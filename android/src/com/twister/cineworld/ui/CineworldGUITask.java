package com.twister.cineworld.ui;

import android.app.Activity;

import com.twister.cineworld.exception.*;
import com.twister.cineworld.log.*;

/**
 * Base class for background tasks which have to be presented on the GUI when they finish.
 * 
 * @author Zoltán Kiss
 * @param <R>
 */
public abstract class CineworldGUITask<R> extends LoggedRunnable {

	private static final CineworldLogger	LOG	= LogFactory.getLog(Tag.SYSTEM);

	protected final Activity				activity;

	public CineworldGUITask(final Activity activity) {
		this.activity = activity;
	}

	@Override
	protected final void loggedRun() {
		try {
			final R result = work();
			this.activity.runOnUiThread(new LoggedRunnable() {
				@Override
				protected void loggedRun() {
					present(result);
				}
			});
		} catch (CineworldException e) {
			handleException(e);
		} catch (RuntimeException e) {
			handleException(new InternalException(e));
		}
	}

	private void handleException(final CineworldException e) {
		CineworldGUITask.LOG.error("Exception while executing task #" + this.taskId, e);
		/*
		 * TODO Talán itt lenne érdemes csinálni egy általános metódust valami error dialog meghívására és akkor
		 * konzisztensen viselkedne az alkalmazás. Ekkor az exception metódusban csak az Activity specifikus dolgokat
		 * kellene elvégezni pl form ürítése vagy akármi...
		 */
		activity.runOnUiThread(new LoggedRunnable() {
			@Override
			protected void loggedRun() {
				exception(e);
			}
		});
	}

	/**
	 * Do the main work. This is typically a long running operation which has some kind of results. This method is
	 * executed on a background thread, no GUI calls are allowed here.
	 * 
	 * @return The results of the work
	 * @throws CineworldException if any error occurs
	 */
	protected abstract R work() throws CineworldException;

	/**
	 * Presents the results of the work. This callback is executed on a GUI thread. This method should not do any
	 * calculations, just plain presentation.
	 * 
	 * @param result the return value of {@link #work()}
	 */
	protected abstract void present(R result);

	/**
	 * Exception handler callback. Whenever an exception occurs, this method is called on a GUI thread.
	 * 
	 * @param exception the exception
	 */
	protected abstract void exception(CineworldException exception);

}
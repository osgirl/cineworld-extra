package com.twister.cineworld.model.accessor.impl;

import java.util.*;

import com.twister.cineworld.exception.CineworldException;
import com.twister.cineworld.model.accessor.CineworldAccessor;
import com.twister.cineworld.model.generic.*;
import com.twister.cineworld.model.json.TimeSpan;
import com.twister.cineworld.model.json.data.*;

public class EmptyCineworldAccessor implements CineworldAccessor {
	public List<Cinema> getAllCinemas() throws CineworldException {
		return Collections.emptyList();
	}

	public CineworldCinema getCinema(final int cinemaId) throws CineworldException {
		return null;
	}

	public List<CineworldCinema> getCinemas(final int filmEdi) throws CineworldException {
		return Collections.emptyList();
	}

	public List<CineworldFilm> getAllFilms() throws CineworldException {
		return Collections.emptyList();
	}

	public CineworldFilm getFilm(final int filmEdi) throws CineworldException {
		return null;
	}

	public List<CineworldFilm> getFilms(final int cinemaId) throws CineworldException {
		return Collections.emptyList();
	}

	public List<CineworldFilm> getFilms(final int cinemaId, final TimeSpan span) throws CineworldException {
		return Collections.emptyList();
	}

	public List<CineworldDate> getAllDates() throws CineworldException {
		return Collections.emptyList();
	}

	public List<CineworldDate> getDates(final int filmEdi) throws CineworldException {
		return Collections.emptyList();
	}

	public List<Category> getAllCategories() throws CineworldException {
		return Collections.emptyList();
	}

	public List<Event> getAllEvents() throws CineworldException {
		return Collections.emptyList();
	}

	public List<Distributor> getAllDistributors() throws CineworldException {
		return Collections.emptyList();
	}

	public List<Performance> getPeformances(final int cinemaId, final int filmEdi, final int date)
			throws CineworldException {
		return Collections.emptyList();
	}
}
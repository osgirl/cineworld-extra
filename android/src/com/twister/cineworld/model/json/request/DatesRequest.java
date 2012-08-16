package com.twister.cineworld.model.json.request;

import java.net.URL;

import com.twister.cineworld.model.json.data.*;
import com.twister.cineworld.model.json.response.DatesResponse;

/**
 * <p>
 * This query returns a list of dates that have programmed performances. The results can be filtered by supplying
 * optional film, date and cinema parameters. These can all take multiple values, so for example it is possible to
 * search for all dates on which a cinema is showing a particular film.
 * </p>
 * <p>
 * Example request:<br>
 * <code>http://www.cineworld.com/api/quickbook/dates?key=key&cinema=23&film=54321</code>
 * </p>
 * 
 * @author papp.robert.s
 */
public class DatesRequest extends BaseListRequest<CineworldDate> {
	private static final String	REQUEST_TYPE	= "quickbook/dates";
	private Integer	            m_cinema;
	private Integer	            m_film;
	private String	            m_category;
	private String	            m_event;
	private Integer	            m_distributor;

	/**
	 * Creates an empty request, use the setters to provide filtering parameters.
	 */
	public DatesRequest() {
	}

	/**
	 * @param cinema (Optional, no default) Cinema ID to retrieve dates for, or for all cinemas if excluded. More than
	 *            one cinema id can be passed in, by assigning multiple values: cinema=1&cinema=2 - this will mean dates
	 *            are retrieved on which there are performances at at least ONE of the cinemas.
	 * @param film (Optional, no default) Film EDI to retrieve dates for, or for all films if excluded. More than one
	 *            edi can be passed in, by assigning multiple values: film=1234&film=2345 - this will mean dates are
	 *            retrieved that match at least ONE edi.
	 * @param category (Optional, no default) Category code- this can be passed in to filter the results to only contain
	 *            dates on which there is at least on performance for a film in this category.
	 * @param event (Optional, no default) Event code- this can be passed in to filter the results to only contain dates
	 *            on which there is at least on performance for a film linked to this event.
	 * @param distributor (Optional, no default) Distributor id- this can be passed in to filter the results to only
	 *            contain dates on which there is at least on performance for a film from this distributor.
	 */
	public DatesRequest(final Integer cinema, final Integer film, final String category, final String event,
	        final Integer distributor) {
		super();
		m_cinema = cinema;
		m_film = film;
		m_category = category;
		m_event = event;
		m_distributor = distributor;
	}

	/**
	 * @param key (Required) Your developer API key.
	 * @param territory (Optional, default GB) Sets which territory to return cinemas for, valid values for United
	 *            Kingdom and Ireland are; GB and IE.
	 * @param callback (Optional, no default)Wraps the response JSON in the callback function specified to allow cross
	 *            browser scripting, note that if you use jQuery and JSONP the callback parameter is automatically added
	 *            for you.
	 * @param cinema (Optional, no default) Cinema ID to retrieve dates for, or for all cinemas if excluded. More than
	 *            one cinema id can be passed in, by assigning multiple values: cinema=1&cinema=2 - this will mean dates
	 *            are retrieved on which there are performances at at least ONE of the cinemas.
	 * @param film (Optional, no default) Film EDI to retrieve dates for, or for all films if excluded. More than one
	 *            edi can be passed in, by assigning multiple values: film=1234&film=2345 - this will mean dates are
	 *            retrieved that match at least ONE edi.
	 * @param category (Optional, no default) Category code- this can be passed in to filter the results to only contain
	 *            dates on which there is at least on performance for a film in this category.
	 * @param event (Optional, no default) Event code- this can be passed in to filter the results to only contain dates
	 *            on which there is at least on performance for a film linked to this event.
	 * @param distributor (Optional, no default) Distributor id- this can be passed in to filter the results to only
	 *            contain dates on which there is at least on performance for a film from this distributor.
	 */
	public DatesRequest(final String key, final String territory, final String callback, final Integer cinema,
	        final Integer film, final String category, final String event, final Integer distributor) {
		super(key, territory, callback);
		m_cinema = cinema;
		m_film = film;
		m_category = category;
		m_event = event;
		m_distributor = distributor;
	}

	/**
	 * <p>
	 * Example request:<br>
	 * <code>http://www.cineworld.com/api/quickbook/dates?key=key&cinema=23&film=54321</code>
	 * </p>
	 * {@inheritDoc}
	 */
	@Override
	public URL getURL() {
		return BaseListRequest.makeUrl(DatesRequest.REQUEST_TYPE,
		        BaseListRequest.KEY_CINEMA, m_cinema,
		        BaseListRequest.KEY_FILM, m_film,
		        BaseListRequest.KEY_CATEGORY, m_category,
		        BaseListRequest.KEY_EVENT, m_event,
		        BaseListRequest.KEY_DISTRIBUTOR, m_distributor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRequestType() {
		return "dates";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see DatesResponse
	 */
	@Override
	public Class<DatesResponse> getResponseClass() {
		return DatesResponse.class;
	}

	/**
	 * @optional N/A
	 * @return Cinema ID to retrieve dates for, or for all cinemas if excluded. More than one cinema id can be passed
	 *         in, by assigning multiple values: cinema=1&cinema=2 - this will mean dates are retrieved on which there
	 *         are performances at at least ONE of the cinemas.
	 * @see CineworldCinema
	 */
	public Integer getCinema() {
		return m_cinema;
	}

	/**
	 * @optional N/A
	 * @param cinema Cinema ID to retrieve dates for, or for all cinemas if excluded. More than one cinema id can be
	 *            passed in, by assigning multiple values: cinema=1&cinema=2 - this will mean dates are retrieved on
	 *            which there are performances at at least ONE of the cinemas.
	 * @see CineworldCinema
	 */
	public void setCinema(final Integer cinema) {
		m_cinema = cinema;
	}

	/**
	 * @optional N/A
	 * @param cinema Cinema ID to retrieve dates for, or for all cinemas if excluded. More than one cinema id can be
	 *            passed in, by assigning multiple values: cinema=1&cinema=2 - this will mean dates are retrieved on
	 *            which there are performances at at least ONE of the cinemas.
	 * @see CineworldCinema
	 */
	public void setCinema(final CineworldCinema cinema) {
		setCinema(cinema == null? null : cinema.getId());
	}

	/**
	 * @optional N/A
	 * @return Film EDI to retrieve dates for, or for all films if excluded. More than one edi can be passed in, by
	 *         assigning multiple values: film=1234&film=2345 - this will mean dates are retrieved that match at least
	 *         ONE edi.
	 * @see CineworldFilm
	 */
	public Integer getFilm() {
		return m_film;
	}

	/**
	 * @optional N/A
	 * @param film Film EDI to retrieve dates for, or for all films if excluded. More than one edi can be passed in, by
	 *            assigning multiple values: film=1234&film=2345 - this will mean dates are retrieved that match at
	 *            least ONE edi.
	 * @see CineworldFilm
	 */
	public void setFilm(final Integer film) {
		m_film = film;
	}

	/**
	 * @optional N/A
	 * @param film Film EDI to retrieve dates for, or for all films if excluded. More than one edi can be passed in, by
	 *            assigning multiple values: film=1234&film=2345 - this will mean dates are retrieved that match at
	 *            least ONE edi.
	 * @see CineworldFilm
	 */
	public void setFilm(final CineworldFilm film) {
		setFilm(film == null? null : film.getId());
	}

	/**
	 * @optional N/A
	 * @return Category code- this can be passed in to filter the results to only contain dates on which there is at
	 *         least on performance for a film in this category.
	 * @see CineworldCategory
	 */
	public String getCategory() {
		return m_category;
	}

	/**
	 * @optional N/A
	 * @param category Category code- this can be passed in to filter the results to only contain dates on which there
	 *            is at least on performance for a film in this category.
	 * @see CineworldCategory
	 */
	public void setCategory(final String category) {
		m_category = category;
	}

	/**
	 * @optional N/A
	 * @param category Category code- this can be passed in to filter the results to only contain dates on which there
	 *            is at least on performance for a film in this category.
	 * @see CineworldCategory
	 */
	public void setCategory(final CineworldCategory category) {
		setCategory(category == null? null : category.getCode());
	}

	/**
	 * @optional N/A
	 * @return Event code- this can be passed in to filter the results to only contain dates on which there is at least
	 *         on performance for a film linked to this event.
	 * @see CineworldEvent
	 */
	public String getEvent() {
		return m_event;
	}

	/**
	 * @optional N/A
	 * @param event Event code- this can be passed in to filter the results to only contain dates on which there is at
	 *            least on performance for a film linked to this event.
	 * @see CineworldEvent
	 */
	public void setEvent(final String event) {
		m_event = event;
	}

	/**
	 * @optional N/A
	 * @param event Event code- this can be passed in to filter the results to only contain dates on which there is at
	 *            least on performance for a film linked to this event.
	 * @see CineworldEvent
	 */
	public void setEvent(final CineworldEvent event) {
		setEvent(event == null? null : event.getCode());
	}

	/**
	 * @optional N/A
	 * @return Distributor id- this can be passed in to filter the results to only contain dates on which there is at
	 *         least on performance for a film from this distributor.
	 * @see CineworldDistributor
	 */
	public Integer getDistributor() {
		return m_distributor;
	}

	/**
	 * @optional N/A
	 * @param distributor Distributor id- this can be passed in to filter the results to only contain dates on which
	 *            there is at least on performance for a film from this distributor.
	 * @see CineworldDistributor
	 */
	public void setDistributor(final Integer distributor) {
		m_distributor = distributor;
	}

	/**
	 * @optional N/A
	 * @param distributor Distributor id- this can be passed in to filter the results to only contain dates on which
	 *            there is at least on performance for a film from this distributor.
	 * @see CineworldDistributor
	 */
	public void setDistributor(final CineworldDistributor distributor) {
		setDistributor(distributor == null? null : distributor.getId());
	}
}

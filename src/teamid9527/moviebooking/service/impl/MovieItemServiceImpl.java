package teamid9527.moviebooking.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamid9527.moviebooking.dao.CinemaDao;
import teamid9527.moviebooking.dao.MovieDao;
import teamid9527.moviebooking.dao.MovieItemDao;
import teamid9527.moviebooking.entities.Cinema;
import teamid9527.moviebooking.entities.Movie;
import teamid9527.moviebooking.entities.MovieItem;
import teamid9527.moviebooking.service.MovieItemService;

@Service
public class MovieItemServiceImpl implements MovieItemService {

	@Autowired
	private MovieItemDao movieItemDao;
	
	@Autowired
	private CinemaDao cinemaDao;
	
	@Autowired
	private MovieDao movieDao;
	
	public Map<Cinema, List<MovieItem>> queryAllMovieItemByCinema() {
		Map<Cinema, List<MovieItem>> map = new HashMap<Cinema, List<MovieItem>>();
		List<Cinema> cinemas = cinemaDao.findAllCinemas();
		for (Cinema cinema : cinemas) {
			List<MovieItem> movieItems = movieItemDao.findMovieItemsByCinema(cinema);
			map.put(cinema, movieItems);
		}
		return map;
	}

	public Map<Movie, List<MovieItem>> queryAllMovieItemByMovie() {
		Map<Movie, List<MovieItem>> map = new HashMap<Movie, List<MovieItem>>();
		List<Movie> movies = movieDao.findAllMovies();
		for (Movie movie : movies) {
			List<MovieItem> movieItems = movieItemDao.findMovieItemsByMovie(movie);
			map.put(movie, movieItems);
		}
		return map;
	}

	public List<MovieItem> queryMovieItemByCinema(Integer cinema_id) {
		Cinema cinema = new Cinema();
		cinema.setId(cinema_id);
		List<MovieItem> movieItems = movieItemDao.findMovieItemsByCinema(cinema);
		return movieItems;
	}

	public List<MovieItem> queryMovieItemByMovie(Integer movie_id) {
		Movie movie = new Movie();
		movie.setId(movie_id);
		List<MovieItem> movieItems = movieItemDao.findMovieItemsByMovie(movie);
		return movieItems;
	}

}

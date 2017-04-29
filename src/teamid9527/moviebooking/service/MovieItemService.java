package teamid9527.moviebooking.service;

import java.util.List;
import java.util.Map;

import teamid9527.moviebooking.entities.Cinema;
import teamid9527.moviebooking.entities.Movie;
import teamid9527.moviebooking.entities.MovieItem;

public interface MovieItemService {

	public Map<Cinema, List<MovieItem>> queryAllMovieItemByCinema();
	
	public Map<Movie, List<MovieItem>> queryAllMovieItemByMovie();
	
}

package teamid9527.moviebooking.dao;

import java.util.List;

import teamid9527.moviebooking.entities.Cinema;
import teamid9527.moviebooking.entities.Movie;
import teamid9527.moviebooking.entities.MovieItem;

public interface MovieItemDao {

	public MovieItem findMovieItemById(Integer id);
	
	public List<MovieItem> findMovieItemsByMovieId(Integer movie_id);
	
	public List<MovieItem> findMovieItemsByMovie(Movie movie);
	
	public List<MovieItem> findMovieItemsByCinemaId(Integer cinema_id);
	
	public List<MovieItem> findMovieItemsByCinema(Cinema cinema);
}

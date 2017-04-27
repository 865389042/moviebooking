package teamid9527.moviebooking.dao;

import java.util.List;

import teamid9527.moviebooking.entities.Cinema;
import teamid9527.moviebooking.entities.Movie;
import teamid9527.moviebooking.entities.MovieItem;
import teamid9527.moviebooking.entities.Reservation;

public interface MovieItemDao {

	public MovieItem findMovieItemById(Integer id);
	
	public List<MovieItem> findMovieItemsByMovieId(Integer movie_id);
	
	public List<MovieItem> findMovieItemsByMovie(Movie movie);
	
	public List<MovieItem> findMovieItemsByCinemaId(Integer cinema_id);
	
	public List<MovieItem> findMovieItemsByCinema(Cinema cinema);
	
	/**
	 * 添加一个MovieItem
	 * @param movieItem MovieItem.reservations不用赋值，在many-to-many的关系中，MovieItem是被Reservation管理的
	 * 应当由Reservation将MovieItem加入Reservation.movieItems中，然后会由Reservation自动维护他们之间的关系
	 */
	public void createMovieItem(MovieItem movieItem);

	public void updateMovieItem(MovieItem movieItem);

	public void deleteMovieItemById(Integer id);

}
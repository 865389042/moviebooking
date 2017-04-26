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
	 * ���һ��MovieItem
	 * @param movieItem MovieItem.reservations���ø�ֵ����many-to-many�Ĺ�ϵ�У�MovieItem�Ǳ�Reservation�����
	 * Ӧ����Reservation��MovieItem����Reservation.movieItems�У�Ȼ�����Reservation�Զ�ά������֮��Ĺ�ϵ
	 */
	public void createMovieItem(MovieItem movieItem);
	
	public void updateMovieItem(MovieItem movieItem);
	
	public void deleteMovieItemById(Integer id);
	
}

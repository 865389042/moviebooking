package teamid9527.moviebooking.dao;

import java.util.List;

import teamid9527.moviebooking.entities.Movie;

public interface MovieDao {

	
	public List<Movie> findAllMovies();
	
	public Movie findMovieById(Integer id);
	
	/**
	 * 数据库出现冗余,movie中一个条目包含了cinema的信息，会出现多个影院上映同一部电影的情况
	 * 可以修改数据库为many-to-many
	 */
	
	public List<Movie> findMovieByName(String name);
}

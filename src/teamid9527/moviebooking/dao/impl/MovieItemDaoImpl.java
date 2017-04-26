package teamid9527.moviebooking.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamid9527.moviebooking.dao.MovieItemDao;
import teamid9527.moviebooking.entities.Cinema;
import teamid9527.moviebooking.entities.Movie;
import teamid9527.moviebooking.entities.MovieItem;

@Repository
public class MovieItemDaoImpl implements MovieItemDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//获取和当前线程绑定的session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public MovieItem findMovieItemById(Integer id) {
		Criteria criteria = getSession().createCriteria(MovieItem.class);
		criteria.add(Restrictions.eq("id", id));
		return (MovieItem)criteria.uniqueResult();
	}

	public List<MovieItem> findMovieItemsByMovieId(Integer movie_id) {
		Criteria criteria = getSession().createCriteria(MovieItem.class);
		criteria.add(Restrictions.eq("movie.id", movie_id));
		return criteria.list();
	}

	public List<MovieItem> findMovieItemsByMovie(Movie movie) {
		return findMovieItemsByMovieId(movie.getId());
	}

	public List<MovieItem> findMovieItemsByCinemaId(Integer cinema_id) {
		Criteria criteria = getSession().createCriteria(MovieItem.class);
		criteria.add(Restrictions.eq("cinema.id", cinema_id));
		return criteria.list();
	}

	public List<MovieItem> findMovieItemsByCinema(Cinema cinema) {
		return findMovieItemsByCinemaId(cinema.getId());
	}

}

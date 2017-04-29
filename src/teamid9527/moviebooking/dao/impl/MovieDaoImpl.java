package teamid9527.moviebooking.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamid9527.moviebooking.dao.MovieDao;
import teamid9527.moviebooking.entities.Cinema;
import teamid9527.moviebooking.entities.Movie;

@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Movie> findAllMovies() {
		Query query = getSession().createQuery("from Movie");
		List<Movie> movies = query.list();
		return movies;
	}
	
	public Movie findMovieById(Integer id) {
		Criteria criteria = getSession().createCriteria(Movie.class);
		criteria.add(Restrictions.eq("id", id));
		return (Movie)criteria.uniqueResult();
	}

	public List<Movie> findMovieByName(String name) {
		Criteria criteria = getSession().createCriteria(Movie.class);
		criteria.add(Restrictions.eq("name", name));
		return criteria.list();
	}

	

}

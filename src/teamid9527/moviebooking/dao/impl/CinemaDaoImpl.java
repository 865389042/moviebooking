package teamid9527.moviebooking.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamid9527.moviebooking.dao.CinemaDao;
import teamid9527.moviebooking.entities.Cinema;
import teamid9527.moviebooking.entities.Town;

@Repository
public class CinemaDaoImpl implements CinemaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//获取和当前线程绑定的session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Cinema findCinemaById(Integer id) {
		Criteria criteria = getSession().createCriteria(Cinema.class);
		criteria.add(Restrictions.eq("id", id));
		return (Cinema) criteria.uniqueResult();
	}

	public Cinema findCinemaByName(String name) {
		Criteria criteria = getSession().createCriteria(Cinema.class);
		criteria.add(Restrictions.eq("name", name));
		return (Cinema) criteria.uniqueResult();
	}

	public List<Cinema> findCinemasByTownId(Integer town_id) {
		Criteria criteria = getSession().createCriteria(Cinema.class);
		criteria.add(Restrictions.eq("town.id", town_id));
		return criteria.list();
	}

	public List<Cinema> findCinemasByTown(Town town) {
		return findCinemasByTownId(town.getId());
	}

}

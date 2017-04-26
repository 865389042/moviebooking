package teamid9527.moviebooking.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamid9527.moviebooking.dao.TownDao;
import teamid9527.moviebooking.entities.City;
import teamid9527.moviebooking.entities.Town;

@Repository
public class TownDaoImpl implements TownDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//获取和当前线程绑定的session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Town findTownByName(String name) {
		Criteria criteria = getSession().createCriteria(Town.class);
		criteria.add(Restrictions.eq("name", name));
		return (Town) criteria.uniqueResult();
	}

	public Town findTownById(Integer id) {
		Criteria criteria = getSession().createCriteria(Town.class);
		criteria.add(Restrictions.eq("id", id));
		return (Town) criteria.uniqueResult();
	}

	public List<Town> findTownsByCityId(Integer city_id) {
		Criteria criteria = getSession().createCriteria(Town.class);
		criteria.add(Restrictions.eq("city.id", city_id));
		return criteria.list();
	}

	public List<Town> findTownsByCity(City city) {
		return findTownsByCityId(city.getId());
	}

}

package teamid9527.moviebooking.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamid9527.moviebooking.dao.CityDao;
import teamid9527.moviebooking.entities.City;
import teamid9527.moviebooking.entities.Province;

@Repository
public class CityDaoImpl implements CityDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//获取和当前线程绑定的session
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public City findCityByName(String name) {
		Criteria criteria = getSession().createCriteria(City.class);
		criteria.add(Restrictions.eq("name", name));
		return (City) criteria.uniqueResult();
	}

	public City findCityById(Integer id) {
		Criteria criteria = getSession().createCriteria(City.class);
		criteria.add(Restrictions.eq("id", id));
		return (City) criteria.uniqueResult();
	}

	public List<City> findCitysByProvinceId(Integer province_id) {
		Criteria criteria = getSession().createCriteria(City.class);
		criteria.add(Restrictions.eq("province.id", province_id));
		return criteria.list();
	}

	public List<City> findCitysByProvince(Province province) {
		return findCitysByProvinceId(province.getId());
	}
}

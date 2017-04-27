package teamid9527.moviebooking.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teamid9527.moviebooking.dao.ProvinceDao;
import teamid9527.moviebooking.entities.Province;

@Repository
public class ProvinceDaoImpl implements ProvinceDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Integer findProvinceIdByName(String name) {
		
		String hql = "SELECT p.id FROM Province p WHERE p.name = ?";
		Query query = getSession().createQuery(hql).setString(0, name);
		return (Integer)query.uniqueResult();
		
	}

	public Province findProvinceById(Integer id) {
		Criteria criteria = getSession().createCriteria(Province.class);
		criteria.add(Restrictions.eq("id", id));
		return (Province) criteria.uniqueResult();
	}

	public Province findProvinceByName(String name) {
		Criteria criteria = getSession().createCriteria(Province.class);
		criteria.add(Restrictions.eq("name", name));
		return (Province) criteria.uniqueResult();
	}
	
}

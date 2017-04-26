package teamid9527.moviebooking.dao;

import java.util.List;

import teamid9527.moviebooking.entities.City;
import teamid9527.moviebooking.entities.Province;

public interface CityDao {

	public City findCityByName(String name);
	
	public City findCityById(Integer id);
	
	public List<City> findCitysByProvinceId(Integer province_id);
	
	public List<City> findCitysByProvince(Province province);
}

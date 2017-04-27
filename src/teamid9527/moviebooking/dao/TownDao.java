package teamid9527.moviebooking.dao;

import java.util.List;
import teamid9527.moviebooking.entities.City;
import teamid9527.moviebooking.entities.Town;

public interface TownDao {

	public Town findTownByName(String name);
	
	public Town findTownById(Integer id);

	public List<Town> findTownsByCityId(Integer city_id);
	
	public List<Town> findTownsByCity(City city);
	
}

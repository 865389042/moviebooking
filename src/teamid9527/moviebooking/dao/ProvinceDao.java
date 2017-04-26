package teamid9527.moviebooking.dao;

import teamid9527.moviebooking.entities.Province;

public interface ProvinceDao {
	
	public Integer findProvinceIdByName(String name);
	
	public Province findProvinceById(Integer id);
	
	public Province findProvinceByName(String name);
	
}

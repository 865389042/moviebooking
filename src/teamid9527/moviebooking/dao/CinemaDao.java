package teamid9527.moviebooking.dao;

import java.util.List;

import teamid9527.moviebooking.entities.Cinema;
import teamid9527.moviebooking.entities.Town;

public interface CinemaDao {
	
	public Cinema findCinemaById(Integer id);
	
	public Cinema findCinemaByName(String name);
	
	public List<Cinema> findCinemasByTownId(Integer town_id);
	
	public List<Cinema> findCinemasByTown(Town town);
	
}

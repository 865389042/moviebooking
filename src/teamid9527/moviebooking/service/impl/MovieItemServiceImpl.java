package teamid9527.moviebooking.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamid9527.moviebooking.dao.CinemaDao;
import teamid9527.moviebooking.dao.MovieItemDao;
import teamid9527.moviebooking.entities.Cinema;
import teamid9527.moviebooking.entities.Movie;
import teamid9527.moviebooking.entities.MovieItem;
import teamid9527.moviebooking.service.MovieItemService;

@Service
public class MovieItemServiceImpl implements MovieItemService {

	@Autowired
	private MovieItemDao movieItemDao;
	
	@Autowired
	private CinemaDao cinemaDao;
	
	public Map<Cinema, List<MovieItem>> queryAllMovieItemByCinema() {
		Map<Cinema, List<MovieItem>> map = new HashMap<Cinema, List<MovieItem>>();
		
		return null;
	}

	public Map<Movie, List<MovieItem>> queryAllMovieItemByMovie() {
		// TODO Auto-generated method stub
		return null;
	}

}

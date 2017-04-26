package teamid9527.moviebooking.dao;

import java.util.List;

import teamid9527.moviebooking.entities.Movie;

public interface MovieDao {

	public Movie findMovieById(Integer id);
	
	/**
	 * ���ݿ��������,movie��һ����Ŀ������cinema����Ϣ������ֶ��ӰԺ��ӳͬһ����Ӱ�����
	 * �����޸����ݿ�Ϊmany-to-many
	 */
	
	public List<Movie> findMovieByName(String name);
}

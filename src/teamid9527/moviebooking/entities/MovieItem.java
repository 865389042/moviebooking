package teamid9527.moviebooking.entities;

import java.util.List;
import java.util.Set;

/**
 * ��Ӱ����
 * @author 86538
 *
 */
public class MovieItem {

	private Integer id;
	
	private Movie movie;
	
	private Cinema cinema;
	
	private double price;
	
	private Integer seat;
	
	private String duration;

	private Set<Reservation> reservations;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "MovieItem [id=" + id + ", movie=" + movie + ", cinema="
				+ cinema + ", price=" + price + ", seat=" + seat
				+ ", duration=" + duration + "]";
	}
	
}

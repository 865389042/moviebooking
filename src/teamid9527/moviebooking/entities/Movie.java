package teamid9527.moviebooking.entities;

public class Movie {

	private Integer id;
	
	private String name;
	
	private String type;
	
	private double stars;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", type=" + type
				+ ", stars=" + stars + "]";
	}

	
	
	
}

package teamid9527.moviebooking.entities;

public class Cinema {

	private Integer id;
	
	private String name;
	
	private String address;
	
	private double stars;
	
	private String info;
	
	private double max_discount;

	private Town town;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getMax_discount() {
		return max_discount;
	}

	public void setMax_discount(double max_discount) {
		this.max_discount = max_discount;
	}

	public Town getTown() {
		return town;
	}

	public void setTown(Town town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", address=" + address
				+ ", stars=" + stars + ", info=" + info + ", max_discount="
				+ max_discount + ", town=" + town + "]";
	}

	
	
	
}

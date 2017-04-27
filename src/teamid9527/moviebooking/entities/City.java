package teamid9527.moviebooking.entities;

public class City {

	private Integer id;
	
	private String name;
	
	private Province province;

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

	public Province getProvince() {
		return province;
	}
	
	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", province=" + province
				+ "]";
	}

	
	
}

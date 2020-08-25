package model;

public class Product {
	private int id;
	private String name;
	private int price;
	private String img;
	private String country;
	private String category;
	private String brand;
	private String dry;
	
	
	
	public Product(int id, String name, int price, String img, String country, String category, String brand,
			String dry) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
		this.country = country;
		this.category = category;
		this.brand = brand;
		this.dry = dry;
	}
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", img=" + img + ", country=" + country
				+ ", category=" + category + ", brand=" + brand + ", dry=" + dry + "]";
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDry() {
		return dry;
	}
	public void setDry(String dry) {
		this.dry = dry;
	}
	
	
	
}

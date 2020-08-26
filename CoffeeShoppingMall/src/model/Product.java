package model;

import org.json.simple.JSONAware;

public class Product implements JSONAware {
	private int pro_id;
	private String pro_name;
	private int pro_price;
	private String pro_img;
	private String pro_region;
	private String pro_country;
	private String pro_description;

	public Product() {
	}

	public Product(int pro_id, String pro_name, int pro_price, String pro_img, String pro_region, String pro_country,
			String pro_description) {
		this.pro_id = pro_id;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_img = pro_img;
		this.pro_region = pro_region;
		this.pro_country = pro_country;
		this.pro_description = pro_description;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public int getPro_price() {
		return pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	public String getPro_img() {
		return pro_img;
	}

	public void setPro_img(String pro_img) {
		this.pro_img = pro_img;
	}

	public String getPro_region() {
		return pro_region;
	}

	public void setPro_region(String pro_region) {
		this.pro_region = pro_region;
	}

	public String getPro_country() {
		return pro_country;
	}

	public void setPro_country(String pro_country) {
		this.pro_country = pro_country;
	}

	public String getPro_description() {
		return pro_description;
	}

	public void setPro_description(String pro_description) {
		this.pro_description = pro_description;
	}

	@Override
	public String toString() {
		return "Product [pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_price=" + pro_price + ", pro_img="
				+ pro_img + ", pro_region=" + pro_region + ", pro_country=" + pro_country + ", pro_description="
				+ pro_description + "]";
	}

	@Override
	public String toJSONString() {
		return "{\"pro_id\" : \"" + pro_id + "\", \"pro_name\" : \"" + pro_name + "\", \"pro_price\" : \"" + pro_img
				+ "\", \"pro_region\" : \"" + pro_region + "\", \"pro_country\" : \"" + pro_country
				+ "\", \"pro_description\" : \"" + pro_description + "\"}";
	}

}

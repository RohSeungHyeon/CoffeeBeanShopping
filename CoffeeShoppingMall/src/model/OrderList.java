package model;

import java.sql.Date;

import org.json.simple.JSONAware;

public class OrderList implements JSONAware {
	private int order_id;
	private String order_address;
	private Date order_date;
	private int order_count;
	private String id;
	private int pro_id;

	public OrderList(String order_address, Date order_date, int order_count, String id, int pro_id) {
		super();
		this.order_address = order_address;
		this.order_date = order_date;
		this.order_count = order_count;
		this.id = id;
		this.pro_id = pro_id;
	}

	public OrderList(int order_id, String order_address, Date order_date, int order_count, String id, int pro_id) {
		super();
		this.order_id = order_id;
		this.order_address = order_address;
		this.order_date = order_date;
		this.order_count = order_count;
		this.id = id;
		this.pro_id = pro_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderList [order_id=" + order_id + ", order_address=" + order_address + ", order_date=" + order_date
				+ ", order_count=" + order_count + ", pro_id=" + pro_id + "]";
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_address() {
		return order_address;
	}

	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getOrder_count() {
		return order_count;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	@Override
	public String toJSONString() {
		return "{\"order_id\" : \"" + order_id + "\", \"order_address\" : \"" + order_address
				+ "\", \"order_date\" : \"" + order_date + "\", \"order_count\" : \"" + order_count + "\", \"id\" : \""
				+ id + "\", \"pro_id\" : \"" + pro_id + "\"}";
	}

}

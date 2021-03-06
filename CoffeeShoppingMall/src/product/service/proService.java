package product.service;

import java.sql.Date;
import java.util.ArrayList;

import model.Product;

public interface proService {
	Product getProduct (int id);
	boolean addCart(String m_id, int pro_id);
	ArrayList<Product> getCart(String id);
	int delCart(String m_id,int pro_id);
	void addOrder(String addr, Date date, int cnt, String m_id, int pro_id);
	void addOrderStatus(Date d, String id);
	void clearCart(String m_id);
	
	
	void addProduct(String name, int price, String img, String region, String country, String description);
	void delProduct(int id);
	ArrayList<Product> getAllProduct();
	ArrayList<Product> getProduct(String region);
	ArrayList<Product> getProductByCountry(String country);
	ArrayList<Product> getRecoProduct();
}

package product.dao;

import java.sql.Date;
import java.util.ArrayList;

import model.Product;

public interface proDao {
	Product select(int id);
	boolean addCart(String m_id,int pro_id);
	ArrayList<Product> getCart(String id);
	int delCart(String m_id,int pro_id);
	void addOrder( String addr, Date date, int cnt, String m_id, int pro_id);
	void addOrder_Status(Date d, String id);
	void clearCart(String m_id);
	
	ArrayList<Product> selectAll();
	ArrayList<Product> selectPro(String str);
	ArrayList<Product> getRecoProduct();
	
	void addProduct(String name, int price, String img, String region, String country, String description);
	void delProduct(int id);
	ArrayList<Product> selectPro_Country(String country);
	
}

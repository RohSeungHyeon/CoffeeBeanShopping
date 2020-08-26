package product.dao;

import java.util.ArrayList;

import model.Product;

public interface proDao {
	Product select(int id);
	ArrayList<Product> selectAll();
	boolean addCart(String m_id,int pro_id);
	ArrayList<Product> getCart(String id);
	int delCart(String m_id,int pro_id);
}

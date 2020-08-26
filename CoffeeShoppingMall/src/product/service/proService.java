package product.service;

import java.util.ArrayList;

import model.Product;

public interface proService {
	Product getProduct (int id);
	ArrayList<Product> getAllProduct();
	boolean addCart(String m_id, int pro_id);
	ArrayList<Product> getCart(String id);
	int delCart(String m_id,int pro_id);
}

package product.service;

import java.util.ArrayList;

import conn.DBConnect;
import model.Product;
import product.dao.proDao;
import product.dao.proDaoImpl;

public class proServiceImpl implements proService {
	private proDao dao;

	public proServiceImpl() {
		dao = new proDaoImpl();
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}

	@Override
	public ArrayList<Product> getAllProduct() {
		return dao.selectAll();
	}

	@Override
	public boolean addCart(String m_id, int pro_id) {
		return dao.addCart(m_id, pro_id);
	}

	@Override
	public ArrayList<Product> getCart(String id) {
		return dao.getCart(id);
	}

	@Override
	public int delCart(String m_id, int pro_id) {
		return dao.delCart(m_id, pro_id);
	}

}
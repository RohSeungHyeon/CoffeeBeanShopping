package product.service;

import java.sql.Date;
import java.util.ArrayList;

import conn.DBConnect;
import model.Product;
import product.dao.proDao;
import product.dao.proDaoImpl;

public class proServiceImpl implements proService{
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
	@Override
	public void addOrder(String addr, Date date, int cnt, String m_id, int pro_id) {
		dao.addOrder( addr, date, cnt, m_id, pro_id);
	}
	@Override
	public void clearCart(String m_id) {
		dao.clearCart(m_id);
	}
	@Override
	public void addProduct(String name, int price, String img, String region, String country, String description) {
		dao.addProduct(name, price, img, region, country, description);
	}
	@Override
	public void delProduct(int id) {
		dao.delProduct(id);
	}
	@Override
	public ArrayList<Product> getAllProduct() {
		return dao.selectAll();
	}
	@Override
	public ArrayList<Product> getProduct(String region) {
		return dao.selectPro(region);
	}
	@Override
	public ArrayList<Product> getRecoProduct() {
		return dao.getRecoProduct();
	}


}

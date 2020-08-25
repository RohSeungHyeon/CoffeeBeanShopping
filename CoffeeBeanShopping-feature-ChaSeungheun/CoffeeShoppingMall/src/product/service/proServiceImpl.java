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


}

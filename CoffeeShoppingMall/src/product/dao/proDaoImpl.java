package product.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conn.DBConnect;
import model.Product;

public class proDaoImpl implements proDao {
	private DBConnect db;

	public proDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public Product select(int id) {
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from product where pro_id = ?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("!!!!");
				return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
			}
		} catch (Exception e) {

		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return null;
	}

	@Override
	public boolean addCart(String m_id, int pro_id) {
		Connection conn = null;
		String sql = "insert into cart values(SEQ_CAR.nextval, ?, ?)";
		PreparedStatement pstmt = null;
		boolean ok = false;
		if (!cart_check(m_id, pro_id)) {
			System.out.println("중복존재");
			return false;
		}
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setInt(2, pro_id);
			pstmt.executeUpdate();
			ok = true;
		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return ok;
	}

	// 장바구니 중복체크
	public boolean cart_check(String m_id, int pro_id) {
		Connection conn = null;
		String sql = "select * from cart where id = ? and pro_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setInt(2, pro_id);
			rs = pstmt.executeQuery();
			if (!rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return false;
	}

	@Override
	public ArrayList<Product> getCart(String id) {
		Connection conn = null;
		String sql = "select * from cart where id = ? order by pro_id";
		String sql1 = "select * from product where pro_id = ?";
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ArrayList<Product> p = new ArrayList<Product>();
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setInt(1, rs.getInt(3));
				rs1 = pstmt1.executeQuery();
				while (rs1.next()) {
					p.add(new Product(rs1.getInt(1), rs1.getString(2), rs1.getInt(3), rs1.getString(4), rs1.getString(5),
							rs1.getString(6), rs1.getString(7)));
				}
			}
		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return p;
	}

	@Override
	public int delCart(String m_id, int pro_id) {
		Connection conn = null;
		String sql = "delete cart where id = ? and pro_id = ?";
		PreparedStatement pstmt = null;
		System.out.println("delcart = "+m_id+pro_id);
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.setInt(2, pro_id);
			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return 1;
	}

	@Override
	public void addOrder( String addr, Date date, int cnt, String m_id, int pro_id) {
		Connection conn = null;
		String sql = "insert into orderlist values(SEQ_ORD.nextval,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setDate(2, date);
			pstmt.setInt(3, cnt);
			pstmt.setString(4, m_id);
			pstmt.setInt(5, pro_id);
			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		
	}

	@Override
	public void clearCart(String m_id) {
		Connection conn = null;
		String sql = "delete cart where id = ?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
	}

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> list = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from product order by pro_id";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
			}
		} catch (Exception e) {

		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return list;
	}

	@Override
	public void addProduct(String name, int price, String img, String region, String country, String description) {
		Connection conn = null;
		String sql = "insert into product values(SEQ_PRO.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setString(3, img);
			pstmt.setString(4, region);
			pstmt.setString(5, country);
			pstmt.setString(6, description);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
	}

	@Override
	public void delProduct(int id) {
		Connection conn = null;
		String sql = "delete product where pro_id = ?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}

	}

	@Override
	public ArrayList<Product> selectPro(String str) {
		ArrayList<Product> list = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from product where pro_region = ? order by pro_id";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
			}
		} catch (Exception e) {

		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return list;
	}

	@Override
	public ArrayList<Product> getRecoProduct() {
		ArrayList<Product> list = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from product a, (select pro_id,count(*) as ord from orderlist group by pro_id ) b where a.pro_id = b.pro_id order by b.ord desc";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
			}
		} catch (Exception e) {

		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		return list;
	}

	@Override
	public void addOrder_Status(Date d, String id) {
		Connection conn = null;
		String sql = "insert into order_status values(?,?,'결제완료')";
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, d);
			pstmt.setString(2, id);
			pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

			}
		}
		
	}
}

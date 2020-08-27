package orderlist.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import conn.DBConnect;
import model.OrderList;

public class OrderDaoImpl implements OrderDao {
	private DBConnect db;

	public OrderDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public ArrayList<OrderList> selectAll() {
		ArrayList<OrderList> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from orderlist NATURAL JOIN (select distinct id, order_date from orderlist) order by order_date desc";
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new OrderList(rs.getInt("order_id"), rs.getString("order_address"), rs.getDate("order_date"),
						rs.getInt("order_count"), rs.getString("id"), rs.getInt("pro_id")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public Map<String, String> selectOrderStatus() {
		Map<String, String> map = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from order_status";
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			map = new HashMap<>();
			while (rs.next()) {
				map.put(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getDate("order_date"))
						+ rs.getString("id"), rs.getString("status"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return map;
	}

	@Override
	public void updateOrderStatus(int order_id, String status) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt_2 = null;
		ResultSet rs = null;

		try {
			String sql = "select * from orderlist where order_id=?";
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery();

			OrderList order = null;
			if (rs.next()) {
				order = new OrderList(rs.getInt("order_id"), rs.getString("order_address"), rs.getDate("order_date"),
						rs.getInt("order_count"), rs.getString("id"), rs.getInt("pro_id"));
			}

			if (order != null) {
				sql = "update order_status set status=? where id=? and order_date=?";
				pstmt_2 = conn.prepareStatement(sql);
				pstmt_2.setString(1, status);
				pstmt_2.setString(2, order.getId());
				pstmt_2.setDate(3, order.getOrder_date());

				pstmt_2.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				pstmt_2.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

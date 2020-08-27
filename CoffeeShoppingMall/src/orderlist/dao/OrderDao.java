package orderlist.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import model.OrderList;

public interface OrderDao {

	ArrayList<OrderList> selectAll();

	Map<String, String> selectOrderStatus();

	void updateOrderStatus(int order_id, String status);
}

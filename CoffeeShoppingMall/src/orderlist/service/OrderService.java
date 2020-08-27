package orderlist.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;

import model.OrderList;

public interface OrderService {

	Map<String, ArrayList<OrderList>> getOrderMap();

	Map<String, String> getOrderStatus();

	void editOrderStatus(int order_id, String status);

}

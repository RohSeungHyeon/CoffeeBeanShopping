package orderlist.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import model.OrderList;
import orderlist.dao.OrderDao;
import orderlist.dao.OrderDaoImpl;

public class OrderServiceImpl implements OrderService {
	private OrderDao dao;

	public OrderServiceImpl() {
		this.dao = new OrderDaoImpl();
	}

	@Override
	public Map<String, ArrayList<OrderList>> getOrderMap() {
		ArrayList<OrderList> orderList = dao.selectAll();
		Map<String, ArrayList<OrderList>> map = null;

		if (orderList != null) {
			map = new TreeMap<>(Collections.reverseOrder());
			for (OrderList order : orderList) {
				String tempKey = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrder_date())
						+ order.getId();
				if (map.get(tempKey) == null) {
					map.put(tempKey, new ArrayList<OrderList>());
				}
				map.get(tempKey).add(order);
			}
		}

		return map;
	}

	@Override
	public Map<String, String> getOrderStatus() {
		return dao.selectOrderStatus();
	}

	@Override
	public void editOrderStatus(int order_id, String status) {
		dao.updateOrderStatus(order_id, status);
	}

	@Override
	public Map<String, ArrayList<OrderList>> getOrder(String id) {
		ArrayList<OrderList> orderList = dao.selectOrderById(id);
		Map<String, ArrayList<OrderList>> map = null;

		if (orderList != null) {
			map = new TreeMap<>(Collections.reverseOrder());
			for (OrderList order : orderList) {
				String tempKey = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrder_date())
						+ order.getId();
				if (map.get(tempKey) == null) {
					map.put(tempKey, new ArrayList<OrderList>());
				}
				map.get(tempKey).add(order);
			}
		}

		return map;
	}

	@Override
	public Map<String, String> getOrderStatusById(String id) {
		return dao.selectOrderStatusById(id);
	}
	
	
}

package org.git.spring.mongo.service;

import java.util.List;
import org.git.spring.mongo.MongoConfig;
import org.git.spring.mongo.Order;
import org.git.spring.mongo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes=MongoConfig.class)
@Component
public class MongoService {
	@Autowired	
	private OrderRepository orderRepository;
	
	public List<Order> getOrderByCustomers(String cName){
		List<Order> custOrders=orderRepository.findByCustomer("Elon Musk"); 
		return custOrders;
	}
}

package org.git.spring.mongo.test;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.git.spring.mongo.Item;
import org.git.spring.mongo.MongoConfig;
import org.git.spring.mongo.Order;
import org.git.spring.mongo.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes=MongoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoDBTest {

	@Autowired	
	private OrderRepository orderRepository;
	
	@Autowired
	MongoOperations mongoOperations;
	
	/*public static void main(String str[]){
		Order order=createAnOrder();
		Order saveOrder=orderRepository.save(order);
		System.out.println("!! Save Executed !!");
	}*/
	@Test
	public void testMongoRepository(){
		assertEquals(0, orderRepository.count());
		Order order=createAnOrder();
		//Save Order
		Order saveOrder=orderRepository.save(order);
		System.out.println("!! Save Executed !!");
		assertEquals(1, orderRepository.count());
		System.out.println("!! orderRepository.count() !!"+orderRepository.count());


	}
	
	private Order createAnOrder(){
		Order order=new Order();
		order.setCustomer("Elon Musk");
		order.setType("WEB");
		Item item1=new Item();
		item1.setProduct("Tesla Model S");
		item1.setQuantity(2);
		item1.setPrice(70000);
		Item item2=new Item();
		item1.setProduct("Tesla Model 3");
		item1.setQuantity(3);
		item1.setPrice(35000);
		order.setItems(Arrays.asList(item1,item2));
		return order;
	}
		
}

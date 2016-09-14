package org.git.spring.mongo.rest;

import java.util.List;
import org.git.spring.mongo.Order;
import org.git.spring.mongo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestControllerMongo {

	@Autowired
	MongoService mongoService;
	
	@RequestMapping(method=RequestMethod.GET,produces="application/json")
	public @ResponseBody List<Order> getCustomers(){
		return mongoService.getOrderByCustomers("Elon Musk");
	}
}

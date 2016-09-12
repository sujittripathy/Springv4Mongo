package org.git.spring.mongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="org.git.spring.mongo")
public class MongoConfig extends AbstractMongoConfiguration{

	/*@Bean
	public MongoFactoryBean mongo(){
		MongoFactoryBean mongoFactoryBean=new MongoFactoryBean();
		mongoFactoryBean.setHost("127.0.0.1");
		return mongoFactoryBean;
	}
	@Bean
	public MongoTemplate mongoTemplate(Mongo mongo){
		return new MongoTemplate(mongo,"test");
	}*/
	@Override
	protected String getDatabaseName() {
		return "test";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient();
	}
}

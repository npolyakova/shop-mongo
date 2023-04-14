package com.online.shop;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

@SpringBootTest
class ShopApplicationTests extends MongoDbConnection{

	private static MongoCollection<Document> data;

	@BeforeEach
	public void getCollection() {
		data = setCollection("listingsAndReviews");
	}

	@Test
	void generateDocument() {
		//data.find(eq("name", "123"));
		Document doc = new Document();
		doc.append("name", "First Second Name");
		doc.append("summary", "Short description");
		data.insertOne(doc);
	}

	@Test
	void generateDeletedDocument() {
		Document doc = new Document();
		doc.append("name", "First Second Name");
		doc.append("summary", "Short description");
		data.insertOne(doc);

		data.deleteOne(doc);

		var res = data.find(and(eq("name", "First Second Name"), eq("summary", "Short description")));
		System.out.println("\n" + res.first().toJson() + "\n");
	}

}

package com.online.shop;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.BeforeAll;

public class MongoDbConnection {

    public static MongoClient mongoClient;

    @BeforeAll
    public static void setConnection() {
        String uri = "mongodb+srv://natusj13:ZwzawKRSp7OJgMeL@cluster0.wqsu7sw.mongodb.net/?retryWrites=true&w=majority";
        try {
            mongoClient = MongoClients.create(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MongoCollection<Document> setCollection(String collectionName) {
        MongoDatabase database = mongoClient.getDatabase("sample_airbnb");
        return database.getCollection(collectionName);
    }
}

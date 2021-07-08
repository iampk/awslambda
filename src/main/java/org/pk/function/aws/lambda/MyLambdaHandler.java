package org.pk.function.aws.lambda;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MyLambdaHandler implements RequestHandler<String, String> {
    @Override
    public String handleRequest(String input, Context context) {
        System.out.println(">>>>>> Input:"+input);
        String tableName = System.getenv("dynamoDBTableName");
        System.out.println(">>>>>> DynamoDB Table Name:"+tableName);
        return getDynamoItem(tableName,input);
    }

    private String getDynamoItem(String tableName, String id){

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable(tableName);

        Item item = table.getItem("_id", id);

        return item.toString();

    }
}

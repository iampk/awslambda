package org.pk.function.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;

public class MyDynamoHandler implements RequestHandler<DynamodbEvent, String> {


    @Override
    public String handleRequest(DynamodbEvent dynamodbEvent, Context context) {
        for (DynamodbEvent.DynamodbStreamRecord record : dynamodbEvent.getRecords()){
            System.out.println(">>> eventId:"+record.getEventID());
            System.out.println(">>> eventName:"+record.getEventName());
            System.out.println(">>> record:"+record.getDynamodb().toString());
        }
        return "Check the Logs!";
    }
}

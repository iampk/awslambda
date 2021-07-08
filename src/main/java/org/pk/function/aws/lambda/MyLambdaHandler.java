package org.pk.function.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MyLambdaHandler implements RequestHandler<String, String> {
    @Override
    public String handleRequest(String input, Context context) {
        System.out.println(">>>>>> Inside the Lambda "+input);
        return "Hello "+input+"!";
    }
}

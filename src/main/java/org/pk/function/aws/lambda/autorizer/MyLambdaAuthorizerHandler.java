package org.pk.function.aws.lambda.autorizer;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class MyLambdaAuthorizerHandler implements RequestHandler<Map<String, String>, String> {

    @Override
    public String handleRequest(Map<String, String> input, Context context) {
        System.out.println(">>>>>> Input:" + input);
        return input.toString();
    }

}

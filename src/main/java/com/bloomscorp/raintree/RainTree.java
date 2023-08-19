package com.bloomscorp.raintree;

import com.bloomscorp.hastar.code.ActionCode;
import com.bloomscorp.raintree.configuration.GsonExclusionStrategy;
import com.bloomscorp.raintree.support.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

public class RainTree {

    private static final Gson GSON = new GsonBuilder().setExclusionStrategies(
        new GsonExclusionStrategy()
    ).create();

    public String renderResponse(Object object) {
        return RainTree.GSON.toJson(object);
    }

    public String renderResponse(
            boolean success,
            String message,
            HashMap<String, Object> parameters
    ) {

        if (parameters == null)
            parameters = new HashMap<>();

        parameters.put(Constant.JSON_RESPONSE_SUCCESS, success);
        parameters.put(Constant.JSON_RESPONSE_MESSAGE, message);

        return RainTree.GSON.toJson(parameters);
    }

    public String renderResponse(boolean success, String message) {
        return renderResponse(success, message, null);
    }

    public String successResponse(String message) {
        return renderResponse(true, message);
    }

    public String failureResponse(String message) {
        return renderResponse(false, message);
    }

    public String failureResponse(int actionCode) {
        return renderResponse(
                false,
                ActionCode.message(actionCode)
        );
    }

    public String successResponse() {
        return successResponse(Constant.JSON_RESPONSE_GENERIC_SUCCESS);
    }

    public String failureResponse() {
        return failureResponse(Constant.JSON_RESPONSE_GENERIC_FAILURE);
    }

    public String renderParameterizedSuccessResponse(HashMap<String, Object> parameters) {
        return renderResponse(true, Constant.BLANK_STRING_VALUE, parameters);
    }
}

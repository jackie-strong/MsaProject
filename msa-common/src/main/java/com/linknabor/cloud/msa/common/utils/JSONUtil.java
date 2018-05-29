package com.linknabor.cloud.msa.common.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletResponse;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSON對象格式化工具类.
 * Create by Jackie on 2018.05.28
 */
public class JSONUtil {
    private static Gson gson = null;

    static {
        gsonBuilder();
    }
    private static void gsonBuilder(){
        gson = new GsonBuilder().registerTypeAdapter(ServletResponse.class,new ServletResponseAdapter()).create();
    }

    public static synchronized Gson newInstance() {
        if (gson == null) {
            gsonBuilder();
        }
        return gson;
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T toBean(String json, Class<T> clz) {

        return gson.fromJson(json, clz);
    }

    public static <T> Map<String, T> toMap(String json, Class<T> clz) {
        Map<String, JsonObject> map = gson.fromJson(json, new TypeToken<Map<String, JsonObject>>() {
        }.getType());
        Map<String, T> result = new HashMap<>();
        for (String key : map.keySet()) {
            result.put(key, gson.fromJson(map.get(key), clz));
        }
        return result;
    }

    public static Map<String, Object> toMap(String json) {
        Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
        }.getType());
        return map;
    }

    public static <T> List<T> toList(String json, Class<T> clz) {
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        List<T> list = new ArrayList<>();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, clz));
        }
        return list;
    }
    static class ServletResponseAdapter implements JsonSerializer<ServletResponse>{
        @Override
        public JsonElement serialize(ServletResponse servletResponse, Type type, JsonSerializationContext jsonSerializationContext) {
            return null;
        }
    }
}

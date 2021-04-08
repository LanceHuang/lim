package com.lance.lim.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * json工具类
 *
 * @author Lance
 */
public class JsonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    private static final TypeFactory typeFactory = TypeFactory.defaultInstance();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    private JsonUtils() {
    }

    /**
     * Transform object to json.
     */
    public static String object2json(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("Failed to parse object.", e);
            return null;
        }
    }

    /**
     * Transform json to object.
     *
     * @param str String of json format
     */
    public static <T> T json2object(String str, Class<T> clazz) {
        try {
            return mapper.readValue(str, clazz);
        } catch (JsonProcessingException e) {
            LOGGER.error("Failed to parse json.", e);
            return null;
        }
    }

    /**
     * Transform map to json.
     */
    public static <K, V> String map2json(Map<K, V> data) {
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            LOGGER.error("Failed to parse map.", e);
            return null;
        }
    }

    /**
     * Transform json to map.
     *
     * @param str String of json format
     */
    public static Map<String, Object> json2map(String str) {
        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Object.class);
        try {
            return mapper.readValue(str, mapType);
        } catch (JsonProcessingException e) {
            LOGGER.error("Failed to parse json.", e);
            return null;
        }
    }

    /**
     * Transform json to map.
     *
     * @param str String of json format
     */
    public static <K, V> Map<K, V> json2map(String str, Class<K> kClass, Class<V> vClass) {
        MapType mapType = typeFactory.constructMapType(HashMap.class, kClass, vClass);
        try {
            return mapper.readValue(str, mapType);
        } catch (JsonProcessingException e) {
            LOGGER.error("Failed to parse json.", e);
            return null;
        }
    }

}

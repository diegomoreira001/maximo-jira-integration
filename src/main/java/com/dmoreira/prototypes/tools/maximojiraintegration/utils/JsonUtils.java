package com.dmoreira.prototypes.tools.maximojiraintegration.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;

/**
 * Created by dmoreira <diegomoreira00@gmail.com> on 10/22/17.
 */
public class JsonUtils {

    /**
     * Takes a POJO and writes its values a JSON String (not pretty print)
     * @param pojo
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> String POJOToJSONString(T pojo) throws IOException {
        return new ObjectMapper().writeValueAsString(pojo);
    }

    /**
     * Re-writes a JSON String using JavaScript (pretty print).
     *
     * Obscure and "hacky" way of doing stuff. Not cool.
     *
     * @param jsonString
     * @return
     * @throws ScriptException
     */
    public static String JSONStringToPrettyString (String jsonString) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine scriptEngine = manager.getEngineByName("JavaScript");
        scriptEngine.put("jsonString", jsonString);
        scriptEngine.eval("result = JSON.stringify(JSON.parse(jsonString), null, 2)");
        return (String) scriptEngine.get("result");
    }

    /**
     * Writes a POJO as a JSON String using JavaScript (pretty print).
     *
     * @param pojo
     * @param <T>
     * @return
     * @throws IOException
     * @throws ScriptException
     */
    public static <T> String POJOToPrettyString (T pojo) throws IOException, ScriptException {
        String jsonString = POJOToJSONString(pojo);
        return JSONStringToPrettyString(jsonString);
    }
}

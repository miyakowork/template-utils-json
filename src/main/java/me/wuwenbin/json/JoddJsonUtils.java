package me.wuwenbin.json;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

/**
 * 具体用法请参考
 * http://jodd.org/doc/json/json-serializer.html
 * Created by wuwenbin on 2017/2/17.
 *
 * @author wuwenbin
 * @since 1.0
 */
public class JoddJsonUtils {

    /**
     * 获取对象转json的操作对象
     *
     * @return
     */
    public JsonSerializer serializer() {
        return new JsonSerializer();
    }

    /**
     * 获取json转对象的操作对象
     * @return
     */
    public JsonParser parser(){
        return new JsonParser();
    }
}

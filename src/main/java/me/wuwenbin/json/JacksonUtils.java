package me.wuwenbin.json;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * <b>ClassName</b>: BnJsonFastUtils<br>
 * <b>Description</b>: JSON快速处理工具类，包含2个无敌的转化方法。不是很奇葩的情况此工具类的2个方法都可满足。<br>
 * <h1>不足的地方</h1> Jackson对于复杂类型的json转换bean会出现问题，一些集合Map，List的转换出现问题。
 * Jackson对于复杂类型的bean转换Json，转换的json格式不是标准的Json格式
 *
 * <b>author</b>: Wuwenbin<br>
 * <b>date</b>: 2016年8月28日<br>
 * <b>time</b>: 下午5:59:59 <br>
 */
public class JacksonUtils {
	
	static ObjectMapper objectMapper;

	/**
	 * <h1>使用泛型方法，把json字符串转换为相应的JavaBean对象。</h1>
	 * (1)转换为普通JavaBean：readValue(json,Student.class)<br/>
	 * (2)转换为List：readValue(json,List.class).但是如果我们想把json转换为特定类型的List，<br/>
	 * 比如List&lt; Student&gt;，就不能直接进行转换了。
	 * 因为readValue(json,List.class)返回的其实是List&lt;Map&gt;类型，<br/>
	 * 你不能指定readValue()的第二个参数是List&lt;Student&gt;.class，所以不能直接转换。
	 * 我们可以把readValue()的第二个参数传递为Student[].class.然后使用Arrays.asList();
	 * 方法把得到的数组转换为特定类型的List。<br/>
	 * (3)转换为Map：readValue(json,Map.class) 我们使用泛型，得到的也是泛型。
	 * 
	 * @param content
	 *            要转换的JavaBean类型
	 * @param valueType
	 *            原始json字符串数据
	 * @return JavaBean对象
	 */
	public static <T> T fromJSon(String content, Class<T> valueType) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.readValue(content, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * <h1>把JavaBean转换为json字符串</h1><br/>
	 * (1)普通对象转换：toJson(Student) <br/>
	 * (2)List转换：toJson(List)<br/>
	 * (3)Map转换:toJson(Map) 我们发现不管什么类型，都可以直接传入这个方法
	 * 
	 * @param object
	 *            JavaBean对象
	 * @return json字符串
	 */
	public static String toJSon(Object object) {
		if (objectMapper == null) {
			objectMapper = new ObjectMapper();
		}
		try {
			return objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}

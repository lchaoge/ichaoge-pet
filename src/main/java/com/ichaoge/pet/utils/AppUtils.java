package com.ichaoge.pet.utils;

import com.fasterxml.jackson.databind.JavaType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * @author vanhb 2014年12月30日9:51:12
 */

public class AppUtils {
	private static final Logger logger = LoggerFactory.getLogger("ecard-sell");
	// 缓存需要结算的经验，掉落物品等

	/**
	 * @return 返回一个Map，便与restful层使用
	 */
	public static NoNullMap getMap(String key, Object value) {
		NoNullMap map = new NoNullMap();
		map.put(key, value);
		return map;
	}

	/**
	 * @return 返回一个Map，便与restful层使用
	 */
	public static NoNullMap getTierMap(String key, String subKey, Object value) {
		NoNullMap map = new NoNullMap();
		map.put(key, getMap(subKey, value));
		return map;
	}

	/**
	 * @return 返回一个
	 */
	public static List<Map<String, Object>> getList(Map<String, Object> obj) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(obj);
		return list;
	}


	/**
	 * 无空Map<String,Object>,链式封装参数
	 */
	public static class NoNullMap extends HashMap<String, Object> {
		private static final long serialVersionUID = 1L;
		@Override
		public NoNullMap put(String key, Object value) {
			if (!isNull(value + "")) {
				super.put(key, value);
			}
			return this;
		}

	}
	
	/**
	 * 检查从 Map<String, Object> 中获取的参数是否为"",null," ";
	 */
	public static boolean isNull(String str) {
		if (StringUtils.isBlank(str) || "null".equals(str)) {
			return true;
		}
		return false;
	}
	public static Integer getIntFromStr(String str) {
		try {
			Integer integer = Integer.valueOf(str);
			return  integer;
		}catch (Exception e){
			logger.error(e.getMessage(),e);
			return null;
		}
	}
	public static Double getDoubleFromStr(String str) {
		try {
			Double integer = Double.valueOf(str);
			return  integer;
		}catch (Exception e){
			logger.error(e.getMessage(),e);
			return null;
		}
	}

	/**
	 * jackson 获取把json转换成List<String>
	 * 
	 *
	 */
	public static JavaType getListJT(Class<?> entityClass) {
		return JsonMapper.getInstance().constructListType(List.class, entityClass);
	}

	/**
	 * jackson 获取把json转换成 Map<String,Object>
	 *
	 * @param str
	 *            ,obj collection的泛型的大Class实例，（内存中的一份字节码）
	 */
	public static JavaType getMapJT(Class<?> str, Class<?> obj) {
		return JsonMapper.getInstance().contructMapType(Map.class, str, obj);
	}

	/**
	 * 直接把json转换为Map<Stirng,Object>
	 */
	public static Map<String, Object> getMapOfjson(String json) {
		JavaType type = getMapJT(String.class, Object.class);
		Map<String, Object> map = JsonMapper.getInstance().fromJson(json, type);
		return map;
	}

	/**
	 * @param obj
	 *            :声明类型是Object;运行时类型是Map<String,Object>
	 *            把声明类型Object强制转换成运行时类型Map<String,Object>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> ojbCast2Map(Object obj) {
		if (obj instanceof Map) {
			Map<String, Object> mmap = (Map<String, Object>) obj;
			return mmap;
		} else {
			return null;
		}

	}

	public static String objCast2String(Object obj) {
		if (obj instanceof String) {
			return obj + "";
		} else {
			return null;
		}
	}

	/**
	 * Generic type Map
	 */
	public static List<Map<String, Object>> json2List(String jsonList) {
		JavaType jt = getListJT(Map.class);
		List<Map<String, Object>> list = JsonMapper.getInstance().fromJson(jsonList, jt);
		return list;
	}

	/**
	 * Generic type String
	 */
	public static List<String> json2ListStr(String jsonList) {
		JavaType jt = getListJT(String.class);
		List<String> list = JsonMapper.getInstance().fromJson(jsonList, jt);
		return list;
	}
	public static List<Integer> json2ListInt(String jsonList) {
		JavaType jt = getListJT(Integer.class);
		List<Integer> list = JsonMapper.getInstance().fromJson(jsonList, jt);
		return list;
	}

	/**
	 * json2Map (default Generic type String,Object)
	 */
	public static Map<String, Object> json2Map(String json) {
		JavaType jt = getMapJT(String.class, Object.class);
		Map<String, Object> jsonToMap = JsonMapper.getInstance().fromJson(json, jt);
		return jsonToMap;
	}

	/**
	 * @param map
	 *            遍历map获取 key
	 * @return
	 */
	public static List<String> getKeyOfMap(Map<String, Object> map) {
		if (map == null || map.size() == 0) {
			throw new RuntimeException("getKeyOfMap,参数不能为空");
		}
		List<String> list = new ArrayList<String>();
		Set<Entry<String, Object>> entrySet2 = map.entrySet();
		for (Entry<String, Object> entry2 : entrySet2) {
			String key = entry2.getKey();
			list.add(key);
		}
		return list;
	}



	/**
	 * 
	 * @param recordDate
	 * @return	过了刷新时间返回ture，否则false
	 * @throws java.text.ParseException
	 */
	public static boolean isRefreshTime(Date recordDate) {
		try {
			//获得当天的日期
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
			//定义开始时间字符串
			String refreshTime =""; //刷新时间
			refreshTime = sdf.format(new Date())+refreshTime;
			//获得当天的指定时间的date对象
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date refreshDate = sdf.parse(refreshTime);
			
			//刷新日期>记录日期:则需要刷新
			if(recordDate == null || refreshDate.getTime() > recordDate.getTime()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		return false;
	}
	
	
	public static List<String> objCast2ListStr(Object obj) {
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>)obj;
		return list;
	}
	
	
	public static String getCurrentDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	public static String formatYyyyMMddHHmmss(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}
	



    


	/**
	 * @param str  驼峰和下划线字符串互转
	 * @return
	 */
	public static String underLine22camelcase(String str) {
		if (str != null && str.contains("_")) {
			StringBuilder sb = new StringBuilder();
			char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				char tmp = charArray[i];
	            if((tmp<='Z')&&(tmp>='A')){
	            	sb.append("_").append((tmp+"").toLowerCase());
	            }else {
					sb.append(tmp);
				}
			}
			return sb.toString();
		}else {
			boolean flag = false;
			StringBuilder sb = new StringBuilder();
			char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				char tmp = charArray[i];
				if ('_'==tmp) {
					flag = true;
				}else {
					if (!flag) {
						sb.append(tmp);
					}else {
						flag = false;
						sb.append((tmp+"").toUpperCase());
					}
				}
			}
			return sb.toString();
		}
		
	}


	public static String getTradeNo(){

		return UUID.randomUUID().toString().replace("-","");


	}
	public static String getPathOfTomcat4bak() {
		String path = Thread.currentThread().getContextClassLoader().getResource("/").getPath().split("webapps")[0]
				+ "bak4source";
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}
		return path;

	}

	public static void upload2TomcatUpload(String realPath, String fileName, InputStream in) throws Exception {
		File versionFile = new File(realPath, fileName);
		OutputStream bos = new FileOutputStream(versionFile);
		BufferedInputStream bis = new BufferedInputStream(in);
		try {
			byte[] data = new byte[1024];
			int bytes = 0;
			while ((bytes = bis.read(data, 0, data.length)) != -1) {
				bos.write(data, 0, bytes);
			}
			bis.close();
			bos.flush();
			bos.close();

		}catch (Exception e){

		}finally {
			bis.close();
			bos.flush();
			bos.close();
		}
	}
	public static Map<String,Object> getMap(Map<String ,Object> target,String key) throws RuntimeException{
		Object o = target.get(key);
		System.out.println(o);
		return (Map)o;
	}
	public static String xmlKey2LowerCase(String str){


		if (StringUtils.isBlank(str)) {
			return null;
		}
		char[] charArray = str.toCharArray();
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		for (char c : charArray) {
			if (c=='<') {
				flag = true;
			}else if (c=='>') {
				flag = false;
			}
			if (flag && c != '/'&& c != '<'&& c != '>') {
				if ( c>=65 && c<=90){
					c+=32;
				}

			}
			sb.append(c);

		}

		return sb.toString();
	}

	public static String getStrOfMap4Excel(Map<String ,Object> map,String key){
		Object o = map.get(key);
		if (o != null){
			return o+"";
		}else {
			return  null;
		}

	}



	public static void main(String[] args) {
		String tradeNo = getTradeNo();
		System.out.println(tradeNo);

	}


}

/**
 *
 * @project GMS
 * @package com.gms.util
 * @version 1.0
 * @author 王博
 * @createDate 上午11:28:24
 * @company 北京天行网安信息技术有限责任公司
 * @authorization (C) Copyright TopWalk Corporation 2006-2012<br/>
 *                <B>本内容仅限于北京天行网安信息技术有限责任公司内部使用，禁止转发</B>
 * @since JDK 1.6
 **/
package com.core.util;

import java.util.Date;
import java.util.HashMap;


public class MapUtil {
	
	/**
	 * 获取字符串
	 * @param obj
	 * @return
	 */
	public static String getString(Object obj){
		if(obj != null){
			return ""+obj;
		}else{
			return "";
		}
	}
	
	/**
	 * 获取整型类型数据，要求参数必须是 int 型或者是 Integer型
	 * @param obj
	 * @return 如果参数为null，将会返回整数0
	 */
	public static Integer getInteger(Object obj){
		if(obj != null){
			return (Integer)obj;
		}else{
			return 0;
		}
	}
	
	/**
	 * 获取双精度浮点型，要求参数必须是double型或者是 Double型
	 * @param obj
	 * @return 如果参数为null，将会返回整数0.0
	 */
	public static Double getDouble(Object obj){
		if(obj != null){
			return (Double)obj;
		}else{
			return 0.0;
		}
	}
	
	
	public static Date getDate(Object obj){
		if(obj!=null){
			return (Date)obj;
		}else{
			return null;
		}
	}
	
	/**
	 * 获取整型类型数据，要求参数必须是 int、long、Long、Integer型
	 * @param obj
	 * @return 如果参数为null，将会返回长整形0
	 */
	public static Long getLong(Object obj){
		if(obj != null){
			if(obj instanceof Integer){
				return new Long((Integer)obj);
			}else{
				return (Long)obj;
			}
		}else{
			return 0L;
		}
	}
	
	/**
	 * 获取整型类型数据，要求参数必须是 int、long、Long、Integer型
	 * @param obj
	 * @return 如果参数为null，将会返回浮点型0
	 */
	public static Float getFloat(Object obj){
		if(obj != null){
			String tmp = String.valueOf(obj);
			return Float.parseFloat(tmp);
		}else{
			return 0F;
		}
	}
	/**
	 * 获取一个新的new的HashMap<String,Object>,主要用于构建查询参数封装器，默认容器大小为5。
	 * @return HashMap<String,Object>
	 */
	public static synchronized HashMap<String,Object> getNewHashMap(){
		return new HashMap<String,Object>(5);
	}

}

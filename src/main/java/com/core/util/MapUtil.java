/**
 *
 * @project GMS
 * @package com.gms.util
 * @version 1.0
 * @author ����
 * @createDate ����11:28:24
 * @company ��������������Ϣ�����������ι�˾
 * @authorization (C) Copyright TopWalk Corporation 2006-2012<br/>
 *                <B>�����ݽ����ڱ�������������Ϣ�����������ι�˾�ڲ�ʹ�ã���ֹת��</B>
 * @since JDK 1.6
 **/
package com.core.util;

import java.util.Date;
import java.util.HashMap;


public class MapUtil {
	
	/**
	 * ��ȡ�ַ���
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
	 * ��ȡ�����������ݣ�Ҫ����������� int �ͻ����� Integer��
	 * @param obj
	 * @return �������Ϊnull�����᷵������0
	 */
	public static Integer getInteger(Object obj){
		if(obj != null){
			return (Integer)obj;
		}else{
			return 0;
		}
	}
	
	/**
	 * ��ȡ˫���ȸ����ͣ�Ҫ�����������double�ͻ����� Double��
	 * @param obj
	 * @return �������Ϊnull�����᷵������0.0
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
	 * ��ȡ�����������ݣ�Ҫ����������� int��long��Long��Integer��
	 * @param obj
	 * @return �������Ϊnull�����᷵�س�����0
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
	 * ��ȡ�����������ݣ�Ҫ����������� int��long��Long��Integer��
	 * @param obj
	 * @return �������Ϊnull�����᷵�ظ�����0
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
	 * ��ȡһ���µ�new��HashMap<String,Object>,��Ҫ���ڹ�����ѯ������װ����Ĭ��������СΪ5��
	 * @return HashMap<String,Object>
	 */
	public static synchronized HashMap<String,Object> getNewHashMap(){
		return new HashMap<String,Object>(5);
	}

}

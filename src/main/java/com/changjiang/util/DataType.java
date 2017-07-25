package com.changjiang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类型转化类
 * 
 * @author LIYUNFENG
 * 
 */
public class DataType {
	/**
	 * 通过该方法将字符串数组转化为整形数组
	 * 
	 * @param ids
	 * @return
	 */
	public static Integer[] converterStringArray2IntegerArray(String[] ids) {
		// 转化的整形数组长度要保持一致
		Integer[] id = new Integer[ids.length];
		if (ids != null && ids.length > 0) {
			for (int i = 0; i < ids.length; i++) {
				id[i] = Integer.parseInt(ids[i]);
			}
			return id;
		}
		return null;
	}

	
	/**
	   * 获取现在时间
	   * 
	   * @return  返回字符串格式   dateFormat 例如 yyyy-MM-dd
	   */
	public static String getStringDate(String dateFormat) {
	   Date currentTime = new Date();
	   SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
	   String dateString = formatter.format(currentTime);
	   return dateString;
	}

	/**
	 * 处理客户编码产生当前流水号 3位 001 4位 0001
	 */
	public static String createCurrentGlideNumber(int glideNumber) {
		String glideNum = "";
		if (glideNumber <= 3) {
			glideNum = "00";
		} else {
			for (int i = 0; i < glideNumber - 1; i++) {
				glideNum = glideNum + "0";
			}
		}
		glideNum = glideNum + "1";
		return glideNum;
	}

	/**
	 * 生成当前流水号的下一条流水号 "0001"------>"10001" "10001"----->10001 10001 + 1
	 * ---->10002 10002---->"10002" 截取为0002
	 * 
	 * @param args
	 */
	public static String createNextGlideNumber(String glideNumber) {
		//System.out.println("0:" + glideNumber);//010
		if(glideNumber!=null && !glideNumber.equals("")){
			glideNumber="1"+glideNumber;
		}
		//System.out.println("1:" + glideNumber);//0101010
		Integer num = Integer.parseInt(glideNumber);
		//System.out.println("2:" + glideNumber);//0101010
		++num;
		//System.out.println("3:" + glideNumber);//0101010
		glideNumber = num.toString().substring(1);
		//System.out.println("4:" + glideNumber);//1011
		return glideNumber;
	}

	public static void main(String[] args) {
		// 产生4位的当前流水号
		System.out.println("产生4位的当前流水号     :"
				+ DataType.createCurrentGlideNumber(5));
		// 获取0001的下一位流水号
		System.out.println("获取00010的下一位流水号     :"
				+ DataType.createNextGlideNumber("00001"));
	}
}

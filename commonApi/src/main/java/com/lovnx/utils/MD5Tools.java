package com.lovnx.utils;

import java.security.MessageDigest;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;

import com.traffic.common.utils.Tools;

public abstract class MD5Tools  
{  
   /*public final static String MD5(String username,String pwd) {  
        //用于加密的字符  
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
                'A', 'B', 'C', 'D', 'E', 'F' };  
        try {  
            //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中  
        	String finalS = username+pwd;
            byte[] btInput =finalS.getBytes();  
               
            //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
               
            //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要  
            mdInst.update(btInput);  
               
            // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文  
            byte[] md = mdInst.digest();  
               
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {   //  i = 0  
                byte byte0 = md[i];  //95  
                str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5   
                str[k++] = md5String[byte0 & 0xf];   //   F  
            }  
               
            //返回经过加密后的字符串  
            return new String(str);  
               
        } catch (Exception e) {  
            return null;  
        }  
    }*/
	public final static String MD5(String username,String pwd) { 
		String finalS = username+pwd+Tools.getRandomNum()+Tools.getTimeInMillis();
		return Tools.str(MD5Tools.generate(finalS), "");
	}
	
    /**  
     * 加盐MD5  
     * @author daniel  
     * @time 2016-6-11 下午8:45:04  
     * @param password  
     * @return  
     */  
        public static String generate(String password) {  
            Random r = new Random();  
            StringBuilder sb = new StringBuilder(16);  
            sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));  
            int len = sb.length();  
            if (len < 16) {  
                for (int i = 0; i < 16 - len; i++) {  
                    sb.append("0");  
                }  
            }  
            String salt = sb.toString();  
            password = md5Hex(password + salt);  
            char[] cs = new char[48];  
            for (int i = 0; i < 48; i += 3) {  
                cs[i] = password.charAt(i / 3 * 2);  
                char c = salt.charAt(i / 3);  
                cs[i + 1] = c;  
                cs[i + 2] = password.charAt(i / 3 * 2 + 1);  
            }  
            return new String(cs);  
        }  
  
        /**  
         * 校验加盐后是否和原文一致  
         * @author daniel  
         * @time 2016-6-11 下午8:45:39  
         * @param password  
         * @param md5  
         * @return  
         */  
        public static boolean verify(String password, String md5) {  
            char[] cs1 = new char[32];  
            char[] cs2 = new char[16];  
            for (int i = 0; i < 48; i += 3) {  
                cs1[i / 3 * 2] = md5.charAt(i);  
                cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);  
                cs2[i / 3] = md5.charAt(i + 1);  
            }  
            String salt = new String(cs2);  
            return md5Hex(password + salt).equals(new String(cs1));  
        }  
  
        /**  
         * 获取十六进制字符串形式的MD5摘要  
         */  
        private static String md5Hex(String src) {  
            try {  
                MessageDigest md5 = MessageDigest.getInstance("MD5");  
                byte[] bs = md5.digest(src.getBytes());  
                return new String(new Hex().encode(bs));  
            } catch (Exception e) {  
                return null;  
            }  
        }  
  
    
    
    public static void main(String[] args) {
		System.out.println(MD5Tools.MD5("admin", "1234567"));
		System.out.println(MD5Tools.generate("1234567"));
		System.out.println(MD5Tools.verify("1234567","369521145f54d3b491e59034e9ab1ee8237c73b02914d94f"));
	}
}  
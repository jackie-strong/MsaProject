package com.linknabor.cloud.msa.common.utils;

import java.util.Date;
import java.util.Random;

/**
 * 主键配置类
 * Create by Jackie on 2018.05.28
 */
public class PrimayKeyUtils {
    /**
     * 自定义订单编号
     * @return
     */
    public  static Long getOrderNum(){
        StringBuffer str=new StringBuffer();
        str.append(DateUtils.getTimeStrDefault(new Date()).substring(2));
        str.append(DateUtils.getTimeStrDefault(new Date()));
        str.append(getRandomBy6());
        return Long.getLong(str.toString());
    }
    /**
     * 生成6位随机数
     * @return
     */
    public static String getRandomBy6() {

        Random r = new Random();
        long i = r.nextInt(100000);
        long number = i + 900000L;
        return Long.toString(number);
    }

    /**
     * 生成16位随机数
     * @return
     */
    public static String getRandomBy16(){

        long currTime = System.currentTimeMillis();	//13位
        Random random = new Random();
        int s = random.nextInt(999)%(999-0+1) + 0;
        return String.valueOf(currTime)+s;
    }

    public   static int PAY_ORDER_ID_LENGTH = 28;

    public static String DEFAULT_PAY_ORDER_ID_SUFFIX = "0000000000";
    /**
     * 28位自定义订单编号
     * @param prefixValue 两位前缀
     * @param additionalValue  至少2为中部添加值
     * @return
     */
    public  static String getCateringPayOrderNum(String prefixValue, String additionalValue){
        StringBuffer str=new StringBuffer();
        str.append(prefixValue);//2
        str.append(DateUtils.getTimeStrDefault(new Date()).substring(2));//15
        str.append(additionalValue);//2
        str.append(getRandomBy6());//6
        return  str.length() >= PAY_ORDER_ID_LENGTH ? str.substring(0,PAY_ORDER_ID_LENGTH) : str.append(DEFAULT_PAY_ORDER_ID_SUFFIX).substring(0,PAY_ORDER_ID_LENGTH);
    }
}

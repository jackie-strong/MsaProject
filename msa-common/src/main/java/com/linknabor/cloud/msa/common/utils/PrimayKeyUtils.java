package com.linknabor.cloud.msa.common.utils;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 主键配置类
 * Create by Jackie on 2018.05.28
 */
public class PrimayKeyUtils {
    /**
     * 自定义订单编号
     *
     * @return
     */
    public static Long getOrderNum() {
        StringBuffer str = new StringBuffer();
        str.append(DateUtils.getTimeStrDefault(new Date()).substring(2));
        str.append(DateUtils.getTimeStrDefault(new Date()));
        str.append(getRandomBy6());
        return Long.getLong(str.toString());
    }

    /**
     * 生成6位随机数
     *
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
     *
     * @return
     */
    public static String getRandomBy16() {

        long currTime = System.currentTimeMillis();    //13位
        Random random = new Random();
        int s = random.nextInt(999) % (999 - 0 + 1) + 0;
        return String.valueOf(currTime) + s;
    }

    public static int PAY_ORDER_ID_LENGTH = 28;

    public static String DEFAULT_PAY_ORDER_ID_SUFFIX = "0000000000";

    /**
     * 28位自定义订单编号
     *
     * @param prefixValue     两位前缀
     * @param additionalValue 至少2为中部添加值
     * @return
     */
    public static String getCateringPayOrderNum(String prefixValue, String additionalValue) {
        StringBuffer str = new StringBuffer();
        str.append(prefixValue);//2
        str.append(DateUtils.getTimeStrDefault(new Date()).substring(2));//15
        str.append(additionalValue);//2
        str.append(getRandomBy6());//6
        return str.length() >= PAY_ORDER_ID_LENGTH ? str.substring(0, PAY_ORDER_ID_LENGTH) : str.append(DEFAULT_PAY_ORDER_ID_SUFFIX).substring(0, PAY_ORDER_ID_LENGTH);
    }


    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();
    }

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

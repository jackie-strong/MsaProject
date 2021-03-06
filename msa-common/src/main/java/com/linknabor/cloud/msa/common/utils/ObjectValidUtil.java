package com.linknabor.cloud.msa.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * 校验参数类型
 * Create by Jackie on 2018.05.28
 */
public class ObjectValidUtil {
    /**
     * 判断是否为有效Short值
     *
     * @param num
     * @return
     */
    public static boolean isValidShort(Short num) {
        return num != null && num.compareTo((short) 0) > 0;
    }

    public static boolean isInvalidShort(Short num) {
        return !isValidShort(num);
    }

    /**
     * 判断是否为有效Integer值
     *
     * @param num
     * @return
     */
    public static boolean isValidInteger(Integer num) {
        return num != null && num.compareTo(0) > 0;
    }

    public static boolean isInvalidInteger(Integer num) {
        return !isValidInteger(num);
    }

    /**
     * 判断是否为有效Long值
     *
     * @param num
     * @return
     */
    public static boolean isValidLong(Long num) {
        return num != null && num.compareTo(0L) > 0;
    }

    public static boolean isInvalidLong(Long num) {
        return !isValidLong(num);
    }

    /**
     * 判断是否为有效BigDecimal值
     *
     * @param num
     * @return
     */
    public static boolean isValidBigDecimal(BigDecimal num) {
        return num != null && num.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean isInvalidBigDecimal(BigDecimal num) {
        return !isValidBigDecimal(num);
    }

    /**
     * 判断是否为有效String值
     *
     * @param str
     * @return
     */
    public static boolean isValidString(String str) {
        return StringUtils.isNotBlank(str);
    }

    public static boolean isInvalidString(String str) {
        return StringUtils.isBlank(str);
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isValidCurPage(Integer curPage) {
        if (curPage == null) {
            return false;
        }
        return curPage.compareTo(1) >= 0;
    }

    public static boolean isValidCurPage(Long curPage) {
        if (curPage == null) {
            return false;
        }
        return curPage.compareTo(1L) >= 0;
    }

    public static boolean isInvalidCurPage(Integer curPage) {
        return !isValidCurPage(curPage);
    }

    public static boolean isInvalidCurPage(Long curPage) {
        return !isValidCurPage(curPage);
    }

    public static boolean isValidViewNumber(Integer viewNumber) {
        if (viewNumber == null) {
            return false;
        }
        return viewNumber.compareTo(0) > 0;
    }

    public static boolean isValidViewNumber(Long viewNumber) {
        if (viewNumber == null) {
            return false;
        }
        return viewNumber.compareTo(0L) > 0;
    }

    public static boolean isInvalidViewNumber(Integer viewNumber) {
        return !isValidViewNumber(viewNumber);
    }

    public static boolean isInvalidViewNumber(Long viewNumber) {
        return !isValidViewNumber(viewNumber);
    }

    public static boolean isValidLimit(Integer limit) {
        if (limit == null) {
            return false;
        }
        return limit.compareTo(0) > 0;
    }

    public static boolean isInvalidLimit(Integer limit) {
        return !isValidLimit(limit);
    }

    public static boolean isAllNull(Object... objs) {
        if (objs == null || objs.length < 1) {
            return true;
        }
        int nullcount = 0;
        for (Object obj : objs) {
            if (isNull(obj)) {
                nullcount++;
            }
        }
        return objs.length == nullcount;
    }
}

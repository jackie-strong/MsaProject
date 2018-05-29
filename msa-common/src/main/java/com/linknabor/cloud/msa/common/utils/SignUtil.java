package com.linknabor.cloud.msa.common.utils;

import com.linknabor.cloud.msa.common.exception.BaseException;
import org.apache.commons.net.util.Base64;
import org.springframework.util.StringUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SignUtil {

    private final static String INPUT_CHARSET = "input_charset";

    /**
     * 创建md5摘要,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     */
    public static String createSign(Map<?, ?> map, String key) {
        String charset = (String) map.get(INPUT_CHARSET);
        if (StringUtils.isEmpty(charset)) {
            charset = "UTF-8";
        }
        StringBuffer sb = new StringBuffer();
        Set es = map.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k) && !"csp_id".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + key);
        return MD5Util.MD5Encode(sb.toString(), charset).toUpperCase();
    }
}

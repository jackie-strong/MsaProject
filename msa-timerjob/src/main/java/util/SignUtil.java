package util;

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

public class SignUtil {
    /**
     * RSA签名
     * RSA/ECB/PKCS1Padding
     * @param content	内容
     * String keyPath	密钥路径
     * @return
     */
    public static String signByKeyPath(String content, String keyPath, String charset){

        String key = getKeyStrByPath(keyPath);
        return sign(content, key, charset);

    }

    /**
     * 根据路径获取公钥
     * @param publicKeyPath	密钥路径
     * @return
     */
    private static String getKeyStrByPath(String publicKeyPath){

        InputStream inputStream = null;
        StringBuffer sb = new StringBuffer();
        try {
            inputStream = new FileInputStream(publicKeyPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String readLine = null;
            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }

        } catch (Exception e) {

            throw new BaseException("load public key failed !", e);
        } finally {
            if (inputStream != null){
                try {
                    inputStream.close();
                }catch (Exception e){
                    throw new BaseException(e);
                }
            }
        }
        return sb.toString();
    }

    /**
     * RSA私钥签名
     * RSA/ECB/PKCS1Padding
     * @param content
     * @param privateKey	私钥字串
     * @param charset	字符集
     * @return
     */
    public static String sign(String content, String privateKey, String charset) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey.getBytes()));
            KeyFactory key = KeyFactory.getInstance("RSA");
            PrivateKey priKey = key.generatePrivate(priPKCS8);
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initSign(priKey);
            if (StringUtils.isEmpty(charset)) {
                signature.update(content.getBytes());
            }else {
                signature.update(content.getBytes(charset));
            }
            byte[]signed = signature.sign();
            return new String(Base64.encodeBase64Chunked(signed));

        } catch (Exception e) {
            throw new BaseException(e);
        }
    }
}

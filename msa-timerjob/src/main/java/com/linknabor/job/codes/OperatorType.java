package com.linknabor.job.codes;

import com.linknabor.job.model.CodeInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatorType extends CodesItem {

    private static final Log logger = LogFactory.getLog(OperatorType.class);

    static {
        fillObjectToMap();
    }
    private String code;
    private String category;

    public OperatorType(String code){
        this.category=CodesItem.operatorType;
        this.code=code;
    }

    public static String getValue(String code){
        return CodesItem.getValue(CodesItem.operatorType,code);
    }
    public static String getValue(OperatorType code){
        return CodesItem.getValue(CodesItem.operatorType,code.toString());
    }

    public static List<CodeInfo> getCodeList(){
        return CodesItem.getCodeList(CodesItem.operatorType);
    }

    public static final OperatorType getObject(String code){
        Map map=(Map)mapCodeObject.get(CodesItem.operatorType);
        return map==null?null:(OperatorType)map.get(code);
    }

    private static final void fillObjectToMap(){
        List<CodeInfo> listCode = getCodeFromDB(CodesItem.operatorType);

        Map map = new HashMap(listCode.size());
        String temp = null;
        Map map2 = new HashMap(listCode.size());
        for (int i=0; i < listCode.size(); i++){
            CodeInfo codeInfo = listCode.get(i);
            temp = codeInfo.getCiSpCode();
            map.put(temp, codeInfo.getCiSpName());
            map2.put(temp, new OperatorType(temp));
        }
        mapCategoryCode.put(CodesItem.operatorType, map);
        mapCodeObject.put(CodesItem.operatorType, map2);
    }

    /**新增<XinZeng>  */
    public static final String XinZeng                                 		= "01";
    /**修改<XiuGai>  */
    public static final String XiuGai                                  		= "02";
    /**删除<ShanChu>  */
    public static final String ShanChu                                 		= "03";
}

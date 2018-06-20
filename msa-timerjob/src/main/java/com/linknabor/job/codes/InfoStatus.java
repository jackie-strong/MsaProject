package com.linknabor.job.codes;

import com.linknabor.job.model.CodeInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoStatus extends CodesItem{
    private static final Log logger = LogFactory.getLog(InfoStatus.class);

    static {
        fillObjectToMap();
    }
    private String code;
    private String category;

    public InfoStatus(String code){
        this.category=CodesItem.infoStatus;
        this.code=code;
    }

    public static String getValue(String code){
        return CodesItem.getValue(CodesItem.infoStatus, code);
    }
    public static String getValue(InfoStatus code){
        return CodesItem.getValue(CodesItem.infoStatus,code.toString());
    }

    public static List<CodeInfo> getCodeList(){
        return CodesItem.getCodeList(CodesItem.infoStatus);
    }

    public static final InfoStatus getObject(String code){
        Map map=(Map)mapCodeObject.get(CodesItem.infoStatus);
        return map==null?null:(InfoStatus)map.get(code);
    }

    private static final void fillObjectToMap(){
        List<CodeInfo> listCode = getCodeFromDB(CodesItem.infoStatus);
        Map map = new HashMap(listCode.size());
        String temp = null;
        Map map2 = new HashMap(listCode.size());
        for (int i=0; i < listCode.size(); i++){
            CodeInfo codeInfo = listCode.get(i);
            temp = codeInfo.getCiSpCode();
            map.put(temp, codeInfo.getCiSpName());
            map2.put(temp, new InfoStatus(temp));
        }
        mapCategoryCode.put(CodesItem.infoStatus, map);
        mapCodeObject.put(CodesItem.infoStatus, map2);
    }

    /**正常<ZhengChang>  */
    public static final String ZhengChang                              		= "0";
    /**注销<ZhuXiao>  */
    public static final String ZhuXiao                                 		= "1";
}

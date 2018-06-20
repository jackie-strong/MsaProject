package com.linknabor.job.codes;

import com.linknabor.cloud.msa.common.exception.BaseException;
import com.linknabor.job.mapper.CodeInfoMapper;
import com.linknabor.job.model.CodeInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class CodesItem {

    private static final Log logger = LogFactory.getLog(CodesItem.class);

    @Autowired
    private CodeInfoMapper codeInfoMapper;

    protected static final  Map mapCategoryCode = new HashMap(200);
    protected static final  Map mapCodeObject = new HashMap(200);

    //操作类型
    protected static final String operatorType = new String("101");
    //基础信息状态
    protected static final String infoStatus = new String("39");

    public static CodesItem codesItem;

    @PostConstruct
    public void init() {
        codesItem = this;
        codesItem.codeInfoMapper = this.codeInfoMapper;
    }

    protected static String getValue(String category,String code){
        Map map=(Map)mapCategoryCode.get(category);
        if(map==null) return "";
        String temp=(String)map.get(code);
        return (temp==null)? "" : temp;
    }

    public static List<CodeInfo> getCodeList(String categoryCode){
        List<CodeInfo> list = new ArrayList<CodeInfo>();
        Map mp = (Map)mapCategoryCode.get(categoryCode);
        if(mp==null) return list;
        String temp;
        for (Iterator it = mp.keySet().iterator(); it.hasNext();){
            temp = (String)it.next();
            CodeInfo codeInfo = new CodeInfo();
            codeInfo.setCiSpClass(categoryCode);
            codeInfo.setCiSpCode(temp);
            codeInfo.setCiSpName((String)mp.get(temp));
            list.add(codeInfo);
        }

        //排序
        Collections.sort(list, new Comparator<CodeInfo>() {
            @Override
            public int compare(CodeInfo o1, CodeInfo o2) {
                int i = o1.getCiSpCode().compareTo(o2.getCiSpCode());
                if (i==0) {
                    return o1.getCiSpName().compareTo(o2.getCiSpName());
                }
                return i;
            }
        });

        return list;
    }

    public static final List<CodeInfo> getCodeFromDB(String category) {
        List<CodeInfo> list = codesItem.codeInfoMapper.selectByClass(category);
        if(list.size()<1){
            throw new BaseException("当前使用的代码项在数据库无法取到 code="+ category);
        }
        return list;
    }
}

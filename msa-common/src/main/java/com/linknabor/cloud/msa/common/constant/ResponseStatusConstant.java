package com.linknabor.cloud.msa.common.constant;

public interface ResponseStatusConstant {
    /**
     * 非体系内定义异常.
     */
    Integer EX_OTHER_CODE = 500;

    /**
     * 默认成功
     */
    int SUCCESS = 200;
    String SUCCESS_MESSAGE = "SUCCESS";


    /**
     * 返回成功，空数据
     */
    int SUCCESS_NO_DATA = 10201;
    String SUCCESS_NO_DATA_MESSAGE = "No data returned!";
}

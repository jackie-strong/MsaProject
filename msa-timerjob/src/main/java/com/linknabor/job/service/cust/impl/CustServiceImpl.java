package com.linknabor.job.service.cust.impl;

import com.linknabor.cloud.msa.common.exception.BaseException;
import com.linknabor.cloud.msa.common.utils.PrimayKeyUtils;
import com.linknabor.job.codes.InfoStatus;
import com.linknabor.job.codes.OperatorType;
import com.linknabor.job.mapper.MsaBaseCustInfoMapper;
import com.linknabor.job.mapper.MsaCfgMchInfoMapper;
import com.linknabor.job.mapper.MsaCfgSystemInfoMapper;
import com.linknabor.job.model.MsaBaseCustInfo;
import com.linknabor.job.model.MsaCfgMchInfo;
import com.linknabor.job.model.MsaCfgSystemInfo;
import com.linknabor.job.service.cust.CustService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.util.StringUtil;

@Service("custService")
public class CustServiceImpl implements CustService{

    private static Logger logger = LoggerFactory.getLogger(CustServiceImpl.class);

    @Autowired
    MsaBaseCustInfoMapper msaBaseCustInfoMapper;

    @Autowired
    MsaCfgMchInfoMapper msaCfgMchInfoMapper;

    @Autowired
    MsaCfgSystemInfoMapper msaCfgSystemInfoMapper;

    @Override
    public int synCustInfo(MsaBaseCustInfo custInfo) {
        int flag = 0;
        if (null != custInfo) {
            //1.根据appid查询当前请求是否在授权表中
            MsaCfgSystemInfo systemInfo = msaCfgSystemInfoMapper.selectByPrimaryKey(custInfo.getAppId());
            //如果存在，则继续往下执行，否则返回错误
            if(systemInfo != null) {
                MsaBaseCustInfo checkCustInfo = msaBaseCustInfoMapper.selectByOriginId(custInfo.getOriginId(), custInfo.getAppId());

                //获取当前需要同步的数据状态
                String cust_state = custInfo.getCustState();
                if (OperatorType.XinZeng.toString().equals(cust_state)
                        || OperatorType.XiuGai.toString().equals(cust_state)) { //新增、修改

                    custInfo.setCustState(InfoStatus.ZhengChang.toString());

                    if (!StringUtil.isEmpty(checkCustInfo.getCustId())) { //如果已经存在，则去更新
                        custInfo.setCustId(checkCustInfo.getCustId());
                        flag = msaBaseCustInfoMapper.updateByPrimaryKeySelective(custInfo);
                    } else {
                        custInfo.setCustId(PrimayKeyUtils.getUuid());
                        flag = msaBaseCustInfoMapper.insertSelective(custInfo);
                    }
                }else if(OperatorType.ShanChu.toString().equals(cust_state)) { //删除
                    if (!StringUtil.isEmpty(checkCustInfo.getCustId())) {
                        flag = msaBaseCustInfoMapper.deleteByPrimaryKey(checkCustInfo.getCustId());
                    }
                } else {
                    throw new BaseException("不合法的数据状态");
                }
            } else {
                throw new BaseException("请求appid不正确，请传入正确参数");
            }
        } else {
            throw new BaseException("请求集合不能为空");
        }

        return flag;
    }

    @Override
    public int synMchInfo(MsaCfgMchInfo mchInfo) {
        int flag = 0;
        if (null != mchInfo) {
            //1.根据appid查询当前请求是否在授权表中
            MsaCfgSystemInfo systemInfo = msaCfgSystemInfoMapper.selectByPrimaryKey(mchInfo.getAppId());
            //如果存在，则继续往下执行，否则返回错误
            if(systemInfo != null) {
                MsaBaseCustInfo checkCustInfo = msaBaseCustInfoMapper.selectByOriginId(mchInfo.getOriginId(), mchInfo.getAppId());
                if (checkCustInfo != null) {
                    MsaCfgMchInfo checkMchInfo = msaCfgMchInfoMapper.selectByCustIdAndMchNo(checkCustInfo.getCustId(), mchInfo.getMchNo());
                    String mch_state = mchInfo.getMchState();
                    if (OperatorType.XinZeng.toString().equals(mch_state)
                            || OperatorType.XiuGai.toString().equals(mch_state)) { //新增、修改

                        mchInfo.setCustId(checkCustInfo.getCustId());
                        mchInfo.setMchState(InfoStatus.ZhengChang.toString());

                        if (!StringUtil.isEmpty(checkMchInfo.getMchId())) { //如果已经存在，则去更新
                            mchInfo.setMchId(checkMchInfo.getMchId());
                            flag = msaCfgMchInfoMapper.updateByPrimaryKeySelective(mchInfo);
                        } else {
                            mchInfo.setMchId(PrimayKeyUtils.getUuid());
                            flag = msaCfgMchInfoMapper.insertSelective(mchInfo);
                        }
                    } else if(OperatorType.ShanChu.toString().equals(mch_state)) { //删除
                        if (!StringUtil.isEmpty(checkMchInfo.getMchId())) {
                            flag = msaCfgMchInfoMapper.deleteByPrimaryKey(checkMchInfo.getMchId());
                        }
                    } else {
                        throw new BaseException("不合法的数据状态");
                    }
                } else {
                    throw new BaseException("客户信息为空");
                }
            } else {
                throw new BaseException("请求appid不正确，请传入正确参数");
            }
        } else {
            throw new BaseException("请求集合不能为空");
        }

        return flag;
    }
}

package com.linknabor.cloud.msa.common.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * 共通Mapper.
 * @param <T>
 */
public interface CommonMapper<T> extends SelectByIdsMapper<T>,Mapper<T> {
}

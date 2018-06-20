package com.linknabor.job.mapper;

import com.linknabor.job.model.CodeInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeInfoMapper {

    List<CodeInfo> selectByClass(@Param("ciSpClass") String ciSpClass);
}
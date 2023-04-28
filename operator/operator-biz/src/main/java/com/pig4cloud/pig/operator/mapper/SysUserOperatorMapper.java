package com.pig4cloud.pig.operator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pig4cloud.pig.operator.api.entity.SysUserOperator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserOperatorMapper extends BaseMapper<SysUserOperator> {
	boolean deleteSysUserOperatorByOperatorId(@Param("operatorId") Long operatorId);

}

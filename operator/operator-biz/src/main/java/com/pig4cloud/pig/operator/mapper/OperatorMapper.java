package com.pig4cloud.pig.operator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.operator.api.entity.Operator;
import com.pig4cloud.pig.operator.api.vo.OperatorVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface OperatorMapper extends BaseMapper<Operator> {

	/**
	 * 分页查询当前User的Secret
	 *
	 * @param page   page
	 * @param userId userId
	 * @return IPage<List < SecretVO>>
	 */
	IPage<OperatorVO> getOperatorPageByUserId(Page page, @Param("userId") Long userId);
}

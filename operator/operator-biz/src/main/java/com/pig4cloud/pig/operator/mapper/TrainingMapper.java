package com.pig4cloud.pig.operator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.operator.api.entity.Operator;
import com.pig4cloud.pig.operator.api.vo.OperatorVO;
import com.pig4cloud.pig.operator.api.vo.TrainingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface TrainingMapper extends BaseMapper<Operator> {

	/**
	 * 分页查询当前User的TrainingVO
	 *
	 * @param page   page
	 * @param userId userId
	 * @return TrainingVO集合
	 */
	IPage<TrainingVO> getTrainingPageByUserId(Page page, @Param("userId") Long userId);
}

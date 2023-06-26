package com.pig4cloud.pig.operator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.operator.api.entity.Workflow;
import com.pig4cloud.pig.operator.api.vo.OperatorVO;
import com.pig4cloud.pig.operator.api.vo.WorkflowVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface WorkflowMapper extends BaseMapper<Workflow> {

	/**
	 * 分页查询当前User的Workflow
	 *
	 * @param page   page
	 * @param userId userId
	 * @return IPage<List < SecretVO>>
	 */
	IPage<WorkflowVO> getWorkflowPageByUserId(Page page, @Param("userId") Long userId);
}

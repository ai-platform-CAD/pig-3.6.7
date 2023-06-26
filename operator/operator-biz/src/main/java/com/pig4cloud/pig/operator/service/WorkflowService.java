package com.pig4cloud.pig.operator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.operator.api.dto.WorkflowDTO;
import com.pig4cloud.pig.operator.api.entity.Workflow;
import com.pig4cloud.pig.operator.api.vo.OperatorVO;
import com.pig4cloud.pig.operator.api.vo.WorkflowVO;


public interface WorkflowService extends IService<Workflow> {
	/**
	 * 新增
	 *
	 * @param workflowDTO workflowDTO
	 * @param userId      userId
	 * @return 成功True，失败False
	 */
	boolean saveWorkflow(WorkflowDTO workflowDTO, Long userId);

	/**
	 * 删除
	 *
	 * @param workflowId workflowId
	 * @return 成功True，失败False
	 */
	boolean removeWorkflowById(Long workflowId);

	/**
	 * 修改
	 *
	 * @param workflowDTO workflowDTO
	 * @return 成功True，失败False
	 */
	boolean updateWorkflow(WorkflowDTO workflowDTO);

	/**
	 * 分页查询
	 *
	 * @param page   page
	 * @param userId userId
	 * @return IPage<List < OperatorVO>>
	 */
	IPage<WorkflowVO> getWorkflowPageByUserId(Page page, Long userId);

}

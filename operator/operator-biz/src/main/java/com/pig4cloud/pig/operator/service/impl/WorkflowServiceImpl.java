package com.pig4cloud.pig.operator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.operator.api.dto.WorkflowDTO;
import com.pig4cloud.pig.operator.api.entity.Workflow;
import com.pig4cloud.pig.operator.api.vo.WorkflowVO;
import com.pig4cloud.pig.operator.mapper.SysUserOperatorMapper;
import com.pig4cloud.pig.operator.mapper.WorkflowMapper;
import com.pig4cloud.pig.operator.service.WorkflowService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class WorkflowServiceImpl extends ServiceImpl<WorkflowMapper, Workflow> implements WorkflowService {
	private final WorkflowMapper workflowMapper;

	@Override
	public boolean saveWorkflow(WorkflowDTO workflowDTO, Long userId) {
		Workflow workflow = new Workflow();
		BeanUtils.copyProperties(workflowDTO, workflow);
		workflow.setUserId(userId);
		log.info("Saving workflow {}", workflow);
		// 在数据库中创建
		baseMapper.insert(workflow);
		return true;
	}

	@Override
	public boolean removeWorkflowById(Long workflowId) {
		log.info("Removing workflowId id={}", workflowId);
		// 从数据库中移除
		baseMapper.deleteById(workflowId);
		return true;
	}

	@Override
	public boolean updateWorkflow(WorkflowDTO workflowDTO) {
		log.info("Updating workflow {}", workflowDTO);
		// 复制DTO属性至Entity
		Workflow workflow = new Workflow();
		BeanUtils.copyProperties(workflowDTO, workflow);
		// 在数据库中修改
		baseMapper.updateById(workflow);
		return true;
	}

	@Override
	public IPage<WorkflowVO> getWorkflowPageByUserId(Page page, Long userId) {
		return workflowMapper.getWorkflowPageByUserId(page, userId);
	}

}

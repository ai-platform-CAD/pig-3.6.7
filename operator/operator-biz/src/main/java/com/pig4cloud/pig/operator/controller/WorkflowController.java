package com.pig4cloud.pig.operator.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.common.security.service.PigUser;
import com.pig4cloud.pig.common.security.util.SecurityUtils;
import com.pig4cloud.pig.operator.api.dto.WorkflowDTO;
import com.pig4cloud.pig.operator.api.vo.WorkflowVO;
import com.pig4cloud.pig.operator.service.WorkflowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/workflow")
@Tag(name = "工作流表管理")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class WorkflowController {

	private final WorkflowService workflowService;

	/**
	 * 分页查询
	 *
	 * @param page 分页对象
	 * @return
	 */
	@Operation(summary = "分页查询", description = "分页查询")
	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission('workflow_manage_get')")
	public R<IPage<WorkflowVO>> getPage(Page page) {
		PigUser user = SecurityUtils.getUser();
		return R.ok(workflowService.getWorkflowPageByUserId(page, user.getId()));
	}

	/**
	 * id查询
	 *
	 * @param workflowId workflowId
	 * @return R
	 */
	@Operation(summary = "通过id查询", description = "通过id查询")
	@GetMapping("/{workflowId}")
	@PreAuthorize("@pms.hasPermission('workflow_manage_get')")
	public R getById(@PathVariable("workflowId") Long workflowId) {
		return R.ok(workflowService.getById(workflowId));
	}

	/**
	 * 新增
	 *
	 * @param workflowDTO workflowDTO
	 * @return R
	 */
	@Operation(summary = "新增工作流", description = "新增工作流")
	@SysLog("新增工作流")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('workflow_manage_add')")
	@Transactional
	public R save(@RequestBody WorkflowDTO workflowDTO) {
		PigUser user = SecurityUtils.getUser();
		
		return R.ok(workflowService.saveWorkflow(workflowDTO, user.getId()));
	}

	/**
	 * 修改
	 *
	 * @param workflowDTO workflowDTO
	 * @return R
	 */
	@Operation(summary = "修改工作流", description = "修改工作流子")
	@SysLog("修改工作流")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('workflow_manage_edit')")
	public R updateById(@Valid @RequestBody WorkflowDTO workflowDTO) {
		return R.ok(workflowService.updateWorkflow(workflowDTO));
	}

	/**
	 * 通过id删除
	 *
	 * @param workflowId workflowId
	 * @return R
	 */
	@Operation(summary = "通过id删除工作流", description = "通过id删除工作流")
	@SysLog("通过id删除工作流")
	@DeleteMapping("/{workflowId}")
	@PreAuthorize("@pms.hasPermission('workflow_manage_del')")
	public R removeById(@PathVariable Long workflowId) {
		return R.ok(workflowService.removeWorkflowById(workflowId));
	}

}

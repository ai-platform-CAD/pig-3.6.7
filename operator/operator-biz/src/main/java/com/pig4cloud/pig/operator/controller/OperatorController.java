package com.pig4cloud.pig.operator.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.common.security.service.PigUser;
import com.pig4cloud.pig.common.security.util.SecurityUtils;
import com.pig4cloud.pig.operator.api.dto.OperatorDTO;
import com.pig4cloud.pig.operator.api.vo.OperatorVO;
import com.pig4cloud.pig.operator.service.OperatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/manage")
@Tag(name = "算子表管理")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class OperatorController {

	private final OperatorService operatorService;

	/**
	 * 分页查询
	 *
	 * @param page 分页对象
	 * @return
	 */
	@Operation(summary = "分页查询", description = "分页查询")
	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission('operator_manage_get')")
	public R<IPage<OperatorVO>> getOperatorPage(Page page) {
		PigUser user = SecurityUtils.getUser();
		return R.ok(operatorService.getOperatorPageByUserId(page, user.getId()));
	}

	/**
	 * id查询
	 *
	 * @param operatorId operatorId
	 * @return R
	 */
	@Operation(summary = "通过id查询", description = "通过id查询")
	@GetMapping("/{operatorId}")
	@PreAuthorize("@pms.hasPermission('operator_manage_get')")
	public R getById(@PathVariable("operatorId") Long operatorId) {
		return R.ok(operatorService.getById(operatorId));
	}

	/**
	 * 新增
	 *
	 * @param operatorDTO operatorDTO
	 * @return R
	 */
	@Operation(summary = "新增算子", description = "新增算子")
	@SysLog("新增算子")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('operator_manage_add')")
	public R save(@RequestBody OperatorDTO operatorDTO) {
		PigUser user = SecurityUtils.getUser();
		return R.ok(operatorService.saveOperator(operatorDTO, user.getId()));
	}

	/**
	 * 修改
	 *
	 * @param operatorDTO operatorDTO
	 * @return R
	 */
	@Operation(summary = "修改算子", description = "修改算子")
	@SysLog("修改算子")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('operator_manage_edit')")
	public R updateById(@Valid @RequestBody OperatorDTO operatorDTO) {
		return R.ok(operatorService.updateOperator(operatorDTO));
	}

	/**
	 * 通过id删除算子表
	 *
	 * @param operatorId operatorId
	 * @return R
	 */
	@Operation(summary = "通过id删除算子", description = "通过id删除算子")
	@SysLog("通过id删除算子")
	@DeleteMapping("/{operatorId}")
	@PreAuthorize("@pms.hasPermission('operator_manage_del')")
	public R removeById(@PathVariable Long operatorId) {
		return R.ok(operatorService.removeOperatorById(operatorId));
	}

}

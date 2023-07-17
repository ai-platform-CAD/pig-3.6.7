package com.pig4cloud.pig.operator.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.operator.api.dto.TrainingProjectDTO;
import com.pig4cloud.pig.operator.api.vo.TrainingProjectVO;
import com.pig4cloud.pig.operator.service.TrainingProjectService;
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
@RequestMapping("/project")
@Tag(name = "训练项目表管理")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class TrainingProjectController {

	private final TrainingProjectService trainingProjectService;

	/**
	 * 新增
	 *
	 * @param trainingProjectDTO trainingProjectDTO
	 * @return R
	 */
	@Operation(summary = "新增", description = "新增")
	@SysLog("新增")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('project_manage_add')")
	public R save(@RequestBody TrainingProjectDTO trainingProjectDTO) {
		return R.ok(trainingProjectService.save(trainingProjectDTO));
	}

	/**
	 * 通过id删除
	 *
	 * @param id id
	 * @return R
	 */
	@Operation(summary = "通过id删除", description = "通过id删除")
	@SysLog("通过id删除")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('project_manage_del')")
	public R removeById(@PathVariable Long id) {
		return R.ok(trainingProjectService.removeById(id));
	}

	/**
	 * 修改
	 *
	 * @param trainingProjectDTO trainingProjectDTO
	 * @return R
	 */
	@Operation(summary = "修改", description = "修改")
	@SysLog("修改")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('project_manage_edit')")
	public R updateById(@Valid @RequestBody TrainingProjectDTO trainingProjectDTO) {
		return R.ok(trainingProjectService.update(trainingProjectDTO));
	}


	/**
	 * id查询
	 *
	 * @param id id
	 * @return R
	 */
	@Operation(summary = "通过id查询", description = "通过id查询")
	@GetMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('project_manage_get')")
	public R getById(@PathVariable("id") Long id) {
		return R.ok(trainingProjectService.getById(id));
	}

	/**
	 * 分页查询
	 *
	 * @param page 分页对象
	 * @return
	 */
	@Operation(summary = "分页查询", description = "分页查询")
	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission('project_manage_get')")
	public R<IPage<TrainingProjectVO>> getPage(Page page) {
		return R.ok(trainingProjectService.getPage(page));
	}
}

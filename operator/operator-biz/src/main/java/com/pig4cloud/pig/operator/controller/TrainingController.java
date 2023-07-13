package com.pig4cloud.pig.operator.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.common.security.service.PigUser;
import com.pig4cloud.pig.common.security.util.SecurityUtils;
import com.pig4cloud.pig.operator.api.dto.TrainingDTO;
import com.pig4cloud.pig.operator.api.vo.TrainingVO;
import com.pig4cloud.pig.operator.service.TrainingService;
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
@RequestMapping("/training")
@Tag(name = "训练表管理")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class TrainingController {

	private final TrainingService trainingService;

	/**
	 * 分页查询
	 *
	 * @param page 分页对象
	 * @return
	 */
	@Operation(summary = "分页查询", description = "分页查询")
	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission('training_manage_get')")
	public R<IPage<TrainingVO>> getTrainingPage(Page page) {
		PigUser user = SecurityUtils.getUser();
		return R.ok(trainingService.getTrainingPageByUserId(page, user.getId()));
	}

	/**
	 * id查询
	 *
	 * @param trainingId trainingId
	 * @return R
	 */
	@Operation(summary = "通过id查询", description = "通过id查询")
	@GetMapping("/{trainingId}")
	@PreAuthorize("@pms.hasPermission('training_manage_get')")
	public R getById(@PathVariable("trainingId") Long trainingId) {
		return R.ok(trainingService.getById(trainingId));
	}

	/**
	 * 新增
	 *
	 * @param trainingDTO trainingDTO
	 * @return R
	 */
	@Operation(summary = "新增", description = "新增训练")
	@SysLog("新增训练")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('training_manage_add')")
	public R save(@RequestBody TrainingDTO trainingDTO) {
		PigUser user = SecurityUtils.getUser();
		return R.ok(trainingService.saveTraining(trainingDTO, user.getId()));
	}

	/**
	 * 修改
	 *
	 * @param trainingDTO trainingDTO
	 * @return R
	 */
	@Operation(summary = "修改训练", description = "修改训练")
	@SysLog("修改训练")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('training_manage_edit')")
	public R updateById(@Valid @RequestBody TrainingDTO trainingDTO) {
		return R.ok(trainingService.updateTraining(trainingDTO));
	}

	/**
	 * 通过id删除训练表
	 *
	 * @param trainingId trainingId
	 * @return R
	 */
	@Operation(summary = "通过id删除训练", description = "通过id删除训练")
	@SysLog("通过id删除训练")
	@DeleteMapping("/{trainingId}")
	@PreAuthorize("@pms.hasPermission('training_manage_del')")
	public R removeById(@PathVariable Long trainingId) {
		return R.ok(trainingService.removeTrainingById(trainingId));
	}

}

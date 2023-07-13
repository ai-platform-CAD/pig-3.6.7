package com.pig4cloud.pig.operator.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.operator.api.dto.DockerImageDTO;
import com.pig4cloud.pig.operator.api.vo.DockerImageVO;
import com.pig4cloud.pig.operator.service.DockerImageService;
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
@RequestMapping("/image")
@Tag(name = "DOCKER镜像表管理")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class DockerImageController {

	private final DockerImageService dockerImageService;

	/**
	 * 分页查询
	 *
	 * @param page 分页对象
	 * @return
	 */
	@Operation(summary = "分页查询", description = "分页查询")
	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission('image_manage_get')")
	public R<IPage<DockerImageVO>> getImagePage(Page page) {
		return R.ok(dockerImageService.getImagePage(page));
	}

	/**
	 * id查询
	 *
	 * @param operatorId operatorId
	 * @return R
	 */
	@Operation(summary = "通过id查询", description = "通过id查询")
	@GetMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('image_manage_get')")
	public R getById(@PathVariable("id") Long id) {
		return R.ok(dockerImageService.getById(id));
	}

	/**
	 * 新增
	 *
	 * @param dockerImageDTO dockerImageDTO
	 * @return R
	 */
	@Operation(summary = "新增镜像", description = "新增镜像")
	@SysLog("新增镜像")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('operator_manage_add')")
	public R save(@RequestBody DockerImageDTO dockerImageDTO) {
		return R.ok(dockerImageService.saveImage(dockerImageDTO));
	}

	/**
	 * 修改
	 *
	 * @param dockerImageDTO dockerImageDTO
	 * @return R
	 */
	@Operation(summary = "修改镜像", description = "修改镜像")
	@SysLog("修改镜像")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('image_manage_edit')")
	public R updateById(@Valid @RequestBody DockerImageDTO dockerImageDTO) {
		return R.ok(dockerImageService.updateImage(dockerImageDTO));
	}

	/**
	 * 通过id删除
	 *
	 * @param id id
	 * @return R
	 */
	@Operation(summary = "通过id删除镜像", description = "通过id删除镜像")
	@SysLog("通过id删除镜像")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('image_manage_del')")
	public R removeById(@PathVariable Long id) {
		return R.ok(dockerImageService.removeImageById(id));
	}

}

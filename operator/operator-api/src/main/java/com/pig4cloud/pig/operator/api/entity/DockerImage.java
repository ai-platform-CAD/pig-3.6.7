package com.pig4cloud.pig.operator.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pig4cloud.pig.common.mybatis.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("docker_image")
@Schema(name = "DOCKER镜像表")
public class DockerImage extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.ASSIGN_ID)
	@Schema(name = "ID")
	private Long id;

	@Schema(name = "DOCKER镜像ID")
	private String imageId;

	@Schema(name = "DOCKER镜像TAG")
	private String tag;

	@Schema(name = "DOCKER镜像SIZE(Byte)")
	private Long size;

	@Schema(name = "DOCKER镜像TAG")
	private Long tag;

	@Schema(name = "DOCKER镜像SIZE")
	private Long size;

	@Schema(name = "PYTHON版本")
	private String pythonVersion;

	@Schema(name = "CUDA版本")
	private String cudaVersion;

	@Schema(name = "深度学习框架")
	private String framework;

	@Schema(name = "其他参数")
	private String parameters;

}

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
@TableName("training_project")
@Schema(name = "训练项目表")
public class TrainingProject extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.ASSIGN_ID)
	@Schema(name = "训练项目ID")
	private Long projectId;

	@Schema(name = "训练项目名称")
	private String projectName;

	@Schema(name = "训练容器")
	private String trainingContainer;

	@Schema(name = "训练脚本")
	private String trainingScript;

	@Schema(name = "训练指令")
	private String trainingCommand;

	@Schema(name = "输出")
	private String trainingOutput;

}

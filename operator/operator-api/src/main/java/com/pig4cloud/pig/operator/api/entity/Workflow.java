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
@TableName("workflow")
@Schema(name = "工作流表")
public class Workflow extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.ASSIGN_ID)
	@Schema(name = "workflowId")
	private Long workflowId;

	@Schema(name = "工作流名称")
	private String workflowName;

	@Schema(name = "DATA内容")
	private String data;

	@Schema(name = "工作流所属用户ID")
	private Long userId;

}

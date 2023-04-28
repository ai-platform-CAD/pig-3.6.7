package com.pig4cloud.pig.operator.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user_operator")
@Schema(name = "用户算子表")
public class SysUserOperator extends Model<SysUserOperator> {
	private static final long serialVersionUID = 1L;

	@Schema(name = "userId")
	private Long userId;

	@Schema(name = "operatorId")
	private Long operatorId;
}

package com.pig4cloud.pig.operator.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class WorkflowVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long workflowId;

	private String workflowName;

	private String data;

	private LocalDateTime createTime;
}

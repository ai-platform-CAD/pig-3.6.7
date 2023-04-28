package com.pig4cloud.pig.operator.api.vo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OperatorVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long operatorId;

	private String operatorName;

	private String jsonContent;

	private LocalDateTime createTime;
}

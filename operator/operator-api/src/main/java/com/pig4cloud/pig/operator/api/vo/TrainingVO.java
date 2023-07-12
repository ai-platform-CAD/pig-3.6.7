package com.pig4cloud.pig.operator.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TrainingVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long trainingId;

	private String trainingName;

	private String trainingContainer;

	private String trainingScript;

	private String trainingCommand;

	private String trainingOutput;

	private LocalDateTime createTime;
}

package com.pig4cloud.pig.operator.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TrainingProjectVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long projectId;

	private String projectName;

	private Long projectData;

}

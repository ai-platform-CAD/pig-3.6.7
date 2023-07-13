package com.pig4cloud.pig.operator.api.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class DockerImageVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long imageId;

	private Long tag;

	private Long size;

	private String pythonVersion;

	private String cudaVersion;

	private String framework;

	private String parameters;

}

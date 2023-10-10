package com.pig4cloud.pig.operator.api.docker;

import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.ContainerPort;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
@Schema(name = "DOCKER进程")
public class DockerProcess {
	private String id;

	private String image;

	private String command;

	private Long created;

	private String status;

	private ContainerPort[] ports;

	public DockerProcess(Container container) {
		// 从Docker container创建DockerProcess
		this.id = container.getId();
		this.image = container.getImage();
		this.command = container.getCommand();
		this.created = container.getCreated();
		this.status = container.getStatus();
		this.ports = container.getPorts();
	}

}

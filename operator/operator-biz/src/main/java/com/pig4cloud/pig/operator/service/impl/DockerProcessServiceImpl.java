package com.pig4cloud.pig.operator.service.impl;

import com.github.dockerjava.api.command.InspectImageResponse;
import com.pig4cloud.pig.operator.api.docker.DockerProcess;
import com.pig4cloud.pig.operator.api.entity.DockerImage;
import com.pig4cloud.pig.operator.client.DockerAdapter;
import com.pig4cloud.pig.operator.service.DockerProcessService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class DockerProcessServiceImpl implements DockerProcessService {

	@Override
	public List<DockerProcess> listProcesses() {
		log.info("listProcess begin");
		// build image in docker

		log.info("listProcess finish");
		return null;
	}

	private List<DockerProcess> _listProcess() {
		List<DockerProcess> processList = new ArrayList<>();
		DockerAdapter dockerAdapter = DockerAdapter.getInstance();

		return null;
	}


}

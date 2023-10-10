package com.pig4cloud.pig.operator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.operator.api.docker.DockerProcess;
import com.pig4cloud.pig.operator.api.dto.DockerImageDTO;
import com.pig4cloud.pig.operator.api.entity.DockerImage;
import com.pig4cloud.pig.operator.api.vo.DockerImageVO;

import java.util.List;


public interface DockerProcessService {
	/**
	 * 新增
	 *
	 * @param dockerImageDTO dockerImageDTO
	 * @return 成功True，失败False
	 */
	List<DockerProcess> listProcesses();


}

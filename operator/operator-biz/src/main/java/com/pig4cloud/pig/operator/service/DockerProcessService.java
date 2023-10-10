package com.pig4cloud.pig.operator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.operator.api.dto.DockerImageDTO;
import com.pig4cloud.pig.operator.api.entity.DockerImage;
import com.pig4cloud.pig.operator.api.vo.DockerImageVO;


public interface DockerProcessService extends IService<DockerImage> {
	/**
	 * 新增
	 *
	 * @param dockerImageDTO dockerImageDTO
	 * @return 成功True，失败False
	 */
	boolean saveImage(DockerImageDTO dockerImageDTO);

	/**
	 * 删除
	 *
	 * @param id id
	 * @return 成功True，失败False
	 */
	boolean removeImageById(Long id);

	/**
	 * 修改
	 *
	 * @param dockerImageDTO dockerImageDTO
	 * @return 成功True，失败False
	 */
	boolean updateImage(DockerImageDTO dockerImageDTO);

	/**
	 * 分页查询
	 *
	 * @param page page
	 * @return DockerImage集合
	 */
	IPage<DockerImageVO> getImagePage(Page page);

}

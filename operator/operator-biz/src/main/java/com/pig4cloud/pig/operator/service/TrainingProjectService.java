package com.pig4cloud.pig.operator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.operator.api.dto.TrainingDTO;
import com.pig4cloud.pig.operator.api.dto.TrainingProjectDTO;
import com.pig4cloud.pig.operator.api.entity.TrainingProject;
import com.pig4cloud.pig.operator.api.vo.TrainingProjectVO;


public interface TrainingProjectService extends IService<TrainingProject> {
	/**
	 * 新增
	 *
	 * @param trainingProjectDTO trainingProjectDTO
	 * @return 成功True，失败False
	 */
	boolean save(TrainingProjectDTO trainingProjectDTO);

	/**
	 * 删除
	 *
	 * @param id id
	 * @return 成功True，失败False
	 */
	boolean removeById(Long id);

	/**
	 * 修改
	 *
	 * @param trainingProjectDTO trainingProjectDTO
	 * @return 成功True，失败False
	 */
	boolean update(TrainingProjectDTO trainingProjectDTO);

	/**
	 * 分页查询
	 *
	 * @param page page
	 * @return TrainingVO集合
	 */
	IPage<TrainingProjectVO> getPage(Page page);

}

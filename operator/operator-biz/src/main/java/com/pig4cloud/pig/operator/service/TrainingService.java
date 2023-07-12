package com.pig4cloud.pig.operator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.operator.api.dto.TrainingDTO;
import com.pig4cloud.pig.operator.api.entity.Training;
import com.pig4cloud.pig.operator.api.vo.TrainingVO;


public interface TrainingService extends IService<Training> {
	/**
	 * 新增
	 *
	 * @param trainingDTO TrainingDTO
	 * @param userId      用户ID
	 * @return 成功True，失败False
	 */
	boolean saveTraining(TrainingDTO trainingDTO, Long userId);

	/**
	 * 删除
	 *
	 * @param trainingId 训练ID
	 * @return 成功True，失败False
	 */
	boolean removeTrainingById(Long trainingId);

	/**
	 * 修改
	 *
	 * @param trainingDTO TrainingDTO
	 * @return 成功True，失败False
	 */
	boolean updateTraining(TrainingDTO trainingDTO);

	/**
	 * 分页查询
	 *
	 * @param page   page
	 * @param userId userId
	 * @return TrainingVO集合
	 */
	IPage<TrainingVO> getTrainingPageByUserId(Page page, Long userId);

}

package com.pig4cloud.pig.operator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.operator.api.dto.TrainingDTO;
import com.pig4cloud.pig.operator.api.vo.TrainingVO;
import com.pig4cloud.pig.operator.service.TrainingService;

public class TrainingServiceImpl implements TrainingService {
	@Override
	public boolean saveTraining(TrainingDTO trainingDTO, Long userId) {
		return false;
	}

	@Override
	public boolean removeTrainingById(Long trainingId) {
		return false;
	}

	@Override
	public boolean updateTraining(TrainingDTO trainingDTO) {
		return false;
	}

	@Override
	public IPage<TrainingVO> getTrainingPageByUserId(Page page, Long userId) {
		return null;
	}
}

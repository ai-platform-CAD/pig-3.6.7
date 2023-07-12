package com.pig4cloud.pig.operator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.operator.api.dto.TrainingDTO;
import com.pig4cloud.pig.operator.api.entity.Training;
import com.pig4cloud.pig.operator.api.vo.TrainingVO;
import com.pig4cloud.pig.operator.mapper.TrainingMapper;
import com.pig4cloud.pig.operator.service.TrainingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TrainingServiceImpl extends ServiceImpl<TrainingMapper, Training> implements TrainingService {
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

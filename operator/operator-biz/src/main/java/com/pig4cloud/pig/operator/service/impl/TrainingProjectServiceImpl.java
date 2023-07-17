package com.pig4cloud.pig.operator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.operator.api.dto.TrainingProjectDTO;
import com.pig4cloud.pig.operator.api.entity.TrainingProject;
import com.pig4cloud.pig.operator.api.vo.TrainingProjectVO;
import com.pig4cloud.pig.operator.mapper.TrainingProjectMapper;
import com.pig4cloud.pig.operator.service.TrainingProjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@AllArgsConstructor
public class TrainingProjectServiceImpl extends ServiceImpl<TrainingProjectMapper, TrainingProject> implements TrainingProjectService {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean save(TrainingProjectDTO trainingProjectDTO) {
		log.info("Saving TrainingProject {}", trainingProjectDTO);
		TrainingProject trainingProject = new TrainingProject();
		BeanUtils.copyProperties(trainingProjectDTO, trainingProject);
		// 在数据库中插入
		baseMapper.insert(trainingProject);
		log.info("成功在数据库中创建");
		return true;
	}

	@Override
	public boolean removeById(Long id) {
		log.info("Removing TrainingProject id={}", id);
		// 在数据库中移除
		baseMapper.deleteById(id);
		return true;
	}

	@Override
	public boolean update(TrainingProjectDTO trainingProjectDTO) {
		log.info("Updating TrainingProject {}", trainingProjectDTO);
		TrainingProject trainingProject = new TrainingProject();
		BeanUtils.copyProperties(trainingProjectDTO, trainingProject);
		// 在数据库中更新
		baseMapper.updateById(trainingProject);
		return true;
	}

	@Override
	public IPage<TrainingProjectVO> getPage(Page page) {
		log.info("Getting TrainingProjectVO page");
		return baseMapper.selectPage(page, null);
	}
}

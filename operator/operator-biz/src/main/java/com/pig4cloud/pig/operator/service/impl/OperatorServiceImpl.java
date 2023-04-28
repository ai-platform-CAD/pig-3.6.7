/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */
package com.pig4cloud.pig.operator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.operator.api.entity.Operator;
import com.pig4cloud.pig.operator.api.vo.OperatorVO;
import com.pig4cloud.pig.operator.mapper.OperatorMapper;
import com.pig4cloud.pig.operator.service.OperatorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Secret表
 *
 * @author sjh
 * @date 2023-02-27 11:06:05
 */
@Slf4j
@Service
@AllArgsConstructor
public class OperatorServiceImpl extends ServiceImpl<OperatorMapper, Operator> implements OperatorService {
	private final OperatorMapper operatorMapper;

	@Override
	public boolean saveOperator(Operator operator) {
		log.info("Saving operator {}", operator);
		// 在数据库中创建
		baseMapper.insert(operator);
		return true;
	}

	@Override
	public boolean removeOperatorById(Long operatorId) {
		log.info("Removing operatorId id={}", operatorId);
		// 从数据库中移除
		baseMapper.deleteById(operatorId);
		return true;
	}

	@Override
	public boolean updateOperator(Operator operator) {
		log.info("Updating operator {}", operator);
		// 在数据库中修改
		updateById(operator);
		return true;
	}

	@Override
	public IPage<List<OperatorVO>> getOperatorPageByUserId(Page page, Long userId) {
		return operatorMapper.getOperatorPageByUserId(page, userId);
	}

}

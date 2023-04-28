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

package com.pig4cloud.pig.operator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.operator.api.entity.Operator;
import com.pig4cloud.pig.operator.api.vo.OperatorVO;

import java.util.List;

/**
 * Secret表
 *
 * @author sjh
 * @date 2023-02-27 11:06:05
 */
public interface OperatorService extends IService<Operator> {
	/**
	 * 新增
	 *
	 * @param operator operator
	 * @return 成功True，失败False
	 */
	boolean saveOperator(Operator operator);

	/**
	 * 删除
	 *
	 * @param operatorId operatorId
	 * @return 成功True，失败False
	 */
	boolean removeOperatorById(Long operatorId);

	/**
	 * 修改
	 *
	 * @param operator operator
	 * @return 成功True，失败False
	 */
	boolean updateOperator(Operator operator);

	/**
	 * 分页查询
	 *
	 * @param page
	 * @param userId
	 * @return IPage<List < OperatorVO>>
	 */
	IPage<List<OperatorVO>> getOperatorPageByUserId(Page page, Long userId);

}

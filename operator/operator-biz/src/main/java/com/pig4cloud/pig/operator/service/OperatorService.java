package com.pig4cloud.pig.operator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig4cloud.pig.operator.api.dto.OperatorDTO;
import com.pig4cloud.pig.operator.api.entity.Operator;
import com.pig4cloud.pig.operator.api.vo.OperatorVO;


public interface OperatorService extends IService<Operator> {
	/**
	 * 新增
	 *
	 * @param operatorDTO operatorDTO
	 * @param userId      userId
	 * @return 成功True，失败False
	 */
	boolean saveOperator(OperatorDTO operatorDTO, Long userId);

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
	 * @param operatorDTO operatorDTO
	 * @return 成功True，失败False
	 */
	boolean updateOperator(OperatorDTO operatorDTO);

	/**
	 * 分页查询
	 *
	 * @param page   page
	 * @param userId userId
	 * @return IPage<List < OperatorVO>>
	 */
	IPage<OperatorVO> getOperatorPageByUserId(Page page, Long userId);

}

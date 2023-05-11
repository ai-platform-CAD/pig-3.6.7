package com.pig4cloud.pig.operator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pig4cloud.pig.operator.api.dto.OperatorDTO;
import com.pig4cloud.pig.operator.api.entity.Operator;
import com.pig4cloud.pig.operator.api.entity.SysUserOperator;
import com.pig4cloud.pig.operator.api.vo.OperatorVO;
import com.pig4cloud.pig.operator.mapper.OperatorMapper;
import com.pig4cloud.pig.operator.mapper.SysUserOperatorMapper;
import com.pig4cloud.pig.operator.service.OperatorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class OperatorServiceImpl extends ServiceImpl<OperatorMapper, Operator> implements OperatorService {
	private final SysUserOperatorMapper sysUserOperatorMapper;

	@Override
	public boolean saveOperator(OperatorDTO operatorDTO, Long userId) {
		Operator operator = new Operator();
		BeanUtils.copyProperties(operatorDTO, operator);
		log.info("Saving operator {}", operator);
		// 在数据库中创建
		// operator
		baseMapper.insert(operator);
		// sys_user_operator
		SysUserOperator sysUserOperator = new SysUserOperator();
		sysUserOperator.setOperatorId(operator.getOperatorId());
		sysUserOperator.setUserId(userId);
		sysUserOperatorMapper.insert(sysUserOperator);
		return true;
	}

	@Override
	public boolean removeOperatorById(Long operatorId) {
		log.info("Removing operatorId id={}", operatorId);
		// 从数据库中移除
		// operator
		baseMapper.deleteById(operatorId);
		// sys_user_operator
		return sysUserOperatorMapper.deleteSysUserOperatorByOperatorId(operatorId);
	}

	@Override
	public boolean updateOperator(OperatorDTO operatorDTO) {
		log.info("Updating operator {}", operatorDTO);
		// 在数据库中修改
		Operator operator = new Operator();
		BeanUtils.copyProperties(operatorDTO, operator);
		baseMapper.updateById(operator);
		return true;
	}

	@Override
	public IPage<OperatorVO> getOperatorPageByUserId(Page page, Long userId) {
		return baseMapper.getOperatorPageByUserId(page, userId);
	}

}

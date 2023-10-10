package com.pig4cloud.pig.operator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.dockerjava.api.command.InspectImageResponse;
import com.pig4cloud.pig.operator.api.dto.DockerImageDTO;
import com.pig4cloud.pig.operator.api.entity.DockerImage;
import com.pig4cloud.pig.operator.api.vo.DockerImageVO;
import com.pig4cloud.pig.operator.client.DockerAdapter;
import com.pig4cloud.pig.operator.mapper.DockerImageMapper;
import com.pig4cloud.pig.operator.service.DockerImageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@AllArgsConstructor
public class DockerProcessServiceImpl extends ServiceImpl<DockerImageMapper, DockerImage> implements DockerImageService {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean saveImage(DockerImageDTO dockerImageDTO) {
		log.info("Saving dockerImage {}", dockerImageDTO);
		// build image in docker
		DockerImage dockerImage = buildDockerImage(dockerImageDTO);
		log.info("成功在Docker中构建镜像");
		// 在数据库中插入
		baseMapper.insert(dockerImage);
		log.info("成功在数据库中创建");
		return true;
	}

	/**
	 * build image in docker
	 *
	 * @param dockerImageDTO dockerImageDTO
	 * @return dockerImage
	 */
	private DockerImage buildDockerImage(DockerImageDTO dockerImageDTO) {
		DockerImage dockerImage = new DockerImage();
		BeanUtils.copyProperties(dockerImageDTO, dockerImage);
		// 在Docker容器中构建镜像
		DockerAdapter dockerAdapter = DockerAdapter.getInstance();
		String imageId = dockerAdapter.saveImage(dockerImage.getTag());
		InspectImageResponse exec = dockerAdapter.inspectImageInfo(imageId);
		// set info
		dockerImage.setImageId(exec.getId());
		if (exec.getRepoTags() != null) {
			dockerImage.setTag(exec.getRepoTags().toString());
		}
		dockerImage.setSize(exec.getSize());
		// return
		return dockerImage;
	}

	@Override
	public boolean removeImageById(Long id) {
		log.info("Removing dockerImage id={}", id);
		// 在数据库中移除
		baseMapper.deleteById(id);
		return true;
	}

	@Override
	public boolean updateImage(DockerImageDTO dockerImageDTO) {
		log.info("Updating dockerImage {}", dockerImageDTO);
		DockerImage dockerImage = new DockerImage();
		BeanUtils.copyProperties(dockerImageDTO, dockerImage);
		// 在数据库中移除
		baseMapper.updateById(dockerImage);
		return true;
	}

	@Override
	public IPage<DockerImageVO> getImagePage(Page page) {
		log.info("Getting dockerImage page");
		return baseMapper.selectPage(page, null);
	}
}

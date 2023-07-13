package com.pig4cloud.pig.operator.client;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.BuildImageResultCallback;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.core.DockerClientBuilder;
import com.pig4cloud.pig.operator.api.entity.DockerImage;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * 单例模式、适配器模式
 */
@Slf4j
public class DockerAdapter {

    private static volatile DockerAdapter dockerAdapter;

    // volatile关键字的使用
    private static volatile DockerClient dockerClient;

    private DockerAdapter() {

    }

    public static DockerAdapter getInstance() {
        // 使用双重校验锁DCL
        if (dockerAdapter == null) {
            synchronized (DockerAdapter.class) {
                if (dockerAdapter == null) {
                    dockerAdapter = new DockerAdapter();
                    dockerClient = DockerClientBuilder.getInstance().build();
                }
            }
        }
		return dockerAdapter;
    }

    public static void main(String[] args) {

    }

    /**
     * 查询Docker镜像，并包装为DockerImage类
     *
     * @return DockerImage集合
     */
    public List<DockerImage> listImages() {
        List<DockerImage> dockerImages = new ArrayList<>();

        List<Image> images = dockerClient.listImagesCmd().exec();
        if (images != null) {
            for (Image image : images) {
                DockerImage dockerImage = new DockerImage();
                dockerImage.setImageId(image.getId());
                String[] tags = image.getRepoTags();
                if (tags != null) {
                    dockerImage.setTag(tags[0]);
                }
                dockerImage.setSize(image.getSize());
                dockerImages.add(dockerImage);
            }
        }
        return dockerImages;
    }

    /**
     * 根据Dockerfile构建镜像
     *
     * @return 构建成功的镜像ID
     */
    public String saveImage(String tag) {
        // 可以根据Dockerfile成功构建镜像
        File file = new File("/home/sjh/ai-platform/test/pig 3.6.7/db/Dockerfile");
        System.out.println(file.getAbsolutePath());
        // 本步执行较慢，考虑异步编程？
        String imageId = dockerClient.buildImageCmd()
				.withDockerfile(file)
				.withPull(true)
				.withNoCache(true)
				.withTag(tag)
				.exec(new BuildImageResultCallback())
				.awaitImageId();
        System.out.println(imageId);
        return imageId;
    }

    /**
     * @param imageId 镜像ID
     * @return 成功返回true，失败返回false
     */
    public boolean removeImage(String imageId) {
        dockerClient.removeImageCmd(imageId).exec();
        return true;
    }

}

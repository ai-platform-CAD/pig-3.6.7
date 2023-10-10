package com.pig4cloud.pig.operator.client;

import com.pig4cloud.pig.operator.api.docker.DockerProcess;
import com.pig4cloud.pig.operator.api.entity.DockerImage;
import org.junit.jupiter.api.Test;

import java.util.List;

class DockerAdapterTest {

	DockerAdapter dockerAdapter = DockerAdapter.getInstance();

    @Test
    void listImages() {
        DockerAdapter dockerAdapter = DockerAdapter.getInstance();
        List<DockerImage> dockerImages = dockerAdapter.listImages();
        dockerImages.forEach(dockerImage -> System.out.println(dockerImages));
    }

    @Test
    void saveImage() {
        DockerAdapter dockerAdapter = DockerAdapter.getInstance();
        String imageId = dockerAdapter.saveImage("pig-mysql:v2");
        System.out.println(imageId);
    }

    @Test
    void removeImage() {
        DockerAdapter dockerAdapter = DockerAdapter.getInstance();
        String imageId = dockerAdapter.saveImage("pig-mysql:v2");
        System.out.println(imageId);
        boolean b = dockerAdapter.removeImage(imageId);
        System.out.println(b);
    }

	@Test
	void inspectImageInfo() {
	}

	@Test
	void testListImages() {
	}

	@Test
	void testSaveImage() {
	}

	@Test
	void testRemoveImage() {
	}

	@Test
	void listProcess() {
		List<DockerProcess> processList = dockerAdapter.listProcesses();
		System.out.println(processList.size());
	}

	@Test
	void listAllProcesses() {
		List<DockerProcess> processList = dockerAdapter.listAllProcesses();
		System.out.println(processList.size());
	}
}
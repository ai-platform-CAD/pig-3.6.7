package com.pig4cloud.pig.operator.api.entity;

import io.kubernetes.client.openapi.models.V1PodList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class KubernetesClientTest {

	private static final KubernetesClient kubernetesClient = KubernetesClient.getInstance();

	@Test
	void getAllPodList() {
		V1PodList list =  kubernetesClient.getAllPodList();
		System.out.println(list);
	}

	@Test
	void getNamespacedPodList() {
		System.out.println(kubernetesClient.getNamespacedPodList("argo"));
	}
}
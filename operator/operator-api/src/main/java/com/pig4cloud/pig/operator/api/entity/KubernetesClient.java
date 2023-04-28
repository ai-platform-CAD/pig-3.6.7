package com.pig4cloud.pig.operator.api.entity;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.Config;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * 单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
 * <p>
 * 这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
 * <p>
 * 3、饿汉式
 * 是否 Lazy 初始化：否
 * <p>
 * 是否多线程安全：是
 * <p>
 * 实现难度：易
 * <p>
 * 描述：这种方式比较常用，但容易产生垃圾对象。
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 * 它基于 classloader 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。
 */
@Slf4j
public class KubernetesClient {

	private static final KubernetesClient kubernetesClient = new KubernetesClient();
	private static final ApiClient apiClient;

	static {
		try {
			apiClient = Config.defaultClient();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private KubernetesClient() {
	}

	public static KubernetesClient getInstance() {
		return kubernetesClient;
	}

	public V1PodList getAllPodList() {
		CoreV1Api api = new CoreV1Api(apiClient);

		try {
			V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null, null);
			return list;
		} catch (ApiException e) {
			log.error("KubernetesClient getAllPodList error:" + e.getResponseBody());
		}
		return null;
	}

	public V1PodList getNamespacedPodList(String namespace) {
		CoreV1Api api = new CoreV1Api(apiClient);
		try {
			V1PodList list = api.listNamespacedPod(namespace, null, null, null, null, null, null, null, null, null, null);
			return list;
		} catch (ApiException e) {
			log.error("KubernetesClient getNamespacedPodList error:" + e.getResponseBody());
		}
		return null;
	}

}

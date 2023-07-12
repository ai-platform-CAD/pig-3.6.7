package com.pig4cloud.pig.operator.argo.config;

import com.pig4cloud.pig.operator.argo.ArgoClientAdapter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(ArgoWorkflowConfigProperties.class)
public class ArgoWorkflowClientConfiguration {
	@Bean
	public ArgoClientAdapter argoClientAdapter(ArgoWorkflowConfigProperties argoWorkflowConfigProperties) {
		return new ArgoClientAdapter(argoWorkflowConfigProperties);
	}
}

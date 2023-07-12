package com.pig4cloud.pig.operator.argo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
@RefreshScope
@ConfigurationProperties("argo")
public class ArgoWorkflowConfigProperties {
	private String basePath;
	private String apiKey;
}

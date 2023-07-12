package com.pig4cloud.pig.operator.argo;

import com.pig4cloud.pig.operator.argo.config.ArgoWorkflowConfigProperties;
import io.argoproj.workflow.ApiClient;
import io.argoproj.workflow.Configuration;
import io.argoproj.workflow.apis.WorkflowServiceApi;
import io.argoproj.workflow.auth.ApiKeyAuth;
import io.argoproj.workflow.models.IoArgoprojWorkflowV1alpha1WorkflowCreateRequest;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
public class ArgoClientAdapter {

	@Getter
	private final ApiClient client = Configuration.getDefaultApiClient();

	private final WorkflowServiceApi workflowServiceApi;

	//todo
	private final String NAMESPACE = "argo";

	public ArgoClientAdapter(ArgoWorkflowConfigProperties argoWorkflowConfigProperties) {
		client.setBasePath(argoWorkflowConfigProperties.getBasePath());

		ApiKeyAuth BearerToken = (ApiKeyAuth) client.getAuthentication("BearerToken");
		BearerToken.setApiKey(argoWorkflowConfigProperties.getApiKey());

		this.workflowServiceApi = new WorkflowServiceApi(client);
	}

	public void saveWorkflow() {
		IoArgoprojWorkflowV1alpha1WorkflowCreateRequest body = new IoArgoprojWorkflowV1alpha1WorkflowCreateRequest();
		body.setNamespace(NAMESPACE);
	}

	public void deleteWorkflow() {

	}

	public void getWorkflowInfo() {

	}
}

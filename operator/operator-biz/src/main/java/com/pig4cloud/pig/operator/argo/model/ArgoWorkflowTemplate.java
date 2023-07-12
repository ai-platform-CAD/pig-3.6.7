package com.pig4cloud.pig.operator.argo.model;


import io.argoproj.workflow.models.IoArgoprojWorkflowV1alpha1Artifact;
import io.argoproj.workflow.models.IoArgoprojWorkflowV1alpha1Inputs;
import io.argoproj.workflow.models.IoArgoprojWorkflowV1alpha1OSSArtifact;
import io.argoproj.workflow.models.IoArgoprojWorkflowV1alpha1Template;
import io.kubernetes.client.openapi.models.V1Container;

import java.util.ArrayList;
import java.util.List;


public class ArgoWorkflowTemplate {
	private void foo(String name, String image, List<String> command, List<String> args, List<ArgoWorkflowArtifact> artifacts) {
		IoArgoprojWorkflowV1alpha1Template template = new IoArgoprojWorkflowV1alpha1Template();
		template.setName(name);

		// template.container
		V1Container container = new V1Container();
		container.setImage(image);
		container.setCommand(command);
		container.setArgs(args);
		// container.setName(name);
		template.setContainer(container);


		// template.inputs
		IoArgoprojWorkflowV1alpha1Inputs inputs = new IoArgoprojWorkflowV1alpha1Inputs();
		List<IoArgoprojWorkflowV1alpha1Artifact> ioArgoprojWorkflowV1alpha1Artifacts = new ArrayList<>(artifacts.size());

		for(ArgoWorkflowArtifact artifact : artifacts){
			IoArgoprojWorkflowV1alpha1Artifact ioArgoprojWorkflowV1alpha1Artifact = new IoArgoprojWorkflowV1alpha1Artifact();
			ioArgoprojWorkflowV1alpha1Artifact.setName(artifact.getName());
			ioArgoprojWorkflowV1alpha1Artifact.setPath(artifact.getPath());
			if(artifact.getArchive().isPresent()){
				ioArgoprojWorkflowV1alpha1Artifact.setArchive(artifact.getArchive().get());
			}
			if(artifact.getS3().isPresent()){
				ioArgoprojWorkflowV1alpha1Artifact.setS3(artifact.getS3().get());
			}
			ioArgoprojWorkflowV1alpha1Artifacts.add(ioArgoprojWorkflowV1alpha1Artifact);
		}
		inputs.setArtifacts(ioArgoprojWorkflowV1alpha1Artifacts);
		template.setInputs(inputs);

		// todo: template.outputs

		// return template

	}
}

package com.pig4cloud.pig.operator.argo.model;

import io.argoproj.workflow.models.IoArgoprojWorkflowV1alpha1ArchiveStrategy;
import io.argoproj.workflow.models.IoArgoprojWorkflowV1alpha1S3Artifact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Optional;

@Data
@AllArgsConstructor
public class ArgoWorkflowArtifact {
	private final String name;
	private final String path;
	private final Optional<IoArgoprojWorkflowV1alpha1ArchiveStrategy> archive;
	private final Optional<IoArgoprojWorkflowV1alpha1S3Artifact> s3;
}

package com.equifax.teamin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="project")
public class Projects implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_id")
	private int  projectId;

	@Column(name="project_name")
	private String projectName;

	@ManyToOne
	@JoinColumn(name="program_id", nullable=false)
	private Programs programs;

	@OneToMany(mappedBy="project")
	private List<Source> sources;

	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public Programs getPrograms() {
		return programs;
	}

	public void setPrograms(Programs programs) {
		this.programs = programs;
	}

	public List<Source> getSources() {
		return sources;

	}

	public void setSources(List<Source> sources) {
		this.sources = sources;
	}
}

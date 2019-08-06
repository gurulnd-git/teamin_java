package com.equifax.teamin.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="team")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "teamId")
public class Team implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="team_id")
	private int  teamId;
	@Column(name="team_name")
	private String teanName;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id", nullable = false)
	private Projects project ;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
	private Set<TeamMembers>teamMembers;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeanName() {
		return teanName;
	}

	public void setTeanName(String teanName) {
		this.teanName = teanName;
	}

	public Projects getProject() {
		return project;
	}

	public void setProject(Projects project) {
		this.project = project;
	}

	public Set<TeamMembers> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(Set<TeamMembers> teamMembers) {
		this.teamMembers = teamMembers;
	}
	
	
	

}

package com.equifax.teamin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="teammembers")
public class TeamMembers implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="team_members_id")
	private int teamMembersId;
	@Column(name="employee_id")
	private String employeeId;
	@Column(name="employee_name")
	private String employeeName;
	@Column(name="joining_date")
	private Date joiningDate;
	@Column(name="last_working_day")
	private Date lastWorkingDay;
	@Column(name="resigning_date")
	private Date resigningDate ; 
	@Column(name="status")
	private String status;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id", nullable = false)
	private Team team ;

	public int getTeamMembersId() {
		return teamMembersId;
	}

	public void setTeamMembersId(int teamMembersId) {
		this.teamMembersId = teamMembersId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getLastWorkingDay() {
		return lastWorkingDay;
	}

	public void setLastWorkingDay(Date lastWorkingDay) {
		this.lastWorkingDay = lastWorkingDay;
	}

	public Date getResigningDate() {
		return resigningDate;
	}

	public void setResigningDate(Date resigningDate) {
		this.resigningDate = resigningDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}

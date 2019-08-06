package com.equifax.teamin.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="source")
@SuppressWarnings("all")
public class Source implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="source_id")
    private int sourceId;

    @Column(name="candidate_name")
    private String candidateName;

    @Column(name="yearof_experience")
    private int yearofExperience ;

    @Column(name="planned_start_date")
    private Date planned_start_date ;

    @Column(name="actual_start_date")
    private Date actual_start_date ;

    @Column(name="status")
    private String status;

    @ManyToOne
    @JoinColumn(name="project_id",nullable=false)
    private Projects project;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="role_id")
    private Roles role;

    public int getSourceId() {
        return sourceId;
    }
    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }
    public String getCandidateName() {
        return candidateName;
    }
    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Date getPlanned_start_date() {
        return planned_start_date;
    }

    public void setPlanned_start_date(Date planned_start_date) {
        this.planned_start_date = planned_start_date;
    }

    public Date getActual_start_date() {
        return actual_start_date;
    }

    public void setActual_start_date(Date actual_start_date) {
        this.actual_start_date = actual_start_date;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public Projects getProject() {
        return project;
    }
    public void setProject(Projects project) {
        this.project = project;
    }
    public int getYearofExperience() {
        return yearofExperience;
    }
    public void setYearofExperience(int yearofExperience) {
        this.yearofExperience = yearofExperience;
    }
    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;
    }


}

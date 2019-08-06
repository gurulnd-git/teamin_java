package com.equifax.teamin.dao;

import com.equifax.teamin.Repo.ProgramRepo;
import com.equifax.teamin.Repo.ProjectRepo;
import com.equifax.teamin.Repo.RoleRepo;
import com.equifax.teamin.Repo.SourceRepo;
import com.equifax.teamin.dto.ProjectDTO;
import com.equifax.teamin.dto.SourcingDTO;
import com.equifax.teamin.dto.SourcingRequest;
import com.equifax.teamin.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SourcingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SourceRepo sourceRepo;
    @Autowired
    private ProgramRepo programRepo;
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private RoleRepo roleRepo;

       public List<User> getAllUsers() {
        System.out.println("enter in the list");
        String hql = "FROM User as user ";

        return (List<User>) entityManager.createQuery(hql).getResultList();
    }
    public List<Programs> getPrograms(){
           String sql=" from Programs as program ";
           return (List<Programs>) entityManager.createQuery(sql).getResultList();

    }
    public List<Projects> getProjects(SourcingRequest sourcingRequest){
        List<Projects> projects = null;
        String hql= " from Projects as project";
        if (sourcingRequest != null && sourcingRequest.getProgramDTO() != null ) {
            if (sourcingRequest.getProgramDTO().getProgramId() != null) {
                hql = " from Projects as project where program_id=:program_id";
                projects = (List<Projects>) entityManager.createQuery(hql, Projects.class)
                        .setParameter("program_id", sourcingRequest.getProgramDTO().getProgramId())
                        .getResultList();
            }

        } else {
            projects = (List<Projects>) entityManager.createQuery(hql).getResultList();
        }
        return projects;

    }
    public List<Roles> getRoles(SourcingRequest sourcingRequest){
        String sql=" from Roles as role";
        return (List<Roles>) entityManager.createQuery(sql).getResultList();

    }

    public List<Source> getSources(SourcingRequest sourcingRequest){
        List<Source> sourceList = null;
        String  hql=" from Source as source";
        if (sourcingRequest != null && sourcingRequest.getProjectDTO() != null ) {
            if ( sourcingRequest.getProjectDTO().getProjectId() != null) {
                hql = " from Source as source where project_id=:project_id";
                sourceList = (List<Source>) entityManager.createQuery(hql, Source.class)
                        .setParameter("project_id", sourcingRequest.getProjectDTO().getProjectId())
                        .getResultList();
            }
        } else {
            sourceList = (List<Source>) entityManager.createQuery(hql).getResultList();
        }
        return sourceList;
    }

    public void saveSourcing(Source source){
       if (source != null) {
           sourceRepo.save(source);
       }
    }

    public  void addProgram(Programs programs){
           if(programs!=null){
               programRepo.save(programs);
           }
    }
    public void addProject(Projects projects){
           if(projects!=null){
               projectRepo.save(projects);
           }
    }

    public void addRole(Roles roles){
           if(roles!=null){
               roleRepo.save(roles);
           }
    }


}
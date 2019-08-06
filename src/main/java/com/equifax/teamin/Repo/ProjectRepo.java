package com.equifax.teamin.Repo;

import com.equifax.teamin.entity.Projects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProjectRepo extends CrudRepository<Projects,Long> {

}
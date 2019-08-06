package com.equifax.teamin.Repo;

import com.equifax.teamin.entity.Programs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProgramRepo extends CrudRepository<Programs,Long> {

}
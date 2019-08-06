package com.equifax.teamin.Repo;

import com.equifax.teamin.entity.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleRepo extends CrudRepository<Roles,Long> {

}

package com.equifax.teamin.Repo;

import com.equifax.teamin.entity.Source;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepo extends CrudRepository<Source,Long> {

}

package com.ittaga.bikini.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findByName(String name);
}

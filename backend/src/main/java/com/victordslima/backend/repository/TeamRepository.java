package com.victordslima.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.victordslima.backend.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long > { 

    Team findByTeamName(String teamName);
    
}

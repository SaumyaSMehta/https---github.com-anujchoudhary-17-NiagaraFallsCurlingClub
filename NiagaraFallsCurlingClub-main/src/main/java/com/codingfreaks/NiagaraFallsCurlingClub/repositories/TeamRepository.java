package com.codingfreaks.NiagaraFallsCurlingClub.repositories;


import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Team;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team,String>{
  
}
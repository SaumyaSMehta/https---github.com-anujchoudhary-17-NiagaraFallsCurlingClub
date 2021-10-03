package com.codingfreaks.NiagaraFallsCurlingClub.repositories;

import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.User;
import com.codingfreaks.NiagaraFallsCurlingClub.modelClasses.Match.Match;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MatchRepository extends MongoRepository<Match, String>{ 

  
    

}

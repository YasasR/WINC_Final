package com.winc.exhibits;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExhibitRepository extends MongoRepository<ExhibitModel, Integer>{
	
	public List<Exhibit> findById(int id);
}

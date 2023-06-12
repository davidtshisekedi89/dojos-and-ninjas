package com.david.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.dojosandninjas.models.Dojo;
import com.david.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepo; 
	

//  Find All	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
//  Create
	public Dojo createDojo(Dojo newDojo) {
		return dojoRepo.save(newDojo);
	}
	
//  Find One
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo= dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
			
		}else {
			return null;
		}
	}
	
//   Update
	 public Dojo updateDojo(Dojo oneDojo) {
		return dojoRepo.save(oneDojo);
	}
	
//   Delete
     public void removeDojo(long id) {
    	  dojoRepo.deleteById(id);
		
	}
		  
	

}

package com.david.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.dojosandninjas.models.Ninja;
import com.david.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
//  Find All	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
//  Create
	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
//  Find One
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja= ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
			
		}else {
			return null;
		}
	}
	
//   Update
	 public Ninja updateNinja(Ninja oneNinja) {
		return ninjaRepo.save(oneNinja);
	}
	
//   Delete
     public void removeNinja(long id) {
    	 ninjaRepo.deleteById(id);
		
	}

}

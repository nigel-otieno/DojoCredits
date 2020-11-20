package com.codingdojo.Lookify.services;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;

import com.codingdojo.Lookify.models.Look;
import com.codingdojo.Lookify.repository.LookRepository;


@Service
public class LookService {
	private final LookRepository lookRepository;
	
	public LookService(LookRepository lookRepository) {
		this.lookRepository = lookRepository;
	}
	
	public java.util.List<Look> allLooks() {
        return lookRepository.findAll();
    }
    // creates a book
    public Look createLook(Look look) {
        return lookRepository.save(look);
    }
    // retrieves a book
    public Look findLook(Long id) {
        Optional<Look> optionalLook = lookRepository.findById(id);
        if(optionalLook.isPresent()) {
            return optionalLook.get();
        } else {
            return null;
        }
    }
    public List<Look> findByArtist(String search){
    	return lookRepository.findByArtistContaining(search);
    }
    public void deleteLook(Long id) {
		Optional<Look> optionalLook = lookRepository.findById(id);
		if(optionalLook.isPresent()) {
		lookRepository.deleteById(id);
		}
	}
}

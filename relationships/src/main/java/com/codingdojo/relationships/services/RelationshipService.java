package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

@Service
public class RelationshipService {
private final RelationshipRepository relationshipRepository;
	
	public RelationshipService(RelationshipRepository relationshipRepository) {
		this.relationshipRepository = relationshipRepository;
	}
	
	public java.util.List<Relationship> allLooks() {
        return relationshipRepository.findAll();
    }
    // creates a book
    public Relationship createLook(Realationship realationship) {
        return relationshipRepository.save(relationship);
    }
    // retrieves a book
    public Relationship findLook(Long id) {
        Optional<Relationship> optionalRelationship = relationshipRepository.findById(id);
        if(optionalLook.isPresent()) {
            return optionalLook.get();
        } else {
            return null;
        }
    }
    public List<Relationship> findByArtist(String search){
    	return relationshipRepository.findByArtistContaining(search);
    }
    public void deleteLook(Long id) {
		Optional<Relationship> optionalLook = relationshipRepository.findById(id);
		if(optionalLook.isPresent()) {
			relationshipRepository.deleteById(id);
		}
	}
}

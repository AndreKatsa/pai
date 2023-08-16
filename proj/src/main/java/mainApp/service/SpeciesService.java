package mainApp.service;

import org.springframework.stereotype.Service;

import mainApp.model.Species;

@Service
public interface SpeciesService {
	public void saveSpecies(Species species);
}

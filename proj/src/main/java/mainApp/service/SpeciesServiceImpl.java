package mainApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.SpeciesDAO;
import mainApp.model.Species;

@Service
public class SpeciesServiceImpl implements SpeciesService {
	
	@Autowired
	SpeciesDAO speciesDAO;
	
	@Override
	public void saveSpecies(Species species) {
		speciesDAO.save(species);
		
	}

}

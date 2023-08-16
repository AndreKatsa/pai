package mainApp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import mainApp.dao.SpeciesDAO;
import mainApp.model.Species;
import mainApp.service.SpeciesService;
@Controller
public class SpeciesController {
	
	@Autowired
	SpeciesService speciesService;
	
	@Autowired
	SpeciesDAO speciesdao;
	
    @RequestMapping("/registerSpecies")
    public String register(Model model){
        model.addAttribute("species", new Species());
        return "/user/addspecies";
    }

	
    @RequestMapping("/saveSpecies")
    public String registerSpecies(@ModelAttribute("species") Species species, Model model){
        speciesService.saveSpecies(species);
        model.addAttribute("successMessage", "Species registered successfully!");

        return "/user/addspecies";
    }
    
    @GetMapping("/ShowSpecies")
    public String showProductTable(Model model) {
    	
        List<Species> speciesList = speciesdao.findAll();
        List<String> speciesName= new ArrayList<String>();
        List<ArrayList<Integer>> speciesDeliveries = new ArrayList<ArrayList<Integer>>();
        List<Double> speciesAmount = new ArrayList<Double>();
        for(int i = 0; i<speciesList.size();i++) {
        	if(speciesName.contains(speciesList.get(i).getName())) {
        		for(int j=0;j<speciesName.size();j++) {
        			if(speciesName.get(j).equals(speciesList.get(i).getName())) {
        				speciesDeliveries.get(j).add(speciesList.get(i).getDelivery());
        				Double newAmount=speciesAmount.get(j)+speciesList.get(i).getAmount();
        				speciesAmount.set(j, newAmount);
        				break;
        			}
        		}
        	}
        	else {
        		speciesName.add(speciesList.get(i).getName());
        		ArrayList<Integer> dls=new ArrayList<Integer>();
        		dls.add(speciesList.get(i).getDelivery());
        		speciesDeliveries.add(dls);
        		speciesAmount.add(speciesList.get(i).getAmount());
        	}
        }
        model.addAttribute("name",speciesName);
        model.addAttribute("deliveries",speciesDeliveries);
        model.addAttribute("amounts",speciesAmount);
        return "admin/showspecies";
    }
}

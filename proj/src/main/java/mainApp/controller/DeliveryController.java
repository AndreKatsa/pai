package mainApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mainApp.model.Delivery;
import mainApp.service.DeliveryService;

@Controller
public class DeliveryController {

	@Autowired
	DeliveryService deliveryService;
	
    @RequestMapping("/registerDelivery")
    public String register(Model model){
        model.addAttribute("delivery", new Delivery());
        return "/user/addDelivery";
    }

	
    @RequestMapping("/saveDelivery")
    public String registerSpecies(@ModelAttribute("delivery") Delivery delivery, Model model){
        deliveryService.saveDelivery(delivery);
        model.addAttribute("successMessage", "Delivery registered successfully!");

        return "/user/addDelivery";
    }
}
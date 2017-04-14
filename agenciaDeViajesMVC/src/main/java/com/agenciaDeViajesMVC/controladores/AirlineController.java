package com.agenciaDeViajesMVC.controladores;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agenciaDeViajesMVC.modelos.Airline;
import com.agenciaDeViajesMVC.services.AirlineService;

public class AirlineController {
	
	AirlineService airlineService;
	
	@RequestMapping(value = "/airlineList", method = RequestMethod.GET)
    public String listUsers(Model model) {
		
		List<Airline> airlines = airlineService.listAirlines();
		model.addAttribute("airline", new Airline());
		model.addAttribute("airlines", airlines);
		return "airlineList";
    }
    
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAirline(@ModelAttribute("airline") Airline airline){
		
//		if (String.valueOf(user.getId()).equals("null")){
		if (airline.getIdAirline() == null){
			try {
				airlineService.saveAirline(airline);	
			}
			catch (DataIntegrityViolationException e){
				System.out.println("airline already exists");
			}
		}else{
			airlineService.updateAirline(airline);

		}
		return "redirect:/airlineList";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String removeAirline(@PathVariable("id") Integer id){
        airlineService.removeAirline(id);
        return "redirect:/airlineList";
    }
	
    @RequestMapping("/edit/{id}")
    public String editAirline(@PathVariable("id") Integer id, Model model){
        model.addAttribute("airline", airlineService.getAirlineById(id));
		List<Airline> airlines = airlineService.listAirlines();
        model.addAttribute("airlines", airlines);
        return "airlineList";
    }
    
//    @RequestMapping(value = "/planes/{id}")
//    public String seePlanes(@PathVariable("id") Integer id, Model model){
//    	model.addAttribute("airline", airlineService.getAirlineById(id));
//    	
//    	Airline airline2 = airlineService.getAirlineById(id);
//        return "redirect:/planeList/{airline}";
//    }
    

	public AirlineService getAirlineService() {
		return airlineService;
	}

	public void setAirlineService(AirlineService airlineService) {
		this.airlineService = airlineService;
	}
    
}

package com.agenciaDeViajesMVC.controladores;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agenciaDeViajesMVC.modelos.Plane;
import com.agenciaDeViajesMVC.services.PlaneService;

public class PlaneController {

	PlaneService planeService;
	
//	@RequestMapping(value = "/planeList/{airline}", method = RequestMethod.GET)
//    public String listPlanes(@PathVariable("airline") Airline airline, Model model){
//		
//		List<Plane> planes = planeService.listPlanes();
//		model.addAttribute("plane", new Plane());
//		model.addAttribute("planes", planes);
//		return "/planeList/{airline}";
//    }
	
//	@RequestMapping(value = "planeList", method = RequestMethod.GET)
//    public String listPlanes(@ModelAttribute("airline") Airline airline, Model model){
//		
//		Airline airline2 = airline;
//		List<Plane> planes = planeService.listPlanes();
//		model.addAttribute("plane", new Plane());
//		model.addAttribute("planes", planes);
//		return "planeList";
//    }
	
	@RequestMapping(value = "/planeList/{id}", method = RequestMethod.GET)
    public String listPlanes(@PathVariable("id") Integer id, Model model){
		
		List<Plane> planes = planeService.listPlanes();
		model.addAttribute("plane", new Plane());
		model.addAttribute("planes", planes);
		return "planeList/"+id+"";
    }

	public PlaneService getPlaneService() {
		return planeService;
	}

	public void setPlaneService(PlaneService planeService) {
		this.planeService = planeService;
	}
    
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public String saveAirline(@ModelAttribute("airline") Airline airline){
//		
////		if (String.valueOf(user.getId()).equals("null")){
//		if (airline.getIdAirline() == null){
//			try {
//				airlineService.saveAirline(airline);	
//			}
//			catch (DataIntegrityViolationException e){
//				System.out.println("airline already exists");
//			}
//		}else{
//			airlineService.updateAirline(airline);
//
//		}
//		return "redirect:/airlineList";
//	}
//	
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public String removeAirline(@PathVariable("id") Integer id){
//        airlineService.removeAirline(id);
//        return "redirect:/airlineList";
//    }
//	
//    @RequestMapping("/edit/{id}")
//    public String editAirline(@PathVariable("id") int id, Model model){
//        model.addAttribute("airline", airlineService.getAirlineById(id));
//		List<Airline> airlines = airlineService.listAirlines();
//        model.addAttribute("airlines", airlines);
//        return "airlineList";
//    }

	
}

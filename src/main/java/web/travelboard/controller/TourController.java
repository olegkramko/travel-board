package web.travelboard.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.travelboard.model.Tour;
import web.travelboard.service.TourService;

@Controller
public class TourController {
    private TourService tourService;

    @Autowired(required = true)
    @Qualifier(value = "tourService")
    public void setTourService(TourService tourService) {
        this.tourService = tourService;
    }

    @RequestMapping(value = "tours", method = RequestMethod.GET)
    public String listTours(Model model){
        model.addAttribute("tour", new Tour());
        model.addAttribute("listTours", this.tourService.listTours());

        return "tours";
    }

    @RequestMapping(value = "/tours/add", method = RequestMethod.POST)
    public String addTour(@ModelAttribute("tour") Tour tour){
        if(Tour.getId() == 0){
            this.tourService.addTour(tour);
        }else {
            this.tourService.updateTour(tour);
        }

        return "redirect:/tours";
    }

    @RequestMapping("/remove/{id}")
    public String removeTour(@PathVariable("id") int id){
        this.tourService.removeTour(id);

        return "redirect:/tours";
    }

    @RequestMapping("edit/{id}")
    public String editTour(@PathVariable("id") int id, Model model){
        model.addAttribute("tour", this.tourService.getTourById(id));
        model.addAttribute("listTours", this.tourService.listTours());

        return "tours";
    }

    @RequestMapping("tourdata/{id}")
    public String TourData(@PathVariable("id") int id, Model model){
        model.addAttribute("Tour", this.tourService.getTourById(id));

        return "tourdata";
    }
}


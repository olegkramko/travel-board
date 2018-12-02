package web.travelboard.service;
import web.travelboard.model.Tour;
import java.util.List;

public interface TourService {

    public void addTour(Tour tour);

    public void updateTour(Tour tour);

    public void removeTour(int id);

    public Tour getTourById(int id);

    public  List<Tour> listTours();

}
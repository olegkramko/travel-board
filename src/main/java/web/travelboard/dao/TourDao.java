package web.travelboard.dao;

import java.util.List;
import web.travelboard.model.Tour;

public interface TourDao {

    public void addTour(Tour tour);

    public void updateTour(Tour tour);

    public void removeTour(int id);

    public Tour getTourById(int id);

    public List<Tour> listTours();
}

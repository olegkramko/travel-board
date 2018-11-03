package web.travelboard.dao;

import web.travelboard.model.Tour;

import java.util.List;

public interface TourDao {

    public void addTour(Tour tour);

    public void updateTour(Tour tour);

    public void removeTour(int id);

    public Tour getTourById(int id);

    public List<Tour> listTours();
}

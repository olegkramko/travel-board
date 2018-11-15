package web.travelboard.service;


import web.travelboard.dao.TourDao;
import web.travelboard.model.Tour;

import java.util.List;

public interface TourService {
    void setTourDao(TourDao tourDao);

    void addTour(Tour tour);

    void updateTour(Tour tour);

    void removeTour(int id);

    Tour getTourById(int id);

    List<Tour> listTour();
}


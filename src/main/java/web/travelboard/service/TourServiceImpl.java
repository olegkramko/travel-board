package web.travelboard.service;

import web.travelboard.model.Tour;
import web.travelboard.dao.TourDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TourServiceImpl implements TourService {
    private TourDao tourDao;

    public void setTourDao(TourDao tourDao) {
        this.tourDao = tourDao;
    }

    @Override
    @Transactional
    public void addTour(Tour tour) {
        this.tourDao.addTour(tour);
    }

    @Override
    public void updateTour(Tour tour) {
        this.tourDao.updateTour(tour);
    }

    @Override
    @Transactional
    public void removeTour(int id) {
        this.tourDao.removeTour(id);
    }

    @Override
    @Transactional
    public Tour getTourById(int id) {
        return this.tourDao.getTourById(id);
    }

    @Override
    @Transactional
    public List<Tour> listTours() {
        return this.tourDao.listTours();
    }
}


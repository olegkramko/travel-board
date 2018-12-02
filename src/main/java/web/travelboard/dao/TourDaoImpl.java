package web.travelboard.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import web.travelboard.model.Tour;
import java.util.List;

@Repository
public class TourDaoImpl implements TourDao{
    private static final Logger logger = LoggerFactory.getLogger(TourDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public void addTour(Tour tour) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(tour);
        logger.info("Tour successfully saved: " + tour);

    }

    @Override
    public void updateTour(Tour tour) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(tour);
        logger.info("Tour successfully updated. Tour details: " + tour);
    }

    @Override
    public void removeTour(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tour tour = (Tour) session.load(Tour.class, new Integer(id));
            if(tour!=null){
                session.delete(tour);
            }
        logger.info("Tour successfully removed. Tour details: " + tour);
    }

    @Override
    public Tour getTourById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tour tour = (Tour) session.load(Tour.class, new Integer(id));
        logger.info("Tour successfully loaded. Tour details: " + tour);

        return tour;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Tour> listTours() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Tour> tourList = session.createQuery("from Tour").list();

        for(Tour tour: tourList){
            logger.info("Tour list: " + tour);
        }

        return tourList;
    }
}

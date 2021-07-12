package dao;

import models.Regions;
import models.SnowLoads;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class SnowLoadsDao {

    public static SnowLoads findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(SnowLoads.class, id);
    }

    public static List<SnowLoads> findAll() {
        return (List<SnowLoads>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From models.SnowLoads").list();
    }


}

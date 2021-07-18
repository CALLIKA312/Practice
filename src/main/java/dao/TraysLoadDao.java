package dao;

import models.Trays;
import models.TraysLoad;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TraysLoadDao {
    public TraysLoad findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TraysLoad.class, id);
    }

    public static List<TraysLoad> findAll() {
        return (List<TraysLoad>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM models.TraysLoad").list();
    }
}

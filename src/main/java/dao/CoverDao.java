package dao;

import models.Cities;
import models.Cover;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CoverDao {
    public static Cover findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Cover.class, id);
    }

    public static List<Cover> findAll() {
        return (List<Cover>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From models.Cover").list();

    }
}

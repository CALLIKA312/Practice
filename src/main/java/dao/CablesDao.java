package dao;

import models.Cables;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CablesDao {
    public Cables findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Cables.class, id);
    }

    public static List<Cables> findAll() {
        return (List<Cables>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM models.Cables").list();
    }
}

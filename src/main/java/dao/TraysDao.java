package dao;

import models.Cables;
import models.Trays;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TraysDao {
    public Trays findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Trays.class, id);
    }

    public static List<Trays> findAll() {
        return (List<Trays>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM models.Trays").list();
    }
}

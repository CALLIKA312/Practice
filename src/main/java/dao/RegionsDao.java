package dao;

import models.Cities;
import models.Regions;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class RegionsDao {
    public Regions findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Regions.class,id);
    }
    public static List<Regions> findAll(){
        return (List<Regions>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From models.Regions").list();
    }
}

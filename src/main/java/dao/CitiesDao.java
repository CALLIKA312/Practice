package dao;

import models.Cities;
import models.TestTable;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CitiesDao {
    public Cities findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Cities.class,id);
    }
    public static List<Cities> findAll(){
        return (List<Cities>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From models.Cities").list();
    }
}

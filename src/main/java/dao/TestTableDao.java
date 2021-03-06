package dao;

import models.TestTable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TestTableDao {
    public TestTable findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TestTable.class, id);
    }

    public void save(TestTable testTable) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(testTable);
        // session.createNativeQuery("insert into public.table values(400,'Арбуз',5)", TestTable.class).executeUpdate();
        tx1.commit();
        session.close();
    }

    public void update(TestTable testTable) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(testTable);
        tx1.commit();
        session.close();
    }

    public void delete(TestTable testTable) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(testTable);
        tx1.commit();
        session.close();
    }

    public static List<TestTable> findAll() {
        return (List<TestTable>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From models.TestTable").list();
    }

}


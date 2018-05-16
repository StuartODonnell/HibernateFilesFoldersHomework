package com.codeclan.folders.db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.awt.print.Book;
import java.util.List;

public class DBHelper {


    private static Session session;
    private static Transaction transaction;

    public static void save(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
    }

    public static <T> List<T> getAll(Class classType) {

        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            Criteria cr = session.createCriteria(classType);
            results = cr.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }


    public static <T> T find(Class classType, int id)

    {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            Criteria cr = session.createCriteria(classType);
            cr.add(Restrictions.eq("id", id));
            result = (T) cr.uniqueResult();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;

    }

//    public static void delete(Object object) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            session.delete(object);
//            transaction.commit();
//        } catch (HibernateException e){
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
}
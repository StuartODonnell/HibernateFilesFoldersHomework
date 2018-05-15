package com.codeclan.example.db;


import com.codeclan.example.models.File;
import com.codeclan.example.models.Folder;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFolder {

    private static Transaction transaction;
    private static Session session;


    public static List<File> getFIlesForFolder(Folder folder) {
        session = db.HibernateUtil.getSessionFactory().openSession();
        List<File> results = null;
        try {
            Criteria cr = session.createCriteria(File.class);
            cr.add(Restrictions.eq("folder", folder));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;

    }
}

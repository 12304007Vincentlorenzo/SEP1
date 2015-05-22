package service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import proj.obj.Relation;

import java.util.List;

/**
 * Created by Stephen on 2015/05/20.
 * Ver 1.0
 */
public class RelationService {
    private static RelationService ourInstance = new RelationService();

    public static RelationService getInstance() {
        return ourInstance;
    }

    SessionFactory factory;

    private RelationService() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("proj/resources/sep1.cfg.xml");

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public List<Relation> getRelation(int superiorid) {
        Session session = factory.openSession();

        Transaction tr = null;

        List<Relation> result = null;

        try {

            tr = session.beginTransaction();

            result = (List<Relation>) session.createQuery("FROM Relation WHERE superiorid = ?").setParameter(0, superiorid).list();

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }

    public void insertRelation(Relation newR) {
        Session session = factory.openSession();

        Transaction tr = null;


        try {

            tr = session.beginTransaction();

            session.save(newR);

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

package service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import proj.obj.AttendanceLog;

import java.util.List;

/**
 * Created by Stephen on 2015/05/20.
 * Ver 1.0
 */
public class AttendanceLogService {
    private static AttendanceLogService ourInstance = new AttendanceLogService();

    public static AttendanceLogService getInstance() {
        return ourInstance;
    }

    SessionFactory factory;

    private AttendanceLogService() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("proj/resources/sep1.cfg.xml");

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void insertAttendanceLog(AttendanceLog newAL) {

        Session session = factory.openSession();

        Transaction tr = null;

        try {

            tr = session.beginTransaction();

            session.save(newAL);

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    public List<AttendanceLog> getAttendanceLog(int employeeID){
        Session session = factory.openSession();

        Transaction tr = null;

        List<AttendanceLog> result = null;

        try {

            tr = session.beginTransaction();

            result = (List<AttendanceLog>) session.createQuery("FROM AttendanceLog where employeeid = ?").setParameter(0, employeeID).list();

            tr.commit();

        } catch (HibernateException e){
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }

}

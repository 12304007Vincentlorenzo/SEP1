package service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import proj.obj.Employee;

/**
 * Created by Stephen on 2015/05/20.
 * Ver 1.0
 */
public class EmployeeService {

    private static EmployeeService instance = new EmployeeService();

    public static EmployeeService getInstance() {
        return instance;
    }

    SessionFactory factory;

    private EmployeeService() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("proj/resources/sep1.cfg.xml");

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Employee getEmployee (int id){

        Session session = factory.openSession();

        Transaction tr = null;

        Employee result = null;

        try {

            tr = session.beginTransaction();

            result = (Employee) session.get(Employee.class, id);

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

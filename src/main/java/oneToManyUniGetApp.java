import Entity.Company;
import Entity.CompanyDetail;
import Entity.Department;
import Entity.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class oneToManyUniGetApp {

    public static void main(String[] args) {
        // stworzyc obiekt Configuration
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");
        // wczytanie adnotacji
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);

        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // pobranie sesji
        Session session = factory.getCurrentSession();

        int id = 41;

        session.beginTransaction();
   /*     Company company = session.get(Company.class, id);
        System.out.println("Informacje dotyczące firmy" + company);

        Set<Department> departments = company.getDepartments();

        for(Department department : departments){
            System.out.println(department);
        } */

        Department department = session.get(Department.class,3);
        System.out.println("Info o department" + department);
        

        session.getTransaction().commit();

        factory.close();
    }

}

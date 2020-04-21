import Entity.Company;
import Entity.CompanyDetail;
import Entity.Department;
import Entity.Property;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManyUniSaveApp {

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
        Company company = session.get(Company.class, id);
        System.out.println("Informacje dotyczące firmy" + company);

        Department department1 = new Department("sales");
        Department department2 = new Department("production");
        Department department3 = new Department("HR");

        company.addDepartment(department1);
        company.addDepartment(department2);
        company.addDepartment(department3);

        session.persist(company); //operacje dodawania jest kaskadowalna

        session.getTransaction().commit();

        factory.close();
    }

}

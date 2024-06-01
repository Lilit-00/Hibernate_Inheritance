import net.sf.ehcache.CacheManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {
        // Get a Hibernate session and begin a transaction
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        createAndSave(session);


        searchNativeQuery(session);

        searchNamedQuery(session);

        // Commit the transaction and close the session
        transaction.commit();
        session.close();

        int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
                .getCache("Employee").getSize();
        System.out.println(size);
        // Shutdown Hibernate when you're done
        HibernateUtil.shutdown();
    }

    private static void searchNamedQuery(Session session) {
        Query<Employee> getById = session.createNamedQuery("get_by_id", Employee.class);
        getById.setParameter("id", 7554);
        Employee singleResult = getById.uniqueResultOptional().orElse(null);
        System.out.println("single result by named query" + singleResult);
    }

    private static void searchNativeQuery(Session session) {
        NativeQuery<Employee> nativeQuery = session
                .createNativeQuery(
                        "select * from employee", Employee.class);
        for (Employee employee2 : nativeQuery.getResultList()) {
            System.out.println("employee from  native query result:" + employee2);

        }
    }


    private static void createAndSave(Session session) {
        // Create an Employee object and persist it
        Employee employee = new Employee();
        employee.setName("John smith");

        session.persist(employee);
        Employee employee1 = session.find(Employee.class, 2);
        System.out.println(employee1);
    }
}

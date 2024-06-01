import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//OneToOne
//OneToMany
//ManyToOne
//ManyToMany
public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    // This method initializes and manages Hibernate configuration and services.
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create a central registry for Hibernate configuration and services.
                Configuration config = new Configuration();
                config.configure();
                // local SessionFactory bean created
                 sessionFactory = config.buildSessionFactory();

            } catch (Exception e) {
                // Handle exceptions gracefully, print stack trace for debugging purposes.
                e.printStackTrace();

                // If an exception occurs, release resources associated with the registry.
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        // Return the created or existing SessionFactory, allowing efficient sharing.
        return sessionFactory;
    }

    // This method is responsible for cleaning up and releasing Hibernate resources during application shutdown.
    public static void shutdown() {
        if (registry != null) {
            // Properly release resources and shut down Hibernate by destroying the registry.
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}

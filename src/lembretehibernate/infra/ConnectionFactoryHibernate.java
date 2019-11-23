package lembretehibernate.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mello
 */
public class ConnectionFactoryHibernate {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("LembretePU");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emf.createEntityManager();
    }
}

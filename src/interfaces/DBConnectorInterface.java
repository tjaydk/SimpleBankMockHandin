package interfaces;

import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dennis
 */
public interface DBConnectorInterface {
    public EntityManagerFactory getConnection();
}

package DB;

import interfaces.DBConnectorInterface;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dennis
 */
public class DBConnector implements DBConnectorInterface{

    private String PU_NAME = "SimpleBankPU";
    
    @Override
    public EntityManagerFactory getConnection() {
        return Persistence.createEntityManagerFactory( PU_NAME );
    }
    
}

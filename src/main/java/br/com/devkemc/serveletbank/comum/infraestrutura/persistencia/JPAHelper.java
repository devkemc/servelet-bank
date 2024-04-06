package br.com.devkemc.serveletbank.comum.infraestrutura.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import java.util.HashMap;
import java.util.Map;

public class JPAHelper {
    public static EntityManager getEntityManager() {
        Map<String, String> properties = new HashMap<>();

        properties.put(PersistenceUnitProperties.JDBC_DRIVER, "org.h2.Driver");
        properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:h2:./banco;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        properties.put(PersistenceUnitProperties.JDBC_USER, "sa");
        properties.put(PersistenceUnitProperties.JDBC_PASSWORD, "");
        properties.put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);
        properties.put(PersistenceUnitProperties.LOGGING_LEVEL, "FINE");

        properties.put(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML, "META-INF/persistence.xml");

        return Persistence
                .createEntityManagerFactory("contatos", properties)
                .createEntityManager();
    }
    
}

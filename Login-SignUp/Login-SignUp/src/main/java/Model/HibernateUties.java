package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUties {
    private static final SessionFactory FACTORY ;
    static {
       Configuration conf = new Configuration();
       Properties prop = new Properties();
       prop.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
       prop.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
       prop.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=hibernate");
       prop.put(Environment.USER, "sa");
       prop.put(Environment.PASS, "123456789");
       prop.put(Environment.SHOW_SQL, "true");
       prop.put(Environment.HBM2DDL_AUTO, "update");
       conf.setProperties(prop);
       conf.addAnnotatedClass(User.class);
       ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
       FACTORY = conf.buildSessionFactory(registry);

   }



   public static SessionFactory getFACTORY(){
       return FACTORY ;
   }
}

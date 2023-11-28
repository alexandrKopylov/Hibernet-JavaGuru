package util;

import entity.BirthdayConverter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernetUtil {
    public static SessionFactory buildSessionFactory (){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAttributeConverter( BirthdayConverter.class,true);
        return configuration.buildSessionFactory();
    }
}

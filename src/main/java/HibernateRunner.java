import entity.Role;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        // configuration.addAnnotatedClass(User.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession();) {

            session.beginTransaction();
            session.save(User.builder()
                    .username("iva11n@mail.ru")
                    .firstname("ivan")
                    .lastname("Ivaniv")
                    .birthDate(LocalDate.of(2000, 01, 01))
                    .age(40)
                    .role(Role.ADMIN)
                    .build());
            session.getTransaction().commit();
        }
    }
}

import entity.Birthday;
import entity.BirthdayConverter;
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
        configuration.addAttributeConverter( BirthdayConverter.class,true);
        // configuration.addAnnotatedClass(User.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession();) {

            session.beginTransaction();

            User user = User.builder()
                    .username("iva123n@mail.ru")
                    .firstname("ivan")
                    .lastname("Ivaniv")
                    .birthDate(
                            new Birthday(LocalDate.of(2000, 01, 01)) )

                    .role(Role.USER)
                    .build();

            // базовые команды  в нhibernete

        //    session.save(user);      // сохраняем юзера в базу даннных
         //  session.update(user);     // будет обновлять юзера ,  может выдать исключение
                                             // если такого юзера не найдется

          ///  session.saveOrUpdate(user);    //  будет сохранять юзера, если его нет
                                            //  или  обновлять если он  есть

          ///  session.delete(user);      //  удаляет узера

           User user1 =  session.get (User.class , "iva123n@mail.ru");   // получить юзера  из базы данных по ключу id

            System.out.println(user1);

            session.getTransaction().commit();
        }
    }
}

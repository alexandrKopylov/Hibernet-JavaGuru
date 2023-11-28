import entity.Birthday;
import entity.BirthdayConverter;
import entity.Role;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.HibernetUtil;

import java.time.LocalDate;


public class HibernateRunner {
    private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class);

    public static void main(String[] args) {


//   создали  юзера     статус -  transient
        User user = new User.UserBuilder()
                .setUserName("333")
                .setFirstName("alexx")
                .setLastName("Kop")
                .setBirthDate(new Birthday(LocalDate.of(2000, 01, 01)))
                .setRole(Role.USER)
                .build();

      //  log.info("user object is transient state {}", user);

        try (SessionFactory sessionFactory = HibernetUtil.buildSessionFactory();
             Session session = sessionFactory.openSession();) {
            session.beginTransaction();

          //  user.setFirstname("ivan");
        //    log.warn("user firstname is changed: {}", user);


            // базовые команды  в нhibernete

             session.save(user);      // сохраняем юзера в базу даннных


            //  session.update(user);     // будет обновлять юзера ,  может выдать исключение
            // если такого юзера не найдется

            ///  session.saveOrUpdate(user);    //  будет сохранять юзера, если его нет
            //  или  обновлять если он  есть

            ///  session.delete(user);      //  удаляет узера

            // User user1 =  session.get (User.class , "111");   // получить юзера  из базы данных по ключу id

            // System.out.println(user1);
log.debug("user: {} , session {}  ", user , session);
            session.getTransaction().commit();
        } catch (Exception ex){
            log.error("Exeptio accured" , ex);
            throw ex;
        }
    }
}

package client;

import org.hibernate.Session;
import util.HibernateUtil;
import entity.Message;

public class HelloWordClient {
    public static void main(String[] args) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Message message = new Message("Hello Word with Hibernate and JPA Annotation");

            session.save(message);

            session.getTransaction().commit();
            session.close();
        }catch(NullPointerException npe){
            System.out.println();
        }
    }
}

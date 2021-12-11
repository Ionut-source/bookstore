package client;

import com.mysql.cj.Session;
import entity.Message;
import util.HibernateUtil;

public class UpdateMessageClient {
    public static void main(String[] args) {

        Session session1 = (Session) HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();

            Message message = session1.get(Message.class, 1L);
            System.out.println(message);

            session1.getTransaction().commit();
            session1.forceClose();

            message.setText("Updated" + message.getText());

        Session session2 = (Session) HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();

         session2.update(message);

         session2.getTransaction().commit();
         session2.forceClose();

        System.out.println(message);
        }
    }
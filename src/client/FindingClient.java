package client;

import com.mysql.cj.Session;
import entity.Message;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class FindingClient {
    public static void main(String[] args) {
        Session session = (Session) HibernateUtil.getSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
                txn.begin();

            //Finding Message {id=2L}
            Message message = session.get(Message.class, 2L);
            System.out.println(message);

        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        } finally {
            {
                session.forceClose();
            }
        }
    }
}

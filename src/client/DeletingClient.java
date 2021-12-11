package client;

import com.mysql.cj.Session;
import entity.Message;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class DeletingClient {
    public static void main(String[] args) {
        Session session = (Session) HibernateUtil.getSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
                txn.begin();

            //Deleting Message {id=2L}
            Message message = (Message) session.get(Message.class, 2L);
            session.delete(message);

            txn.commit();

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

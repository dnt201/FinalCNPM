package dao.impl;

import dao.UserDao;
import model.UsersModel;
import utl.HibernateUtil;
import org.hibernate.*;

public class UserDaoImpl extends AbstractDao<Integer, UsersModel> implements UserDao{

    @Override
    public UsersModel findUserByUsername(String username) {
        UsersModel user = new UsersModel();
        Transaction transaction = null;

        System.out.println(username);

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            try {
                StringBuilder sqlcmd = new StringBuilder("From UsersModel WHERE username= :userName");
                Query query = session.createQuery(sqlcmd.toString());
                query.setParameter("userName", username);

                user = (UsersModel) query.uniqueResult();
                transaction.commit();
            }
            catch(HibernateException e){
                transaction.rollback();
                throw e;
            }
            finally {
                session.close();
            }
        }
        catch (HibernateException e){
            System.out.println(e.getMessage());
        }

        return user;
    }

    @Override
    public UsersModel findUserByUsernameAndPassword(String username, String password){
        UsersModel user = new UsersModel();
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            try {
                StringBuilder sqlcmd = new StringBuilder("From UsersModel WHERE userName= :userName AND password= :password");
                Query query = session.createSQLQuery(sqlcmd.toString());
                query.setParameter("userName", username);
                query.setParameter("password", password);

                user = (UsersModel) query.uniqueResult();
                transaction.commit();
            }
            catch(HibernateException e){
                transaction.rollback();
                throw e;
            }
            finally {
                session.close();
            }
        }
        catch (HibernateException e){
            System.out.println(e.getMessage());
        }

        return user;
    }
}
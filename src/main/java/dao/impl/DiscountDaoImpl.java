package dao.impl;

import dao.DiscountDao;
import model.DiscountModel;
import utl.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DiscountDaoImpl extends AbstractDao<Integer, DiscountModel> implements DiscountDao {

    @Override
    public DiscountModel findByName(String discountName){
        List<DiscountModel> discount = new ArrayList<DiscountModel>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                StringBuilder sqlcmd = new StringBuilder("from ");
                sqlcmd.append(this.getPersistenceClassName());
                sqlcmd.append(" WHERE discountName= :discountName");

                Query query = session.createQuery(sqlcmd.toString());
                query.setParameter("discountName", discountName);
                discount = query.getResultList();
                transaction.commit();
            }
            catch (HibernateException e){
                transaction.rollback();
                throw e;
            }
            finally {
                session.close();
            }
        }
        catch (HibernateException e){
            throw e;
        }
        if (discount.size()>0) return discount.get(0);
        else return null;
    }
}

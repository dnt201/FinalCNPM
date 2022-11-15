package dao.impl;

import dao.OrderDetailsDao;
import model.OrderDetailsModel;
import utl.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDaoImpl extends AbstractDao<Integer, OrderDetailsModel> implements OrderDetailsDao {
    @Override
    public Integer saveReturnId(OrderDetailsModel orderDetailModel) {
        Integer id = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(orderDetailModel);
            transaction.commit();
            id = orderDetailModel.getOrder_id();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public List<OrderDetailsModel> findByUserId(Integer userId) {
        List<OrderDetailsModel> list = new ArrayList<OrderDetailsModel>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                StringBuilder sql = new StringBuilder("from ");
                sql.append(this.getPersistenceClassName());
                sql.append(" WHERE usersModel.user_id= " + userId.toString());
                Query query = session.createQuery(sql.toString());

                list = query.list();
                transaction.commit();
            } catch (HibernateException e) {
                transaction.rollback();
                throw e;
            } finally {
                session.close();
            }
        } catch (HibernateException e) {
            throw e;
        }

        return list;
    }
}

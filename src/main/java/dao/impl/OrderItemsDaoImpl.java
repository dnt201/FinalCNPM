package dao.impl;

import dao.OrderItemsDao;
import model.OrderItemsModel;
import utl.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class OrderItemsDaoImpl extends AbstractDao<Integer, OrderItemsModel> implements OrderItemsDao{
    private Class<OrderItemsModel> persistenceClass;

    public OrderItemsDaoImpl() {
        this.persistenceClass = (Class<OrderItemsModel>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName() {
        return persistenceClass.getSimpleName();
    }
    @Override
    public List<OrderItemsModel> findByProductId(Integer id) {
        List<OrderItemsModel> result = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try {
                transaction = session.beginTransaction();
                StringBuilder sql = new StringBuilder("from ");
                sql.append(this.getPersistenceClassName());
                sql.append(" WHERE productModel.product_id= "+id.toString());
                Query query = session.createQuery(sql.toString());
                result = query.list();
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
        return result;
    }
}

package dao.impl;

import dao.ProductDao;
import model.ProductModel;
import utl.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends AbstractDao<Integer, ProductModel> implements ProductDao {

    @Override
    public List<ProductModel> findByBrand(Integer brandId){
        List<ProductModel> products = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                StringBuilder sqlcmd = new StringBuilder("from ");
                sqlcmd.append(this.getPersistenceClassName());
                sqlcmd.append(" WHERE brandModel.brand_id= "+brandId.toString());

                Query query = session.createQuery(sqlcmd.toString());
                products = query.getResultList();
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
        return products;
    }

    @Override
    public List<ProductModel> findByDiscount(Integer discountId){
        List<ProductModel> products = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                StringBuilder sqlcmd = new StringBuilder("from ");
                sqlcmd.append(this.getPersistenceClassName());
                sqlcmd.append(" WHERE discount.discount_id= "+discountId.toString());

                Query query = session.createQuery(sqlcmd.toString());
                products = query.getResultList();
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
        return products;
    }

    @Override
    public ProductModel findByName(String productName){
        List<ProductModel> product = new ArrayList<ProductModel>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                StringBuilder sqlcmd = new StringBuilder("from ");
                sqlcmd.append(this.getPersistenceClassName());
                sqlcmd.append(" WHERE productName= :productName");

                Query query = session.createQuery(sqlcmd.toString());
                query.setParameter("productName", productName);
                product = query.getResultList();
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
        if (product.size()>0) return product.get(0);
        else return null;
    }
}

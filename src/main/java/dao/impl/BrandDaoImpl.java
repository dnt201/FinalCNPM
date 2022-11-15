package dao.impl;

import dao.BrandDao;
import model.BrandModel;
import utl.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class BrandDaoImpl extends AbstractDao<Integer, BrandModel> implements BrandDao {
    @Override
    public BrandModel findByName(String brandName){
        List<BrandModel> brand = new ArrayList<BrandModel>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = null;
            try{
                transaction = session.beginTransaction();
                StringBuilder sqlcmd = new StringBuilder("from ");
                sqlcmd.append(this.getPersistenceClassName());
                sqlcmd.append(" WHERE brand_name= :brandName");

                Query query = session.createQuery(sqlcmd.toString());
                query.setParameter("brandName", brandName);
                brand = query.getResultList();
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
        if (brand.size()>0) return brand.get(0);
        else return null;
    }
}

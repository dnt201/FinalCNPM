package dao.impl;

import dao.RoleDao;
import model.RoleModel;
import utl.HibernateUtil;
import org.hibernate.*;

public class RoleDaoImpl  extends AbstractDao<Integer, RoleModel> implements RoleDao {
    @Override
    public Integer findRoleByRoleName(String roleName){
        Integer role = 0;
        Transaction transaction = null;

        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            try{
                StringBuilder sqlcmd = new StringBuilder("SELECT role_id FROM RoleModel WHERE role_name= :roleName");
                Query query = session.createQuery(sqlcmd.toString());
                query.setParameter("roleName", roleName);

                role = (Integer) query.uniqueResult();
                transaction.commit();
            }
            catch (HibernateException e){
                transaction.rollback();
                throw  e;
            }
            finally {
                session.close();
            }
        }
        catch (HibernateException e){
            System.out.println(e.getMessage());
        }

        return role;
    }
}

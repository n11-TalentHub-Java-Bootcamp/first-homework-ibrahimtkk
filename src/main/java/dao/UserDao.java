package dao;

import base.BaseDao;
import entity.User;
import org.hibernate.query.Query;

public class UserDao extends BaseDao {

    public User findById(Long id) {
        String sql = "select user from User user where user.id =: id";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("id", id);

        return (User) query.list().get(0);
    }



}

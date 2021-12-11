package dao;

import base.BaseDao;
import entity.ProductComment;
import org.hibernate.query.Query;

import java.util.List;

public class ProductCommentDao extends BaseDao {

    public List<ProductComment> findByProductId(Long productId) {
        String sql = "select productComment from ProductComment productComment where productComment.productId =: productId";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("productId", productId);


        return query.list();
    }

    public List<ProductComment> findByUserId(Long userId) {
        String sql = "select productComment from ProductComment productComment where productComment.userId =: userId";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("userId", userId);


        return query.list();
    }

}

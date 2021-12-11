package dao;

import base.BaseDao;
import entity.ProductComment;
import org.hibernate.query.Query;

import java.util.List;

public class ProductCommentDao extends BaseDao {

    public List<ProductComment> findByProductId(Long productId) {
        String sql = "select productComment from ProductComment productComment where productComment.productId =: productId";

        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("productId", String.valueOf(productId));


        return query.list();
    }

}

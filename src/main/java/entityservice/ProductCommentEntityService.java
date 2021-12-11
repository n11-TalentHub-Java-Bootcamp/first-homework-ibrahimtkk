package entityservice;

import dao.ProductCommentDao;
import dao.ProductDao;
import dao.UserDao;
import dto.ProductCommentDto;
import dto.UserCommentDto;
import dto.UserDto;
import entity.Product;
import entity.ProductComment;
import entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class ProductCommentEntityService {

    private ProductCommentDao productCommentDao;
    private ProductDao productDao;
    private UserDao userDao;
    private UserEntityService userEntityService;

    public ProductCommentEntityService() {
        productCommentDao = new ProductCommentDao();
        productDao = new ProductDao();
        userDao = new UserDao();
        userEntityService = new UserEntityService();
    }

    public List<ProductCommentDto> findByProductId(Long productId) {
        List<ProductComment> productComments = productCommentDao.findByProductId(productId);
        Product product = productDao.findById(productId);

        return productComments
                .stream()
                .map(productComment ->
                        ProductCommentDto.builder()
                            .productName(product.getName())
                            .categoryName(product.getCategory().getAdi())
                            .price(product.getPrice())
                            .user(userEntityService.findById(productComment.getUserId())) // TODO: can be refactor
                            .comment(productComment.getComment())
                            .commentDate(productComment.getCommentDate())
                            .build())
                .collect(Collectors.toList());
    }

    public List<UserCommentDto> findByUserId(Long userId) {
        List<ProductComment> productComments = productCommentDao.findByUserId(userId);

        return productComments
                .stream()
                .map(productComment -> {
                    UserDto userDto = userEntityService.findById(productComment.getId());
                    Product product = productDao.findById(productComment.getProductId());
                    return UserCommentDto.builder()
                            .userId(userDto.getId())
                            .username(userDto.getName())
                            .productName(product.getName())
                            .comment(productComment.getComment())
                            .commentDate(productComment.getCommentDate())
                            .build();
                })
                .collect(Collectors.toList());
    }



}

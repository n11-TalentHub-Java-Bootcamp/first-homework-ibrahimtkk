package uygulamalar;

import dto.ProductCommentDto;
import dto.UserCommentDto;
import entity.Product;
import entityservice.ProductCommentEntityService;
import entityservice.ProductEntityService;

import java.util.List;
import java.util.stream.Collectors;

public class CommentsOfOneProductApp {

    public static void main(String[] args) {

        final List<ProductCommentDto> productCommentList = commensOfOneProduct(4L);
    }

    public static List<ProductCommentDto> commensOfOneProduct(Long productId) {
        final ProductCommentEntityService service = new ProductCommentEntityService();
        return service.findByProductId(productId);
    }

}

package uygulamalar;

import dto.ProductCommentDto;
import entity.Product;
import entityservice.ProductCommentEntityService;
import entityservice.ProductEntityService;

import java.util.List;
import java.util.stream.Collectors;

public class FirstHomeWorkApp {

    public static void main(String[] args) {

        final List<ProductCommentDto> productCommentList = commensOfOneProduct(4L);
        final List<ProductCommentDto> productCommentDtoList = commentCountOfAllProducts();
    }

    public static List<ProductCommentDto> commensOfOneProduct(Long productId) {
        final ProductCommentEntityService service = new ProductCommentEntityService();
        return service.findByProductId(productId);
    }

    public static List<ProductCommentDto> commentCountOfAllProducts() {
        final ProductEntityService productEntityService = new ProductEntityService();
        final ProductCommentEntityService productCommentEntityService = new ProductCommentEntityService();
        final List<Product> products = productEntityService.findAll();

        return products
                        .stream()
                        .map(product -> {
                            List<ProductCommentDto> commentsOfOneProduct = productCommentEntityService.findByProductId(product.getId());
                            return ProductCommentDto.builder()
                                    .productId(product.getId())
                                    .productName(product.getName())
                                    .price(product.getPrice())
                                    .commentCount(commentsOfOneProduct.size() > 0 ? commentsOfOneProduct.size() : null)
                                    .build();

                        })
                        .collect(Collectors.toList());
    }
}

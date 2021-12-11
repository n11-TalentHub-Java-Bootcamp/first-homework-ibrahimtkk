package uygulamalar;

import dto.ProductCommentDto;
import entityservice.ProductCommentEntityService;

import java.util.List;

public class FirstHomeWorkApp {

    public static void main(String[] args) {

        ProductCommentEntityService service = new ProductCommentEntityService();
        List<ProductCommentDto> productCommentList = service.findByProductId(4L);

        for (ProductCommentDto productCommentDto : productCommentList) {
            System.out.println(productCommentDto);
        }
    }
}

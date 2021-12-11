package uygulamalar;

import entity.Product;
import entityservice.ProductEntityService;

public class FindByIdApp {

    public static void main(String[] args) {
        ProductEntityService service = new ProductEntityService();
        Product product = service.findById(1L);

        System.out.println(product);
    }
}

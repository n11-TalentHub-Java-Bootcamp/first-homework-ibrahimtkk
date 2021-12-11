package uygulamalar;

import dto.ProductDetailDto;
import entityservice.ProductEntityService;

import java.util.List;

public class DtoApp {

    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        List<ProductDetailDto> urunList = service.findAllUrunDetayDtoByKategoriKirilim(3L);

        for (ProductDetailDto productDetailDto : urunList) {
            System.out.println(productDetailDto);
        }
    }
}

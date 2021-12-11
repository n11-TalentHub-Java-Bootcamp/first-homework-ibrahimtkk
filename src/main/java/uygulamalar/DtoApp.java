package uygulamalar;

import dto.UrunDetayDto;
import entityservice.ProductEntityService;

import java.util.List;

public class DtoApp {

    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        List<UrunDetayDto> urunList = service.findAllUrunDetayDtoByKategoriKirilim(3L);

        for (UrunDetayDto urunDetayDto : urunList) {
            System.out.println(urunDetayDto);
        }
    }
}

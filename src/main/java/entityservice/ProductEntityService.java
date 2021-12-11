package entityservice;

import dao.ProductDao;
import dto.UrunDetayDto;
import entity.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductEntityService {

    private ProductDao productDao;

    public ProductEntityService() {
        productDao = new ProductDao();
    }

    public List<Product> findAll(){
        return productDao.findAll();
    }

    public Product findById(Long id){
        return productDao.findById(id);
    }

    public List<Product> findAllUrunListByFiyatGeAndFiyatLe(BigDecimal fiyatGe, BigDecimal fiyatLe){
        return productDao.findAllUrunListByFiyatGeAndFiyatLe(fiyatGe, fiyatLe);
    }

    public List<Product> findAllUrunListByFiyatBetween(BigDecimal fiyatGe, BigDecimal fiyatLe){
        return productDao.findAllUrunListByFiyatBetween(fiyatGe, fiyatLe);
    }

    public List<Product> findAllUrunByKategoriKirilim(Long kirilim){
        return productDao.findAllUrunByKategoriKirilim(kirilim);
    }

    public List<UrunDetayDto> findAllUrunDetayDtoByKategoriKirilim(Long kirilim) {
        return productDao.findAllUrunDetayDtoByKategoriKirilim(kirilim);
    }

    }

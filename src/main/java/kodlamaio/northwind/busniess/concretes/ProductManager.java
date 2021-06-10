package kodlamaio.northwind.busniess.concretes;

import kodlamaio.northwind.busniess.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<>(productDao.findAll(), "Data listelendi");
    }
    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<>(productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted(){
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<>(productDao.findAll(sort));
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessDataResult<>("Urun eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>(productDao.getByProductName(productName), "Data listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByProductNameAndCategory_CategoryId(productName,categoryId), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByProductNameOrCategory_CategoryId(productName,categoryId), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<>(productDao.getByCategory_CategoryIdIn(categories), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>(productDao.getByProductNameContains(productName), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartingWith(String productName) {
        return new SuccessDataResult<>(productDao.getByProductNameStartingWith(productName),
                "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>(productDao.getByNameAndCategory(productName,categoryId), "Data listelendi");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<>(productDao.getProductWithCategoryDetails());
    }
}

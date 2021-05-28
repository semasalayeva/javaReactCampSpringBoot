package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.busniess.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() {
        return productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody  Product product) {
        return productService.add(product);
    }

    @GetMapping("/getproduct")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory_CategoryId")
    public  DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam String productName,@RequestParam int categoryId){
        return productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllSorted")
    public DataResult<List<Product>> getAllSorted(){
        return productService.getAllSorted();
    }
}

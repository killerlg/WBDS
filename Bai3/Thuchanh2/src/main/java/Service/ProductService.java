package Service;

import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{

    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Iphone 11", "Apple"));
        products.put(2,new Product(2,"Iphone 12", "Apple"));
        products.put(3,new Product(3,"Iphone 13", "Apple"));
        products.put(4,new Product(4,"Iphone 14", "Apple"));
        products.put(5,new Product(5,"Iphone 15", "Apple"));
        products.put(6,new Product(6,"Iphone 16", "Apple"));
        products.put(7,new Product(7,"Iphone 17", "Apple"));
        products.put(8,new Product(8,"Iphone 18", "Apple"));

    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
            products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}

package uk.ac.le.co2103.part2.repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import uk.ac.le.co2103.part2.models.Product;
import uk.ac.le.co2103.part2.models.ShoppingList;
import uk.ac.le.co2103.part2.viewModels.ProductDao;
import uk.ac.le.co2103.part2.viewModels.ProductsDb;
import uk.ac.le.co2103.part2.viewModels.ShoppingListsDb;

public class ProductRepository {
    private ProductDao productDao;
    private LiveData<List<Product>> allProducts;

    public ProductRepository(Application application) {
        ProductsDb db = ProductsDb.getDatabase(application);
        productDao = db.ProductsDao();
        allProducts = productDao.findAll();
    }

    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }

    public void insert(Product product) {
        ShoppingListsDb.databaseWriteExecutor.execute(() -> {
            productDao.insert(product);
        });
    }
}

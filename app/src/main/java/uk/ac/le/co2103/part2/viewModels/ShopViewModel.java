package uk.ac.le.co2103.part2.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import uk.ac.le.co2103.part2.models.ShoppingList;
import uk.ac.le.co2103.part2.repos.ProductRepository;
import uk.ac.le.co2103.part2.repos.ShoppingListRepository;

public class ShopViewModel extends AndroidViewModel {
    private ShoppingListRepository repo;
    private ProductRepository p_repo;

    private final LiveData<List<ShoppingList>> allItems;

    public ShopViewModel(Application application) {
        super(application);
        repo = new ShoppingListRepository(application);
        p_repo = new ProductRepository(application);
        allItems = repo.getAllLists();

    }
    LiveData<List<ShoppingList>> getAllItems() { return allItems; }
    public void insert(ShoppingList item) {
        repo.insert(item);
    }
}
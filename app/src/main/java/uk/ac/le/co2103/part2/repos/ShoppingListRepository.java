
package uk.ac.le.co2103.part2.repos;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import uk.ac.le.co2103.part2.models.Product;
import uk.ac.le.co2103.part2.models.ShoppingList;
import uk.ac.le.co2103.part2.viewModels.ShoppingListDao;
import uk.ac.le.co2103.part2.viewModels.ShoppingListsDb;

public class ShoppingListRepository {
    private ShoppingListDao shoppingListDao;
    private LiveData<List<ShoppingList>> allLists;

    public ShoppingListRepository(Application application) {
        ShoppingListsDb db = ShoppingListsDb.getDatabase(application);
        shoppingListDao = db.shoppingListDao();
        allLists = shoppingListDao.getShoppingList();
    }

    public LiveData<List<ShoppingList>> getAllLists() {
        return allLists;
    }

    public void insert(ShoppingList shoppingList) {
        ShoppingListsDb.databaseWriteExecutor.execute(() -> {
            shoppingListDao.insert(shoppingList);
        });
    }
    public void deleteAllLists() {
        ShoppingListsDb.databaseWriteExecutor.execute(() -> {
            shoppingListDao.deleteAll();
        });
    }
}

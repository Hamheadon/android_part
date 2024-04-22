package uk.ac.le.co2103.part2.viewModels;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import uk.ac.le.co2103.part2.models.Product;
import uk.ac.le.co2103.part2.models.ShoppingList;

@Dao
public interface ShoppingListDao {
    @Insert
    void insert(ShoppingList list);

    //TODO: check that no error comes from here
    @Query("SELECT * from SHOPPINGLIST Order by listId ASC")
    LiveData<List<ShoppingList>> getShoppingList();

    @Query("DELETE FROM shoppingList")
    void deleteAll();
}

package uk.ac.le.co2103.part2.viewModels;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import uk.ac.le.co2103.part2.models.Product;
import uk.ac.le.co2103.part2.models.ShoppingList;

@Dao
public interface ProductDao {


    @Insert
    void insert(Product product);


    //TODO: check that no error comes from here
    @Query("SELECT * from Product Order by Name ASC")
    LiveData<List<Product>> findAll();

    @Query("DELETE FROM Product")
    void deleteAll();

    @Query("SELECT * FROM Product WHERE parentId = :id")
    public LiveData<List<Product>> findByParentId(int id);


}

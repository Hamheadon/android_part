package uk.ac.le.co2103.part2.viewModels;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import uk.ac.le.co2103.part2.models.Product;
import uk.ac.le.co2103.part2.models.ShoppingList;


@Database(entities = {Product.class, ShoppingList.class}, version = 1, exportSchema = false)
public abstract class ProductsDb extends RoomDatabase {

    public abstract ProductDao ProductsDao();

    private static volatile ProductsDb INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ProductsDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductsDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ProductsDb.class, "Products_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

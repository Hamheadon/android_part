package uk.ac.le.co2103.part2.viewModels;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import uk.ac.le.co2103.part2.models.Product;
import uk.ac.le.co2103.part2.models.ShoppingList;

//TODO: check that this is not an error area (having two separate db classes)

@Database(entities = {ShoppingList.class}, version = 1, exportSchema = false)
public abstract class ShoppingListsDb extends RoomDatabase {

    public abstract ShoppingListDao shoppingListDao();
    private static volatile ShoppingListsDb INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static ShoppingListsDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ShoppingListsDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ShoppingListsDb.class, "shoppingcart_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
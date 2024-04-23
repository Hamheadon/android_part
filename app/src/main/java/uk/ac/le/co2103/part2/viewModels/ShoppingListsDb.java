package uk.ac.le.co2103.part2.viewModels;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import uk.ac.le.co2103.part2.models.ShoppingList;

//TODO: check that this is not an error area (having two separate db classes)

@Database(entities = {ShoppingList.class}, version = 1, exportSchema = false)
public abstract class ShoppingListsDb extends RoomDatabase {


    public abstract ShoppingListDao ShoppingList();

    private static volatile ShoppingListsDb INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ShoppingListsDb getDatabase(final Context context) {
        if (!Objects.isNull(INSTANCE))
            return INSTANCE;


        synchronized (ShoppingListsDb.class) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                ShoppingListsDb.class, "shoppingList_db")
                        .build();
            }
        }

        return INSTANCE;
    }

}

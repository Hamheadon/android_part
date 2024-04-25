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

@Database(entities = {ShoppingList.class, Product.class}, version = 1, exportSchema = false)
public abstract class ShoppingListsDb extends RoomDatabase {


    public abstract ShoppingListDao ShoppingListDao();

    private static volatile ShoppingListsDb INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ShoppingListsDb getDatabase(final Context context) {
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

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                ShoppingListDao dao = INSTANCE.ShoppingListDao();
                dao.deleteAll();
                ShoppingList shoppingList = new ShoppingList(0,"listIndex0");
                dao.insert(shoppingList);

            });
        }
    };

}


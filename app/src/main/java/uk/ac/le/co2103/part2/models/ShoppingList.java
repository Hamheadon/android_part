package uk.ac.le.co2103.part2.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shoppingList")
public class ShoppingList {

    @PrimaryKey(autoGenerate = true)
    public int listId;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "name")
    public String name;

    @NonNull @ColumnInfo(name = "image")
    public String image;

    @NonNull @ColumnInfo(name = "quantity")
    public int quantity;

    @NonNull @ColumnInfo(name = "unit")
    public String unit;


    public ShoppingList(@NonNull String name, @NonNull String image, @NonNull  int quantity,
                        @NonNull String unit){
        this.name = name;
        this.image = image;
        this.quantity = quantity;
        this.unit = unit;
    }

}

package uk.ac.le.co2103.part2.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "shoppingList", primaryKeys = {"customId", "listId"})
public class ShoppingList {


    @ColumnInfo(name = "listId")
    public int listId;

    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "image")
    public String image;




    public ShoppingList(@NonNull String name){
        this.name = name;

    }

    public String getItem(){
        return name;
    }

}

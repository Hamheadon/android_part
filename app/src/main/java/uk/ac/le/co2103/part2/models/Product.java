package uk.ac.le.co2103.part2.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(tableName = "Product") //TODO: possible cause for errors
public class Product {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    @NonNull
    @ColumnInfo(name = "quantity")
    public int quantity;

    @NonNull @ColumnInfo(name = "unit")
    public String unit;

    @NonNull @ColumnInfo(name = "")
    public int parentId;

    public Product(@NonNull int quantity, @NonNull String unit){
        this.quantity = quantity;
        this.unit = unit;
    }


}

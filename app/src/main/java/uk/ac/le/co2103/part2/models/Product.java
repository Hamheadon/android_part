package uk.ac.le.co2103.part2.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product")
public class Product {
    @PrimaryKey
    @ColumnInfo(name = "name")
    public String name;
}

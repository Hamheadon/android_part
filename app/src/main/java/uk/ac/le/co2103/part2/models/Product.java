package uk.ac.le.co2103.part2.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product")
public class Product {
    @PrimaryKey
    String name;
}

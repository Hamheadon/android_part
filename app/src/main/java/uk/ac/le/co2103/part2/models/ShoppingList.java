package uk.ac.le.co2103.part2.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Objects;

@Entity(tableName = "shoppingList")
public class ShoppingList {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingList that = (ShoppingList) o;
        return getListId() == that.getListId() && Objects.equals(getName(), that.getName()) && Objects.equals(getImage(), that.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getListId(), getName(), getImage());
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "listId") //TODO: make auto generated
    private int listId;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "image")
    private String image;

    public ShoppingList(@NonNull String name) {
        this.name = name;
        this.image = null;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
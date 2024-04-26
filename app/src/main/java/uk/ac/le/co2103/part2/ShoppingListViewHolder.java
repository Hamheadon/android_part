package uk.ac.le.co2103.part2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingListViewHolder extends RecyclerView.ViewHolder {

    private TextView itemTextView;
    private ImageView listImage;

    private ShoppingListViewHolder(@NonNull View itemView) {
        super(itemView);
        itemTextView = itemView.findViewById(R.id.listName);
        listImage = itemView.findViewById(R.id.listImage);

    }

    public void bind(String text) {
        itemTextView.setText(text);
    }

    public void bindImage(String img_location){
        //listImage.setImageResource(R.drawable.f);
    }

    static ShoppingListViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_row, parent, false);
        return new ShoppingListViewHolder(view);
    }
}

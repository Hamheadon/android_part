package uk.ac.le.co2103.part2;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingListViewHolder extends RecyclerView.ViewHolder {

    private final TextView itemTextView;
    private final ImageView listImage;

    private ShoppingListViewHolder(View itemView) {
        super(itemView);
        itemTextView = itemView.findViewById(R.id.listName);
        listImage = itemView.findViewById(R.id.listImage);

    }

    public void bind(String text) {
        itemTextView.setText(text);
    }

    public void bindImage(String img_location){
        listImage.setImageURI(Uri.parse(img_location));
    }

    public static ShoppingListViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_row, parent, false);
        return new ShoppingListViewHolder(view);
    }
}

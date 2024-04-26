package uk.ac.le.co2103.part2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uk.ac.le.co2103.part2.models.ShoppingList;
import uk.ac.le.co2103.part2.viewModels.ShopViewModel;

public class ShoppingListListAdapter extends ListAdapter<ShoppingList, ShoppingListViewHolder> {


    private ShopViewModel shopViewModel;
    ArrayList<ShoppingList> shoppingListsModels;
    public ShoppingListListAdapter(@NonNull DiffUtil.ItemCallback<ShoppingList> diffCallback)
    {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ShoppingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return ShoppingListViewHolder.create(parent);
    }
//    @Override
//    public void onBindViewHolder(ShoppingListView holder, int position) {
//        ShoppingList current = getItem(position);
//        holder.bind(current.getName());
//    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView tvShopingLisName;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.listImage);
        tvShopingLisName = itemView.findViewById(R.id.listName);
    }
}

    @Override
    public void onBindViewHolder(@NonNull ShoppingListViewHolder holder, int position) {
        //holder.tvShopingLisName.setText(shoppingListsModels.get(position).getName());
        ShoppingList current = getItem(position);
        holder.bind(current.getName());


    }

    static class ItemDiff extends DiffUtil.ItemCallback<ShoppingList> {
        @Override
        public boolean areItemsTheSame(@NonNull ShoppingList oldShop, @NonNull ShoppingList newShop) {
            return oldShop == newShop;
        }
        @Override
        public boolean areContentsTheSame(@NonNull ShoppingList oldShoppingList, @NonNull ShoppingList newShoppingList) {
            return oldShoppingList.getName().equals(newShoppingList.getName());
        }
    }
}

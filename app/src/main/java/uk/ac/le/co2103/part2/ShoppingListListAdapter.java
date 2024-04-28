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


    public ShoppingListListAdapter()
    {
        super(ShoppingListListAdapter.DIFF_CALLBACK);
    }

    //TODO: problem area
    @NonNull
    @Override
    public ShoppingListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return ShoppingListViewHolder.create(parent);
    }
//    @Override
//    public void onBindViewHolder(ShoppingListView holder, int position) {
//        ShoppingList current = getItem(position);
//        holder.bind(current.getName());
//    }


    @Override
    public void onBindViewHolder(ShoppingListViewHolder holder, int position) {
        //holder.tvShopingLisName.setText(shoppingListsModels.get(position).getName());
        ShoppingList current = getItem(position);
        holder.bind(current.getName());
        //Todo: uncomment this under,  we commented for debugging
        //holder.bindImage(current.getImage());


    }
    public static final DiffUtil.ItemCallback<ShoppingList> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ShoppingList>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull ShoppingList oldShoppingList, @NonNull ShoppingList newShoppingList) {
                    // ShoppingList properties may have changed if reloaded from the DB, but ID is fixed
                    return oldShoppingList.getListId() == newShoppingList.getListId();
                }
                @Override
                public boolean areContentsTheSame(
                        @NonNull ShoppingList oldShoppingList, @NonNull ShoppingList newShoppingList) {
                    // NOTE: if you use equals, your object must properly override Object#equals()
                    // Incorrectly returning false here will result in too many animations.
                    return oldShoppingList.equals(newShoppingList);
                }
            };

//    static class ItemDiff extends DiffUtil.ItemCallback<ShoppingList> {
//        @Override
//        public boolean areItemsTheSame(@NonNull ShoppingList oldShop, @NonNull ShoppingList newShop) {
//            return oldShop == newShop;
//        }
//        @Override
//        public boolean areContentsTheSame(@NonNull ShoppingList oldShoppingList, @NonNull ShoppingList newShoppingList) {
//            return oldShoppingList.getName().equals(newShoppingList.getName());
//        }
//    }
}

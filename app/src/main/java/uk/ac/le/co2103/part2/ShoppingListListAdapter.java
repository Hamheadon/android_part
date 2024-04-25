package uk.ac.le.co2103.part2;

import android.content.ClipData;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import uk.ac.le.co2103.part2.models.ShoppingList;
import uk.ac.le.co2103.part2.viewModels.ShopViewModel;

public class ShoppingListListAdapter extends ListAdapter<ShoppingList, ShoppingListView> {

    private ShopViewModel shopViewModel;
    public ShoppingListListAdapter(@NonNull DiffUtil.ItemCallback<ShoppingList> diffCallback)
    {
        super(diffCallback);
    }
    @NonNull
    @Override
    public ShoppingListView onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return ShoppingListView.create(parent);
    }
    @Override
    public void onBindViewHolder(ShoppingListView holder, int position) {
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

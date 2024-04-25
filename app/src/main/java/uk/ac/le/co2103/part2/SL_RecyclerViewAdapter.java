package uk.ac.le.co2103.part2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uk.ac.le.co2103.part2.models.ShoppingList;

public class SL_RecyclerViewAdapter extends RecyclerView.Adapter<SL_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<ShoppingList> shoppingListsModels;

    public SL_RecyclerViewAdapter(Context context, ArrayList<ShoppingList> shoppingListsModels) {
        this.context = context;
        this.shoppingListsModels = shoppingListsModels;
    }

    @NonNull
    @Override
    public SL_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.recycler_view_row,parent,false);

        return new SL_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SL_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvShopingLisName.setText(shoppingListsModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return shoppingListsModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvShopingLisName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            tvShopingLisName = itemView.findViewById(R.id.textView);
        }
    }
}

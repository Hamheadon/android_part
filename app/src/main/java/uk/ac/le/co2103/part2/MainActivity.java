package uk.ac.le.co2103.part2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

import uk.ac.le.co2103.part2.models.ShoppingList;
import uk.ac.le.co2103.part2.viewModels.ShopViewModel;

public class MainActivity extends AppCompatActivity {

    private ShopViewModel shopViewModel;

    ArrayList<ShoppingList> shoppingListModels = new ArrayList<>();

     private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        new File("/data/data/uk.ac.le.co2103.hw4/code_cache/.overlay/base.apk/classes6.dex").setReadOnly();
       // Log.d(TAG, "onCreate()");

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.shoppingRecyclerView);


        ShoppingListListAdapter adapter = new ShoppingListListAdapter();
        if (Objects.isNull(recyclerView)){
            System.out.println("ThE ADAP IS BUGI");
            return;
        }
        System.out.println("TIS NOT NULL BA");

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        shopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        shopViewModel.getAllLists().observe(this, items -> {
           adapter.submitList(items);
        });


        //final FloatingActionButton button = findViewById(R.id.fab);
//        button.setOnClickListener(view -> {
//            Log.d(TAG, "Floating action button clicked.");
//            Toast.makeText(getApplicationContext(), "Not implemented yet.", Toast.LENGTH_LONG).show();
//        })

    }
    public void openCreateListActivity(View view){
        Intent intent = new Intent(this, CreateListActivity.class);
        startActivity(intent);
    }


//    public void setUpShoppingListModels(){
//        String[] shoppingListNames = getResources().getStringArray(R.array.placeholderText);
//
//        for(int i = 0; i<shoppingListNames.length; i++){ //Todo: add images later
//            shoppingListModels.add(new ShoppingList(i, shoppingListNames[i]));
//        }
//
//    }

}
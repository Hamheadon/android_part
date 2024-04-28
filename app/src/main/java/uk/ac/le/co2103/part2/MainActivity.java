package uk.ac.le.co2103.part2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ArrayList;

import uk.ac.le.co2103.part2.models.ShoppingList;
import uk.ac.le.co2103.part2.viewModels.ShopViewModel;

public class MainActivity extends AppCompatActivity {


    private ShopViewModel shopViewModel;

    ArrayList<ShoppingList> shoppingListModels = new ArrayList<>();

     private static final String TAG = MainActivity.class.getSimpleName();
     private static final int PERMISSION_REQUEST_CODE = 100;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        new File("/data/data/uk.ac.le.co2103.hw4/code_cache/.overlay/base.apk/classes6.dex").setReadOnly();
       // Log.d(TAG, "onCreate()");

        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission has not been granted, so request it
            requestPermission();
        } else {
            // Permission is already granted, do your work here
            // For example, launch the gallery
            sortOutAdapter();
        }




        //final FloatingActionButton button = findViewById(R.id.fab);
//        button.setOnClickListener(view -> {
//            Log.d(TAG, "Floating action button clicked.");
//            Toast.makeText(getApplicationContext(), "Not implemented yet.", Toast.LENGTH_LONG).show();
//        })

    }

    public void sortOutAdapter(){
        RecyclerView recyclerView = findViewById(R.id.shoppingRecyclerView);


        setUpShoppingListModels();


        ShoppingListListAdapter adapter = new ShoppingListListAdapter();
        if (Objects.isNull(recyclerView)){
            System.out.println("ThE ADAP IS BUGI");
            return;
        }
        System.out.println("TIS NOT NULL BA");

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        shopViewModel = new ViewModelProvider(MainActivity.this).get(ShopViewModel.class);
        shopViewModel.getAllLists().observe(MainActivity.this, items -> {
            adapter.submitList(items);
        });
        shopViewModel.deleteAllLists();

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

    public void setUpShoppingListModels(){
        String[] shoppingListNames = getResources().getStringArray(R.array.placeholderText);

        for(int i = 0; i<shoppingListNames.length; i++){ //Todo: add images later
            shoppingListModels.add(new ShoppingList(shoppingListNames[i]));
        }

    }

    private void requestPermission() {
        // Request permission from the user
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            // Check if permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted, do your work here
                // For example, launch the gallery
                sortOutAdapter();
            } else {
                // Permission is denied, inform the user
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
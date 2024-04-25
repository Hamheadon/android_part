package uk.ac.le.co2103.part2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import uk.ac.le.co2103.part2.models.ShoppingList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ShoppingList> shoppingListModels = new ArrayList<>();

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate()");

        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.shoppingRecyclerView);

        setUpShoppingListModels();

        SL_RecyclerViewAdapter adapter = new SL_RecyclerViewAdapter(this,shoppingListModels);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final FloatingActionButton button = findViewById(R.id.fab);
//        button.setOnClickListener(view -> {
//            Log.d(TAG, "Floating action button clicked.");
//            Toast.makeText(getApplicationContext(), "Not implemented yet.", Toast.LENGTH_LONG).show();
//        });

    }
    public void openCreateListActivity(View view){
        Intent intent = new Intent(this, CreateListActivity.class);
        startActivity(intent);
    }


    public void setUpShoppingListModels(){
        String[] shoppingListNames = getResources().getStringArray(R.array.placeholderText);

        for(int i = 0; i<shoppingListNames.length; i++){ //Todo: add images later
            shoppingListModels.add(new ShoppingList(i,shoppingListNames[i]));
        }

    }

}
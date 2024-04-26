package uk.ac.le.co2103.part2;

import static android.app.PendingIntent.getActivity;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateListActivity extends AppCompatActivity {

    public static String shoppingListName = "uk.edu.le.co2103.part2.ShoppingList.name";
    TextView nameInput;
    ImageView imageSelector;
    Button selectorBtn;
    Button createBtn;
    ActivityResultLauncher<Intent> resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_list_activity);
        imageSelector = findViewById(R.id.shopListImgPreview);
        nameInput = findViewById(R.id.name_Input);
        selectorBtn = findViewById(R.id.selectImgBtn);
        registerImageSelection();
        selectorBtn.setOnClickListener(view -> pickImage());

        shoppingListName = String.valueOf(findViewById(R.id.name_Input));
        createBtn = findViewById(R.id.create_button);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Shopping list Name is:" + shoppingListName);
            }


        });

    }

//    public void createShoppingList(View view){
//        Intent intent = new Intent(this, MainActivity.class);
//        EditText editText = (EditText) view.getRootView().findViewById(R.id.name_Input);
//        String message = editText.getText().toString();
//        intent.putExtra(shoppingListName, message);
//        startActivity(intent);
//    }


    private void pickImage()
    {
        Intent intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
        resultLauncher.launch(intent);
    }
    private void registerImageSelection(){
        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        try {
                            Uri imageUri = result.getData().getData();

                            imageSelector.setImageURI(imageUri);
                        } catch (Exception e){
                            Toast.makeText(CreateListActivity.this, "No image selected", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

}
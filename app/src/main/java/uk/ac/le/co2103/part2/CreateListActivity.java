package uk.ac.le.co2103.part2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateListActivity extends AppCompatActivity {

    TextView nameInput;
    ImageView imageSelector;
    Button selectorBtn;
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
    }

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
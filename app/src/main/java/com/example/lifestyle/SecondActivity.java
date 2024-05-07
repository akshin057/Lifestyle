package com.example.lifestyle;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    Toolbar secondToolBarTB;
    TextView indexTV;
    TextView recommendationTV;
    ImageView imageViewIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondToolBarTB = findViewById(R.id.secondToolBarTB);
        indexTV = findViewById(R.id.indexTV);
        recommendationTV = findViewById(R.id.recommendationTV);
        imageViewIV = findViewById(R.id.imageViewIV);


        setSupportActionBar(secondToolBarTB);
        getSupportActionBar().setTitle("Результаты");
        getSupportActionBar().setSubtitle("Версия 1.0");
        getSupportActionBar().setLogo(R.drawable.healthy_logo);

        String indexString = getIntent().getStringExtra("index");

        Double index = Double.parseDouble(indexString);
        setBody(index, imageViewIV, recommendationTV, indexTV);
    }

    public static void setBody(Double index, ImageView imageView, TextView recommendationTV, TextView indexTV){
        if (index < 18.5){
            imageView.setImageResource(R.drawable.slim_person);
            recommendationTV.setText(R.string.recommendation_for_slim_person);
        } else if (index >= 18.5 && index < 25){
            imageView.setImageResource(R.drawable.fit_person);
            recommendationTV.setText(R.string.recommendation_for_fit_person);
        } else if (index >= 25 && index < 30) {
            imageView.setImageResource(R.drawable.pretty_fat_person);
            recommendationTV.setText(R.string.recommendation_for_pretty_fat_person);
        } else if (index >= 30) {
            imageView.setImageResource(R.drawable.fat_person);
            recommendationTV.setText(R.string.recommendation_for_fat_person);
        }
        indexTV.setText(String.valueOf(Math.ceil(index)));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.recalculateBTN){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Введите значения заново", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
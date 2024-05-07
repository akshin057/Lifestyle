package com.example.lifestyle;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText heightET;
    EditText weightET;
    Toolbar toolBarTB;
    Button calculateBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightET = findViewById(R.id.heightET);
        weightET = findViewById(R.id.weightET);
        toolBarTB = findViewById(R.id.toolBarTB);
        calculateBTN = findViewById(R.id.calculateBTN);

        setSupportActionBar(toolBarTB);
        getSupportActionBar().setTitle("Расчет индекса массы тела");
        getSupportActionBar().setSubtitle("Версия 1.0");
        getSupportActionBar().setLogo(R.drawable.healthy_logo);

        calculateBTN.setOnClickListener(v -> {
            Double weight = Double.parseDouble(weightET.getText().toString());
            Double height = Double.parseDouble(heightET.getText().toString());
            Double height1 = height/100;

            Intent intent = new Intent(this, SecondActivity.class);
            String index = String.valueOf(weight/Math.pow(height1,2));

            intent.putExtra("index", index);
            startActivity(intent);
            finish();
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.exitBTN){
            finish();
            Toast.makeText(this, "Приложение закрыто", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
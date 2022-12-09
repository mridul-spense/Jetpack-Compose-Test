package com.spense.android.jetpackcomposetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText input;
    private MaterialButton submitButton;

    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textview);
        input = findViewById(R.id.input);
        submitButton = findViewById(R.id.submitButton);

        textview.setText(getIntent().getStringExtra("nameValue"));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ComposeActivity.class);
                i.putExtra("name", input.getText().toString().trim());
                startActivity(i);
                finish();
            }
        });
    }
}
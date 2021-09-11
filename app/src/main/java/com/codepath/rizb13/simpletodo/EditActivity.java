package com.codepath.rizb13.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class EditActivity extends AppCompatActivity {

    EditText utItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        utItem = findViewById(R.id.utItem);
        btnSave = findViewById(R.id.btnSave);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Edit Item!");

        utItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        //
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create intent of update item:
                Intent intent = new Intent();

                //pass updated value:
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, utItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                //set result:
                setResult(RESULT_OK,intent);

                //close activity:
                finish();
            }
        });
    }
}
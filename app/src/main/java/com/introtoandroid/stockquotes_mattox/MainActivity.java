package com.introtoandroid.stockquotes_mattox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button getStocks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        getStocks = findViewById(R.id.getStocks);

        getStocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placeHolder;
                if(editText.getText().toString().length() > 0) {
                    placeHolder = editText.getText().toString();
                    Stock stock = new Stock(placeHolder);
                    AsyncTaskStock stockLoaded = new AsyncTaskStock(stock);
                    stockLoaded.execute();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter valid symbol", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(editText.getText().toString() != ""){
            outState.putString("editText", editText.getText().toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String placeHolder = savedInstanceState.getString("editText");
        editText.setText(placeHolder);
    }
}

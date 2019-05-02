package com.introtoandroid.stockquotes_mattox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button getStocks;
    private TextView symbol;
    private TextView name;
    private TextView price;
    private TextView time;
    private TextView change;
    private TextView year;

    TextView[] textViewsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        getStocks = findViewById(R.id.getStocks);

        symbol = findViewById(R.id.textVSymbol);
        name = findViewById(R.id.textVName);
        price = findViewById(R.id.textVPrice);
        time = findViewById(R.id.textVTime);
        change = findViewById(R.id.textVChange);
        year = findViewById(R.id.textVYear);

        textViewsArray = new  TextView[] {symbol, name, price, time, change, year};



        getStocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placeHolder;
                if(editText.getText().toString().length() > 0) {
                    placeHolder = editText.getText().toString();
                    Stock stock = new Stock(placeHolder);
                    AsyncTaskStock stockLoaded = new AsyncTaskStock(stock, textViewsArray, getApplicationContext());

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
        if(symbol.getText() != ""){
            outState.putString("symbol", symbol.getText().toString());
            outState.putString("name", name.getText().toString());
            outState.putString("price", price.getText().toString());
            outState.putString("time", time.getText().toString());
            outState.putString("change", change.getText().toString());
            outState.putString("year", year.getText().toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String placeHolder = savedInstanceState.getString("editText");
        editText.setText(placeHolder);
        placeHolder = savedInstanceState.getString("symbol");
        symbol.setText(placeHolder);
        placeHolder = savedInstanceState.getString("name");
        name.setText(placeHolder);
        placeHolder = savedInstanceState.getString("price");
        price.setText(placeHolder);
        placeHolder = savedInstanceState.getString("time");
        time.setText(placeHolder);
        placeHolder = savedInstanceState.getString("change");
        change.setText(placeHolder);
        placeHolder = savedInstanceState.getString("year");
        year.setText(placeHolder);
    }

}

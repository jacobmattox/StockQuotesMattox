package com.introtoandroid.stockquotes_mattox;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskStock extends AsyncTask<Stock, Void, Stock> {

    private Stock stock;
    private TextView[] textViews;

    public AsyncTaskStock(Stock stock, TextView[] textViews) {
        this.stock = stock;
        this.textViews = textViews;
    }

    @Override
    protected Stock doInBackground(Stock... Stock) {
        try{
            stock.load();
            System.out.println("did it load");
            return stock;
        }
        catch(Exception e){
            return null;
        }

    }

    @Override
    protected void onPostExecute(Stock s) {
        super.onPostExecute(s);
        textViews[0].setText(s.getSymbol());
        textViews[1].setText(s.getName());
        textViews[2].setText(s.getLastTradePrice());
        textViews[3].setText(s.getLastTradeTime());
        textViews[4].setText(s.getChange());
        textViews[5].setText(s.getRange());

        if(Double.parseDouble(s.getChange()) > 0){
            textViews[4].setTextColor(Color.GREEN);
        }
        else if(Double.parseDouble(s.getChange()) < 0){
            textViews[4].setTextColor(Color.RED);
        }

    }
}


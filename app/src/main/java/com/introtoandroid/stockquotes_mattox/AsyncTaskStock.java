package com.introtoandroid.stockquotes_mattox;

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

    public AsyncTaskStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    protected Stock doInBackground(Stock... Stock) {
        try{
            stock.load();
        }
        catch(Exception e){
        }
        return stock;
    }

    @Override
    protected void onPostExecute(Stock s) {
        super.onPostExecute(s);
        Log.v("whatever", s.getName());

    }
}


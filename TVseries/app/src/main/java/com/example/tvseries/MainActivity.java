package com.example.tvseries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SeriesList seriesList= new SeriesList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickChoose(View view) {
        TextView textView =  findViewById(R.id.series_text);
        Spinner spinner = findViewById(R.id.genre_list);
        String getList = String.valueOf(spinner.getSelectedItem());
        List<String> listTV = seriesList.getListTV(getList);
        StringBuilder listModified = new StringBuilder();
        for (String list : listTV){
            listModified.append(list).append("\n");
        }
        textView.setText(listModified);
    }
}

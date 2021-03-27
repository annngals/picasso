package com.example.picasso;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.products_list);

        DatabaseWork databaseWork = DatabaseWork.getInstance(getApplicationContext());
        databaseWork.open();

        Cursor c = DatabaseWork.getData();

        ProductsAdapter adapter = new ProductsAdapter(this, c, 0);
        lv.setAdapter(adapter);
        databaseWork.close();
    }
}
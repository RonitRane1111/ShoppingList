package com.ronit.myapplication;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   Button button;

   EditText shoppingName;

    ListView listView;

    ShoppingLIstAdapterd adapter;
    ArrayList<ShoppingList> list;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

         button = findViewById(R.id.btn);
         listView = findViewById(R.id.listView);
         shoppingName = findViewById(R.id.itemname);
         list = new ArrayList<ShoppingList>();
         adapter = new ShoppingLIstAdapterd(this, list);
         listView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            String text = shoppingName.getText().toString();
            if(!text.isEmpty()){
              list.add(new ShoppingList(text));
              adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}

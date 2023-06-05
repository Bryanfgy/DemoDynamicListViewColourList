package com.example.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement, etIndexElement;
    Button btnAdd, btnEdit, btnRemove;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;
    String colourAdd;
    String colourEdit;
    
    String colour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etIndexElement = findViewById(R.id.editTextIndex);
        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAdditem);
        btnEdit = findViewById(R.id.buttonEditItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        lvColour = findViewById(R.id.listViewColour);

        alColours = new ArrayList<String>();
        alColours.add("red");
        alColours.add("orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               colourAdd = etElement.getText().toString();
               //alColours.add(colourAdd);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos-1, colourAdd);
                aaColour.notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colourEdit = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos-1 , colourEdit);
                aaColour.notifyDataSetChanged();
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos-1);
                aaColour.notifyDataSetChanged();
            }
        });



        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                colour = aaColour.getItem(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_LONG).show();
            }
        });




    }
}
package sg.edu.rp.c346.id22021538.demodynamiclistviewcolourlist;

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

    EditText etElement;
    Button btnAdd;
    ListView lvColour;
    EditText etIndex;
    Button btnRemove;
    Button btnUpdate;


    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndex = findViewById(R.id.editTextIndex);
        btnRemove = findViewById(R.id.buttonRemoveColour);
        btnUpdate = findViewById(R.id.buttonUpdateColour);

        ArrayList<String> alColours;
        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colourInput = etElement.getText().toString();
                //alColours.add(colourInput);
                int pos = Integer.parseInt(etElement.getText().toString());
                alColours.add(pos, colourInput);

                aaColour.notifyDataSetChanged();
            }
        });
        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etElement.getText().toString());
                alColours.remove(pos);

                aaColour.notifyDataSetChanged();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updateColour = etElement.getText().toString();
                int pos = Integer.parseInt(etElement.getText().toString());
                alColours.set(pos, updateColour);

                aaColour.notifyDataSetChanged();
            }
        });
    }
}
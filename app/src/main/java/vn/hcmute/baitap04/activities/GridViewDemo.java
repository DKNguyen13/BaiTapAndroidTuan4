package vn.hcmute.baitap04.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import vn.hcmute.baitap04.R;

public class GridViewDemo extends AppCompatActivity {

    GridView gridView;
    List<String> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gridView = (GridView) findViewById(R.id.gridView);
        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("C++");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(GridViewDemo.this, android.R.layout.simple_list_item_1, arrayList);
        gridView.setAdapter(arrayAdapter);

        //Bat su kien click vao items
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewDemo.this,"Ban dang nhan :"+arrayList.get(i),Toast.LENGTH_SHORT).show();
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewDemo.this, "Ban dang an giu:"+ i+" - "+arrayList.get(i), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

}
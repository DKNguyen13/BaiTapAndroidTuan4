package vn.hcmute.baitap04.activities;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import vn.hcmute.baitap04.adapter.MonhocAdapter;
import vn.hcmute.baitap04.R;
import vn.hcmute.baitap04.models.MonHoc;

public class CustomAdapterGridView extends AppCompatActivity {

    GridView gridView;
    List<MonHoc> arrayList = new ArrayList<>();
    MonhocAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_adapter_grid_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gridView = (GridView) findViewById(R.id.gridV);
        arrayList.add(new MonHoc("Java","Java 1",R.drawable.java1));
        arrayList.add(new MonHoc("C#","C# 1",R.drawable.c));
        arrayList.add(new MonHoc("PHP","PHP 1",R.drawable.php));

        adapter = new MonhocAdapter(CustomAdapterGridView.this,R.layout.row_monhoc1,arrayList);
        //Truyen du lieu ra grid view tu adapter
        gridView.setAdapter(adapter);
    }
}

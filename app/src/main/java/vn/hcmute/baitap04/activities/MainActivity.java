package vn.hcmute.baitap04.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import vn.hcmute.baitap04.R;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    Button btnNhap, updatebtn, deleteBtn;
    private int index;
    //ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AnhXa();
        //Create array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                arrayList
        );
        listView.setAdapter(adapter);


        //Bắt sự kiện trên từ dòng
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Ban dang nhan vao "+ arrayList.get(i),Toast.LENGTH_SHORT).show();
                //Length_short = 2s, length_long = 3.5s
                //Toast view là hiển thị thông báo
                editText.setText(arrayList.get(i));
                index = i;
            }
        });


        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                arrayList.add(name);
                    adapter.notifyDataSetChanged();
            }
        });

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.set(index, editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(index);
                adapter.notifyDataSetChanged();
            }
        });
    }
    private  void AnhXa(){
        //List view
        listView = (ListView)findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);
        btnNhap = (Button)findViewById(R.id.nhapBtn);
        updatebtn = (Button) findViewById(R.id.updateBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);

        //Add data to list
        arrayList.add("C#");
        arrayList.add("C++");
        arrayList.add("java");
 /*

        //Thêm dữ liệu vào List
        arrayList = new ArrayList<>();
        arrayList.add(new MonHoc("Java","Java 1",R.drawable.java1));
        arrayList.add(new MonHoc("C#","C# 1",R.drawable.c));
        arrayList.add(new MonHoc("PHP","PHP 1",R.drawable.php));
        arrayList.add(new MonHoc("Kotlin","Kotlin",R.drawable.kotlin));*/
    }

}

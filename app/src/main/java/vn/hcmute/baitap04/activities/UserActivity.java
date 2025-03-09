package vn.hcmute.baitap04.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.hcmute.baitap04.R;
import vn.hcmute.baitap04.adapter.UserApdater;
import vn.hcmute.baitap04.models.UserModel;

public class UserActivity extends AppCompatActivity {

    UserApdater adapter;
    List<Object> list;
    private RecyclerView rvMultipleViewType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            EdgeToEdge.enable(this);
        }
        setContentView(R.layout.activity_user);
        rvMultipleViewType = (RecyclerView) findViewById(R.id.rv_multipe_view_type);
        list = new ArrayList<>();
        list.add(new UserModel("Nguyen", "S1VVN"));
        list.add(R.drawable.java1);
        list.add(R.drawable.c);
        list.add(R.drawable.kotlin);
        list.add("Hello");
        adapter = new UserApdater(this,list);
        rvMultipleViewType.setAdapter(adapter);
        rvMultipleViewType.setLayoutManager(new LinearLayoutManager(this));
    }
}
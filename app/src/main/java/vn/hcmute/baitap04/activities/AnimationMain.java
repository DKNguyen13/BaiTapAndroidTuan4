package vn.hcmute.baitap04.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.hcmute.baitap04.R;
import vn.hcmute.baitap04.adapter.CustomAnimationAdapter;

public class AnimationMain extends AppCompatActivity {

    private Button btnAddItem;
    private RecyclerView rview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animation_main);
        btnAddItem = (Button) findViewById(R.id.btn_add_item);
        rview = (RecyclerView) findViewById(R.id.rv_items);
        List<String> list = new ArrayList<>();
        for(int i=0; i<5; i++){
            list.add("Item: "+i);
        }
        final CustomAnimationAdapter adapter = new CustomAnimationAdapter(list);
        rview.setAdapter(adapter);
        rview.setLayoutManager(new LinearLayoutManager(this));
        //Set ItemAnimator
        rview.setItemAnimator(new DefaultItemAnimator());
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.AddItem("New items");
                rview.scrollToPosition(adapter.getItemCount()-1);
            }
        });
    }
}
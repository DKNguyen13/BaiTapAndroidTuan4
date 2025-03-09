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
import vn.hcmute.baitap04.adapter.SongAdapter;
import vn.hcmute.baitap04.models.SongModel;

public class RecyclerViewDemo extends AppCompatActivity {
    private RecyclerView rvSongs;
    private SongAdapter msongAdapter;
    private List<SongModel> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvSongs = (RecyclerView) findViewById(R.id.recyclerV);
        mSongs = new ArrayList<>();
        mSongs.add(new SongModel( "60696", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu 1 tình yêu Là lúc anh tự thay",  "Trịnh Đình Quang"));
        mSongs.add(new SongModel("60761",  "NGỐC", "Có rất nhiều những câu chuyện En dấu riêng mình en biết", "Khắc Việt"));
        mSongs.add(new SongModel( "66658", "HÃY TIN ANH LẦN NỮA","Dầu cho ta đã sai khi ở bên nhau Cô yêu thương", "Thiên Dũng"));
        msongAdapter =  new SongAdapter(this, mSongs);
        rvSongs.setAdapter(msongAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        rvSongs.setLayoutManager(linearLayoutManager);
    }
}
package vn.hcmute.baitap04.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.hcmute.baitap04.R;
import vn.hcmute.baitap04.models.SongModel;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private static final String Tag = "SongAdapter";
    private List<SongModel> mSong;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public SongAdapter(Context context, List<SongModel> datas){
        mContext = context;
        mSong = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.row_item_song, parent,false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        SongModel song = mSong.get(position);
        holder.tvCode.setText(song.getmCode());
        holder.tvArtist.setText(song.getmArtist());
        holder.tvLyric.setText(song.getmLyric());
        holder.tvTitle.setText(song.getmTitle());
    }

    @Override
    public int getItemCount() {
        return mSong.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder{
        private TextView tvCode;
        private TextView tvTitle;
        private TextView tvLyric;
        private TextView tvArtist;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tv_code);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvLyric = itemView.findViewById(R.id.tv_lyric);
            tvArtist = itemView.findViewById(R.id.tv_artist);
        }
}

}
package vn.hcmute.baitap04.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.hcmute.baitap04.R;

public class CustomAnimationAdapter extends RecyclerView.Adapter<CustomAnimationAdapter.ViewHolder> {
    private List<String> mDatas;

    public CustomAnimationAdapter(List<String>data){
        this.mDatas = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View view = li.inflate(R.layout.row_animation,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = mDatas.get(position);
        holder.textViewAnimation.setText(item);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void AddItem(String item){
        mDatas.add(item);
        notifyItemInserted(mDatas.size()-1);
    }
    public void AddItem(String item, int position){
        mDatas.add(position,item);
        notifyItemInserted(position);
    }

    public void RemoveItem(String item){
        int index = mDatas.indexOf(item);
        if(index<0) return;
        mDatas.remove(index);
        notifyItemRemoved(index);
    }

    public void ReplaceItem(int position, String item){
        mDatas.remove(position);
        mDatas.add(position,item);
        notifyItemChanged(position);
    }

    public void RemoveItem(int position){
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewAnimation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAnimation = (TextView) itemView.findViewById(R.id.tv_item);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    RemoveItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Remove item",Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ReplaceItem(getAdapterPosition(),"item changed");
                    Toast.makeText(itemView.getContext(), "Change",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

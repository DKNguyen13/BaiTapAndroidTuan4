package vn.hcmute.baitap04.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import vn.hcmute.baitap04.R;
import vn.hcmute.baitap04.models.UserModel;


public class UserApdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Object> mObjects;
    private static final int TEXT = 0;
    private static final int IMAGE = 1;
    private static final int USER = 2;

    public UserApdater(Context context, List<Object> mObjects) {
        this.context = context;
        this.mObjects = mObjects;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);//Chuyen XLM thanh view
        switch (viewType){
            case TEXT:
                View itemView0 = li.inflate(R.layout.row_text,parent, false);
                return new TextViewHolder(itemView0);
            case IMAGE:
                View itemView1 = li.inflate(R.layout.row_image, parent,false);
                return new ImageViewHolder(itemView1);
            case USER:
                View itemView2 = li.inflate(R.layout.row_user, parent, false);
                return new UserViewHolder(itemView2);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case TEXT:
                TextViewHolder textViewHolder = (TextViewHolder) holder;
                textViewHolder.tView.setText(mObjects.get(position).toString());
                break;
            case IMAGE:
                ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                imageViewHolder.imageView.setImageResource((int)mObjects.get(position));
                break;
            case USER:
                UserModel userModel =(UserModel) mObjects.get(position);
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                userViewHolder.tvName.setText(userModel.getName());
                userViewHolder.tvAddress.setText(userModel.getAddress());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mObjects.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object item = mObjects.get(position);

        if (item instanceof String) {
            return TEXT;
        } else if (item instanceof Integer) {
            return IMAGE;
        } else if (item instanceof UserModel) {
            return USER;
        }
        return -1;
    }

    public class TextViewHolder extends RecyclerView.ViewHolder{
        private TextView tView;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            tView = (TextView) itemView.findViewById(R.id.tv_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imv_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, mObjects.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvAddress;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvName = itemView.findViewById(R.id.tv_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserModel user = (UserModel) mObjects.get(getAdapterPosition());
                    Toast.makeText(context, user.getName() +" "+ user.getAddress(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}

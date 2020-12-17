package first.test.a1217.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import first.test.a1217.R;
import first.test.a1217.bean.SchoolBean;
import first.test.a1217.view.MainActivity;

public class HomeAdapter extends RecyclerView.Adapter {
    Context context;
    private ArrayList<SchoolBean.NewsBean> list;
    public HomeAdapter(Context context, ArrayList<SchoolBean.NewsBean> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.text_item,parent,false);
        return new TextHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SchoolBean.NewsBean newsBean = list.get(position);
        TextHolder textHolder= (TextHolder) holder;
        textHolder.mTitle.setText(newsBean.getTile());
        Glide.with(context).load(newsBean.getImageUrl()).into(textHolder.mImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    static
    class  TextHolder extends RecyclerView.ViewHolder {
        View view;
        TextView mTitle;
        ImageView mImg;

        TextHolder(View view){
            super(view);
            this.view=view;
            this.mImg=view.findViewById(R.id.img);
            this.mTitle=view.findViewById(R.id.title);
        }
    }
}

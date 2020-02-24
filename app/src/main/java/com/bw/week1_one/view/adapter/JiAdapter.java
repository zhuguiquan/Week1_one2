package com.bw.week1_one.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.week1_one.R;
import com.bw.week1_one.model.bean.JiBean;
import com.bw.week1_one.util.NetUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * DateTime:2020/2/22 0022
 * author:朱贵全(Administrator)
 * function:
 */
public class JiAdapter extends RecyclerView.Adapter<JiAdapter.JiViewhoder> {
    private List<JiBean.SubjectsBean> subjects;

    public JiAdapter(List<JiBean.SubjectsBean> subjects) {

        this.subjects = subjects;
    }

    @NonNull
    @Override
    public JiViewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ji_item, parent, false);

        return new JiViewhoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull JiViewhoder holder, int position) {
        JiBean.SubjectsBean subjectsBean = subjects.get(position);
        holder.tx1.setText(subjectsBean.getTitle());
        holder.tx2.setText(subjectsBean.getMainland_pubdate());
        JiBean.SubjectsBean.ImagesBean images = subjectsBean.getImages();
        String small = images.getSmall();
        NetUtil.getInstance().getPhoto(small,holder.img);


    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    class JiViewhoder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tx1)
        TextView tx1;
        @BindView(R.id.tx2)
        TextView tx2;
        public JiViewhoder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


}

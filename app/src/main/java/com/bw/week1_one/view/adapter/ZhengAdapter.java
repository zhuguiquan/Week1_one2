package com.bw.week1_one.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.week1_one.R;
import com.bw.week1_one.model.bean.ZhengBean;
import com.bw.week1_one.util.NetUtil;
import com.bw.week1_one.util.NetUtil1;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * DateTime:2020/2/22 0022
 * author:朱贵全(Administrator)
 * function:
 */
public class ZhengAdapter extends RecyclerView.Adapter<ZhengAdapter.ZhengViewHolder> {
    private List<ZhengBean.SubjectsBean> subjects;

    public ZhengAdapter(List<ZhengBean.SubjectsBean> subjects) {

        this.subjects = subjects;
    }

    @NonNull
    @Override
    public ZhengViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.zheng_item, parent, false);
      //  View inflate = View.inflate(parent.getContext(), R.layout.zheng_item, null);
        return new ZhengViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ZhengViewHolder holder, int position) {
        ZhengBean.SubjectsBean subjectsBean = subjects.get(position);
        holder.tv1.setText(subjectsBean.getTitle());
        List<String> genres = subjectsBean.getGenres();
        for (int i = 0; i < genres.size(); i++) {
            String s = genres.get(i);
            holder.tv2.setText(s);
        }

        holder.tv3.setText(subjectsBean.getMainland_pubdate());
        List<ZhengBean.SubjectsBean.CastsBean> casts = subjectsBean.getCasts();
        for (int i = 0; i <casts.size() ; i++) {
            ZhengBean.SubjectsBean.CastsBean castsBean = casts.get(i);
            ZhengBean.SubjectsBean.CastsBean.AvatarsBean avatars = castsBean.getAvatars();
            String small = avatars.getSmall();
            NetUtil.getInstance().getPhoto(small,holder.tv4);
        }
        ZhengBean.SubjectsBean.ImagesBean images = subjectsBean.getImages();
        String small = images.getSmall();
        NetUtil.getInstance().getPhoto(small,holder.img);


    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    class ZhengViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.tv4)
        ImageView tv4;
        public ZhengViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


}

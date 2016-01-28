package me.fangx.zhihu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import me.fangx.zhihu.R;
import me.fangx.zhihu.modle.bean.ArticleListBean;
import me.fangx.zhihu.ui.activity.ArticleDetailActivity;
import me.fangx.zhihu.ui.fragment.ArticleDetailFragment;

/**
 * Created by fangxiao on 16/1/28.
 */
public class ExploreListAdapter extends RecyclerView.Adapter<ExploreListAdapter.ViewHolder> {
    public ArrayList<ArticleListBean> datas = null;

    Context context;

    public ExploreListAdapter(Context context, ArrayList<ArticleListBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.explore_list_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.tv_content_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ArticleDetailActivity.class);
                intent.putExtra(ArticleDetailFragment.ARG_ITEM_INFO, datas.get(position));
                context.startActivity(intent);
            }
        });

        ArticleListBean articleListBean = datas.get(position);
        viewHolder.tv_title_explore.setText(articleListBean.getTitle());
        viewHolder.tv_content_explore.setText(articleListBean.getSummary());
        viewHolder.tv_like.setText(articleListBean.getLikesCount() > 1000 ? (float) (articleListBean.getLikesCount() / 1000) * 10 / 10 + "k" : articleListBean.getLikesCount() + "");

    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_title_explore;
        public TextView tv_like;
        public TextView tv_content_explore;
        public SimpleDraweeView explore_icon;

        public ViewHolder(View view) {
            super(view);
            tv_title_explore = (TextView) view.findViewById(R.id.tv_title_explore);
            tv_like = (TextView) view.findViewById(R.id.tv_like);
            explore_icon = (SimpleDraweeView) view.findViewById(R.id.explore_icon);
            tv_content_explore = (TextView) view.findViewById(R.id.tv_content_explore);

        }
    }
}
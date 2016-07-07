package com.android.loadingmoredata;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishal on 05/07/2016.
 */
public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ResponseData.OffersBean> android;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private OnLoadMoreListener mOnLoadMoreListener;


    public DataAdapter(List<ResponseData.OffersBean> android, RecyclerView recyclerView) {
        this.android = android;


        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {

            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        // End has been reached
                        // Do something
                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onLoadMore();
                        }
                        isLoading = true;
                    }
                }
            });
        }
    }

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }

    @Override
    public int getItemViewType(int position) {
        return android.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }
//
//    @Override
//    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//
//        if (i == VIEW_TYPE_ITEM) {
//            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.date_to_dateorder, viewGroup, false);
//            return new ViewHolder(view);
//        } else if (i == VIEW_TYPE_LOADING) {
//            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_loading_item, viewGroup, false);
//
//            return new ViewHolder(view);
//        }
//        return null;
//
//    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_to_dateorder, parent, false);
            return new UserViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_loading_item, parent, false);
            return new LoadingViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        if (viewHolder instanceof UserViewHolder) {

            UserViewHolder userViewHolder = (UserViewHolder) viewHolder;
            userViewHolder.tvName.setText(android.get(i).getId());
            userViewHolder.tvEmailId.setText(android.get(i).getCityName());
        } else if (viewHolder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) viewHolder;
            loadingViewHolder.progressBar.setIndeterminate(true);
        }


    }


    @Override
    public int getItemCount() {
        return android.size();
    }


//    static class LoadingViewHolder extends RecyclerView.ViewHolder {
//        public ProgressBar progressBar;
//
//        public LoadingViewHolder(View itemView) {
//            super(itemView);
//            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
//        }
//    }


    static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvEmailId;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_donorName_donorList);

            tvEmailId = (TextView) itemView.findViewById(R.id.tv_dateDonor_donorList);
        }
    }

    static class LoadingViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
        }
    }

    //    static class ViewHolder extends RecyclerView.ViewHolder {
//        private TextView tv_id, tv_name;
//        public ProgressBar progressBar;
//
//        public ViewHolder(View view) {
//            super(view);
//            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
//            tv_id = (TextView) view.findViewById(R.id.tv_donorName_donorList);
//            tv_name = (TextView) view.findViewById(R.id.tv_dateDonor_donorList);
//
//        }
//    }
    public void setLoaded() {
        isLoading = false;
    }


}
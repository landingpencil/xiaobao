package com.example.pencil.xiaobao.timeline;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pencil.xiaobao.R;
import com.example.pencil.xiaobao.data.GuokrHandpickNewsResult;
import com.example.pencil.xiaobao.interfaze.OnRecyclerViewItemOnClickListener;
import java.util.List;

public class GuokrHandpickNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  @NonNull
  private final Context mContext;

  @NonNull
  private final List<GuokrHandpickNewsResult> mList;
  private OnRecyclerViewItemOnClickListener mListener;

  public GuokrHandpickNewsAdapter(@NonNull List<GuokrHandpickNewsResult> list,
      @NonNull Context context) {
    this.mContext = context;
    this.mList = list;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    return new ItemViewHolder(
        LayoutInflater.from(mContext).inflate(R.layout.item_universal_layout, viewGroup, false), mListener);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
    GuokrHandpickNewsResult item = mList.get(i);

    ItemViewHolder holder = (ItemViewHolder) viewHolder;

    Glide.with(mContext)
        .load(item.getImageInfo().getUrl())
        .asBitmap()
        .placeholder(R.drawable.placeholder)
        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
        .error(R.drawable.placeholder)
        .centerCrop()
        .into(holder.imageView);

    holder.textView.setText(item.getTitle());
  }

  @Override
  public int getItemCount() {
    return mList.isEmpty() ? 0 : mList.size();
  }

  public void setItemClickListener(OnRecyclerViewItemOnClickListener listener){
    this.mListener = listener;
  }

  public void updateData(@NonNull List<GuokrHandpickNewsResult> list) {
    mList.clear();
    mList.addAll(list);
    notifyDataSetChanged();
    notifyItemRemoved(list.size());
  }

  public class ItemViewHolder extends RecyclerView.ViewHolder
      implements View.OnClickListener{

    ImageView imageView;
    TextView textView;
    OnRecyclerViewItemOnClickListener listener;

    public ItemViewHolder(View itemView, OnRecyclerViewItemOnClickListener listener) {
      super(itemView);

      imageView = itemView.findViewById(R.id.image_view_cover);
      textView = itemView.findViewById(R.id.text_view_title);

      this.listener = listener;
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      if (listener != null){
        listener.OnItemClick(view, getLayoutPosition());
      }
    }
  }

}
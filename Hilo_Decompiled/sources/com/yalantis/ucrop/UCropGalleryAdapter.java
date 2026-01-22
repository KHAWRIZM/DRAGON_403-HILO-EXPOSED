package com.yalantis.ucrop;

import android.graphics.ColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.a;
import androidx.core.graphics.d;
import androidx.core.graphics.e;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class UCropGalleryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private int currentSelectPosition;
    private final List<String> list;
    private OnItemClickListener listener;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnItemClickListener {
        void onItemClick(int i, View view);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mIvPhoto;
        View mViewCurrentSelect;

        public ViewHolder(View view) {
            super(view);
            this.mIvPhoto = (ImageView) view.findViewById(R.id.iv_photo);
            this.mViewCurrentSelect = view.findViewById(R.id.view_current_select);
        }
    }

    public UCropGalleryAdapter(List<String> list) {
        this.list = list;
    }

    public int getCurrentSelectPosition() {
        return this.currentSelectPosition;
    }

    public int getItemCount() {
        List<String> list = this.list;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void setCurrentSelectPosition(int i) {
        this.currentSelectPosition = i;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        ColorFilter a;
        String str = this.list.get(i);
        UCropImageEngine uCropImageEngine = UCropDevelopConfig.imageEngine;
        if (uCropImageEngine != null) {
            uCropImageEngine.loadImage(((RecyclerView.ViewHolder) viewHolder).itemView.getContext(), str, viewHolder.mIvPhoto);
        }
        if (this.currentSelectPosition == i) {
            viewHolder.mViewCurrentSelect.setVisibility(0);
            a = d.a(a.getColor(((RecyclerView.ViewHolder) viewHolder).itemView.getContext(), R.color.ucrop_color_80), e.j);
        } else {
            a = d.a(a.getColor(((RecyclerView.ViewHolder) viewHolder).itemView.getContext(), R.color.ucrop_color_20), e.j);
            viewHolder.mViewCurrentSelect.setVisibility(8);
        }
        viewHolder.mIvPhoto.setColorFilter(a);
        ((RecyclerView.ViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropGalleryAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UCropGalleryAdapter.this.listener != null) {
                    UCropGalleryAdapter.this.listener.onItemClick(viewHolder.getAbsoluteAdapterPosition(), view);
                }
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ucrop_gallery_adapter_item, viewGroup, false));
    }
}

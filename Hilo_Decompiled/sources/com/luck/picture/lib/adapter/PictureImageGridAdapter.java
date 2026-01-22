package com.luck.picture.lib.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.holder.BaseRecyclerMediaHolder;
import com.luck.picture.lib.config.InjectResourceSource;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PictureImageGridAdapter extends RecyclerView.Adapter<BaseRecyclerMediaHolder> {
    public static final int ADAPTER_TYPE_AUDIO = 4;
    public static final int ADAPTER_TYPE_CAMERA = 1;
    public static final int ADAPTER_TYPE_IMAGE = 2;
    public static final int ADAPTER_TYPE_VIDEO = 3;
    private boolean isDisplayCamera;
    private OnItemClickListener listener;
    private final SelectorConfig mConfig;
    private final Context mContext;
    private ArrayList<LocalMedia> mData = new ArrayList<>();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, int i10, LocalMedia localMedia);

        void onItemLongClick(View view, int i10);

        int onSelected(View view, int i10, LocalMedia localMedia);

        void openCameraClick();
    }

    public PictureImageGridAdapter(Context context, SelectorConfig selectorConfig) {
        this.mConfig = selectorConfig;
        this.mContext = context;
    }

    private int getItemResourceId(int i10) {
        if (i10 != 1) {
            if (i10 != 3) {
                if (i10 != 4) {
                    int layoutResource = InjectResourceSource.getLayoutResource(this.mContext, 3, this.mConfig);
                    if (layoutResource == 0) {
                        return R.layout.ps_item_grid_image;
                    }
                    return layoutResource;
                }
                int layoutResource2 = InjectResourceSource.getLayoutResource(this.mContext, 5, this.mConfig);
                if (layoutResource2 == 0) {
                    return R.layout.ps_item_grid_audio;
                }
                return layoutResource2;
            }
            int layoutResource3 = InjectResourceSource.getLayoutResource(this.mContext, 4, this.mConfig);
            if (layoutResource3 == 0) {
                return R.layout.ps_item_grid_video;
            }
            return layoutResource3;
        }
        return R.layout.ps_item_grid_camera;
    }

    public ArrayList<LocalMedia> getData() {
        return this.mData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.isDisplayCamera) {
            return this.mData.size() + 1;
        }
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        boolean z10 = this.isDisplayCamera;
        if (z10 && i10 == 0) {
            return 1;
        }
        if (z10) {
            i10--;
        }
        String mimeType = this.mData.get(i10).getMimeType();
        if (PictureMimeType.isHasVideo(mimeType)) {
            return 3;
        }
        if (PictureMimeType.isHasAudio(mimeType)) {
            return 4;
        }
        return 2;
    }

    public boolean isDataEmpty() {
        if (this.mData.size() == 0) {
            return true;
        }
        return false;
    }

    public boolean isDisplayCamera() {
        return this.isDisplayCamera;
    }

    public void notifyItemPositionChanged(int i10) {
        notifyItemChanged(i10);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setDataAndDataSetChanged(ArrayList<LocalMedia> arrayList) {
        if (arrayList != null) {
            this.mData = arrayList;
            notifyDataSetChanged();
        }
    }

    public void setDisplayCamera(boolean z10) {
        this.isDisplayCamera = z10;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseRecyclerMediaHolder baseRecyclerMediaHolder, int i10) {
        if (getItemViewType(i10) == 1) {
            baseRecyclerMediaHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.adapter.PictureImageGridAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PictureImageGridAdapter.this.listener != null) {
                        PictureImageGridAdapter.this.listener.openCameraClick();
                    }
                }
            });
            return;
        }
        if (this.isDisplayCamera) {
            i10--;
        }
        baseRecyclerMediaHolder.bindData(this.mData.get(i10), i10);
        baseRecyclerMediaHolder.setOnItemClickListener(this.listener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseRecyclerMediaHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return BaseRecyclerMediaHolder.generate(viewGroup, i10, getItemResourceId(i10), this.mConfig);
    }
}

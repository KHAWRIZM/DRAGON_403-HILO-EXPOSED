package com.qiahao.nextvideo.ui.feedback;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.adapter.PictureImageGridAdapter;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.utils.DateUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.feedback.GridImageAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 82\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00039:8B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0010J\u001b\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010!J#\u0010#\u001a\u00020\u000e2\n\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u0014048F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006;"}, d2 = {"Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter$ViewHolder;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter$OnAddPicClickListener;", "onAddPicClickListener", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter$OnAddPicClickListener;)V", "", "position", "", "isShowAddItem", "(I)Z", "", "delete", "(I)V", "selectMax", "setSelectMax", "", "Lcom/luck/picture/lib/entity/LocalMedia;", "list", "setList", "(Ljava/util/List;)V", "remove", "getItemCount", "()I", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "viewGroup", "i", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter$ViewHolder;", "viewHolder", "onBindViewHolder", "(Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter$ViewHolder;I)V", "Lcom/luck/picture/lib/adapter/PictureImageGridAdapter$OnItemClickListener;", "l", "setOnItemClickListener", "(Lcom/luck/picture/lib/adapter/PictureImageGridAdapter$OnItemClickListener;)V", "Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter$OnAddPicClickListener;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/LayoutInflater;", "Ljava/util/List;", "itemClickListener", "Lcom/luck/picture/lib/adapter/PictureImageGridAdapter$OnItemClickListener;", "I", "Lpb/a;", "onItemLongClickListener", "Lpb/a;", "", "getData", "()Ljava/util/List;", "data", "Companion", "OnAddPicClickListener", "ViewHolder", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GridImageAdapter extends RecyclerView.Adapter<ViewHolder> {

    @NotNull
    public static final String TAG = "PictureSelector";
    public static final int TYPE_CAMERA = 1;
    public static final int TYPE_PICTURE = 2;

    @NotNull
    private final LayoutInflater inflater;

    @Nullable
    private PictureImageGridAdapter.OnItemClickListener itemClickListener;

    @NotNull
    private final List<LocalMedia> list;

    @NotNull
    private final OnAddPicClickListener onAddPicClickListener;

    @Nullable
    private pb.a onItemLongClickListener;
    private int selectMax;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter$OnAddPicClickListener;", "", "onAddPicClick", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface OnAddPicClickListener {
        void onAddPicClick();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/qiahao/nextvideo/ui/feedback/GridImageAdapter;Landroid/view/View;)V", "img", "Landroid/widget/ImageView;", "getImg", "()Landroid/widget/ImageView;", "setImg", "(Landroid/widget/ImageView;)V", "ivDel", "getIvDel", "setIvDel", "tvDuration", "Landroid/widget/TextView;", "getTvDuration", "()Landroid/widget/TextView;", "setTvDuration", "(Landroid/widget/TextView;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private ImageView img;

        @NotNull
        private ImageView ivDel;
        final /* synthetic */ GridImageAdapter this$0;

        @NotNull
        private TextView tvDuration;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull GridImageAdapter gridImageAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = gridImageAdapter;
            View findViewById = view.findViewById(R.id.fiv);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.img = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.iv_del);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.ivDel = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(2131365418);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.tvDuration = (TextView) findViewById3;
        }

        @NotNull
        public final ImageView getImg() {
            return this.img;
        }

        @NotNull
        public final ImageView getIvDel() {
            return this.ivDel;
        }

        @NotNull
        public final TextView getTvDuration() {
            return this.tvDuration;
        }

        public final void setImg(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.img = imageView;
        }

        public final void setIvDel(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.ivDel = imageView;
        }

        public final void setTvDuration(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.tvDuration = textView;
        }
    }

    public GridImageAdapter(@Nullable Context context, @NotNull OnAddPicClickListener onAddPicClickListener) {
        Intrinsics.checkNotNullParameter(onAddPicClickListener, "onAddPicClickListener");
        this.onAddPicClickListener = onAddPicClickListener;
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        this.inflater = from;
        this.list = new ArrayList();
        this.selectMax = 9;
    }

    private final boolean isShowAddItem(int position) {
        int size;
        if (this.list.size() == 0) {
            size = 0;
        } else {
            size = this.list.size();
        }
        if (position != size) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(GridImageAdapter gridImageAdapter, View view) {
        gridImageAdapter.onAddPicClickListener.onAddPicClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(ViewHolder viewHolder, GridImageAdapter gridImageAdapter, View view) {
        int adapterPosition = viewHolder.getAdapterPosition();
        if (adapterPosition != -1 && gridImageAdapter.list.size() > adapterPosition) {
            gridImageAdapter.list.remove(adapterPosition);
            gridImageAdapter.notifyItemRemoved(adapterPosition);
            gridImageAdapter.notifyItemRangeChanged(adapterPosition, gridImageAdapter.list.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(ViewHolder viewHolder, GridImageAdapter gridImageAdapter, LocalMedia localMedia, View view) {
        int adapterPosition = viewHolder.getAdapterPosition();
        PictureImageGridAdapter.OnItemClickListener onItemClickListener = gridImageAdapter.itemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, adapterPosition, localMedia);
        }
    }

    private static final boolean onBindViewHolder$lambda$4(ViewHolder viewHolder, GridImageAdapter gridImageAdapter, View view) {
        viewHolder.getAdapterPosition();
        gridImageAdapter.getClass();
        return true;
    }

    public final void delete(int position) {
        if (position != -1) {
            try {
                if (this.list.size() > position) {
                    this.list.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, this.list.size());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @NotNull
    public final List<LocalMedia> getData() {
        return this.list;
    }

    public int getItemCount() {
        if (this.list.size() < this.selectMax) {
            return this.list.size() + 1;
        }
        return this.list.size();
    }

    public int getItemViewType(int position) {
        if (isShowAddItem(position)) {
            return 1;
        }
        return 2;
    }

    public final void remove(int position) {
        if (position < this.list.size()) {
            this.list.remove(position);
        }
    }

    public final void setList(@NotNull List<LocalMedia> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list.clear();
        this.list.addAll(list);
    }

    public final void setOnItemClickListener(@Nullable PictureImageGridAdapter.OnItemClickListener l) {
        this.itemClickListener = l;
    }

    public final void setSelectMax(int selectMax) {
        this.selectMax = selectMax;
    }

    public void onBindViewHolder(@NotNull final ViewHolder viewHolder, int position) {
        String compressPath;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (getItemViewType(position) == 1) {
            ImageKtxKt.loadImage$default(viewHolder.getImg(), (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_feedback_image), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            viewHolder.getImg().setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.feedback.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GridImageAdapter.onBindViewHolder$lambda$0(GridImageAdapter.this, view);
                }
            });
            viewHolder.getIvDel().setVisibility(4);
            return;
        }
        viewHolder.getIvDel().setVisibility(0);
        viewHolder.getIvDel().setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.feedback.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GridImageAdapter.onBindViewHolder$lambda$1(GridImageAdapter.ViewHolder.this, this, view);
            }
        });
        final LocalMedia localMedia = this.list.get(position);
        if (TextUtils.isEmpty(localMedia.getPath())) {
            return;
        }
        if (localMedia.isCut() && !localMedia.isCompressed()) {
            compressPath = localMedia.getCutPath();
        } else if (!localMedia.isCompressed() && (!localMedia.isCut() || !localMedia.isCompressed())) {
            if (!TextUtils.isEmpty(localMedia.getRealPath())) {
                compressPath = localMedia.getRealPath();
            } else {
                compressPath = localMedia.getPath();
            }
        } else {
            compressPath = localMedia.getCompressPath();
        }
        String str = compressPath;
        if (PictureMimeType.isContent(str)) {
            ImageKtxKt.loadImage$default(viewHolder.getImg(), (String) null, Uri.parse(str), (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65533, (Object) null);
        } else {
            ImageKtxKt.loadImage$default(viewHolder.getImg(), str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        long duration = localMedia.getDuration();
        viewHolder.getTvDuration().setVisibility(PictureMimeType.isHasVideo(localMedia.getMimeType()) ? 0 : 8);
        if (localMedia.getChooseModel() == SelectMimeType.ofVideo()) {
            viewHolder.getTvDuration().setVisibility(0);
            viewHolder.getTvDuration().setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_im_video, 0, 0, 0);
        } else {
            viewHolder.getTvDuration().setVisibility(8);
        }
        viewHolder.getTvDuration().setText(DateUtils.formatDurationTime(duration));
        if (this.itemClickListener != null) {
            ((RecyclerView.ViewHolder) viewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.feedback.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GridImageAdapter.onBindViewHolder$lambda$3(GridImageAdapter.ViewHolder.this, this, localMedia, view);
                }
            });
        }
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View inflate = this.inflater.inflate(R.layout.cell_grid_files_upload_preview, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(this, inflate);
    }
}

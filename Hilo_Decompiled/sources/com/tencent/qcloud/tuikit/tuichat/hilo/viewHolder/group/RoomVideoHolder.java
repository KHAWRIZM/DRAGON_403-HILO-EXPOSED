package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.databinding.MessageAdapterContentImageBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomVideoHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/MessageAdapterContentImageBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "DEFAULT_MAX_SIZE", "", "DEFAULT_RADIUS", "downloadEles", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "getImageParams", "Landroid/view/ViewGroup$LayoutParams;", "params", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomVideoBean;", "performVideo", "setHighLightBackground", "color", "clearHighLightBackground", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomVideoHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomVideoHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomVideoHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,166:1\n1#2:167\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomVideoHolder extends HiloRoomContentHolder<MessageAdapterContentImageBinding> {
    private final int DEFAULT_MAX_SIZE;
    private final int DEFAULT_RADIUS;

    @NotNull
    private ArrayList<String> downloadEles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomVideoHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.DEFAULT_MAX_SIZE = 540;
        this.DEFAULT_RADIUS = 10;
        this.downloadEles = new ArrayList<>();
    }

    private final ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams params, RoomVideoBean msg) {
        if (msg.getImgWidth() != 0 && msg.getImgHeight() != 0) {
            if (msg.getImgWidth() > msg.getImgHeight()) {
                int i = this.DEFAULT_MAX_SIZE;
                params.width = i;
                params.height = (i * msg.getImgHeight()) / msg.getImgWidth();
            } else {
                params.width = (this.DEFAULT_MAX_SIZE * msg.getImgWidth()) / msg.getImgHeight();
                params.height = this.DEFAULT_MAX_SIZE;
            }
            return params;
        }
        int i2 = this.DEFAULT_MAX_SIZE;
        params.width = i2;
        params.height = i2;
        return params;
    }

    private final void performVideo(final RoomVideoBean msg, final int position) {
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        TextView textView2;
        ImageView imageView3;
        ImageView imageView4;
        ViewGroup.LayoutParams layoutParams;
        ImageView imageView5;
        ViewGroup.LayoutParams layoutParams2;
        MessageAdapterContentImageBinding binding = getBinding();
        if (binding != null && (imageView4 = binding.contentImageIv) != null) {
            MessageAdapterContentImageBinding binding2 = getBinding();
            if (binding2 != null && (imageView5 = binding2.contentImageIv) != null && (layoutParams2 = imageView5.getLayoutParams()) != null) {
                layoutParams = getImageParams(layoutParams2, msg);
            } else {
                layoutParams = null;
            }
            imageView4.setLayoutParams(layoutParams);
        }
        MessageAdapterContentImageBinding binding3 = getBinding();
        if (binding3 != null && (imageView3 = binding3.videoPlayBtn) != null) {
            imageView3.setVisibility(0);
        }
        MessageAdapterContentImageBinding binding4 = getBinding();
        if (binding4 != null && (textView2 = binding4.videoDurationTv) != null) {
            textView2.setVisibility(0);
        }
        if (!TextUtils.isEmpty(msg.getDataPath())) {
            MessageAdapterContentImageBinding binding5 = getBinding();
            if (binding5 != null) {
                imageView2 = binding5.contentImageIv;
            } else {
                imageView2 = null;
            }
            GlideEngine.loadCornerImageWithoutPlaceHolder(imageView2, msg.getDataPath(), null, this.DEFAULT_RADIUS);
        } else {
            MessageAdapterContentImageBinding binding6 = getBinding();
            if (binding6 != null) {
                imageView = binding6.contentImageIv;
            } else {
                imageView = null;
            }
            GlideEngine.clear(imageView);
            synchronized (this.downloadEles) {
                try {
                    if (!this.downloadEles.contains(msg.getSnapshotUUID())) {
                        this.downloadEles.add(msg.getSnapshotUUID());
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            final String str = TUIConfig.getImageDownloadDir() + msg.getSnapshotUUID();
            msg.downloadSnapshot(str, new RoomVideoBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomVideoHolder$performVideo$3
                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean.VideoDownloadCallback
                public void onError(int code, String desc) {
                    ArrayList arrayList;
                    arrayList = RoomVideoHolder.this.downloadEles;
                    arrayList.remove(msg.getSnapshotUUID());
                    TUIChatLog.e("MessageAdapter video getImage", code + ":" + desc);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean.VideoDownloadCallback
                public void onProgress(long currentSize, long totalSize) {
                    TUIChatLog.i("downloadSnapshot progress current:", currentSize + ", total:" + totalSize);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomVideoBean.VideoDownloadCallback
                public void onSuccess() {
                    ArrayList arrayList;
                    ImageView imageView6;
                    int i;
                    arrayList = RoomVideoHolder.this.downloadEles;
                    arrayList.remove(msg.getSnapshotUUID());
                    msg.setDataPath(str);
                    MessageAdapterContentImageBinding binding7 = RoomVideoHolder.this.getBinding();
                    if (binding7 != null) {
                        imageView6 = binding7.contentImageIv;
                    } else {
                        imageView6 = null;
                    }
                    String dataPath = msg.getDataPath();
                    i = RoomVideoHolder.this.DEFAULT_RADIUS;
                    GlideEngine.loadCornerImageWithoutPlaceHolder(imageView6, dataPath, null, i);
                }
            });
        }
        String formatSecondsTo00 = DateTimeUtil.formatSecondsTo00(msg.getDuration());
        MessageAdapterContentImageBinding binding7 = getBinding();
        if (binding7 != null && (textView = binding7.videoDurationTv) != null) {
            textView.setText(formatSecondsTo00);
        }
        File file = new File(TUIConfig.getVideoDownloadDir() + msg.getVideoUUID());
        if (msg.getStatus() == 2) {
            ImageView messageStatus = getMessageStatus();
            if (messageStatus != null) {
                messageStatus.setVisibility(8);
            }
            ProgressBar progressBar = getProgressBar();
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        } else if (file.exists() && msg.getStatus() == 1) {
            ImageView messageStatus2 = getMessageStatus();
            if (messageStatus2 != null) {
                messageStatus2.setVisibility(8);
            }
            ProgressBar progressBar2 = getProgressBar();
            if (progressBar2 != null) {
                progressBar2.setVisibility(0);
            }
        } else if (msg.getStatus() == 3) {
            ImageView messageStatus3 = getMessageStatus();
            if (messageStatus3 != null) {
                messageStatus3.setVisibility(0);
            }
            ProgressBar progressBar3 = getProgressBar();
            if (progressBar3 != null) {
                progressBar3.setVisibility(8);
            }
        }
        if (getIsMultiSelectMode()) {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomVideoHolder.performVideo$lambda$2(RoomVideoHolder.this, position, msg, view);
                }
            });
            return;
        }
        this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoomVideoHolder.performVideo$lambda$3(RoomVideoHolder.this, msg, view);
            }
        });
        if (msg.getMessageReactBean() == null || msg.getMessageReactBean().getReactSize() <= 0) {
            LinearLayout linearLayout = this.msgArea;
            if (linearLayout != null) {
                linearLayout.setBackground(null);
            }
            LinearLayout linearLayout2 = this.msgArea;
            if (linearLayout2 != null) {
                linearLayout2.setPadding(0, 0, 0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performVideo$lambda$2(RoomVideoHolder roomVideoHolder, int i, RoomVideoBean roomVideoBean, View view) {
        OnItemClickListener onItemClickListener = roomVideoHolder.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onMessageClick(view, i, roomVideoBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void performVideo$lambda$3(RoomVideoHolder roomVideoHolder, RoomVideoBean roomVideoBean, View view) {
        List<TUIMessageBean> dataSource;
        Intent intent = new Intent(ServiceInitializer.getAppContext(), (Class<?>) ImageVideoScanActivity.class);
        intent.addFlags(268435456);
        if (roomVideoHolder.getIsForwardMode() && roomVideoHolder.getDataSource() != null && (dataSource = roomVideoHolder.getDataSource()) != null && (!dataSource.isEmpty())) {
            intent.putExtra(TUIChatConstants.OPEN_MESSAGES_SCAN_FORWARD, (Serializable) roomVideoHolder.getDataSource());
        }
        intent.putExtra(TUIChatConstants.OPEN_MESSAGE_SCAN, roomVideoBean);
        intent.putExtra(TUIChatConstants.FORWARD_MODE, roomVideoHolder.getIsForwardMode());
        ServiceInitializer.getAppContext().startActivity(intent);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void clearHighLightBackground() {
        ImageView imageView;
        Drawable drawable;
        MessageAdapterContentImageBinding binding = getBinding();
        if (binding != null && (imageView = binding.contentImageIv) != null && (drawable = imageView.getDrawable()) != null) {
            drawable.setColorFilter(null);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomVideoBean)) {
            return;
        }
        performVideo((RoomVideoBean) msg, position);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int color) {
        ImageView imageView;
        Drawable drawable;
        MessageAdapterContentImageBinding binding = getBinding();
        if (binding != null && (imageView = binding.contentImageIv) != null && (drawable = imageView.getDrawable()) != null) {
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder
    @NotNull
    public MessageAdapterContentImageBinding inflateViewBinding() {
        MessageAdapterContentImageBinding inflate = MessageAdapterContentImageBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

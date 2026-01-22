package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.databinding.MessageAdapterContentImageBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import o4.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomImageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/MessageAdapterContentImageBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "DEFAULT_MAX_SIZE", "", "DEFAULT_RADIUS", "downloadEles", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mImagePath", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "getImageParams", "Landroid/view/ViewGroup$LayoutParams;", "params", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/bean/group/RoomImageBean;", "performImage", "setHighLightBackground", "color", "clearHighLightBackground", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomImageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomImageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomImageHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,203:1\n61#2,9:204\n*S KotlinDebug\n*F\n+ 1 RoomImageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomImageHolder\n*L\n152#1:204,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomImageHolder extends HiloRoomContentHolder<MessageAdapterContentImageBinding> {
    private final int DEFAULT_MAX_SIZE;
    private final int DEFAULT_RADIUS;

    @NotNull
    private ArrayList<String> downloadEles;

    @Nullable
    private String mImagePath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomImageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.DEFAULT_MAX_SIZE = 540;
        this.DEFAULT_RADIUS = 10;
        this.downloadEles = new ArrayList<>();
    }

    private final ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams params, RoomImageBean msg) {
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

    private final void performImage(final RoomImageBean msg, final int position) {
        ImageView imageView;
        IntRange intRange;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        final ImageView imageView5;
        ImageView imageView6;
        TextView textView;
        ImageView imageView7;
        ImageView imageView8;
        MessageAdapterContentImageBinding binding = getBinding();
        if (binding != null && (imageView8 = binding.contentImageIv) != null) {
            ViewGroup.LayoutParams layoutParams = imageView8.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "getLayoutParams(...)");
            imageView8.setLayoutParams(getImageParams(layoutParams, msg));
        }
        MessageAdapterContentImageBinding binding2 = getBinding();
        if (binding2 != null && (imageView7 = binding2.videoPlayBtn) != null) {
            imageView7.setVisibility(8);
        }
        MessageAdapterContentImageBinding binding3 = getBinding();
        if (binding3 != null && (textView = binding3.videoDurationTv) != null) {
            textView.setVisibility(8);
        }
        List<RoomImageBean.ImageBean> imageBeanList = msg.getImageBeanList();
        String dataPath = msg.getDataPath();
        String originImagePath = TUIChatUtils.getOriginImagePath(msg);
        if (!TextUtils.isEmpty(originImagePath)) {
            dataPath = originImagePath;
        }
        if (!TextUtils.isEmpty(dataPath)) {
            MessageAdapterContentImageBinding binding4 = getBinding();
            if (binding4 != null) {
                imageView6 = binding4.contentImageIv;
            } else {
                imageView6 = null;
            }
            GlideEngine.loadCornerImageWithoutPlaceHolder(imageView6, dataPath, null, this.DEFAULT_RADIUS);
        } else {
            MessageAdapterContentImageBinding binding5 = getBinding();
            if (binding5 != null) {
                imageView = binding5.contentImageIv;
            } else {
                imageView = null;
            }
            GlideEngine.clear(imageView);
            if (imageBeanList != null) {
                intRange = CollectionsKt.getIndices(imageBeanList);
            } else {
                intRange = null;
            }
            if (intRange == null) {
                return;
            }
            int size = imageBeanList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                final RoomImageBean.ImageBean imageBean = imageBeanList.get(i);
                if (imageBean.getType() == 1) {
                    synchronized (this.downloadEles) {
                        try {
                            if (!this.downloadEles.contains(imageBean.getUUID())) {
                                this.downloadEles.add(imageBean.getUUID());
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 1);
                    if (!Intrinsics.areEqual(generateImagePath, this.mImagePath)) {
                        MessageAdapterContentImageBinding binding6 = getBinding();
                        if (binding6 != null) {
                            imageView2 = binding6.contentImageIv;
                        } else {
                            imageView2 = null;
                        }
                        GlideEngine.clear(imageView2);
                    }
                    imageBean.downloadImage(generateImagePath, new RoomImageBean.ImageBean.ImageDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomImageHolder$performImage$3
                        @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean.ImageBean.ImageDownloadCallback
                        public void onError(int code, String desc) {
                            ArrayList arrayList;
                            arrayList = RoomImageHolder.this.downloadEles;
                            arrayList.remove(imageBean.getUUID());
                            TUIChatLog.e("MessageAdapter img getImage", code + ":" + desc);
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean.ImageBean.ImageDownloadCallback
                        public void onProgress(long currentSize, long totalSize) {
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomImageBean.ImageBean.ImageDownloadCallback
                        public void onSuccess() {
                            ArrayList arrayList;
                            ImageView imageView9;
                            int i2;
                            arrayList = RoomImageHolder.this.downloadEles;
                            arrayList.remove(imageBean.getUUID());
                            msg.setDataPath(generateImagePath);
                            MessageAdapterContentImageBinding binding7 = RoomImageHolder.this.getBinding();
                            if (binding7 != null) {
                                imageView9 = binding7.contentImageIv;
                            } else {
                                imageView9 = null;
                            }
                            String dataPath2 = msg.getDataPath();
                            final RoomImageHolder roomImageHolder = RoomImageHolder.this;
                            final String str = generateImagePath;
                            c5.g gVar = new c5.g() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomImageHolder$performImage$3$onSuccess$1
                                public boolean onLoadFailed(q e, Object model, com.bumptech.glide.request.target.j target, boolean isFirstResource) {
                                    Intrinsics.checkNotNullParameter(target, Constants.KEY_TARGET);
                                    RoomImageHolder.this.mImagePath = null;
                                    return false;
                                }

                                public boolean onResourceReady(Object resource, Object model, com.bumptech.glide.request.target.j target, m4.a dataSource, boolean isFirstResource) {
                                    Intrinsics.checkNotNullParameter(resource, "resource");
                                    Intrinsics.checkNotNullParameter(model, Constants.KEY_MODEL);
                                    Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                                    RoomImageHolder.this.mImagePath = str;
                                    return false;
                                }
                            };
                            i2 = RoomImageHolder.this.DEFAULT_RADIUS;
                            GlideEngine.loadCornerImageWithoutPlaceHolder(imageView9, dataPath2, gVar, i2);
                        }
                    });
                } else {
                    i++;
                }
            }
        }
        if (getIsMultiSelectMode()) {
            MessageAdapterContentImageBinding binding7 = getBinding();
            if (binding7 != null && (imageView5 = binding7.contentImageIv) != null) {
                final long j = 800;
                imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomImageHolder$performImage$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OnItemClickListener onItemClickListener;
                        OnItemClickListener onItemClickListener2;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView5) > j || (imageView5 instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(imageView5, currentTimeMillis);
                            ImageView imageView9 = (ImageView) imageView5;
                            onItemClickListener = ((MessageBaseHolder) this).onItemClickListener;
                            if (onItemClickListener != null) {
                                onItemClickListener2 = ((MessageBaseHolder) this).onItemClickListener;
                                onItemClickListener2.onMessageClick(imageView9, position, msg);
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        MessageAdapterContentImageBinding binding8 = getBinding();
        if (binding8 != null && (imageView4 = binding8.contentImageIv) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomImageHolder.performImage$lambda$3(RoomImageHolder.this, msg, view);
                }
            });
        }
        MessageAdapterContentImageBinding binding9 = getBinding();
        if (binding9 != null && (imageView3 = binding9.contentImageIv) != null) {
            imageView3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.d
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean performImage$lambda$4;
                    performImage$lambda$4 = RoomImageHolder.performImage$lambda$4(RoomImageHolder.this, position, msg, view);
                    return performImage$lambda$4;
                }
            });
        }
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
    public static final void performImage$lambda$3(RoomImageHolder roomImageHolder, RoomImageBean roomImageBean, View view) {
        List<TUIMessageBean> dataSource;
        Intent intent = new Intent(ServiceInitializer.getAppContext(), (Class<?>) ImageVideoScanActivity.class);
        intent.addFlags(268435456);
        if (roomImageHolder.getIsForwardMode() && roomImageHolder.getDataSource() != null && (dataSource = roomImageHolder.getDataSource()) != null && (!dataSource.isEmpty())) {
            intent.putExtra(TUIChatConstants.OPEN_MESSAGES_SCAN_FORWARD, (Serializable) roomImageHolder.getDataSource());
        }
        intent.putExtra(TUIChatConstants.OPEN_MESSAGE_SCAN, roomImageBean);
        intent.putExtra(TUIChatConstants.FORWARD_MODE, roomImageHolder.getIsForwardMode());
        ServiceInitializer.getAppContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean performImage$lambda$4(RoomImageHolder roomImageHolder, int i, RoomImageBean roomImageBean, View view) {
        OnItemClickListener onItemClickListener = roomImageHolder.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onMessageLongClick(view, i, roomImageBean);
            return true;
        }
        return true;
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
        if (!(msg instanceof RoomImageBean)) {
            return;
        }
        performImage((RoomImageBean) msg, position);
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

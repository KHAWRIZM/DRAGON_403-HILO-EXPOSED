package com.qiahao.nextvideo.room.rocket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import c5.g;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.RocketRoomSmallBean;
import com.qiahao.nextvideo.databinding.ViewRoomRocketEnterBinding;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0007R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/room/rocket/RoomRocketEnterView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContext", "mViewRoomRocketEnterView", "Lcom/qiahao/nextvideo/databinding/ViewRoomRocketEnterBinding;", "getMViewRoomRocketEnterView", "()Lcom/qiahao/nextvideo/databinding/ViewRoomRocketEnterBinding;", "setMViewRoomRocketEnterView", "(Lcom/qiahao/nextvideo/databinding/ViewRoomRocketEnterBinding;)V", "mRocketRoomSmallBean", "Lcom/qiahao/nextvideo/data/model/RocketRoomSmallBean;", "getMRocketRoomSmallBean", "()Lcom/qiahao/nextvideo/data/model/RocketRoomSmallBean;", "setMRocketRoomSmallBean", "(Lcom/qiahao/nextvideo/data/model/RocketRoomSmallBean;)V", "initView", "", "setData", "rocketRoomSmallBean", "updateView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomRocketEnterView extends FrameLayout {

    @NotNull
    private Context mContext;

    @Nullable
    private RocketRoomSmallBean mRocketRoomSmallBean;
    public ViewRoomRocketEnterBinding mViewRoomRocketEnterView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomRocketEnterView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView() {
        setMViewRoomRocketEnterView(ViewRoomRocketEnterBinding.inflate(LayoutInflater.from(this.mContext), this, true));
    }

    @Nullable
    public final RocketRoomSmallBean getMRocketRoomSmallBean() {
        return this.mRocketRoomSmallBean;
    }

    @NotNull
    public final ViewRoomRocketEnterBinding getMViewRoomRocketEnterView() {
        ViewRoomRocketEnterBinding viewRoomRocketEnterBinding = this.mViewRoomRocketEnterView;
        if (viewRoomRocketEnterBinding != null) {
            return viewRoomRocketEnterBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewRoomRocketEnterView");
        return null;
    }

    public final void setData(@NotNull RocketRoomSmallBean rocketRoomSmallBean) {
        Intrinsics.checkNotNullParameter(rocketRoomSmallBean, "rocketRoomSmallBean");
        this.mRocketRoomSmallBean = rocketRoomSmallBean;
        getMViewRoomRocketEnterView().progressBar.post(new Runnable() { // from class: com.qiahao.nextvideo.room.rocket.e
            @Override // java.lang.Runnable
            public final void run() {
                RoomRocketEnterView.this.updateView();
            }
        });
    }

    public final void setMRocketRoomSmallBean(@Nullable RocketRoomSmallBean rocketRoomSmallBean) {
        this.mRocketRoomSmallBean = rocketRoomSmallBean;
    }

    public final void setMViewRoomRocketEnterView(@NotNull ViewRoomRocketEnterBinding viewRoomRocketEnterBinding) {
        Intrinsics.checkNotNullParameter(viewRoomRocketEnterBinding, "<set-?>");
        this.mViewRoomRocketEnterView = viewRoomRocketEnterBinding;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void updateView() {
        int i;
        RocketRoomSmallBean rocketRoomSmallBean = this.mRocketRoomSmallBean;
        if (rocketRoomSmallBean == null) {
            return;
        }
        Intrinsics.checkNotNull(rocketRoomSmallBean);
        int stage = rocketRoomSmallBean.getStage();
        if (stage != 0) {
            if (stage != 1) {
                if (stage != 2) {
                    if (stage != 3) {
                        if (stage == 4) {
                            ImageView imageView = getMViewRoomRocketEnterView().imgRocket;
                            Intrinsics.checkNotNullExpressionValue(imageView, "imgRocket");
                            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_orange_enter), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                            getMViewRoomRocketEnterView().progressBar.setProgressDrawable(this.mContext.getDrawable(R.drawable.progressbar_orange_rocket_bg));
                        }
                    } else {
                        ImageView imageView2 = getMViewRoomRocketEnterView().imgRocket;
                        Intrinsics.checkNotNullExpressionValue(imageView2, "imgRocket");
                        ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_purple_enter), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                        getMViewRoomRocketEnterView().progressBar.setProgressDrawable(this.mContext.getDrawable(R.drawable.progressbar_purple_rocket_bg));
                    }
                } else {
                    ImageView imageView3 = getMViewRoomRocketEnterView().imgRocket;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "imgRocket");
                    ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_red_enter), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                    getMViewRoomRocketEnterView().progressBar.setProgressDrawable(this.mContext.getDrawable(R.drawable.progressbar_red_rocket_bg));
                }
            } else {
                ImageView imageView4 = getMViewRoomRocketEnterView().imgRocket;
                Intrinsics.checkNotNullExpressionValue(imageView4, "imgRocket");
                ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_blue_enter), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                getMViewRoomRocketEnterView().progressBar.setProgressDrawable(this.mContext.getDrawable(R.drawable.progressbar_blue_rocket_bg));
            }
        } else {
            ImageView imageView5 = getMViewRoomRocketEnterView().imgRocket;
            Intrinsics.checkNotNullExpressionValue(imageView5, "imgRocket");
            ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_green_enter), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
            getMViewRoomRocketEnterView().progressBar.setProgressDrawable(this.mContext.getDrawable(R.drawable.progressbar_green_rocket_bg));
        }
        ProgressBar progressBar = getMViewRoomRocketEnterView().progressBar;
        RocketRoomSmallBean rocketRoomSmallBean2 = this.mRocketRoomSmallBean;
        int i2 = 0;
        if (rocketRoomSmallBean2 != null) {
            i = rocketRoomSmallBean2.getNextScore();
        } else {
            i = 0;
        }
        progressBar.setMax(i);
        RocketRoomSmallBean rocketRoomSmallBean3 = this.mRocketRoomSmallBean;
        if (rocketRoomSmallBean3 != null) {
            i2 = rocketRoomSmallBean3.getScore();
        }
        progressBar.setProgress(i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomRocketEnterView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomRocketEnterView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mContext = context2;
        initView();
    }
}

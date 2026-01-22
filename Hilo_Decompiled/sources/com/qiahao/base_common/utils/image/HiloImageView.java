package com.qiahao.base_common.utils.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.wedgit.HiloCircleImageView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u00107\u001a\u0002082\u0006\u0010\u0006\u001a\u00020\u0007H\u0003J\b\u00109\u001a\u000208H\u0002J\"\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020&2\b\b\u0002\u0010<\u001a\u00020\n2\b\b\u0002\u0010=\u001a\u00020\nJ\b\u0010>\u001a\u000208H\u0007J\u0018\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020\n2\b\b\u0001\u0010A\u001a\u00020\nR\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000e\"\u0004\b-\u0010\u0010R\u001a\u0010.\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0010R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006B"}, d2 = {"Lcom/qiahao/base_common/utils/image/HiloImageView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRoundRadius", "getMRoundRadius", "()I", "setMRoundRadius", "(I)V", "mBorderWidth", "", "getMBorderWidth", "()F", "setMBorderWidth", "(F)V", "isCircle", "", "()Z", "setCircle", "(Z)V", "mBorderColor", "getMBorderColor", "setMBorderColor", "mImageView", "Lcom/qiahao/base_common/wedgit/HiloCircleImageView;", "getMImageView", "()Lcom/qiahao/base_common/wedgit/HiloCircleImageView;", "setMImageView", "(Lcom/qiahao/base_common/wedgit/HiloCircleImageView;)V", "mUrl", "", "getMUrl", "()Ljava/lang/Object;", "setMUrl", "(Ljava/lang/Object;)V", "mPlaceholder", "getMPlaceholder", "setMPlaceholder", "mErrorImage", "getMErrorImage", "setMErrorImage", "mBorderView", "Landroid/view/View;", "getMBorderView", "()Landroid/view/View;", "setMBorderView", "(Landroid/view/View;)V", "initAttrs", "", "initView", "loadImage", "url", "errorImage", "placeholder", "loadCircleImage", "setWidthAndColor", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "color", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HiloImageView extends FrameLayout {
    private boolean isCircle;
    private int mBorderColor;

    @Nullable
    private View mBorderView;
    private float mBorderWidth;
    private int mErrorImage;

    @Nullable
    private HiloCircleImageView mImageView;
    private int mPlaceholder;
    private int mRoundRadius;

    @NotNull
    private Object mUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isCircle = true;
        this.mBorderColor = R.color.white;
        this.mUrl = "";
        int i10 = R.drawable.default_user_icon;
        this.mPlaceholder = i10;
        this.mErrorImage = i10;
        initView();
    }

    @SuppressLint({"ResourceAsColor"})
    private final void initAttrs(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.HiloImageView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mRoundRadius = (int) obtainStyledAttributes.getDimension(R.styleable.HiloImageView_roundRadiusImg, DownloadProgress.UNKNOWN_PROGRESS);
        this.mBorderWidth = obtainStyledAttributes.getDimension(R.styleable.HiloImageView_borderWidthImg, DownloadProgress.UNKNOWN_PROGRESS);
        this.isCircle = obtainStyledAttributes.getBoolean(R.styleable.HiloImageView_isCircleImg, true);
        this.mBorderColor = obtainStyledAttributes.getColor(R.styleable.HiloImageView_borderColorImg, R.color.white);
        obtainStyledAttributes.recycle();
    }

    private final void initView() {
        if (getChildCount() == 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.mImageView = new HiloCircleImageView(context);
            this.mBorderView = new View(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            View view = this.mBorderView;
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            HiloCircleImageView hiloCircleImageView = this.mImageView;
            if (hiloCircleImageView != null) {
                hiloCircleImageView.setLayoutParams(layoutParams);
            }
            addView(this.mImageView);
            addView(this.mBorderView);
        }
    }

    public static /* synthetic */ void loadImage$default(HiloImageView hiloImageView, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = R.drawable.default_user_icon;
        }
        if ((i12 & 4) != 0) {
            i11 = R.drawable.default_user_icon;
        }
        hiloImageView.loadImage(obj, i10, i11);
    }

    public final int getMBorderColor() {
        return this.mBorderColor;
    }

    @Nullable
    public final View getMBorderView() {
        return this.mBorderView;
    }

    public final float getMBorderWidth() {
        return this.mBorderWidth;
    }

    public final int getMErrorImage() {
        return this.mErrorImage;
    }

    @Nullable
    public final HiloCircleImageView getMImageView() {
        return this.mImageView;
    }

    public final int getMPlaceholder() {
        return this.mPlaceholder;
    }

    public final int getMRoundRadius() {
        return this.mRoundRadius;
    }

    @NotNull
    public final Object getMUrl() {
        return this.mUrl;
    }

    /* renamed from: isCircle, reason: from getter */
    public final boolean getIsCircle() {
        return this.isCircle;
    }

    @SuppressLint({"CheckResult"})
    public final void loadCircleImage() {
        Drawable createShapeStroke;
        HiloCircleImageView hiloCircleImageView = this.mImageView;
        if (hiloCircleImageView != null) {
            BaseActivity activity = HiloUtils.INSTANCE.getActivity(hiloCircleImageView.getContext());
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                hiloCircleImageView.setCircle(this.isCircle);
                Object obj = this.mUrl;
                if (obj instanceof String) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    ImageKtxKt.loadImage$default(hiloCircleImageView, (String) obj, null, null, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(this.mPlaceholder), Integer.valueOf(this.mErrorImage), null, 40958, null);
                } else if (obj instanceof Integer) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    Integer num = (Integer) obj;
                    num.intValue();
                    ImageKtxKt.loadImage$default(hiloCircleImageView, null, null, null, num, null, null, false, 0, false, null, null, null, null, Integer.valueOf(this.mPlaceholder), Integer.valueOf(this.mErrorImage), null, 40951, null);
                } else if (obj instanceof Bitmap) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.Bitmap");
                    ImageKtxKt.loadImage$default(hiloCircleImageView, null, null, null, null, (Bitmap) obj, null, false, 0, false, null, null, null, null, Integer.valueOf(this.mPlaceholder), Integer.valueOf(this.mErrorImage), null, 40943, null);
                } else if (obj instanceof File) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.io.File");
                    ImageKtxKt.loadImage$default(hiloCircleImageView, null, null, (File) obj, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(this.mPlaceholder), Integer.valueOf(this.mErrorImage), null, 40955, null);
                }
            } else {
                return;
            }
        }
        if (this.mBorderWidth != DownloadProgress.UNKNOWN_PROGRESS && this.mBorderColor != 0) {
            try {
                View view = this.mBorderView;
                if (view != null) {
                    view.setVisibility(0);
                }
                View view2 = this.mBorderView;
                if (view2 != null) {
                    createShapeStroke = ShapeUtil.INSTANCE.createShapeStroke(this.mBorderColor, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? DownloadProgress.UNKNOWN_PROGRESS : this.mBorderWidth, (r12 & 8) != 0 ? false : true, (r12 & 16) == 0 ? 0 : 0, (r12 & 32) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null);
                    view2.setBackground(createShapeStroke);
                    return;
                }
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        View view3 = this.mBorderView;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    public final void loadImage(@NotNull Object url, int errorImage, int placeholder) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.mUrl = url;
        this.mErrorImage = errorImage;
        this.mPlaceholder = placeholder;
        loadCircleImage();
    }

    public final void setCircle(boolean z10) {
        this.isCircle = z10;
    }

    public final void setMBorderColor(int i10) {
        this.mBorderColor = i10;
    }

    public final void setMBorderView(@Nullable View view) {
        this.mBorderView = view;
    }

    public final void setMBorderWidth(float f10) {
        this.mBorderWidth = f10;
    }

    public final void setMErrorImage(int i10) {
        this.mErrorImage = i10;
    }

    public final void setMImageView(@Nullable HiloCircleImageView hiloCircleImageView) {
        this.mImageView = hiloCircleImageView;
    }

    public final void setMPlaceholder(int i10) {
        this.mPlaceholder = i10;
    }

    public final void setMRoundRadius(int i10) {
        this.mRoundRadius = i10;
    }

    public final void setMUrl(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.mUrl = obj;
    }

    public final void setWidthAndColor(int width, int color) {
        Drawable createShapeStroke;
        float px = UiKtxKt.toPX(width);
        this.mBorderWidth = px;
        this.mBorderColor = color;
        if (px != DownloadProgress.UNKNOWN_PROGRESS && color != 0) {
            try {
                View view = this.mBorderView;
                if (view != null) {
                    view.setVisibility(0);
                }
                View view2 = this.mBorderView;
                if (view2 != null) {
                    createShapeStroke = ShapeUtil.INSTANCE.createShapeStroke(this.mBorderColor, (r12 & 2) != 0 ? 0 : 0, (r12 & 4) != 0 ? DownloadProgress.UNKNOWN_PROGRESS : this.mBorderWidth, (r12 & 8) != 0 ? false : true, (r12 & 16) == 0 ? 0 : 0, (r12 & 32) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null);
                    view2.setBackground(createShapeStroke);
                    return;
                }
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        View view3 = this.mBorderView;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloImageView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.isCircle = true;
        this.mBorderColor = R.color.white;
        this.mUrl = "";
        int i10 = R.drawable.default_user_icon;
        this.mPlaceholder = i10;
        this.mErrorImage = i10;
        initAttrs(attrs);
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloImageView(@NotNull Context context, @NotNull AttributeSet attrs, int i10) {
        super(context, attrs, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.isCircle = true;
        this.mBorderColor = R.color.white;
        this.mUrl = "";
        int i11 = R.drawable.default_user_icon;
        this.mPlaceholder = i11;
        this.mErrorImage = i11;
        initAttrs(attrs);
        initView();
    }
}

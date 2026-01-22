package com.oudi.widget.nine;

import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.luck.picture.lib.config.CustomIntentKey;
import com.oudi.utils.AppUtils;
import com.oudi.utils.UiUtils;
import com.oudi.widget.R;
import com.oudi.widget.RecyclerViewBlankAreaClickHelper;
import com.oudi.widget.nine.NineGridView;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(3)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/oudi/widget/nine/NineGridView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gridSpacing", "isConfigured", "", "blankAreaClickHelper", "Lcom/oudi/widget/RecyclerViewBlankAreaClickHelper;", "getBlankAreaClickHelper", "()Lcom/oudi/widget/RecyclerViewBlankAreaClickHelper;", "blankAreaClickHelper$delegate", "Lkotlin/Lazy;", "config", "", "recycledViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "configStandardImage", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "Companion", "SizeInfo", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class NineGridView extends RecyclerView {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: blankAreaClickHelper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy blankAreaClickHelper;
    private int gridSpacing;
    private boolean isConfigured;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/oudi/widget/nine/NineGridView$Companion;", "", "<init>", "()V", "getRecycledViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecyclerView.RecycledViewPool getRecycledViewPool() {
            RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
            recycledViewPool.setMaxRecycledViews(0, 20);
            return recycledViewPool;
        }

        private Companion() {
        }
    }

    @Keep
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/oudi/widget/nine/NineGridView$SizeInfo;", "Ljava/io/Serializable;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "scaleType", "Landroid/widget/ImageView$ScaleType;", "<init>", "(IILandroid/widget/ImageView$ScaleType;)V", "getWidth", "()I", "getHeight", "getScaleType", "()Landroid/widget/ImageView$ScaleType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final /* data */ class SizeInfo implements Serializable {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final int maxSize;
        private static final int maxSizeRatio;
        private static final int minSize;
        private static final int screenWidth;
        private final int height;

        @NotNull
        private final ImageView.ScaleType scaleType;
        private final int width;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/oudi/widget/nine/NineGridView$SizeInfo$Companion;", "", "<init>", "()V", "screenWidth", "", "maxSizeRatio", "maxSize", "minSize", "measureImageSize", "Lcom/oudi/widget/nine/NineGridView$SizeInfo;", CustomIntentKey.EXTRA_IMAGE_WIDTH, CustomIntentKey.EXTRA_IMAGE_HEIGHT, "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final SizeInfo measureImageSize(int imageWidth, int imageHeight) {
                float f10;
                float f11;
                int i10;
                int i11;
                ImageView.ScaleType scaleType;
                if (imageWidth > imageHeight) {
                    f10 = imageWidth;
                    f11 = imageHeight;
                } else {
                    f10 = imageHeight;
                    f11 = imageWidth;
                }
                float f12 = f10 / f11;
                if (f12 < SizeInfo.maxSizeRatio) {
                    i10 = SizeInfo.maxSize;
                    i11 = (int) (i10 / f12);
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                } else {
                    i10 = SizeInfo.maxSize;
                    i11 = SizeInfo.minSize;
                    scaleType = null;
                }
                if (imageWidth > imageHeight) {
                    if (scaleType == null) {
                        scaleType = ImageView.ScaleType.CENTER_CROP;
                    }
                    return new SizeInfo(i10, i11, scaleType);
                }
                if (scaleType == null) {
                    scaleType = ImageView.ScaleType.MATRIX;
                }
                return new SizeInfo(i11, i10, scaleType);
            }

            private Companion() {
            }
        }

        static {
            UiUtils uiUtils = UiUtils.INSTANCE;
            Application app = AppUtils.getApp();
            Intrinsics.checkNotNullExpressionValue(app, "getApp(...)");
            int screenWidth2 = uiUtils.getScreenWidth(app);
            screenWidth = screenWidth2;
            maxSizeRatio = 4;
            maxSize = screenWidth2 / 2;
            minSize = (int) (screenWidth2 / 3.5f);
        }

        public SizeInfo(int i10, int i11, @NotNull ImageView.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.width = i10;
            this.height = i11;
            this.scaleType = scaleType;
        }

        public static /* synthetic */ SizeInfo copy$default(SizeInfo sizeInfo, int i10, int i11, ImageView.ScaleType scaleType, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = sizeInfo.width;
            }
            if ((i12 & 2) != 0) {
                i11 = sizeInfo.height;
            }
            if ((i12 & 4) != 0) {
                scaleType = sizeInfo.scaleType;
            }
            return sizeInfo.copy(i10, i11, scaleType);
        }

        /* renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component2, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final ImageView.ScaleType getScaleType() {
            return this.scaleType;
        }

        @NotNull
        public final SizeInfo copy(int width, int height, @NotNull ImageView.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            return new SizeInfo(width, height, scaleType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SizeInfo)) {
                return false;
            }
            SizeInfo sizeInfo = (SizeInfo) other;
            return this.width == sizeInfo.width && this.height == sizeInfo.height && this.scaleType == sizeInfo.scaleType;
        }

        public final int getHeight() {
            return this.height;
        }

        @NotNull
        public final ImageView.ScaleType getScaleType() {
            return this.scaleType;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return this.scaleType.hashCode() + ((this.height + (this.width * 31)) * 31);
        }

        @NotNull
        public String toString() {
            return "SizeInfo(width=" + this.width + ", height=" + this.height + ", scaleType=" + this.scaleType + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecyclerViewBlankAreaClickHelper blankAreaClickHelper_delegate$lambda$0(NineGridView nineGridView) {
        return new RecyclerViewBlankAreaClickHelper(nineGridView);
    }

    private final void config(RecyclerView.RecycledViewPool recycledViewPool) {
        NineGridLayoutManager nineGridLayoutManager;
        setNestedScrollingEnabled(false);
        setLayoutManager(new NineGridLayoutManager(this.gridSpacing));
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof NineGridLayoutManager) {
            nineGridLayoutManager = (NineGridLayoutManager) layoutManager;
        } else {
            nineGridLayoutManager = null;
        }
        if (nineGridLayoutManager != null) {
            nineGridLayoutManager.setRecycleChildrenOnDetach(false);
        }
        if (recycledViewPool != null) {
            setRecycledViewPool(recycledViewPool);
        }
    }

    public static /* synthetic */ void config$default(NineGridView nineGridView, RecyclerView.RecycledViewPool recycledViewPool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            recycledViewPool = null;
        }
        nineGridView.config(recycledViewPool);
    }

    public static /* synthetic */ void configStandardImage$default(NineGridView nineGridView, RecyclerView.RecycledViewPool recycledViewPool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            recycledViewPool = null;
        }
        nineGridView.configStandardImage(recycledViewPool);
    }

    private final RecyclerViewBlankAreaClickHelper getBlankAreaClickHelper() {
        return (RecyclerViewBlankAreaClickHelper) this.blankAreaClickHelper.getValue();
    }

    public final void configStandardImage(@Nullable RecyclerView.RecycledViewPool recycledViewPool) {
        if (this.isConfigured) {
            return;
        }
        this.isConfigured = true;
        config(recycledViewPool);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener l10) {
        super.setOnClickListener(l10);
        getBlankAreaClickHelper().setOnClickListener(l10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NineGridView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NineGridView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.blankAreaClickHelper = LazyKt.lazy(new Function0() { // from class: wa.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RecyclerViewBlankAreaClickHelper blankAreaClickHelper_delegate$lambda$0;
                blankAreaClickHelper_delegate$lambda$0 = NineGridView.blankAreaClickHelper_delegate$lambda$0(NineGridView.this);
                return blankAreaClickHelper_delegate$lambda$0;
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NineGridView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.gridSpacing = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.NineGridView_nine_grid_spacing, 0);
        obtainStyledAttributes.recycle();
    }
}

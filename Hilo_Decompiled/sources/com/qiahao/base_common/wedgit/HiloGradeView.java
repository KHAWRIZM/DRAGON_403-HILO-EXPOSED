package com.qiahao.base_common.wedgit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.qiahao.base_common.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0017R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/qiahao/base_common/wedgit/HiloGradeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTextColor", "mTextSize", "", "mDefaultImage", "Landroid/graphics/drawable/Drawable;", "getDefaultConfig", "", "setLevelBg", FirebaseAnalytics.Param.LEVEL, "", "isCharm", "", "isWealth", "isActivity", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHiloGradeView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HiloGradeView.kt\ncom/qiahao/base_common/wedgit/HiloGradeView\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,67:1\n51#2,9:68\n*S KotlinDebug\n*F\n+ 1 HiloGradeView.kt\ncom/qiahao/base_common/wedgit/HiloGradeView\n*L\n42#1:68,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HiloGradeView extends FrameLayout {

    @Nullable
    private Drawable mDefaultImage;
    private int mTextColor;
    private float mTextSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloGradeView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTextColor = androidx.core.content.a.getColor(getContext(), R.color.white);
        this.mTextSize = 10.0f;
        getDefaultConfig(context, null);
    }

    private final void getDefaultConfig(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] HiloGradeView = R.styleable.HiloGradeView;
            Intrinsics.checkNotNullExpressionValue(HiloGradeView, "HiloGradeView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, HiloGradeView, 0, 0);
            this.mTextColor = obtainStyledAttributes.getColor(R.styleable.HiloGradeView_android_textColor, androidx.core.content.a.getColor(context, R.color.white));
            this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.HiloGradeView_android_textSize, 10.0f);
            this.mDefaultImage = obtainStyledAttributes.getDrawable(R.styleable.HiloGradeView_android_src);
            obtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ void setLevelBg$default(HiloGradeView hiloGradeView, long j10, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        boolean z13;
        boolean z14;
        boolean z15;
        if ((i10 & 2) != 0) {
            z13 = false;
        } else {
            z13 = z10;
        }
        if ((i10 & 4) != 0) {
            z14 = false;
        } else {
            z14 = z11;
        }
        if ((i10 & 8) != 0) {
            z15 = false;
        } else {
            z15 = z12;
        }
        hiloGradeView.setLevelBg(j10, z13, z14, z15);
    }

    public final void setLevelBg(long level, boolean isCharm, boolean isWealth, boolean isActivity) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setBackground(new LevelDrawable(context, level, isCharm, isWealth, isActivity, this.mTextColor, this.mTextSize));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloGradeView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTextColor = androidx.core.content.a.getColor(getContext(), R.color.white);
        this.mTextSize = 10.0f;
        getDefaultConfig(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloGradeView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTextColor = androidx.core.content.a.getColor(getContext(), R.color.white);
        this.mTextSize = 10.0f;
        getDefaultConfig(context, attributeSet);
    }
}

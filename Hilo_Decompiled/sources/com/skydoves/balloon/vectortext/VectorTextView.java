package com.skydoves.balloon.vectortext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.skydoves.balloon.DefinitionKt;
import com.skydoves.balloon.R;
import com.skydoves.balloon.extensions.TextViewExtensionKt;
import com.tencent.rtmp.TXLiveConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/skydoves/balloon/vectortext/VectorTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Lcom/skydoves/balloon/vectortext/VectorTextViewParams;", "drawableTextViewParams", "getDrawableTextViewParams", "()Lcom/skydoves/balloon/vectortext/VectorTextViewParams;", "setDrawableTextViewParams", "(Lcom/skydoves/balloon/vectortext/VectorTextViewParams;)V", "initAttrs", "", "balloon_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class VectorTextView extends AppCompatTextView {

    @Nullable
    private VectorTextViewParams drawableTextViewParams;

    /* JADX WARN: Illegal instructions before constructor call */
    @JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VectorTextView(@NotNull Context context) {
        this(context, r0, 2, r0);
        AttributeSet attributeSet = null;
    }

    private final void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.VectorTextView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…styleable.VectorTextView)");
            setDrawableTextViewParams(new VectorTextViewParams(DefinitionKt.takeIfNotNoIntValue(obtainStyledAttributes.getResourceId(R.styleable.VectorTextView_drawableLeft, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(obtainStyledAttributes.getResourceId(R.styleable.VectorTextView_drawableRight, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(obtainStyledAttributes.getResourceId(R.styleable.VectorTextView_drawableBottom, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(obtainStyledAttributes.getResourceId(R.styleable.VectorTextView_drawableTop, Integer.MIN_VALUE)), null, null, null, null, null, null, DefinitionKt.takeIfNotNoIntValue(obtainStyledAttributes.getResourceId(R.styleable.VectorTextView_drawablePadding, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(obtainStyledAttributes.getResourceId(R.styleable.VectorTextView_drawableTintColor, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(obtainStyledAttributes.getResourceId(R.styleable.VectorTextView_drawableWidth, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(obtainStyledAttributes.getResourceId(R.styleable.VectorTextView_drawableHeight, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(obtainStyledAttributes.getResourceId(R.styleable.VectorTextView_drawableSquareSize, Integer.MIN_VALUE)), TXLiveConstants.PUSH_EVT_START_VIDEO_ENCODER, null));
            obtainStyledAttributes.recycle();
        }
    }

    @Nullable
    public final VectorTextViewParams getDrawableTextViewParams() {
        return this.drawableTextViewParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setDrawableTextViewParams(@Nullable VectorTextViewParams vectorTextViewParams) {
        if (vectorTextViewParams != null) {
            TextViewExtensionKt.applyDrawable(this, vectorTextViewParams);
            Unit unit = Unit.INSTANCE;
        } else {
            vectorTextViewParams = null;
        }
        this.drawableTextViewParams = vectorTextViewParams;
    }

    public /* synthetic */ VectorTextView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VectorTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initAttrs(context, attributeSet);
    }
}

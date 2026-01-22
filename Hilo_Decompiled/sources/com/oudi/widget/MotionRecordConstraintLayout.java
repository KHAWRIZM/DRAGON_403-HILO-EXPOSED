package com.oudi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013¨\u0006\""}, d2 = {"Lcom/oudi/widget/MotionRecordConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "lastDownX", "", "getLastDownX", "()Ljava/lang/Float;", "setLastDownX", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "lastDownY", "getLastDownY", "setLastDownY", "lastDownRawX", "getLastDownRawX", "setLastDownRawX", "lastDownRawY", "getLastDownRawY", "setLastDownRawY", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MotionRecordConstraintLayout extends ConstraintLayout {

    @Nullable
    private Float lastDownRawX;

    @Nullable
    private Float lastDownRawY;

    @Nullable
    private Float lastDownX;

    @Nullable
    private Float lastDownY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionRecordConstraintLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev) {
        if (ev != null && ev.getAction() == 0) {
            this.lastDownX = Float.valueOf(ev.getX());
            this.lastDownY = Float.valueOf(ev.getY());
            this.lastDownRawX = Float.valueOf(ev.getRawX());
            this.lastDownRawY = Float.valueOf(ev.getRawY());
        }
        return super.dispatchTouchEvent(ev);
    }

    @Nullable
    public final Float getLastDownRawX() {
        return this.lastDownRawX;
    }

    @Nullable
    public final Float getLastDownRawY() {
        return this.lastDownRawY;
    }

    @Nullable
    public final Float getLastDownX() {
        return this.lastDownX;
    }

    @Nullable
    public final Float getLastDownY() {
        return this.lastDownY;
    }

    public final void setLastDownRawX(@Nullable Float f10) {
        this.lastDownRawX = f10;
    }

    public final void setLastDownRawY(@Nullable Float f10) {
        this.lastDownRawY = f10;
    }

    public final void setLastDownX(@Nullable Float f10) {
        this.lastDownX = f10;
    }

    public final void setLastDownY(@Nullable Float f10) {
        this.lastDownY = f10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionRecordConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionRecordConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MotionRecordConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

package com.qhqc.core.basic.uiframe.ui.dialogfragment;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/DialogOptions;", "", "()V", "cancelable", "", "getCancelable", "()Z", "setCancelable", "(Z)V", "dimAmount", "", "getDimAmount", "()F", "setDimAmount", "(F)V", "gravity", "", "getGravity", "()I", "setGravity", "(I)V", "isHeightMatch", "setHeightMatch", "isWidthMatch", "setWidthMatch", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class DialogOptions {
    private boolean isHeightMatch;
    private int gravity = 80;
    private boolean cancelable = true;
    private float dimAmount = 0.5f;
    private boolean isWidthMatch = true;

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final float getDimAmount() {
        return this.dimAmount;
    }

    public final int getGravity() {
        return this.gravity;
    }

    /* renamed from: isHeightMatch, reason: from getter */
    public final boolean getIsHeightMatch() {
        return this.isHeightMatch;
    }

    /* renamed from: isWidthMatch, reason: from getter */
    public final boolean getIsWidthMatch() {
        return this.isWidthMatch;
    }

    public final void setCancelable(boolean z10) {
        this.cancelable = z10;
    }

    public final void setDimAmount(float f10) {
        this.dimAmount = f10;
    }

    public final void setGravity(int i10) {
        this.gravity = i10;
    }

    public final void setHeightMatch(boolean z10) {
        this.isHeightMatch = z10;
    }

    public final void setWidthMatch(boolean z10) {
        this.isWidthMatch = z10;
    }
}

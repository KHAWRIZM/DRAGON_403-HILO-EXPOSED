package com.qmuiteam.qmui.kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0003\u001a\u0019\u0010\f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0019\u0010\u000e\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\r\u001a\u0019\u0010\u000f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\r\u001a\u0019\u0010\u0010\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\r\u001a\u0019\u0010\u0011\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\r\u001a\u0019\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\r\u001a\u0019\u0010\u0013\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\r\"\u001a\u0010\u0014\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u0018\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017\"\u001a\u0010\u001a\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u001a\u0010\u001c\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017¨\u0006\u001e"}, d2 = {"Landroidx/constraintlayout/widget/ConstraintLayout$b;", "", "alignParent4", "(Landroidx/constraintlayout/widget/ConstraintLayout$b;)V", "alignParentHor", "alignParentVer", "alignParentLeftTop", "alignParentLeftBottom", "alignParentRightTop", "alignParentRightBottom", "", "id", "alignView4", "(Landroidx/constraintlayout/widget/ConstraintLayout$b;I)V", "alignViewHor", "alignViewVer", "alignViewLeftTop", "alignViewLeftBottom", "alignViewRightTop", "alignViewRightBottom", "matchParent", "I", "getMatchParent", "()I", "wrapContent", "getWrapContent", "matchConstraint", "getMatchConstraint", "constraintParentId", "getConstraintParentId", "qmui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class LayoutParamKtKt {
    private static final int constraintParentId = 0;
    private static final int matchConstraint = 0;
    private static final int matchParent = -1;
    private static final int wrapContent = -2;

    public static final void alignParent4(@NotNull ConstraintLayout.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int i10 = constraintParentId;
        bVar.f٢٣٠٧e = i10;
        bVar.f٢٣١٣h = i10;
        bVar.f٢٣١٥i = i10;
        bVar.f٢٣٢١l = i10;
    }

    public static final void alignParentHor(@NotNull ConstraintLayout.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int i10 = constraintParentId;
        bVar.f٢٣٠٧e = i10;
        bVar.f٢٣١٣h = i10;
    }

    public static final void alignParentLeftBottom(@NotNull ConstraintLayout.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int i10 = constraintParentId;
        bVar.f٢٣٢١l = i10;
        bVar.f٢٣٠٧e = i10;
    }

    public static final void alignParentLeftTop(@NotNull ConstraintLayout.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int i10 = constraintParentId;
        bVar.f٢٣١٥i = i10;
        bVar.f٢٣٠٧e = i10;
    }

    public static final void alignParentRightBottom(@NotNull ConstraintLayout.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int i10 = constraintParentId;
        bVar.f٢٣٢١l = i10;
        bVar.f٢٣١٣h = i10;
    }

    public static final void alignParentRightTop(@NotNull ConstraintLayout.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int i10 = constraintParentId;
        bVar.f٢٣١٥i = i10;
        bVar.f٢٣١٣h = i10;
    }

    public static final void alignParentVer(@NotNull ConstraintLayout.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        int i10 = constraintParentId;
        bVar.f٢٣١٥i = i10;
        bVar.f٢٣٢١l = i10;
    }

    public static final void alignView4(@NotNull ConstraintLayout.b bVar, int i10) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.f٢٣٠٧e = i10;
        bVar.f٢٣١٣h = i10;
        bVar.f٢٣١٥i = i10;
        bVar.f٢٣٢١l = i10;
    }

    public static final void alignViewHor(@NotNull ConstraintLayout.b bVar, int i10) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.f٢٣٠٧e = i10;
        bVar.f٢٣١٣h = i10;
    }

    public static final void alignViewLeftBottom(@NotNull ConstraintLayout.b bVar, int i10) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.f٢٣٢١l = i10;
        bVar.f٢٣٠٧e = i10;
    }

    public static final void alignViewLeftTop(@NotNull ConstraintLayout.b bVar, int i10) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.f٢٣١٥i = i10;
        bVar.f٢٣٠٧e = i10;
    }

    public static final void alignViewRightBottom(@NotNull ConstraintLayout.b bVar, int i10) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.f٢٣٢١l = i10;
        bVar.f٢٣١٣h = i10;
    }

    public static final void alignViewRightTop(@NotNull ConstraintLayout.b bVar, int i10) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.f٢٣١٥i = i10;
        bVar.f٢٣١٣h = i10;
    }

    public static final void alignViewVer(@NotNull ConstraintLayout.b bVar, int i10) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        bVar.f٢٣١٥i = i10;
        bVar.f٢٣٢١l = i10;
    }

    public static final int getConstraintParentId() {
        return constraintParentId;
    }

    public static final int getMatchConstraint() {
        return matchConstraint;
    }

    public static final int getMatchParent() {
        return matchParent;
    }

    public static final int getWrapContent() {
        return wrapContent;
    }
}

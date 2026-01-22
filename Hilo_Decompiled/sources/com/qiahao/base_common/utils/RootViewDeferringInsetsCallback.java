package com.qiahao.base_common.utils;

import android.view.View;
import androidx.core.graphics.b0;
import androidx.core.view.d1;
import androidx.core.view.d2;
import androidx.core.view.j0;
import androidx.core.view.q1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/qiahao/base_common/utils/RootViewDeferringInsetsCallback;", "Landroidx/core/view/q1$b;", "Landroidx/core/view/j0;", "", "persistentInsetTypes", "deferredInsetTypes", "<init>", "(II)V", "Landroid/view/View;", "v", "Landroidx/core/view/d2;", "windowInsets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/d2;)Landroidx/core/view/d2;", "Landroidx/core/view/q1;", "animation", "", "onPrepare", "(Landroidx/core/view/q1;)V", "insets", "", "runningAnims", "onProgress", "(Landroidx/core/view/d2;Ljava/util/List;)Landroidx/core/view/d2;", "onEnd", "I", "getPersistentInsetTypes", "()I", "getDeferredInsetTypes", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "lastWindowInsets", "Landroidx/core/view/d2;", "", "deferredInsets", "Z", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RootViewDeferringInsetsCallback extends q1.b implements j0 {
    private final int deferredInsetTypes;
    private boolean deferredInsets;

    @Nullable
    private d2 lastWindowInsets;
    private final int persistentInsetTypes;

    @Nullable
    private View view;

    public RootViewDeferringInsetsCallback(int i10, int i11) {
        super(1);
        this.persistentInsetTypes = i10;
        this.deferredInsetTypes = i11;
        if ((i10 & i11) == 0) {
        } else {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values");
        }
    }

    public final int getDeferredInsetTypes() {
        return this.deferredInsetTypes;
    }

    public final int getPersistentInsetTypes() {
        return this.persistentInsetTypes;
    }

    @Override // androidx.core.view.j0
    @NotNull
    public d2 onApplyWindowInsets(@NotNull View v10, @NotNull d2 windowInsets) {
        int i10;
        Intrinsics.checkNotNullParameter(v10, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        this.view = v10;
        this.lastWindowInsets = windowInsets;
        if (this.deferredInsets) {
            i10 = this.persistentInsetTypes;
        } else {
            i10 = this.persistentInsetTypes | this.deferredInsetTypes;
        }
        b0 f10 = windowInsets.f(i10);
        Intrinsics.checkNotNullExpressionValue(f10, "getInsets(...)");
        v10.setPadding(f10.f٢٧٩٣a, f10.f٢٧٩٤b, f10.f٢٧٩٥c, f10.f٢٧٩٦d);
        d2 CONSUMED = d2.f٢٩٣٥b;
        Intrinsics.checkNotNullExpressionValue(CONSUMED, "CONSUMED");
        return CONSUMED;
    }

    @Override // androidx.core.view.q1.b
    public void onEnd(@NotNull q1 animation) {
        View view;
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (this.deferredInsets && (animation.c() & this.deferredInsetTypes) != 0) {
            this.deferredInsets = false;
            if (this.lastWindowInsets != null && (view = this.view) != null) {
                Intrinsics.checkNotNull(view);
                d2 d2Var = this.lastWindowInsets;
                Intrinsics.checkNotNull(d2Var);
                d1.j(view, d2Var);
            }
        }
    }

    @Override // androidx.core.view.q1.b
    public void onPrepare(@NotNull q1 animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if ((animation.c() & this.deferredInsetTypes) != 0) {
            this.deferredInsets = true;
        }
    }

    @Override // androidx.core.view.q1.b
    @NotNull
    public d2 onProgress(@NotNull d2 insets, @NotNull List<q1> runningAnims) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(runningAnims, "runningAnims");
        return insets;
    }
}

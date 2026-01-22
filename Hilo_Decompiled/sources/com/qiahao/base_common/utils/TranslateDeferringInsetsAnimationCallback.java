package com.qiahao.base_common.utils;

import android.view.View;
import androidx.core.graphics.b0;
import androidx.core.view.d2;
import androidx.core.view.q1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/qiahao/base_common/utils/TranslateDeferringInsetsAnimationCallback;", "Landroidx/core/view/q1$b;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "persistentInsetTypes", "deferredInsetTypes", "dispatchMode", "<init>", "(Landroid/view/View;III)V", "Landroidx/core/view/d2;", "insets", "", "Landroidx/core/view/q1;", "runningAnimations", "onProgress", "(Landroidx/core/view/d2;Ljava/util/List;)Landroidx/core/view/d2;", "animation", "", "onEnd", "(Landroidx/core/view/q1;)V", "Landroid/view/View;", "I", "getPersistentInsetTypes", "()I", "getDeferredInsetTypes", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TranslateDeferringInsetsAnimationCallback extends q1.b {
    private final int deferredInsetTypes;
    private final int persistentInsetTypes;

    @NotNull
    private final View view;

    public /* synthetic */ TranslateDeferringInsetsAnimationCallback(View view, int i10, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, i10, i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public final int getDeferredInsetTypes() {
        return this.deferredInsetTypes;
    }

    public final int getPersistentInsetTypes() {
        return this.persistentInsetTypes;
    }

    @Override // androidx.core.view.q1.b
    public void onEnd(@NotNull q1 animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.view.setTranslationX(DownloadProgress.UNKNOWN_PROGRESS);
        this.view.setTranslationY(DownloadProgress.UNKNOWN_PROGRESS);
    }

    @Override // androidx.core.view.q1.b
    @NotNull
    public d2 onProgress(@NotNull d2 insets, @NotNull List<q1> runningAnimations) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
        b0 f10 = insets.f(this.deferredInsetTypes);
        Intrinsics.checkNotNullExpressionValue(f10, "getInsets(...)");
        b0 f11 = insets.f(this.persistentInsetTypes);
        Intrinsics.checkNotNullExpressionValue(f11, "getInsets(...)");
        Intrinsics.checkNotNullExpressionValue(b0.a(b0.d(f10, f11), b0.f٢٧٩٢e), "let(...)");
        this.view.setTranslationX(r5.f٢٧٩٣a - r5.f٢٧٩٥c);
        this.view.setTranslationY(r5.f٢٧٩٤b - r5.f٢٧٩٦d);
        return insets;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranslateDeferringInsetsAnimationCallback(@NotNull View view, int i10, int i11, int i12) {
        super(i12);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.persistentInsetTypes = i10;
        this.deferredInsetTypes = i11;
        if ((i10 & i11) != 0) {
            throw new IllegalArgumentException("persistentInsetTypes and deferredInsetTypes can not contain any of  same WindowInsetsCompat.Type values");
        }
    }
}

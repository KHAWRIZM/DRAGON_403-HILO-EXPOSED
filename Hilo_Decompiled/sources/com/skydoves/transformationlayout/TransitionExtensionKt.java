package com.skydoves.transformationlayout;

import android.app.Activity;
import androidx.core.view.d1;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.skydoves.transformationlayout.TransformationLayout;
import i8.k;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0006\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a \u0010\u0007\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\r"}, d2 = {"onTransformationStartContainer", "", "Landroid/app/Activity;", "onTransformationEndContainer", "params", "Lcom/skydoves/transformationlayout/TransformationLayout$Params;", "Landroidx/fragment/app/Fragment;", "addTransformation", "Landroidx/fragment/app/FragmentTransaction;", "transformationLayout", "Lcom/skydoves/transformationlayout/TransformationLayout;", "transitionName", "", "transformationlayout_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TransitionExtensionKt {
    @JvmOverloads
    @NotNull
    public static final FragmentTransaction addTransformation(@NotNull FragmentTransaction fragmentTransaction, @NotNull TransformationLayout transformationLayout) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "<this>");
        Intrinsics.checkNotNullParameter(transformationLayout, "transformationLayout");
        return addTransformation$default(fragmentTransaction, transformationLayout, null, 2, null);
    }

    public static /* synthetic */ FragmentTransaction addTransformation$default(FragmentTransaction fragmentTransaction, TransformationLayout transformationLayout, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return addTransformation(fragmentTransaction, transformationLayout, str);
    }

    public static final void onTransformationEndContainer(@NotNull Activity activity, @Nullable TransformationLayout.Params params) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (params != null) {
            activity.getWindow().requestFeature(13);
            d1.J0(activity.findViewById(android.R.id.content), params.getTransitionName());
            activity.setEnterSharedElementCallback(new k());
            activity.getWindow().setSharedElementEnterTransition(TransformationParamsKt.getMaterialContainerTransform(params));
            activity.getWindow().setSharedElementReturnTransition(TransformationParamsKt.getMaterialContainerTransform(params));
            return;
        }
        throw new IllegalArgumentException("TransformationLayout.Params must not be a null. check your intent key value is correct.");
    }

    public static final void onTransformationStartContainer(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        activity.getWindow().requestFeature(13);
        activity.setExitSharedElementCallback(new k());
        activity.getWindow().setSharedElementsUseOverlay(false);
    }

    @JvmOverloads
    @NotNull
    public static final FragmentTransaction addTransformation(@NotNull FragmentTransaction fragmentTransaction, @NotNull TransformationLayout transformationLayout, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "<this>");
        Intrinsics.checkNotNullParameter(transformationLayout, "transformationLayout");
        if (str != null && transformationLayout.getTransitionName() == null) {
            d1.J0(transformationLayout, str);
        }
        fragmentTransaction.addSharedElement(transformationLayout, transformationLayout.getTransitionName());
        return fragmentTransaction;
    }

    public static final void onTransformationStartContainer(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        fragment.setExitTransition(new i8.g());
    }

    public static final void onTransformationEndContainer(@NotNull Fragment fragment, @Nullable TransformationLayout.Params params) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        if (params != null) {
            fragment.setSharedElementEnterTransition(TransformationParamsKt.getMaterialFragmentTransform(params));
            return;
        }
        throw new IllegalArgumentException("TransformationLayout.Params must not be a null. check your intent key value is correct.");
    }
}

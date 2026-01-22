package com.skydoves.transformationlayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import com.skydoves.transformationlayout.TransformationLayout;
import com.taobao.accs.messenger.MessengerService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J$\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0007J/\u0010\u001c\u001a\u00020\u0007*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00070\u001eH\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/skydoves/transformationlayout/TransformationCompat;", "", "<init>", "()V", "activityTransitionName", "", "startActivity", "", "transformationLayout", "Lcom/skydoves/transformationlayout/TransformationLayout;", MessengerService.INTENT, "Landroid/content/Intent;", "startActivityForResult", "requestCode", "", "onTransformationEndContainerApplyParams", AgooConstants.OPEN_ACTIIVTY_NAME, "Landroid/app/Activity;", "onTransformationStartContainer", "onTransformationEndContainer", "params", "Lcom/skydoves/transformationlayout/TransformationLayout$Params;", "fragment", "Landroidx/fragment/app/Fragment;", "addTransformation", "fragmentTransaction", "Landroidx/fragment/app/FragmentTransaction;", "transitionName", "startActivityWithBundleOptions", MessageMenuDialog.BLOCK, "Lkotlin/Function2;", "Landroid/os/Bundle;", "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransformationCompat.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformationCompat.kt\ncom/skydoves/transformationlayout/TransformationCompat\n*L\n1#1,128:1\n119#1,8:129\n119#1,8:137\n*S KotlinDebug\n*F\n+ 1 TransformationCompat.kt\ncom/skydoves/transformationlayout/TransformationCompat\n*L\n41#1:129,8\n58#1:137,8\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TransformationCompat {

    @NotNull
    public static final TransformationCompat INSTANCE = new TransformationCompat();

    @NotNull
    public static final String activityTransitionName = "com.skydoves.transformationlayout";

    private TransformationCompat() {
    }

    @JvmStatic
    public static final void addTransformation(@NotNull FragmentTransaction fragmentTransaction, @NotNull TransformationLayout transformationLayout, @Nullable String transitionName) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "fragmentTransaction");
        Intrinsics.checkNotNullParameter(transformationLayout, "transformationLayout");
        TransitionExtensionKt.addTransformation(fragmentTransaction, transformationLayout, transitionName);
    }

    public static /* synthetic */ void addTransformation$default(FragmentTransaction fragmentTransaction, TransformationLayout transformationLayout, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        addTransformation(fragmentTransaction, transformationLayout, str);
    }

    @JvmStatic
    public static final void onTransformationEndContainer(@NotNull Activity activity, @Nullable TransformationLayout.Params params) {
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        TransitionExtensionKt.onTransformationEndContainer(activity, params);
    }

    @JvmStatic
    public static final void onTransformationEndContainerApplyParams(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        TransitionExtensionKt.onTransformationEndContainer(activity, (TransformationLayout.Params) activity.getIntent().getParcelableExtra(activityTransitionName));
    }

    @JvmStatic
    public static final void onTransformationStartContainer(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        TransitionExtensionKt.onTransformationStartContainer(activity);
    }

    @JvmStatic
    public static final void startActivity(@NotNull TransformationLayout transformationLayout, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(transformationLayout, "transformationLayout");
        Intrinsics.checkNotNullParameter(intent, MessengerService.INTENT);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - transformationLayout.getThrottledTime() > transformationLayout.getDuration()) {
            transformationLayout.setThrottledTime(elapsedRealtime);
            Bundle withView = transformationLayout.withView(transformationLayout, activityTransitionName);
            intent.putExtra(activityTransitionName, transformationLayout.getParcelableParams());
            androidx.core.content.a.startActivity(transformationLayout.getContext(), intent, withView);
        }
    }

    @JvmStatic
    public static final void startActivityForResult(@NotNull TransformationLayout transformationLayout, @NotNull Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(transformationLayout, "transformationLayout");
        Intrinsics.checkNotNullParameter(intent, MessengerService.INTENT);
        Context context = transformationLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Activity activity = ContextExtensionKt.getActivity(context);
        if (activity != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - transformationLayout.getThrottledTime() > transformationLayout.getDuration()) {
                transformationLayout.setThrottledTime(elapsedRealtime);
                Bundle withView = transformationLayout.withView(transformationLayout, activityTransitionName);
                intent.putExtra(activityTransitionName, transformationLayout.getParcelableParams());
                androidx.core.app.b.k(activity, intent, requestCode, withView);
            }
        }
    }

    private final void startActivityWithBundleOptions(TransformationLayout transformationLayout, Intent intent, Function2<? super Intent, ? super Bundle, Unit> function2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - transformationLayout.getThrottledTime() > transformationLayout.getDuration()) {
            transformationLayout.setThrottledTime(elapsedRealtime);
            Bundle withView = transformationLayout.withView(transformationLayout, activityTransitionName);
            intent.putExtra(activityTransitionName, transformationLayout.getParcelableParams());
            function2.invoke(intent, withView);
        }
    }

    @JvmStatic
    public static final void onTransformationEndContainer(@NotNull Fragment fragment, @Nullable TransformationLayout.Params params) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        TransitionExtensionKt.onTransformationEndContainer(fragment, params);
    }

    @JvmStatic
    public static final void onTransformationStartContainer(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        TransitionExtensionKt.onTransformationStartContainer(fragment);
    }
}

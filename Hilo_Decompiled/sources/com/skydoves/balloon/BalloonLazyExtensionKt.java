package com.skydoves.balloon;

import android.content.Context;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import com.skydoves.balloon.Balloon;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\u0005H\u0087\b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\b\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\bH\u0087\b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\b\u001a!\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\tH\u0087\b\u001a/\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u0004*\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\b¨\u0006\n"}, d2 = {"balloon", "Lkotlin/Lazy;", "Lcom/skydoves/balloon/Balloon;", "T", "Lcom/skydoves/balloon/Balloon$Factory;", "Landroid/view/View;", "factory", "Lkotlin/reflect/KClass;", "Landroidx/activity/ComponentActivity;", "Landroidx/fragment/app/Fragment;", "balloon_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class BalloonLazyExtensionKt {
    @Deprecated(message = "Use balloon<T>() instead", replaceWith = @ReplaceWith(expression = "balloon<T>()", imports = {"com.skydoves.balloon"}))
    public static final /* synthetic */ <T extends Balloon.Factory> Lazy<Balloon> balloon(ComponentActivity componentActivity, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(componentActivity, "$this$balloon");
        Intrinsics.checkNotNullParameter(kClass, "factory");
        return new ActivityBalloonLazy(componentActivity, componentActivity, kClass);
    }

    public static final /* synthetic */ <T extends Balloon.Factory> Lazy<Balloon> balloon(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "$this$balloon");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new ActivityBalloonLazy(componentActivity, componentActivity, Reflection.getOrCreateKotlinClass(Balloon.Factory.class));
    }

    @Deprecated(message = "Use balloon<T>() instead", replaceWith = @ReplaceWith(expression = "balloon<T>()", imports = {"com.skydoves.balloon"}))
    public static final /* synthetic */ <T extends Balloon.Factory> Lazy<Balloon> balloon(Fragment fragment, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(fragment, "$this$balloon");
        Intrinsics.checkNotNullParameter(kClass, "factory");
        return new FragmentBalloonLazy(fragment, kClass);
    }

    public static final /* synthetic */ <T extends Balloon.Factory> Lazy<Balloon> balloon(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "$this$balloon");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new FragmentBalloonLazy(fragment, Reflection.getOrCreateKotlinClass(Balloon.Factory.class));
    }

    @Deprecated(message = "Use balloon<T>() instead", replaceWith = @ReplaceWith(expression = "balloon<T>()", imports = {"com.skydoves.balloon"}))
    public static final /* synthetic */ <T extends Balloon.Factory> Lazy<Balloon> balloon(View view, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(view, "$this$balloon");
        Intrinsics.checkNotNullParameter(kClass, "factory");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new ViewBalloonLazy(context, kClass);
    }

    public static final /* synthetic */ <T extends Balloon.Factory> Lazy<Balloon> balloon(View view) {
        Intrinsics.checkNotNullParameter(view, "$this$balloon");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new ViewBalloonLazy(context, Reflection.getOrCreateKotlinClass(Balloon.Factory.class));
    }
}

package com.qhqc.core.basic.expand;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import j3.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a7\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0005\u0010\r\u001a;\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0004\u0012\u00028\u00000\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lj3/a;", "VB", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/LayoutInflater;", "layoutInflater", "inflateWithGeneric", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/view/LayoutInflater;)Lj3/a;", "inflateBindingWithGeneric", "Landroidx/fragment/app/Fragment;", "Landroid/view/ViewGroup;", "parent", "", "attachToParent", "(Landroidx/fragment/app/Fragment;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lj3/a;", "", "any", "Lkotlin/Function1;", "Ljava/lang/Class;", ChatMenuDialog.CLICK_BLOCK, "withGenericBindingClass", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lj3/a;", "basic_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ViewBindUtilKt {
    @JvmName(name = "inflateWithGeneric")
    @NotNull
    public static final <VB extends a> VB inflateWithGeneric(@NotNull AppCompatActivity appCompatActivity, @NotNull final LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        ViewDataBinding viewDataBinding = (VB) withGenericBindingClass(appCompatActivity, new Function1<Class<VB>, VB>() { // from class: com.qhqc.core.basic.expand.ViewBindUtilKt$inflateBindingWithGeneric$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Class<TVB;>;)TVB; */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final a invoke(@NotNull Class clazz) {
                Intrinsics.checkNotNullParameter(clazz, "clazz");
                Object invoke = clazz.getMethod("inflate", LayoutInflater.class).invoke(null, layoutInflater);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type VB of com.qhqc.core.basic.expand.ViewBindUtilKt.inflateBindingWithGeneric");
                return (a) invoke;
            }
        });
        if (viewDataBinding instanceof ViewDataBinding) {
            viewDataBinding.setLifecycleOwner(appCompatActivity);
        }
        return viewDataBinding;
    }

    private static final <VB extends a> VB withGenericBindingClass(Object obj, Function1<? super Class<VB>, ? extends VB> function1) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        for (Class<? super Object> superclass = obj.getClass().getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (genericSuperclass instanceof ParameterizedType) {
                try {
                    Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                    Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<VB of com.qhqc.core.basic.expand.ViewBindUtilKt.withGenericBindingClass>");
                    return function1.invoke((Class) type);
                } catch (ClassCastException | NoSuchMethodException unused) {
                    continue;
                } catch (InvocationTargetException e10) {
                    Throwable targetException = e10.getTargetException();
                    Intrinsics.checkNotNullExpressionValue(targetException, "getTargetException(...)");
                    throw targetException;
                }
            }
            genericSuperclass = superclass.getGenericSuperclass();
        }
        throw new IllegalArgumentException("There is no generic of ViewBinding.");
    }

    @JvmName(name = "inflateWithGeneric")
    @NotNull
    public static final <VB extends a> VB inflateWithGeneric(@NotNull Fragment fragment, @NotNull final LayoutInflater layoutInflater, @Nullable final ViewGroup viewGroup, final boolean z10) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        ViewDataBinding viewDataBinding = (VB) withGenericBindingClass(fragment, new Function1<Class<VB>, VB>() { // from class: com.qhqc.core.basic.expand.ViewBindUtilKt$inflateBindingWithGeneric$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Incorrect return type in method signature: (Ljava/lang/Class<TVB;>;)TVB; */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final a invoke(@NotNull Class clazz) {
                Intrinsics.checkNotNullParameter(clazz, "clazz");
                Object invoke = clazz.getMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE).invoke(null, layoutInflater, viewGroup, Boolean.valueOf(z10));
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type VB of com.qhqc.core.basic.expand.ViewBindUtilKt.inflateBindingWithGeneric");
                return (a) invoke;
            }
        });
        if (viewDataBinding instanceof ViewDataBinding) {
            viewDataBinding.setLifecycleOwner(fragment.getViewLifecycleOwner());
        }
        return viewDataBinding;
    }
}

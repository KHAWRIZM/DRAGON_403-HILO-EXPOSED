package com.skydoves.balloon;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.Balloon.Factory;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0088\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/skydoves/balloon/ViewBalloonLazy;", "T", "Lcom/skydoves/balloon/Balloon$Factory;", "Lkotlin/Lazy;", "Lcom/skydoves/balloon/Balloon;", "Ljava/io/Serializable;", "context", "Landroid/content/Context;", "clazz", "Lkotlin/reflect/KClass;", "(Landroid/content/Context;Lkotlin/reflect/KClass;)V", "cached", "value", "getValue", "()Lcom/skydoves/balloon/Balloon;", "isInitialized", "", "toString", "", "balloon_release"}, k = 1, mv = {1, 4, 1})
@PublishedApi
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ViewBalloonLazy<T extends Balloon.Factory> implements Lazy<Balloon>, Serializable {
    private Balloon cached;
    private final KClass<T> clazz;
    private final Context context;

    public ViewBalloonLazy(@NotNull Context context, @NotNull KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        this.context = context;
        this.clazz = kClass;
    }

    public boolean isInitialized() {
        if (this.cached != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        if (isInitialized()) {
            return m١٠٩getValue().toString();
        }
        return "Lazy value not initialized yet.";
    }

    @NotNull
    /* renamed from: getValue, reason: merged with bridge method [inline-methods] */
    public Balloon m١٠٩getValue() {
        Balloon balloon = this.cached;
        if (balloon != null) {
            return balloon;
        }
        if (this.context instanceof ComponentActivity) {
            final KClass<T> kClass = this.clazz;
            Balloon.Factory factory = (Balloon.Factory) ((Class) new PropertyReference0Impl(kClass) { // from class: com.skydoves.balloon.ViewBalloonLazy$value$factory$1
                @Nullable
                public Object get() {
                    return JvmClassMappingKt.getJavaClass((KClass) ((CallableReference) this).receiver);
                }
            }.get()).newInstance();
            Context context = this.context;
            Balloon create = factory.create(context, (LifecycleOwner) context);
            this.cached = create;
            return create;
        }
        throw new IllegalArgumentException("Balloon can not be initialized. The passed context is not an instance of the ComponentActivity.");
    }
}

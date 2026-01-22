package androidx.lifecycle.model;

import androidx.lifecycle.Elements_extKt;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Landroidx/lifecycle/model/EventMethod;", "", FirebaseAnalytics.Param.METHOD, "Ljavax/lang/model/element/ExecutableElement;", "onLifecycleEvent", "Landroidx/lifecycle/OnLifecycleEvent;", "type", "Ljavax/lang/model/element/TypeElement;", "<init>", "(Ljavax/lang/model/element/ExecutableElement;Landroidx/lifecycle/OnLifecycleEvent;Ljavax/lang/model/element/TypeElement;)V", "getMethod", "()Ljavax/lang/model/element/ExecutableElement;", "getOnLifecycleEvent", "()Landroidx/lifecycle/OnLifecycleEvent;", "getType", "()Ljavax/lang/model/element/TypeElement;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "lifecycle-compiler"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final /* data */ class EventMethod {

    @NotNull
    private final ExecutableElement method;

    @NotNull
    private final OnLifecycleEvent onLifecycleEvent;

    @NotNull
    private final TypeElement type;

    public EventMethod(@NotNull ExecutableElement method, @NotNull OnLifecycleEvent onLifecycleEvent, @NotNull TypeElement type) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(onLifecycleEvent, "onLifecycleEvent");
        Intrinsics.checkNotNullParameter(type, "type");
        this.method = method;
        this.onLifecycleEvent = onLifecycleEvent;
        this.type = type;
    }

    public static /* synthetic */ EventMethod copy$default(EventMethod eventMethod, ExecutableElement executableElement, OnLifecycleEvent onLifecycleEvent, TypeElement typeElement, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            executableElement = eventMethod.method;
        }
        if ((i10 & 2) != 0) {
            onLifecycleEvent = eventMethod.onLifecycleEvent;
        }
        if ((i10 & 4) != 0) {
            typeElement = eventMethod.type;
        }
        return eventMethod.copy(executableElement, onLifecycleEvent, typeElement);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final ExecutableElement getMethod() {
        return this.method;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final OnLifecycleEvent getOnLifecycleEvent() {
        return this.onLifecycleEvent;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final TypeElement getType() {
        return this.type;
    }

    @NotNull
    public final EventMethod copy(@NotNull ExecutableElement method, @NotNull OnLifecycleEvent onLifecycleEvent, @NotNull TypeElement type) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(onLifecycleEvent, "onLifecycleEvent");
        Intrinsics.checkNotNullParameter(type, "type");
        return new EventMethod(method, onLifecycleEvent, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventMethod)) {
            return false;
        }
        EventMethod eventMethod = (EventMethod) other;
        return Intrinsics.areEqual(this.method, eventMethod.method) && Intrinsics.areEqual(this.onLifecycleEvent, eventMethod.onLifecycleEvent) && Intrinsics.areEqual(this.type, eventMethod.type);
    }

    @NotNull
    public final ExecutableElement getMethod() {
        return this.method;
    }

    @NotNull
    public final OnLifecycleEvent getOnLifecycleEvent() {
        return this.onLifecycleEvent;
    }

    @NotNull
    public final TypeElement getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.method.hashCode() * 31) + this.onLifecycleEvent.hashCode()) * 31) + this.type.hashCode();
    }

    @NotNull
    public final String packageName() {
        return Elements_extKt.getPackageQName(this.type);
    }

    @NotNull
    public String toString() {
        return "EventMethod(method=" + this.method + ", onLifecycleEvent=" + this.onLifecycleEvent + ", type=" + this.type + ")";
    }
}

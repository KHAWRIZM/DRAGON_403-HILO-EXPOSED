package androidx.lifecycle.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/model/EventMethodCall;", "", FirebaseAnalytics.Param.METHOD, "Landroidx/lifecycle/model/EventMethod;", "syntheticAccess", "Ljavax/lang/model/element/TypeElement;", "<init>", "(Landroidx/lifecycle/model/EventMethod;Ljavax/lang/model/element/TypeElement;)V", "getMethod", "()Landroidx/lifecycle/model/EventMethod;", "getSyntheticAccess", "()Ljavax/lang/model/element/TypeElement;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lifecycle-compiler"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final /* data */ class EventMethodCall {

    @NotNull
    private final EventMethod method;

    @Nullable
    private final TypeElement syntheticAccess;

    public EventMethodCall(@NotNull EventMethod method, @Nullable TypeElement typeElement) {
        Intrinsics.checkNotNullParameter(method, "method");
        this.method = method;
        this.syntheticAccess = typeElement;
    }

    public static /* synthetic */ EventMethodCall copy$default(EventMethodCall eventMethodCall, EventMethod eventMethod, TypeElement typeElement, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            eventMethod = eventMethodCall.method;
        }
        if ((i10 & 2) != 0) {
            typeElement = eventMethodCall.syntheticAccess;
        }
        return eventMethodCall.copy(eventMethod, typeElement);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final EventMethod getMethod() {
        return this.method;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final TypeElement getSyntheticAccess() {
        return this.syntheticAccess;
    }

    @NotNull
    public final EventMethodCall copy(@NotNull EventMethod method, @Nullable TypeElement syntheticAccess) {
        Intrinsics.checkNotNullParameter(method, "method");
        return new EventMethodCall(method, syntheticAccess);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventMethodCall)) {
            return false;
        }
        EventMethodCall eventMethodCall = (EventMethodCall) other;
        return Intrinsics.areEqual(this.method, eventMethodCall.method) && Intrinsics.areEqual(this.syntheticAccess, eventMethodCall.syntheticAccess);
    }

    @NotNull
    public final EventMethod getMethod() {
        return this.method;
    }

    @Nullable
    public final TypeElement getSyntheticAccess() {
        return this.syntheticAccess;
    }

    public int hashCode() {
        int hashCode = this.method.hashCode() * 31;
        TypeElement typeElement = this.syntheticAccess;
        return hashCode + (typeElement == null ? 0 : typeElement.hashCode());
    }

    @NotNull
    public String toString() {
        return "EventMethodCall(method=" + this.method + ", syntheticAccess=" + this.syntheticAccess + ")";
    }

    public /* synthetic */ EventMethodCall(EventMethod eventMethod, TypeElement typeElement, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventMethod, (i10 & 2) != 0 ? null : typeElement);
    }
}

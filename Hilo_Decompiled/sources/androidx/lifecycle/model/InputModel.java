package androidx.lifecycle.model;

import androidx.lifecycle.Elements_extKt;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u001b\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006 "}, d2 = {"Landroidx/lifecycle/model/InputModel;", "", "rootTypes", "", "Ljavax/lang/model/element/TypeElement;", "observersInfo", "", "Landroidx/lifecycle/model/LifecycleObserverInfo;", "generatedAdapters", "", "Ljavax/lang/model/element/ExecutableElement;", "<init>", "(Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)V", "getObserversInfo", "()Ljava/util/Map;", "getGeneratedAdapters", "isRootType", "", "type", "hasSyntheticAccessorFor", "eventMethod", "Landroidx/lifecycle/model/EventMethod;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "lifecycle-compiler"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nInputModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InputModel.kt\nandroidx/lifecycle/model/InputModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,45:1\n1755#2,3:46\n*S KotlinDebug\n*F\n+ 1 InputModel.kt\nandroidx/lifecycle/model/InputModel\n*L\n38#1:46,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final /* data */ class InputModel {

    @NotNull
    private final Map<TypeElement, List<ExecutableElement>> generatedAdapters;

    @NotNull
    private final Map<TypeElement, LifecycleObserverInfo> observersInfo;

    @NotNull
    private final Set<TypeElement> rootTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public InputModel(@NotNull Set<? extends TypeElement> rootTypes, @NotNull Map<TypeElement, LifecycleObserverInfo> observersInfo, @NotNull Map<TypeElement, ? extends List<? extends ExecutableElement>> generatedAdapters) {
        Intrinsics.checkNotNullParameter(rootTypes, "rootTypes");
        Intrinsics.checkNotNullParameter(observersInfo, "observersInfo");
        Intrinsics.checkNotNullParameter(generatedAdapters, "generatedAdapters");
        this.rootTypes = rootTypes;
        this.observersInfo = observersInfo;
        this.generatedAdapters = generatedAdapters;
    }

    private final Set<TypeElement> component1() {
        return this.rootTypes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InputModel copy$default(InputModel inputModel, Set set, Map map, Map map2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            set = inputModel.rootTypes;
        }
        if ((i10 & 2) != 0) {
            map = inputModel.observersInfo;
        }
        if ((i10 & 4) != 0) {
            map2 = inputModel.generatedAdapters;
        }
        return inputModel.copy(set, map, map2);
    }

    @NotNull
    public final Map<TypeElement, LifecycleObserverInfo> component2() {
        return this.observersInfo;
    }

    @NotNull
    public final Map<TypeElement, List<ExecutableElement>> component3() {
        return this.generatedAdapters;
    }

    @NotNull
    public final InputModel copy(@NotNull Set<? extends TypeElement> rootTypes, @NotNull Map<TypeElement, LifecycleObserverInfo> observersInfo, @NotNull Map<TypeElement, ? extends List<? extends ExecutableElement>> generatedAdapters) {
        Intrinsics.checkNotNullParameter(rootTypes, "rootTypes");
        Intrinsics.checkNotNullParameter(observersInfo, "observersInfo");
        Intrinsics.checkNotNullParameter(generatedAdapters, "generatedAdapters");
        return new InputModel(rootTypes, observersInfo, generatedAdapters);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputModel)) {
            return false;
        }
        InputModel inputModel = (InputModel) other;
        return Intrinsics.areEqual(this.rootTypes, inputModel.rootTypes) && Intrinsics.areEqual(this.observersInfo, inputModel.observersInfo) && Intrinsics.areEqual(this.generatedAdapters, inputModel.generatedAdapters);
    }

    @NotNull
    public final Map<TypeElement, List<ExecutableElement>> getGeneratedAdapters() {
        return this.generatedAdapters;
    }

    @NotNull
    public final Map<TypeElement, LifecycleObserverInfo> getObserversInfo() {
        return this.observersInfo;
    }

    public final boolean hasSyntheticAccessorFor(@NotNull EventMethod eventMethod) {
        Intrinsics.checkNotNullParameter(eventMethod, "eventMethod");
        List<ExecutableElement> list = this.generatedAdapters.get(eventMethod.getType());
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (ExecutableElement executableElement : list) {
            if (Intrinsics.areEqual(Elements_extKt.name(executableElement), Elements_extKt.syntheticName(eventMethod.getMethod())) && eventMethod.getMethod().getParameters().size() + 1 == executableElement.getParameters().size()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.rootTypes.hashCode() * 31) + this.observersInfo.hashCode()) * 31) + this.generatedAdapters.hashCode();
    }

    public final boolean isRootType(@NotNull TypeElement type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.rootTypes.contains(type);
    }

    @NotNull
    public String toString() {
        return "InputModel(rootTypes=" + this.rootTypes + ", observersInfo=" + this.observersInfo + ", generatedAdapters=" + this.generatedAdapters + ")";
    }
}

package androidx.lifecycle;

import androidx.lifecycle.model.AdapterClassKt;
import androidx.lifecycle.model.EventMethod;
import androidx.lifecycle.model.LifecycleObserverInfo;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u0018J\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u001d\u001a\u00020\u0018J \u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010\"\u001a\u00020\u00182\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Landroidx/lifecycle/ObserversCollector;", "", "processingEnv", "Ljavax/annotation/processing/ProcessingEnvironment;", "<init>", "(Ljavax/annotation/processing/ProcessingEnvironment;)V", "typeUtils", "Ljavax/lang/model/util/Types;", "getTypeUtils", "()Ljavax/lang/model/util/Types;", "elementUtils", "Ljavax/lang/model/util/Elements;", "getElementUtils", "()Ljavax/lang/model/util/Elements;", "lifecycleObserverTypeMirror", "Ljavax/lang/model/type/TypeMirror;", "getLifecycleObserverTypeMirror", "()Ljavax/lang/model/type/TypeMirror;", "validator", "Landroidx/lifecycle/Validator;", "getValidator", "()Landroidx/lifecycle/Validator;", "observers", "", "Ljavax/lang/model/element/TypeElement;", "Landroidx/lifecycle/model/LifecycleObserverInfo;", "getObservers", "()Ljava/util/Map;", "collect", "type", "generatedAdapterInfoFor", "", "Ljavax/lang/model/element/ExecutableElement;", "createObserverInfo", "typeElement", "parents", "lifecycle-compiler"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\ninput_collector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 input_collector.kt\nandroidx/lifecycle/ObserversCollector\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,193:1\n774#2:194\n865#2,2:195\n827#2:197\n855#2,2:198\n1557#2:200\n1628#2,3:201\n774#2:204\n865#2,2:205\n774#2:207\n865#2,2:208\n1557#2:210\n1628#2,3:211\n*S KotlinDebug\n*F\n+ 1 input_collector.kt\nandroidx/lifecycle/ObserversCollector\n*L\n86#1:194\n86#1:195,2\n87#1:197\n87#1:198,2\n88#1:200\n88#1:201,3\n100#1:204\n100#1:205,2\n114#1:207\n114#1:208,2\n117#1:210\n117#1:211,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class ObserversCollector {

    @NotNull
    private final Elements elementUtils;

    @NotNull
    private final TypeMirror lifecycleObserverTypeMirror;

    @NotNull
    private final Map<TypeElement, LifecycleObserverInfo> observers;

    @NotNull
    private final Types typeUtils;

    @NotNull
    private final Validator validator;

    public ObserversCollector(@NotNull ProcessingEnvironment processingEnv) {
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        Types typeUtils = processingEnv.getTypeUtils();
        Intrinsics.checkNotNullExpressionValue(typeUtils, "getTypeUtils(...)");
        this.typeUtils = typeUtils;
        Elements elementUtils = processingEnv.getElementUtils();
        Intrinsics.checkNotNullExpressionValue(elementUtils, "getElementUtils(...)");
        this.elementUtils = elementUtils;
        TypeMirror asType = elementUtils.getTypeElement(LifecycleObserver.class.getCanonicalName()).asType();
        Intrinsics.checkNotNullExpressionValue(asType, "asType(...)");
        this.lifecycleObserverTypeMirror = asType;
        this.validator = new Validator(processingEnv);
        this.observers = new LinkedHashMap();
    }

    private final LifecycleObserverInfo createObserverInfo(TypeElement typeElement, List<LifecycleObserverInfo> parents) {
        EventMethod eventMethod;
        if (!this.validator.validateClass((Element) typeElement)) {
            return null;
        }
        List<ExecutableElement> methods = Elements_extKt.methods(typeElement);
        ArrayList<ExecutableElement> arrayList = new ArrayList();
        for (Object obj : methods) {
            if (j8.a.e((ExecutableElement) obj, OnLifecycleEvent.class)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (ExecutableElement executableElement : arrayList) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) executableElement.getAnnotation(OnLifecycleEvent.class);
            if (this.validator.validateMethod(executableElement, onLifecycleEvent.value())) {
                Intrinsics.checkNotNull(onLifecycleEvent);
                eventMethod = new EventMethod(executableElement, onLifecycleEvent, typeElement);
            } else {
                eventMethod = null;
            }
            arrayList2.add(eventMethod);
        }
        return new LifecycleObserverInfo(typeElement, CollectionsKt.filterNotNull(arrayList2), parents);
    }

    @Nullable
    public final LifecycleObserverInfo collect(@NotNull TypeElement type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.observers.containsKey(type)) {
            return this.observers.get(type);
        }
        List listOf = CollectionsKt.listOf(type.getSuperclass());
        List interfaces = type.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
        List plus = CollectionsKt.plus((Collection) listOf, (Iterable) interfaces);
        ArrayList arrayList = new ArrayList();
        for (Object obj : plus) {
            if (this.typeUtils.isAssignable((TypeMirror) obj, this.lifecycleObserverTypeMirror)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!this.typeUtils.isSameType((TypeMirror) obj2, this.lifecycleObserverTypeMirror)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            TypeElement b10 = j8.b.b((TypeMirror) it.next());
            Intrinsics.checkNotNullExpressionValue(b10, "asTypeElement(...)");
            arrayList3.add(collect(b10));
        }
        LifecycleObserverInfo createObserverInfo = createObserverInfo(type, CollectionsKt.filterNotNull(arrayList3));
        if (createObserverInfo != null) {
            this.observers.put(type, createObserverInfo);
        }
        return createObserverInfo;
    }

    @Nullable
    public final List<ExecutableElement> generatedAdapterInfoFor(@NotNull TypeElement type) {
        String str;
        List<ExecutableElement> methods;
        Intrinsics.checkNotNullParameter(type, "type");
        Element element = (Element) type;
        if (Elements_extKt.getPackageQName(element).length() == 0) {
            str = "";
        } else {
            str = Elements_extKt.getPackageQName(element) + InstructionFileId.DOT;
        }
        TypeElement typeElement = this.elementUtils.getTypeElement(str + AdapterClassKt.getAdapterName(type));
        if (typeElement != null && (methods = Elements_extKt.methods(typeElement)) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : methods) {
                if (Elements_extKt.isSyntheticMethod((ExecutableElement) obj)) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return null;
    }

    @NotNull
    public final Elements getElementUtils() {
        return this.elementUtils;
    }

    @NotNull
    public final TypeMirror getLifecycleObserverTypeMirror() {
        return this.lifecycleObserverTypeMirror;
    }

    @NotNull
    public final Map<TypeElement, LifecycleObserverInfo> getObservers() {
        return this.observers;
    }

    @NotNull
    public final Types getTypeUtils() {
        return this.typeUtils;
    }

    @NotNull
    public final Validator getValidator() {
        return this.validator;
    }
}

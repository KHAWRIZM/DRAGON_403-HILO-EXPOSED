package androidx.lifecycle;

import androidx.lifecycle.model.InputModel;
import androidx.lifecycle.model.LifecycleObserverInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"collectAndVerifyInput", "Landroidx/lifecycle/model/InputModel;", "processingEnv", "Ljavax/annotation/processing/ProcessingEnvironment;", "roundEnv", "Ljavax/annotation/processing/RoundEnvironment;", "lifecycle-compiler"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\ninput_collector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 input_collector.kt\nandroidx/lifecycle/Input_collectorKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,193:1\n1557#2:194\n1628#2,3:195\n1863#2,2:198\n1611#2,9:200\n1863#2:209\n1864#2:212\n1620#2:213\n1#3:210\n1#3:211\n*S KotlinDebug\n*F\n+ 1 input_collector.kt\nandroidx/lifecycle/Input_collectorKt\n*L\n48#1:194\n48#1:195,3\n63#1:198,2\n67#1:200,9\n67#1:209\n67#1:212\n67#1:213\n67#1:211\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class Input_collectorKt {
    @NotNull
    public static final InputModel collectAndVerifyInput(@NotNull ProcessingEnvironment processingEnv, @NotNull RoundEnvironment roundEnv) {
        Pair pair;
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        Intrinsics.checkNotNullParameter(roundEnv, "roundEnv");
        Validator validator = new Validator(processingEnv);
        ObserversCollector observersCollector = new ObserversCollector(processingEnv);
        Set elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(OnLifecycleEvent.class);
        Intrinsics.checkNotNullExpressionValue(elementsAnnotatedWith, "getElementsAnnotatedWith(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(elementsAnnotatedWith, 10));
        Iterator it = elementsAnnotatedWith.iterator();
        while (true) {
            TypeElement typeElement = null;
            if (!it.hasNext()) {
                break;
            }
            Element element = (Element) it.next();
            if (element.getKind() != ElementKind.METHOD) {
                Intrinsics.checkNotNull(element);
                validator.printErrorMessage(ErrorMessages.INVALID_ANNOTATED_ELEMENT, element);
            } else {
                Element enclosingElement = element.getEnclosingElement();
                Intrinsics.checkNotNull(enclosingElement);
                if (validator.validateClass(enclosingElement)) {
                    typeElement = j8.a.a(enclosingElement);
                }
            }
            arrayList.add(typeElement);
        }
        Set set = CollectionsKt.toSet(CollectionsKt.filterNotNull(arrayList));
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            observersCollector.collect((TypeElement) it2.next());
        }
        Map<TypeElement, LifecycleObserverInfo> observers = observersCollector.getObservers();
        Set<TypeElement> keySet = observersCollector.getObservers().keySet();
        ArrayList arrayList2 = new ArrayList();
        for (TypeElement typeElement2 : keySet) {
            List<ExecutableElement> generatedAdapterInfoFor = observersCollector.generatedAdapterInfoFor(typeElement2);
            if (generatedAdapterInfoFor != null) {
                pair = TuplesKt.to(typeElement2, generatedAdapterInfoFor);
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        return new InputModel(set, observers, MapsKt.toMap(arrayList2));
    }
}

package androidx.lifecycle;

import androidx.lifecycle.model.AdapterClass;
import androidx.lifecycle.model.EventMethod;
import androidx.lifecycle.model.EventMethodCall;
import androidx.lifecycle.model.InputModel;
import androidx.lifecycle.model.LifecycleObserverInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\f\u001a\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0002\u001a(\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0002\u001a\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0011¨\u0006\u0014"}, d2 = {"mergeAndVerifyMethods", "", "Landroidx/lifecycle/model/EventMethod;", "processingEnv", "Ljavax/annotation/processing/ProcessingEnvironment;", "type", "Ljavax/lang/model/element/TypeElement;", "classMethods", "parentMethods", "flattenObservers", "Landroidx/lifecycle/model/LifecycleObserverInfo;", "world", "", "needsSyntheticAccess", "", "eventMethod", "validateMethod", "Landroidx/lifecycle/model/InputModel;", "transformToOutput", "Landroidx/lifecycle/model/AdapterClass;", "lifecycle-compiler"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\ntransformation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 transformation.kt\nandroidx/lifecycle/TransformationKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,165:1\n1557#2:166\n1628#2,3:167\n827#2:170\n855#2,2:171\n1863#2,2:173\n774#2:175\n865#2,2:176\n774#2:178\n865#2:179\n1734#2,3:180\n866#2:183\n1557#2:184\n1628#2,2:185\n1557#2:187\n1628#2,3:188\n774#2:191\n865#2,2:192\n1863#2,2:194\n1630#2:196\n1557#2:200\n1628#2,3:201\n1863#2,2:205\n1557#2:207\n1628#2,3:208\n1797#2,3:211\n126#3:197\n153#3,2:198\n155#3:204\n*S KotlinDebug\n*F\n+ 1 transformation.kt\nandroidx/lifecycle/TransformationKt\n*L\n39#1:166\n39#1:167,3\n57#1:170\n57#1:171,2\n89#1:173,2\n134#1:175\n134#1:176,2\n136#1:178\n136#1:179\n137#1:180,3\n136#1:183\n141#1:184\n141#1:185,2\n143#1:187\n143#1:188,3\n151#1:191\n151#1:192,2\n152#1:194,2\n141#1:196\n161#1:200\n161#1:201,3\n74#1:205,2\n76#1:207\n76#1:208,3\n76#1:211,3\n159#1:197\n159#1:198,2\n159#1:204\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class TransformationKt {
    @NotNull
    public static final List<LifecycleObserverInfo> flattenObservers(@NotNull ProcessingEnvironment processingEnv, @NotNull Map<TypeElement, LifecycleObserverInfo> world) {
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        Intrinsics.checkNotNullParameter(world, "world");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = world.values().iterator();
        while (it.hasNext()) {
            flattenObservers$traverse(linkedHashMap, processingEnv, (LifecycleObserverInfo) it.next());
        }
        return CollectionsKt.toList(linkedHashMap.values());
    }

    private static final void flattenObservers$traverse(Map<LifecycleObserverInfo, LifecycleObserverInfo> map, ProcessingEnvironment processingEnvironment, LifecycleObserverInfo lifecycleObserverInfo) {
        if (map.containsKey(lifecycleObserverInfo)) {
            return;
        }
        if (lifecycleObserverInfo.getParents().isEmpty()) {
            map.put(lifecycleObserverInfo, lifecycleObserverInfo);
            return;
        }
        Iterator<T> it = lifecycleObserverInfo.getParents().iterator();
        while (it.hasNext()) {
            flattenObservers$traverse(map, processingEnvironment, (LifecycleObserverInfo) it.next());
        }
        List<LifecycleObserverInfo> parents = lifecycleObserverInfo.getParents();
        ArrayList<LifecycleObserverInfo> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parents, 10));
        Iterator<T> it2 = parents.iterator();
        while (it2.hasNext()) {
            arrayList.add(map.get((LifecycleObserverInfo) it2.next()));
        }
        List<EventMethod> emptyList = CollectionsKt.emptyList();
        for (LifecycleObserverInfo lifecycleObserverInfo2 : arrayList) {
            TypeElement type = lifecycleObserverInfo.getType();
            Intrinsics.checkNotNull(lifecycleObserverInfo2);
            emptyList = mergeAndVerifyMethods(processingEnvironment, type, lifecycleObserverInfo2.getMethods(), emptyList);
        }
        map.put(lifecycleObserverInfo, new LifecycleObserverInfo(lifecycleObserverInfo.getType(), mergeAndVerifyMethods(processingEnvironment, lifecycleObserverInfo.getType(), lifecycleObserverInfo.getMethods(), emptyList), null, 4, null));
    }

    private static final List<EventMethod> mergeAndVerifyMethods(ProcessingEnvironment processingEnvironment, TypeElement typeElement, List<EventMethod> list, List<EventMethod> list2) {
        Object obj;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (EventMethod eventMethod : list2) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (processingEnvironment.getElementUtils().overrides(((EventMethod) obj).getMethod(), eventMethod.getMethod(), typeElement)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            EventMethod eventMethod2 = (EventMethod) obj;
            if (eventMethod2 != null) {
                if (!Intrinsics.areEqual(eventMethod2.getOnLifecycleEvent(), eventMethod.getOnLifecycleEvent())) {
                    processingEnvironment.getMessager().printMessage(Diagnostic.Kind.ERROR, ErrorMessages.INVALID_STATE_OVERRIDE_METHOD, eventMethod2.getMethod());
                }
                eventMethod = eventMethod2;
            }
            arrayList.add(eventMethod);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (!arrayList.contains((EventMethod) obj2)) {
                arrayList2.add(obj2);
            }
        }
        return CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2);
    }

    private static final boolean needsSyntheticAccess(TypeElement typeElement, EventMethod eventMethod) {
        ExecutableElement method = eventMethod.getMethod();
        if (!Intrinsics.areEqual(Elements_extKt.getPackageQName((Element) typeElement), eventMethod.packageName()) && (Elements_extKt.isPackagePrivate(method) || Elements_extKt.isProtected(method))) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final List<AdapterClass> transformToOutput(@NotNull ProcessingEnvironment processingEnv, @NotNull InputModel world) {
        EventMethodCall eventMethodCall;
        Intrinsics.checkNotNullParameter(processingEnv, "processingEnv");
        Intrinsics.checkNotNullParameter(world, "world");
        List<LifecycleObserverInfo> flattenObservers = flattenObservers(processingEnv, world.getObserversInfo());
        com.google.common.collect.n u10 = com.google.common.collect.n.u();
        ArrayList arrayList = new ArrayList();
        for (Object obj : flattenObservers) {
            if (world.isRootType(((LifecycleObserverInfo) obj).getType())) {
                arrayList.add(obj);
            }
        }
        ArrayList<LifecycleObserverInfo> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            LifecycleObserverInfo lifecycleObserverInfo = (LifecycleObserverInfo) obj2;
            TypeElement type = lifecycleObserverInfo.getType();
            List<EventMethod> component2 = lifecycleObserverInfo.component2();
            if (!(component2 instanceof Collection) || !component2.isEmpty()) {
                Iterator<T> it = component2.iterator();
                while (it.hasNext()) {
                    if (!validateMethod(processingEnv, world, type, (EventMethod) it.next())) {
                        break;
                    }
                }
            }
            arrayList2.add(obj2);
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (LifecycleObserverInfo lifecycleObserverInfo2 : arrayList2) {
            TypeElement type2 = lifecycleObserverInfo2.getType();
            List<EventMethod> component22 = lifecycleObserverInfo2.component2();
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(component22, 10));
            for (EventMethod eventMethod : component22) {
                if (needsSyntheticAccess(type2, eventMethod)) {
                    eventMethodCall = new EventMethodCall(eventMethod, eventMethod.getType());
                } else {
                    eventMethodCall = new EventMethodCall(eventMethod, null, 2, null);
                }
                arrayList4.add(eventMethodCall);
            }
            ArrayList<EventMethodCall> arrayList5 = new ArrayList();
            for (Object obj3 : arrayList4) {
                if (((EventMethodCall) obj3).getSyntheticAccess() != null) {
                    arrayList5.add(obj3);
                }
            }
            for (EventMethodCall eventMethodCall2 : arrayList5) {
                u10.p(eventMethodCall2.getMethod().getType(), eventMethodCall2);
            }
            arrayList3.add(TuplesKt.to(type2, arrayList4));
        }
        Map map = MapsKt.toMap(arrayList3);
        ArrayList arrayList6 = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            TypeElement typeElement = (TypeElement) entry.getKey();
            List list = (List) entry.getValue();
            Set<EventMethodCall> set = u10.get(typeElement);
            if (set == null) {
                set = SetsKt.emptySet();
            }
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            for (EventMethodCall eventMethodCall3 : set) {
                Intrinsics.checkNotNull(eventMethodCall3);
                arrayList7.add(eventMethodCall3.getMethod().getMethod());
            }
            arrayList6.add(new AdapterClass(typeElement, list, CollectionsKt.toSet(arrayList7)));
        }
        return arrayList6;
    }

    private static final boolean validateMethod(ProcessingEnvironment processingEnvironment, InputModel inputModel, TypeElement typeElement, EventMethod eventMethod) {
        if (!needsSyntheticAccess(typeElement, eventMethod) || inputModel.isRootType(eventMethod.getType()) || inputModel.hasSyntheticAccessorFor(eventMethod)) {
            return true;
        }
        processingEnvironment.getMessager().printMessage(Diagnostic.Kind.WARNING, ErrorMessages.INSTANCE.failedToGenerateAdapter(typeElement, eventMethod), (Element) typeElement);
        return false;
    }
}

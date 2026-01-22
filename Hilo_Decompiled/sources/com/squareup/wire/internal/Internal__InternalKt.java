package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import com.therouter.inject.DebugOnlyKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u0016\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\u000b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f\u001a\u0016\u0010\f\u001a\u00020\r2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0011\u001a,\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u000fH\u0007\u001a>\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u0018\u0018\u00010\u0011H\u0007\u001a \u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u00142\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\u001a2\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u001a$\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u001aK\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040 \"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010!\u001a\u001a\u0010\"\u001a\u00020#2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u001a(\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\u001a:\u0010$\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a:\u0010%\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u00182\u0006\u0010\u0015\u001a\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\u001a!\u0010&\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010'\u001a\u0002H\u0014¢\u0006\u0002\u0010(\u001a'\u0010)\u001a\u00060*j\u0002`+2\u0016\u0010,\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040 \"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010-\u001a\u0012\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\u0004\b\u0000\u0010\u0014\u001a\u001e\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018\u001a\u000e\u00100\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u0001\u001a\u0014\u00100\u001a\u00020\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f\u001a1\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000f\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u0002H\u00140\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u0002H\u001404H\u0007¢\u0006\u0002\b5\u001aC\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0011\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u00112\f\u00103\u001a\b\u0012\u0004\u0012\u0002H\u001804H\u0007¢\u0006\u0002\b5\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\" \u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u00066"}, d2 = {"ESCAPED_CHARS", "", "typeName", "Lkotlin/reflect/KClass;", "", "getTypeName$Internal__InternalKt", "(Ljava/lang/Object;)Lkotlin/reflect/KClass;", "boxedOneOfClassName", "oneOfName", "boxedOneOfKeyFieldName", "fieldName", "boxedOneOfKeysFieldName", "checkElementsNotNull", "", "list", "", "map", "", "copyOf", "", "T", "name", "", "K", "V", "countNonNull", "", DebugOnlyKt.PACKAGE, "b", "c", "d", "rest", "", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)I", "equals", "", "immutableCopyOf", "immutableCopyOfMapWithStructValues", "immutableCopyOfStruct", "value", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "missingRequiredFields", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "args", "([Ljava/lang/Object;)Ljava/lang/IllegalStateException;", "newMutableList", "newMutableMap", "sanitize", "values", "redactElements", "adapter", "Lcom/squareup/wire/ProtoAdapter;", "-redactElements", "wire-runtime"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "com/squareup/wire/internal/Internal")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class Internal__InternalKt {

    @NotNull
    private static final String ESCAPED_CHARS = ",[]{}\\";

    @JvmName(name = "-redactElements")
    @NotNull
    /* renamed from: -redactElements, reason: not valid java name */
    public static final <T> List<T> m١١٩redactElements(@NotNull List<? extends T> list, @NotNull ProtoAdapter<T> protoAdapter) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(protoAdapter.redact(it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final String boxedOneOfClassName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "oneOfName");
        return StringsKt.capitalize(str);
    }

    @NotNull
    public static final String boxedOneOfKeyFieldName(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "oneOfName");
        Intrinsics.checkNotNullParameter(str2, "fieldName");
        String upperCase = (str + '_' + str2).toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    @NotNull
    public static final String boxedOneOfKeysFieldName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "oneOfName");
        String upperCase = Intrinsics.stringPlus(str, "_keys").toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    public static final void checkElementsNotNull(@NotNull List<?> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            if (list.get(i) == null) {
                throw new NullPointerException("Element at index " + i + " is null");
            }
            i = i2;
        }
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(list)", imports = {}))
    @NotNull
    public static final <T> List<T> copyOf(@NotNull String str, @Nullable List<? extends T> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNull(list);
        return Internal.copyOf(list);
    }

    public static final int countNonNull(@Nullable Object obj, @Nullable Object obj2) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0);
    }

    public static final boolean equals(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2 && (obj == null || !Intrinsics.areEqual(obj, obj2))) {
            return false;
        }
        return true;
    }

    private static final KClass<? extends Object> getTypeName$Internal__InternalKt(Object obj) {
        return Reflection.getOrCreateKotlinClass(obj.getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> immutableCopyOf(@NotNull String str, @NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "list");
        boolean z = list instanceof MutableOnWriteList;
        List<T> list2 = list;
        if (z) {
            list2 = ((MutableOnWriteList) list).getMutableList$wire_runtime();
        }
        if (list2 == CollectionsKt.emptyList() || (list2 instanceof ImmutableList)) {
            return list2;
        }
        AbstractCollection abstractCollection = (List<T>) new ImmutableList(list2);
        if (abstractCollection.contains((Object) null)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".contains(null)").toString());
        }
        return abstractCollection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> immutableCopyOfMapWithStructValues(@NotNull String str, @NotNull Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key != null) {
                linkedHashMap.put(key, Internal.immutableCopyOfStruct(str, value));
            } else {
                throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".containsKey(null)").toString());
            }
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(this)");
        return unmodifiableMap;
    }

    public static final <T> T immutableCopyOfStruct(@NotNull String str, T t) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (t != null && !(t instanceof Boolean) && !(t instanceof Double) && !(t instanceof String)) {
            if (t instanceof List) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) t).iterator();
                while (it.hasNext()) {
                    arrayList.add(Internal.immutableCopyOfStruct(str, it.next()));
                }
                T t2 = (T) Collections.unmodifiableList(arrayList);
                Intrinsics.checkNotNullExpressionValue(t2, "unmodifiableList(this)");
                return t2;
            }
            if (t instanceof Map) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : ((Map) t).entrySet()) {
                    linkedHashMap.put(Internal.immutableCopyOfStruct(str, entry.getKey()), Internal.immutableCopyOfStruct(str, entry.getValue()));
                }
                T t3 = (T) Collections.unmodifiableMap(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(t3, "unmodifiableMap(this)");
                return t3;
            }
            throw new IllegalArgumentException("struct value " + str + " must be a JSON type (null, Boolean, Double, String, List, or Map) but was " + getTypeName$Internal__InternalKt(t) + ": " + t);
        }
        return t;
    }

    @NotNull
    public static final IllegalStateException missingRequiredFields(@NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "args");
        StringBuilder sb2 = new StringBuilder();
        IntProgression step = RangesKt.step(RangesKt.until(0, objArr.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        String str = "";
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                int i = first + step2;
                if (objArr[first] == null) {
                    if (sb2.length() > 0) {
                        str = "s";
                    }
                    sb2.append("\n  ");
                    sb2.append(objArr[first + 1]);
                }
                if (first == last) {
                    break;
                }
                first = i;
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        throw new IllegalStateException("Required field" + str + " not set:" + sb3);
    }

    @NotNull
    public static final <T> List<T> newMutableList() {
        return (List<T>) new MutableOnWriteList(CollectionsKt.emptyList());
    }

    @NotNull
    public static final <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    @NotNull
    public static final String sanitize(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        StringBuilder sb2 = new StringBuilder(str.length());
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            i++;
            if (StringsKt.contains$default(ESCAPED_CHARS, charAt, false, 2, (Object) null)) {
                sb2.append('\\');
            }
            sb2.append(charAt);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public static final <T> List<T> copyOf(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (list != CollectionsKt.emptyList() && !(list instanceof ImmutableList)) {
            return new ArrayList(list);
        }
        return (List<T>) new MutableOnWriteList(list);
    }

    public static final int countNonNull(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0) + (obj3 != null ? 1 : 0);
    }

    public static final int countNonNull(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "rest");
        int i = 0;
        int i2 = obj != null ? 1 : 0;
        if (obj2 != null) {
            i2++;
        }
        if (obj3 != null) {
            i2++;
        }
        if (obj4 != null) {
            i2++;
        }
        int length = objArr.length;
        while (i < length) {
            Object obj5 = objArr[i];
            i++;
            if (obj5 != null) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmName(name = "-redactElements")
    @NotNull
    /* renamed from: -redactElements, reason: not valid java name */
    public static final <K, V> Map<K, V> m١٢٠redactElements(@NotNull Map<K, ? extends V> map, @NotNull ProtoAdapter<V> protoAdapter) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(protoAdapter, "adapter");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), protoAdapter.redact(entry.getValue()));
        }
        return linkedHashMap;
    }

    public static final void checkElementsNotNull(@NotNull Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                throw new NullPointerException("map.containsKey(null)");
            }
            if (value == null) {
                throw new NullPointerException("Value for key " + key + " is null");
            }
        }
    }

    @Deprecated(message = "Please regenerate code using wire-compiler version 3.0.0 or higher.", replaceWith = @ReplaceWith(expression = "com.squareup.internal.Internal.copyOf(map)", imports = {}))
    @NotNull
    public static final <K, V> Map<K, V> copyOf(@NotNull String str, @Nullable Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNull(map);
        return Internal.copyOf(map);
    }

    @NotNull
    public static final <K, V> Map<K, V> copyOf(@NotNull Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new LinkedHashMap(map);
    }

    @NotNull
    public static final <K, V> Map<K, V> immutableCopyOf(@NotNull String str, @NotNull Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "map");
        if (map.isEmpty()) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (!linkedHashMap.keySet().contains(null)) {
            if (!linkedHashMap.values().contains(null)) {
                Map<K, V> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
                Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(this)");
                return unmodifiableMap;
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".containsValue(null)").toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus(str, ".containsKey(null)").toString());
    }

    @NotNull
    public static final String sanitize(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "values");
        return CollectionsKt.joinToString$default(list, (CharSequence) null, "[", "]", 0, (CharSequence) null, Internal__InternalKt$sanitize$2.INSTANCE, 25, (Object) null);
    }
}

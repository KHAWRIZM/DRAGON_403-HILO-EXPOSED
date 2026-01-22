package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\u001cB\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\fJ\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a*\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002R(\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/squareup/wire/KotlinConstructorBuilder;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "messageType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "fieldValueMap", "", "", "Lkotlin/Pair;", "Lcom/squareup/wire/WireField;", "", "mapFieldKeyValueMap", "repeatedFieldValueMap", "", "build", "()Lcom/squareup/wire/Message;", "clobberOtherIsOneOfs", "", "field", "get", "set", "value", "declaredProtoFields", "", "Lcom/squareup/wire/KotlinConstructorBuilder$ProtoField;", "ProtoField", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class KotlinConstructorBuilder<M extends Message<M, B>, B extends Message.Builder<M, B>> extends Message.Builder<M, B> {

    @NotNull
    private final Map<Integer, Pair<WireField, Object>> fieldValueMap;

    @NotNull
    private final Map<Integer, Pair<WireField, Map<?, ?>>> mapFieldKeyValueMap;

    @NotNull
    private final Class<M> messageType;

    @NotNull
    private final Map<Integer, Pair<WireField, List<?>>> repeatedFieldValueMap;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/squareup/wire/KotlinConstructorBuilder$ProtoField;", "", "type", "Ljava/lang/Class;", "wireField", "Lcom/squareup/wire/WireField;", "(Ljava/lang/Class;Lcom/squareup/wire/WireField;)V", "getType", "()Ljava/lang/Class;", "getWireField", "()Lcom/squareup/wire/WireField;", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class ProtoField {

        @NotNull
        private final Class<?> type;

        @NotNull
        private final WireField wireField;

        public ProtoField(@NotNull Class<?> cls, @NotNull WireField wireField) {
            Intrinsics.checkNotNullParameter(cls, "type");
            Intrinsics.checkNotNullParameter(wireField, "wireField");
            this.type = cls;
            this.wireField = wireField;
        }

        @NotNull
        public final Class<?> getType() {
            return this.type;
        }

        @NotNull
        public final WireField getWireField() {
            return this.wireField;
        }
    }

    public KotlinConstructorBuilder(@NotNull Class<M> cls) {
        Intrinsics.checkNotNullParameter(cls, "messageType");
        this.messageType = cls;
        int length = cls.getDeclaredFields().length;
        this.fieldValueMap = new LinkedHashMap(length);
        this.repeatedFieldValueMap = new LinkedHashMap(length);
        this.mapFieldKeyValueMap = new LinkedHashMap(length);
    }

    private final void clobberOtherIsOneOfs(WireField field) {
        Collection<Pair<WireField, Object>> values = this.fieldValueMap.values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(values, 10));
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            arrayList.add((WireField) ((Pair) it.next()).getFirst());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            WireField wireField = (WireField) obj;
            if (Intrinsics.areEqual(wireField.oneofName(), field.oneofName()) && wireField.tag() != field.tag()) {
                arrayList2.add(obj);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.fieldValueMap.remove(Integer.valueOf(((WireField) it2.next()).tag()));
        }
    }

    private final List<ProtoField> declaredProtoFields(Class<M> cls) {
        ProtoField protoField;
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
        ArrayList arrayList = new ArrayList();
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "field.declaredAnnotations");
            WireField wireField = (WireField) CollectionsKt.firstOrNull(ArraysKt.filterIsInstance(declaredAnnotations, WireField.class));
            if (wireField == null) {
                protoField = null;
            } else {
                Class<?> type = field.getType();
                Intrinsics.checkNotNullExpressionValue(type, "field.type");
                protoField = new ProtoField(type, wireField);
            }
            if (protoField != null) {
                arrayList.add(protoField);
            }
        }
        return arrayList;
    }

    @Override // com.squareup.wire.Message.Builder
    @NotNull
    public M build() {
        int parameterCount;
        Parameter[] parameters;
        Class type;
        Object obj;
        Class type2;
        boolean isMap;
        List<ProtoField> declaredProtoFields = declaredProtoFields(this.messageType);
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        for (ProtoField protoField : declaredProtoFields) {
            if (!protoField.getWireField().label().isRepeated()) {
                isMap = KotlinConstructorBuilderKt.isMap(protoField.getWireField());
                if (!isMap) {
                    arrayDeque2.add(protoField);
                }
            }
            arrayDeque.add(protoField);
        }
        Constructor<?>[] constructors = this.messageType.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "messageType.constructors");
        int length = constructors.length;
        int i = 0;
        while (i < length) {
            Constructor<?> constructor = constructors[i];
            i++;
            parameterCount = constructor.getParameterCount();
            if (parameterCount == declaredProtoFields.size() + 1) {
                parameters = constructor.getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
                ArrayList arrayList = new ArrayList(parameters.length);
                int length2 = parameters.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length2) {
                    Parameter parameter = parameters[i2];
                    i2++;
                    int i4 = i3 + 1;
                    Parameter a = d.a(parameter);
                    type = a.getType();
                    if (!Intrinsics.areEqual(type, List.class)) {
                        type2 = a.getType();
                        if (!Intrinsics.areEqual(type2, Map.class)) {
                            if (i3 == declaredProtoFields.size()) {
                                obj = buildUnknownFields();
                            } else {
                                obj = get(((ProtoField) arrayDeque2.removeFirst()).getWireField());
                            }
                            arrayList.add(obj);
                            i3 = i4;
                        }
                    }
                    obj = get(((ProtoField) arrayDeque.removeFirst()).getWireField());
                    arrayList.add(obj);
                    i3 = i4;
                }
                Object[] array = arrayList.toArray(new Object[0]);
                if (array != null) {
                    Object newInstance = constructor.newInstance(Arrays.copyOf(array, array.length));
                    if (newInstance != null) {
                        return (M) newInstance;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type M of com.squareup.wire.KotlinConstructorBuilder");
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Nullable
    public final Object get(@NotNull WireField field) {
        boolean isMap;
        Intrinsics.checkNotNullParameter(field, "field");
        isMap = KotlinConstructorBuilderKt.isMap(field);
        Object obj = null;
        if (isMap) {
            Pair<WireField, Map<?, ?>> pair = this.mapFieldKeyValueMap.get(Integer.valueOf(field.tag()));
            if (pair != null) {
                obj = (Map) pair.getSecond();
            }
            if (obj == null) {
                return MapsKt.emptyMap();
            }
            return obj;
        }
        if (field.label().isRepeated()) {
            Pair<WireField, List<?>> pair2 = this.repeatedFieldValueMap.get(Integer.valueOf(field.tag()));
            if (pair2 != null) {
                obj = (List) pair2.getSecond();
            }
            if (obj == null) {
                return CollectionsKt.emptyList();
            }
            return obj;
        }
        Pair<WireField, Object> pair3 = this.fieldValueMap.get(Integer.valueOf(field.tag()));
        if (pair3 == null) {
            return null;
        }
        return pair3.getSecond();
    }

    public final void set(@NotNull WireField field, @Nullable Object value) {
        boolean isMap;
        Intrinsics.checkNotNullParameter(field, "field");
        isMap = KotlinConstructorBuilderKt.isMap(field);
        if (isMap) {
            Map<Integer, Pair<WireField, Map<?, ?>>> map = this.mapFieldKeyValueMap;
            Integer valueOf = Integer.valueOf(field.tag());
            if (value != null) {
                map.put(valueOf, TuplesKt.to(field, TypeIntrinsics.asMutableMap(value)));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
        }
        if (field.label().isRepeated()) {
            Map<Integer, Pair<WireField, List<?>>> map2 = this.repeatedFieldValueMap;
            Integer valueOf2 = Integer.valueOf(field.tag());
            if (value != null) {
                map2.put(valueOf2, TuplesKt.to(field, TypeIntrinsics.asMutableList(value)));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<*>");
        }
        this.fieldValueMap.put(Integer.valueOf(field.tag()), TuplesKt.to(field, value));
        if (value != null && field.label().isOneOf()) {
            clobberOtherIsOneOfs(field);
        }
    }
}

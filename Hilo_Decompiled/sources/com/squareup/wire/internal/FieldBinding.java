package com.squareup.wire.internal;

import com.squareup.wire.KotlinConstructorBuilder;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import com.taobao.accs.common.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 A*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005:\u0001AB;\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0018\u00105\u001a\u0004\u0018\u00010\u00142\u0006\u00106\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u00107J*\u00108\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J0\u00109\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00170\u00162\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0017\u0010:\u001a\u0004\u0018\u00010\u00142\u0006\u0010;\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010<J$\u0010=\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u001f\u0010>\u001a\u00020\u00172\u0006\u0010;\u001a\u00028\u00012\b\u0010?\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010@J\u001d\u0010?\u001a\u00020\u00172\u0006\u0010;\u001a\u00028\u00012\u0006\u0010?\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010@R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0018\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020%X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0014\u0010*\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0018\u0010,\u001a\u0006\u0012\u0002\b\u00030 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\"R\u0014\u0010.\u001a\u00020/X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001aR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001d¨\u0006B"}, d2 = {"Lcom/squareup/wire/internal/FieldBinding;", "M", "Lcom/squareup/wire/Message;", "B", "Lcom/squareup/wire/Message$Builder;", "Lcom/squareup/wire/internal/FieldOrOneOfBinding;", "wireField", "Lcom/squareup/wire/WireField;", "messageType", "Ljava/lang/Class;", "messageField", "Ljava/lang/reflect/Field;", "builderType", "writeIdentityValues", "", "(Lcom/squareup/wire/WireField;Ljava/lang/Class;Ljava/lang/reflect/Field;Ljava/lang/Class;Z)V", "adapterString", "", "builderGetter", "Lkotlin/Function1;", "", "builderSetter", "Lkotlin/Function2;", "", "declaredName", "getDeclaredName", "()Ljava/lang/String;", "instanceGetter", "isMap", "()Z", "isMessage", "keyAdapter", "Lcom/squareup/wire/ProtoAdapter;", "getKeyAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "keyAdapterString", "label", "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "name", "getName", "redacted", "getRedacted", "singleAdapter", "getSingleAdapter", "tag", "", "getTag", "()I", "wireFieldJsonName", "getWireFieldJsonName", "getWriteIdentityValues", "get", Constants.SHARED_MESSAGE_ID_FILE, "(Lcom/squareup/wire/Message;)Ljava/lang/Object;", "getBuilderGetter", "getBuilderSetter", "getFromBuilder", "builder", "(Lcom/squareup/wire/Message$Builder;)Ljava/lang/Object;", "getInstanceGetter", "set", "value", "(Lcom/squareup/wire/Message$Builder;Ljava/lang/Object;)V", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> extends FieldOrOneOfBinding<M, B> {

    @NotNull
    private static final Regex IS_GETTER_FIELD_NAME_REGEX = new Regex("^is[^a-z].*$");

    @NotNull
    private final String adapterString;

    @NotNull
    private final Function1<B, Object> builderGetter;

    @NotNull
    private final Function2<B, Object, Unit> builderSetter;

    @NotNull
    private final String declaredName;

    @NotNull
    private final Function1<M, Object> instanceGetter;

    @NotNull
    private final String keyAdapterString;

    @NotNull
    private final WireField.Label label;

    @NotNull
    private final Field messageField;

    @NotNull
    private final String name;
    private final boolean redacted;
    private final int tag;

    @NotNull
    private final String wireFieldJsonName;
    private final boolean writeIdentityValues;

    public FieldBinding(@NotNull WireField wireField, @NotNull Class<M> cls, @NotNull Field field, @NotNull Class<B> cls2, boolean z) {
        String declaredName;
        Intrinsics.checkNotNullParameter(wireField, "wireField");
        Intrinsics.checkNotNullParameter(cls, "messageType");
        Intrinsics.checkNotNullParameter(field, "messageField");
        Intrinsics.checkNotNullParameter(cls2, "builderType");
        this.messageField = field;
        this.writeIdentityValues = z;
        this.label = wireField.label();
        String name = field.getName();
        Intrinsics.checkNotNullExpressionValue(name, "messageField.name");
        this.name = name;
        this.wireFieldJsonName = wireField.jsonName();
        if (wireField.declaredName().length() == 0) {
            declaredName = field.getName();
            Intrinsics.checkNotNullExpressionValue(declaredName, "messageField.name");
        } else {
            declaredName = wireField.declaredName();
        }
        this.declaredName = declaredName;
        this.tag = wireField.tag();
        this.keyAdapterString = wireField.keyAdapter();
        this.adapterString = wireField.adapter();
        this.redacted = wireField.redacted();
        this.builderSetter = getBuilderSetter(cls2, wireField);
        this.builderGetter = getBuilderGetter(cls2, wireField);
        this.instanceGetter = getInstanceGetter(cls);
    }

    private final Function1<B, Object> getBuilderGetter(Class<?> builderType, final WireField wireField) {
        if (builderType.isAssignableFrom(KotlinConstructorBuilder.class)) {
            return (Function1<B, Object>) new Function1<B, Object>() { // from class: com.squareup.wire.internal.FieldBinding$getBuilderGetter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TB;)Ljava/lang/Object; */
                @Nullable
                public final Object invoke(@NotNull Message.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return ((KotlinConstructorBuilder) builder).get(WireField.this);
                }
            };
        }
        try {
            final Field field = builderType.getField(getName());
            return (Function1<B, Object>) new Function1<B, Object>() { // from class: com.squareup.wire.internal.FieldBinding$getBuilderGetter$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TB;)Ljava/lang/Object; */
                @Nullable
                public final Object invoke(@NotNull Message.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return field.get(builder);
                }
            };
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + ((Object) builderType.getName()) + '.' + getName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Function2<B, Object, Unit> getBuilderSetter(Class<?> builderType, final WireField wireField) {
        Function2<B, Object, Unit> function2;
        if (builderType.isAssignableFrom(KotlinConstructorBuilder.class)) {
            return (Function2<B, Object, Unit>) new Function2<B, Object, Unit>() { // from class: com.squareup.wire.internal.FieldBinding$getBuilderSetter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Message.Builder) obj, obj2);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Incorrect types in method signature: (TB;Ljava/lang/Object;)V */
                public final void invoke(@NotNull Message.Builder builder, @Nullable Object obj) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    ((KotlinConstructorBuilder) builder).set(WireField.this, obj);
                }
            };
        }
        if (wireField.label().isOneOf()) {
            Class<?> type = this.messageField.getType();
            try {
                final Method method = builderType.getMethod(getName(), type);
                function2 = new Function2<B, Object, Unit>() { // from class: com.squareup.wire.internal.FieldBinding$getBuilderSetter$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Message.Builder) obj, obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Incorrect types in method signature: (TB;Ljava/lang/Object;)V */
                    public final void invoke(@NotNull Message.Builder builder, @Nullable Object obj) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        method.invoke(builder, obj);
                    }
                };
            } catch (NoSuchMethodException unused) {
                throw new AssertionError("No builder method " + ((Object) builderType.getName()) + '.' + getName() + '(' + ((Object) type.getName()) + ')');
            }
        } else {
            try {
                final Field field = builderType.getField(getName());
                function2 = new Function2<B, Object, Unit>() { // from class: com.squareup.wire.internal.FieldBinding$getBuilderSetter$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Message.Builder) obj, obj2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Incorrect types in method signature: (TB;Ljava/lang/Object;)V */
                    public final void invoke(@NotNull Message.Builder builder, @Nullable Object obj) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        field.set(builder, obj);
                    }
                };
            } catch (NoSuchFieldException unused2) {
                throw new AssertionError("No builder field " + ((Object) builderType.getName()) + '.' + getName());
            }
        }
        return function2;
    }

    private final Function1<M, Object> getInstanceGetter(Class<M> messageType) {
        if (Modifier.isPrivate(this.messageField.getModifiers())) {
            String name = this.messageField.getName();
            Regex regex = IS_GETTER_FIELD_NAME_REGEX;
            Intrinsics.checkNotNullExpressionValue(name, "fieldName");
            if (!regex.matches(name)) {
                if (name.length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    String upperCase = String.valueOf(name.charAt(0)).toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    sb2.append((Object) upperCase);
                    String substring = name.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    sb2.append(substring);
                    name = sb2.toString();
                }
                name = Intrinsics.stringPlus("get", name);
            }
            final Method method = messageType.getMethod(name, null);
            return (Function1<M, Object>) new Function1<M, Object>() { // from class: com.squareup.wire.internal.FieldBinding$getInstanceGetter$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Incorrect types in method signature: (TM;)Ljava/lang/Object; */
                public final Object invoke(@NotNull Message message) {
                    Intrinsics.checkNotNullParameter(message, "instance");
                    return method.invoke(message, null);
                }
            };
        }
        return (Function1<M, Object>) new Function1<M, Object>(this) { // from class: com.squareup.wire.internal.FieldBinding$getInstanceGetter$2
            final /* synthetic */ FieldBinding<M, B> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect types in method signature: (TM;)Ljava/lang/Object; */
            public final Object invoke(@NotNull Message message) {
                Field field;
                Intrinsics.checkNotNullParameter(message, "instance");
                field = ((FieldBinding) this.this$0).messageField;
                return field.get(message);
            }
        };
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public String getDeclaredName() {
        return this.declaredName;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public ProtoAdapter<?> getKeyAdapter() {
        return ProtoAdapter.INSTANCE.get(this.keyAdapterString);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public WireField.Label getLabel() {
        return this.label;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getRedacted() {
        return this.redacted;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public ProtoAdapter<?> getSingleAdapter() {
        return ProtoAdapter.INSTANCE.get(this.adapterString);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public int getTag() {
        return this.tag;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @NotNull
    public String getWireFieldJsonName() {
        return this.wireFieldJsonName;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean getWriteIdentityValues() {
        return this.writeIdentityValues;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMap() {
        if (this.keyAdapterString.length() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public boolean isMessage() {
        Class javaObjectType;
        KClass<?> type = getSingleAdapter().getType();
        if (type == null) {
            javaObjectType = null;
        } else {
            javaObjectType = JvmClassMappingKt.getJavaObjectType(type);
        }
        return Message.class.isAssignableFrom(javaObjectType);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @Nullable
    public Object get(@NotNull M message) {
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        return this.instanceGetter.invoke(message);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    @Nullable
    public Object getFromBuilder(@NotNull B builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return this.builderGetter.invoke(builder);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public void set(@NotNull B builder, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builderSetter.invoke(builder, value);
    }

    @Override // com.squareup.wire.internal.FieldOrOneOfBinding
    public void value(@NotNull B builder, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (getLabel().isRepeated()) {
            Object fromBuilder = getFromBuilder((FieldBinding<M, B>) builder);
            if (TypeIntrinsics.isMutableList(fromBuilder)) {
                if (fromBuilder == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
                }
                TypeIntrinsics.asMutableList(fromBuilder).add(value);
                return;
            } else if (fromBuilder instanceof List) {
                List mutableList = CollectionsKt.toMutableList((Collection) fromBuilder);
                mutableList.add(value);
                set((FieldBinding<M, B>) builder, (Object) mutableList);
                return;
            } else {
                throw new ClassCastException("Expected a list type, got " + (fromBuilder != null ? fromBuilder.getClass() : null) + '.');
            }
        }
        if (this.keyAdapterString.length() > 0) {
            Object fromBuilder2 = getFromBuilder((FieldBinding<M, B>) builder);
            if (TypeIntrinsics.isMutableMap(fromBuilder2)) {
                ((Map) fromBuilder2).putAll((Map) value);
                return;
            }
            if (fromBuilder2 instanceof Map) {
                Map mutableMap = MapsKt.toMutableMap((Map) fromBuilder2);
                mutableMap.putAll((Map) value);
                set((FieldBinding<M, B>) builder, (Object) mutableMap);
                return;
            } else {
                throw new ClassCastException("Expected a map type, got " + (fromBuilder2 != null ? fromBuilder2.getClass() : null) + '.');
            }
        }
        set((FieldBinding<M, B>) builder, value);
    }
}

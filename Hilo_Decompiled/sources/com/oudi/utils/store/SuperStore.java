package com.oudi.utils.store;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001dB+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u0014\u001a\u00028\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0096\u0002¢\u0006\u0002\u0010\u0018J,\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u001b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/oudi/utils/store/SuperStore;", "T", "Lkotlin/properties/ReadWriteProperty;", "", TransferTable.COLUMN_KEY, "", "default", "group", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getDefault", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getGroup", "getType", "()I", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "Companion", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SuperStore<T> implements ReadWriteProperty<Object, T> {
    public static final int TYPE_MMKV = 0;
    public static final int TYPE_SP = 1;
    private final T default;
    private final String group;
    private final String key;
    private final int type;

    public SuperStore(String key, T t10, String group, int i10) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(group, "group");
        this.key = key;
        this.default = t10;
        this.group = group;
        this.type = i10;
    }

    public final T getDefault() {
        return this.default;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getType() {
        return this.type;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public T getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (this.type == 1) {
            T t10 = (T) SPStore.INSTANCE.getValue(this.key, this.default, this.group);
            if (t10 == null) {
                return this.default;
            }
            return t10;
        }
        T t11 = (T) MMKVStore.INSTANCE.getValue(this.key, this.default, this.group);
        if (t11 == null) {
            return this.default;
        }
        return t11;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object thisRef, KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (this.type == 1) {
            SPStore.INSTANCE.setValue(this.key, value, this.group);
        } else {
            MMKVStore.INSTANCE.setValue(this.key, value, this.group);
        }
    }

    public /* synthetic */ SuperStore(String str, Object obj, String str2, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i11 & 4) != 0 ? "default" : str2, (i11 & 8) != 0 ? 0 : i10);
    }
}

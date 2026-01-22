package com.therouter.inject;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0006\"\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/therouter/inject/ClassWrapper;", "T", "", "clazz", "Ljava/lang/Class;", "params", "", "(Ljava/lang/Class;[Ljava/lang/Object;)V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "equals", "", "o", "hashCode", "", "unWrapper", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nClassWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassWrapper.kt\ncom/therouter/inject/ClassWrapper\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,31:1\n13309#2,2:32\n*S KotlinDebug\n*F\n+ 1 ClassWrapper.kt\ncom/therouter/inject/ClassWrapper\n*L\n25#1:32,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ClassWrapper<T> {

    @NotNull
    private final Class<T> clazz;

    @Nullable
    private String key;

    public ClassWrapper(@NotNull Class<T> cls, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(objArr, "params");
        this.clazz = cls;
        for (Object obj : objArr) {
            if (obj != null) {
                this.key = this.key + obj;
            }
        }
    }

    public boolean equals(@Nullable Object o) {
        if (o instanceof ClassWrapper) {
            ClassWrapper classWrapper = (ClassWrapper) o;
            if (Intrinsics.areEqual(unWrapper(), classWrapper.unWrapper()) && Intrinsics.areEqual(this.key, classWrapper.key)) {
                return true;
            }
            return false;
        }
        return super.equals(o);
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        int hashCode = unWrapper().hashCode();
        String str = this.key;
        if (str == null) {
            str = "";
        }
        int hashCode2 = str.hashCode();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(hashCode);
        sb2.append(hashCode2);
        return sb2.toString().hashCode();
    }

    public final void setKey(@Nullable String str) {
        this.key = str;
    }

    @NotNull
    public final Class<T> unWrapper() {
        return this.clazz;
    }
}

package com.qiahao.hilo_message.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/qiahao/hilo_message/data/CustomElemContent;", "", "data", "", "dataType", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "getDataType", "()Ljava/lang/Object;", "setDataType", "(Ljava/lang/Object;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class CustomElemContent {

    @Nullable
    private String data;

    @Nullable
    private Object dataType;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomElemContent() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CustomElemContent copy$default(CustomElemContent customElemContent, String str, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            str = customElemContent.data;
        }
        if ((i10 & 2) != 0) {
            obj = customElemContent.dataType;
        }
        return customElemContent.copy(str, obj);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getData() {
        return this.data;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Object getDataType() {
        return this.dataType;
    }

    @NotNull
    public final CustomElemContent copy(@Nullable String data, @Nullable Object dataType) {
        return new CustomElemContent(data, dataType);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomElemContent)) {
            return false;
        }
        CustomElemContent customElemContent = (CustomElemContent) other;
        return Intrinsics.areEqual(this.data, customElemContent.data) && Intrinsics.areEqual(this.dataType, customElemContent.dataType);
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    @Nullable
    public final Object getDataType() {
        return this.dataType;
    }

    public int hashCode() {
        String str = this.data;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Object obj = this.dataType;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public final void setData(@Nullable String str) {
        this.data = str;
    }

    public final void setDataType(@Nullable Object obj) {
        this.dataType = obj;
    }

    @NotNull
    public String toString() {
        return "CustomElemContent(data=" + this.data + ", dataType=" + this.dataType + ")";
    }

    public CustomElemContent(@Nullable String str, @Nullable Object obj) {
        this.data = str;
        this.dataType = obj;
    }

    public /* synthetic */ CustomElemContent(String str, Object obj, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : obj);
    }
}

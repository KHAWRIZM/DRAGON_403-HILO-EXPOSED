package com.qiahao.base_common.model;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u0012\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/qiahao/base_common/model/MessageTaskData;", "T", "", "id", "", "content", "priority", "", "<init>", "(Ljava/lang/String;Ljava/lang/Object;I)V", "getId", "()Ljava/lang/String;", "getContent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPriority", "()I", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Object;I)Lcom/qiahao/base_common/model/MessageTaskData;", "equals", "", "other", "hashCode", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class MessageTaskData<T> {
    private final T content;

    @NotNull
    private final String id;
    private final int priority;

    public MessageTaskData(@NotNull String id, T t10, int i10) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.content = t10;
        this.priority = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageTaskData copy$default(MessageTaskData messageTaskData, String str, Object obj, int i10, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            str = messageTaskData.id;
        }
        if ((i11 & 2) != 0) {
            obj = messageTaskData.content;
        }
        if ((i11 & 4) != 0) {
            i10 = messageTaskData.priority;
        }
        return messageTaskData.copy(str, obj, i10);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final T component2() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    public final MessageTaskData<T> copy(@NotNull String id, T content, int priority) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new MessageTaskData<>(id, content, priority);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageTaskData)) {
            return false;
        }
        MessageTaskData messageTaskData = (MessageTaskData) other;
        return Intrinsics.areEqual(this.id, messageTaskData.id) && Intrinsics.areEqual(this.content, messageTaskData.content) && this.priority == messageTaskData.priority;
    }

    public final T getContent() {
        return this.content;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final int getPriority() {
        return this.priority;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        T t10 = this.content;
        return ((hashCode + (t10 == null ? 0 : t10.hashCode())) * 31) + this.priority;
    }

    @NotNull
    public String toString() {
        return "MessageTaskData(id=" + this.id + ", content=" + this.content + ", priority=" + this.priority + ")";
    }

    public /* synthetic */ MessageTaskData(String str, Object obj, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i11 & 4) != 0 ? 1 : i10);
    }
}

package com.qiahao.nextvideo.data.service;

import com.qiahao.nextvideo.data.model.Login;
import com.taobao.accs.utl.BaseMonitor;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001 B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/data/service/SignInEvent;", "", "type", "Lcom/qiahao/nextvideo/data/service/SignInEvent$Type;", "data", "Lcom/qiahao/nextvideo/data/model/Login;", BaseMonitor.COUNT_ERROR, "", "errorMessage", "", "<init>", "(Lcom/qiahao/nextvideo/data/service/SignInEvent$Type;Lcom/qiahao/nextvideo/data/model/Login;ILjava/lang/String;)V", "getType", "()Lcom/qiahao/nextvideo/data/service/SignInEvent$Type;", "getData", "()Lcom/qiahao/nextvideo/data/model/Login;", "getError", "()I", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Type", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class SignInEvent {

    @Nullable
    private final Login data;
    private final int error;

    @Nullable
    private String errorMessage;

    @NotNull
    private final Type type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/data/service/SignInEvent$Type;", "", "<init>", "(Ljava/lang/String;I)V", "FACEBOOK", "GOOGLE", "WECHAT", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type FACEBOOK = new Type("FACEBOOK", 0);
        public static final Type GOOGLE = new Type("GOOGLE", 1);
        public static final Type WECHAT = new Type("WECHAT", 2);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{FACEBOOK, GOOGLE, WECHAT};
        }

        static {
            Type[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Type(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public SignInEvent(@NotNull Type type, @Nullable Login login, int i, @Nullable String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.data = login;
        this.error = i;
        this.errorMessage = str;
    }

    public static /* synthetic */ SignInEvent copy$default(SignInEvent signInEvent, Type type, Login login, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            type = signInEvent.type;
        }
        if ((i2 & 2) != 0) {
            login = signInEvent.data;
        }
        if ((i2 & 4) != 0) {
            i = signInEvent.error;
        }
        if ((i2 & 8) != 0) {
            str = signInEvent.errorMessage;
        }
        return signInEvent.copy(type, login, i, str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Login getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final int getError() {
        return this.error;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final SignInEvent copy(@NotNull Type type, @Nullable Login data, int error, @Nullable String errorMessage) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new SignInEvent(type, data, error, errorMessage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignInEvent)) {
            return false;
        }
        SignInEvent signInEvent = (SignInEvent) other;
        return this.type == signInEvent.type && Intrinsics.areEqual(this.data, signInEvent.data) && this.error == signInEvent.error && Intrinsics.areEqual(this.errorMessage, signInEvent.errorMessage);
    }

    @Nullable
    public final Login getData() {
        return this.data;
    }

    public final int getError() {
        return this.error;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        Login login = this.data;
        int hashCode2 = (((hashCode + (login == null ? 0 : login.hashCode())) * 31) + this.error) * 31;
        String str = this.errorMessage;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final void setErrorMessage(@Nullable String str) {
        this.errorMessage = str;
    }

    @NotNull
    public String toString() {
        return "SignInEvent(type=" + this.type + ", data=" + this.data + ", error=" + this.error + ", errorMessage=" + this.errorMessage + ")";
    }

    public /* synthetic */ SignInEvent(Type type, Login login, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, login, i, (i2 & 8) != 0 ? null : str);
    }
}

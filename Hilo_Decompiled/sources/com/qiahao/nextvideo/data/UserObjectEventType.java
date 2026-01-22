package com.qiahao.nextvideo.data;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/data/UserObjectEventType;", "", "<init>", "(Ljava/lang/String;I)V", "LOGIN", "REFRESH", "AUTHENTICATE", "LOGOUT", "FILLUESRINFO", "REFRESH_MONEY", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserObjectEventType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UserObjectEventType[] $VALUES;
    public static final UserObjectEventType LOGIN = new UserObjectEventType("LOGIN", 0);
    public static final UserObjectEventType REFRESH = new UserObjectEventType("REFRESH", 1);
    public static final UserObjectEventType AUTHENTICATE = new UserObjectEventType("AUTHENTICATE", 2);
    public static final UserObjectEventType LOGOUT = new UserObjectEventType("LOGOUT", 3);
    public static final UserObjectEventType FILLUESRINFO = new UserObjectEventType("FILLUESRINFO", 4);
    public static final UserObjectEventType REFRESH_MONEY = new UserObjectEventType("REFRESH_MONEY", 5);

    private static final /* synthetic */ UserObjectEventType[] $values() {
        return new UserObjectEventType[]{LOGIN, REFRESH, AUTHENTICATE, LOGOUT, FILLUESRINFO, REFRESH_MONEY};
    }

    static {
        UserObjectEventType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private UserObjectEventType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<UserObjectEventType> getEntries() {
        return $ENTRIES;
    }

    public static UserObjectEventType valueOf(String str) {
        return (UserObjectEventType) Enum.valueOf(UserObjectEventType.class, str);
    }

    public static UserObjectEventType[] values() {
        return (UserObjectEventType[]) $VALUES.clone();
    }
}

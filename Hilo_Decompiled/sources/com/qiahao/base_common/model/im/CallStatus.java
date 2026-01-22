package com.qiahao.base_common.model.im;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/qiahao/base_common/model/im/CallStatus;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "NORMAL", "CANCELED", "TIMEOUT_REFUSE", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CallStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CallStatus[] $VALUES;
    private final int code;
    public static final CallStatus NORMAL = new CallStatus("NORMAL", 0, 0);
    public static final CallStatus CANCELED = new CallStatus("CANCELED", 1, 1);
    public static final CallStatus TIMEOUT_REFUSE = new CallStatus("TIMEOUT_REFUSE", 2, 2);

    private static final /* synthetic */ CallStatus[] $values() {
        return new CallStatus[]{NORMAL, CANCELED, TIMEOUT_REFUSE};
    }

    static {
        CallStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private CallStatus(String str, int i10, int i11) {
        this.code = i11;
    }

    @NotNull
    public static EnumEntries<CallStatus> getEntries() {
        return $ENTRIES;
    }

    public static CallStatus valueOf(String str) {
        return (CallStatus) Enum.valueOf(CallStatus.class, str);
    }

    public static CallStatus[] values() {
        return (CallStatus[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}

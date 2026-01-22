package com.qiahao.nextvideo.data.service;

import com.qiahao.nextvideo.ui.commonlist.interactivetracking.CommonCellViewHolder;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/data/service/ReportFrom;", "", Constants.KEY_HTTP_CODE, "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", CommonCellViewHolder.VideoCall, "Profile", "Chat", "History", "Group", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ReportFrom {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReportFrom[] $VALUES;
    private final int code;
    public static final ReportFrom VideoCall = new ReportFrom(CommonCellViewHolder.VideoCall, 0, 1);
    public static final ReportFrom Profile = new ReportFrom("Profile", 1, 2);
    public static final ReportFrom Chat = new ReportFrom("Chat", 2, 3);
    public static final ReportFrom History = new ReportFrom("History", 3, 4);
    public static final ReportFrom Group = new ReportFrom("Group", 4, 5);

    private static final /* synthetic */ ReportFrom[] $values() {
        return new ReportFrom[]{VideoCall, Profile, Chat, History, Group};
    }

    static {
        ReportFrom[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private ReportFrom(String str, int i, int i2) {
        this.code = i2;
    }

    @NotNull
    public static EnumEntries<ReportFrom> getEntries() {
        return $ENTRIES;
    }

    public static ReportFrom valueOf(String str) {
        return (ReportFrom) Enum.valueOf(ReportFrom.class, str);
    }

    public static ReportFrom[] values() {
        return (ReportFrom[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}

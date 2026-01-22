package com.qiahao.nextvideo.data.model;

import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ReceivedGift;", "", TUIConstants.TUIChat.INPUT_MORE_ICON, "", "count", "", "<init>", "(Ljava/lang/String;I)V", "getIcon", "()Ljava/lang/String;", "getCount", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ReceivedGift {

    @c("num")
    private final int count;

    @NotNull
    @c("iconUrl")
    private final String icon;

    public ReceivedGift(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, TUIConstants.TUIChat.INPUT_MORE_ICON);
        this.icon = str;
        this.count = i;
    }

    public static /* synthetic */ ReceivedGift copy$default(ReceivedGift receivedGift, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = receivedGift.icon;
        }
        if ((i2 & 2) != 0) {
            i = receivedGift.count;
        }
        return receivedGift.copy(str, i);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final ReceivedGift copy(@NotNull String icon, int count) {
        Intrinsics.checkNotNullParameter(icon, TUIConstants.TUIChat.INPUT_MORE_ICON);
        return new ReceivedGift(icon, count);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceivedGift)) {
            return false;
        }
        ReceivedGift receivedGift = (ReceivedGift) other;
        return Intrinsics.areEqual(this.icon, receivedGift.icon) && this.count == receivedGift.count;
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    public int hashCode() {
        return (this.icon.hashCode() * 31) + this.count;
    }

    @NotNull
    public String toString() {
        return "ReceivedGift(icon=" + this.icon + ", count=" + this.count + ")";
    }
}

package com.qiahao.nextvideo.data.model;

import com.qiahao.base_common.model.common.User;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ContactsLikeEachItem;", "", "onLineStatus", "", "userBase", "Lcom/qiahao/base_common/model/common/User;", "type", "", "<init>", "(ILcom/qiahao/base_common/model/common/User;Ljava/lang/String;)V", "getOnLineStatus", "()I", "getUserBase", "()Lcom/qiahao/base_common/model/common/User;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "isSelect", "", "()Z", "setSelect", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class ContactsLikeEachItem {
    private boolean isSelect;

    @c("imOnlineStatus")
    private final int onLineStatus;

    @Nullable
    private String type;

    @NotNull
    @c("userBase")
    private final User userBase;

    public ContactsLikeEachItem(int i, @NotNull User user, @Nullable String str) {
        Intrinsics.checkNotNullParameter(user, "userBase");
        this.onLineStatus = i;
        this.userBase = user;
        this.type = str;
    }

    public static /* synthetic */ ContactsLikeEachItem copy$default(ContactsLikeEachItem contactsLikeEachItem, int i, User user, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = contactsLikeEachItem.onLineStatus;
        }
        if ((i2 & 2) != 0) {
            user = contactsLikeEachItem.userBase;
        }
        if ((i2 & 4) != 0) {
            str = contactsLikeEachItem.type;
        }
        return contactsLikeEachItem.copy(i, user, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getOnLineStatus() {
        return this.onLineStatus;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final User getUserBase() {
        return this.userBase;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final ContactsLikeEachItem copy(int onLineStatus, @NotNull User userBase, @Nullable String type) {
        Intrinsics.checkNotNullParameter(userBase, "userBase");
        return new ContactsLikeEachItem(onLineStatus, userBase, type);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactsLikeEachItem)) {
            return false;
        }
        ContactsLikeEachItem contactsLikeEachItem = (ContactsLikeEachItem) other;
        return this.onLineStatus == contactsLikeEachItem.onLineStatus && Intrinsics.areEqual(this.userBase, contactsLikeEachItem.userBase) && Intrinsics.areEqual(this.type, contactsLikeEachItem.type);
    }

    public final int getOnLineStatus() {
        return this.onLineStatus;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final User getUserBase() {
        return this.userBase;
    }

    public int hashCode() {
        int hashCode = ((this.onLineStatus * 31) + this.userBase.hashCode()) * 31;
        String str = this.type;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    /* renamed from: isSelect, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    @NotNull
    public String toString() {
        return "ContactsLikeEachItem(onLineStatus=" + this.onLineStatus + ", userBase=" + this.userBase + ", type=" + this.type + ")";
    }

    public /* synthetic */ ContactsLikeEachItem(int i, User user, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, user, (i2 & 4) != 0 ? null : str);
    }
}

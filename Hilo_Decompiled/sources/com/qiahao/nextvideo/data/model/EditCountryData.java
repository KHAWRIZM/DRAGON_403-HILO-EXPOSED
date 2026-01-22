package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.qiahao.nextvideo.ui.home.discover.CountryActivity;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/data/model/EditCountryData;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemType", "", CountryActivity.COUNTRY_SHORT, "", "name", TUIConstants.TUIChat.INPUT_MORE_ICON, Constants.KEY_HTTP_CODE, "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getItemType", "()I", "getShortName", "()Ljava/lang/String;", "setShortName", "(Ljava/lang/String;)V", "getName", "getIcon", "getCode", "()J", "setCode", "(J)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class EditCountryData implements MultiItemEntity {
    private long code;

    @Nullable
    private final String icon;
    private final int itemType;

    @Nullable
    private final String name;

    @Nullable
    private String shortName;

    public EditCountryData(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, long j) {
        this.itemType = i;
        this.shortName = str;
        this.name = str2;
        this.icon = str3;
        this.code = j;
    }

    public static /* synthetic */ EditCountryData copy$default(EditCountryData editCountryData, int i, String str, String str2, String str3, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = editCountryData.itemType;
        }
        if ((i2 & 2) != 0) {
            str = editCountryData.shortName;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            str2 = editCountryData.name;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = editCountryData.icon;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            j = editCountryData.code;
        }
        return editCountryData.copy(i, str4, str5, str6, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getItemType() {
        return this.itemType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getShortName() {
        return this.shortName;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component5, reason: from getter */
    public final long getCode() {
        return this.code;
    }

    @NotNull
    public final EditCountryData copy(int itemType, @Nullable String shortName, @Nullable String name, @Nullable String icon, long code) {
        return new EditCountryData(itemType, shortName, name, icon, code);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditCountryData)) {
            return false;
        }
        EditCountryData editCountryData = (EditCountryData) other;
        return this.itemType == editCountryData.itemType && Intrinsics.areEqual(this.shortName, editCountryData.shortName) && Intrinsics.areEqual(this.name, editCountryData.name) && Intrinsics.areEqual(this.icon, editCountryData.icon) && this.code == editCountryData.code;
    }

    public final long getCode() {
        return this.code;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    public int getItemType() {
        return this.itemType;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getShortName() {
        return this.shortName;
    }

    public int hashCode() {
        int i = this.itemType * 31;
        String str = this.shortName;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + c.a(this.code);
    }

    public final void setCode(long j) {
        this.code = j;
    }

    public final void setShortName(@Nullable String str) {
        this.shortName = str;
    }

    @NotNull
    public String toString() {
        return "EditCountryData(itemType=" + this.itemType + ", shortName=" + this.shortName + ", name=" + this.name + ", icon=" + this.icon + ", code=" + this.code + ")";
    }

    public /* synthetic */ EditCountryData(int i, String str, String str2, String str3, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) == 0 ? str3 : null, (i2 & 16) != 0 ? 0L : j);
    }
}

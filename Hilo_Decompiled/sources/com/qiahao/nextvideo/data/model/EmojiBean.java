package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/model/EmojiBean;", "", AgooConstants.MESSAGE_ID, "", "iconUrl", "", "name", "svagUrl", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getIconUrl", "()Ljava/lang/String;", "getName", "getSvagUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class EmojiBean {

    @NotNull
    private final String iconUrl;
    private final long id;

    @NotNull
    private final String name;

    @NotNull
    private final String svagUrl;

    public EmojiBean(long j, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "iconUrl");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "svagUrl");
        this.id = j;
        this.iconUrl = str;
        this.name = str2;
        this.svagUrl = str3;
    }

    public static /* synthetic */ EmojiBean copy$default(EmojiBean emojiBean, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = emojiBean.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = emojiBean.iconUrl;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = emojiBean.name;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = emojiBean.svagUrl;
        }
        return emojiBean.copy(j2, str4, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getSvagUrl() {
        return this.svagUrl;
    }

    @NotNull
    public final EmojiBean copy(long id2, @NotNull String iconUrl, @NotNull String name, @NotNull String svagUrl) {
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(svagUrl, "svagUrl");
        return new EmojiBean(id2, iconUrl, name, svagUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiBean)) {
            return false;
        }
        EmojiBean emojiBean = (EmojiBean) other;
        return this.id == emojiBean.id && Intrinsics.areEqual(this.iconUrl, emojiBean.iconUrl) && Intrinsics.areEqual(this.name, emojiBean.name) && Intrinsics.areEqual(this.svagUrl, emojiBean.svagUrl);
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getSvagUrl() {
        return this.svagUrl;
    }

    public int hashCode() {
        return (((((c.a(this.id) * 31) + this.iconUrl.hashCode()) * 31) + this.name.hashCode()) * 31) + this.svagUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmojiBean(id=" + this.id + ", iconUrl=" + this.iconUrl + ", name=" + this.name + ", svagUrl=" + this.svagUrl + ")";
    }
}

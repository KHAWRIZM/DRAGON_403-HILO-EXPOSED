package com.qiahao.nextvideo.data.room;

import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0016JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\bHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/data/room/Svip10Signaling;", "", "content", "", "nickName", "avatar", Constants.KEY_HTTP_CODE, "svipLevel", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getNickName", "setNickName", "getAvatar", "setAvatar", "getCode", "setCode", "getSvipLevel", "()Ljava/lang/Integer;", "setSvipLevel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/qiahao/nextvideo/data/room/Svip10Signaling;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class Svip10Signaling {

    @Nullable
    private String avatar;

    @Nullable
    private String code;

    @Nullable
    private String content;

    @Nullable
    private String nickName;

    @Nullable
    private Integer svipLevel;

    public Svip10Signaling() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Svip10Signaling copy$default(Svip10Signaling svip10Signaling, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = svip10Signaling.content;
        }
        if ((i & 2) != 0) {
            str2 = svip10Signaling.nickName;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = svip10Signaling.avatar;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = svip10Signaling.code;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            num = svip10Signaling.svipLevel;
        }
        return svip10Signaling.copy(str, str5, str6, str7, num);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    @NotNull
    public final Svip10Signaling copy(@Nullable String content, @Nullable String nickName, @Nullable String avatar, @Nullable String code, @Nullable Integer svipLevel) {
        return new Svip10Signaling(content, nickName, avatar, code, svipLevel);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Svip10Signaling)) {
            return false;
        }
        Svip10Signaling svip10Signaling = (Svip10Signaling) other;
        return Intrinsics.areEqual(this.content, svip10Signaling.content) && Intrinsics.areEqual(this.nickName, svip10Signaling.nickName) && Intrinsics.areEqual(this.avatar, svip10Signaling.avatar) && Intrinsics.areEqual(this.code, svip10Signaling.code) && Intrinsics.areEqual(this.svipLevel, svip10Signaling.svipLevel);
    }

    @Nullable
    public final String getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getNickName() {
        return this.nickName;
    }

    @Nullable
    public final Integer getSvipLevel() {
        return this.svipLevel;
    }

    public int hashCode() {
        String str = this.content;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.nickName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatar;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.code;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.svipLevel;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    public final void setAvatar(@Nullable String str) {
        this.avatar = str;
    }

    public final void setCode(@Nullable String str) {
        this.code = str;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setNickName(@Nullable String str) {
        this.nickName = str;
    }

    public final void setSvipLevel(@Nullable Integer num) {
        this.svipLevel = num;
    }

    @NotNull
    public String toString() {
        return "Svip10Signaling(content=" + this.content + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", code=" + this.code + ", svipLevel=" + this.svipLevel + ")";
    }

    public Svip10Signaling(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num) {
        this.content = str;
        this.nickName = str2;
        this.avatar = str3;
        this.code = str4;
        this.svipLevel = num;
    }

    public /* synthetic */ Svip10Signaling(String str, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : num);
    }
}

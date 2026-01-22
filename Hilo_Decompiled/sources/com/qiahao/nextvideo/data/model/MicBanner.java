package com.qiahao.nextvideo.data.model;

import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MicBanner;", "", TUIConstants.TUILive.USER_ID, "", "nick", "myAvatar", "vote", "", "avatar1", "avatar2", "avatar3", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getNick", "setNick", "getMyAvatar", "setMyAvatar", "getVote", "()Ljava/lang/Integer;", "setVote", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAvatar1", "setAvatar1", "getAvatar2", "setAvatar2", "getAvatar3", "setAvatar3", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/qiahao/nextvideo/data/model/MicBanner;", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MicBanner {

    @Nullable
    private String avatar1;

    @Nullable
    private String avatar2;

    @Nullable
    private String avatar3;

    @Nullable
    private String myAvatar;

    @Nullable
    private String nick;

    @Nullable
    private String url;

    @Nullable
    private String userId;

    @Nullable
    private Integer vote;

    public MicBanner() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getMyAvatar() {
        return this.myAvatar;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getVote() {
        return this.vote;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getAvatar1() {
        return this.avatar1;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getAvatar2() {
        return this.avatar2;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getAvatar3() {
        return this.avatar3;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final MicBanner copy(@Nullable String userId, @Nullable String nick, @Nullable String myAvatar, @Nullable Integer vote, @Nullable String avatar1, @Nullable String avatar2, @Nullable String avatar3, @Nullable String url) {
        return new MicBanner(userId, nick, myAvatar, vote, avatar1, avatar2, avatar3, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MicBanner)) {
            return false;
        }
        MicBanner micBanner = (MicBanner) other;
        return Intrinsics.areEqual(this.userId, micBanner.userId) && Intrinsics.areEqual(this.nick, micBanner.nick) && Intrinsics.areEqual(this.myAvatar, micBanner.myAvatar) && Intrinsics.areEqual(this.vote, micBanner.vote) && Intrinsics.areEqual(this.avatar1, micBanner.avatar1) && Intrinsics.areEqual(this.avatar2, micBanner.avatar2) && Intrinsics.areEqual(this.avatar3, micBanner.avatar3) && Intrinsics.areEqual(this.url, micBanner.url);
    }

    @Nullable
    public final String getAvatar1() {
        return this.avatar1;
    }

    @Nullable
    public final String getAvatar2() {
        return this.avatar2;
    }

    @Nullable
    public final String getAvatar3() {
        return this.avatar3;
    }

    @Nullable
    public final String getMyAvatar() {
        return this.myAvatar;
    }

    @Nullable
    public final String getNick() {
        return this.nick;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    public final Integer getVote() {
        return this.vote;
    }

    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.nick;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.myAvatar;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.vote;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.avatar1;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.avatar2;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.avatar3;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.url;
        return hashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setAvatar1(@Nullable String str) {
        this.avatar1 = str;
    }

    public final void setAvatar2(@Nullable String str) {
        this.avatar2 = str;
    }

    public final void setAvatar3(@Nullable String str) {
        this.avatar3 = str;
    }

    public final void setMyAvatar(@Nullable String str) {
        this.myAvatar = str;
    }

    public final void setNick(@Nullable String str) {
        this.nick = str;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    public final void setVote(@Nullable Integer num) {
        this.vote = num;
    }

    @NotNull
    public String toString() {
        return "MicBanner(userId=" + this.userId + ", nick=" + this.nick + ", myAvatar=" + this.myAvatar + ", vote=" + this.vote + ", avatar1=" + this.avatar1 + ", avatar2=" + this.avatar2 + ", avatar3=" + this.avatar3 + ", url=" + this.url + ")";
    }

    public MicBanner(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.userId = str;
        this.nick = str2;
        this.myAvatar = str3;
        this.vote = num;
        this.avatar1 = str4;
        this.avatar2 = str5;
        this.avatar3 = str6;
        this.url = str7;
    }

    public /* synthetic */ MicBanner(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) == 0 ? str7 : null);
    }
}

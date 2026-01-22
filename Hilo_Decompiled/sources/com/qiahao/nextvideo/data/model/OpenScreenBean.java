package com.qiahao.nextvideo.data.model;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0095\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\rHÖ\u0001J\t\u0010;\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0016\"\u0004\b%\u0010\u001dR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u001d¨\u0006<"}, d2 = {"Lcom/qiahao/nextvideo/data/model/OpenScreenBean;", "", AgooConstants.MESSAGE_ID, "", "bannerUrl", "", "groupId", "h5Url", "nick1", "nick2", "pic1Url", "pic2Url", "type", "", "localFile", "localPic1Url", "localPic2Url", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getBannerUrl", "()Ljava/lang/String;", "getGroupId", "getH5Url", "getNick1", "getNick2", "getPic1Url", "setPic1Url", "(Ljava/lang/String;)V", "getPic2Url", "setPic2Url", "getType", "()I", "setType", "(I)V", "getLocalFile", "setLocalFile", "getLocalPic1Url", "setLocalPic1Url", "getLocalPic2Url", "setLocalPic2Url", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class OpenScreenBean {

    @Nullable
    private final String bannerUrl;

    @Nullable
    private final String groupId;

    @Nullable
    private final String h5Url;
    private final long id;

    @Nullable
    private String localFile;

    @Nullable
    private String localPic1Url;

    @Nullable
    private String localPic2Url;

    @Nullable
    private final String nick1;

    @Nullable
    private final String nick2;

    @Nullable
    private String pic1Url;

    @Nullable
    private String pic2Url;
    private int type;

    public OpenScreenBean(long j, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, int i, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        this.id = j;
        this.bannerUrl = str;
        this.groupId = str2;
        this.h5Url = str3;
        this.nick1 = str4;
        this.nick2 = str5;
        this.pic1Url = str6;
        this.pic2Url = str7;
        this.type = i;
        this.localFile = str8;
        this.localPic1Url = str9;
        this.localPic2Url = str10;
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getLocalFile() {
        return this.localFile;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getLocalPic1Url() {
        return this.localPic1Url;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getLocalPic2Url() {
        return this.localPic2Url;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getH5Url() {
        return this.h5Url;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getNick1() {
        return this.nick1;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getNick2() {
        return this.nick2;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getPic1Url() {
        return this.pic1Url;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getPic2Url() {
        return this.pic2Url;
    }

    /* renamed from: component9, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @NotNull
    public final OpenScreenBean copy(long id2, @Nullable String bannerUrl, @Nullable String groupId, @Nullable String h5Url, @Nullable String nick1, @Nullable String nick2, @Nullable String pic1Url, @Nullable String pic2Url, int type, @Nullable String localFile, @Nullable String localPic1Url, @Nullable String localPic2Url) {
        return new OpenScreenBean(id2, bannerUrl, groupId, h5Url, nick1, nick2, pic1Url, pic2Url, type, localFile, localPic1Url, localPic2Url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenScreenBean)) {
            return false;
        }
        OpenScreenBean openScreenBean = (OpenScreenBean) other;
        return this.id == openScreenBean.id && Intrinsics.areEqual(this.bannerUrl, openScreenBean.bannerUrl) && Intrinsics.areEqual(this.groupId, openScreenBean.groupId) && Intrinsics.areEqual(this.h5Url, openScreenBean.h5Url) && Intrinsics.areEqual(this.nick1, openScreenBean.nick1) && Intrinsics.areEqual(this.nick2, openScreenBean.nick2) && Intrinsics.areEqual(this.pic1Url, openScreenBean.pic1Url) && Intrinsics.areEqual(this.pic2Url, openScreenBean.pic2Url) && this.type == openScreenBean.type && Intrinsics.areEqual(this.localFile, openScreenBean.localFile) && Intrinsics.areEqual(this.localPic1Url, openScreenBean.localPic1Url) && Intrinsics.areEqual(this.localPic2Url, openScreenBean.localPic2Url);
    }

    @Nullable
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @Nullable
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getH5Url() {
        return this.h5Url;
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final String getLocalFile() {
        return this.localFile;
    }

    @Nullable
    public final String getLocalPic1Url() {
        return this.localPic1Url;
    }

    @Nullable
    public final String getLocalPic2Url() {
        return this.localPic2Url;
    }

    @Nullable
    public final String getNick1() {
        return this.nick1;
    }

    @Nullable
    public final String getNick2() {
        return this.nick2;
    }

    @Nullable
    public final String getPic1Url() {
        return this.pic1Url;
    }

    @Nullable
    public final String getPic2Url() {
        return this.pic2Url;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int a = c.a(this.id) * 31;
        String str = this.bannerUrl;
        int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.groupId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.h5Url;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nick1;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.nick2;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.pic1Url;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.pic2Url;
        int hashCode7 = (((hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.type) * 31;
        String str8 = this.localFile;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.localPic1Url;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.localPic2Url;
        return hashCode9 + (str10 != null ? str10.hashCode() : 0);
    }

    public final void setLocalFile(@Nullable String str) {
        this.localFile = str;
    }

    public final void setLocalPic1Url(@Nullable String str) {
        this.localPic1Url = str;
    }

    public final void setLocalPic2Url(@Nullable String str) {
        this.localPic2Url = str;
    }

    public final void setPic1Url(@Nullable String str) {
        this.pic1Url = str;
    }

    public final void setPic2Url(@Nullable String str) {
        this.pic2Url = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public String toString() {
        return "OpenScreenBean(id=" + this.id + ", bannerUrl=" + this.bannerUrl + ", groupId=" + this.groupId + ", h5Url=" + this.h5Url + ", nick1=" + this.nick1 + ", nick2=" + this.nick2 + ", pic1Url=" + this.pic1Url + ", pic2Url=" + this.pic2Url + ", type=" + this.type + ", localFile=" + this.localFile + ", localPic1Url=" + this.localPic1Url + ", localPic2Url=" + this.localPic2Url + ")";
    }

    public /* synthetic */ OpenScreenBean(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, String str9, String str10, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? 0 : i, (i2 & 512) != 0 ? null : str8, (i2 & LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY) != 0 ? null : str9, (i2 & 2048) != 0 ? null : str10);
    }
}

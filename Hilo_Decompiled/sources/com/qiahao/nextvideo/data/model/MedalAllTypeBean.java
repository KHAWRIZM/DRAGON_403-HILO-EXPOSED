package com.qiahao.nextvideo.data.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003Jm\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013¨\u00066"}, d2 = {"Lcom/qiahao/nextvideo/data/model/MedalAllTypeBean;", "Ljava/io/Serializable;", AgooConstants.MESSAGE_ID, "", "isHas", "", "name", "", "picUrl", "previewUrl", "svgaUrl", "type", "desc", "level", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getId", "()I", "setId", "(I)V", "()Z", "setHas", "(Z)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPicUrl", "setPicUrl", "getPreviewUrl", "setPreviewUrl", "getSvgaUrl", "setSvgaUrl", "getType", "setType", "getDesc", "setDesc", "getLevel", "setLevel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class MedalAllTypeBean implements Serializable {

    @Nullable
    private String desc;
    private int id;
    private boolean isHas;
    private int level;

    @Nullable
    private String name;

    @Nullable
    private String picUrl;

    @Nullable
    private String previewUrl;

    @Nullable
    private String svgaUrl;
    private int type;

    public MedalAllTypeBean(int i, boolean z, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i2, @Nullable String str5, int i3) {
        this.id = i;
        this.isHas = z;
        this.name = str;
        this.picUrl = str2;
        this.previewUrl = str3;
        this.svgaUrl = str4;
        this.type = i2;
        this.desc = str5;
        this.level = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsHas() {
        return this.isHas;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    /* renamed from: component7, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component9, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    @NotNull
    public final MedalAllTypeBean copy(int id2, boolean isHas, @Nullable String name, @Nullable String picUrl, @Nullable String previewUrl, @Nullable String svgaUrl, int type, @Nullable String desc, int level) {
        return new MedalAllTypeBean(id2, isHas, name, picUrl, previewUrl, svgaUrl, type, desc, level);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MedalAllTypeBean)) {
            return false;
        }
        MedalAllTypeBean medalAllTypeBean = (MedalAllTypeBean) other;
        return this.id == medalAllTypeBean.id && this.isHas == medalAllTypeBean.isHas && Intrinsics.areEqual(this.name, medalAllTypeBean.name) && Intrinsics.areEqual(this.picUrl, medalAllTypeBean.picUrl) && Intrinsics.areEqual(this.previewUrl, medalAllTypeBean.previewUrl) && Intrinsics.areEqual(this.svgaUrl, medalAllTypeBean.svgaUrl) && this.type == medalAllTypeBean.type && Intrinsics.areEqual(this.desc, medalAllTypeBean.desc) && this.level == medalAllTypeBean.level;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    public final int getId() {
        return this.id;
    }

    public final int getLevel() {
        return this.level;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPicUrl() {
        return this.picUrl;
    }

    @Nullable
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    @Nullable
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int a = ((this.id * 31) + a.a(this.isHas)) * 31;
        String str = this.name;
        int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.picUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.previewUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.svgaUrl;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.type) * 31;
        String str5 = this.desc;
        return ((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.level;
    }

    public final boolean isHas() {
        return this.isHas;
    }

    public final void setDesc(@Nullable String str) {
        this.desc = str;
    }

    public final void setHas(boolean z) {
        this.isHas = z;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    public final void setPicUrl(@Nullable String str) {
        this.picUrl = str;
    }

    public final void setPreviewUrl(@Nullable String str) {
        this.previewUrl = str;
    }

    public final void setSvgaUrl(@Nullable String str) {
        this.svgaUrl = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @NotNull
    public String toString() {
        return "MedalAllTypeBean(id=" + this.id + ", isHas=" + this.isHas + ", name=" + this.name + ", picUrl=" + this.picUrl + ", previewUrl=" + this.previewUrl + ", svgaUrl=" + this.svgaUrl + ", type=" + this.type + ", desc=" + this.desc + ", level=" + this.level + ")";
    }
}

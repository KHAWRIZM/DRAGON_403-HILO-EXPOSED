package com.qhqc.core.feature.bean.community;

import androidx.collection.c;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003Jk\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010'\"\u0004\b(\u0010)¨\u00068"}, d2 = {"Lcom/qhqc/core/feature/bean/community/PostsCreateMediaBean;", "", "mediaType", "", "path", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "size", "", "md5", "uploadedPath", "uploadedPathAbsolute", "isAddPic", "", "<init>", "(ILjava/lang/String;IIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getMediaType", "()I", "setMediaType", "(I)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getWidth", "setWidth", "getHeight", "setHeight", "getSize", "()J", "setSize", "(J)V", "getMd5", "setMd5", "getUploadedPath", "setUploadedPath", "getUploadedPathAbsolute", "setUploadedPathAbsolute", "()Z", "setAddPic", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PostsCreateMediaBean {
    private int height;
    private transient boolean isAddPic;

    @Nullable
    private String md5;
    private int mediaType;

    @Nullable
    private String path;
    private long size;

    @Nullable
    private transient String uploadedPath;

    @Nullable
    private transient String uploadedPathAbsolute;
    private int width;

    public PostsCreateMediaBean() {
        this(0, null, 0, 0, 0L, null, null, null, false, 511, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMediaType() {
        return this.mediaType;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component5, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final String getMd5() {
        return this.md5;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getUploadedPath() {
        return this.uploadedPath;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getUploadedPathAbsolute() {
        return this.uploadedPathAbsolute;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsAddPic() {
        return this.isAddPic;
    }

    @NotNull
    public final PostsCreateMediaBean copy(int mediaType, @Nullable String path, int width, int height, long size, @Nullable String md5, @Nullable String uploadedPath, @Nullable String uploadedPathAbsolute, boolean isAddPic) {
        return new PostsCreateMediaBean(mediaType, path, width, height, size, md5, uploadedPath, uploadedPathAbsolute, isAddPic);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostsCreateMediaBean)) {
            return false;
        }
        PostsCreateMediaBean postsCreateMediaBean = (PostsCreateMediaBean) other;
        return this.mediaType == postsCreateMediaBean.mediaType && Intrinsics.areEqual(this.path, postsCreateMediaBean.path) && this.width == postsCreateMediaBean.width && this.height == postsCreateMediaBean.height && this.size == postsCreateMediaBean.size && Intrinsics.areEqual(this.md5, postsCreateMediaBean.md5) && Intrinsics.areEqual(this.uploadedPath, postsCreateMediaBean.uploadedPath) && Intrinsics.areEqual(this.uploadedPathAbsolute, postsCreateMediaBean.uploadedPathAbsolute) && this.isAddPic == postsCreateMediaBean.isAddPic;
    }

    public final int getHeight() {
        return this.height;
    }

    @Nullable
    public final String getMd5() {
        return this.md5;
    }

    public final int getMediaType() {
        return this.mediaType;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    @Nullable
    public final String getUploadedPath() {
        return this.uploadedPath;
    }

    @Nullable
    public final String getUploadedPathAbsolute() {
        return this.uploadedPathAbsolute;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i10 = this.mediaType * 31;
        String str = this.path;
        int hashCode = (((((((i10 + (str == null ? 0 : str.hashCode())) * 31) + this.width) * 31) + this.height) * 31) + c.a(this.size)) * 31;
        String str2 = this.md5;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.uploadedPath;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.uploadedPathAbsolute;
        return ((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + a.a(this.isAddPic);
    }

    public final boolean isAddPic() {
        return this.isAddPic;
    }

    public final void setAddPic(boolean z10) {
        this.isAddPic = z10;
    }

    public final void setHeight(int i10) {
        this.height = i10;
    }

    public final void setMd5(@Nullable String str) {
        this.md5 = str;
    }

    public final void setMediaType(int i10) {
        this.mediaType = i10;
    }

    public final void setPath(@Nullable String str) {
        this.path = str;
    }

    public final void setSize(long j10) {
        this.size = j10;
    }

    public final void setUploadedPath(@Nullable String str) {
        this.uploadedPath = str;
    }

    public final void setUploadedPathAbsolute(@Nullable String str) {
        this.uploadedPathAbsolute = str;
    }

    public final void setWidth(int i10) {
        this.width = i10;
    }

    @NotNull
    public String toString() {
        return "PostsCreateMediaBean(mediaType=" + this.mediaType + ", path=" + this.path + ", width=" + this.width + ", height=" + this.height + ", size=" + this.size + ", md5=" + this.md5 + ", uploadedPath=" + this.uploadedPath + ", uploadedPathAbsolute=" + this.uploadedPathAbsolute + ", isAddPic=" + this.isAddPic + ")";
    }

    public PostsCreateMediaBean(int i10, @Nullable String str, int i11, int i12, long j10, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z10) {
        this.mediaType = i10;
        this.path = str;
        this.width = i11;
        this.height = i12;
        this.size = j10;
        this.md5 = str2;
        this.uploadedPath = str3;
        this.uploadedPathAbsolute = str4;
        this.isAddPic = z10;
    }

    public /* synthetic */ PostsCreateMediaBean(int i10, String str, int i11, int i12, long j10, String str2, String str3, String str4, boolean z10, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 1 : i10, (i13 & 2) != 0 ? null : str, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12, (i13 & 16) != 0 ? 0L : j10, (i13 & 32) == 0 ? str2 : null, (i13 & 64) != 0 ? "" : str3, (i13 & 128) == 0 ? str4 : "", (i13 & 256) == 0 ? z10 : false);
    }
}

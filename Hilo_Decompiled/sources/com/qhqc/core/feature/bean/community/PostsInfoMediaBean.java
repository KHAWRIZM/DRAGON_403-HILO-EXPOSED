package com.qhqc.core.feature.bean.community;

import androidx.collection.c;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J=\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006'"}, d2 = {"Lcom/qhqc/core/feature/bean/community/PostsInfoMediaBean;", "", "type", "", "url", "", "size", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "<init>", "(ILjava/lang/String;JII)V", "getType", "()I", "setType", "(I)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getSize", "()J", "setSize", "(J)V", "getWidth", "setWidth", "getHeight", "setHeight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PostsInfoMediaBean {
    private int height;
    private long size;
    private int type;

    @Nullable
    private String url;
    private int width;

    public PostsInfoMediaBean(int i10, @Nullable String str, long j10, int i11, int i12) {
        this.type = i10;
        this.url = str;
        this.size = j10;
        this.width = i11;
        this.height = i12;
    }

    public static /* synthetic */ PostsInfoMediaBean copy$default(PostsInfoMediaBean postsInfoMediaBean, int i10, String str, long j10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = postsInfoMediaBean.type;
        }
        if ((i13 & 2) != 0) {
            str = postsInfoMediaBean.url;
        }
        String str2 = str;
        if ((i13 & 4) != 0) {
            j10 = postsInfoMediaBean.size;
        }
        long j11 = j10;
        if ((i13 & 8) != 0) {
            i11 = postsInfoMediaBean.width;
        }
        int i14 = i11;
        if ((i13 & 16) != 0) {
            i12 = postsInfoMediaBean.height;
        }
        return postsInfoMediaBean.copy(i10, str2, j11, i14, i12);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: component4, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component5, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final PostsInfoMediaBean copy(int type, @Nullable String url, long size, int width, int height) {
        return new PostsInfoMediaBean(type, url, size, width, height);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostsInfoMediaBean)) {
            return false;
        }
        PostsInfoMediaBean postsInfoMediaBean = (PostsInfoMediaBean) other;
        return this.type == postsInfoMediaBean.type && Intrinsics.areEqual(this.url, postsInfoMediaBean.url) && this.size == postsInfoMediaBean.size && this.width == postsInfoMediaBean.width && this.height == postsInfoMediaBean.height;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i10 = this.type * 31;
        String str = this.url;
        return ((((((i10 + (str == null ? 0 : str.hashCode())) * 31) + c.a(this.size)) * 31) + this.width) * 31) + this.height;
    }

    public final void setHeight(int i10) {
        this.height = i10;
    }

    public final void setSize(long j10) {
        this.size = j10;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    public final void setWidth(int i10) {
        this.width = i10;
    }

    @NotNull
    public String toString() {
        return "PostsInfoMediaBean(type=" + this.type + ", url=" + this.url + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + ")";
    }
}

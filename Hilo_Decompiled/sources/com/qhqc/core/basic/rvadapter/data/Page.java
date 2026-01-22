package com.qhqc.core.basic.rvadapter.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.a;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003JI\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u0006)"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/data/Page;", "", "page", "", "currentPageCursor", "", "nextPageCursor", "hasNextPage", "", "pageSize", "loadError", "(ILjava/lang/String;Ljava/lang/String;ZIZ)V", "getCurrentPageCursor", "()Ljava/lang/String;", "setCurrentPageCursor", "(Ljava/lang/String;)V", "getHasNextPage", "()Z", "setHasNextPage", "(Z)V", "getLoadError", "setLoadError", "getNextPageCursor", "setNextPageCursor", "getPage", "()I", "setPage", "(I)V", "getPageSize", "setPageSize", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class Page {

    @Nullable
    private String currentPageCursor;
    private boolean hasNextPage;
    private boolean loadError;

    @Nullable
    private String nextPageCursor;
    private int page;
    private int pageSize;

    public Page() {
        this(0, null, null, false, 0, false, 63, null);
    }

    public static /* synthetic */ Page copy$default(Page page, int i10, String str, String str2, boolean z10, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = page.page;
        }
        if ((i12 & 2) != 0) {
            str = page.currentPageCursor;
        }
        String str3 = str;
        if ((i12 & 4) != 0) {
            str2 = page.nextPageCursor;
        }
        String str4 = str2;
        if ((i12 & 8) != 0) {
            z10 = page.hasNextPage;
        }
        boolean z12 = z10;
        if ((i12 & 16) != 0) {
            i11 = page.pageSize;
        }
        int i13 = i11;
        if ((i12 & 32) != 0) {
            z11 = page.loadError;
        }
        return page.copy(i10, str3, str4, z12, i13, z11);
    }

    /* renamed from: component1, reason: from getter */
    public final int getPage() {
        return this.page;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getCurrentPageCursor() {
        return this.currentPageCursor;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getNextPageCursor() {
        return this.nextPageCursor;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    /* renamed from: component5, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getLoadError() {
        return this.loadError;
    }

    @NotNull
    public final Page copy(int page, @Nullable String currentPageCursor, @Nullable String nextPageCursor, boolean hasNextPage, int pageSize, boolean loadError) {
        return new Page(page, currentPageCursor, nextPageCursor, hasNextPage, pageSize, loadError);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Page)) {
            return false;
        }
        Page page = (Page) other;
        return this.page == page.page && Intrinsics.areEqual(this.currentPageCursor, page.currentPageCursor) && Intrinsics.areEqual(this.nextPageCursor, page.nextPageCursor) && this.hasNextPage == page.hasNextPage && this.pageSize == page.pageSize && this.loadError == page.loadError;
    }

    @Nullable
    public final String getCurrentPageCursor() {
        return this.currentPageCursor;
    }

    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    public final boolean getLoadError() {
        return this.loadError;
    }

    @Nullable
    public final String getNextPageCursor() {
        return this.nextPageCursor;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public int hashCode() {
        int i10 = this.page * 31;
        String str = this.currentPageCursor;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nextPageCursor;
        return ((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + a.a(this.hasNextPage)) * 31) + this.pageSize) * 31) + a.a(this.loadError);
    }

    public final void setCurrentPageCursor(@Nullable String str) {
        this.currentPageCursor = str;
    }

    public final void setHasNextPage(boolean z10) {
        this.hasNextPage = z10;
    }

    public final void setLoadError(boolean z10) {
        this.loadError = z10;
    }

    public final void setNextPageCursor(@Nullable String str) {
        this.nextPageCursor = str;
    }

    public final void setPage(int i10) {
        this.page = i10;
    }

    public final void setPageSize(int i10) {
        this.pageSize = i10;
    }

    @NotNull
    public String toString() {
        return "Page(page=" + this.page + ", currentPageCursor=" + this.currentPageCursor + ", nextPageCursor=" + this.nextPageCursor + ", hasNextPage=" + this.hasNextPage + ", pageSize=" + this.pageSize + ", loadError=" + this.loadError + ")";
    }

    public Page(int i10, @Nullable String str, @Nullable String str2, boolean z10, int i11, boolean z11) {
        this.page = i10;
        this.currentPageCursor = str;
        this.nextPageCursor = str2;
        this.hasNextPage = z10;
        this.pageSize = i11;
        this.loadError = z11;
    }

    public /* synthetic */ Page(int i10, String str, String str2, boolean z10, int i11, boolean z11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? "" : str, (i12 & 4) == 0 ? str2 : "", (i12 & 8) != 0 ? true : z10, (i12 & 16) != 0 ? 10 : i11, (i12 & 32) != 0 ? false : z11);
    }
}

package com.qhqc.core.basic.rvadapter.data;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0016B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006HÆ\u0003J+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/data/PageData;", "T", "", "page", "Lcom/qhqc/core/basic/rvadapter/data/Page;", "data", "", "(Lcom/qhqc/core/basic/rvadapter/data/Page;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "getPage", "()Lcom/qhqc/core/basic/rvadapter/data/Page;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class PageData<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final List<T> data;

    @NotNull
    private final Page page;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u0005H\u0007J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/data/PageData$Companion;", "", "()V", "error", "Lcom/qhqc/core/basic/rvadapter/data/PageData;", "T", "page", "", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final <T> PageData<T> error() {
            return new PageData<>(new Page(-1, null, null, false, 0, true, 30, null), new ArrayList());
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final <T> PageData<T> error(int page) {
            return new PageData<>(new Page(page == 1 ? 1 : -1, null, null, false, 0, true, 30, null), new ArrayList());
        }
    }

    public PageData(@NotNull Page page, @Nullable List<T> list) {
        Intrinsics.checkNotNullParameter(page, "page");
        this.page = page;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageData copy$default(PageData pageData, Page page, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            page = pageData.page;
        }
        if ((i10 & 2) != 0) {
            list = pageData.data;
        }
        return pageData.copy(page, list);
    }

    @JvmStatic
    @NotNull
    public static final <T> PageData<T> error() {
        return INSTANCE.error();
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final Page getPage() {
        return this.page;
    }

    @Nullable
    public final List<T> component2() {
        return this.data;
    }

    @NotNull
    public final PageData<T> copy(@NotNull Page page, @Nullable List<T> data) {
        Intrinsics.checkNotNullParameter(page, "page");
        return new PageData<>(page, data);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageData)) {
            return false;
        }
        PageData pageData = (PageData) other;
        return Intrinsics.areEqual(this.page, pageData.page) && Intrinsics.areEqual(this.data, pageData.data);
    }

    @Nullable
    public final List<T> getData() {
        return this.data;
    }

    @NotNull
    public final Page getPage() {
        return this.page;
    }

    public int hashCode() {
        int hashCode = this.page.hashCode() * 31;
        List<T> list = this.data;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        return "PageData(page=" + this.page + ", data=" + this.data + ")";
    }

    @JvmStatic
    @NotNull
    public static final <T> PageData<T> error(int i10) {
        return INSTANCE.error(i10);
    }
}

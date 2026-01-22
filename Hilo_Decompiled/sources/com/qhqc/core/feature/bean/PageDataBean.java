package com.qhqc.core.feature.bean;

import com.qhqc.core.basic.rvadapter.data.Page;
import com.qhqc.core.basic.rvadapter.data.PageData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0006R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/qhqc/core/feature/bean/PageDataBean;", "T", "", "<init>", "()V", "pageCursor", "", "getPageCursor", "()Ljava/lang/String;", "setPageCursor", "(Ljava/lang/String;)V", "hasNextPage", "", "getHasNextPage", "()Z", "setHasNextPage", "(Z)V", "data", "", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "total", "", "getTotal", "()I", "setTotal", "(I)V", "toPageData", "Lcom/qhqc/core/basic/rvadapter/data/PageData;", "page", "currentPageCursor", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class PageDataBean<T> {

    @Nullable
    private List<T> data;
    private boolean hasNextPage;

    @Nullable
    private String pageCursor;
    private int total;

    public static /* synthetic */ PageData toPageData$default(PageDataBean pageDataBean, int i10, String str, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                i10 = 1;
            }
            return pageDataBean.toPageData(i10, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toPageData");
    }

    @Nullable
    public final List<T> getData() {
        return this.data;
    }

    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    @Nullable
    public final String getPageCursor() {
        return this.pageCursor;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setData(@Nullable List<T> list) {
        this.data = list;
    }

    public final void setHasNextPage(boolean z10) {
        this.hasNextPage = z10;
    }

    public final void setPageCursor(@Nullable String str) {
        this.pageCursor = str;
    }

    public final void setTotal(int i10) {
        this.total = i10;
    }

    @NotNull
    public final PageData<T> toPageData(int page, @Nullable String currentPageCursor) {
        return new PageData<>(new Page(page, currentPageCursor, this.pageCursor, this.hasNextPage, 0, false, 48, null), this.data);
    }
}

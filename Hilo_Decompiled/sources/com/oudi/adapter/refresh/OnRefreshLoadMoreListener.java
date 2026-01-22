package com.oudi.adapter.refresh;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/oudi/adapter/refresh/OnRefreshLoadMoreListener;", "Lcom/oudi/adapter/refresh/OnRefreshListener;", "Lcom/oudi/adapter/refresh/OnLoadMoreListener;", "onRefresh", "", "onLoadMore", "lib_adapter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface OnRefreshLoadMoreListener extends OnRefreshListener, OnLoadMoreListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        public static void onLoadMore(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        }

        public static void onRefresh(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        }
    }

    @Override // com.oudi.adapter.refresh.OnLoadMoreListener
    void onLoadMore();

    @Override // com.oudi.adapter.refresh.OnRefreshListener
    void onRefresh();
}

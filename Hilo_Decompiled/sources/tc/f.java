package tc;

import android.view.ViewGroup;
import vc.g;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface f {
    f finishLoadMore();

    f finishRefresh();

    f finishRefresh(int i);

    ViewGroup getLayout();

    f setDisableContentWhenRefresh(boolean z);

    f setEnableNestedScroll(boolean z);

    f setHeaderInsetStart(float f);

    f setHeaderTriggerRate(float f);

    f setNoMoreData(boolean z);

    f setOnLoadMoreListener(vc.e eVar);

    f setOnRefreshListener(g gVar);
}

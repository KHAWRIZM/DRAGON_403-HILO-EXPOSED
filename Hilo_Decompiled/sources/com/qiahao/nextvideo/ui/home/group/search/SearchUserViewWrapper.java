package com.qiahao.nextvideo.ui.home.group.search;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewSearchChildUserBinding;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapperDelegate;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 '2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0013J\"\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0013H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/search/SearchUserViewWrapper;", "Landroid/widget/FrameLayout;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapperDelegate;", "Lcom/qiahao/base_common/model/common/User;", "context", "Landroid/content/Context;", "searchGroupOrUserViewControl", "Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupOrUserViewControl;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupOrUserViewControl;)V", "getSearchGroupOrUserViewControl", "()Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupOrUserViewControl;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewSearchChildUserBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewSearchChildUserBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewSearchChildUserBinding;)V", "mCode", "", "getMCode", "()Ljava/lang/String;", "setMCode", "(Ljava/lang/String;)V", "searchUserViewItemListWrapper", "Lcom/qiahao/nextvideo/ui/home/group/search/SearchUserViewItemListWrapper;", "getSearchUserViewItemListWrapper", "()Lcom/qiahao/nextvideo/ui/home/group/search/SearchUserViewItemListWrapper;", "setSearchUserViewItemListWrapper", "(Lcom/qiahao/nextvideo/ui/home/group/search/SearchUserViewItemListWrapper;)V", "getNetDataAndInitView", "", "getData", Constants.KEY_HTTP_CODE, "listViewControllerOnItemSelected", "item", "position", "", "clickTag", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SearchUserViewWrapper extends FrameLayout implements ItemListViewWrapperDelegate<User> {

    @NotNull
    private static final String TAG = "PopularViewWrapper";

    @NotNull
    private String mCode;
    public ViewSearchChildUserBinding mDataBinding;

    @NotNull
    private final SearchGroupOrUserViewControl searchGroupOrUserViewControl;

    @Nullable
    private SearchUserViewItemListWrapper searchUserViewItemListWrapper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserViewWrapper(@NotNull Context context, @NotNull SearchGroupOrUserViewControl searchGroupOrUserViewControl) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(searchGroupOrUserViewControl, "searchGroupOrUserViewControl");
        this.searchGroupOrUserViewControl = searchGroupOrUserViewControl;
        getNetDataAndInitView();
        this.mCode = "";
    }

    private final void getNetDataAndInitView() {
        Log.d(TAG, "getNetDataAndInitView: ");
        setMDataBinding((ViewSearchChildUserBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_search_child_user, this, true));
        Log.d(TAG, "getNetDataAndInitView:----- ");
    }

    public final void getData(@NotNull String code) {
        SmartRefreshLayout swipeToRefreshView;
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        this.mCode = code;
        SearchUserViewItemListWrapper searchUserViewItemListWrapper = this.searchUserViewItemListWrapper;
        if (searchUserViewItemListWrapper == null) {
            View root = getMDataBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            SearchUserViewItemListWrapper searchUserViewItemListWrapper2 = new SearchUserViewItemListWrapper(root, this.mCode);
            searchUserViewItemListWrapper2.getRecyclerView();
            searchUserViewItemListWrapper2.setDelegate(this);
            this.searchUserViewItemListWrapper = searchUserViewItemListWrapper2;
            return;
        }
        if (searchUserViewItemListWrapper != null) {
            searchUserViewItemListWrapper.setMCode(code);
        }
        SearchUserViewItemListWrapper searchUserViewItemListWrapper3 = this.searchUserViewItemListWrapper;
        if (searchUserViewItemListWrapper3 != null && (swipeToRefreshView = searchUserViewItemListWrapper3.getSwipeToRefreshView()) != null) {
            swipeToRefreshView.autoRefresh();
        }
    }

    @NotNull
    public final String getMCode() {
        return this.mCode;
    }

    @NotNull
    public final ViewSearchChildUserBinding getMDataBinding() {
        ViewSearchChildUserBinding viewSearchChildUserBinding = this.mDataBinding;
        if (viewSearchChildUserBinding != null) {
            return viewSearchChildUserBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @NotNull
    public final SearchGroupOrUserViewControl getSearchGroupOrUserViewControl() {
        return this.searchGroupOrUserViewControl;
    }

    @Nullable
    public final SearchUserViewItemListWrapper getSearchUserViewItemListWrapper() {
        return this.searchUserViewItemListWrapper;
    }

    public final void setMCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCode = str;
    }

    public final void setMDataBinding(@NotNull ViewSearchChildUserBinding viewSearchChildUserBinding) {
        Intrinsics.checkNotNullParameter(viewSearchChildUserBinding, "<set-?>");
        this.mDataBinding = viewSearchChildUserBinding;
    }

    public final void setSearchUserViewItemListWrapper(@Nullable SearchUserViewItemListWrapper searchUserViewItemListWrapper) {
        this.searchUserViewItemListWrapper = searchUserViewItemListWrapper;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapperDelegate
    public void listViewControllerOnItemSelected(@NotNull User item, int position, @Nullable String clickTag) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.searchGroupOrUserViewControl.hideoftKeyBoard();
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            service.openPersonPage(item.getExternalId());
        }
    }
}

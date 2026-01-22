package com.qiahao.nextvideo.ui.home.group.search;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.SearchGroupBean;
import com.qiahao.nextvideo.databinding.ViewSearchChildGroupBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapperDelegate;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 '2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0013J\"\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0013H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupViewWrapper;", "Landroid/widget/FrameLayout;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapperDelegate;", "Lcom/qiahao/nextvideo/data/model/SearchGroupBean;", "context", "Landroid/content/Context;", "searchGroupOrUserViewControl", "Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupOrUserViewControl;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupOrUserViewControl;)V", "getSearchGroupOrUserViewControl", "()Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupOrUserViewControl;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewSearchChildGroupBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewSearchChildGroupBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewSearchChildGroupBinding;)V", "mCode", "", "getMCode", "()Ljava/lang/String;", "setMCode", "(Ljava/lang/String;)V", "initView", "", "searchGroupViewItem", "Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupViewItemListWrapper;", "getSearchGroupViewItem", "()Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupViewItemListWrapper;", "setSearchGroupViewItem", "(Lcom/qiahao/nextvideo/ui/home/group/search/SearchGroupViewItemListWrapper;)V", "getData", Constants.KEY_HTTP_CODE, "listViewControllerOnItemSelected", "item", "position", "", "clickTag", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SearchGroupViewWrapper extends FrameLayout implements ItemListViewWrapperDelegate<SearchGroupBean> {

    @NotNull
    private static final String TAG = "PopularViewWrapper";

    @NotNull
    private String mCode;
    public ViewSearchChildGroupBinding mDataBinding;

    @NotNull
    private final SearchGroupOrUserViewControl searchGroupOrUserViewControl;

    @Nullable
    private SearchGroupViewItemListWrapper searchGroupViewItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchGroupViewWrapper(@NotNull Context context, @NotNull SearchGroupOrUserViewControl searchGroupOrUserViewControl) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(searchGroupOrUserViewControl, "searchGroupOrUserViewControl");
        this.searchGroupOrUserViewControl = searchGroupOrUserViewControl;
        this.mCode = "";
        initView();
    }

    private final void initView() {
        Log.d(TAG, "getNetDataAndInitView: ");
        setMDataBinding((ViewSearchChildGroupBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_search_child_group, this, true));
        Log.d(TAG, "getNetDataAndInitView:----- ");
    }

    public final void getData(@NotNull String code) {
        SmartRefreshLayout swipeToRefreshView;
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        this.mCode = code;
        SearchGroupViewItemListWrapper searchGroupViewItemListWrapper = this.searchGroupViewItem;
        if (searchGroupViewItemListWrapper == null) {
            View root = getMDataBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            SearchGroupViewItemListWrapper searchGroupViewItemListWrapper2 = new SearchGroupViewItemListWrapper(root, this.mCode);
            searchGroupViewItemListWrapper2.getRecyclerView();
            searchGroupViewItemListWrapper2.setDelegate(this);
            this.searchGroupViewItem = searchGroupViewItemListWrapper2;
            return;
        }
        if (searchGroupViewItemListWrapper != null) {
            searchGroupViewItemListWrapper.setMCode(code);
        }
        SearchGroupViewItemListWrapper searchGroupViewItemListWrapper3 = this.searchGroupViewItem;
        if (searchGroupViewItemListWrapper3 != null && (swipeToRefreshView = searchGroupViewItemListWrapper3.getSwipeToRefreshView()) != null) {
            swipeToRefreshView.autoRefresh();
        }
    }

    @NotNull
    public final String getMCode() {
        return this.mCode;
    }

    @NotNull
    public final ViewSearchChildGroupBinding getMDataBinding() {
        ViewSearchChildGroupBinding viewSearchChildGroupBinding = this.mDataBinding;
        if (viewSearchChildGroupBinding != null) {
            return viewSearchChildGroupBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @NotNull
    public final SearchGroupOrUserViewControl getSearchGroupOrUserViewControl() {
        return this.searchGroupOrUserViewControl;
    }

    @Nullable
    public final SearchGroupViewItemListWrapper getSearchGroupViewItem() {
        return this.searchGroupViewItem;
    }

    public final void setMCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCode = str;
    }

    public final void setMDataBinding(@NotNull ViewSearchChildGroupBinding viewSearchChildGroupBinding) {
        Intrinsics.checkNotNullParameter(viewSearchChildGroupBinding, "<set-?>");
        this.mDataBinding = viewSearchChildGroupBinding;
    }

    public final void setSearchGroupViewItem(@Nullable SearchGroupViewItemListWrapper searchGroupViewItemListWrapper) {
        this.searchGroupViewItem = searchGroupViewItemListWrapper;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapperDelegate
    public void listViewControllerOnItemSelected(@NotNull SearchGroupBean item, int position, @Nullable String clickTag) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (FastClickOneUtils.INSTANCE.isFastClick()) {
            this.searchGroupOrUserViewControl.hideoftKeyBoard();
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, item.getGroupId(), item.getCode(), item.getFaceUrl(), item.getName(), Boolean.valueOf(item.getHasPassWord()), item.getCountryIcon(), item.getIntroduction(), item.getNotification(), 0, 0, null, 0, false, 7936, null);
        }
    }
}

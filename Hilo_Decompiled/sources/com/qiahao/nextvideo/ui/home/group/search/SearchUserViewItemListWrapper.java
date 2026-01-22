package com.qiahao.nextvideo.ui.home.group.search;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemSearchUserViewBinding;
import com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000eH\u0016J \u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u000eH\u0016J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006,"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/search/SearchUserViewItemListWrapper;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ItemListViewWrapper;", "Lcom/qiahao/base_common/model/common/User;", "view", "Landroid/view/View;", "mCode", "", "<init>", "(Landroid/view/View;Ljava/lang/String;)V", "getMCode", "()Ljava/lang/String;", "setMCode", "(Ljava/lang/String;)V", Constants.KEY_MODEL, "", "lastIndex", "nextPage", "pageSize", "getPageSize", "()I", "setPageSize", "(I)V", "firstIndex", "getFirstIndex", "setFirstIndex", "maxSize", "getMaxSize", "setMaxSize", "currentSize", "getCurrentSize", "setCurrentSize", "doCreateItemViewHolder", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "doBindItemViewHolder", "", "holder", "item", "position", "doLoadNextPage", "pageIndex", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchUserViewItemListWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchUserViewItemListWrapper.kt\ncom/qiahao/nextvideo/ui/home/group/search/SearchUserViewItemListWrapper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,152:1\n1#2:153\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SearchUserViewItemListWrapper extends ItemListViewWrapper<User> {

    @NotNull
    private static final String TAG = "SearchGroupViewItemList";
    private int currentSize;
    private int firstIndex;
    private int lastIndex;

    @NotNull
    private String mCode;
    private int maxSize;
    private int model;
    private int nextPage;
    private int pageSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserViewItemListWrapper(@NotNull View view, @NotNull String str) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "mCode");
        this.mCode = str;
        this.nextPage = 1;
        this.pageSize = 10;
        this.firstIndex = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$1(SearchUserViewItemListWrapper searchUserViewItemListWrapper, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        searchUserViewItemListWrapper.maxSize = 0;
        ArrayList arrayList = new ArrayList();
        User user = (User) apiResponse.getData();
        if (user != null) {
            arrayList.add(user);
        }
        int pageSize = searchUserViewItemListWrapper.currentSize + searchUserViewItemListWrapper.getPageSize();
        searchUserViewItemListWrapper.currentSize = pageSize;
        if (pageSize < searchUserViewItemListWrapper.maxSize) {
            int i2 = searchUserViewItemListWrapper.nextPage + 1;
            searchUserViewItemListWrapper.nextPage = i2;
            searchUserViewItemListWrapper.fillInItemsByPageIndex(arrayList, i, i2);
        } else {
            searchUserViewItemListWrapper.fillInItemsByPageIndex(arrayList, i, -1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doLoadNextPage$lambda$2(SearchUserViewItemListWrapper searchUserViewItemListWrapper, int i, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        searchUserViewItemListWrapper.fillInItemsByPageIndex(new ArrayList(), i, -1);
        searchUserViewItemListWrapper.maxSize = 0;
        searchUserViewItemListWrapper.onError(th);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    @NotNull
    public ViewHolder doCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Log.d(TAG, "doCreateItemViewHolder: ---");
        ItemSearchUserViewBinding inflate = ItemSearchUserViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SearchUserItemViewHolder(inflate);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void doLoadNextPage(final int pageIndex) {
        Log.d(TAG, "doLoadNextPage: ---");
        if (pageIndex == 1) {
            this.nextPage = 1;
            this.model = 0;
            this.lastIndex = 0;
            this.firstIndex = -1;
            this.currentSize = 0;
        }
        RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().findUserByCode(this.mCode), new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.search.g
            public final Object invoke(Object obj) {
                Unit doLoadNextPage$lambda$1;
                doLoadNextPage$lambda$1 = SearchUserViewItemListWrapper.doLoadNextPage$lambda$1(SearchUserViewItemListWrapper.this, pageIndex, (ApiResponse) obj);
                return doLoadNextPage$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.search.h
            public final Object invoke(Object obj) {
                Unit doLoadNextPage$lambda$2;
                doLoadNextPage$lambda$2 = SearchUserViewItemListWrapper.doLoadNextPage$lambda$2(SearchUserViewItemListWrapper.this, pageIndex, (Throwable) obj);
                return doLoadNextPage$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    public final int getCurrentSize() {
        return this.currentSize;
    }

    public final int getFirstIndex() {
        return this.firstIndex;
    }

    @NotNull
    public final String getMCode() {
        return this.mCode;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public int getPageSize() {
        return this.pageSize;
    }

    public final void setCurrentSize(int i) {
        this.currentSize = i;
    }

    public final void setFirstIndex(int i) {
        this.firstIndex = i;
    }

    public final void setMCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCode = str;
    }

    public final void setMaxSize(int i) {
        this.maxSize = i;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void setPageSize(int i) {
        this.pageSize = i;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.views.list.ItemListViewWrapper
    public void doBindItemViewHolder(@NotNull ViewHolder holder, @NotNull User item, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Log.d(TAG, "doBindItemViewHolder: ---");
        ((RecyclerView.ViewHolder) holder).itemView.setTag(R.id.id_item_position, Integer.valueOf(position));
        ((SearchUserItemViewHolder) holder).bind(item);
    }
}

package com.qhqc.core.feature.community.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.basic.rvadapter.data.Page;
import com.qhqc.core.basic.rvadapter.data.PageData;
import com.qhqc.core.basic.widget.toolbar.CommonToolbar;
import com.qhqc.core.basic.widget.toolbar.ICommonToolbar;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsLikeBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.IUserEvents;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.data.viewmodel.PostsLikeListViewModel;
import com.qhqc.core.feature.community.databinding.FeatureCommunityActivityPostsLikeUserListBinding;
import com.qhqc.core.feature.community.events.CommentEvent;
import com.qhqc.core.feature.community.events.IEventsCallback;
import com.qhqc.core.feature.community.events.PostsEvent;
import com.qhqc.core.feature.community.events.UserOperateEvent;
import com.qhqc.core.feature.community.ui.adapter.PostsLikeListAdapter;
import com.qhqc.core.feature.uiframe.BaseModelActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0018B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0014R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/qhqc/core/feature/community/ui/activity/PostsLikeUserListActivity;", "Lcom/qhqc/core/feature/uiframe/BaseModelActivity;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityActivityPostsLikeUserListBinding;", "Lcom/qhqc/core/feature/community/data/viewmodel/PostsLikeListViewModel;", "Lcom/qhqc/core/feature/community/events/IEventsCallback;", "<init>", "()V", "mLikeListAdapter", "Lcom/qhqc/core/feature/community/ui/adapter/PostsLikeListAdapter;", "getMLikeListAdapter", "()Lcom/qhqc/core/feature/community/ui/adapter/PostsLikeListAdapter;", "mLikeListAdapter$delegate", "Lkotlin/Lazy;", "onCreateCommonToolbar", "Lcom/qhqc/core/basic/widget/toolbar/ICommonToolbar;", "onInit", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onUserEvent", "event", "Lcom/qhqc/core/feature/community/events/UserOperateEvent;", "onDestroy", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsLikeUserListActivity extends BaseModelActivity<FeatureCommunityActivityPostsLikeUserListBinding, PostsLikeListViewModel> implements IEventsCallback {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: mLikeListAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLikeListAdapter = LazyKt.lazy(new Function0() { // from class: com.qhqc.core.feature.community.ui.activity.u
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PostsLikeListAdapter mLikeListAdapter_delegate$lambda$0;
            mLikeListAdapter_delegate$lambda$0 = PostsLikeUserListActivity.mLikeListAdapter_delegate$lambda$0();
            return mLikeListAdapter_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Lcom/qhqc/core/feature/community/ui/activity/PostsLikeUserListActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", ShareConstants.RESULT_POST_ID, "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @Nullable String postId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent putExtra = new Intent(context, (Class<?>) PostsLikeUserListActivity.class).putExtra(ShareConstants.RESULT_POST_ID, postId);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            context.startActivity(putExtra);
        }

        private Companion() {
        }
    }

    private final PostsLikeListAdapter getMLikeListAdapter() {
        return (PostsLikeListAdapter) this.mLikeListAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(PostsLikeUserListActivity postsLikeUserListActivity, PageData pageData) {
        PostsLikeListAdapter mLikeListAdapter = postsLikeUserListActivity.getMLikeListAdapter();
        Intrinsics.checkNotNull(pageData);
        mLikeListAdapter.addPageDataWithCursor(pageData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PostsLikeListAdapter mLikeListAdapter_delegate$lambda$0() {
        return new PostsLikeListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.qhqc.core.basic.uiframe.viewmodel.BaseViewModel, androidx.lifecycle.ViewModel] */
    public static final void onInit$lambda$2(PostsLikeUserListActivity postsLikeUserListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        IUserEvents mUserEventsImpl;
        UserInfoBean user;
        UserInfoBean user2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        PostsLikeBean item = postsLikeUserListActivity.getMLikeListAdapter().getItem(i10);
        int id = view.getId();
        if (id == R.id.mIvAvatar) {
            IUserEvents mUserEventsImpl2 = CommunityManager.INSTANCE.getInstance().getMUserEventsImpl();
            if (mUserEventsImpl2 != null && (user2 = item.getUser()) != null) {
                mUserEventsImpl2.onUserClick(user2, view);
                return;
            }
            return;
        }
        if (id == R.id.mBtnFollowUser && (mUserEventsImpl = CommunityManager.INSTANCE.getInstance().getMUserEventsImpl()) != null && (user = item.getUser()) != null) {
            mUserEventsImpl.onFollowUserClick(user, view, ViewModelKt.getViewModelScope(postsLikeUserListActivity.m٥٢١getViewModel()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onInit$lambda$3(PostsLikeUserListActivity postsLikeUserListActivity, Page it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ((PostsLikeListViewModel) postsLikeUserListActivity.m٥٢١getViewModel()).getLikeList(it.getNextPageCursor());
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @Nullable String str) {
        INSTANCE.start(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void initData() {
        super.initData();
        ((PostsLikeListViewModel) m٥٢١getViewModel()).getLikeListLiveData().observe(this, new PostsLikeUserListActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = PostsLikeUserListActivity.initData$lambda$4(PostsLikeUserListActivity.this, (PageData) obj);
                return initData$lambda$4;
            }
        }));
        getMLikeListAdapter().loadData();
    }

    @Override // com.qhqc.core.feature.community.events.IEventsCallback
    public void onCommentEvent(@NotNull CommentEvent commentEvent) {
        IEventsCallback.DefaultImpls.onCommentEvent(this, commentEvent);
    }

    @Override // com.qhqc.core.feature.uiframe.BaseModelActivity
    @NotNull
    protected ICommonToolbar onCreateCommonToolbar() {
        return new CommonToolbar.Builder().setTitle(R.string.feature_community_posts_like_list).build(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CommunityManager.INSTANCE.getInstance().removeHandler$feature_community_release(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void onInit(@Nullable Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        CommunityManager.INSTANCE.getInstance().addEventHandler$feature_community_release(this);
        PostsLikeListViewModel postsLikeListViewModel = (PostsLikeListViewModel) m٥٢١getViewModel();
        String stringExtra = getIntent().getStringExtra(ShareConstants.RESULT_POST_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        postsLikeListViewModel.setPostId(stringExtra);
        ((FeatureCommunityActivityPostsLikeUserListBinding) getBinding()).mRV.setLayoutManager(new LinearLayoutManager(this));
        ((FeatureCommunityActivityPostsLikeUserListBinding) getBinding()).mRV.setAdapter(getMLikeListAdapter());
        getMLikeListAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.w
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                PostsLikeUserListActivity.onInit$lambda$2(PostsLikeUserListActivity.this, baseQuickAdapter, view, i10);
            }
        });
        getMLikeListAdapter().setOnDataLoad(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit onInit$lambda$3;
                onInit$lambda$3 = PostsLikeUserListActivity.onInit$lambda$3(PostsLikeUserListActivity.this, (Page) obj);
                return onInit$lambda$3;
            }
        });
    }

    @Override // com.qhqc.core.feature.community.events.IEventsCallback
    public void onPostsEvent(@NotNull PostsEvent postsEvent) {
        IEventsCallback.DefaultImpls.onPostsEvent(this, postsEvent);
    }

    @Override // com.qhqc.core.feature.community.events.IEventsCallback
    public void onUserEvent(@NotNull UserOperateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getEvent() == 12289) {
            int size = getMLikeListAdapter().getData().size();
            for (int i10 = 0; i10 < size; i10++) {
                UserInfoBean user = getMLikeListAdapter().getData().get(i10).getUser();
                if (user != null && user.getId() == event.getUser().getId()) {
                    getMLikeListAdapter().getData().get(i10).setFollowUser(true);
                    getMLikeListAdapter().notifyItemChangedAt(i10, Integer.valueOf(event.getEvent()));
                }
            }
        }
    }
}

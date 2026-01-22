package com.qhqc.core.feature.community.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qhqc.core.basic.rvadapter.data.Page;
import com.qhqc.core.basic.rvadapter.data.PageData;
import com.qhqc.core.basic.widget.toolbar.CommonToolbar;
import com.qhqc.core.basic.widget.toolbar.ICommonToolbar;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsNoticeBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.IUserEvents;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.data.viewmodel.PostsNoticeViewModel;
import com.qhqc.core.feature.community.databinding.FeatureCommunityActivityPostsNoticeBinding;
import com.qhqc.core.feature.community.ui.adapter.PostNewestUserListAdapter;
import com.qhqc.core.feature.community.ui.adapter.PostsNoticeListAdapter;
import com.qhqc.core.feature.uiframe.BaseModelActivity;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0014R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/qhqc/core/feature/community/ui/activity/PostsNoticeActivity;", "Lcom/qhqc/core/feature/uiframe/BaseModelActivity;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityActivityPostsNoticeBinding;", "Lcom/qhqc/core/feature/community/data/viewmodel/PostsNoticeViewModel;", "<init>", "()V", "mNoticeAdapter", "Lcom/qhqc/core/feature/community/ui/adapter/PostsNoticeListAdapter;", "getMNoticeAdapter", "()Lcom/qhqc/core/feature/community/ui/adapter/PostsNoticeListAdapter;", "mNoticeAdapter$delegate", "Lkotlin/Lazy;", "newestUserListAdapter", "Lcom/qhqc/core/feature/community/ui/adapter/PostNewestUserListAdapter;", "getNewestUserListAdapter", "()Lcom/qhqc/core/feature/community/ui/adapter/PostNewestUserListAdapter;", "newestUserListAdapter$delegate", "onCreateCommonToolbar", "Lcom/qhqc/core/basic/widget/toolbar/ICommonToolbar;", "onInit", "", "savedInstanceState", "Landroid/os/Bundle;", "initEvent", "initData", "onDestroy", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsNoticeActivity extends BaseModelActivity<FeatureCommunityActivityPostsNoticeBinding, PostsNoticeViewModel> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: mNoticeAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mNoticeAdapter = LazyKt.lazy(new Function0() { // from class: com.qhqc.core.feature.community.ui.activity.y
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PostsNoticeListAdapter mNoticeAdapter_delegate$lambda$0;
            mNoticeAdapter_delegate$lambda$0 = PostsNoticeActivity.mNoticeAdapter_delegate$lambda$0();
            return mNoticeAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: newestUserListAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy newestUserListAdapter = LazyKt.lazy(new Function0() { // from class: com.qhqc.core.feature.community.ui.activity.z
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PostNewestUserListAdapter newestUserListAdapter_delegate$lambda$1;
            newestUserListAdapter_delegate$lambda$1 = PostsNoticeActivity.newestUserListAdapter_delegate$lambda$1();
            return newestUserListAdapter_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/qhqc/core/feature/community/ui/activity/PostsNoticeActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) PostsNoticeActivity.class));
        }

        private Companion() {
        }
    }

    private final PostsNoticeListAdapter getMNoticeAdapter() {
        return (PostsNoticeListAdapter) this.mNoticeAdapter.getValue();
    }

    private final PostNewestUserListAdapter getNewestUserListAdapter() {
        return (PostNewestUserListAdapter) this.newestUserListAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$10(PostsNoticeActivity postsNoticeActivity, String str) {
        if (Intrinsics.areEqual(str, "emptyList")) {
            Log.e("emptyList", "emptyList");
            ((FeatureCommunityActivityPostsNoticeBinding) postsNoticeActivity.getBinding()).mRV.setVisibility(8);
            ((FeatureCommunityActivityPostsNoticeBinding) postsNoticeActivity.getBinding()).recentContainer.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$12(PostsNoticeActivity postsNoticeActivity, ArrayList arrayList) {
        if (arrayList != null) {
            postsNoticeActivity.getNewestUserListAdapter().setList(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$9(PostsNoticeActivity postsNoticeActivity, PageData pageData) {
        ((FeatureCommunityActivityPostsNoticeBinding) postsNoticeActivity.getBinding()).mRV.setVisibility(0);
        ((FeatureCommunityActivityPostsNoticeBinding) postsNoticeActivity.getBinding()).recentContainer.setVisibility(8);
        PostsNoticeListAdapter mNoticeAdapter = postsNoticeActivity.getMNoticeAdapter();
        Intrinsics.checkNotNull(pageData);
        mNoticeAdapter.addPageDataWithCursor(pageData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEvent$lambda$5(PostsNoticeActivity postsNoticeActivity, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        PostsDetailsActivity.INSTANCE.startFromNotice(postsNoticeActivity, postsNoticeActivity.getMNoticeAdapter().getItem(i10).getId(), CommunityManager.INSTANCE.getInstance().getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEvent$lambda$7(PostsNoticeActivity postsNoticeActivity, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        IUserEvents mUserEventsImpl;
        UserInfoBean user;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        PostsNoticeBean item = postsNoticeActivity.getMNoticeAdapter().getItem(i10);
        int id = view.getId();
        if ((id == R.id.mIvAvatar || id == R.id.mViewInfos) && (mUserEventsImpl = CommunityManager.INSTANCE.getInstance().getMUserEventsImpl()) != null && (user = item.getUser()) != null) {
            mUserEventsImpl.onUserClick(user, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEvent$lambda$8(PostsNoticeActivity postsNoticeActivity, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        CommunityManager.Companion companion = CommunityManager.INSTANCE;
        Function0<Unit> noticeGoToPlazaClick = companion.getInstance().getNoticeGoToPlazaClick();
        if (noticeGoToPlazaClick != null) {
            noticeGoToPlazaClick.invoke();
        }
        companion.getInstance().setNoticeGoToPlazaClick(null);
        postsNoticeActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PostsNoticeListAdapter mNoticeAdapter_delegate$lambda$0() {
        return new PostsNoticeListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PostNewestUserListAdapter newestUserListAdapter_delegate$lambda$1() {
        return new PostNewestUserListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onInit$lambda$2(PostsNoticeActivity postsNoticeActivity, Page it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ((PostsNoticeViewModel) postsNoticeActivity.m٥٢١getViewModel()).getNoticeList(it.getNextPageCursor());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInit$lambda$3(PostsNoticeActivity postsNoticeActivity, View view) {
        CommunityManager.Companion companion = CommunityManager.INSTANCE;
        Function0<Unit> noticeGoToPlazaClick = companion.getInstance().getNoticeGoToPlazaClick();
        if (noticeGoToPlazaClick != null) {
            noticeGoToPlazaClick.invoke();
        }
        companion.getInstance().setNoticeGoToPlazaClick(null);
        postsNoticeActivity.finish();
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void initData() {
        super.initData();
        ((PostsNoticeViewModel) m٥٢١getViewModel()).getNoticeListLiveData().observe(this, new PostsNoticeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initData$lambda$9;
                initData$lambda$9 = PostsNoticeActivity.initData$lambda$9(PostsNoticeActivity.this, (PageData) obj);
                return initData$lambda$9;
            }
        }));
        ((PostsNoticeViewModel) m٥٢١getViewModel()).getEmptyListLiveData().observe(this, new PostsNoticeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initData$lambda$10;
                initData$lambda$10 = PostsNoticeActivity.initData$lambda$10(PostsNoticeActivity.this, (String) obj);
                return initData$lambda$10;
            }
        }));
        ((PostsNoticeViewModel) m٥٢١getViewModel()).getPostNewestUserList().observe(this, new PostsNoticeActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initData$lambda$12;
                initData$lambda$12 = PostsNoticeActivity.initData$lambda$12(PostsNoticeActivity.this, (ArrayList) obj);
                return initData$lambda$12;
            }
        }));
        getMNoticeAdapter().loadData();
        ((PostsNoticeViewModel) m٥٢١getViewModel()).m٥٢٣getPostNewestUserList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void initEvent() {
        super.initEvent();
        getMNoticeAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.d0
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                PostsNoticeActivity.initEvent$lambda$5(PostsNoticeActivity.this, baseQuickAdapter, view, i10);
            }
        });
        getMNoticeAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.e0
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                PostsNoticeActivity.initEvent$lambda$7(PostsNoticeActivity.this, baseQuickAdapter, view, i10);
            }
        });
        getNewestUserListAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.f0
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                PostsNoticeActivity.initEvent$lambda$8(PostsNoticeActivity.this, baseQuickAdapter, view, i10);
            }
        });
    }

    @Override // com.qhqc.core.feature.uiframe.BaseModelActivity
    @NotNull
    protected ICommonToolbar onCreateCommonToolbar() {
        return new CommonToolbar.Builder().setTitle(R.string.plaza).build(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void onInit(@Nullable Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        ((FeatureCommunityActivityPostsNoticeBinding) getBinding()).mRV.setLayoutManager(new LinearLayoutManager(this));
        ((FeatureCommunityActivityPostsNoticeBinding) getBinding()).mRV.setAdapter(getMNoticeAdapter());
        getMNoticeAdapter().setOnDataLoad(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit onInit$lambda$2;
                onInit$lambda$2 = PostsNoticeActivity.onInit$lambda$2(PostsNoticeActivity.this, (Page) obj);
                return onInit$lambda$2;
            }
        });
        ((FeatureCommunityActivityPostsNoticeBinding) getBinding()).goToPlaza.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostsNoticeActivity.onInit$lambda$3(PostsNoticeActivity.this, view);
            }
        });
        ((FeatureCommunityActivityPostsNoticeBinding) getBinding()).recentRv.setAdapter(getNewestUserListAdapter());
    }
}

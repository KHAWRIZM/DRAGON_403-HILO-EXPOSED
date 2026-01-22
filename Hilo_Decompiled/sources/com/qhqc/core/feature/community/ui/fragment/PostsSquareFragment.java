package com.qhqc.core.feature.community.ui.fragment;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qhqc.core.basic.rvadapter.data.Page;
import com.qhqc.core.basic.rvadapter.data.PageData;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.Menu;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.MenuSelectDialog;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.CommunityUtils;
import com.qhqc.core.feature.community.IUserEvents;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.data.viewmodel.PostsSquareViewModel;
import com.qhqc.core.feature.community.databinding.FeatureCommunityFragmentPostsSquareBinding;
import com.qhqc.core.feature.community.events.CommentEvent;
import com.qhqc.core.feature.community.events.IEventsCallback;
import com.qhqc.core.feature.community.events.PostsEvent;
import com.qhqc.core.feature.community.events.UserOperateEvent;
import com.qhqc.core.feature.community.ui.activity.PostsCreateActivity;
import com.qhqc.core.feature.community.ui.activity.PostsDetailsActivity;
import com.qhqc.core.feature.community.ui.adapter.PostsListAdapter;
import com.qhqc.core.feature.community.ui.fragment.PostsSquareFragment;
import com.qhqc.core.feature.community.widget.CommunityAvatarView;
import com.qhqc.core.feature.community.widget.PostsContentView;
import com.qhqc.core.feature.uiframe.BaseModelFragment;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00029:B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0014J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J1\u0010)\u001a\u00020\u00182\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\b\u0010-\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/H\u0002¢\u0006\u0002\u00100J\u0006\u00101\u001a\u00020\u0018J\u0010\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00182\u0006\u00103\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0018H\u0016J\b\u00108\u001a\u00020\u0018H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006;"}, d2 = {"Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment;", "Lcom/qhqc/core/feature/uiframe/BaseModelFragment;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityFragmentPostsSquareBinding;", "Lcom/qhqc/core/feature/community/data/viewmodel/PostsSquareViewModel;", "Lcom/qhqc/core/feature/community/events/IEventsCallback;", "<init>", "()V", "mPostsAdapter", "Lcom/qhqc/core/feature/community/ui/adapter/PostsListAdapter;", "getMPostsAdapter", "()Lcom/qhqc/core/feature/community/ui/adapter/PostsListAdapter;", "mPostsAdapter$delegate", "Lkotlin/Lazy;", "mOnMenuListener", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog$OnMenuSelectedListener;", "mAnimator", "Landroid/animation/ValueAnimator;", "changePostBtnListener", "Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment$ChangePostCreateBtnStyleListener;", "getChangePostBtnListener", "()Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment$ChangePostCreateBtnStyleListener;", "setChangePostBtnListener", "(Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment$ChangePostCreateBtnStyleListener;)V", "onInit", "", "savedInstanceState", "Landroid/os/Bundle;", "initEvent", "dpToPx", "", "dp", "btnCreateAnim", LiveEvent.SHOW_ANIMATION, "", "cancelAnim", "initData", "changeAllLottieAnimations", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "type", "", "showMenusDialog", "menus", "", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "onMenuListener", "payload", "", "([Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog$OnMenuSelectedListener;Ljava/lang/Object;)V", "scrollToTop", "onPostsEvent", "event", "Lcom/qhqc/core/feature/community/events/PostsEvent;", "onUserEvent", "Lcom/qhqc/core/feature/community/events/UserOperateEvent;", "onFirstVisible", "onDestroyView", "Companion", "ChangePostCreateBtnStyleListener", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsSquareFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsSquareFragment.kt\ncom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,438:1\n256#2,2:439\n256#2,2:441\n*S KotlinDebug\n*F\n+ 1 PostsSquareFragment.kt\ncom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment\n*L\n70#1:439,2\n73#1:441,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsSquareFragment extends BaseModelFragment<FeatureCommunityFragmentPostsSquareBinding, PostsSquareViewModel> implements IEventsCallback {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private ChangePostCreateBtnStyleListener changePostBtnListener;

    @Nullable
    private ValueAnimator mAnimator;

    @Nullable
    private MenuSelectDialog.OnMenuSelectedListener mOnMenuListener;

    /* renamed from: mPostsAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPostsAdapter = LazyKt.lazy(new Function0() { // from class: com.qhqc.core.feature.community.ui.fragment.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PostsListAdapter mPostsAdapter_delegate$lambda$0;
            mPostsAdapter_delegate$lambda$0 = PostsSquareFragment.mPostsAdapter_delegate$lambda$0();
            return mPostsAdapter_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment$ChangePostCreateBtnStyleListener;", "", "showBtnAnim", "", "noShowBtnAnim", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface ChangePostCreateBtnStyleListener {
        void noShowBtnAnim();

        void showBtnAnim();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\u0007¨\u0006\u000f"}, d2 = {"Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment;", "type", "", "targetId", "", "getBundle", "Landroid/os/Bundle;", "getRecommendBundle", "getFollowBundle", "getTargetUserBundle", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Bundle getBundle$default(Companion companion, int i10, long j10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                j10 = 0;
            }
            return companion.getBundle(i10, j10);
        }

        public static /* synthetic */ Bundle getTargetUserBundle$default(Companion companion, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = 0;
            }
            return companion.getTargetUserBundle(i10);
        }

        public static /* synthetic */ PostsSquareFragment newInstance$default(Companion companion, int i10, long j10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                j10 = 0;
            }
            return companion.newInstance(i10, j10);
        }

        @NotNull
        public final Bundle getBundle(int type, long targetId) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", type);
            bundle.putLong("targetId", targetId);
            return bundle;
        }

        @NotNull
        public final Bundle getFollowBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 2);
            return bundle;
        }

        @NotNull
        public final Bundle getRecommendBundle() {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 1);
            return bundle;
        }

        @NotNull
        public final Bundle getTargetUserBundle(int targetId) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", 3);
            bundle.putInt("targetId", targetId);
            return bundle;
        }

        @NotNull
        public final PostsSquareFragment newInstance(int type, long targetId) {
            PostsSquareFragment postsSquareFragment = new PostsSquareFragment();
            postsSquareFragment.setArguments(PostsSquareFragment.INSTANCE.getBundle(type, targetId));
            return postsSquareFragment;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ PostsSquareViewModel access$getViewModel(PostsSquareFragment postsSquareFragment) {
        return (PostsSquareViewModel) postsSquareFragment.m٥٢٢getViewModel();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void btnCreateAnim(boolean isShow) {
        float f10 = 0.1f;
        if (isShow) {
            cancelAnim();
            if (((FeatureCommunityFragmentPostsSquareBinding) getBinding()).mIvPostsCreate.getAlpha() < 1.0f) {
                f10 = ((FeatureCommunityFragmentPostsSquareBinding) getBinding()).mIvPostsCreate.getAlpha();
            }
            this.mAnimator = ValueAnimator.ofFloat(f10, 1.0f);
        } else {
            cancelAnim();
            this.mAnimator = ValueAnimator.ofFloat(((FeatureCommunityFragmentPostsSquareBinding) getBinding()).mIvPostsCreate.getAlpha(), 0.1f);
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(500L);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qhqc.core.feature.community.ui.fragment.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    PostsSquareFragment.btnCreateAnim$lambda$6$lambda$5(PostsSquareFragment.this, valueAnimator2);
                }
            });
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void btnCreateAnim$lambda$6$lambda$5(PostsSquareFragment postsSquareFragment, ValueAnimator mVa) {
        Intrinsics.checkNotNullParameter(mVa, "mVa");
        AppCompatImageView appCompatImageView = ((FeatureCommunityFragmentPostsSquareBinding) postsSquareFragment.getBinding()).mIvPostsCreate;
        Object animatedValue = mVa.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        appCompatImageView.setAlpha(((Float) animatedValue).floatValue());
    }

    private final void cancelAnim() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.mAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.mAnimator = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeAllLottieAnimations(RecyclerView recyclerView, String type) {
        int findFirstVisibleItemPosition;
        int findLastVisibleItemPosition;
        CommunityAvatarView communityAvatarView;
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager == null || (findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        while (true) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
            if ((findViewHolderForAdapterPosition instanceof BaseViewHolder) && (communityAvatarView = (CommunityAvatarView) ((BaseViewHolder) findViewHolderForAdapterPosition).itemView.findViewById(R.id.mIvAvatar)) != null) {
                if (Intrinsics.areEqual(type, "pause")) {
                    communityAvatarView.getBinding().mIvOnlineState.C();
                } else {
                    communityAvatarView.getBinding().mIvOnlineState.E();
                }
            }
            if (findFirstVisibleItemPosition != findLastVisibleItemPosition) {
                findFirstVisibleItemPosition++;
            } else {
                return;
            }
        }
    }

    private final int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostsListAdapter getMPostsAdapter() {
        return (PostsListAdapter) this.mPostsAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$7(PostsSquareFragment postsSquareFragment, PageData pageData) {
        if (((FeatureCommunityFragmentPostsSquareBinding) postsSquareFragment.getBinding()).mRefreshLayout.isRefreshing()) {
            ((FeatureCommunityFragmentPostsSquareBinding) postsSquareFragment.getBinding()).mRefreshLayout.finishRefresh();
        }
        PostsListAdapter mPostsAdapter = postsSquareFragment.getMPostsAdapter();
        Intrinsics.checkNotNull(pageData);
        mPostsAdapter.addPageDataWithCursor(pageData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEvent$lambda$2(PostsSquareFragment postsSquareFragment, View view) {
        PostsCreateActivity.Companion companion = PostsCreateActivity.INSTANCE;
        Context requireContext = postsSquareFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.start(requireContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initEvent$lambda$3(PostsSquareFragment postsSquareFragment, Page page) {
        Intrinsics.checkNotNullParameter(page, "page");
        Log.e("pageCursor", String.valueOf(page.getNextPageCursor()));
        ((PostsSquareViewModel) postsSquareFragment.m٥٢٢getViewModel()).getPostsList(page.getNextPageCursor());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEvent$lambda$4(PostsSquareFragment postsSquareFragment, tc.f it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.finishRefresh(10000);
        postsSquareFragment.getMPostsAdapter().loadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PostsListAdapter mPostsAdapter_delegate$lambda$0() {
        return new PostsListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMenusDialog(Menu[] menus, MenuSelectDialog.OnMenuSelectedListener onMenuListener, Object payload) {
        new MenuSelectDialog().setMenus((Menu[]) Arrays.copyOf(menus, menus.length), onMenuListener).setPayload(payload).show(this);
    }

    static /* synthetic */ void showMenusDialog$default(PostsSquareFragment postsSquareFragment, Menu[] menuArr, MenuSelectDialog.OnMenuSelectedListener onMenuSelectedListener, Object obj, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            obj = null;
        }
        postsSquareFragment.showMenusDialog(menuArr, onMenuSelectedListener, obj);
    }

    @Nullable
    public final ChangePostCreateBtnStyleListener getChangePostBtnListener() {
        return this.changePostBtnListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMFragment
    public void initData() {
        super.initData();
        ((PostsSquareViewModel) m٥٢٢getViewModel()).getPostsListLiveData().observe(this, new PostsSquareFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qhqc.core.feature.community.ui.fragment.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = PostsSquareFragment.initData$lambda$7(PostsSquareFragment.this, (PageData) obj);
                return initData$lambda$7;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMFragment
    public void initEvent() {
        int i10;
        long j10;
        super.initEvent();
        CommunityManager.Companion companion = CommunityManager.INSTANCE;
        companion.getInstance().addEventHandler$feature_community_release(this);
        PostsSquareViewModel postsSquareViewModel = (PostsSquareViewModel) m٥٢٢getViewModel();
        Bundle arguments = getArguments();
        if (arguments != null) {
            i10 = arguments.getInt("type");
        } else {
            i10 = 1;
        }
        postsSquareViewModel.setPostsType(i10);
        PostsSquareViewModel postsSquareViewModel2 = (PostsSquareViewModel) m٥٢٢getViewModel();
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            j10 = arguments2.getLong("targetId");
        } else {
            j10 = 0;
        }
        postsSquareViewModel2.setTargetId(j10);
        if (((PostsSquareViewModel) m٥٢٢getViewModel()).getPostsType() == 3) {
            AppCompatImageView mIvPostsCreate = ((FeatureCommunityFragmentPostsSquareBinding) getBinding()).mIvPostsCreate;
            Intrinsics.checkNotNullExpressionValue(mIvPostsCreate, "mIvPostsCreate");
            mIvPostsCreate.setVisibility(8);
        } else {
            AppCompatImageView mIvPostsCreate2 = ((FeatureCommunityFragmentPostsSquareBinding) getBinding()).mIvPostsCreate;
            Intrinsics.checkNotNullExpressionValue(mIvPostsCreate2, "mIvPostsCreate");
            mIvPostsCreate2.setVisibility(8);
        }
        ((FeatureCommunityFragmentPostsSquareBinding) getBinding()).mIvPostsCreate.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.feature.community.ui.fragment.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostsSquareFragment.initEvent$lambda$2(PostsSquareFragment.this, view);
            }
        });
        this.mOnMenuListener = new PostsSquareFragment$initEvent$2(this);
        getMPostsAdapter().setOnViewClickListener(new PostsContentView.OnClickListener() { // from class: com.qhqc.core.feature.community.ui.fragment.PostsSquareFragment$initEvent$3
            @Override // com.qhqc.core.feature.community.widget.PostsContentView.OnClickListener
            public void onChildViewClick(View view, PostsInfoBean item, int position) {
                long j11;
                boolean z10;
                MenuSelectDialog.OnMenuSelectedListener onMenuSelectedListener;
                PostsListAdapter mPostsAdapter;
                IUserEvents mUserEventsImpl;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(item, "item");
                int id = view.getId();
                if (id == R.id.mIvAvatar) {
                    UserInfoBean user = item.getUser();
                    if (user != null && (mUserEventsImpl = CommunityManager.INSTANCE.getInstance().getMUserEventsImpl()) != null) {
                        mUserEventsImpl.onUserClick(user, view);
                        return;
                    }
                    return;
                }
                if (id == R.id.mTvMore) {
                    item.setShowAllContent(true);
                    mPostsAdapter = PostsSquareFragment.this.getMPostsAdapter();
                    mPostsAdapter.notifyItemChangedAt(position, 4100);
                    return;
                }
                if (id == R.id.mViewFollow) {
                    UserInfoBean user2 = item.getUser();
                    if (user2 != null) {
                        PostsSquareFragment postsSquareFragment = PostsSquareFragment.this;
                        IUserEvents mUserEventsImpl2 = CommunityManager.INSTANCE.getInstance().getMUserEventsImpl();
                        if (mUserEventsImpl2 != null) {
                            mUserEventsImpl2.onFollowUserClick(user2, view, ViewModelKt.getViewModelScope(PostsSquareFragment.access$getViewModel(postsSquareFragment)));
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (id != R.id.mTvLikes && id != R.id.mIvLike && id != R.id.likeClickView) {
                    if (id == R.id.mIvMore) {
                        PostsSquareFragment postsSquareFragment2 = PostsSquareFragment.this;
                        Menu[] moreMenus = CommunityUtils.INSTANCE.getMoreMenus(item);
                        onMenuSelectedListener = PostsSquareFragment.this.mOnMenuListener;
                        postsSquareFragment2.showMenusDialog(moreMenus, onMenuSelectedListener, item);
                        return;
                    }
                    Context requireContext = PostsSquareFragment.this.requireContext();
                    PostsDetailsActivity.Companion companion2 = PostsDetailsActivity.INSTANCE;
                    Context requireContext2 = PostsSquareFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                    String id2 = item.getId();
                    if (id2 == null) {
                        return;
                    }
                    UserInfoBean user3 = item.getUser();
                    if (user3 != null) {
                        j11 = user3.getId();
                    } else {
                        j11 = 0;
                    }
                    long j12 = j11;
                    if (view.getId() == R.id.mTvComments) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    requireContext.startActivity(companion2.starter(requireContext2, id2, position, j12, z10));
                    return;
                }
                PostsSquareFragment.access$getViewModel(PostsSquareFragment.this).postsLike(item, position);
            }
        });
        getMPostsAdapter().setOnDataLoad(new Function1() { // from class: com.qhqc.core.feature.community.ui.fragment.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initEvent$lambda$3;
                initEvent$lambda$3 = PostsSquareFragment.initEvent$lambda$3(PostsSquareFragment.this, (Page) obj);
                return initEvent$lambda$3;
            }
        });
        ((FeatureCommunityFragmentPostsSquareBinding) getBinding()).mRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qhqc.core.feature.community.ui.fragment.c
            public final void onRefresh(tc.f fVar) {
                PostsSquareFragment.initEvent$lambda$4(PostsSquareFragment.this, fVar);
            }
        });
        ((FeatureCommunityFragmentPostsSquareBinding) getBinding()).mRefreshLayout.setEnableLoadMore(false);
        ((FeatureCommunityFragmentPostsSquareBinding) getBinding()).mRV.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.qhqc.core.feature.community.ui.fragment.PostsSquareFragment$initEvent$6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, newState);
                if (newState != 0) {
                    if (newState == 1 || newState == 2) {
                        PostsSquareFragment.ChangePostCreateBtnStyleListener changePostBtnListener = PostsSquareFragment.this.getChangePostBtnListener();
                        if (changePostBtnListener != null) {
                            changePostBtnListener.noShowBtnAnim();
                        }
                        PostsSquareFragment.this.changeAllLottieAnimations(recyclerView, "pause");
                        return;
                    }
                    return;
                }
                PostsSquareFragment.ChangePostCreateBtnStyleListener changePostBtnListener2 = PostsSquareFragment.this.getChangePostBtnListener();
                if (changePostBtnListener2 != null) {
                    changePostBtnListener2.showBtnAnim();
                }
                PostsSquareFragment.this.changeAllLottieAnimations(recyclerView, "resume");
            }
        });
        if (((PostsSquareViewModel) m٥٢٢getViewModel()).getTargetId() != companion.getInstance().getUid() && ((PostsSquareViewModel) m٥٢٢getViewModel()).getPostsType() == 3) {
            ((FeatureCommunityFragmentPostsSquareBinding) getBinding()).postContainer.setPadding(0, 0, 0, dpToPx(70));
        } else {
            ((FeatureCommunityFragmentPostsSquareBinding) getBinding()).postContainer.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.qhqc.core.feature.community.events.IEventsCallback
    public void onCommentEvent(@NotNull CommentEvent commentEvent) {
        IEventsCallback.DefaultImpls.onCommentEvent(this, commentEvent);
    }

    @Override // com.qhqc.core.feature.uiframe.BaseModelFragment, com.qhqc.core.basic.uiframe.ui.BasicVBFragment, com.qhqc.core.basic.uiframe.ui.BasicVMFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        cancelAnim();
        CommunityManager.INSTANCE.getInstance().removeHandler$feature_community_release(this);
        super.onDestroyView();
    }

    @Override // com.qhqc.core.basic.uiframe.ui.VisibilityFragment, com.qhqc.core.basic.uiframe.ui.IFragmentVisibility
    public void onFirstVisible() {
        super.onFirstVisible();
        getMPostsAdapter().loadData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMFragment
    public void onInit(@Nullable Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        FeatureCommunityFragmentPostsSquareBinding featureCommunityFragmentPostsSquareBinding = (FeatureCommunityFragmentPostsSquareBinding) getBinding();
        featureCommunityFragmentPostsSquareBinding.mRV.setLayoutManager(new LinearLayoutManager(requireContext()));
        featureCommunityFragmentPostsSquareBinding.mRV.setAdapter(getMPostsAdapter());
    }

    @Override // com.qhqc.core.feature.community.events.IEventsCallback
    public void onPostsEvent(@NotNull PostsEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getEvent() == 4096) {
            PostsListAdapter mPostsAdapter = getMPostsAdapter();
            PostsInfoBean postsInfo = event.getPostsInfo();
            if (postsInfo == null) {
                return;
            }
            mPostsAdapter.addData(0, (int) postsInfo);
            scrollToTop();
            return;
        }
        PostsInfoBean postsInfo2 = event.getPostsInfo();
        if (postsInfo2 != null) {
            int size = getMPostsAdapter().getData().size();
            for (int i10 = 0; i10 < size; i10++) {
                if (Intrinsics.areEqual(((PostsInfoBean) getMPostsAdapter().getData().get(i10)).getId(), postsInfo2.getId())) {
                    switch (event.getEvent()) {
                        case 4097:
                            ((PostsInfoBean) getMPostsAdapter().getData().get(i10)).setCommentCount(postsInfo2.getCommentCount());
                            getMPostsAdapter().notifyItemChangedAt(i10, 4097);
                            return;
                        case 4098:
                            ((PostsInfoBean) getMPostsAdapter().getData().get(i10)).setLike(postsInfo2.isLike());
                            ((PostsInfoBean) getMPostsAdapter().getData().get(i10)).setLikeCount(postsInfo2.getLikeCount());
                            getMPostsAdapter().notifyItemChangedAt(i10, 4098);
                            return;
                        case 4099:
                            getMPostsAdapter().removeAt(i10);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    @Override // com.qhqc.core.feature.community.events.IEventsCallback
    public void onUserEvent(@NotNull UserOperateEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getEvent() == 12289) {
            int size = getMPostsAdapter().getData().size();
            for (int i10 = 0; i10 < size; i10++) {
                UserInfoBean user = ((PostsInfoBean) getMPostsAdapter().getData().get(i10)).getUser();
                if (user != null && user.getId() == event.getUser().getId()) {
                    ((PostsInfoBean) getMPostsAdapter().getData().get(i10)).setFollowUser(true);
                    getMPostsAdapter().notifyItemChangedAt(i10, Integer.valueOf(event.getEvent()));
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void scrollToTop() {
        ((FeatureCommunityFragmentPostsSquareBinding) getBinding()).mRV.smoothScrollToPosition(0);
    }

    public final void setChangePostBtnListener(@Nullable ChangePostCreateBtnStyleListener changePostCreateBtnStyleListener) {
        this.changePostBtnListener = changePostCreateBtnStyleListener;
    }
}

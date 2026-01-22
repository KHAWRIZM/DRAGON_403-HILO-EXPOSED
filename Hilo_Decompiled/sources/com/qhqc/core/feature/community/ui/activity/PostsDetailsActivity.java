package com.qhqc.core.feature.community.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.ktx.SpannableStringKtxKt;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.router.provider.IToast;
import com.qhqc.core.basic.rvadapter.data.Page;
import com.qhqc.core.basic.rvadapter.data.PageData;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.Menu;
import com.qhqc.core.basic.uiframe.ui.dialogfragment.menuselector.MenuSelectDialog;
import com.qhqc.core.basic.utils.SoftKeyboardUtils;
import com.qhqc.core.basic.widget.KeyboardFrameLayout;
import com.qhqc.core.basic.widget.toolbar.CommonToolbar;
import com.qhqc.core.basic.widget.toolbar.ICommonToolbar;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsCommentBean;
import com.qhqc.core.feature.bean.community.PostsCommentFloorBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.CommunityUtils;
import com.qhqc.core.feature.community.IUserEvents;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.data.viewmodel.PostsDetailsViewModel;
import com.qhqc.core.feature.community.databinding.FeatureCommunityActivityPostsDetailsBinding;
import com.qhqc.core.feature.community.events.CommentEvent;
import com.qhqc.core.feature.community.events.IEventsCallback;
import com.qhqc.core.feature.community.events.PostsEvent;
import com.qhqc.core.feature.community.events.UserOperateEvent;
import com.qhqc.core.feature.community.ui.adapter.PostsCommentFloorListAdapter;
import com.qhqc.core.feature.community.ui.adapter.PostsCommentListAdapter;
import com.qhqc.core.feature.community.widget.PostsContentView;
import com.qhqc.core.feature.uiframe.BaseModelActivity;
import com.ruffian.library.widget.REditText;
import com.ruffian.library.widget.RTextView;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 >2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001>B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0014J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u001dH\u0014J\b\u0010%\u001a\u00020\u001dH\u0015J1\u0010&\u001a\u00020\u001d2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\b\u0010*\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0002\u0010-JA\u0010.\u001a\u00020\u001d2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00122\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u00102\u001a\u00020\u0012H\u0002¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\u001dH\u0003J4\u00105\u001a\u00020\u001d2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u00100\u001a\u00020\u00122\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u00102\u001a\u00020\u0012H\u0002J\u0010\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u001dH\u0014R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/qhqc/core/feature/community/ui/activity/PostsDetailsActivity;", "Lcom/qhqc/core/feature/uiframe/BaseModelActivity;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityActivityPostsDetailsBinding;", "Lcom/qhqc/core/feature/community/data/viewmodel/PostsDetailsViewModel;", "Lcom/qhqc/core/feature/community/events/IEventsCallback;", "<init>", "()V", "mCommentsAdapter", "Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentListAdapter;", "getMCommentsAdapter", "()Lcom/qhqc/core/feature/community/ui/adapter/PostsCommentListAdapter;", "mCommentsAdapter$delegate", "Lkotlin/Lazy;", "detailMore", "Landroid/widget/ImageView;", "postInfoData", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "mMaxLines", "", "mOnMenuListener", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog$OnMenuSelectedListener;", "mReplyComment", "Lkotlin/Pair;", "Lcom/qhqc/core/feature/bean/community/PostsCommentBean;", "mReplyCommentFloor", "Lcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;", "onCreateCommonToolbar", "Lcom/qhqc/core/basic/widget/toolbar/ICommonToolbar;", "onInit", "", "savedInstanceState", "Landroid/os/Bundle;", "initEvent", "showLoading", "s", "", "dismissLoading", "initData", "showMenusDialog", "menus", "", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;", "onMenuListener", "payload", "", "([Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/MenuSelectDialog$OnMenuSelectedListener;Ljava/lang/Object;)V", "showCommentMenusDialog", "itemComment", "positionComment", "itemCommentFloor", "positionCommentFloor", "([Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/menuselector/Menu;Lcom/qhqc/core/feature/bean/community/PostsCommentBean;ILcom/qhqc/core/feature/bean/community/PostsCommentFloorBean;I)V", "resetInputInfo", "onReply", "onPostsEvent", "event", "Lcom/qhqc/core/feature/community/events/PostsEvent;", "onCommentEvent", "Lcom/qhqc/core/feature/community/events/CommentEvent;", "onUserEvent", "Lcom/qhqc/core/feature/community/events/UserOperateEvent;", "onDestroy", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsDetailsActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsDetailsActivity.kt\ncom/qhqc/core/feature/community/ui/activity/PostsDetailsActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,861:1\n58#2,23:862\n93#2,3:885\n256#3,2:888\n256#3,2:890\n256#3,2:892\n256#3,2:894\n37#4:896\n36#4,3:897\n*S KotlinDebug\n*F\n+ 1 PostsDetailsActivity.kt\ncom/qhqc/core/feature/community/ui/activity/PostsDetailsActivity\n*L\n191#1:862,23\n191#1:885,3\n674#1:888,2\n694#1:890,2\n703#1:892,2\n714#1:894,2\n545#1:896\n545#1:897,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsDetailsActivity extends BaseModelActivity<FeatureCommunityActivityPostsDetailsBinding, PostsDetailsViewModel> implements IEventsCallback {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private ImageView detailMore;

    /* renamed from: mCommentsAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCommentsAdapter = LazyKt.lazy(new Function0() { // from class: com.qhqc.core.feature.community.ui.activity.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PostsCommentListAdapter mCommentsAdapter_delegate$lambda$0;
            mCommentsAdapter_delegate$lambda$0 = PostsDetailsActivity.mCommentsAdapter_delegate$lambda$0();
            return mCommentsAdapter_delegate$lambda$0;
        }
    });
    private final int mMaxLines = 20;

    @Nullable
    private MenuSelectDialog.OnMenuSelectedListener mOnMenuListener;

    @Nullable
    private Pair<PostsCommentBean, Integer> mReplyComment;

    @Nullable
    private Pair<PostsCommentFloorBean, Integer> mReplyCommentFloor;

    @Nullable
    private PostsInfoBean postInfoData;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u0007¨\u0006\u0013"}, d2 = {"Lcom/qhqc/core/feature/community/ui/activity/PostsDetailsActivity$Companion;", "", "<init>", "()V", "starter", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "postsId", "", "position", "", "userId", "", "autoShowKeyboard", "", "startFromNotice", "", "noticeId", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent starter$default(Companion companion, Context context, String str, int i10, long j10, boolean z10, int i11, Object obj) {
            int i12;
            boolean z11;
            if ((i11 & 4) != 0) {
                i12 = -1;
            } else {
                i12 = i10;
            }
            if ((i11 & 8) != 0) {
                j10 = 0;
            }
            long j11 = j10;
            if ((i11 & 16) != 0) {
                z11 = false;
            } else {
                z11 = z10;
            }
            return companion.starter(context, str, i12, j11, z11);
        }

        @JvmStatic
        public final void startFromNotice(@NotNull Context context, @Nullable String noticeId, long userId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent putExtra = new Intent(context, (Class<?>) PostsDetailsActivity.class).putExtra("noticeId", noticeId).putExtra("userId", userId);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            context.startActivity(putExtra);
        }

        @JvmStatic
        @NotNull
        public final Intent starter(@NotNull Context context, @NotNull String postsId, int position, long userId, boolean autoShowKeyboard) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(postsId, "postsId");
            Intent putExtra = new Intent(context, (Class<?>) PostsDetailsActivity.class).putExtra(ShareConstants.RESULT_POST_ID, postsId).putExtra("position", postsId).putExtra("userId", userId).putExtra("autoShowKeyboard", autoShowKeyboard);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            return putExtra;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FeatureCommunityActivityPostsDetailsBinding access$getBinding(PostsDetailsActivity postsDetailsActivity) {
        return (FeatureCommunityActivityPostsDetailsBinding) postsDetailsActivity.getBinding();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ PostsDetailsViewModel access$getViewModel(PostsDetailsActivity postsDetailsActivity) {
        return (PostsDetailsViewModel) postsDetailsActivity.m٥٢١getViewModel();
    }

    private final PostsCommentListAdapter getMCommentsAdapter() {
        return (PostsCommentListAdapter) this.mCommentsAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$6(PostsDetailsActivity postsDetailsActivity, PostsInfoBean postsInfoBean) {
        postsInfoBean.setShowAllContent(true);
        ((FeatureCommunityActivityPostsDetailsBinding) postsDetailsActivity.getBinding()).mViewPostContent.setStyle(postsInfoBean.getItemType());
        PostsContentView postsContentView = ((FeatureCommunityActivityPostsDetailsBinding) postsDetailsActivity.getBinding()).mViewPostContent;
        Intrinsics.checkNotNull(postsInfoBean);
        PostsContentView.setData$default(postsContentView, postsInfoBean, 0, 2, null);
        postsDetailsActivity.postInfoData = postsInfoBean;
        if (postsDetailsActivity.getIntent().getBooleanExtra("autoShowKeyboard", false)) {
            onReply$default(postsDetailsActivity, null, 0, null, 0, 15, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$7(PostsDetailsActivity postsDetailsActivity, PageData pageData) {
        PostsCommentListAdapter mCommentsAdapter = postsDetailsActivity.getMCommentsAdapter();
        Intrinsics.checkNotNull(pageData);
        mCommentsAdapter.addPageDataWithCursor(pageData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$8(PostsDetailsActivity postsDetailsActivity, Triple triple) {
        PostsCommentFloorBean[] postsCommentFloorBeanArr;
        PostsCommentBean itemOrNull = postsDetailsActivity.getMCommentsAdapter().getItemOrNull(((Number) triple.getThird()).intValue());
        if (itemOrNull == null) {
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(itemOrNull.getCommentId(), ((PostsCommentBean) triple.getSecond()).getCommentId())) {
            return Unit.INSTANCE;
        }
        String currentPageCursor = itemOrNull.getCurrentPageCursor();
        if (currentPageCursor != null && currentPageCursor.length() != 0) {
            List<PostsCommentFloorBean> subComments = itemOrNull.getSubComments();
            if (subComments != null) {
                List data = ((PageData) triple.getFirst()).getData();
                if (data == null || (postsCommentFloorBeanArr = (PostsCommentFloorBean[]) data.toArray(new PostsCommentFloorBean[0])) == null) {
                    postsCommentFloorBeanArr = new PostsCommentFloorBean[0];
                }
                CollectionsKt.addAll(subComments, postsCommentFloorBeanArr);
            }
        } else {
            itemOrNull.setSubComments(((PageData) triple.getFirst()).getData());
        }
        itemOrNull.setNextPageCursor(((PageData) triple.getFirst()).getPage().getNextPageCursor());
        postsDetailsActivity.getMCommentsAdapter().notifyItemChangedAt(((Number) triple.getThird()).intValue(), 8197);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$9(PostsDetailsActivity postsDetailsActivity, Integer num) {
        IToast iToast;
        if (num != null && num.intValue() == 1) {
            IToast iToast2 = BasicModuleApp.INSTANCE.toastImpl();
            if (iToast2 != null) {
                iToast2.showToast(CompatKtxKt.getString(R.string.feature_community_posts_deleted_posts));
            }
            postsDetailsActivity.finish();
        } else if (num != null && num.intValue() == 2) {
            IToast iToast3 = BasicModuleApp.INSTANCE.toastImpl();
            if (iToast3 != null) {
                iToast3.showToast(CompatKtxKt.getString(R.string.feature_community_posts_deleted_comment));
            }
        } else if (num != null && num.intValue() == 3 && (iToast = BasicModuleApp.INSTANCE.toastImpl()) != null) {
            iToast.showToast(CompatKtxKt.getString(R.string.feature_community_posts_deleted_comment_reply));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initEvent$lambda$1(PostsDetailsActivity postsDetailsActivity, View view) {
        SoftKeyboardUtils.INSTANCE.hideSoftKeyboard(postsDetailsActivity);
        ((FeatureCommunityActivityPostsDetailsBinding) postsDetailsActivity.getBinding()).mViewEdit.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initEvent$lambda$2(PostsDetailsActivity postsDetailsActivity, int i10) {
        boolean z10;
        KeyboardFrameLayout keyboardFrameLayout = ((FeatureCommunityActivityPostsDetailsBinding) postsDetailsActivity.getBinding()).mViewEdit;
        if (i10 == -3) {
            z10 = true;
        } else {
            z10 = false;
        }
        keyboardFrameLayout.setClickable(z10);
        if (i10 == -2) {
            postsDetailsActivity.resetInputInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initEvent$lambda$4(PostsDetailsActivity postsDetailsActivity, View view) {
        if (postsDetailsActivity.mReplyComment == null) {
            ((PostsDetailsViewModel) postsDetailsActivity.m٥٢١getViewModel()).sendComment(String.valueOf(((FeatureCommunityActivityPostsDetailsBinding) postsDetailsActivity.getBinding()).mETComments.getText()));
            return;
        }
        PostsDetailsViewModel postsDetailsViewModel = (PostsDetailsViewModel) postsDetailsActivity.m٥٢١getViewModel();
        String valueOf = String.valueOf(((FeatureCommunityActivityPostsDetailsBinding) postsDetailsActivity.getBinding()).mETComments.getText());
        Pair<PostsCommentBean, Integer> pair = postsDetailsActivity.mReplyComment;
        Intrinsics.checkNotNull(pair);
        postsDetailsViewModel.sendCommentFloor(valueOf, pair, postsDetailsActivity.mReplyCommentFloor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initEvent$lambda$5(PostsDetailsActivity postsDetailsActivity, Page it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ((PostsDetailsViewModel) postsDetailsActivity.m٥٢١getViewModel()).getComments(it.getNextPageCursor());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PostsCommentListAdapter mCommentsAdapter_delegate$lambda$0() {
        return new PostsCommentListAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void onReply(PostsCommentBean itemComment, int positionComment, PostsCommentFloorBean itemCommentFloor, int positionCommentFloor) {
        PostsCommentFloorBean first;
        UserInfoBean fromUser;
        PostsCommentBean first2;
        UserInfoBean user;
        SoftKeyboardUtils.INSTANCE.showSoftInput(((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mETComments);
        String str = null;
        if (itemComment != null) {
            this.mReplyComment = new Pair<>(itemComment, Integer.valueOf(positionComment));
            if (itemCommentFloor == null) {
                this.mReplyCommentFloor = null;
                TextView mTvReplyTo = ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mTvReplyTo;
                Intrinsics.checkNotNullExpressionValue(mTvReplyTo, "mTvReplyTo");
                mTvReplyTo.setVisibility(0);
                Pair<PostsCommentBean, Integer> pair = this.mReplyComment;
                if (pair != null && (first2 = pair.getFirst()) != null && (user = first2.getUser()) != null) {
                    str = user.getNick();
                }
                String str2 = "@" + str;
                ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mTvReplyTo.setText(SpannableStringKtxKt.setStyleTargetTextSpan(new SpannableString(CompatKtxKt.toFormat(R.string.feature_community_posts_reply_to, str2)), new ForegroundColorSpan(CompatKtxKt.getColor(R.color.text_theme)), str2));
                return;
            }
            this.mReplyCommentFloor = new Pair<>(itemCommentFloor, Integer.valueOf(positionCommentFloor));
            TextView mTvReplyTo2 = ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mTvReplyTo;
            Intrinsics.checkNotNullExpressionValue(mTvReplyTo2, "mTvReplyTo");
            mTvReplyTo2.setVisibility(0);
            Pair<PostsCommentFloorBean, Integer> pair2 = this.mReplyCommentFloor;
            if (pair2 != null && (first = pair2.getFirst()) != null && (fromUser = first.getFromUser()) != null) {
                str = fromUser.getNick();
            }
            String str3 = "@" + str;
            ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mTvReplyTo.setText(SpannableStringKtxKt.setStyleTargetTextSpan(new SpannableString(CompatKtxKt.toFormat(R.string.feature_community_posts_reply_to, str3)), new ForegroundColorSpan(CompatKtxKt.getColor(R.color.text_theme)), str3));
            return;
        }
        this.mReplyComment = null;
        this.mReplyCommentFloor = null;
        TextView mTvReplyTo3 = ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mTvReplyTo;
        Intrinsics.checkNotNullExpressionValue(mTvReplyTo3, "mTvReplyTo");
        mTvReplyTo3.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void onReply$default(PostsDetailsActivity postsDetailsActivity, PostsCommentBean postsCommentBean, int i10, PostsCommentFloorBean postsCommentFloorBean, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            postsCommentBean = null;
        }
        if ((i12 & 2) != 0) {
            i10 = -1;
        }
        if ((i12 & 4) != 0) {
            postsCommentFloorBean = null;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        postsDetailsActivity.onReply(postsCommentBean, i10, postsCommentFloorBean, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    private final void resetInputInfo() {
        ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mETComments.setText("");
        TextView mTvReplyTo = ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mTvReplyTo;
        Intrinsics.checkNotNullExpressionValue(mTvReplyTo, "mTvReplyTo");
        mTvReplyTo.setVisibility(8);
        this.mReplyComment = null;
        this.mReplyCommentFloor = null;
        SoftKeyboardUtils.INSTANCE.hideSoftKeyboard(this);
        ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mViewEdit.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCommentMenusDialog(Menu[] menus, PostsCommentBean itemComment, int positionComment, PostsCommentFloorBean itemCommentFloor, int positionCommentFloor) {
        new MenuSelectDialog().setMenus((Menu[]) Arrays.copyOf(menus, menus.length), new PostsDetailsActivity$showCommentMenusDialog$1(this, itemComment, positionComment, itemCommentFloor, positionCommentFloor)).show((AppCompatActivity) this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showCommentMenusDialog$default(PostsDetailsActivity postsDetailsActivity, Menu[] menuArr, PostsCommentBean postsCommentBean, int i10, PostsCommentFloorBean postsCommentFloorBean, int i11, int i12, Object obj) {
        int i13;
        if ((i12 & 8) != 0) {
            postsCommentFloorBean = null;
        }
        PostsCommentFloorBean postsCommentFloorBean2 = postsCommentFloorBean;
        if ((i12 & 16) != 0) {
            i13 = -1;
        } else {
            i13 = i11;
        }
        postsDetailsActivity.showCommentMenusDialog(menuArr, postsCommentBean, i10, postsCommentFloorBean2, i13);
    }

    private final void showMenusDialog(Menu[] menus, MenuSelectDialog.OnMenuSelectedListener onMenuListener, Object payload) {
        new MenuSelectDialog().setMenus((Menu[]) Arrays.copyOf(menus, menus.length), onMenuListener).setPayload(payload).show((AppCompatActivity) this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showMenusDialog$default(PostsDetailsActivity postsDetailsActivity, Menu[] menuArr, MenuSelectDialog.OnMenuSelectedListener onMenuSelectedListener, Object obj, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            obj = null;
        }
        postsDetailsActivity.showMenusDialog(menuArr, onMenuSelectedListener, obj);
    }

    @JvmStatic
    public static final void startFromNotice(@NotNull Context context, @Nullable String str, long j10) {
        INSTANCE.startFromNotice(context, str, j10);
    }

    @JvmStatic
    @NotNull
    public static final Intent starter(@NotNull Context context, @NotNull String str, int i10, long j10, boolean z10) {
        return INSTANCE.starter(context, str, i10, j10, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qhqc.core.feature.uiframe.BaseModelActivity, com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void dismissLoading() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    @SuppressLint({"SetTextI18n"})
    public void initData() {
        super.initData();
        ((PostsDetailsViewModel) m٥٢١getViewModel()).getPostsInfoLiveData().observe(this, new PostsDetailsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = PostsDetailsActivity.initData$lambda$6(PostsDetailsActivity.this, (PostsInfoBean) obj);
                return initData$lambda$6;
            }
        }));
        ((PostsDetailsViewModel) m٥٢١getViewModel()).getCommentListLiveData().observe(this, new PostsDetailsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = PostsDetailsActivity.initData$lambda$7(PostsDetailsActivity.this, (PageData) obj);
                return initData$lambda$7;
            }
        }));
        ((PostsDetailsViewModel) m٥٢١getViewModel()).getCommentFloorListMoreLiveData().observe(this, new PostsDetailsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initData$lambda$8;
                initData$lambda$8 = PostsDetailsActivity.initData$lambda$8(PostsDetailsActivity.this, (Triple) obj);
                return initData$lambda$8;
            }
        }));
        ((PostsDetailsViewModel) m٥٢١getViewModel()).getDeletedStateLiveData().observe(this, new PostsDetailsActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initData$lambda$9;
                initData$lambda$9 = PostsDetailsActivity.initData$lambda$9(PostsDetailsActivity.this, (Integer) obj);
                return initData$lambda$9;
            }
        }));
        if (((PostsDetailsViewModel) m٥٢١getViewModel()).getPostId().length() > 0) {
            ((PostsDetailsViewModel) m٥٢١getViewModel()).getPostsDetail();
            getMCommentsAdapter().loadData();
        } else {
            ((PostsDetailsViewModel) m٥٢١getViewModel()).getPostsDetailByNoticeId();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void initEvent() {
        super.initEvent();
        ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mViewPostContent.setTargetUserId(((PostsDetailsViewModel) m٥٢١getViewModel()).getTargetUserId());
        ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mViewPostContent.setOnViewClickListener(new PostsContentView.OnClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.PostsDetailsActivity$initEvent$1
            @Override // com.qhqc.core.feature.community.widget.PostsContentView.OnClickListener
            public void onChildViewClick(View view, PostsInfoBean item, int position) {
                MenuSelectDialog.OnMenuSelectedListener onMenuSelectedListener;
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
                if (id == R.id.mViewFollow) {
                    UserInfoBean user2 = item.getUser();
                    if (user2 != null) {
                        PostsDetailsActivity postsDetailsActivity = PostsDetailsActivity.this;
                        IUserEvents mUserEventsImpl2 = CommunityManager.INSTANCE.getInstance().getMUserEventsImpl();
                        if (mUserEventsImpl2 != null) {
                            mUserEventsImpl2.onFollowUserClick(user2, view, ViewModelKt.getViewModelScope(PostsDetailsActivity.access$getViewModel(postsDetailsActivity)));
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (id == R.id.mViewLike) {
                    PostsLikeUserListActivity.Companion.start(PostsDetailsActivity.this, item.getId());
                    return;
                }
                if (id == R.id.mTvComments) {
                    PostsDetailsActivity.onReply$default(PostsDetailsActivity.this, null, 0, null, 0, 15, null);
                    return;
                }
                if (id != R.id.mTvLikes && id != R.id.mIvLike && id != R.id.likeClickView) {
                    if (id == R.id.mIvMore) {
                        PostsDetailsActivity postsDetailsActivity2 = PostsDetailsActivity.this;
                        Menu[] moreMenus = CommunityUtils.INSTANCE.getMoreMenus(item);
                        onMenuSelectedListener = PostsDetailsActivity.this.mOnMenuListener;
                        PostsDetailsActivity.showMenusDialog$default(postsDetailsActivity2, moreMenus, onMenuSelectedListener, null, 4, null);
                        return;
                    }
                    return;
                }
                PostsDetailsActivity.access$getViewModel(PostsDetailsActivity.this).postsLike();
            }
        });
        ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mViewEdit.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostsDetailsActivity.initEvent$lambda$1(PostsDetailsActivity.this, view);
            }
        });
        ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mViewEdit.setOnkbdStateListener(new KeyboardFrameLayout.a() { // from class: com.qhqc.core.feature.community.ui.activity.k
            @Override // com.qhqc.core.basic.widget.KeyboardFrameLayout.a
            public final void a(int i10) {
                PostsDetailsActivity.initEvent$lambda$2(PostsDetailsActivity.this, i10);
            }
        });
        REditText mETComments = ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mETComments;
        Intrinsics.checkNotNullExpressionValue(mETComments, "mETComments");
        mETComments.addTextChangedListener(new TextWatcher() { // from class: com.qhqc.core.feature.community.ui.activity.PostsDetailsActivity$initEvent$$inlined$doAfterTextChanged$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s10) {
                int i10;
                String substring;
                int i11;
                if (s10 != null) {
                    int lineCount = PostsDetailsActivity.access$getBinding(PostsDetailsActivity.this).mETComments.getLineCount();
                    i10 = PostsDetailsActivity.this.mMaxLines;
                    boolean z10 = false;
                    if (lineCount > i10) {
                        String obj = s10.toString();
                        int selectionStart = PostsDetailsActivity.access$getBinding(PostsDetailsActivity.this).mETComments.getSelectionStart();
                        if (selectionStart == PostsDetailsActivity.access$getBinding(PostsDetailsActivity.this).mETComments.getSelectionEnd() && selectionStart < obj.length() && selectionStart >= 1) {
                            String substring2 = obj.substring(0, selectionStart - 1);
                            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                            String substring3 = obj.substring(selectionStart);
                            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                            substring = substring2 + substring3;
                        } else {
                            substring = obj.substring(0, s10.length() - 1);
                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        }
                        PostsDetailsActivity.access$getBinding(PostsDetailsActivity.this).mETComments.setText(substring);
                        REditText rEditText = PostsDetailsActivity.access$getBinding(PostsDetailsActivity.this).mETComments;
                        Editable text = PostsDetailsActivity.access$getBinding(PostsDetailsActivity.this).mETComments.getText();
                        if (text != null) {
                            i11 = text.length();
                        } else {
                            i11 = 0;
                        }
                        rEditText.setSelection(i11);
                    }
                    RTextView rTextView = PostsDetailsActivity.access$getBinding(PostsDetailsActivity.this).mTvSend;
                    if (StringsKt.trim((CharSequence) String.valueOf(PostsDetailsActivity.access$getBinding(PostsDetailsActivity.this).mETComments.getText())).toString().length() > 0) {
                        z10 = true;
                    }
                    rTextView.setEnabled(z10);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            }
        });
        ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mTvSend.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostsDetailsActivity.initEvent$lambda$4(PostsDetailsActivity.this, view);
            }
        });
        if (((PostsDetailsViewModel) m٥٢١getViewModel()).getPostId().length() > 0) {
            getMCommentsAdapter().setOnDataLoad(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit initEvent$lambda$5;
                    initEvent$lambda$5 = PostsDetailsActivity.initEvent$lambda$5(PostsDetailsActivity.this, (Page) obj);
                    return initEvent$lambda$5;
                }
            });
        }
        getMCommentsAdapter().setOnClickListener(new PostsCommentListAdapter.OnClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.PostsDetailsActivity$initEvent$7
            @Override // com.qhqc.core.feature.community.ui.adapter.PostsCommentListAdapter.OnClickListener
            public void onCommentClick(PostsCommentListAdapter adapter, View view, PostsCommentBean item, int position) {
                UserInfoBean user;
                Intrinsics.checkNotNullParameter(adapter, "adapter");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(item, "item");
                int id = view.getId();
                if (id == R.id.mTvLike) {
                    PostsDetailsActivity.access$getViewModel(PostsDetailsActivity.this).commentLike(item, position);
                    return;
                }
                if (id == R.id.mViewMoreCom) {
                    PostsDetailsActivity.access$getViewModel(PostsDetailsActivity.this).loadMoreCommentFloor(item, position);
                    return;
                }
                if (id == R.id.mIvAvatar) {
                    IUserEvents mUserEventsImpl = CommunityManager.INSTANCE.getInstance().getMUserEventsImpl();
                    if (mUserEventsImpl == null || (user = item.getUser()) == null) {
                        return;
                    }
                    mUserEventsImpl.onUserClick(user, view);
                    return;
                }
                PostsDetailsActivity.onReply$default(PostsDetailsActivity.this, item, position, null, 0, 12, null);
            }

            @Override // com.qhqc.core.feature.community.ui.adapter.PostsCommentListAdapter.OnClickListener
            public void onCommentFloorClick(PostsCommentFloorListAdapter adapter, View view, PostsCommentBean itemComment, int positionComment, PostsCommentFloorBean itemCommentFloor, int positionCommentFloor) {
                UserInfoBean fromUser;
                Intrinsics.checkNotNullParameter(adapter, "adapter");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(itemComment, "itemComment");
                Intrinsics.checkNotNullParameter(itemCommentFloor, "itemCommentFloor");
                if (view.getId() != R.id.mIvAvatar) {
                    PostsDetailsActivity.this.onReply(itemComment, positionComment, itemCommentFloor, positionCommentFloor);
                    return;
                }
                IUserEvents mUserEventsImpl = CommunityManager.INSTANCE.getInstance().getMUserEventsImpl();
                if (mUserEventsImpl == null || (fromUser = itemCommentFloor.getFromUser()) == null) {
                    return;
                }
                mUserEventsImpl.onUserClick(fromUser, view);
            }

            @Override // com.qhqc.core.feature.community.ui.adapter.PostsCommentListAdapter.OnClickListener
            public void onCommentFloorLongClick(PostsCommentFloorListAdapter adapter, View view, PostsCommentBean itemComment, int positionComment, PostsCommentFloorBean itemCommentFloor, int positionCommentFloor) {
                Menu[] menuArr;
                Intrinsics.checkNotNullParameter(adapter, "adapter");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(itemComment, "itemComment");
                Intrinsics.checkNotNullParameter(itemCommentFloor, "itemCommentFloor");
                PostsInfoBean postsInfoBean = (PostsInfoBean) PostsDetailsActivity.access$getViewModel(PostsDetailsActivity.this).getPostsInfoLiveData().getValue();
                if (postsInfoBean == null) {
                    return;
                }
                CommunityUtils communityUtils = CommunityUtils.INSTANCE;
                if (communityUtils.isMyCommentFloor(itemCommentFloor)) {
                    menuArr = new Menu[]{new Menu(18, null, R.string.copy, 2, null), new Menu(16, null, R.string.feature_community_delete, 2, null)};
                } else if (!communityUtils.isMyPosts(postsInfoBean) && !communityUtils.hasSuperAdminAuth(itemCommentFloor.getFromUser())) {
                    menuArr = new Menu[]{new Menu(18, null, R.string.copy, 2, null), new Menu(17, null, R.string.report, 2, null)};
                } else {
                    menuArr = new Menu[]{new Menu(18, null, R.string.copy, 2, null), new Menu(16, null, R.string.feature_community_delete, 2, null), new Menu(17, null, R.string.report, 2, null)};
                }
                PostsDetailsActivity.this.showCommentMenusDialog(menuArr, itemComment, positionComment, itemCommentFloor, positionCommentFloor);
            }

            @Override // com.qhqc.core.feature.community.ui.adapter.PostsCommentListAdapter.OnClickListener
            public void onCommentLongClick(PostsCommentListAdapter adapter, View view, PostsCommentBean item, int position) {
                Menu[] menuArr;
                Intrinsics.checkNotNullParameter(adapter, "adapter");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(item, "item");
                PostsInfoBean postsInfoBean = (PostsInfoBean) PostsDetailsActivity.access$getViewModel(PostsDetailsActivity.this).getPostsInfoLiveData().getValue();
                if (postsInfoBean == null) {
                    return;
                }
                CommunityUtils communityUtils = CommunityUtils.INSTANCE;
                if (communityUtils.isMyComment(item)) {
                    menuArr = new Menu[]{new Menu(18, null, R.string.copy, 2, null), new Menu(13, null, R.string.feature_community_delete, 2, null)};
                } else if (!communityUtils.isMyPosts(postsInfoBean) && !communityUtils.hasSuperAdminAuth(item.getUser())) {
                    menuArr = new Menu[]{new Menu(18, null, R.string.copy, 2, null), new Menu(14, null, R.string.report, 2, null)};
                } else {
                    menuArr = new Menu[]{new Menu(18, null, R.string.copy, 2, null), new Menu(13, null, R.string.feature_community_delete, 2, null), new Menu(14, null, R.string.report, 2, null)};
                }
                PostsDetailsActivity.showCommentMenusDialog$default(PostsDetailsActivity.this, menuArr, item, position, null, 0, 24, null);
            }
        });
        this.mOnMenuListener = new PostsDetailsActivity$initEvent$8(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.feature.community.events.IEventsCallback
    public void onCommentEvent(@NotNull CommentEvent event) {
        String str;
        PostsCommentFloorBean postsCommentFloorBean;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!Intrinsics.areEqual(event.getPostId(), ((PostsDetailsViewModel) m٥٢١getViewModel()).getPostId())) {
            return;
        }
        if (event.getEvent() == 8194) {
            PostsCommentBean commentSent = event.getCommentSent();
            if (commentSent != null) {
                if (getMCommentsAdapter().getData().size() == 0) {
                    getMCommentsAdapter().addPageDataWithCursor(new PageData(new Page(1, "", "", false, 0, false, 48, null), CollectionsKt.arrayListOf(commentSent)));
                } else {
                    getMCommentsAdapter().addData(0, (int) commentSent);
                }
                ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mRV.scrollToPosition(0);
                resetInputInfo();
                return;
            }
            return;
        }
        PostsCommentBean itemOrNull = getMCommentsAdapter().getItemOrNull(event.getPosition());
        if (itemOrNull != null) {
            String commentId = itemOrNull.getCommentId();
            PostsCommentBean item = event.getItem();
            String str2 = null;
            if (item != null) {
                str = item.getCommentId();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(commentId, str)) {
                return;
            }
            switch (event.getEvent()) {
                case CommentEvent.EVENT_LIKE /* 8193 */:
                    getMCommentsAdapter().notifyItemChangedAt(event.getPosition(), Integer.valueOf(CommentEvent.EVENT_LIKE));
                    return;
                case 8194:
                case 8197:
                default:
                    return;
                case CommentEvent.EVENT_REPLY /* 8195 */:
                case CommentEvent.EVENT_REPLY_FLOOR /* 8196 */:
                    resetInputInfo();
                    PostsCommentBean item2 = event.getItem();
                    if (item2 != null) {
                        itemOrNull.setSubCommentCnt(item2.getSubCommentCnt());
                    }
                    getMCommentsAdapter().notifyItemChangedAt(event.getPosition(), Integer.valueOf(event.getEvent()));
                    ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mRV.scrollToPosition(event.getPosition());
                    return;
                case CommentEvent.EVENT_DELETED /* 8198 */:
                    getMCommentsAdapter().removeAt(event.getPosition());
                    return;
                case CommentEvent.EVENT_COMMENT_FLOOR_DELETED /* 8199 */:
                    List<PostsCommentFloorBean> subComments = itemOrNull.getSubComments();
                    if (subComments != null && (postsCommentFloorBean = (PostsCommentFloorBean) CollectionsKt.getOrNull(subComments, event.getItemCommentFloorPosition())) != null) {
                        String commentId2 = postsCommentFloorBean.getCommentId();
                        PostsCommentFloorBean itemCommentFloor = event.getItemCommentFloor();
                        if (itemCommentFloor != null) {
                            str2 = itemCommentFloor.getCommentId();
                        }
                        if (!Intrinsics.areEqual(commentId2, str2)) {
                            return;
                        }
                        List<PostsCommentFloorBean> subComments2 = itemOrNull.getSubComments();
                        if (subComments2 != null) {
                            subComments2.remove(event.getItemCommentFloorPosition());
                        }
                        getMCommentsAdapter().notifyItemChangedAt(event.getPosition(), Integer.valueOf(event.getEvent()));
                        return;
                    }
                    return;
            }
        }
    }

    @Override // com.qhqc.core.feature.uiframe.BaseModelActivity
    @NotNull
    protected ICommonToolbar onCreateCommonToolbar() {
        return new CommonToolbar.Builder().setTitle(R.string.feature_community_posts_details).build(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CommunityManager.INSTANCE.getInstance().removeHandler$feature_community_release(this);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void onInit(@Nullable Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        PostsDetailsViewModel postsDetailsViewModel = (PostsDetailsViewModel) m٥٢١getViewModel();
        String stringExtra = getIntent().getStringExtra(ShareConstants.RESULT_POST_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        postsDetailsViewModel.setPostId(stringExtra);
        ((PostsDetailsViewModel) m٥٢١getViewModel()).setNoticeId(getIntent().getStringExtra("noticeId"));
        ((PostsDetailsViewModel) m٥٢١getViewModel()).setTargetUserId(getIntent().getLongExtra("userId", 0L));
        ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mRV.setLayoutManager(new LinearLayoutManager(this));
        ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mRV.setAdapter(getMCommentsAdapter());
        CommunityManager.INSTANCE.getInstance().addEventHandler$feature_community_release(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.feature.community.events.IEventsCallback
    public void onPostsEvent(@NotNull PostsEvent event) {
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        String postId = ((PostsDetailsViewModel) m٥٢١getViewModel()).getPostId();
        PostsInfoBean postsInfo = event.getPostsInfo();
        if (postsInfo != null) {
            str = postsInfo.getId();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(postId, str)) {
            return;
        }
        switch (event.getEvent()) {
            case 4097:
                ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mViewPostContent.commentCountChanged(event.getPostsInfo());
                return;
            case 4098:
                ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mViewPostContent.likeChanged(event.getPostsInfo(), true);
                return;
            case 4099:
                finish();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.feature.community.events.IEventsCallback
    public void onUserEvent(@NotNull UserOperateEvent event) {
        PostsInfoBean postsInfoBean;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getEvent() == 12289 && (postsInfoBean = (PostsInfoBean) ((PostsDetailsViewModel) m٥٢١getViewModel()).getPostsInfoLiveData().getValue()) != null) {
            postsInfoBean.setFollowUser(true);
            ((FeatureCommunityActivityPostsDetailsBinding) getBinding()).mViewPostContent.followUser(postsInfoBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qhqc.core.feature.uiframe.BaseModelActivity, com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void showLoading(@Nullable String s10) {
    }
}

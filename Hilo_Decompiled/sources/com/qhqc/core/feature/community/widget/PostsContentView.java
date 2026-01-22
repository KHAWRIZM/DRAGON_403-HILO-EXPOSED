package com.qhqc.core.feature.community.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.ktx.DisplayKtxKt;
import com.qhqc.core.basic.uiframe.ui.BasicActivity;
import com.qhqc.core.feature.bean.UserInfoBean;
import com.qhqc.core.feature.bean.community.PostsInfoBean;
import com.qhqc.core.feature.bean.community.PostsInfoMediaBean;
import com.qhqc.core.feature.community.ActivityUtils;
import com.qhqc.core.feature.community.CommunityManager;
import com.qhqc.core.feature.community.CommunityUtils;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.databinding.FeatureCommunityPostsContentViewBinding;
import com.qhqc.core.feature.community.ui.activity.CommunityPhotoViewActivity;
import com.qhqc.core.feature.community.ui.activity.PostsDetailsActivity;
import com.qhqc.core.feature.community.ui.adapter.PostsListImageAdapter;
import com.qhqc.core.feature.community.ui.adapter.PostsListLikeUserAvatarAdapter;
import com.ruffian.library.widget.RConstraintLayout;
import io.agora.rtc.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u00018B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\bJ\u0006\u0010(\u001a\u00020%J\b\u0010)\u001a\u00020%H\u0002J\u0018\u0010*\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0017J\u000e\u0010.\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0017J\u000e\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\bJ\u0010\u00101\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0017H\u0002J\u0012\u00103\u001a\u00020%2\b\u00104\u001a\u0004\u0018\u000105H\u0002J\u0012\u00106\u001a\u00020%2\b\u00107\u001a\u0004\u0018\u000105H\u0016R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00069"}, d2 = {"Lcom/qhqc/core/feature/community/widget/PostsContentView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLikeColorNor", "mLikeColorPre", "binding", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityPostsContentViewBinding;", "mStyleType", "mPostSize", "mImgSizeStyle2", "mImgSizeStyle3", "mSingleImgW", "mSingleImgH", "mPosition", "mData", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "onViewClickListener", "Lcom/qhqc/core/feature/community/widget/PostsContentView$OnClickListener;", "getOnViewClickListener", "()Lcom/qhqc/core/feature/community/widget/PostsContentView$OnClickListener;", "setOnViewClickListener", "(Lcom/qhqc/core/feature/community/widget/PostsContentView$OnClickListener;)V", "targetUserId", "", "getTargetUserId", "()J", "setTargetUserId", "(J)V", "setData", "", "item", "position", "showMoreContent", "showContent", "likeChanged", "isShowAnim", "", "followUser", "commentCountChanged", "setStyle", "style", "measureImageSize", "resetSingleImgSize", "likeClickAnim", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onClick", "p0", "OnClickListener", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsContentView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsContentView.kt\ncom/qhqc/core/feature/community/widget/PostsContentView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,392:1\n296#2:393\n256#2,2:394\n256#2,2:396\n256#2,2:398\n256#2,2:400\n256#2,2:402\n256#2,2:404\n256#2,2:406\n256#2,2:408\n256#2,2:410\n256#2,2:412\n256#2,2:414\n256#2,2:416\n256#2,2:418\n256#2,2:420\n256#2,2:422\n256#2,2:424\n256#2,2:426\n277#2,2:428\n277#2,2:430\n277#2,2:432\n256#2,2:434\n256#2,2:436\n256#2,2:440\n1863#3,2:438\n*S KotlinDebug\n*F\n+ 1 PostsContentView.kt\ncom/qhqc/core/feature/community/widget/PostsContentView\n*L\n86#1:393\n87#1:394,2\n105#1:396,2\n108#1:398,2\n114#1:400,2\n117#1:402,2\n184#1:404,2\n185#1:406,2\n188#1:408,2\n189#1:410,2\n211#1:412,2\n212#1:414,2\n215#1:416,2\n216#1:418,2\n236#1:420,2\n240#1:422,2\n251#1:424,2\n252#1:426,2\n268#1:428,2\n272#1:430,2\n276#1:432,2\n325#1:434,2\n329#1:436,2\n245#1:440,2\n160#1:438,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsContentView extends FrameLayout implements View.OnClickListener {

    @NotNull
    private final FeatureCommunityPostsContentViewBinding binding;

    @Nullable
    private PostsInfoBean mData;
    private final int mImgSizeStyle2;
    private final int mImgSizeStyle3;
    private final int mLikeColorNor;
    private final int mLikeColorPre;
    private int mPosition;
    private final int mPostSize;
    private int mSingleImgH;
    private int mSingleImgW;
    private int mStyleType;

    @Nullable
    private OnClickListener onViewClickListener;
    private long targetUserId;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/qhqc/core/feature/community/widget/PostsContentView$OnClickListener;", "", "onChildViewClick", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "item", "Lcom/qhqc/core/feature/bean/community/PostsInfoBean;", "position", "", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface OnClickListener {
        void onChildViewClick(@NotNull View view, @NotNull PostsInfoBean item, int position);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PostsContentView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void likeChanged$default(PostsContentView postsContentView, PostsInfoBean postsInfoBean, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        postsContentView.likeChanged(postsInfoBean, z10);
    }

    private final void likeClickAnim(final View view) {
        Spring createSpring = SpringSystem.create().createSpring();
        createSpring.setSpringConfig(new SpringConfig(100.0d, 12.0d));
        createSpring.addListener(new SimpleSpringListener() { // from class: com.qhqc.core.feature.community.widget.PostsContentView$likeClickAnim$1
            @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
            public void onSpringUpdate(Spring spring) {
                Intrinsics.checkNotNullParameter(spring, "spring");
                float currentValue = (float) spring.getCurrentValue();
                View view2 = view;
                if (view2 != null) {
                    view2.setScaleX(currentValue);
                }
                View view3 = view;
                if (view3 != null) {
                    view3.setScaleY(currentValue);
                }
            }
        });
        createSpring.setCurrentValue(0.5d);
        createSpring.setEndValue(1.0d);
    }

    private final void measureImageSize(PostsInfoBean item) {
        GridLayoutManager gridLayoutManager;
        int i10 = this.mStyleType;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        gridLayoutManager = null;
                    } else {
                        gridLayoutManager = new GridLayoutManager(getContext(), 2);
                    }
                } else {
                    gridLayoutManager = new GridLayoutManager(getContext(), 3);
                }
            } else {
                gridLayoutManager = new GridLayoutManager(getContext(), 2);
            }
        } else {
            gridLayoutManager = new GridLayoutManager(getContext(), 1);
        }
        if (gridLayoutManager != null) {
            RecyclerView mRVImages = this.binding.mRVImages;
            Intrinsics.checkNotNullExpressionValue(mRVImages, "mRVImages");
            mRVImages.setVisibility(0);
            this.binding.mRVImages.setLayoutManager(gridLayoutManager);
            this.binding.mRVImages.setAdapter(new PostsListImageAdapter(this.mStyleType));
            return;
        }
        RecyclerView mRVImages2 = this.binding.mRVImages;
        Intrinsics.checkNotNullExpressionValue(mRVImages2, "mRVImages");
        mRVImages2.setVisibility(8);
    }

    private final void resetSingleImgSize(PostsInfoBean item) {
        List<PostsInfoMediaBean> mediaResources;
        PostsInfoMediaBean postsInfoMediaBean;
        if (this.mStyleType == 1 && (mediaResources = item.getMediaResources()) != null && (postsInfoMediaBean = (PostsInfoMediaBean) CollectionsKt.getOrNull(mediaResources, 0)) != null) {
            int width = postsInfoMediaBean.getWidth();
            int height = postsInfoMediaBean.getHeight();
            if (width <= 0) {
                width = this.mPostSize / 3;
            }
            if (height <= 0) {
                height = this.mPostSize / 3;
            }
            if (width > height) {
                int i10 = this.mPostSize;
                this.mSingleImgW = i10;
                this.mSingleImgH = (int) RangesKt.coerceAtLeast(i10 * (height / width), i10 * 0.65f);
            } else {
                int i11 = this.mPostSize;
                int i12 = (int) ((i11 * 25.0f) / 27.0f);
                this.mSingleImgH = i12;
                this.mSingleImgW = (int) RangesKt.coerceAtLeast(i12 * (width / height), i11 * 0.6481481f);
            }
        }
    }

    public static /* synthetic */ void setData$default(PostsContentView postsContentView, PostsInfoBean postsInfoBean, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = -1;
        }
        postsContentView.setData(postsInfoBean, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$9$lambda$6$lambda$5(PostsListImageAdapter postsListImageAdapter, PostsContentView postsContentView, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        ArrayList arrayList = new ArrayList();
        for (PostsInfoMediaBean postsInfoMediaBean : postsListImageAdapter.getData()) {
            if (postsInfoMediaBean.getType() == 1) {
                arrayList.add(postsInfoMediaBean.getUrl());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        CommunityPhotoViewActivity.Companion companion = CommunityPhotoViewActivity.INSTANCE;
        Context context = postsContentView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        companion.start(context, arrayList, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$9$lambda$8$lambda$7(PostsContentView postsContentView, PostsInfoBean postsInfoBean, int i10, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        OnClickListener onClickListener = postsContentView.onViewClickListener;
        if (onClickListener != null) {
            RConstraintLayout mViewLike = postsContentView.binding.mViewLike;
            Intrinsics.checkNotNullExpressionValue(mViewLike, "mViewLike");
            onClickListener.onChildViewClick(mViewLike, postsInfoBean, i10);
        }
    }

    private final void showContent() {
        PostsInfoBean postsInfoBean = this.mData;
        if (postsInfoBean != null) {
            final FeatureCommunityPostsContentViewBinding featureCommunityPostsContentViewBinding = this.binding;
            String content = postsInfoBean.getContent();
            if (content != null && content.length() != 0) {
                TextView mTvContent = featureCommunityPostsContentViewBinding.mTvContent;
                Intrinsics.checkNotNullExpressionValue(mTvContent, "mTvContent");
                mTvContent.setVisibility(0);
                featureCommunityPostsContentViewBinding.mTvContent.setText(postsInfoBean.getContent());
                if (postsInfoBean.isShowAllContent()) {
                    featureCommunityPostsContentViewBinding.mTvContent.setMaxLines(50);
                    AppCompatTextView mTvMore = featureCommunityPostsContentViewBinding.mTvMore;
                    Intrinsics.checkNotNullExpressionValue(mTvMore, "mTvMore");
                    mTvMore.setVisibility(8);
                    return;
                }
                featureCommunityPostsContentViewBinding.mTvContent.setMaxLines(4);
                featureCommunityPostsContentViewBinding.mTvContent.post(new Runnable() { // from class: com.qhqc.core.feature.community.widget.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        PostsContentView.showContent$lambda$13$lambda$12$lambda$11(FeatureCommunityPostsContentViewBinding.this);
                    }
                });
                return;
            }
            AppCompatTextView mTvMore2 = featureCommunityPostsContentViewBinding.mTvMore;
            Intrinsics.checkNotNullExpressionValue(mTvMore2, "mTvMore");
            mTvMore2.setVisibility(8);
            TextView mTvContent2 = featureCommunityPostsContentViewBinding.mTvContent;
            Intrinsics.checkNotNullExpressionValue(mTvContent2, "mTvContent");
            mTvContent2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showContent$lambda$13$lambda$12$lambda$11(FeatureCommunityPostsContentViewBinding featureCommunityPostsContentViewBinding) {
        Layout layout = featureCommunityPostsContentViewBinding.mTvContent.getLayout();
        if (layout != null) {
            AppCompatTextView mTvMore = featureCommunityPostsContentViewBinding.mTvMore;
            Intrinsics.checkNotNullExpressionValue(mTvMore, "mTvMore");
            boolean z10 = true;
            int i10 = 0;
            if (layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
                z10 = false;
            }
            if (!z10) {
                i10 = 8;
            }
            mTvMore.setVisibility(i10);
        }
    }

    public final void commentCountChanged(@NotNull PostsInfoBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.binding.mTvComments.setText(CommunityUtils.INSTANCE.getPostsNumFormat(item.getCommentCount()));
    }

    public final void followUser(@NotNull PostsInfoBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.binding.mViewFollow.followUser();
    }

    @Nullable
    public final OnClickListener getOnViewClickListener() {
        return this.onViewClickListener;
    }

    public final long getTargetUserId() {
        return this.targetUserId;
    }

    public final void likeChanged(@NotNull PostsInfoBean item, boolean isShowAnim) {
        Intrinsics.checkNotNullParameter(item, "item");
        FeatureCommunityPostsContentViewBinding featureCommunityPostsContentViewBinding = this.binding;
        featureCommunityPostsContentViewBinding.mTvLikes.setText(CommunityUtils.INSTANCE.getPostsNumFormat(item.getLikeCount()));
        if (item.isLike()) {
            featureCommunityPostsContentViewBinding.mTvLikes.setTextColor(this.mLikeColorPre);
            featureCommunityPostsContentViewBinding.mIvLike.setImageDrawable(CompatKtxKt.getDrawable(R.drawable.feature_community_ic_posts_likes_pre));
            if (isShowAnim) {
                LottieAnimationView mIvLikeSvga = featureCommunityPostsContentViewBinding.mIvLikeSvga;
                Intrinsics.checkNotNullExpressionValue(mIvLikeSvga, "mIvLikeSvga");
                mIvLikeSvga.setVisibility(0);
                featureCommunityPostsContentViewBinding.mIvLikeSvga.D();
                return;
            }
            LottieAnimationView mIvLikeSvga2 = featureCommunityPostsContentViewBinding.mIvLikeSvga;
            Intrinsics.checkNotNullExpressionValue(mIvLikeSvga2, "mIvLikeSvga");
            mIvLikeSvga2.setVisibility(4);
            featureCommunityPostsContentViewBinding.mIvLikeSvga.r();
            return;
        }
        LottieAnimationView mIvLikeSvga3 = featureCommunityPostsContentViewBinding.mIvLikeSvga;
        Intrinsics.checkNotNullExpressionValue(mIvLikeSvga3, "mIvLikeSvga");
        mIvLikeSvga3.setVisibility(4);
        featureCommunityPostsContentViewBinding.mIvLikeSvga.r();
        featureCommunityPostsContentViewBinding.mTvLikes.setTextColor(this.mLikeColorNor);
        featureCommunityPostsContentViewBinding.mIvLike.setImageDrawable(CompatKtxKt.getDrawable(R.drawable.feature_community_ic_posts_likes));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View p02) {
        PostsInfoBean postsInfoBean;
        if (p02 == null) {
            return;
        }
        if (Intrinsics.areEqual(p02, this.binding.mIvLike) || Intrinsics.areEqual(p02, this.binding.mTvLikes) || Intrinsics.areEqual(p02, this.binding.likeClickView)) {
            likeClickAnim(this.binding.mIvLike);
        }
        OnClickListener onClickListener = this.onViewClickListener;
        if (onClickListener == null || (postsInfoBean = this.mData) == null) {
            return;
        }
        onClickListener.onChildViewClick(p02, postsInfoBean, this.mPosition);
    }

    public final void setData(@NotNull final PostsInfoBean item, final int position) {
        boolean z10;
        final PostsListImageAdapter postsListImageAdapter;
        UserInfoBean user;
        Intrinsics.checkNotNullParameter(item, "item");
        ConstraintLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        if (root.getVisibility() == 8) {
            ConstraintLayout root2 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            root2.setVisibility(0);
        }
        this.mData = item;
        this.mPosition = position;
        FeatureCommunityPostsContentViewBinding featureCommunityPostsContentViewBinding = this.binding;
        UserInfoBean user2 = item.getUser();
        if (user2 != null) {
            featureCommunityPostsContentViewBinding.mIvAvatar.loadData(user2);
            featureCommunityPostsContentViewBinding.mTvName.setText(user2.getNick());
            featureCommunityPostsContentViewBinding.mViewGender.setData(user2.getSex(), user2.getAge(), user2.isShowAge());
            CommunityManager.Companion companion = CommunityManager.INSTANCE;
            Drawable sVipIcon = companion.getInstance().getSVipIcon(user2.getSvipLevel());
            if (sVipIcon != null) {
                AppCompatImageView mIvSVip = featureCommunityPostsContentViewBinding.mIvSVip;
                Intrinsics.checkNotNullExpressionValue(mIvSVip, "mIvSVip");
                mIvSVip.setVisibility(0);
                featureCommunityPostsContentViewBinding.mIvSVip.setImageDrawable(sVipIcon);
            } else {
                AppCompatImageView mIvSVip2 = featureCommunityPostsContentViewBinding.mIvSVip;
                Intrinsics.checkNotNullExpressionValue(mIvSVip2, "mIvSVip");
                mIvSVip2.setVisibility(8);
            }
            Drawable vipIcon = companion.getInstance().getVipIcon(user2.getVipLevel());
            if (vipIcon != null) {
                AppCompatImageView mIvNoble = featureCommunityPostsContentViewBinding.mIvNoble;
                Intrinsics.checkNotNullExpressionValue(mIvNoble, "mIvNoble");
                mIvNoble.setVisibility(0);
                featureCommunityPostsContentViewBinding.mIvNoble.setImageDrawable(vipIcon);
            } else {
                AppCompatImageView mIvNoble2 = featureCommunityPostsContentViewBinding.mIvNoble;
                Intrinsics.checkNotNullExpressionValue(mIvNoble2, "mIvNoble");
                mIvNoble2.setVisibility(8);
            }
        }
        FollowBtnView followBtnView = featureCommunityPostsContentViewBinding.mViewFollow;
        if (!item.isFollowUser() && ((user = item.getUser()) == null || user.getId() != CommunityManager.INSTANCE.getInstance().getUid())) {
            z10 = false;
        } else {
            z10 = true;
        }
        followBtnView.isFollow(z10);
        showContent();
        if (Intrinsics.areEqual(getContext().getResources().getConfiguration().locale.getLanguage(), "ar") || Intrinsics.areEqual(getContext().getResources().getConfiguration().locale.getLanguage(), "ur")) {
            featureCommunityPostsContentViewBinding.mIvLikeListEnd.setScaleX(-1.0f);
        }
        if (!(featureCommunityPostsContentViewBinding.mRVImages.getAdapter() instanceof PostsListImageAdapter)) {
            measureImageSize(item);
        }
        resetSingleImgSize(item);
        RecyclerView.Adapter adapter = featureCommunityPostsContentViewBinding.mRVImages.getAdapter();
        if (adapter instanceof PostsListImageAdapter) {
            postsListImageAdapter = (PostsListImageAdapter) adapter;
        } else {
            postsListImageAdapter = null;
        }
        if (postsListImageAdapter != null) {
            int i10 = this.mStyleType;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 4) {
                            int i11 = this.mImgSizeStyle2;
                            postsListImageAdapter.resizeImageSize(i11, i11);
                        }
                    } else {
                        int i12 = this.mImgSizeStyle3;
                        postsListImageAdapter.resizeImageSize(i12, i12);
                    }
                } else {
                    int i13 = this.mImgSizeStyle2;
                    postsListImageAdapter.resizeImageSize(i13, i13);
                }
            } else {
                postsListImageAdapter.resizeImageSize(this.mSingleImgW, this.mSingleImgH);
            }
            postsListImageAdapter.setList(item.getMediaResources());
            postsListImageAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.qhqc.core.feature.community.widget.c
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i14) {
                    PostsContentView.setData$lambda$9$lambda$6$lambda$5(PostsListImageAdapter.this, this, baseQuickAdapter, view, i14);
                }
            });
        }
        featureCommunityPostsContentViewBinding.mTvTime.setText(CommunityUtils.INSTANCE.getPostsTime(item.getCreatedAt()));
        likeChanged$default(this, item, false, 2, null);
        commentCountChanged(item);
        BasicActivity activity = ActivityUtils.INSTANCE.getActivity(getContext());
        long j10 = this.targetUserId;
        if (j10 != 0 && j10 == CommunityManager.INSTANCE.getInstance().getUid() && (activity instanceof PostsDetailsActivity)) {
            List<UserInfoBean> likeUserList = item.getLikeUserList();
            if (likeUserList != null && !likeUserList.isEmpty()) {
                RConstraintLayout mViewLike = featureCommunityPostsContentViewBinding.mViewLike;
                Intrinsics.checkNotNullExpressionValue(mViewLike, "mViewLike");
                mViewLike.setVisibility(0);
                View mViewBottom = featureCommunityPostsContentViewBinding.mViewBottom;
                Intrinsics.checkNotNullExpressionValue(mViewBottom, "mViewBottom");
                mViewBottom.setVisibility(0);
                if (featureCommunityPostsContentViewBinding.mRVLikes.getAdapter() instanceof PostsListLikeUserAvatarAdapter) {
                    RecyclerView.Adapter adapter2 = featureCommunityPostsContentViewBinding.mRVLikes.getAdapter();
                    Intrinsics.checkNotNull(adapter2, "null cannot be cast to non-null type com.qhqc.core.feature.community.ui.adapter.PostsListLikeUserAvatarAdapter");
                    ((PostsListLikeUserAvatarAdapter) adapter2).setList(item.getLikeUserList());
                    return;
                } else {
                    featureCommunityPostsContentViewBinding.mRVLikes.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                    RecyclerView recyclerView = featureCommunityPostsContentViewBinding.mRVLikes;
                    PostsListLikeUserAvatarAdapter postsListLikeUserAvatarAdapter = new PostsListLikeUserAvatarAdapter();
                    postsListLikeUserAvatarAdapter.setList(item.getLikeUserList());
                    postsListLikeUserAvatarAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.qhqc.core.feature.community.widget.d
                        @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                        public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i14) {
                            PostsContentView.setData$lambda$9$lambda$8$lambda$7(PostsContentView.this, item, position, baseQuickAdapter, view, i14);
                        }
                    });
                    recyclerView.setAdapter(postsListLikeUserAvatarAdapter);
                    return;
                }
            }
            RConstraintLayout mViewLike2 = featureCommunityPostsContentViewBinding.mViewLike;
            Intrinsics.checkNotNullExpressionValue(mViewLike2, "mViewLike");
            mViewLike2.setVisibility(8);
            View mViewBottom2 = featureCommunityPostsContentViewBinding.mViewBottom;
            Intrinsics.checkNotNullExpressionValue(mViewBottom2, "mViewBottom");
            mViewBottom2.setVisibility(0);
            return;
        }
        if (activity instanceof PostsDetailsActivity) {
            View mViewBottom3 = featureCommunityPostsContentViewBinding.mViewBottom;
            Intrinsics.checkNotNullExpressionValue(mViewBottom3, "mViewBottom");
            mViewBottom3.setVisibility(0);
            RConstraintLayout mViewLike3 = featureCommunityPostsContentViewBinding.mViewLike;
            Intrinsics.checkNotNullExpressionValue(mViewLike3, "mViewLike");
            mViewLike3.setVisibility(8);
            return;
        }
        View mViewBottom4 = featureCommunityPostsContentViewBinding.mViewBottom;
        Intrinsics.checkNotNullExpressionValue(mViewBottom4, "mViewBottom");
        mViewBottom4.setVisibility(8);
        RConstraintLayout mViewLike4 = featureCommunityPostsContentViewBinding.mViewLike;
        Intrinsics.checkNotNullExpressionValue(mViewLike4, "mViewLike");
        mViewLike4.setVisibility(8);
    }

    public final void setOnViewClickListener(@Nullable OnClickListener onClickListener) {
        this.onViewClickListener = onClickListener;
    }

    public final void setStyle(int style) {
        this.mStyleType = style;
    }

    public final void setTargetUserId(long j10) {
        this.targetUserId = j10;
    }

    public final void showMoreContent() {
        PostsInfoBean postsInfoBean = this.mData;
        if (postsInfoBean != null) {
            postsInfoBean.setShowAllContent(true);
        }
        showContent();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PostsContentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PostsContentView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PostsContentView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLikeColorNor = CompatKtxKt.getColor(R.color.color_666666);
        this.mLikeColorPre = CompatKtxKt.getColor(R.color.color_E749FF);
        FeatureCommunityPostsContentViewBinding inflate = FeatureCommunityPostsContentViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.mPostSize = DisplayKtxKt.screenWidth() - DisplayKtxKt.getDp(110);
        this.mImgSizeStyle2 = (DisplayKtxKt.screenWidth() - DisplayKtxKt.getDp(Constants.ERR_ALREADY_IN_RECORDING)) / 2;
        this.mImgSizeStyle3 = (DisplayKtxKt.screenWidth() - DisplayKtxKt.getDp(80)) / 3;
        this.mPosition = -1;
        inflate.mIvAvatar.setOnClickListener(this);
        inflate.mViewFollow.setOnClickListener(this);
        inflate.mTvMore.setOnClickListener(this);
        inflate.getRoot().setOnClickListener(this);
        inflate.mTvComments.setOnClickListener(this);
        inflate.mTvLikes.setOnClickListener(this);
        inflate.mIvLike.setOnClickListener(this);
        inflate.likeClickView.setOnClickListener(this);
        inflate.mIvMore.setOnClickListener(this);
        inflate.mViewLike.setOnClickListener(this);
    }
}

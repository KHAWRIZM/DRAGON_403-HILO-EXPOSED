package com.qhqc.core.feature.community.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.qhqc.core.basic.ktx.CompatKtxKt;
import com.qhqc.core.basic.ktx.DisplayKtxKt;
import com.qhqc.core.basic.picture.selector.PicSelectorHelper;
import com.qhqc.core.basic.picture.selector.PictureSelectorConfigures;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.router.provider.IToast;
import com.qhqc.core.basic.widget.toolbar.CommonToolbar;
import com.qhqc.core.basic.widget.toolbar.ICommonToolbar;
import com.qhqc.core.feature.bean.community.PostsCreateMediaBean;
import com.qhqc.core.feature.community.R;
import com.qhqc.core.feature.community.data.viewmodel.PostsCreateViewModel;
import com.qhqc.core.feature.community.databinding.FeatureCommunityActivityPostsCreateBinding;
import com.qhqc.core.feature.community.ui.adapter.PostsCreatePicAdapter;
import com.qhqc.core.feature.uiframe.BaseModelActivity;
import com.ruffian.library.widget.RTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001%B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0015J\b\u0010\u001e\u001a\u00020\u001aH\u0014J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0016\u0010 \u001a\u00020\u001a2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0017J\b\u0010$\u001a\u00020\u001aH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/qhqc/core/feature/community/ui/activity/PostsCreateActivity;", "Lcom/qhqc/core/feature/uiframe/BaseModelActivity;", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityActivityPostsCreateBinding;", "Lcom/qhqc/core/feature/community/data/viewmodel/PostsCreateViewModel;", "Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper$ICallback;", "<init>", "()V", "mBtnSend", "Lcom/ruffian/library/widget/RTextView;", "mMaxLengthContent", "", "mMaxLines", "mPicAdapter", "Lcom/qhqc/core/feature/community/ui/adapter/PostsCreatePicAdapter;", "getMPicAdapter", "()Lcom/qhqc/core/feature/community/ui/adapter/PostsCreatePicAdapter;", "mPicAdapter$delegate", "Lkotlin/Lazy;", "mPicSelectorHelper", "Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper;", "getMPicSelectorHelper", "()Lcom/qhqc/core/basic/picture/selector/PicSelectorHelper;", "mPicSelectorHelper$delegate", "onCreateCommonToolbar", "Lcom/qhqc/core/basic/widget/toolbar/ICommonToolbar;", "onInit", "", "savedInstanceState", "Landroid/os/Bundle;", "initEvent", "initData", "getPictures", "onPictureSelectorImagesResult", "result", "", "Lcom/luck/picture/lib/entity/LocalMedia;", "checkSendBtn", "Companion", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPostsCreateActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsCreateActivity.kt\ncom/qhqc/core/feature/community/ui/activity/PostsCreateActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,265:1\n58#2,23:266\n93#2,3:289\n49#2:292\n65#2,16:293\n93#2,3:309\n1863#3,2:312\n1863#3,2:314\n*S KotlinDebug\n*F\n+ 1 PostsCreateActivity.kt\ncom/qhqc/core/feature/community/ui/activity/PostsCreateActivity\n*L\n145#1:266,23\n145#1:289,3\n164#1:292\n164#1:293,16\n164#1:309,3\n114#1:312,2\n171#1:314,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PostsCreateActivity extends BaseModelActivity<FeatureCommunityActivityPostsCreateBinding, PostsCreateViewModel> implements PicSelectorHelper.ICallback {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private RTextView mBtnSend;
    private final int mMaxLengthContent = 1000;
    private final int mMaxLines = 50;

    /* renamed from: mPicAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPicAdapter = LazyKt.lazy(new Function0() { // from class: com.qhqc.core.feature.community.ui.activity.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PostsCreatePicAdapter mPicAdapter_delegate$lambda$0;
            mPicAdapter_delegate$lambda$0 = PostsCreateActivity.mPicAdapter_delegate$lambda$0();
            return mPicAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: mPicSelectorHelper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPicSelectorHelper = LazyKt.lazy(new Function0() { // from class: com.qhqc.core.feature.community.ui.activity.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            PicSelectorHelper mPicSelectorHelper_delegate$lambda$2;
            mPicSelectorHelper_delegate$lambda$2 = PostsCreateActivity.mPicSelectorHelper_delegate$lambda$2(PostsCreateActivity.this);
            return mPicSelectorHelper_delegate$lambda$2;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/qhqc/core/feature/community/ui/activity/PostsCreateActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) PostsCreateActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FeatureCommunityActivityPostsCreateBinding access$getBinding(PostsCreateActivity postsCreateActivity) {
        return (FeatureCommunityActivityPostsCreateBinding) postsCreateActivity.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkSendBtn() {
        if (getMPicAdapter().getData().size() > 1) {
            RTextView rTextView = this.mBtnSend;
            if (rTextView != null) {
                rTextView.setEnabled(true);
            }
            RTextView rTextView2 = this.mBtnSend;
            if (rTextView2 != null) {
                rTextView2.setTextColor(CompatKtxKt.getColor(R.color.color_8833FF));
                return;
            }
            return;
        }
        RTextView rTextView3 = this.mBtnSend;
        if (rTextView3 != null) {
            rTextView3.setEnabled(false);
        }
        RTextView rTextView4 = this.mBtnSend;
        if (rTextView4 != null) {
            rTextView4.setTextColor(CompatKtxKt.getColor(R.color.color_4D8833FF));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PostsCreatePicAdapter getMPicAdapter() {
        return (PostsCreatePicAdapter) this.mPicAdapter.getValue();
    }

    private final PicSelectorHelper getMPicSelectorHelper() {
        return (PicSelectorHelper) this.mPicSelectorHelper.getValue();
    }

    private final void getPictures() {
        getMPicSelectorHelper().getPicture(this, new PictureSelectorConfigures.Companion.Builder().setMShowType(SelectMimeType.ofImage()).isMEnableCrop(false).isMCompress(true).setMMaxSelect(9 - (getMPicAdapter().getData().size() - 1)).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$15(PostsCreateActivity postsCreateActivity, Pair pair) {
        if (((Number) pair.getFirst()).intValue() == 1) {
            IToast iToast = BasicModuleApp.INSTANCE.toastImpl();
            if (iToast != null) {
                iToast.showToast(CompatKtxKt.getString(R.string.feature_community_posts_create_success));
            }
            postsCreateActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEvent$lambda$10(PostsCreateActivity postsCreateActivity, BaseQuickAdapter baseQuickAdapter, View v10, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(v10, "v");
        postsCreateActivity.getMPicAdapter().getItem(i10);
        if (v10.getId() == R.id.mIvDel) {
            postsCreateActivity.getMPicAdapter().removeAt(i10);
            if (postsCreateActivity.getMPicAdapter().getData().size() == 0 || !postsCreateActivity.getMPicAdapter().getData().get(CollectionsKt.getLastIndex(postsCreateActivity.getMPicAdapter().getData())).isAddPic()) {
                postsCreateActivity.getMPicAdapter().addData((PostsCreatePicAdapter) new PostsCreateMediaBean(0, null, 0, 0, 0L, null, null, null, true, KotlinVersion.MAX_COMPONENT_VALUE, null));
            }
            postsCreateActivity.checkSendBtn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initEvent$lambda$14(PostsCreateActivity postsCreateActivity, View view) {
        ArrayList arrayList = new ArrayList();
        for (PostsCreateMediaBean postsCreateMediaBean : postsCreateActivity.getMPicAdapter().getData()) {
            String path = postsCreateMediaBean.getPath();
            if (path != null && path.length() != 0) {
                arrayList.add(postsCreateMediaBean);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        PostsCreateViewModel.uploadImages$default((PostsCreateViewModel) postsCreateActivity.m٥٢١getViewModel(), 0, String.valueOf(((FeatureCommunityActivityPostsCreateBinding) postsCreateActivity.getBinding()).mTvContent.getText()), arrayList, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEvent$lambda$8(PostsCreateActivity postsCreateActivity, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (postsCreateActivity.getMPicAdapter().getItem(i10).isAddPic()) {
            postsCreateActivity.getPictures();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (PostsCreateMediaBean postsCreateMediaBean : postsCreateActivity.getMPicAdapter().getData()) {
            if (postsCreateMediaBean.getMediaType() == 1 && !postsCreateMediaBean.isAddPic()) {
                arrayList.add(postsCreateMediaBean.getPath());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        CommunityPhotoViewActivity.INSTANCE.start(postsCreateActivity, arrayList, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PostsCreatePicAdapter mPicAdapter_delegate$lambda$0() {
        return new PostsCreatePicAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PicSelectorHelper mPicSelectorHelper_delegate$lambda$2(PostsCreateActivity postsCreateActivity) {
        PicSelectorHelper picSelectorHelper = new PicSelectorHelper(postsCreateActivity);
        picSelectorHelper.setCallBack(postsCreateActivity);
        return picSelectorHelper;
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void initData() {
        ((PostsCreateViewModel) m٥٢١getViewModel()).getOnSuccessLD().observe(this, new PostsCreateActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qhqc.core.feature.community.ui.activity.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit initData$lambda$15;
                initData$lambda$15 = PostsCreateActivity.initData$lambda$15(PostsCreateActivity.this, (Pair) obj);
                return initData$lambda$15;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    @SuppressLint({"SetTextI18n"})
    public void initEvent() {
        getMPicAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.c
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                PostsCreateActivity.initEvent$lambda$8(PostsCreateActivity.this, baseQuickAdapter, view, i10);
            }
        });
        getMPicAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.d
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                PostsCreateActivity.initEvent$lambda$10(PostsCreateActivity.this, baseQuickAdapter, view, i10);
            }
        });
        ((FeatureCommunityActivityPostsCreateBinding) getBinding()).mTvContent.setMaxLines(this.mMaxLines);
        AppCompatEditText mTvContent = ((FeatureCommunityActivityPostsCreateBinding) getBinding()).mTvContent;
        Intrinsics.checkNotNullExpressionValue(mTvContent, "mTvContent");
        mTvContent.addTextChangedListener(new TextWatcher() { // from class: com.qhqc.core.feature.community.ui.activity.PostsCreateActivity$initEvent$$inlined$doAfterTextChanged$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s10) {
                int i10;
                String substring;
                if (s10 != null) {
                    int lineCount = PostsCreateActivity.access$getBinding(PostsCreateActivity.this).mTvContent.getLineCount();
                    i10 = PostsCreateActivity.this.mMaxLines;
                    if (lineCount > i10) {
                        String obj = s10.toString();
                        int selectionStart = PostsCreateActivity.access$getBinding(PostsCreateActivity.this).mTvContent.getSelectionStart();
                        int i11 = 0;
                        if (selectionStart == PostsCreateActivity.access$getBinding(PostsCreateActivity.this).mTvContent.getSelectionEnd() && selectionStart < obj.length() && selectionStart >= 1) {
                            String substring2 = obj.substring(0, selectionStart - 1);
                            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                            String substring3 = obj.substring(selectionStart);
                            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                            substring = substring2 + substring3;
                        } else {
                            substring = obj.substring(0, s10.length() - 1);
                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        }
                        PostsCreateActivity.access$getBinding(PostsCreateActivity.this).mTvContent.setText(substring);
                        AppCompatEditText appCompatEditText = PostsCreateActivity.access$getBinding(PostsCreateActivity.this).mTvContent;
                        Editable text = PostsCreateActivity.access$getBinding(PostsCreateActivity.this).mTvContent.getText();
                        if (text != null) {
                            i11 = text.length();
                        }
                        appCompatEditText.setSelection(i11);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            }
        });
        AppCompatEditText mTvContent2 = ((FeatureCommunityActivityPostsCreateBinding) getBinding()).mTvContent;
        Intrinsics.checkNotNullExpressionValue(mTvContent2, "mTvContent");
        mTvContent2.addTextChangedListener(new TextWatcher() { // from class: com.qhqc.core.feature.community.ui.activity.PostsCreateActivity$initEvent$$inlined$doOnTextChanged$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s10) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
                Integer num;
                int i10;
                TextView textView = PostsCreateActivity.access$getBinding(PostsCreateActivity.this).mTvContentCount;
                Editable text2 = PostsCreateActivity.access$getBinding(PostsCreateActivity.this).mTvContent.getText();
                if (text2 != null) {
                    num = Integer.valueOf(text2.length());
                } else {
                    num = null;
                }
                i10 = PostsCreateActivity.this.mMaxLengthContent;
                textView.setText(num + "/" + i10);
            }
        });
        RTextView rTextView = this.mBtnSend;
        if (rTextView != null) {
            rTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.feature.community.ui.activity.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PostsCreateActivity.initEvent$lambda$14(PostsCreateActivity.this, view);
                }
            });
        }
    }

    @Override // com.qhqc.core.feature.uiframe.BaseModelActivity
    @NotNull
    protected ICommonToolbar onCreateCommonToolbar() {
        return new CommonToolbar.Builder().setTitle(R.string.release).build(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qhqc.core.basic.uiframe.ui.BasicVMActivity
    public void onInit(@Nullable Bundle savedInstanceState) {
        CommonToolbar commonToolbar;
        super.onInit(savedInstanceState);
        RTextView rTextView = new RTextView(this);
        mc.c helper = rTextView.getHelper();
        int i10 = com.qhqc.core.basic.R.color.white;
        helper.m(CompatKtxKt.getColor(i10));
        rTextView.getHelper().o(CompatKtxKt.getColor(i10));
        rTextView.getHelper().u(DisplayKtxKt.getDp(27));
        rTextView.setTextColor(CompatKtxKt.getColor(R.color.color_4D8833FF));
        rTextView.setText(R.string.send);
        rTextView.setEnabled(false);
        rTextView.setHeight(DisplayKtxKt.getDp(27));
        rTextView.setGravity(17);
        this.mBtnSend = rTextView;
        ICommonToolbar commonToolbar2 = getCommonToolbar();
        if (commonToolbar2 instanceof CommonToolbar) {
            commonToolbar = (CommonToolbar) commonToolbar2;
        } else {
            commonToolbar = null;
        }
        if (commonToolbar != null) {
            RTextView rTextView2 = this.mBtnSend;
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.setMarginEnd(DisplayKtxKt.getDp(15));
            Unit unit = Unit.INSTANCE;
            commonToolbar.setMenuView(rTextView2, marginLayoutParams);
        }
        FeatureCommunityActivityPostsCreateBinding featureCommunityActivityPostsCreateBinding = (FeatureCommunityActivityPostsCreateBinding) getBinding();
        featureCommunityActivityPostsCreateBinding.mRVPictures.setLayoutManager(new GridLayoutManager(this, 3));
        featureCommunityActivityPostsCreateBinding.mRVPictures.setAdapter(getMPicAdapter());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PostsCreateMediaBean(0, null, 0, 0, 0L, null, null, null, true, KotlinVersion.MAX_COMPONENT_VALUE, null));
        getMPicAdapter().setList(arrayList);
        new ItemTouchHelper(new PostsCreatePicAdapter.TouchCallback(getMPicAdapter())).attachToRecyclerView(featureCommunityActivityPostsCreateBinding.mRVPictures);
    }

    @Override // com.qhqc.core.basic.picture.selector.PicSelectorHelper.ICallback
    @SuppressLint({"NotifyDataSetChanged"})
    public void onPictureSelectorImagesResult(@NotNull List<LocalMedia> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        ArrayList arrayList = new ArrayList();
        for (PostsCreateMediaBean postsCreateMediaBean : getMPicAdapter().getData()) {
            if (!postsCreateMediaBean.isAddPic()) {
                arrayList.add(postsCreateMediaBean);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PostsCreateActivity$onPictureSelectorImagesResult$1(result, arrayList, this, null), 3, null);
    }
}

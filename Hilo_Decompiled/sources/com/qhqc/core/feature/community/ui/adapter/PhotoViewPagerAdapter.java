package com.qhqc.core.feature.community.ui.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.bumptech.glide.Glide;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.qhqc.core.basic.picture.glide.GlideConstant;
import com.qhqc.core.basic.rvadapter.BasicVBAdapter;
import com.qhqc.core.basic.rvadapter.BasicViewBindingHolder;
import com.qhqc.core.feature.community.databinding.FeatureCommunityItemPhotoViewBinding;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\n\u001a\u00020\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0014\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/PhotoViewPagerAdapter;", "Lcom/qhqc/core/basic/rvadapter/BasicVBAdapter;", "", "Lcom/qhqc/core/feature/community/databinding/FeatureCommunityItemPhotoViewBinding;", "<init>", "()V", "Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;", "holder", "item", "", "convert", "(Lcom/qhqc/core/basic/rvadapter/BasicViewBindingHolder;Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Landroid/view/LayoutInflater;", "layoutInflater", "", "attachToParent", "onCreateViewBinding", "(Landroid/view/ViewGroup;ILandroid/view/LayoutInflater;Z)Lcom/qhqc/core/feature/community/databinding/FeatureCommunityItemPhotoViewBinding;", "Lc5/h;", "requestOptions", "Lc5/h;", "Lkotlin/Function0;", "imageClickListener", "Lkotlin/jvm/functions/Function0;", "getImageClickListener", "()Lkotlin/jvm/functions/Function0;", "setImageClickListener", "(Lkotlin/jvm/functions/Function0;)V", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPhotoViewPagerAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PhotoViewPagerAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PhotoViewPagerAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,66:1\n256#2,2:67\n*S KotlinDebug\n*F\n+ 1 PhotoViewPagerAdapter.kt\ncom/qhqc/core/feature/community/ui/adapter/PhotoViewPagerAdapter\n*L\n39#1:67,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PhotoViewPagerAdapter extends BasicVBAdapter<String, FeatureCommunityItemPhotoViewBinding> {

    @Nullable
    private Function0<Unit> imageClickListener;

    @NotNull
    private c5.h requestOptions;

    public PhotoViewPagerAdapter() {
        c5.h hVar = (c5.h) ((c5.h) new c5.h().g(j.f١٦٦٣٨c)).h0(true);
        GlideConstant glideConstant = GlideConstant.INSTANCE;
        c5.a j10 = ((c5.h) hVar.X(glideConstant.getTRANSPARENT())).j(glideConstant.getTRANSPARENT());
        Intrinsics.checkNotNullExpressionValue(j10, "error(...)");
        this.requestOptions = (c5.h) j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1$lambda$0(PhotoViewPagerAdapter photoViewPagerAdapter, View view) {
        Function0<Unit> function0 = photoViewPagerAdapter.imageClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Nullable
    public final Function0<Unit> getImageClickListener() {
        return this.imageClickListener;
    }

    public final void setImageClickListener(@Nullable Function0<Unit> function0) {
        this.imageClickListener = function0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BasicViewBindingHolder<FeatureCommunityItemPhotoViewBinding> holder, @Nullable String item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final FeatureCommunityItemPhotoViewBinding viewBinding = holder.getViewBinding();
        ProgressBar mProgress = viewBinding.mProgress;
        Intrinsics.checkNotNullExpressionValue(mProgress, "mProgress");
        mProgress.setVisibility(0);
        Glide.with(viewBinding.mIvSubsampling).h(item).a(this.requestOptions).A0(new com.bumptech.glide.request.target.c() { // from class: com.qhqc.core.feature.community.ui.adapter.PhotoViewPagerAdapter$convert$1$1
            @Override // com.bumptech.glide.request.target.j
            public void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.j
            public void onResourceReady(File resource, d5.b transition) {
                Intrinsics.checkNotNullParameter(resource, "resource");
                ProgressBar mProgress2 = FeatureCommunityItemPhotoViewBinding.this.mProgress;
                Intrinsics.checkNotNullExpressionValue(mProgress2, "mProgress");
                mProgress2.setVisibility(8);
                FeatureCommunityItemPhotoViewBinding.this.mIvSubsampling.setImage(ImageSource.uri(resource.getAbsolutePath()));
            }
        });
        viewBinding.mIvSubsampling.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.feature.community.ui.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoViewPagerAdapter.convert$lambda$1$lambda$0(PhotoViewPagerAdapter.this, view);
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qhqc.core.basic.rvadapter.BasicVBAdapter
    @NotNull
    public FeatureCommunityItemPhotoViewBinding onCreateViewBinding(@NotNull ViewGroup parent, int viewType, @NotNull LayoutInflater layoutInflater, boolean attachToParent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
        FeatureCommunityItemPhotoViewBinding inflate = FeatureCommunityItemPhotoViewBinding.inflate(layoutInflater, parent, attachToParent);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}

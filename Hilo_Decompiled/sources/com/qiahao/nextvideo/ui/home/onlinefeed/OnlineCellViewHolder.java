package com.qiahao.nextvideo.ui.home.onlinefeed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.CellOnlineBinding;
import com.qiahao.nextvideo.ui.home.onlinefeed.list.OnlineCellUIModel;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.taobao.accs.common.Constants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/onlinefeed/OnlineCellViewHolder;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "Lcom/qiahao/nextvideo/databinding/CellOnlineBinding;", "binding", "<init>", "(Lcom/qiahao/nextvideo/databinding/CellOnlineBinding;)V", "Lcom/qiahao/nextvideo/ui/home/onlinefeed/list/OnlineCellUIModel;", Constants.KEY_MODEL, "", VerificationCodeFragment.TYPE_BIND, "(Lcom/qiahao/nextvideo/ui/home/onlinefeed/list/OnlineCellUIModel;)V", "Lcom/qiahao/nextvideo/databinding/CellOnlineBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/CellOnlineBinding;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OnlineCellViewHolder extends ViewHolder {

    @NotNull
    public static final String CLICK_CHAT = "chat";

    @NotNull
    public static final String CLICK_LIKE = "like";

    @NotNull
    private final CellOnlineBinding binding;

    @NotNull
    private nd.a compositeDisposable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OnlineCellViewHolder(@NotNull CellOnlineBinding cellOnlineBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(cellOnlineBinding, "binding");
        View root = cellOnlineBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = cellOnlineBinding;
        this.compositeDisposable = new nd.a();
    }

    public final void bind(@NotNull final OnlineCellUIModel model) {
        int i;
        int i2;
        Integer valueOf;
        String str;
        int i3;
        int i4;
        int i5;
        Integer level;
        Integer level2;
        boolean z;
        Integer isShowAge;
        int i6;
        Integer level3;
        Integer level4;
        Intrinsics.checkNotNullParameter(model, Constants.KEY_MODEL);
        if (model.isLiked()) {
            if (model.isLikeMe()) {
                i = R.drawable.ic_online_like_each;
            } else {
                i = R.drawable.ic_online_liked;
            }
        } else {
            i = R.drawable.ic_online_unlike;
        }
        Resources resources = this.binding.getRoot().getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        Drawable drawable = ResourceUtilsKt.getDrawable(resources, model.getSexTag(), 0);
        this.binding.likeImageView.setTag(CLICK_LIKE);
        this.binding.chatImageView.setTag(CLICK_CHAT);
        this.binding.nicknameTextView.setText(model.getNickname());
        NobleInfo noble = model.getNoble();
        if (noble != null && (level4 = noble.getLevel()) != null) {
            i2 = level4.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            AppCompatTextView appCompatTextView = this.binding.nicknameTextView;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = model.getNoble();
            if (noble2 != null && (level3 = noble2.getLevel()) != null) {
                i6 = level3.intValue();
            } else {
                i6 = 0;
            }
            appCompatTextView.setTextColor(UserService.Companion.getNobleColor$default(companion, i6, 0, 2, null));
        } else {
            AppCompatTextView appCompatTextView2 = this.binding.nicknameTextView;
            appCompatTextView2.setTextColor(androidx.core.content.a.getColor(appCompatTextView2.getContext(), 2131101214));
        }
        Dimens dimens = Dimens.INSTANCE;
        int screenWidth = (dimens.getScreenWidth() - dimens.dpToPx(42)) / 2;
        this.binding.backgroundFitRatioFrameLayout.setWeight(screenWidth, (int) (screenWidth * 1.5471698f));
        CorneredImageView corneredImageView = this.binding.backgroundCorneredImageView;
        Intrinsics.checkNotNullExpressionValue(corneredImageView, "backgroundCorneredImageView");
        ImageUIModel thumbnail = model.getThumbnail();
        if (model.getSex() == 1) {
            valueOf = Integer.valueOf(R.drawable.bg_default_online_list_male_placeholder);
        } else {
            valueOf = Integer.valueOf(R.drawable.bg_default_online_list_female_placeholder);
        }
        thumbnail.setPlaceholder(valueOf);
        ViewUtilitiesKt.bind$default(corneredImageView, thumbnail, null, 2, null);
        this.binding.chatImageView.startAnimation();
        AppCompatImageView appCompatImageView = this.binding.likeImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "likeImageView");
        ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(i), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        AppCompatImageView appCompatImageView2 = this.binding.fromCountryImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "fromCountryImageView");
        ViewUtilitiesKt.bind$default(appCompatImageView2, model.getCountry(), null, 2, null);
        this.compositeDisposable.d();
        nd.c subscribe = OnlineUsersItemListViewWrapper.INSTANCE.getRelay().observeOn(RxUtilsKt.getMainThread()).filter(new pd.q() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.OnlineCellViewHolder$bind$2
            public final boolean test(AnimationEvent animationEvent) {
                return Intrinsics.areEqual(animationEvent.getId(), OnlineCellUIModel.this.getUid());
            }
        }).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.OnlineCellViewHolder$bind$3
            public final void accept(AnimationEvent animationEvent) {
                try {
                    if (OnlineCellViewHolder.this.getBinding().likeSvgaImageView.isAnimating()) {
                        return;
                    }
                    SVGAParser shareParser = SVGAParser.Companion.shareParser();
                    final OnlineCellViewHolder onlineCellViewHolder = OnlineCellViewHolder.this;
                    shareParser.decodeFromAssets("svga/like.svga", new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.OnlineCellViewHolder$bind$3.1
                        public void onComplete(SVGAVideoEntity videoItem) {
                            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                            OnlineCellViewHolder.this.getBinding().likeSvgaImageView.stopAnimation(true);
                            OnlineCellViewHolder.this.getBinding().likeSvgaImageView.setImageDrawable(new SVGADrawable(videoItem));
                            OnlineCellViewHolder.this.getBinding().likeSvgaImageView.startAnimation();
                        }

                        public void onError() {
                        }
                    });
                } catch (Exception e) {
                    DebugToolsKt.printfE(OnlineUsersItemListViewWrapper.TAG, "eventRelay 内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        AppCompatTextView appCompatTextView3 = this.binding.ageTextView;
        appCompatTextView3.setText(model.getAge());
        UserStore.Companion companion2 = UserStore.INSTANCE;
        User user = companion2.getShared().getUser();
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, model.getUid())) {
            User user2 = companion2.getShared().getUser();
            if (user2 != null && (isShowAge = user2.isShowAge()) != null && isShowAge.intValue() == 2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                appCompatTextView3.setText("");
            }
        }
        if (model.getSex() == 1) {
            i3 = R.drawable.bg_age_male;
        } else {
            i3 = R.drawable.bg_age_female;
        }
        appCompatTextView3.setBackgroundResource(i3);
        appCompatTextView3.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        if (model.isVip()) {
            this.binding.iconVip.setVisibility(0);
        } else {
            this.binding.iconVip.setVisibility(8);
        }
        NobleInfo noble3 = model.getNoble();
        if (noble3 != null && (level2 = noble3.getLevel()) != null) {
            i4 = level2.intValue();
        } else {
            i4 = 0;
        }
        if (i4 > 0) {
            CellOnlineBinding cellOnlineBinding = this.binding;
            ImageView imageView = cellOnlineBinding.iconNoble;
            Context context = cellOnlineBinding.getRoot().getContext();
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble4 = model.getNoble();
            if (noble4 != null && (level = noble4.getLevel()) != null) {
                i5 = level.intValue();
            } else {
                i5 = 0;
            }
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion3.getNobleDrawableRes(i5)));
            this.binding.iconNoble.setVisibility(0);
            return;
        }
        this.binding.iconNoble.setVisibility(8);
    }

    @NotNull
    public final CellOnlineBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }
}

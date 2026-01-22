package com.qiahao.nextvideo.ui.balloon;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.BalloonLikeEachOtherBinding;
import com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloon;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.AnimationUtilitiesKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.skydoves.balloon.Balloon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloon;", "", "context", "Landroid/content/Context;", "builder", "Lcom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloon$Builder;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloon$Builder;)V", "getContext", "()Landroid/content/Context;", "getBuilder", "()Lcom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloon$Builder;", "show", "", AgooConstants.OPEN_ACTIIVTY_NAME, "Landroid/app/Activity;", "dismiss", "Companion", "Builder", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LikeEachOtherBalloon {
    private static final long avatarAnimationSetStartDelayInMills = 250;

    @NotNull
    private final Builder builder;

    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloon$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "balloon", "Lcom/skydoves/balloon/Balloon;", "getBalloon", "()Lcom/skydoves/balloon/Balloon;", "setBalloon", "(Lcom/skydoves/balloon/Balloon;)V", "remoteUser", "Lcom/qiahao/base_common/model/common/User;", "getRemoteUser", "()Lcom/qiahao/base_common/model/common/User;", "setRemoteUser", "(Lcom/qiahao/base_common/model/common/User;)V", "localUser", "getLocalUser", "setLocalUser", "delegate", "Lcom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloonDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloonDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloonDelegate;)V", "build", "Lcom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloon;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLikeEachOtherBalloon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LikeEachOtherBalloon.kt\ncom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloon$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Balloon.kt\ncom/skydoves/balloon/BalloonKt\n*L\n1#1,198:1\n1#2:199\n94#3:200\n*S KotlinDebug\n*F\n+ 1 LikeEachOtherBalloon.kt\ncom/qiahao/nextvideo/ui/balloon/LikeEachOtherBalloon$Builder\n*L\n121#1:200\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Builder {
        public Balloon balloon;

        @NotNull
        private final Context context;

        @Nullable
        private LikeEachOtherBalloonDelegate delegate;

        @Nullable
        private User localUser;

        @Nullable
        private User remoteUser;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void build$lambda$11(Builder builder, View view) {
            builder.getBalloon().dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit build$lambda$12(Builder builder, View view) {
            Intrinsics.checkNotNullParameter(view, "it");
            LikeEachOtherBalloonDelegate likeEachOtherBalloonDelegate = builder.delegate;
            if (likeEachOtherBalloonDelegate != null) {
                likeEachOtherBalloonDelegate.likeEachClick(builder.remoteUser);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit build$lambda$13(BalloonLikeEachOtherBinding balloonLikeEachOtherBinding, ObjectAnimator objectAnimator) {
            balloonLikeEachOtherBinding.svgaImageView.stopAnimation(true);
            objectAnimator.removeAllListeners();
            objectAnimator.removeAllUpdateListeners();
            return Unit.INSTANCE;
        }

        @SuppressLint({"ObjectAnimatorBinding"})
        @NotNull
        public final LikeEachOtherBalloon build() {
            final ObjectAnimator ofFloat;
            ObjectAnimator ofFloat2;
            String str;
            String str2;
            final BalloonLikeEachOtherBinding inflate = BalloonLikeEachOtherBinding.inflate(LayoutInflater.from(this.context));
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            inflate.leftCircleImageView.setAlpha(0.0f);
            inflate.rightCircleImageView.setAlpha(0.0f);
            final ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(inflate.likeIconImageView, AnimationUtilitiesKt.propertyNameInScaleX, 0.1f, 1.2f, 1.0f);
            ofFloat3.setDuration(400L);
            final ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(inflate.likeIconImageView, AnimationUtilitiesKt.propertyNameInScaleY, 0.1f, 1.2f, 1.0f);
            ofFloat4.setDuration(400L);
            final ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat((Object) null, AnimationUtilitiesKt.propertyNameInScaleX, 0.1f, 1.2f, 1.0f);
            ofFloat5.setDuration(600L);
            final ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat((Object) null, AnimationUtilitiesKt.propertyNameInScaleY, 0.1f, 1.2f, 1.0f);
            ofFloat6.setDuration(600L);
            if (ViewUtilitiesKt.getRightToLeftDirection()) {
                CircleImageView circleImageView = inflate.leftCircleImageView;
                Dimens dimens = Dimens.INSTANCE;
                ofFloat = ObjectAnimator.ofFloat(circleImageView, AnimationUtilitiesKt.propertyNameInTranslationX, 0.0f, -dimens.dpToPx(35), -dimens.dpToPx(25), -dimens.dpToPx(35));
                ofFloat.setDuration(800L);
            } else {
                CircleImageView circleImageView2 = inflate.leftCircleImageView;
                Dimens dimens2 = Dimens.INSTANCE;
                ofFloat = ObjectAnimator.ofFloat(circleImageView2, AnimationUtilitiesKt.propertyNameInTranslationX, 0.0f, dimens2.dpToPx(35), dimens2.dpToPx(25), dimens2.dpToPx(35));
                ofFloat.setDuration(800L);
            }
            if (ViewUtilitiesKt.getRightToLeftDirection()) {
                CircleImageView circleImageView3 = inflate.rightCircleImageView;
                Dimens dimens3 = Dimens.INSTANCE;
                ofFloat2 = ObjectAnimator.ofFloat(circleImageView3, AnimationUtilitiesKt.propertyNameInTranslationX, 0.0f, dimens3.dpToPx(35), dimens3.dpToPx(25), dimens3.dpToPx(35));
                ofFloat2.setDuration(800L);
            } else {
                CircleImageView circleImageView4 = inflate.rightCircleImageView;
                Dimens dimens4 = Dimens.INSTANCE;
                ofFloat2 = ObjectAnimator.ofFloat(circleImageView4, AnimationUtilitiesKt.propertyNameInTranslationX, 0.0f, -dimens4.dpToPx(35), -dimens4.dpToPx(25), -dimens4.dpToPx(35));
                ofFloat2.setDuration(800L);
            }
            final ObjectAnimator objectAnimator = ofFloat2;
            CircleImageView circleImageView5 = inflate.leftCircleImageView;
            Intrinsics.checkNotNullExpressionValue(circleImageView5, "leftCircleImageView");
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            User user = this.remoteUser;
            if (user != null) {
                str = user.getAvatar();
            } else {
                str = null;
            }
            ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
            Dimens dimens5 = Dimens.INSTANCE;
            lfit.setWidth(dimens5.dpToPx(72));
            lfit.setHeight(dimens5.dpToPx(72));
            Unit unit = Unit.INSTANCE;
            ViewUtilitiesKt.bind$default(circleImageView5, companion.displayUserAvatarImage(str, lfit), null, 2, null);
            CircleImageView circleImageView6 = inflate.rightCircleImageView;
            Intrinsics.checkNotNullExpressionValue(circleImageView6, "rightCircleImageView");
            User user2 = this.localUser;
            if (user2 != null) {
                str2 = user2.getAvatar();
            } else {
                str2 = null;
            }
            lfit.setWidth(dimens5.dpToPx(72));
            lfit.setHeight(dimens5.dpToPx(72));
            ViewUtilitiesKt.bind$default(circleImageView6, companion.displayUserAvatarImage(str2, lfit), null, 2, null);
            Balloon.Builder builder = new Balloon.Builder(this.context);
            View root = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            builder.setLayout(root);
            builder.setBalloonAnimationStyle(R.style.LikeEachOtherBalloonAnimation10);
            builder.setArrowSize(0);
            builder.setHeight(180);
            builder.setElevation(0);
            builder.marginTop = dimens5.getMarginXLarge();
            builder.setWidthRatio(0.88f);
            builder.setAutoDismissDuration(4800L);
            builder.setBackgroundDrawableResource(R.drawable.bg_balloon_like_each_other);
            builder.setDismissWhenTouchOutside(false);
            final ObjectAnimator objectAnimator2 = ofFloat;
            builder.setOnBalloonInitializedListener(new Function1<View, Unit>() { // from class: com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloon$Builder$build$3$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((View) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(View view) {
                    Intrinsics.checkNotNullParameter(view, "it");
                    AnimatorSet animatorSet = new AnimatorSet();
                    ObjectAnimator objectAnimator3 = ofFloat5;
                    ObjectAnimator objectAnimator4 = ofFloat6;
                    ObjectAnimator objectAnimator5 = objectAnimator2;
                    BalloonLikeEachOtherBinding balloonLikeEachOtherBinding = BalloonLikeEachOtherBinding.this;
                    ObjectAnimator clone = objectAnimator3.clone();
                    clone.setTarget(balloonLikeEachOtherBinding.leftCircleImageView);
                    AnimatorSet.Builder play = animatorSet.play(clone);
                    ObjectAnimator clone2 = objectAnimator4.clone();
                    clone2.setTarget(balloonLikeEachOtherBinding.leftCircleImageView);
                    play.with(clone2).before(objectAnimator5);
                    animatorSet.setStartDelay(250L);
                    animatorSet.start();
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    ObjectAnimator objectAnimator6 = ofFloat5;
                    ObjectAnimator objectAnimator7 = ofFloat6;
                    ObjectAnimator objectAnimator8 = objectAnimator;
                    BalloonLikeEachOtherBinding balloonLikeEachOtherBinding2 = BalloonLikeEachOtherBinding.this;
                    ObjectAnimator clone3 = objectAnimator6.clone();
                    clone3.setTarget(balloonLikeEachOtherBinding2.rightCircleImageView);
                    AnimatorSet.Builder play2 = animatorSet2.play(clone3);
                    ObjectAnimator clone4 = objectAnimator7.clone();
                    clone4.setTarget(balloonLikeEachOtherBinding2.rightCircleImageView);
                    play2.with(clone4).before(objectAnimator8);
                    animatorSet2.setStartDelay(250L);
                    animatorSet2.start();
                    View root2 = BalloonLikeEachOtherBinding.this.getRoot();
                    final BalloonLikeEachOtherBinding balloonLikeEachOtherBinding3 = BalloonLikeEachOtherBinding.this;
                    root2.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloon$Builder$build$3$1.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            BalloonLikeEachOtherBinding.this.leftCircleImageView.setAlpha(1.0f);
                            BalloonLikeEachOtherBinding.this.rightCircleImageView.setAlpha(1.0f);
                        }
                    }, 250L);
                    ObjectAnimator objectAnimator9 = objectAnimator2;
                    final ObjectAnimator objectAnimator10 = ofFloat3;
                    final ObjectAnimator objectAnimator11 = ofFloat4;
                    final BalloonLikeEachOtherBinding balloonLikeEachOtherBinding4 = BalloonLikeEachOtherBinding.this;
                    objectAnimator9.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.nextvideo.ui.balloon.LikeEachOtherBalloon$Builder$build$3$1.4
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Intrinsics.checkNotNullParameter(valueAnimator, "animation");
                            if (valueAnimator.getAnimatedFraction() >= 0.5f && !objectAnimator10.isStarted()) {
                                objectAnimator10.start();
                                objectAnimator11.start();
                                balloonLikeEachOtherBinding4.likeIconImageView.setAlpha(1.0f);
                                balloonLikeEachOtherBinding4.svgaImageView.startAnimation();
                            }
                        }
                    });
                }
            });
            setBalloon(builder.build());
            CardView findViewById = getBalloon().getContentView().findViewById(2131362054);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            findViewById.setCardElevation(0.0f);
            inflate.dismissImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.balloon.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LikeEachOtherBalloon.Builder.build$lambda$11(LikeEachOtherBalloon.Builder.this, view);
                }
            });
            getBalloon().setOnBalloonClickListener(new Function1() { // from class: com.qiahao.nextvideo.ui.balloon.b
                public final Object invoke(Object obj) {
                    Unit build$lambda$12;
                    build$lambda$12 = LikeEachOtherBalloon.Builder.build$lambda$12(LikeEachOtherBalloon.Builder.this, (View) obj);
                    return build$lambda$12;
                }
            });
            getBalloon().setOnBalloonDismissListener(new Function0() { // from class: com.qiahao.nextvideo.ui.balloon.c
                public final Object invoke() {
                    Unit build$lambda$13;
                    build$lambda$13 = LikeEachOtherBalloon.Builder.build$lambda$13(BalloonLikeEachOtherBinding.this, ofFloat);
                    return build$lambda$13;
                }
            });
            return new LikeEachOtherBalloon(this.context, this);
        }

        @NotNull
        public final Balloon getBalloon() {
            Balloon balloon = this.balloon;
            if (balloon != null) {
                return balloon;
            }
            Intrinsics.throwUninitializedPropertyAccessException("balloon");
            return null;
        }

        @Nullable
        public final LikeEachOtherBalloonDelegate getDelegate() {
            return this.delegate;
        }

        @Nullable
        public final User getLocalUser() {
            return this.localUser;
        }

        @Nullable
        public final User getRemoteUser() {
            return this.remoteUser;
        }

        public final void setBalloon(@NotNull Balloon balloon) {
            Intrinsics.checkNotNullParameter(balloon, "<set-?>");
            this.balloon = balloon;
        }

        public final void setDelegate(@Nullable LikeEachOtherBalloonDelegate likeEachOtherBalloonDelegate) {
            this.delegate = likeEachOtherBalloonDelegate;
        }

        public final void setLocalUser(@Nullable User user) {
            this.localUser = user;
        }

        public final void setRemoteUser(@Nullable User user) {
            this.remoteUser = user;
        }
    }

    public LikeEachOtherBalloon(@NotNull Context context, @NotNull Builder builder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.context = context;
        this.builder = builder;
    }

    public final void dismiss() {
        this.builder.getBalloon().dismiss();
    }

    @NotNull
    public final Builder getBuilder() {
        return this.builder;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final void show(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        Balloon balloon = this.builder.getBalloon();
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        Balloon.showAlignTop$default(balloon, decorView, 0, 0, 6, null);
    }
}

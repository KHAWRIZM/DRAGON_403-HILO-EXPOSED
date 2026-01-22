package com.qiahao.nextvideo.ui.videocall.matchinguser.balloon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.PopupKeepCallTipsBinding;
import com.qiahao.nextvideo.ui.videocall.matchinguser.balloon.KeepCallTipsBalloon;
import com.skydoves.balloon.ArrowConstraints;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon;", "", "context", "Landroid/content/Context;", "builder", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon$Builder;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon$Builder;)V", "getContext", "()Landroid/content/Context;", "getBuilder", "()Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon$Builder;", "show", "", "dismiss", "completion", "Lkotlin/Function0;", "Companion", "Builder", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class KeepCallTipsBalloon {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int FREE = 1;
    public static final int GIFT = 2;
    public static final int GIFT_FLOWER = 4;
    public static final int LOVE = 3;

    @NotNull
    public static final String keyOfFlowerMMKV = "keyOfKeepCallPromptFlower";

    @NotNull
    public static final String keyOfFreeMMKV = "keyOfKeepCallPromptFree";

    @NotNull
    public static final String keyOfGiftMMKV = "keyOfKeepCallPromptGift";

    @NotNull
    public static final String keyOfLoveMMKV = "keyOfKeepCallPromptLOVE";

    @NotNull
    private final Builder builder;

    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "keepCallType", "", "getKeepCallType", "()I", "setKeepCallType", "(I)V", "delegate", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsPopupDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsPopupDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsPopupDelegate;)V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "anchorView", "Landroid/view/View;", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "balloon", "Lcom/skydoves/balloon/Balloon;", "getBalloon", "()Lcom/skydoves/balloon/Balloon;", "setBalloon", "(Lcom/skydoves/balloon/Balloon;)V", "build", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nKeepCallTipsBalloon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 KeepCallTipsBalloon.kt\ncom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon$Builder\n+ 2 Balloon.kt\ncom/skydoves/balloon/BalloonKt\n*L\n1#1,136:1\n94#2:137\n*S KotlinDebug\n*F\n+ 1 KeepCallTipsBalloon.kt\ncom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon$Builder\n*L\n93#1:137\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Builder {
        public View anchorView;
        public Balloon balloon;
        public String content;

        @NotNull
        private final Context context;

        @Nullable
        private KeepCallTipsPopupDelegate delegate;
        private int keepCallType;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void build$lambda$0(Builder builder, View view) {
            KeepCallTipsPopupDelegate keepCallTipsPopupDelegate = builder.delegate;
            if (keepCallTipsPopupDelegate != null) {
                keepCallTipsPopupDelegate.keepCallTipsPopupDelegateDidOkay(builder.keepCallType);
            }
        }

        @NotNull
        public final KeepCallTipsBalloon build() {
            PopupKeepCallTipsBinding inflate = PopupKeepCallTipsBinding.inflate(LayoutInflater.from(this.context));
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            inflate.contentTextView.setText(getContent());
            inflate.okButton.setOnClickListener(new View.OnClickListener() { // from class: vb.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KeepCallTipsBalloon.Builder.build$lambda$0(KeepCallTipsBalloon.Builder.this, view);
                }
            });
            Balloon.Builder builder = new Balloon.Builder(this.context);
            View root = inflate.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            builder.setLayout(root);
            builder.setElevation(0);
            builder.setArrowColorResource(2131099824);
            builder.setArrowDrawableResource(2131230867);
            builder.setArrowSize(12);
            builder.setArrowLeftPadding(0);
            builder.setArrowRightPadding(0);
            builder.setArrowTopPadding(5);
            builder.setArrowConstraints(ArrowConstraints.ALIGN_ANCHOR);
            builder.setPaddingTop(8);
            builder.setPaddingLeft(8);
            builder.setPaddingRight(8);
            builder.setMarginLeft(8);
            builder.setMarginRight(8);
            builder.setMarginBottom(8);
            builder.setCornerRadius(10.0f);
            builder.setHeight(Integer.MIN_VALUE);
            builder.setBackgroundColorResource(2131099824);
            builder.setDismissWhenTouchOutside(false);
            builder.setDismissWhenClicked(false);
            builder.setDismissWhenOverlayClicked(false);
            builder.setBalloonAnimation(BalloonAnimation.FADE);
            builder.setLifecycleOwner(builder.lifecycleOwner);
            setBalloon(builder.build());
            getBalloon().getContentView().getRootView().startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.anim_floating_popup));
            return new KeepCallTipsBalloon(this.context, this);
        }

        @NotNull
        public final View getAnchorView() {
            View view = this.anchorView;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("anchorView");
            return null;
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

        @NotNull
        public final String getContent() {
            String str = this.content;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("content");
            return null;
        }

        @Nullable
        public final KeepCallTipsPopupDelegate getDelegate() {
            return this.delegate;
        }

        public final int getKeepCallType() {
            return this.keepCallType;
        }

        public final void setAnchorView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.anchorView = view;
        }

        public final void setBalloon(@NotNull Balloon balloon) {
            Intrinsics.checkNotNullParameter(balloon, "<set-?>");
            this.balloon = balloon;
        }

        public final void setContent(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }

        public final void setDelegate(@Nullable KeepCallTipsPopupDelegate keepCallTipsPopupDelegate) {
            this.delegate = keepCallTipsPopupDelegate;
        }

        public final void setKeepCallType(int i) {
            this.keepCallType = i;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon$Companion;", "", "<init>", "()V", "FREE", "", "GIFT", "LOVE", "GIFT_FLOWER", "keyOfFreeMMKV", "", "keyOfGiftMMKV", "keyOfLoveMMKV", "keyOfFlowerMMKV", "hasPrompted", "", "key", "markHasPrompted", "unMarkHasPrompted", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean hasPrompted(@NotNull String key) {
            String str;
            Intrinsics.checkNotNullParameter(key, "key");
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null) {
                str = user.getCode();
            } else {
                str = null;
            }
            return ((Boolean) IStore.DefaultImpls.getValue$default(mMKVStore, key + str, Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
        }

        public final boolean markHasPrompted(@NotNull String key) {
            String str;
            Intrinsics.checkNotNullParameter(key, "key");
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null) {
                str = user.getCode();
            } else {
                str = null;
            }
            return IStore.DefaultImpls.setValue$default(mMKVStore, key + str, Boolean.TRUE, (String) null, 4, (Object) null);
        }

        public final boolean unMarkHasPrompted(@NotNull String key) {
            String str;
            Intrinsics.checkNotNullParameter(key, "key");
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null) {
                str = user.getCode();
            } else {
                str = null;
            }
            return IStore.DefaultImpls.setValue$default(mMKVStore, key + str, Boolean.FALSE, (String) null, 4, (Object) null);
        }

        private Companion() {
        }
    }

    public KeepCallTipsBalloon(@NotNull Context context, @NotNull Builder builder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.context = context;
        this.builder = builder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void dismiss$default(KeepCallTipsBalloon keepCallTipsBalloon, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        keepCallTipsBalloon.dismiss(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit show$lambda$0(KeepCallTipsBalloon keepCallTipsBalloon) {
        Balloon.showAlignTop$default(keepCallTipsBalloon.builder.getBalloon(), keepCallTipsBalloon.builder.getAnchorView(), 0, 0, 6, null);
        return Unit.INSTANCE;
    }

    public final void dismiss(@Nullable Function0<Unit> completion) {
        this.builder.getBalloon().dismiss();
        if (completion != null) {
            completion.invoke();
        }
    }

    @NotNull
    public final Builder getBuilder() {
        return this.builder;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final void show() {
        new Function0() { // from class: vb.a
            public final Object invoke() {
                Unit show$lambda$0;
                show$lambda$0 = KeepCallTipsBalloon.show$lambda$0(KeepCallTipsBalloon.this);
                return show$lambda$0;
            }
        }.invoke();
    }
}

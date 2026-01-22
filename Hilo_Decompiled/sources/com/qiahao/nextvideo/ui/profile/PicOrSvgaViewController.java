package com.qiahao.nextvideo.ui.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.player.PlayerState;
import com.qiahao.base_common.player.svga.SVGAMediaSource;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.databinding.DialogPicOrSvgaBinding;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.GiftHelp;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/PicOrSvgaViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;", "url", "", "svgaUrl", "type", "", "senderAvatar", "receiverAvatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getSvgaUrl", "getType", "()I", "getSenderAvatar", "setSenderAvatar", "(Ljava/lang/String;)V", "getReceiverAvatar", "setReceiverAvatar", "binding", "Lcom/qiahao/nextvideo/databinding/DialogPicOrSvgaBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogPicOrSvgaBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogPicOrSvgaBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PicOrSvgaViewController extends ViewController {

    @NotNull
    private static final String TAG = "PicOrSvgaViewController";
    public static final int TYPE_MEDAL = 1;
    public static final int TYPE_MOUNTS = 2;
    public DialogPicOrSvgaBinding binding;

    @Nullable
    private String receiverAvatar;

    @Nullable
    private String senderAvatar;

    @NotNull
    private final String svgaUrl;
    private final int type;

    @NotNull
    private final String url;

    public /* synthetic */ PicOrSvgaViewController(String str, String str2, int i, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$3$lambda$2(PicOrSvgaViewController picOrSvgaViewController, PlayerState playerState) {
        Intrinsics.checkNotNullParameter(playerState, "it");
        if (playerState == PlayerState.ENDED && picOrSvgaViewController.type == 2) {
            ViewController.dismiss$default(picOrSvgaViewController, true, null, 2, null);
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final DialogPicOrSvgaBinding getBinding() {
        DialogPicOrSvgaBinding dialogPicOrSvgaBinding = this.binding;
        if (dialogPicOrSvgaBinding != null) {
            return dialogPicOrSvgaBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @Nullable
    public final String getReceiverAvatar() {
        return this.receiverAvatar;
    }

    @Nullable
    public final String getSenderAvatar() {
        return this.senderAvatar;
    }

    @NotNull
    public final String getSvgaUrl() {
        return this.svgaUrl;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        DialogPicOrSvgaBinding inflate = DialogPicOrSvgaBinding.inflate(inflater, container, false);
        setBinding(inflate);
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setBinding(@NotNull DialogPicOrSvgaBinding dialogPicOrSvgaBinding) {
        Intrinsics.checkNotNullParameter(dialogPicOrSvgaBinding, "<set-?>");
        this.binding = dialogPicOrSvgaBinding;
    }

    public final void setReceiverAvatar(@Nullable String str) {
        this.receiverAvatar = str;
    }

    public final void setSenderAvatar(@Nullable String str) {
        this.senderAvatar = str;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        ConstraintLayout.b layoutParams = getBinding().queuePlayer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        int i = 0;
        if (this.type == 1) {
            getBinding().bgContent.setVisibility(0);
            ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.toPX(300);
            ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.toPX(300);
        } else {
            getBinding().bgContent.setVisibility(8);
            ((ViewGroup.MarginLayoutParams) bVar).height = -1;
            ((ViewGroup.MarginLayoutParams) bVar).width = -1;
        }
        getBinding().queuePlayer.setLayoutParams(bVar);
        if (this.svgaUrl.length() > 0) {
            User user = UserStore.INSTANCE.getShared().getUser();
            String str2 = "";
            if (user == null || (str = user.getAvatar()) == null) {
                str = "";
            }
            String str3 = this.senderAvatar;
            if (str3 != null && str3.length() != 0) {
                str = this.senderAvatar;
            }
            String str4 = str;
            String str5 = this.receiverAvatar;
            if (str5 != null && str5.length() != 0) {
                str2 = this.receiverAvatar;
            }
            GiftDateItem chatToGift$default = DataExternalKt.chatToGift$default(this.svgaUrl, str4, str2, null, null, null, null, 120, null);
            try {
                if (StringKtxKt.checkEndSVGA(this.svgaUrl)) {
                    SVGAMediaSource sVGAData = GiftHelp.INSTANCE.getSVGAData(chatToGift$default);
                    if (this.type != 1) {
                        i = 1;
                    }
                    sVGAData.setLoopCount(i);
                    getBinding().queuePlayer.addQueue(sVGAData);
                } else if (StringKtxKt.checkEndMP4(this.svgaUrl)) {
                    VapMediaSource vap = GiftHelp.INSTANCE.getVAP(chatToGift$default, getRequireActivity());
                    if (this.type != 1) {
                        i = 1;
                    }
                    vap.setLoopCount(i);
                    getBinding().queuePlayer.addQueue(vap);
                } else if (StringKtxKt.checkDefaultMP4(this.svgaUrl)) {
                    getBinding().queuePlayer.addQueue(new VideoMediaSource(StringKtxKt.urlMP4(this.svgaUrl)));
                }
            } catch (Exception unused) {
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放礼物出错", false, 4, (Object) null);
            }
        } else if (this.url.length() > 0) {
            ImageView imageView = getBinding().bigPic;
            Intrinsics.checkNotNullExpressionValue(imageView, "bigPic");
            ViewUtilitiesKt.bind(imageView, new ImageUIModel(this.url, null, null, null, 0, 0, null, 126, null));
        }
        getBinding().queuePlayer.setPlayerStateListener(new Function1() { // from class: com.qiahao.nextvideo.ui.profile.d
            public final Object invoke(Object obj) {
                Unit viewDidLoad$lambda$3$lambda$2;
                viewDidLoad$lambda$3$lambda$2 = PicOrSvgaViewController.viewDidLoad$lambda$3$lambda$2(PicOrSvgaViewController.this, (PlayerState) obj);
                return viewDidLoad$lambda$3$lambda$2;
            }
        });
    }

    public PicOrSvgaViewController(@NotNull String str, @NotNull String str2, int i, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "svgaUrl");
        this.url = str;
        this.svgaUrl = str2;
        this.type = i;
        this.senderAvatar = str3;
        this.receiverAvatar = str4;
        PresentationStyle presentationStyle = getPresentationStyle();
        presentationStyle.setAnimation(PresentingAnimation.RIGHT);
        presentationStyle.setFullscreen(true);
        presentationStyle.setGravity(17);
        presentationStyle.setDim(true);
        presentationStyle.setOverCurrentContext(true);
        setTag(TAG);
        presentationStyle.setDuration(0L);
        presentationStyle.setAllowTapOutsideToDismiss(false);
        presentationStyle.setMinimumSideMargin(0);
    }
}

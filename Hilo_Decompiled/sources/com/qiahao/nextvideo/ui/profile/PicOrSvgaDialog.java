package com.qiahao.nextvideo.ui.profile;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import c5.g;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.player.PlayerState;
import com.qiahao.base_common.player.svga.SVGAMediaSource;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.databinding.DialogPicOrSvgaBinding;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.GiftHelp;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fBA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001a\u001a\u00020\u0007H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/PicOrSvgaDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogPicOrSvgaBinding;", "url", "", "svgaUrl", "type", "", "senderAvatar", "receiverAvatar", "mContext", "Landroid/content/Context;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/content/Context;)V", "getUrl", "()Ljava/lang/String;", "getSvgaUrl", "getType", "()I", "getSenderAvatar", "setSenderAvatar", "(Ljava/lang/String;)V", "getReceiverAvatar", "setReceiverAvatar", "getMContext", "()Landroid/content/Context;", "getLayoutResId", "isNeedFullScreen", "", "onInitialize", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PicOrSvgaDialog extends BaseBindingDialog<DialogPicOrSvgaBinding> {
    public static final int TYPE_MEDAL = 1;
    public static final int TYPE_MOUNTS = 2;

    @NotNull
    private final Context mContext;

    @Nullable
    private String receiverAvatar;

    @Nullable
    private String senderAvatar;

    @NotNull
    private final String svgaUrl;
    private final int type;

    @NotNull
    private final String url;

    public /* synthetic */ PicOrSvgaDialog(String str, String str2, int i, String str3, String str4, Context context, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1$lambda$0(PicOrSvgaDialog picOrSvgaDialog, PlayerState playerState) {
        Intrinsics.checkNotNullParameter(playerState, "it");
        if (playerState == PlayerState.ENDED && picOrSvgaDialog.type == 2) {
            picOrSvgaDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_pic_or_svga;
    }

    @NotNull
    public final Context getMContext() {
        return this.mContext;
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

    protected boolean isNeedFullScreen() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        String str;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ConstraintLayout.b layoutParams = ((DialogPicOrSvgaBinding) getBinding()).queuePlayer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        int i = 0;
        if (this.type == 1) {
            ((DialogPicOrSvgaBinding) getBinding()).bgContent.setVisibility(0);
            ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.toPX(300);
            ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.toPX(300);
        } else {
            ((DialogPicOrSvgaBinding) getBinding()).bgContent.setVisibility(8);
            ((ViewGroup.MarginLayoutParams) bVar).height = -1;
            ((ViewGroup.MarginLayoutParams) bVar).width = -1;
        }
        ((DialogPicOrSvgaBinding) getBinding()).queuePlayer.setLayoutParams(bVar);
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
                    ((DialogPicOrSvgaBinding) getBinding()).queuePlayer.addQueue(sVGAData);
                } else if (StringKtxKt.checkEndMP4(this.svgaUrl)) {
                    GiftHelp giftHelp = GiftHelp.INSTANCE;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    VapMediaSource vap = giftHelp.getVAP(chatToGift$default, context);
                    if (this.type != 1) {
                        i = 1;
                    }
                    vap.setLoopCount(i);
                    ((DialogPicOrSvgaBinding) getBinding()).queuePlayer.addQueue(vap);
                } else if (StringKtxKt.checkDefaultMP4(this.svgaUrl)) {
                    ((DialogPicOrSvgaBinding) getBinding()).queuePlayer.addQueue(new VideoMediaSource(StringKtxKt.urlMP4(this.svgaUrl)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.url.length() > 0) {
            ImageView imageView = ((DialogPicOrSvgaBinding) getBinding()).bigPic;
            Intrinsics.checkNotNullExpressionValue(imageView, "bigPic");
            ImageKtxKt.loadImage$default(imageView, this.url, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        }
        ((DialogPicOrSvgaBinding) getBinding()).queuePlayer.setPlayerStateListener(new Function1() { // from class: com.qiahao.nextvideo.ui.profile.c
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$1$lambda$0;
                onInitialize$lambda$1$lambda$0 = PicOrSvgaDialog.onInitialize$lambda$1$lambda$0(PicOrSvgaDialog.this, (PlayerState) obj);
                return onInitialize$lambda$1$lambda$0;
            }
        });
    }

    public final void setReceiverAvatar(@Nullable String str) {
        this.receiverAvatar = str;
    }

    public final void setSenderAvatar(@Nullable String str) {
        this.senderAvatar = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicOrSvgaDialog(@NotNull String str, @NotNull String str2, int i, @Nullable String str3, @Nullable String str4, @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "svgaUrl");
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.url = str;
        this.svgaUrl = str2;
        this.type = i;
        this.senderAvatar = str3;
        this.receiverAvatar = str4;
        this.mContext = context;
    }
}

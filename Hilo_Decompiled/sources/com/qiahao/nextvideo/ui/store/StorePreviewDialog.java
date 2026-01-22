package com.qiahao.nextvideo.ui.store;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.player.PlayerState;
import com.qiahao.base_common.player.svga.SVGAMediaSource;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.databinding.DialogStorePreviewBinding;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
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

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u00020\tH\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/StorePreviewDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogStorePreviewBinding;", "context", "Landroid/content/Context;", "url", "", "svgaUrl", "type", "", "senderAvatar", "receiverAvatar", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getSvgaUrl", "getType", "()I", "getSenderAvatar", "setSenderAvatar", "(Ljava/lang/String;)V", "getReceiverAvatar", "setReceiverAvatar", "getLayoutResId", "onInitialize", "", "isNeedFullScreen", "", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StorePreviewDialog extends BaseBindingDialog<DialogStorePreviewBinding> {

    @Nullable
    private String receiverAvatar;

    @Nullable
    private String senderAvatar;

    @NotNull
    private final String svgaUrl;
    private final int type;

    @NotNull
    private final String url;

    public /* synthetic */ StorePreviewDialog(Context context, String str, String str2, int i, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        String str;
        ConstraintLayout.b layoutParams = ((DialogStorePreviewBinding) getBinding()).queuePlayer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        int i = 0;
        if (this.type == 1) {
            ((DialogStorePreviewBinding) getBinding()).bgContent.setVisibility(8);
            ((ViewGroup.MarginLayoutParams) bVar).height = -1;
            ((ViewGroup.MarginLayoutParams) bVar).width = -1;
        } else {
            ((DialogStorePreviewBinding) getBinding()).bgContent.setVisibility(0);
            ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.toPX(300);
            ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.toPX(300);
        }
        ((DialogStorePreviewBinding) getBinding()).queuePlayer.setLayoutParams(bVar);
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
                    if (this.type == 1) {
                        i = 1;
                    }
                    sVGAData.setLoopCount(i);
                    ((DialogStorePreviewBinding) getBinding()).queuePlayer.addQueue(sVGAData);
                } else if (StringKtxKt.checkEndMP4(this.svgaUrl)) {
                    GiftHelp giftHelp = GiftHelp.INSTANCE;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    VapMediaSource vap = giftHelp.getVAP(chatToGift$default, context);
                    if (this.type == 1) {
                        i = 1;
                    }
                    vap.setLoopCount(i);
                    ((DialogStorePreviewBinding) getBinding()).queuePlayer.addQueue(vap);
                } else if (StringKtxKt.checkDefaultMP4(this.svgaUrl)) {
                    ((DialogStorePreviewBinding) getBinding()).queuePlayer.addQueue(new VideoMediaSource(StringKtxKt.urlMP4(this.svgaUrl)));
                }
            } catch (Exception unused) {
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放礼物出错", false, 4, (Object) null);
            }
        } else if (this.url.length() > 0) {
            ImageView imageView = ((DialogStorePreviewBinding) getBinding()).bigPic;
            Intrinsics.checkNotNullExpressionValue(imageView, "bigPic");
            ViewUtilitiesKt.bind(imageView, new ImageUIModel(this.url, null, null, null, 0, 0, null, 126, null));
        }
        ((DialogStorePreviewBinding) getBinding()).queuePlayer.setPlayerStateListener(new Function1() { // from class: com.qiahao.nextvideo.ui.store.h2
            public final Object invoke(Object obj) {
                Unit initView$lambda$1$lambda$0;
                initView$lambda$1$lambda$0 = StorePreviewDialog.initView$lambda$1$lambda$0(StorePreviewDialog.this, (PlayerState) obj);
                return initView$lambda$1$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$1$lambda$0(StorePreviewDialog storePreviewDialog, PlayerState playerState) {
        Intrinsics.checkNotNullParameter(playerState, "it");
        if (playerState == PlayerState.ENDED && storePreviewDialog.type == 1) {
            storePreviewDialog.dismiss();
        }
        return Unit.INSTANCE;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_store_preview;
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

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        initView();
    }

    public final void setReceiverAvatar(@Nullable String str) {
        this.receiverAvatar = str;
    }

    public final void setSenderAvatar(@Nullable String str) {
        this.senderAvatar = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorePreviewDialog(@NotNull Context context, @NotNull String str, @NotNull String str2, int i, @Nullable String str3, @Nullable String str4) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "svgaUrl");
        this.url = str;
        this.svgaUrl = str2;
        this.type = i;
        this.senderAvatar = str3;
        this.receiverAvatar = str4;
    }
}

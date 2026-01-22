package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.LuckWheelInfo;
import com.qiahao.nextvideo.data.model.Participant;
import com.qiahao.nextvideo.databinding.DialogLuckyWheelBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.TurnTextBean;
import com.qiahao.nextvideo.room.view.TurntableMainCommonView2;
import com.qiahao.nextvideo.room.view.WheelGameInfo;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.qiahao.nextvideo.view.youtube.FadeViewHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 j2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001jB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0015j\b\u0012\u0004\u0012\u00020\u0005`\u00162\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u0011J\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010\u0011J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\"\u0010\u001dJ\u0017\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010\u0011J\u001d\u0010*\u001a\u00020\f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020#0(H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\f2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020#H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\f2\u0006\u0010,\u001a\u00020#H\u0002¢\u0006\u0004\b0\u0010&J\u000f\u00101\u001a\u00020\fH\u0002¢\u0006\u0004\b1\u0010\u0011J\u000f\u00103\u001a\u000202H\u0014¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\fH\u0016¢\u0006\u0004\b5\u0010\u0011J\u0015\u00106\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b6\u0010\u000eJ\r\u00107\u001a\u00020\f¢\u0006\u0004\b7\u0010\u0011J\u0017\u0010:\u001a\u00020\f2\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\f¢\u0006\u0004\b<\u0010\u0011J\u0017\u0010>\u001a\u00020\f2\u0006\u0010=\u001a\u000202H\u0016¢\u0006\u0004\b>\u0010?J\u001f\u0010B\u001a\u00020\f2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u000202H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\f2\u0006\u0010@\u001a\u00020\u0005H\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\fH\u0016¢\u0006\u0004\bF\u0010\u0011J\u000f\u0010G\u001a\u00020\fH\u0016¢\u0006\u0004\bG\u0010\u0011J\u000f\u0010H\u001a\u00020\fH\u0016¢\u0006\u0004\bH\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010M\u001a\u0004\u0018\u00010J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010L\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010S\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010Y\u001a\u0004\b!\u0010Z\"\u0004\b[\u0010\u001dR$\u0010\\\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010\u000eR\"\u0010a\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010Y\u001a\u0004\ba\u0010Z\"\u0004\bb\u0010\u001dR\"\u0010c\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010Y\u001a\u0004\bd\u0010Z\"\u0004\be\u0010\u001dR\"\u0010f\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u00104\"\u0004\bi\u0010?¨\u0006k"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/LuckyWheelDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogLuckyWheelBinding;", "Landroid/view/View$OnClickListener;", "Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2$OnResultListener;", "Lcom/qiahao/nextvideo/room/view/TurnTextBean;", "Landroid/content/Context;", "mCurrentContext", "<init>", "(Landroid/content/Context;)V", "Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "luckWheelInfo", "", "updateView", "(Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;)V", "updateSequenceData", "getWinInfoAndShow", "()V", "", "Lcom/qiahao/nextvideo/data/model/Participant;", "participantList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "luckWheelInfoChangeToTurnTextBean", "(Ljava/util/List;)Ljava/util/ArrayList;", "showRotateingView", "", "isMyCreate", "showStartView", "(Z)V", "initObserver", "startBgTask", "initView", "isChange", "bgSplash", "", "avatar", "showLoserView", "(Ljava/lang/String;)V", "commonDialogShow", "", "result", "startTaskCycle", "(Ljava/util/List;)V", "avatarUrl", "nick", "showWinOption", "(Ljava/lang/String;Ljava/lang/String;)V", "playSvga", "stopTaskCycle", "", "getLayoutResId", "()I", "onInitialize", "setDate", "hideJoinLayout", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "release", "status", "onAnimationEnd", "(I)V", "data", "sumHas", "onSelectOption", "(Lcom/qiahao/nextvideo/room/view/TurnTextBean;I)V", "onWinOption", "(Lcom/qiahao/nextvideo/room/view/TurnTextBean;)V", "show", "dismiss", "onBackPressed", "Landroid/content/Context;", "Lnd/c;", "mTaskCycle", "Lnd/c;", "mBgTask", "getMBgTask", "()Lnd/c;", "setMBgTask", "(Lnd/c;)V", "Lcom/qiahao/nextvideo/room/dialog/LuckyWheelListener;", "mLuckyWheelListener", "Lcom/qiahao/nextvideo/room/dialog/LuckyWheelListener;", "getMLuckyWheelListener", "()Lcom/qiahao/nextvideo/room/dialog/LuckyWheelListener;", "setMLuckyWheelListener", "(Lcom/qiahao/nextvideo/room/dialog/LuckyWheelListener;)V", "Z", "()Z", "setChange", "mRoomLuckWheelInfo", "Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "getMRoomLuckWheelInfo", "()Lcom/qiahao/nextvideo/data/model/LuckWheelInfo;", "setMRoomLuckWheelInfo", "isShowWinView", "setShowWinView", "hasNextTime", "getHasNextTime", "setHasNextTime", "mAllNumber", "I", "getMAllNumber", "setMAllNumber", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLuckyWheelDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LuckyWheelDialog.kt\ncom/qiahao/nextvideo/room/dialog/LuckyWheelDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,593:1\n1869#2,2:594\n1869#2,2:596\n1869#2,2:598\n1869#2,2:600\n1869#2,2:602\n1#3:604\n*S KotlinDebug\n*F\n+ 1 LuckyWheelDialog.kt\ncom/qiahao/nextvideo/room/dialog/LuckyWheelDialog\n*L\n143#1:594,2\n183#1:596,2\n212#1:598,2\n229#1:600,2\n293#1:602,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyWheelDialog extends BaseBindingDialog<DialogLuckyWheelBinding> implements View.OnClickListener, TurntableMainCommonView2.OnResultListener<TurnTextBean> {

    @NotNull
    private static final String TAG = "LuckyWheelDialog";
    private boolean hasNextTime;
    private boolean isChange;
    private boolean isShowWinView;
    private int mAllNumber;

    @Nullable
    private nd.c mBgTask;

    @NotNull
    private final Context mCurrentContext;

    @Nullable
    private LuckyWheelListener mLuckyWheelListener;

    @Nullable
    private LuckWheelInfo mRoomLuckWheelInfo;

    @Nullable
    private nd.c mTaskCycle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyWheelDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        this.mCurrentContext = context;
    }

    public static final /* synthetic */ DialogLuckyWheelBinding access$getBinding(LuckyWheelDialog luckyWheelDialog) {
        return (DialogLuckyWheelBinding) luckyWheelDialog.getBinding();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bgSplash(boolean isChange) {
        if (isChange) {
            ((DialogLuckyWheelBinding) getBinding()).bgContentA.setVisibility(4);
            ((DialogLuckyWheelBinding) getBinding()).bgContentB.setVisibility(0);
        } else {
            ((DialogLuckyWheelBinding) getBinding()).bgContentA.setVisibility(0);
            ((DialogLuckyWheelBinding) getBinding()).bgContentB.setVisibility(4);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    private final void commonDialogShow() {
        final ?? commonTextDialog = new CommonTextDialog(this.mCurrentContext, 0.0f, 2, null);
        commonTextDialog.setContentText(ResourcesKtxKt.getStringById((Object) commonTextDialog, 2131953126), true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.LuckyWheelDialog$commonDialogShow$1$1
            public void cancel() {
                commonTextDialog.dismiss();
            }

            public void confirm() {
                Context context;
                WalletActivity.Companion companion = WalletActivity.INSTANCE;
                context = LuckyWheelDialog.this.mCurrentContext;
                companion.start(context);
                commonTextDialog.dismiss();
            }
        });
        commonTextDialog.show();
    }

    private final void getWinInfoAndShow() {
        List<String> list;
        int i;
        String str;
        ArrayList<Participant> participants;
        List<String> sequence;
        LuckWheelInfo luckWheelInfo;
        List<String> sequence2;
        LuckWheelInfo luckWheelInfo2 = this.mRoomLuckWheelInfo;
        Participant participant = null;
        if (luckWheelInfo2 != null) {
            list = luckWheelInfo2.getSequence();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty() && (luckWheelInfo = this.mRoomLuckWheelInfo) != null && (sequence2 = luckWheelInfo.getSequence()) != null) {
            i = sequence2.size();
        } else {
            i = -1;
        }
        if (i > -1) {
            LuckWheelInfo luckWheelInfo3 = this.mRoomLuckWheelInfo;
            if (luckWheelInfo3 != null && (sequence = luckWheelInfo3.getSequence()) != null) {
                str = sequence.get(i - 1);
            } else {
                str = null;
            }
            LuckWheelInfo luckWheelInfo4 = this.mRoomLuckWheelInfo;
            if (luckWheelInfo4 != null && (participants = luckWheelInfo4.getParticipants()) != null) {
                for (Participant participant2 : participants) {
                    if (Intrinsics.areEqual(participant2.getExternalId(), str)) {
                        participant = participant2;
                    }
                }
            }
            if (participant != null) {
                Log.d(TAG, "LucklyWheel getWinInfoAndShow: ");
                String avatar = participant.getAvatar();
                String nick = participant.getNick();
                if (nick == null) {
                    nick = "";
                }
                showWinOption(avatar, nick);
            }
        }
    }

    private final void initObserver() {
        ((DialogLuckyWheelBinding) getBinding()).svgaImageView.setCallback(new SVGACallback() { // from class: com.qiahao.nextvideo.room.dialog.LuckyWheelDialog$initObserver$1
            public void onFinished() {
                LuckyWheelDialog.access$getBinding(LuckyWheelDialog.this).clLuckyWheel.setVisibility(0);
                LuckyWheelDialog.access$getBinding(LuckyWheelDialog.this).clWinLayout.setVisibility(8);
                Log.d("LuckyWheelDialog", "LucklyWheel showWinOption: SVGA finish() ");
                LuckyWheelListener mLuckyWheelListener = LuckyWheelDialog.this.getMLuckyWheelListener();
                if (mLuckyWheelListener != null) {
                    mLuckyWheelListener.luckyWheelGameWinSvgaFinish(LuckyWheelDialog.this.getHasNextTime());
                }
            }

            public void onPause() {
            }

            public void onRepeat() {
            }

            public void onStep(int frame, double percentage) {
            }
        });
        startBgTask();
    }

    private final void initView() {
        ((DialogLuckyWheelBinding) getBinding()).turnText.setTurnTableListener(this);
        ((DialogLuckyWheelBinding) getBinding()).turnText.setType(WheelGameInfo.INSTANCE.getDiamond());
    }

    private final ArrayList<TurnTextBean> luckWheelInfoChangeToTurnTextBean(List<Participant> participantList) {
        ArrayList<TurnTextBean> arrayList = new ArrayList<>();
        if (participantList != null && !participantList.isEmpty()) {
            for (Participant participant : participantList) {
                arrayList.add(new TurnTextBean(participant.getNick(), participant.getExternalId(), participant.getAvatar()));
            }
        }
        return arrayList;
    }

    private final void playSvga(final String avatarUrl) {
        try {
            SVGAParser.Companion.shareParser().decodeFromAssets("svga/luckly_wheel_winner.svga", new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.LuckyWheelDialog$playSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                    if (!StringKtxKt.isUrl(avatarUrl)) {
                        UserStore.Companion companion = UserStore.INSTANCE;
                        if (StringKtxKt.isUrl(companion.getShared().getMNormalWomanAvatarUrl())) {
                            sVGADynamicEntity.setDynamicImage(ImageSizeKt.imageCircle(companion.getShared().getMNormalWomanAvatarUrl(), 100), "luckywheel_avatar");
                        }
                    } else {
                        sVGADynamicEntity.setDynamicImage(ImageSizeKt.imageCircle(avatarUrl, 200), "luckywheel_avatar");
                    }
                    Drawable sVGADrawable = new SVGADrawable(videoItem, sVGADynamicEntity);
                    LuckyWheelDialog.access$getBinding(this).svgaImageView.stopAnimation(true);
                    LuckyWheelDialog.access$getBinding(this).svgaImageView.setImageDrawable(sVGADrawable);
                    LuckyWheelDialog.access$getBinding(this).svgaImageView.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception e) {
            ((DialogLuckyWheelBinding) getBinding()).svgaImageView.stopAnimation();
            DebugToolsKt.printfE(TAG, "轮盘胜利头饰出错 内部try()catch{}" + e.getLocalizedMessage());
        }
    }

    private final void showLoserView(String avatar) {
        ((DialogLuckyWheelBinding) getBinding()).outBg.setVisibility(0);
        ((DialogLuckyWheelBinding) getBinding()).outAvatar.setVisibility(0);
        ((DialogLuckyWheelBinding) getBinding()).faceImage.setVisibility(0);
        CircleImageView circleImageView = ((DialogLuckyWheelBinding) getBinding()).outAvatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "outAvatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(77));
        fill.setHeight(dimens.dpToPx(77));
        Unit unit = Unit.INSTANCE;
        ImageUIModel displayUserAvatarImage = companion.displayUserAvatarImage(avatar, fill);
        displayUserAvatarImage.setPlaceholder(Integer.valueOf(R.drawable.icon_gender_girl));
        ViewUtilitiesKt.bind$default(circleImageView, displayUserAvatarImage, null, 2, null);
        ((DialogLuckyWheelBinding) getBinding()).faceImage.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.n0
            @Override // java.lang.Runnable
            public final void run() {
                LuckyWheelDialog.showLoserView$lambda$12(LuckyWheelDialog.this);
            }
        }, FadeViewHelper.DEFAULT_FADE_OUT_DELAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoserView$lambda$12(LuckyWheelDialog luckyWheelDialog) {
        ((DialogLuckyWheelBinding) luckyWheelDialog.getBinding()).outBg.setVisibility(8);
        ((DialogLuckyWheelBinding) luckyWheelDialog.getBinding()).outAvatar.setVisibility(8);
        ((DialogLuckyWheelBinding) luckyWheelDialog.getBinding()).faceImage.setVisibility(8);
    }

    private final void showRotateingView() {
        ((DialogLuckyWheelBinding) getBinding()).clLuckyWheel.setVisibility(0);
        ((DialogLuckyWheelBinding) getBinding()).clWinLayout.setVisibility(8);
        ((DialogLuckyWheelBinding) getBinding()).closeLuckyWheel.setVisibility(8);
        ((DialogLuckyWheelBinding) getBinding()).centerPoint.setVisibility(0);
        ImageView imageView = ((DialogLuckyWheelBinding) getBinding()).centerPoint;
        Intrinsics.checkNotNullExpressionValue(imageView, "centerPoint");
        ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_roulette_start_pointer), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        ((DialogLuckyWheelBinding) getBinding()).llJoin.setVisibility(8);
        ((DialogLuckyWheelBinding) getBinding()).startClick.setVisibility(8);
        ((DialogLuckyWheelBinding) getBinding()).outBg.setVisibility(8);
        ((DialogLuckyWheelBinding) getBinding()).outAvatar.setVisibility(8);
        ((DialogLuckyWheelBinding) getBinding()).faceImage.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void showStartView(boolean isMyCreate) {
        String str;
        ArrayList<Participant> arrayList;
        boolean z;
        ArrayList<Participant> participants;
        String str2;
        String str3;
        String externalId;
        ((DialogLuckyWheelBinding) getBinding()).clLuckyWheel.setVisibility(0);
        ((DialogLuckyWheelBinding) getBinding()).clWinLayout.setVisibility(8);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        String str4 = "";
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        if (meetingRoomManager.getRoomUserRole(str) <= 1) {
            User user2 = companion.getShared().getUser();
            if (user2 != null && (externalId = user2.getExternalId()) != null) {
                str4 = externalId;
            }
            LuckWheelInfo luckWheelInfo = this.mRoomLuckWheelInfo;
            if (luckWheelInfo == null || (str3 = luckWheelInfo.getCreator()) == null) {
                str3 = " ";
            }
            if (!Intrinsics.areEqual(str4, str3)) {
                ((DialogLuckyWheelBinding) getBinding()).closeLuckyWheel.setVisibility(8);
                ((DialogLuckyWheelBinding) getBinding()).centerPoint.setVisibility(0);
                if (!isMyCreate) {
                    ((DialogLuckyWheelBinding) getBinding()).llJoin.setVisibility(8);
                    ((DialogLuckyWheelBinding) getBinding()).startClick.setVisibility(0);
                    ImageView imageView = ((DialogLuckyWheelBinding) getBinding()).centerPoint;
                    Intrinsics.checkNotNullExpressionValue(imageView, "centerPoint");
                    ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_roulette_green_start_pointer), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                } else {
                    LuckWheelInfo luckWheelInfo2 = this.mRoomLuckWheelInfo;
                    Integer num = null;
                    if (luckWheelInfo2 != null) {
                        arrayList = luckWheelInfo2.getParticipants();
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        LuckWheelInfo luckWheelInfo3 = this.mRoomLuckWheelInfo;
                        if (luckWheelInfo3 != null && (participants = luckWheelInfo3.getParticipants()) != null) {
                            Iterator<T> it = participants.iterator();
                            z = false;
                            while (it.hasNext()) {
                                String externalId2 = ((Participant) it.next()).getExternalId();
                                User user3 = UserStore.INSTANCE.getShared().getUser();
                                if (user3 != null) {
                                    str2 = user3.getExternalId();
                                } else {
                                    str2 = null;
                                }
                                if (Intrinsics.areEqual(externalId2, str2)) {
                                    z = true;
                                }
                            }
                        } else {
                            z = false;
                        }
                        if (z) {
                            ((DialogLuckyWheelBinding) getBinding()).llJoin.setVisibility(8);
                            ImageView imageView2 = ((DialogLuckyWheelBinding) getBinding()).centerPoint;
                            Intrinsics.checkNotNullExpressionValue(imageView2, "centerPoint");
                            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_roulette_start_pointer), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        } else {
                            ((DialogLuckyWheelBinding) getBinding()).llJoin.setVisibility(0);
                            AppCompatTextView appCompatTextView = ((DialogLuckyWheelBinding) getBinding()).joinDiamond;
                            LuckWheelInfo luckWheelInfo4 = this.mRoomLuckWheelInfo;
                            if (luckWheelInfo4 != null) {
                                num = Integer.valueOf(luckWheelInfo4.getEntranceFee());
                            }
                            appCompatTextView.setText(String.valueOf(num));
                            ((DialogLuckyWheelBinding) getBinding()).startClick.setVisibility(8);
                            ImageView imageView3 = ((DialogLuckyWheelBinding) getBinding()).centerPoint;
                            Intrinsics.checkNotNullExpressionValue(imageView3, "centerPoint");
                            ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_roulette_green_start_pointer), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        }
                    } else {
                        ((DialogLuckyWheelBinding) getBinding()).llJoin.setVisibility(0);
                        AppCompatTextView appCompatTextView2 = ((DialogLuckyWheelBinding) getBinding()).joinDiamond;
                        LuckWheelInfo luckWheelInfo5 = this.mRoomLuckWheelInfo;
                        if (luckWheelInfo5 != null) {
                            num = Integer.valueOf(luckWheelInfo5.getEntranceFee());
                        }
                        appCompatTextView2.setText(String.valueOf(num));
                        ((DialogLuckyWheelBinding) getBinding()).startClick.setVisibility(8);
                        ImageView imageView4 = ((DialogLuckyWheelBinding) getBinding()).centerPoint;
                        Intrinsics.checkNotNullExpressionValue(imageView4, "centerPoint");
                        ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_roulette_green_start_pointer), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    }
                }
                ((DialogLuckyWheelBinding) getBinding()).outBg.setVisibility(8);
                ((DialogLuckyWheelBinding) getBinding()).outAvatar.setVisibility(8);
                ((DialogLuckyWheelBinding) getBinding()).faceImage.setVisibility(8);
            }
        }
        ((DialogLuckyWheelBinding) getBinding()).closeLuckyWheel.setVisibility(0);
        ((DialogLuckyWheelBinding) getBinding()).centerPoint.setVisibility(0);
        if (!isMyCreate) {
        }
        ((DialogLuckyWheelBinding) getBinding()).outBg.setVisibility(8);
        ((DialogLuckyWheelBinding) getBinding()).outAvatar.setVisibility(8);
        ((DialogLuckyWheelBinding) getBinding()).faceImage.setVisibility(8);
    }

    private final void showWinOption(String avatarUrl, String nick) {
        long j;
        Log.d(TAG, "LucklyWheel showWinOption: " + avatarUrl + " " + nick);
        ((DialogLuckyWheelBinding) getBinding()).clLuckyWheel.setVisibility(8);
        ((DialogLuckyWheelBinding) getBinding()).clWinLayout.setVisibility(0);
        ((DialogLuckyWheelBinding) getBinding()).winnerName.setText(nick);
        AppCompatTextView appCompatTextView = ((DialogLuckyWheelBinding) getBinding()).winnerDiamond;
        LuckWheelInfo luckWheelInfo = this.mRoomLuckWheelInfo;
        if (luckWheelInfo != null) {
            j = luckWheelInfo.getWinnerAmount();
        } else {
            j = 0;
        }
        appCompatTextView.setText(String.valueOf(j));
        LuckyWheelListener luckyWheelListener = this.mLuckyWheelListener;
        if (luckyWheelListener != null) {
            luckyWheelListener.winSvgaStartPlay();
        }
        playSvga(avatarUrl);
    }

    private final void startBgTask() {
        if (this.mBgTask == null) {
            this.mBgTask = io.reactivex.rxjava3.core.z.interval(500L, 500L, TimeUnit.MILLISECONDS).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.dialog.LuckyWheelDialog$startBgTask$1
                public final void accept(Long l) {
                    Intrinsics.checkNotNullParameter(l, "it");
                    LuckyWheelDialog.this.setChange(!r2.getIsChange());
                    LuckyWheelDialog luckyWheelDialog = LuckyWheelDialog.this;
                    luckyWheelDialog.bgSplash(luckyWheelDialog.getIsChange());
                }
            });
        }
    }

    private final void startTaskCycle(List<String> result) {
        stopTaskCycle();
        ((DialogLuckyWheelBinding) getBinding()).turnText.setResultAndStart(result);
        this.mTaskCycle = io.reactivex.rxjava3.core.z.interval(8000L, 8000L, TimeUnit.MILLISECONDS).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.room.dialog.LuckyWheelDialog$startTaskCycle$1
            public final void accept(Long l) {
                Intrinsics.checkNotNullParameter(l, "it");
                if (LuckyWheelDialog.access$getBinding(LuckyWheelDialog.this).turnText.getListData().size() <= 1) {
                    LuckyWheelDialog.this.stopTaskCycle();
                } else {
                    if (LuckyWheelDialog.access$getBinding(LuckyWheelDialog.this).turnText.postNext()) {
                        return;
                    }
                    LuckyWheelDialog.this.stopTaskCycle();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopTaskCycle() {
        nd.c cVar = this.mTaskCycle;
        if (cVar != null && !cVar.isDisposed()) {
            cVar.dispose();
        }
        this.mTaskCycle = null;
    }

    private final void updateSequenceData(LuckWheelInfo luckWheelInfo) {
        int i;
        List<String> list;
        Integer num;
        Iterator<Participant> it;
        List<String> sequence = luckWheelInfo.getSequence();
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        if (sequence != null) {
            i = sequence.size();
        } else {
            i = 0;
        }
        if (i <= luckWheelInfo.getLosersNum()) {
            List<String> sequence2 = luckWheelInfo.getSequence();
            if (sequence2 != null) {
                i2 = sequence2.size();
            }
            Log.d(TAG, "updateSequenceData: 数据报错 " + i2 + " " + luckWheelInfo.getLosersNum());
            return;
        }
        ArrayList<Participant> participants = luckWheelInfo.getParticipants();
        if (participants != null && !participants.isEmpty()) {
            List<String> sequence3 = luckWheelInfo.getSequence();
            List<String> list2 = null;
            if (sequence3 != null) {
                list = sequence3.subList(0, luckWheelInfo.getLosersNum());
            } else {
                list = null;
            }
            if (list != null && !list.isEmpty() && list != null) {
                for (String str : list) {
                    ArrayList<Participant> participants2 = luckWheelInfo.getParticipants();
                    if (participants2 != null && (it = participants2.iterator()) != null) {
                        while (it.hasNext()) {
                            Participant next = it.next();
                            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                            if (Intrinsics.areEqual(str, next.getExternalId())) {
                                it.remove();
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
            List<String> sequence4 = luckWheelInfo.getSequence();
            if (sequence4 != null) {
                num = Integer.valueOf(sequence4.size());
            } else {
                num = null;
            }
            List<String> sequence5 = luckWheelInfo.getSequence();
            if (sequence5 != null) {
                int losersNum = luckWheelInfo.getLosersNum();
                if (num != null) {
                    i3 = num.intValue();
                }
                list2 = sequence5.subList(losersNum, i3);
            }
            luckWheelInfo.setSequence(list2);
            return;
        }
        ArrayList<Participant> participants3 = luckWheelInfo.getParticipants();
        if (participants3 == null || participants3.isEmpty()) {
            z = true;
        }
        Log.d(TAG, "updateSequenceData: 数据报错 参与人数为 null " + z);
    }

    private final void updateView(final LuckWheelInfo luckWheelInfo) {
        String externalId;
        int i;
        ArrayList<Participant> participants;
        String str;
        List<String> sequence;
        List<String> sequence2;
        int status = luckWheelInfo.getStatus();
        int i2 = 0;
        String str2 = "";
        if (status != 1) {
            if (status != 2) {
                if (status == 3) {
                    show();
                    stopTaskCycle();
                    LuckWheelInfo luckWheelInfo2 = this.mRoomLuckWheelInfo;
                    if (luckWheelInfo2 != null && (sequence2 = luckWheelInfo2.getSequence()) != null) {
                        i = sequence2.size();
                    } else {
                        i = -1;
                    }
                    if (i > 0) {
                        LuckWheelInfo luckWheelInfo3 = this.mRoomLuckWheelInfo;
                        Participant participant = null;
                        if (luckWheelInfo3 != null && (participants = luckWheelInfo3.getParticipants()) != null) {
                            Participant participant2 = null;
                            for (Participant participant3 : participants) {
                                String externalId2 = participant3.getExternalId();
                                LuckWheelInfo luckWheelInfo4 = this.mRoomLuckWheelInfo;
                                if (luckWheelInfo4 != null && (sequence = luckWheelInfo4.getSequence()) != null) {
                                    str = sequence.get(i - 1);
                                } else {
                                    str = null;
                                }
                                if (Intrinsics.areEqual(externalId2, str)) {
                                    participant2 = participant3;
                                }
                            }
                            participant = participant2;
                        }
                        if (participant != null) {
                            Log.d(TAG, "LucklyWheel getWinInfoAndShow: ");
                            String avatar = participant.getAvatar();
                            if (avatar == null) {
                                avatar = "";
                            }
                            String nick = participant.getNick();
                            if (nick != null) {
                                str2 = nick;
                            }
                            showWinOption(avatar, str2);
                        }
                    }
                }
            } else {
                showRotateingView();
                ArrayList<Participant> participants2 = luckWheelInfo.getParticipants();
                if (participants2 != null) {
                    i2 = participants2.size();
                }
                this.mAllNumber = i2;
                ((DialogLuckyWheelBinding) getBinding()).turnText.post(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.m0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LuckyWheelDialog.updateView$lambda$3(LuckyWheelDialog.this, luckWheelInfo);
                    }
                });
            }
        } else {
            String creator = luckWheelInfo.getCreator();
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && (externalId = user.getExternalId()) != null) {
                str2 = externalId;
            }
            showStartView(Intrinsics.areEqual(creator, str2));
            ((DialogLuckyWheelBinding) getBinding()).turnText.post(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.l0
                @Override // java.lang.Runnable
                public final void run() {
                    LuckyWheelDialog.updateView$lambda$1(LuckyWheelDialog.this, luckWheelInfo);
                }
            });
            ArrayList<Participant> participants3 = luckWheelInfo.getParticipants();
            if (participants3 != null) {
                i2 = participants3.size();
            }
            ((DialogLuckyWheelBinding) getBinding()).personNumber.setText(i2 + "/10");
        }
        ((DialogLuckyWheelBinding) getBinding()).diamond.setText(String.valueOf(luckWheelInfo.getTotalFee()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$1(LuckyWheelDialog luckyWheelDialog, LuckWheelInfo luckWheelInfo) {
        ((DialogLuckyWheelBinding) luckyWheelDialog.getBinding()).turnText.setList(luckyWheelDialog.luckWheelInfoChangeToTurnTextBean(luckWheelInfo.getParticipants()), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$3(LuckyWheelDialog luckyWheelDialog, LuckWheelInfo luckWheelInfo) {
        int i;
        ArrayList<Participant> participants;
        luckyWheelDialog.updateSequenceData(luckWheelInfo);
        LuckWheelInfo luckWheelInfo2 = luckyWheelDialog.mRoomLuckWheelInfo;
        if (luckWheelInfo2 != null && (participants = luckWheelInfo2.getParticipants()) != null && participants.size() == 1) {
            luckyWheelDialog.show();
            luckyWheelDialog.stopTaskCycle();
            luckyWheelDialog.getWinInfoAndShow();
            return;
        }
        ((DialogLuckyWheelBinding) luckyWheelDialog.getBinding()).turnText.setList(luckyWheelDialog.luckWheelInfoChangeToTurnTextBean(luckWheelInfo.getParticipants()), true);
        if (luckWheelInfo.getSequence() != null) {
            List<String> sequence = luckWheelInfo.getSequence();
            Intrinsics.checkNotNull(sequence, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
            luckyWheelDialog.startTaskCycle(TypeIntrinsics.asMutableList(sequence));
        }
        AppCompatTextView appCompatTextView = ((DialogLuckyWheelBinding) luckyWheelDialog.getBinding()).personNumber;
        ArrayList<Participant> participants2 = luckWheelInfo.getParticipants();
        if (participants2 != null) {
            i = participants2.size();
        } else {
            i = 0;
        }
        appCompatTextView.setText(i + "/" + luckyWheelDialog.mAllNumber);
    }

    public void dismiss() {
        super.dismiss();
        Log.d(TAG, "dismiss: ------");
        this.mLuckyWheelListener = null;
        release();
        nd.c cVar = this.mTaskCycle;
        if (cVar != null && !cVar.isDisposed()) {
            cVar.dispose();
        }
        this.mTaskCycle = null;
        nd.c cVar2 = this.mBgTask;
        if (cVar2 != null && !cVar2.isDisposed()) {
            cVar2.dispose();
        }
        this.mBgTask = null;
    }

    public final boolean getHasNextTime() {
        return this.hasNextTime;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_lucky_wheel;
    }

    public final int getMAllNumber() {
        return this.mAllNumber;
    }

    @Nullable
    public final nd.c getMBgTask() {
        return this.mBgTask;
    }

    @Nullable
    public final LuckyWheelListener getMLuckyWheelListener() {
        return this.mLuckyWheelListener;
    }

    @Nullable
    public final LuckWheelInfo getMRoomLuckWheelInfo() {
        return this.mRoomLuckWheelInfo;
    }

    public final void hideJoinLayout() {
        ((DialogLuckyWheelBinding) getBinding()).llJoin.setVisibility(0);
    }

    /* renamed from: isChange, reason: from getter */
    public final boolean getIsChange() {
        return this.isChange;
    }

    /* renamed from: isShowWinView, reason: from getter */
    public final boolean getIsShowWinView() {
        return this.isShowWinView;
    }

    @Override // com.qiahao.nextvideo.room.view.TurntableMainCommonView2.OnResultListener
    public void onAnimationEnd(int status) {
        Log.d(TAG, "onAnimationEnd: " + status);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        super/*android.app.Dialog*/.onBackPressed();
        hide();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        String str;
        double d;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362254) {
            if (id2 != 2131362375) {
                if (id2 == 2131364846) {
                    Log.d(TAG, "onClick: small_lucky_wheel");
                    LuckyWheelListener luckyWheelListener = this.mLuckyWheelListener;
                    if (luckyWheelListener != null) {
                        luckyWheelListener.smallLuckyWheelView();
                    }
                    hide();
                    return;
                }
                return;
            }
            LuckyWheelListener luckyWheelListener2 = this.mLuckyWheelListener;
            if (luckyWheelListener2 != null) {
                luckyWheelListener2.closeLuckyWheelView();
            }
            Log.d(TAG, "onClick: cloe_lucky_wheel");
            return;
        }
        LuckWheelInfo luckWheelInfo = this.mRoomLuckWheelInfo;
        if (luckWheelInfo != null) {
            String creator = luckWheelInfo.getCreator();
            UserStore.Companion companion = UserStore.INSTANCE;
            User user = companion.getShared().getUser();
            if (user != null) {
                str = user.getExternalId();
            } else {
                str = null;
            }
            boolean areEqual = Intrinsics.areEqual(creator, str);
            int i = 0;
            if (areEqual) {
                ArrayList<Participant> participants = luckWheelInfo.getParticipants();
                if (participants != null && !participants.isEmpty()) {
                    ArrayList<Participant> participants2 = luckWheelInfo.getParticipants();
                    if (participants2 != null) {
                        i = participants2.size();
                    }
                    if (i < 2) {
                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.mCurrentContext, ResourcesKtxKt.getStringById(this, 2131953164), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    LuckyWheelListener luckyWheelListener3 = this.mLuckyWheelListener;
                    if (luckyWheelListener3 != null) {
                        luckyWheelListener3.playLuckyWheelView();
                    }
                    ((DialogLuckyWheelBinding) getBinding()).startClick.setVisibility(8);
                    return;
                }
                Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.mCurrentContext, ResourcesKtxKt.getStringById(this, 2131953164), false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                    return;
                }
                return;
            }
            User user2 = companion.getShared().getUser();
            if (user2 != null) {
                d = user2.getDiamondNum();
            } else {
                d = 0.0d;
            }
            LuckWheelInfo luckWheelInfo2 = this.mRoomLuckWheelInfo;
            if (luckWheelInfo2 != null) {
                i = luckWheelInfo2.getEntranceFee();
            }
            if (d >= i) {
                LuckyWheelListener luckyWheelListener4 = this.mLuckyWheelListener;
                if (luckyWheelListener4 != null) {
                    luckyWheelListener4.joinLuckyWheelGame();
                    return;
                }
                return;
            }
            commonDialogShow();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        initView();
        initObserver();
        ((DialogLuckyWheelBinding) getBinding()).setClick(this);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        setBackgroundDimAmount(0.0f);
    }

    public final void release() {
        stopTaskCycle();
        ((DialogLuckyWheelBinding) getBinding()).turnText.release();
    }

    public final void setChange(boolean z) {
        this.isChange = z;
    }

    public final void setDate(@NotNull LuckWheelInfo luckWheelInfo) {
        Intrinsics.checkNotNullParameter(luckWheelInfo, "luckWheelInfo");
        this.mRoomLuckWheelInfo = luckWheelInfo;
        if (luckWheelInfo != null) {
            updateView(luckWheelInfo);
        }
    }

    public final void setHasNextTime(boolean z) {
        this.hasNextTime = z;
    }

    public final void setMAllNumber(int i) {
        this.mAllNumber = i;
    }

    public final void setMBgTask(@Nullable nd.c cVar) {
        this.mBgTask = cVar;
    }

    public final void setMLuckyWheelListener(@Nullable LuckyWheelListener luckyWheelListener) {
        this.mLuckyWheelListener = luckyWheelListener;
    }

    public final void setMRoomLuckWheelInfo(@Nullable LuckWheelInfo luckWheelInfo) {
        this.mRoomLuckWheelInfo = luckWheelInfo;
    }

    public final void setShowWinView(boolean z) {
        this.isShowWinView = z;
    }

    public void show() {
        super/*com.oudi.core.component.SuperDialog*/.show();
        startBgTask();
    }

    @Override // com.qiahao.nextvideo.room.view.TurntableMainCommonView2.OnResultListener
    public void onSelectOption(@NotNull TurnTextBean data, int sumHas) {
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d(TAG, "onSelectOption: " + data.getId1() + " " + data.getImage1() + " " + sumHas);
        AppCompatTextView appCompatTextView = ((DialogLuckyWheelBinding) getBinding()).personNumber;
        int i = this.mAllNumber;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sumHas);
        sb2.append("/");
        sb2.append(i);
        appCompatTextView.setText(sb2.toString());
        showLoserView(data.getImage1());
    }

    @Override // com.qiahao.nextvideo.room.view.TurntableMainCommonView2.OnResultListener
    public void onWinOption(@NotNull TurnTextBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Log.d(TAG, "LucklyWheel onWinOption: " + data.getId1() + " " + data.getImage1());
        String image1 = data.getImage1();
        String text = data.getText();
        if (text == null) {
            text = "";
        }
        showWinOption(image1, text);
    }
}

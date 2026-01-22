package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.databinding.ViewGameNoticeBinding;
import com.qiahao.nextvideo.databinding.ViewGiftNoticeBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.animation.AnimationUtility;
import com.qiahao.nextvideo.utilities.animation.GiftNoticeUIModel;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\t\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\t¨\u0006\u000b"}, d2 = {"refreshGiftView", "", "Lcom/qiahao/nextvideo/room/help/AudioRoomFragmentHelp;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewGiftNoticeBinding;", "data", "Lcom/qiahao/nextvideo/utilities/animation/GiftNoticeUIModel;", "refreshGameView", "Lcom/qiahao/nextvideo/databinding/ViewGameNoticeBinding;", "LuserProxy/UserProxy1$GlobalGameBanner;", "Lcom/qiahao/nextvideo/room/help/GameRoomFragmentHelp;", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAudioRoomExtraData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioRoomExtraData.kt\ncom/qiahao/nextvideo/room/help/AudioRoomExtraDataKt\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,177:1\n439#2:178\n439#2:179\n439#2:180\n439#2:181\n439#2:182\n439#2:183\n439#2:184\n439#2:185\n439#2:186\n439#2:187\n439#2:188\n439#2:189\n439#2:190\n439#2:191\n439#2:192\n439#2:202\n439#2:203\n439#2:204\n439#2:205\n439#2:206\n439#2:207\n439#2:208\n439#2:209\n439#2:210\n439#2:211\n439#2:212\n439#2:213\n439#2:214\n439#2:215\n439#2:216\n61#3,9:193\n*S KotlinDebug\n*F\n+ 1 AudioRoomExtraData.kt\ncom/qiahao/nextvideo/room/help/AudioRoomExtraDataKt\n*L\n35#1:178\n36#1:179\n37#1:180\n40#1:181\n41#1:182\n42#1:183\n45#1:184\n46#1:185\n47#1:186\n50#1:187\n51#1:188\n52#1:189\n55#1:190\n56#1:191\n57#1:192\n118#1:202\n119#1:203\n120#1:204\n123#1:205\n124#1:206\n125#1:207\n128#1:208\n129#1:209\n130#1:210\n133#1:211\n134#1:212\n135#1:213\n138#1:214\n139#1:215\n140#1:216\n95#1:193,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioRoomExtraDataKt {
    public static final void refreshGameView(@NotNull final AudioRoomFragmentHelp audioRoomFragmentHelp, @NotNull ViewGameNoticeBinding viewGameNoticeBinding, @NotNull final UserProxy1.GlobalGameBanner globalGameBanner) {
        Intrinsics.checkNotNullParameter(audioRoomFragmentHelp, "<this>");
        Intrinsics.checkNotNullParameter(viewGameNoticeBinding, "binding");
        Intrinsics.checkNotNullParameter(globalGameBanner, "data");
        viewGameNoticeBinding.topImage.setVisibility(TextUtils.isEmpty(globalGameBanner.getBannerUrl()) ? 8 : 0);
        ImageView imageView = viewGameNoticeBinding.topImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "topImage");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(globalGameBanner.getBannerUrl(), UiKtxKt.toPX(100)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        QMUIRadiusImageView qMUIRadiusImageView = viewGameNoticeBinding.avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(globalGameBanner.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        viewGameNoticeBinding.diamond.setText("x" + globalGameBanner.getDiamond());
        viewGameNoticeBinding.getRoot().setTag(Long.valueOf(System.currentTimeMillis()));
        if (globalGameBanner.getIsPink()) {
            ImageView imageView2 = viewGameNoticeBinding.diamondImage;
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(imageView2.getContext(), R.drawable.game_notice_gem));
        } else {
            ImageView imageView3 = viewGameNoticeBinding.diamondImage;
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(imageView3.getContext(), R.drawable.game_notice_diamond));
        }
        final View root = viewGameNoticeBinding.getRoot();
        final long j = 800;
        root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.AudioRoomExtraDataKt$refreshGameView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context;
                AudioRoomDialogHelp mDialogHelp;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                    for (GameConfiguration gameConfiguration : MeetingRoomManager.INSTANCE.getGameList()) {
                        int gameId = (int) globalGameBanner.getGameId();
                        Integer gameId2 = gameConfiguration.getGameId();
                        if (gameId2 != null && gameId == gameId2.intValue() && (context = audioRoomFragmentHelp.getFragment().getContext()) != null && (mDialogHelp = audioRoomFragmentHelp.getFragment().getMDialogHelp()) != null) {
                            mDialogHelp.showGame(context, gameConfiguration);
                        }
                    }
                }
            }
        });
    }

    public static final void refreshGiftView(@NotNull AudioRoomFragmentHelp audioRoomFragmentHelp, @NotNull final ViewGiftNoticeBinding viewGiftNoticeBinding, @NotNull GiftNoticeUIModel giftNoticeUIModel) {
        StringBuilder sb2;
        Intrinsics.checkNotNullParameter(audioRoomFragmentHelp, "<this>");
        Intrinsics.checkNotNullParameter(viewGiftNoticeBinding, "binding");
        Intrinsics.checkNotNullParameter(giftNoticeUIModel, "data");
        QMUIRadiusImageView2 qMUIRadiusImageView2 = viewGiftNoticeBinding.circleImageView;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "circleImageView");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(giftNoticeUIModel.getSenderPicture()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        AppCompatImageView appCompatImageView = viewGiftNoticeBinding.giftIconImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "giftIconImageView");
        ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(giftNoticeUIModel.getGiftIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232497, (c5.g) null, 49150, (Object) null);
        AppCompatTextView appCompatTextView = viewGiftNoticeBinding.comboGiftCountTipTextView;
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            long count = giftNoticeUIModel.getCount();
            sb2 = new StringBuilder();
            sb2.append(count);
            sb2.append(" x");
        } else {
            long count2 = giftNoticeUIModel.getCount();
            sb2 = new StringBuilder();
            sb2.append("x ");
            sb2.append(count2);
        }
        appCompatTextView.setText(sb2.toString());
        viewGiftNoticeBinding.fromNicknameTextView.setText(DataExternalKt.maxLengthSuffix(giftNoticeUIModel.getFromNickname(), 8, "..."));
        viewGiftNoticeBinding.toNicknameTextView.setText(DataExternalKt.maxLengthSuffix(giftNoticeUIModel.getToNickname(), 8, "..."));
        if (giftNoticeUIModel.getNobleLevel() == 7) {
            viewGiftNoticeBinding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.send.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.bg.setImageDrawable(androidx.core.content.a.getDrawable(viewGiftNoticeBinding.getRoot().getContext(), R.drawable.bg_gift_noble7));
        } else if (giftNoticeUIModel.getNobleLevel() == 8) {
            viewGiftNoticeBinding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.send.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.bg.setImageDrawable(androidx.core.content.a.getDrawable(viewGiftNoticeBinding.getRoot().getContext(), R.drawable.bg_gift_noble8));
        } else if (giftNoticeUIModel.getNobleLevel() == 9) {
            viewGiftNoticeBinding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.send.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.bg.setImageDrawable(androidx.core.content.a.getDrawable(viewGiftNoticeBinding.getRoot().getContext(), R.drawable.bg_gift_noble9));
        } else if (giftNoticeUIModel.getNobleLevel() >= 10) {
            viewGiftNoticeBinding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.send.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.bg.setImageDrawable(androidx.core.content.a.getDrawable(viewGiftNoticeBinding.getRoot().getContext(), R.drawable.bg_gift_noble10));
        } else {
            viewGiftNoticeBinding.fromNicknameTextView.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.toNicknameTextView.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.send.setTextColor(Color.parseColor("#ffca22"));
            viewGiftNoticeBinding.bg.setImageDrawable(androidx.core.content.a.getDrawable(viewGiftNoticeBinding.getRoot().getContext(), R.drawable.bg_gift_notice));
        }
        if (giftNoticeUIModel.isMystery()) {
            QMUIRadiusImageView2 qMUIRadiusImageView22 = viewGiftNoticeBinding.circleImageView;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView22, "circleImageView");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView22, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else {
            QMUIRadiusImageView2 qMUIRadiusImageView23 = viewGiftNoticeBinding.circleImageView;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView23, "circleImageView");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView23, giftNoticeUIModel.getSenderPicture(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        }
        if (giftNoticeUIModel.isSame()) {
            viewGiftNoticeBinding.comboGiftCountTipTextView.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.help.w0
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRoomExtraDataKt.refreshGiftView$lambda$0(ViewGiftNoticeBinding.this);
                }
            }, 400L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshGiftView$lambda$0(ViewGiftNoticeBinding viewGiftNoticeBinding) {
        AnimationUtility animationUtility = AnimationUtility.INSTANCE;
        AppCompatTextView appCompatTextView = viewGiftNoticeBinding.comboGiftCountTipTextView;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "comboGiftCountTipTextView");
        animationUtility.giftCombo(appCompatTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshGiftView$lambda$4(ViewGiftNoticeBinding viewGiftNoticeBinding) {
        AnimationUtility animationUtility = AnimationUtility.INSTANCE;
        AppCompatTextView appCompatTextView = viewGiftNoticeBinding.comboGiftCountTipTextView;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "comboGiftCountTipTextView");
        animationUtility.giftCombo(appCompatTextView);
    }

    public static final void refreshGameView(@NotNull GameRoomFragmentHelp gameRoomFragmentHelp, @NotNull ViewGameNoticeBinding viewGameNoticeBinding, @NotNull UserProxy1.GlobalGameBanner globalGameBanner) {
        Intrinsics.checkNotNullParameter(gameRoomFragmentHelp, "<this>");
        Intrinsics.checkNotNullParameter(viewGameNoticeBinding, "binding");
        Intrinsics.checkNotNullParameter(globalGameBanner, "data");
        viewGameNoticeBinding.topImage.setVisibility(TextUtils.isEmpty(globalGameBanner.getBannerUrl()) ? 8 : 0);
        ImageView imageView = viewGameNoticeBinding.topImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "topImage");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(globalGameBanner.getBannerUrl(), UiKtxKt.toPX(100)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        QMUIRadiusImageView qMUIRadiusImageView = viewGameNoticeBinding.avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(globalGameBanner.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        viewGameNoticeBinding.diamond.setText("x" + globalGameBanner.getDiamond());
        viewGameNoticeBinding.getRoot().setTag(Long.valueOf(System.currentTimeMillis()));
        if (globalGameBanner.getIsPink()) {
            ImageView imageView2 = viewGameNoticeBinding.diamondImage;
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(imageView2.getContext(), R.drawable.game_notice_gem));
        } else {
            ImageView imageView3 = viewGameNoticeBinding.diamondImage;
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(imageView3.getContext(), R.drawable.game_notice_diamond));
        }
    }

    public static final void refreshGiftView(@NotNull GameRoomFragmentHelp gameRoomFragmentHelp, @NotNull final ViewGiftNoticeBinding viewGiftNoticeBinding, @NotNull GiftNoticeUIModel giftNoticeUIModel) {
        StringBuilder sb2;
        Intrinsics.checkNotNullParameter(gameRoomFragmentHelp, "<this>");
        Intrinsics.checkNotNullParameter(viewGiftNoticeBinding, "binding");
        Intrinsics.checkNotNullParameter(giftNoticeUIModel, "data");
        QMUIRadiusImageView2 qMUIRadiusImageView2 = viewGiftNoticeBinding.circleImageView;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "circleImageView");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(giftNoticeUIModel.getSenderPicture()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        AppCompatImageView appCompatImageView = viewGiftNoticeBinding.giftIconImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "giftIconImageView");
        ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(giftNoticeUIModel.getGiftIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232497, (c5.g) null, 49150, (Object) null);
        AppCompatTextView appCompatTextView = viewGiftNoticeBinding.comboGiftCountTipTextView;
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            long count = giftNoticeUIModel.getCount();
            sb2 = new StringBuilder();
            sb2.append(count);
            sb2.append(" x");
        } else {
            long count2 = giftNoticeUIModel.getCount();
            sb2 = new StringBuilder();
            sb2.append("x ");
            sb2.append(count2);
        }
        appCompatTextView.setText(sb2.toString());
        viewGiftNoticeBinding.fromNicknameTextView.setText(DataExternalKt.maxLengthSuffix(giftNoticeUIModel.getFromNickname(), 8, "..."));
        viewGiftNoticeBinding.toNicknameTextView.setText(DataExternalKt.maxLengthSuffix(giftNoticeUIModel.getToNickname(), 8, "..."));
        if (giftNoticeUIModel.getNobleLevel() == 7) {
            viewGiftNoticeBinding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.send.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.bg.setImageDrawable(androidx.core.content.a.getDrawable(viewGiftNoticeBinding.getRoot().getContext(), R.drawable.bg_gift_noble7));
        } else if (giftNoticeUIModel.getNobleLevel() == 8) {
            viewGiftNoticeBinding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.send.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.bg.setImageDrawable(androidx.core.content.a.getDrawable(viewGiftNoticeBinding.getRoot().getContext(), R.drawable.bg_gift_noble8));
        } else if (giftNoticeUIModel.getNobleLevel() == 9) {
            viewGiftNoticeBinding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.send.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.bg.setImageDrawable(androidx.core.content.a.getDrawable(viewGiftNoticeBinding.getRoot().getContext(), R.drawable.bg_gift_noble9));
        } else if (giftNoticeUIModel.getNobleLevel() >= 10) {
            viewGiftNoticeBinding.fromNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.toNicknameTextView.setTextColor(Color.parseColor("#ffff00"));
            viewGiftNoticeBinding.send.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.bg.setImageDrawable(androidx.core.content.a.getDrawable(viewGiftNoticeBinding.getRoot().getContext(), R.drawable.bg_gift_noble10));
        } else {
            viewGiftNoticeBinding.fromNicknameTextView.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.toNicknameTextView.setTextColor(Color.parseColor("#ffffff"));
            viewGiftNoticeBinding.send.setTextColor(Color.parseColor("#ffca22"));
            viewGiftNoticeBinding.bg.setImageDrawable(androidx.core.content.a.getDrawable(viewGiftNoticeBinding.getRoot().getContext(), R.drawable.bg_gift_notice));
        }
        if (giftNoticeUIModel.isMystery()) {
            QMUIRadiusImageView2 qMUIRadiusImageView22 = viewGiftNoticeBinding.circleImageView;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView22, "circleImageView");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView22, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else {
            QMUIRadiusImageView2 qMUIRadiusImageView23 = viewGiftNoticeBinding.circleImageView;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView23, "circleImageView");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView23, giftNoticeUIModel.getSenderPicture(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        }
        if (giftNoticeUIModel.isSame()) {
            viewGiftNoticeBinding.comboGiftCountTipTextView.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.help.v0
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRoomExtraDataKt.refreshGiftView$lambda$4(ViewGiftNoticeBinding.this);
                }
            }, 400L);
        }
    }
}

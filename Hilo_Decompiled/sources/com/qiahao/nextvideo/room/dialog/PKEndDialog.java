package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.text.GradientTextView;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.room.RoomPKEnd;
import com.qiahao.nextvideo.data.room.RoomPKUser;
import com.qiahao.nextvideo.databinding.DialogPkEndBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/PKEndDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogPkEndBinding;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/data/room/RoomPKEnd;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/room/RoomPKEnd;)V", "getData", "()Lcom/qiahao/nextvideo/data/room/RoomPKEnd;", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "getLayoutResId", "", "isNeedFullScreen", "", "onInitialize", "", "startPKSVGA", "dismiss", "show", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPKEndDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PKEndDialog.kt\ncom/qiahao/nextvideo/room/dialog/PKEndDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n61#2,9:139\n1878#3,3:148\n*S KotlinDebug\n*F\n+ 1 PKEndDialog.kt\ncom/qiahao/nextvideo/room/dialog/PKEndDialog\n*L\n55#1:139,9\n61#1:148,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKEndDialog extends BaseBindingDialog<DialogPkEndBinding> {

    @NotNull
    private final RoomPKEnd data;

    @Nullable
    private CountDownTimer timerTask;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKEndDialog(@NotNull Context context, @NotNull RoomPKEnd roomPKEnd) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(roomPKEnd, "data");
        this.data = roomPKEnd;
    }

    public static final /* synthetic */ DialogPkEndBinding access$getBinding(PKEndDialog pKEndDialog) {
        return (DialogPkEndBinding) pKEndDialog.getBinding();
    }

    private final void startPKSVGA() {
        try {
            SVGAParser.Companion.shareParser().decodeFromAssets("svga/pk_diamond.svga", new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.dialog.PKEndDialog$startPKSVGA$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    Drawable sVGADrawable = new SVGADrawable(videoItem, new SVGADynamicEntity());
                    PKEndDialog.access$getBinding(PKEndDialog.this).pkSvga.setVisibility(0);
                    PKEndDialog.access$getBinding(PKEndDialog.this).pkSvga.setImageDrawable(sVGADrawable);
                    PKEndDialog.access$getBinding(PKEndDialog.this).pkSvga.setLoops(1);
                    PKEndDialog.access$getBinding(PKEndDialog.this).pkSvga.startAnimation();
                }

                public void onError() {
                    PKEndDialog.access$getBinding(PKEndDialog.this).pkSvga.setVisibility(8);
                }
            });
        } catch (Exception unused) {
        }
    }

    public void dismiss() {
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerTask = null;
        ((DialogPkEndBinding) getBinding()).pkSvga.setVisibility(8);
        ((DialogPkEndBinding) getBinding()).pkSvga.stopAnimation();
        super.dismiss();
    }

    @NotNull
    public final RoomPKEnd getData() {
        return this.data;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_pk_end;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        long j;
        long j2;
        long j3;
        long j4;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        if (this.data.getWin() == 1) {
            ((DialogPkEndBinding) getBinding()).bg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.pk_win_bg));
            ((DialogPkEndBinding) getBinding()).diamond.setGradientColors(new int[]{Color.parseColor("#FFF250"), Color.parseColor("#FB9300")});
            ((DialogPkEndBinding) getBinding()).roomBg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.pk_win_header_bg));
            ((DialogPkEndBinding) getBinding()).name.setTextColor(Color.parseColor("#FBF01D"));
            ((DialogPkEndBinding) getBinding()).oneDiamond.setTextColor(Color.parseColor("#FBF01D"));
            ((DialogPkEndBinding) getBinding()).twoDiamond.setTextColor(Color.parseColor("#FBF01D"));
            ((DialogPkEndBinding) getBinding()).threeDiamond.setTextColor(Color.parseColor("#FBF01D"));
        } else {
            ((DialogPkEndBinding) getBinding()).bg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.pk_loss_bg));
            ((DialogPkEndBinding) getBinding()).diamond.setGradientColors(new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF")});
            ((DialogPkEndBinding) getBinding()).roomBg.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.pk_loss_header_bg));
            ((DialogPkEndBinding) getBinding()).name.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
            ((DialogPkEndBinding) getBinding()).oneDiamond.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
            ((DialogPkEndBinding) getBinding()).twoDiamond.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
            ((DialogPkEndBinding) getBinding()).threeDiamond.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
        }
        final ImageView imageView = ((DialogPkEndBinding) getBinding()).close;
        final long j5 = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.PKEndDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j5 || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        QMUIRadiusImageView qMUIRadiusImageView = ((DialogPkEndBinding) getBinding()).avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, this.data.getGroupFaceUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        ((DialogPkEndBinding) getBinding()).name.setText(this.data.getGroupName());
        GradientTextView gradientTextView = ((DialogPkEndBinding) getBinding()).diamond;
        Long diamonds = this.data.getDiamonds();
        if (diamonds != null) {
            j = diamonds.longValue();
        } else {
            j = 0;
        }
        gradientTextView.setText(NumberUtilsKt.rankNumberFormat(j));
        List<RoomPKUser> top3 = this.data.getTop3();
        if (top3 != null) {
            int i = 0;
            for (Object obj : top3) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                RoomPKUser roomPKUser = (RoomPKUser) obj;
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            QMUIRadiusImageView qMUIRadiusImageView2 = ((DialogPkEndBinding) getBinding()).threeAvatar;
                            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "threeAvatar");
                            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, roomPKUser.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
                            TextView textView = ((DialogPkEndBinding) getBinding()).threeDiamond;
                            Long score = roomPKUser.getScore();
                            if (score != null) {
                                j4 = score.longValue();
                            } else {
                                j4 = 0;
                            }
                            textView.setText(NumberUtilsKt.rankNumberFormat(j4));
                            ((DialogPkEndBinding) getBinding()).threeAvatar.setVisibility(0);
                            ((DialogPkEndBinding) getBinding()).threeDiamond.setVisibility(0);
                        }
                    } else {
                        QMUIRadiusImageView qMUIRadiusImageView3 = ((DialogPkEndBinding) getBinding()).twoAvatar;
                        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "twoAvatar");
                        ImageKtxKt.loadImage$default(qMUIRadiusImageView3, roomPKUser.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
                        TextView textView2 = ((DialogPkEndBinding) getBinding()).twoDiamond;
                        Long score2 = roomPKUser.getScore();
                        if (score2 != null) {
                            j3 = score2.longValue();
                        } else {
                            j3 = 0;
                        }
                        textView2.setText(NumberUtilsKt.rankNumberFormat(j3));
                        ((DialogPkEndBinding) getBinding()).twoAvatar.setVisibility(0);
                        ((DialogPkEndBinding) getBinding()).twoDiamond.setVisibility(0);
                    }
                } else {
                    QMUIRadiusImageView qMUIRadiusImageView4 = ((DialogPkEndBinding) getBinding()).oneAvatar;
                    Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView4, "oneAvatar");
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView4, roomPKUser.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
                    TextView textView3 = ((DialogPkEndBinding) getBinding()).oneDiamond;
                    Long score3 = roomPKUser.getScore();
                    if (score3 != null) {
                        j2 = score3.longValue();
                    } else {
                        j2 = 0;
                    }
                    textView3.setText(NumberUtilsKt.rankNumberFormat(j2));
                    ((DialogPkEndBinding) getBinding()).oneAvatar.setVisibility(0);
                    ((DialogPkEndBinding) getBinding()).oneDiamond.setVisibility(0);
                }
                i = i2;
            }
        }
        this.timerTask = new CountDownTimer() { // from class: com.qiahao.nextvideo.room.dialog.PKEndDialog$onInitialize$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(6000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                PKEndDialog.this.setTimerTask(null);
                PKEndDialog.this.dismiss();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
            }
        };
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }

    public void show() {
        super/*com.oudi.core.component.SuperDialog*/.show();
        if (this.data.getWin() == 1 && this.data.getBoxLevel() > 0) {
            startPKSVGA();
        }
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }
}

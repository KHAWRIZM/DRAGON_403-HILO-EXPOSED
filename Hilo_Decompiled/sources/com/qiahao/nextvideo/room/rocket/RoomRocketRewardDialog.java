package com.qiahao.nextvideo.room.rocket;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c5.g;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.MyAward;
import com.qiahao.nextvideo.databinding.DialogRoomRocketReawardBinding;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0014B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/room/rocket/RoomRocketRewardDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogRoomRocketReawardBinding;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "mMyAward", "Lcom/qiahao/nextvideo/data/model/MyAward;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/model/MyAward;)V", "getMMyAward", "()Lcom/qiahao/nextvideo/data/model/MyAward;", "getLayoutResId", "", "onInitialize", "", "onClick", "v", "Landroid/view/View;", "showView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomRocketRewardDialog extends BaseBindingDialog<DialogRoomRocketReawardBinding> implements View.OnClickListener {
    public static final int ROCKET_AWARD_DIAMOND = 3;
    public static final int ROCKET_AWARD_GUEST_DIAMOND = 0;
    public static final int ROCKET_AWARD_HEADDRESS = 2;
    public static final int ROCKET_AWARD_PROPERTY = 1;
    public static final int mPKBox = 4;

    @NotNull
    private final MyAward mMyAward;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomRocketRewardDialog(@NotNull Context context, @NotNull MyAward myAward) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(myAward, "mMyAward");
        this.mMyAward = myAward;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showView() {
        if (this.mMyAward.getAwardType() == 0 && this.mMyAward.getNumber() == 0) {
            ((DialogRoomRocketReawardBinding) getBinding()).rewardContent.setVisibility(0);
            ((DialogRoomRocketReawardBinding) getBinding()).failureFace.setVisibility(0);
            ((DialogRoomRocketReawardBinding) getBinding()).failureText.setVisibility(0);
            ((DialogRoomRocketReawardBinding) getBinding()).winName.setVisibility(8);
            ((DialogRoomRocketReawardBinding) getBinding()).winReward.setVisibility(8);
            ((DialogRoomRocketReawardBinding) getBinding()).winCongratulation.setVisibility(8);
            return;
        }
        ((DialogRoomRocketReawardBinding) getBinding()).rewardContent.setVisibility(0);
        ((DialogRoomRocketReawardBinding) getBinding()).failureFace.setVisibility(8);
        ((DialogRoomRocketReawardBinding) getBinding()).failureText.setVisibility(8);
        ((DialogRoomRocketReawardBinding) getBinding()).winName.setVisibility(0);
        ((DialogRoomRocketReawardBinding) getBinding()).winReward.setVisibility(0);
        ((DialogRoomRocketReawardBinding) getBinding()).winCongratulation.setVisibility(0);
        int awardType = this.mMyAward.getAwardType();
        if (awardType != 0) {
            if (awardType != 1 && awardType != 2) {
                if (awardType != 3) {
                    if (awardType == 4) {
                        ((DialogRoomRocketReawardBinding) getBinding()).rewardContent.setBackground(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_pk_bg));
                        if (Intrinsics.areEqual(this.mMyAward.getHasAward(), Boolean.TRUE)) {
                            ((DialogRoomRocketReawardBinding) getBinding()).winCongratulation.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.pk_title));
                            ImageView imageView = ((DialogRoomRocketReawardBinding) getBinding()).winReward;
                            Intrinsics.checkNotNullExpressionValue(imageView, "winReward");
                            ImageKtxKt.loadImage$default(imageView, this.mMyAward.getUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
                            ((DialogRoomRocketReawardBinding) getBinding()).winName.setText(NumberUtilsKt.rankNumberFormat(this.mMyAward.getNumber()));
                            return;
                        }
                        ((DialogRoomRocketReawardBinding) getBinding()).winCongratulation.setVisibility(8);
                        ((DialogRoomRocketReawardBinding) getBinding()).winReward.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.icon_rocket_face));
                        ((DialogRoomRocketReawardBinding) getBinding()).winName.setText(ResourcesKtxKt.getStringById(this, 2131952109));
                        return;
                    }
                    return;
                }
                ImageView imageView2 = ((DialogRoomRocketReawardBinding) getBinding()).winReward;
                Intrinsics.checkNotNullExpressionValue(imageView2, "winReward");
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_more_dimond), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                ((DialogRoomRocketReawardBinding) getBinding()).winName.setText(String.valueOf(this.mMyAward.getNumber()));
                return;
            }
            ImageView imageView3 = ((DialogRoomRocketReawardBinding) getBinding()).winReward;
            Intrinsics.checkNotNullExpressionValue(imageView3, "winReward");
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            String url = this.mMyAward.getUrl();
            ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            lfit.setWidth(dimens.dpToPx(135));
            lfit.setHeight(dimens.dpToPx(135));
            Unit unit = Unit.INSTANCE;
            ImageUIModel displayImage = companion.displayImage(url, lfit);
            displayImage.setPlaceholder(2131232497);
            ViewUtilitiesKt.bind(imageView3, displayImage);
            TextView textView = ((DialogRoomRocketReawardBinding) getBinding()).winName;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131952502), Arrays.copyOf(new Object[]{String.valueOf(this.mMyAward.getNumber())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            return;
        }
        ImageView imageView4 = ((DialogRoomRocketReawardBinding) getBinding()).winReward;
        Intrinsics.checkNotNullExpressionValue(imageView4, "winReward");
        ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_rocket_less_dimond), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        ((DialogRoomRocketReawardBinding) getBinding()).winName.setText(String.valueOf(this.mMyAward.getNumber()));
    }

    protected int getLayoutResId() {
        return R.layout.dialog_room_rocket_reaward;
    }

    @NotNull
    public final MyAward getMMyAward() {
        return this.mMyAward;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == 2131364111) {
            dismiss();
        }
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogRoomRocketReawardBinding) getBinding()).setClick(this);
        setBackgroundDimAmount(0.0f);
        showView();
    }
}

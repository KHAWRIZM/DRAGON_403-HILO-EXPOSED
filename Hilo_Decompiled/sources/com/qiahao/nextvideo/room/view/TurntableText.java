package com.qiahao.nextvideo.room.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.WheelGameInfo;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/room/view/TurntableText;", "Lcom/qiahao/nextvideo/room/view/TurntableMainCommonView2;", "Lcom/qiahao/nextvideo/room/view/TurnTextBean;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "type", "getType", "()I", "setType", "(I)V", "getItemView", "Landroid/view/View;", "viewLoader", "", "view", "baseBean", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TurntableText extends TurntableMainCommonView2<TurnTextBean> {
    private int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TurntableText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.type = WheelGameInfo.INSTANCE.getText();
    }

    @Override // com.qiahao.nextvideo.room.view.TurntableMainCommonView2
    @RequiresApi(23)
    @Nullable
    public View getItemView() {
        int i = this.type;
        WheelGameInfo.Companion companion = WheelGameInfo.INSTANCE;
        if (i == companion.getDiamond()) {
            return new CircleImageView(getContext());
        }
        if (i == companion.getText()) {
            TextView textView = new TextView(getContext());
            textView.setGravity(17);
            textView.setTextColor(androidx.databinding.q.a(getContext(), 2131101214));
            textView.setTypeface(Typeface.defaultFromStyle(1));
            textView.setTextSize(0, Dimens.INSTANCE.dpToPx(10));
            return textView;
        }
        if (i == companion.getMic()) {
            return new ImageView(getContext());
        }
        if (i == companion.getGift()) {
            return new ImageView(getContext());
        }
        return null;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
        WheelGameInfo.Companion companion = WheelGameInfo.INSTANCE;
        if (i == companion.getText()) {
            setCentrifugal(12);
            setAdditionalAngle(-90);
            Dimens dimens = Dimens.INSTANCE;
            setItemWidth(dimens.dpToPx(80));
            setItemHeight(dimens.dpToPx(40));
            return;
        }
        if (i == companion.getMic()) {
            setCentrifugal(6);
            setAdditionalAngle(0);
            Dimens dimens2 = Dimens.INSTANCE;
            setItemWidth(dimens2.dpToPx(43));
            setItemHeight(dimens2.dpToPx(43));
            return;
        }
        if (i == companion.getGift()) {
            setCentrifugal(5);
            setAdditionalAngle(0);
            Dimens dimens3 = Dimens.INSTANCE;
            setItemWidth(dimens3.dpToPx(50));
            setItemHeight(dimens3.dpToPx(60));
            return;
        }
        if (i == companion.getDiamond()) {
            setCentrifugal(6);
            setAdditionalAngle(0);
            Dimens dimens4 = Dimens.INSTANCE;
            setItemWidth(dimens4.dpToPx(34));
            setItemHeight(dimens4.dpToPx(34));
        }
    }

    @Override // com.qiahao.nextvideo.room.view.TurntableMainCommonView2
    public void viewLoader(@Nullable View view, @NotNull TurnTextBean baseBean) {
        Intrinsics.checkNotNullParameter(baseBean, "baseBean");
        int i = this.type;
        WheelGameInfo.Companion companion = WheelGameInfo.INSTANCE;
        if (i == companion.getDiamond()) {
            if (view instanceof CircleImageView) {
                ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
                String image1 = baseBean.getImage1();
                ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
                Dimens dimens = Dimens.INSTANCE;
                fill.setWidth(dimens.dpToPx(77));
                fill.setHeight(dimens.dpToPx(77));
                Unit unit = Unit.INSTANCE;
                ImageUIModel displayImage = companion2.displayImage(image1, fill);
                displayImage.setPlaceholder(Integer.valueOf(R.drawable.icon_gender_girl));
                ViewUtilitiesKt.bind$default((AppCompatImageView) view, displayImage, null, 2, null);
                return;
            }
            return;
        }
        if (i == companion.getText() && (view instanceof TextView)) {
            ((TextView) view).setText(baseBean.getText());
        }
    }
}

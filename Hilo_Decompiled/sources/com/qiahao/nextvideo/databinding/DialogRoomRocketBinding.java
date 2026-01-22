package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomRocketBinding extends ViewDataBinding {
    public final ImageView bgLight;
    public final ImageView bigReward;
    public final ImageView bigRocket;
    public final ConstraintLayout clTop1;
    public final ConstraintLayout clTop2;
    public final ConstraintLayout clTop3;
    public final ImageView imageView6;
    public final ImageView light;
    public final ImageView line1;
    public final ImageView line2;
    public final ImageView line3;
    public final ImageView line4;
    protected View.OnClickListener mClick;
    public final ProgressBar progressBar;
    public final ConstraintLayout progressContent;
    public final ImageView smallBlueRocket;
    public final ImageView smallGreenRocket;
    public final ImageView smallOrangeRocket;
    public final ImageView smallPurpleRocket;
    public final ImageView smallRedRocket;
    public final ImageView smallReward1;
    public final ImageView smallReward2;
    public final ImageView smallReward3;
    public final ImageView smallReward4;
    public final QMUIRadiusImageView top1Avatar;
    public final TextView top1Name;
    public final QMUIRadiusImageView top2Avatar;
    public final TextView top2Name;
    public final QMUIRadiusImageView top3Avatar;
    public final TextView top3Name;
    public final ConstraintLayout topContributorsContent;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomRocketBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ProgressBar progressBar, ConstraintLayout constraintLayout4, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, ImageView imageView15, ImageView imageView16, ImageView imageView17, ImageView imageView18, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, QMUIRadiusImageView qMUIRadiusImageView2, TextView textView2, QMUIRadiusImageView qMUIRadiusImageView3, TextView textView3, ConstraintLayout constraintLayout5) {
        super(obj, view, i);
        this.bgLight = imageView;
        this.bigReward = imageView2;
        this.bigRocket = imageView3;
        this.clTop1 = constraintLayout;
        this.clTop2 = constraintLayout2;
        this.clTop3 = constraintLayout3;
        this.imageView6 = imageView4;
        this.light = imageView5;
        this.line1 = imageView6;
        this.line2 = imageView7;
        this.line3 = imageView8;
        this.line4 = imageView9;
        this.progressBar = progressBar;
        this.progressContent = constraintLayout4;
        this.smallBlueRocket = imageView10;
        this.smallGreenRocket = imageView11;
        this.smallOrangeRocket = imageView12;
        this.smallPurpleRocket = imageView13;
        this.smallRedRocket = imageView14;
        this.smallReward1 = imageView15;
        this.smallReward2 = imageView16;
        this.smallReward3 = imageView17;
        this.smallReward4 = imageView18;
        this.top1Avatar = qMUIRadiusImageView;
        this.top1Name = textView;
        this.top2Avatar = qMUIRadiusImageView2;
        this.top2Name = textView2;
        this.top3Avatar = qMUIRadiusImageView3;
        this.top3Name = textView3;
        this.topContributorsContent = constraintLayout5;
    }

    public static DialogRoomRocketBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomRocketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogRoomRocketBinding bind(View view, Object obj) {
        return (DialogRoomRocketBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_rocket);
    }

    @Deprecated
    public static DialogRoomRocketBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomRocketBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_rocket, viewGroup, z, obj);
    }

    public static DialogRoomRocketBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomRocketBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomRocketBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_rocket, (ViewGroup) null, false, obj);
    }
}

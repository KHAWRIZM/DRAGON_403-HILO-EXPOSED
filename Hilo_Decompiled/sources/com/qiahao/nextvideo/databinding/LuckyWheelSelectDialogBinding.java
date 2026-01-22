package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LuckyWheelSelectDialogBinding extends ViewDataBinding {
    public final ConstraintLayout bgContent;
    public final ImageView close;
    public final LinearLayout llAlsoParticipate;
    public final LinearLayout llAutomaticNextRound;
    public final TextView luckyWheelCreate;
    public final ImageView luckyWheelQuestion;
    protected View.OnClickListener mClick;
    public final RecyclerView recyclerView;
    public final ImageView selectAlsoParticipate;
    public final ImageView selectAutomaticNextRound;
    public final ImageView titleImg;

    /* JADX INFO: Access modifiers changed from: protected */
    public LuckyWheelSelectDialogBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, ImageView imageView2, RecyclerView recyclerView, ImageView imageView3, ImageView imageView4, ImageView imageView5) {
        super(obj, view, i);
        this.bgContent = constraintLayout;
        this.close = imageView;
        this.llAlsoParticipate = linearLayout;
        this.llAutomaticNextRound = linearLayout2;
        this.luckyWheelCreate = textView;
        this.luckyWheelQuestion = imageView2;
        this.recyclerView = recyclerView;
        this.selectAlsoParticipate = imageView3;
        this.selectAutomaticNextRound = imageView4;
        this.titleImg = imageView5;
    }

    public static LuckyWheelSelectDialogBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static LuckyWheelSelectDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static LuckyWheelSelectDialogBinding bind(View view, Object obj) {
        return (LuckyWheelSelectDialogBinding) ViewDataBinding.bind(obj, view, R.layout.lucky_wheel_select_dialog);
    }

    @Deprecated
    public static LuckyWheelSelectDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LuckyWheelSelectDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.lucky_wheel_select_dialog, viewGroup, z, obj);
    }

    public static LuckyWheelSelectDialogBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static LuckyWheelSelectDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LuckyWheelSelectDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.lucky_wheel_select_dialog, (ViewGroup) null, false, obj);
    }
}

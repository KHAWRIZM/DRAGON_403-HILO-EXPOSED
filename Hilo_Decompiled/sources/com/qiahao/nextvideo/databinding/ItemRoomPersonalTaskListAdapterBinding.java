package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemRoomPersonalTaskListAdapterBinding extends ViewDataBinding {
    public final TextView animDiamond;
    public final LinearLayout centerDiamondContainer;
    public final View centerDotView;
    public final LinearLayout endDiamondContainer;
    public final View endDotView;
    public final TextView goBtn;
    public final ConstraintLayout itemContainer;
    public final ImageView ivTaskIcon;
    public final LinearLayout startDiamondContainer;
    public final View startDotView;
    public final ProgressBar taskProgress;
    public final TextView tvCenterDiamond;
    public final TextView tvCenterTimeText;
    public final TextView tvEndDiamond;
    public final TextView tvEndTimeText;
    public final TextView tvScore;
    public final TextView tvStartDiamond;
    public final TextView tvStartTimeText;
    public final TextView tvTaskName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemRoomPersonalTaskListAdapterBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, View view2, LinearLayout linearLayout2, View view3, TextView textView2, ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout3, View view4, ProgressBar progressBar, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10) {
        super(obj, view, i);
        this.animDiamond = textView;
        this.centerDiamondContainer = linearLayout;
        this.centerDotView = view2;
        this.endDiamondContainer = linearLayout2;
        this.endDotView = view3;
        this.goBtn = textView2;
        this.itemContainer = constraintLayout;
        this.ivTaskIcon = imageView;
        this.startDiamondContainer = linearLayout3;
        this.startDotView = view4;
        this.taskProgress = progressBar;
        this.tvCenterDiamond = textView3;
        this.tvCenterTimeText = textView4;
        this.tvEndDiamond = textView5;
        this.tvEndTimeText = textView6;
        this.tvScore = textView7;
        this.tvStartDiamond = textView8;
        this.tvStartTimeText = textView9;
        this.tvTaskName = textView10;
    }

    public static ItemRoomPersonalTaskListAdapterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemRoomPersonalTaskListAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemRoomPersonalTaskListAdapterBinding bind(View view, Object obj) {
        return (ItemRoomPersonalTaskListAdapterBinding) ViewDataBinding.bind(obj, view, R.layout.item_room_personal_task_list_adapter);
    }

    @Deprecated
    public static ItemRoomPersonalTaskListAdapterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRoomPersonalTaskListAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_personal_task_list_adapter, viewGroup, z, obj);
    }

    public static ItemRoomPersonalTaskListAdapterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemRoomPersonalTaskListAdapterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRoomPersonalTaskListAdapterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_personal_task_list_adapter, (ViewGroup) null, false, obj);
    }
}

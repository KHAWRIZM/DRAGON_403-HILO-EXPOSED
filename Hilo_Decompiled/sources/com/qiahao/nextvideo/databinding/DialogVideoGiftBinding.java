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
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.GroupSendGiftLinearLayout;
import com.qiahao.nextvideo.ui.reusable.views.PageIndicator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogVideoGiftBinding extends ViewDataBinding {
    public final TextView diamondText;
    public final LinearLayout giftViewAll;
    public final PageIndicator pageIndicator;
    public final ImageView rechargeIcon;
    public final TextView rechargeText;
    public final RecyclerView recyclerView;
    public final ConstraintLayout rootBack;
    public final GroupSendGiftLinearLayout sendGiftLinearLayout;
    public final SuperStatusView statusView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogVideoGiftBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout, PageIndicator pageIndicator, ImageView imageView, TextView textView2, RecyclerView recyclerView, ConstraintLayout constraintLayout, GroupSendGiftLinearLayout groupSendGiftLinearLayout, SuperStatusView superStatusView) {
        super(obj, view, i);
        this.diamondText = textView;
        this.giftViewAll = linearLayout;
        this.pageIndicator = pageIndicator;
        this.rechargeIcon = imageView;
        this.rechargeText = textView2;
        this.recyclerView = recyclerView;
        this.rootBack = constraintLayout;
        this.sendGiftLinearLayout = groupSendGiftLinearLayout;
        this.statusView = superStatusView;
    }

    public static DialogVideoGiftBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogVideoGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogVideoGiftBinding bind(View view, Object obj) {
        return (DialogVideoGiftBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_video_gift);
    }

    @Deprecated
    public static DialogVideoGiftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogVideoGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_video_gift, viewGroup, z, obj);
    }

    public static DialogVideoGiftBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogVideoGiftBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogVideoGiftBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_video_gift, (ViewGroup) null, false, obj);
    }
}

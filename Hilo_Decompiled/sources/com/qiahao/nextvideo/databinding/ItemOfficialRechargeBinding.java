package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemOfficialRechargeBinding extends ViewDataBinding {
    public final ImageView chatView;
    public final TextView countryName;
    public final ImageView countryPic;
    protected View.OnClickListener mClick;
    public final ImageView sex;
    public final CircleImageView userAvatar;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemOfficialRechargeBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, ImageView imageView3, CircleImageView circleImageView, TextView textView2) {
        super(obj, view, i);
        this.chatView = imageView;
        this.countryName = textView;
        this.countryPic = imageView2;
        this.sex = imageView3;
        this.userAvatar = circleImageView;
        this.userName = textView2;
    }

    public static ItemOfficialRechargeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemOfficialRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ItemOfficialRechargeBinding bind(View view, Object obj) {
        return (ItemOfficialRechargeBinding) ViewDataBinding.bind(obj, view, R.layout.item_official_recharge);
    }

    @Deprecated
    public static ItemOfficialRechargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemOfficialRechargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_official_recharge, viewGroup, z, obj);
    }

    public static ItemOfficialRechargeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemOfficialRechargeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemOfficialRechargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_official_recharge, (ViewGroup) null, false, obj);
    }
}

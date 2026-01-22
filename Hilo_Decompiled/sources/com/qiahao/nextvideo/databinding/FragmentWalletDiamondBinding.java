package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentWalletDiamondBinding extends ViewDataBinding {
    public final LinearLayout chargeAgent;
    public final AppCompatTextView contactUsTextView;
    public final DiamondTickTextView diamondCountTickTextView;
    public final TextView purchaseVip;
    public final LinearLayout rechargeAgent;
    public final RecyclerView recyclerView;
    public final LinearLayoutCompat rootContainer;
    public final TextView vipContent;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentWalletDiamondBinding(Object obj, View view, int i, LinearLayout linearLayout, AppCompatTextView appCompatTextView, DiamondTickTextView diamondTickTextView, TextView textView, LinearLayout linearLayout2, RecyclerView recyclerView, LinearLayoutCompat linearLayoutCompat, TextView textView2) {
        super(obj, view, i);
        this.chargeAgent = linearLayout;
        this.contactUsTextView = appCompatTextView;
        this.diamondCountTickTextView = diamondTickTextView;
        this.purchaseVip = textView;
        this.rechargeAgent = linearLayout2;
        this.recyclerView = recyclerView;
        this.rootContainer = linearLayoutCompat;
        this.vipContent = textView2;
    }

    public static FragmentWalletDiamondBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentWalletDiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentWalletDiamondBinding bind(View view, Object obj) {
        return (FragmentWalletDiamondBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_wallet_diamond);
    }

    @Deprecated
    public static FragmentWalletDiamondBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWalletDiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_wallet_diamond, viewGroup, z, obj);
    }

    public static FragmentWalletDiamondBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentWalletDiamondBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWalletDiamondBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_wallet_diamond, (ViewGroup) null, false, obj);
    }
}

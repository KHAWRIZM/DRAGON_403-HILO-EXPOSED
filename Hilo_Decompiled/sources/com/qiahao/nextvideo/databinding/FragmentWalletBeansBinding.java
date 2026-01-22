package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentWalletBeansBinding extends ViewDataBinding {
    public final DiamondTickTextView beansCountTickTextView;
    public final TextView exchangeDiamonds;
    public final ImageView image;
    protected View.OnClickListener mClick;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentWalletBeansBinding(Object obj, View view, int i, DiamondTickTextView diamondTickTextView, TextView textView, ImageView imageView) {
        super(obj, view, i);
        this.beansCountTickTextView = diamondTickTextView;
        this.exchangeDiamonds = textView;
        this.image = imageView;
    }

    public static FragmentWalletBeansBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentWalletBeansBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static FragmentWalletBeansBinding bind(View view, Object obj) {
        return (FragmentWalletBeansBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_wallet_beans);
    }

    @Deprecated
    public static FragmentWalletBeansBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentWalletBeansBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_wallet_beans, viewGroup, z, obj);
    }

    public static FragmentWalletBeansBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentWalletBeansBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentWalletBeansBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_wallet_beans, (ViewGroup) null, false, obj);
    }
}

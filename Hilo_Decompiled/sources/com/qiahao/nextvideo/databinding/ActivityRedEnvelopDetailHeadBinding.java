package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityRedEnvelopDetailHeadBinding extends ViewDataBinding {
    public final HiloImageView headAvatar;
    public final TextView tvClaimed;
    public final TextView tvToBeClaimed;
    public final TextView tvUserNameAndId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityRedEnvelopDetailHeadBinding(Object obj, View view, int i, HiloImageView hiloImageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.headAvatar = hiloImageView;
        this.tvClaimed = textView;
        this.tvToBeClaimed = textView2;
        this.tvUserNameAndId = textView3;
    }

    public static ActivityRedEnvelopDetailHeadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityRedEnvelopDetailHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityRedEnvelopDetailHeadBinding bind(View view, Object obj) {
        return (ActivityRedEnvelopDetailHeadBinding) ViewDataBinding.bind(obj, view, R.layout.activity_red_envelop_detail_head);
    }

    @Deprecated
    public static ActivityRedEnvelopDetailHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityRedEnvelopDetailHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_red_envelop_detail_head, viewGroup, z, obj);
    }

    public static ActivityRedEnvelopDetailHeadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityRedEnvelopDetailHeadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityRedEnvelopDetailHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_red_envelop_detail_head, (ViewGroup) null, false, obj);
    }
}

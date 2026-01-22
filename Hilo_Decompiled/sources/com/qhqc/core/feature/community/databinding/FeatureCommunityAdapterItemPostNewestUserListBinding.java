package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qhqc.core.feature.community.R;
import com.ruffian.library.widget.RImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class FeatureCommunityAdapterItemPostNewestUserListBinding extends ViewDataBinding {
    public final View head;
    public final RImageView mIvAvatar;
    public final TextView name;

    /* JADX INFO: Access modifiers changed from: protected */
    public FeatureCommunityAdapterItemPostNewestUserListBinding(Object obj, View view, int i10, View view2, RImageView rImageView, TextView textView) {
        super(obj, view, i10);
        this.head = view2;
        this.mIvAvatar = rImageView;
        this.name = textView;
    }

    public static FeatureCommunityAdapterItemPostNewestUserListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FeatureCommunityAdapterItemPostNewestUserListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static FeatureCommunityAdapterItemPostNewestUserListBinding bind(View view, Object obj) {
        return (FeatureCommunityAdapterItemPostNewestUserListBinding) ViewDataBinding.bind(obj, view, R.layout.feature_community_adapter_item_post_newest_user_list);
    }

    @Deprecated
    public static FeatureCommunityAdapterItemPostNewestUserListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (FeatureCommunityAdapterItemPostNewestUserListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.feature_community_adapter_item_post_newest_user_list, viewGroup, z10, obj);
    }

    public static FeatureCommunityAdapterItemPostNewestUserListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FeatureCommunityAdapterItemPostNewestUserListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FeatureCommunityAdapterItemPostNewestUserListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.feature_community_adapter_item_post_newest_user_list, null, false, obj);
    }
}

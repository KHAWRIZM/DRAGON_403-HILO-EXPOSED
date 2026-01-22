package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogShareInviteFriendsBinding extends ViewDataBinding {
    protected View.OnClickListener mClick;
    public final LinearLayout shareContacts;
    public final LinearLayout shareCopyLink;
    public final LinearLayout shareWhatApps;
    public final TextView textView2;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogShareInviteFriendsBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView) {
        super(obj, view, i);
        this.shareContacts = linearLayout;
        this.shareCopyLink = linearLayout2;
        this.shareWhatApps = linearLayout3;
        this.textView2 = textView;
    }

    public static DialogShareInviteFriendsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogShareInviteFriendsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogShareInviteFriendsBinding bind(View view, Object obj) {
        return (DialogShareInviteFriendsBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_share_invite_friends);
    }

    @Deprecated
    public static DialogShareInviteFriendsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogShareInviteFriendsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_share_invite_friends, viewGroup, z, obj);
    }

    public static DialogShareInviteFriendsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogShareInviteFriendsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogShareInviteFriendsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_share_invite_friends, (ViewGroup) null, false, obj);
    }
}

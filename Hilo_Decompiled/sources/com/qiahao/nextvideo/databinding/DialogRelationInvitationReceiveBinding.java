package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRelationInvitationReceiveBinding extends ViewDataBinding {
    public final TextView agree;
    public final HiloImageView avatar;
    public final ImageView bg;
    public final TextView content;

    /* renamed from: id, reason: collision with root package name */
    public final TextView f٥٥id;
    public final NickTextView nickName;
    public final TextView refuse;
    public final TextView title;
    public final TextView topBanner;
    public final ImageView topLove;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRelationInvitationReceiveBinding(Object obj, View view, int i, TextView textView, HiloImageView hiloImageView, ImageView imageView, TextView textView2, TextView textView3, NickTextView nickTextView, TextView textView4, TextView textView5, TextView textView6, ImageView imageView2) {
        super(obj, view, i);
        this.agree = textView;
        this.avatar = hiloImageView;
        this.bg = imageView;
        this.content = textView2;
        this.f٥٥id = textView3;
        this.nickName = nickTextView;
        this.refuse = textView4;
        this.title = textView5;
        this.topBanner = textView6;
        this.topLove = imageView2;
    }

    public static DialogRelationInvitationReceiveBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRelationInvitationReceiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRelationInvitationReceiveBinding bind(View view, Object obj) {
        return (DialogRelationInvitationReceiveBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_relation_invitation_receive);
    }

    @Deprecated
    public static DialogRelationInvitationReceiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRelationInvitationReceiveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_relation_invitation_receive, viewGroup, z, obj);
    }

    public static DialogRelationInvitationReceiveBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRelationInvitationReceiveBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRelationInvitationReceiveBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_relation_invitation_receive, (ViewGroup) null, false, obj);
    }
}

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
public abstract class DialogCpInvitationSendBinding extends ViewDataBinding {
    public final HiloImageView avatar;
    public final ImageView bg;
    public final TextView buttonText;
    public final TextView content;

    /* renamed from: id, reason: collision with root package name */
    public final TextView f٥٣id;
    public final NickTextView nickName;
    public final TextView sendButton;
    public final TextView title;
    public final TextView topBanner;
    public final ImageView topLove;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogCpInvitationSendBinding(Object obj, View view, int i, HiloImageView hiloImageView, ImageView imageView, TextView textView, TextView textView2, TextView textView3, NickTextView nickTextView, TextView textView4, TextView textView5, TextView textView6, ImageView imageView2) {
        super(obj, view, i);
        this.avatar = hiloImageView;
        this.bg = imageView;
        this.buttonText = textView;
        this.content = textView2;
        this.f٥٣id = textView3;
        this.nickName = nickTextView;
        this.sendButton = textView4;
        this.title = textView5;
        this.topBanner = textView6;
        this.topLove = imageView2;
    }

    public static DialogCpInvitationSendBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogCpInvitationSendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogCpInvitationSendBinding bind(View view, Object obj) {
        return (DialogCpInvitationSendBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_cp_invitation_send);
    }

    @Deprecated
    public static DialogCpInvitationSendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogCpInvitationSendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_invitation_send, viewGroup, z, obj);
    }

    public static DialogCpInvitationSendBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogCpInvitationSendBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogCpInvitationSendBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_cp_invitation_send, (ViewGroup) null, false, obj);
    }
}

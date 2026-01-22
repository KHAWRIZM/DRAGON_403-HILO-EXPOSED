package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellConversationBinding extends ViewDataBinding {
    public final ImageView hiloInformOrHelp;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final AppCompatTextView lastMessageTextView;
    public final View line;
    public final AppCompatTextView messageInDateTextView;
    public final AppCompatTextView nicknameTextView;
    public final View onlineStatus;
    public final AppCompatButton unreadMessageCountTextView;
    public final QMUIRadiusImageView userAvatarCimageView;
    public final AppCompatImageView videoCallImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellConversationBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, AppCompatTextView appCompatTextView, View view2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view3, AppCompatButton appCompatButton, QMUIRadiusImageView qMUIRadiusImageView, AppCompatImageView appCompatImageView) {
        super(obj, view, i);
        this.hiloInformOrHelp = imageView;
        this.iconNoble = imageView2;
        this.iconVip = imageView3;
        this.lastMessageTextView = appCompatTextView;
        this.line = view2;
        this.messageInDateTextView = appCompatTextView2;
        this.nicknameTextView = appCompatTextView3;
        this.onlineStatus = view3;
        this.unreadMessageCountTextView = appCompatButton;
        this.userAvatarCimageView = qMUIRadiusImageView;
        this.videoCallImageView = appCompatImageView;
    }

    public static CellConversationBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellConversationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellConversationBinding bind(View view, Object obj) {
        return (CellConversationBinding) ViewDataBinding.bind(obj, view, R.layout.cell_conversation);
    }

    @Deprecated
    public static CellConversationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellConversationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_conversation, viewGroup, z, obj);
    }

    public static CellConversationBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellConversationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellConversationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_conversation, (ViewGroup) null, false, obj);
    }
}

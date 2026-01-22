package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityChatDialogBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final View bar;
    public final HiloChatView chatView;
    public final AppCompatImageView endImage;
    public final FrameLayout frameLayout;
    public final LinearLayoutCompat linearLayout;
    public final TextView newUser;
    public final LightQueueCombinationPlayer queuePlayer;
    public final ImageView svipType;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityChatDialogBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, View view2, HiloChatView hiloChatView, AppCompatImageView appCompatImageView2, FrameLayout frameLayout, LinearLayoutCompat linearLayoutCompat, TextView textView, LightQueueCombinationPlayer lightQueueCombinationPlayer, ImageView imageView, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.chatView = hiloChatView;
        this.endImage = appCompatImageView2;
        this.frameLayout = frameLayout;
        this.linearLayout = linearLayoutCompat;
        this.newUser = textView;
        this.queuePlayer = lightQueueCombinationPlayer;
        this.svipType = imageView;
        this.title = appCompatTextView;
    }

    public static ActivityChatDialogBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityChatDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityChatDialogBinding bind(View view, Object obj) {
        return (ActivityChatDialogBinding) ViewDataBinding.bind(obj, view, R.layout.activity_chat_dialog);
    }

    @Deprecated
    public static ActivityChatDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityChatDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat_dialog, viewGroup, z, obj);
    }

    public static ActivityChatDialogBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityChatDialogBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityChatDialogBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat_dialog, (ViewGroup) null, false, obj);
    }
}

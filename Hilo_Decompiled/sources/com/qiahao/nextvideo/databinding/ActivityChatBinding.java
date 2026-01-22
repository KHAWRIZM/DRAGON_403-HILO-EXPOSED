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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityChatBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final HiloChatView chatView;
    public final ConstraintLayout constraint;
    public final AppCompatImageView endImage;
    public final LinearLayoutCompat linearLayout;
    public final TextView newUser;
    public final LightQueueCombinationPlayer queuePlayer;
    public final ImageView svipType;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityChatBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, HiloChatView hiloChatView, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView2, LinearLayoutCompat linearLayoutCompat, TextView textView, LightQueueCombinationPlayer lightQueueCombinationPlayer, ImageView imageView, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.chatView = hiloChatView;
        this.constraint = constraintLayout;
        this.endImage = appCompatImageView2;
        this.linearLayout = linearLayoutCompat;
        this.newUser = textView;
        this.queuePlayer = lightQueueCombinationPlayer;
        this.svipType = imageView;
        this.title = appCompatTextView;
    }

    public static ActivityChatBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityChatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityChatBinding bind(View view, Object obj) {
        return (ActivityChatBinding) ViewDataBinding.bind(obj, view, R.layout.activity_chat);
    }

    @Deprecated
    public static ActivityChatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat, viewGroup, z, obj);
    }

    public static ActivityChatBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityChatBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat, (ViewGroup) null, false, obj);
    }
}

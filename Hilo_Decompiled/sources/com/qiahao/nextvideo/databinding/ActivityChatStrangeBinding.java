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
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuicore.component.RoundCornerImageView;
import com.tencent.qcloud.tuikit.tuichat.hilo.HiloChatStrangeView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityChatStrangeBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final RoundCornerImageView bg;
    public final HiloChatStrangeView chatView;
    public final AppCompatImageView closeImage;
    public final ConstraintLayout constraint;
    public final AppCompatImageView endImage;
    public final LinearLayoutCompat linearLayout;
    public final TextView newUser;
    public final LightQueueCombinationPlayer queuePlayer;
    public final AppCompatImageView reportImage;
    public final Group strangeTitleGroup;
    public final ImageView svipType;
    public final AppCompatTextView time;
    public final AppCompatTextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityChatStrangeBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, RoundCornerImageView roundCornerImageView, HiloChatStrangeView hiloChatStrangeView, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat, TextView textView, LightQueueCombinationPlayer lightQueueCombinationPlayer, AppCompatImageView appCompatImageView4, Group group, ImageView imageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.bg = roundCornerImageView;
        this.chatView = hiloChatStrangeView;
        this.closeImage = appCompatImageView2;
        this.constraint = constraintLayout;
        this.endImage = appCompatImageView3;
        this.linearLayout = linearLayoutCompat;
        this.newUser = textView;
        this.queuePlayer = lightQueueCombinationPlayer;
        this.reportImage = appCompatImageView4;
        this.strangeTitleGroup = group;
        this.svipType = imageView;
        this.time = appCompatTextView;
        this.title = appCompatTextView2;
    }

    public static ActivityChatStrangeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityChatStrangeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityChatStrangeBinding bind(View view, Object obj) {
        return (ActivityChatStrangeBinding) ViewDataBinding.bind(obj, view, R.layout.activity_chat_strange);
    }

    @Deprecated
    public static ActivityChatStrangeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityChatStrangeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat_strange, viewGroup, z, obj);
    }

    public static ActivityChatStrangeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityChatStrangeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityChatStrangeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_chat_strange, (ViewGroup) null, false, obj);
    }
}

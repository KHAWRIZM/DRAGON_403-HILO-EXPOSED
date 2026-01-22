package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityGiftEffectBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final ImageView addImage;
    public final View backGround;
    public final ImageView close;
    public final TextView diamond;
    public final ImageView giftEffect;
    public final View giftEffectBg;
    public final TextView giftEffectText;
    public final TextView instructionTitle1;
    public final TextView instructionTitle1One;
    public final TextView instructionTitle2;
    public final TextView instructionTitle2One;
    public final TextView instructionTitle3;
    public final TextView instructionTitle3One;
    public final TextView instructionTitle4;
    public final TextView instructionTitle4One;
    public final View line;
    public final TextView preview;
    public final LightQueueCombinationPlayer queuePlayer;
    public final NestedScrollView scrollView;
    public final Group selectGroup;
    public final TextView submit;
    public final IncludeTitleBinding title;
    public final TextView userId;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGiftEffectBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, View view2, ImageView imageView2, TextView textView, ImageView imageView3, View view3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view4, TextView textView11, LightQueueCombinationPlayer lightQueueCombinationPlayer, NestedScrollView nestedScrollView, Group group, TextView textView12, IncludeTitleBinding includeTitleBinding, TextView textView13) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.addImage = imageView;
        this.backGround = view2;
        this.close = imageView2;
        this.diamond = textView;
        this.giftEffect = imageView3;
        this.giftEffectBg = view3;
        this.giftEffectText = textView2;
        this.instructionTitle1 = textView3;
        this.instructionTitle1One = textView4;
        this.instructionTitle2 = textView5;
        this.instructionTitle2One = textView6;
        this.instructionTitle3 = textView7;
        this.instructionTitle3One = textView8;
        this.instructionTitle4 = textView9;
        this.instructionTitle4One = textView10;
        this.line = view4;
        this.preview = textView11;
        this.queuePlayer = lightQueueCombinationPlayer;
        this.scrollView = nestedScrollView;
        this.selectGroup = group;
        this.submit = textView12;
        this.title = includeTitleBinding;
        this.userId = textView13;
    }

    public static ActivityGiftEffectBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityGiftEffectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityGiftEffectBinding bind(View view, Object obj) {
        return (ActivityGiftEffectBinding) ViewDataBinding.bind(obj, view, R.layout.activity_gift_effect);
    }

    @Deprecated
    public static ActivityGiftEffectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGiftEffectBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_gift_effect, viewGroup, z, obj);
    }

    public static ActivityGiftEffectBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityGiftEffectBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGiftEffectBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_gift_effect, (ViewGroup) null, false, obj);
    }
}

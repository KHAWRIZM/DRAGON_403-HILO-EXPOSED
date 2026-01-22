package com.tencent.qcloud.tuikit.tuichat.classicui.component;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.SoftKeyBoardUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class BeginnerGuidePage {
    private OnFinishListener onFinishListener;
    private PopupWindow popupWindow;
    private int[] resIDs;
    private ViewPager2 viewPager;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class GuideAdapter extends RecyclerView.Adapter<GuideViewHolder> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class GuideViewHolder extends RecyclerView.ViewHolder {
            private final ImageView image;

            public GuideViewHolder(View view) {
                super(view);
                this.image = (ImageView) view.findViewById(R.id.center_image);
            }
        }

        GuideAdapter() {
        }

        public int getItemCount() {
            if (BeginnerGuidePage.this.resIDs == null) {
                return 0;
            }
            return BeginnerGuidePage.this.resIDs.length;
        }

        public void onBindViewHolder(final GuideViewHolder guideViewHolder, int i) {
            ViewGroup.LayoutParams layoutParams = guideViewHolder.image.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = ScreenUtil.getScreenWidth(guideViewHolder.image.getContext());
                layoutParams.height = ScreenUtil.getScreenHeight(guideViewHolder.image.getContext());
                guideViewHolder.image.setLayoutParams(layoutParams);
            }
            GlideEngine.loadImage(guideViewHolder.image, Integer.valueOf(BeginnerGuidePage.this.resIDs[i]));
            ((RecyclerView.ViewHolder) guideViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.component.BeginnerGuidePage.GuideAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (BeginnerGuidePage.this.viewPager != null) {
                        int bindingAdapterPosition = guideViewHolder.getBindingAdapterPosition();
                        if (bindingAdapterPosition < GuideAdapter.this.getItemCount() - 1) {
                            BeginnerGuidePage.this.viewPager.setCurrentItem(bindingAdapterPosition + 1, true);
                            return;
                        }
                        if (BeginnerGuidePage.this.onFinishListener != null) {
                            BeginnerGuidePage.this.onFinishListener.onFinish();
                        }
                        if (BeginnerGuidePage.this.popupWindow != null && BeginnerGuidePage.this.popupWindow.isShowing()) {
                            BeginnerGuidePage.this.popupWindow.dismiss();
                        }
                    }
                }
            });
        }

        public GuideViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new GuideViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_beginner_guide_item, viewGroup, false));
        }
    }

    @FunctionalInterface
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnFinishListener {
        void onFinish();
    }

    public BeginnerGuidePage(final Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_beginner_guide, (ViewGroup) null);
        this.viewPager = inflate.findViewById(R.id.view_pager);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true) { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.component.BeginnerGuidePage.1
            @Override // android.widget.PopupWindow
            public void dismiss() {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    BeginnerGuidePage.this.startAnimation(activity.getWindow(), false);
                }
                super.dismiss();
            }

            @Override // android.widget.PopupWindow
            public void showAtLocation(View view, int i, int i2, int i3) {
                Activity activity2 = activity;
                if (activity2 != null && !activity2.isFinishing()) {
                    BeginnerGuidePage.this.startAnimation(activity.getWindow(), true);
                }
                super.showAtLocation(view, i, i2, i3);
            }
        };
        this.popupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        this.popupWindow.setTouchable(true);
        this.popupWindow.setOutsideTouchable(false);
        this.popupWindow.setAnimationStyle(R.style.BeginnerGuidePopupAnimation);
        this.viewPager.setUserInputEnabled(false);
        this.viewPager.setAdapter(new GuideAdapter());
    }

    public static void showBeginnerGuideThen(View view, final Runnable runnable) {
        if (SPUtils.getInstance(TUIChatConstants.CHAT_SETTINGS_SP_NAME).getBoolean(TUIChatConstants.CHAT_REPLY_GUIDE_SHOW_SP_KEY, true)) {
            SoftKeyBoardUtil.hideKeyBoard(view.getWindowToken());
            SPUtils.getInstance(TUIChatConstants.CHAT_SETTINGS_SP_NAME).put(TUIChatConstants.CHAT_REPLY_GUIDE_SHOW_SP_KEY, false);
            BeginnerGuidePage beginnerGuidePage = new BeginnerGuidePage((Activity) view.getContext());
            beginnerGuidePage.setPagesResIDs(R.drawable.chat_reply_guide, R.drawable.chat_quote_guide);
            beginnerGuidePage.setOnFinishListener(new OnFinishListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.component.BeginnerGuidePage.3
                @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.BeginnerGuidePage.OnFinishListener
                public void onFinish() {
                    runnable.run();
                }
            });
            beginnerGuidePage.show(view, 0);
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation(final Window window, boolean z) {
        ValueAnimator ofFloat;
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        if (z) {
            ofFloat = ValueAnimator.ofFloat(1.0f, 0.5f);
        } else {
            ofFloat = ValueAnimator.ofFloat(0.5f, 1.0f);
        }
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.component.BeginnerGuidePage.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                window.setAttributes(attributes);
            }
        });
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(linearInterpolator);
        ofFloat.start();
    }

    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.onFinishListener = onFinishListener;
    }

    public void setPagesResIDs(int... iArr) {
        this.resIDs = iArr;
        this.viewPager.setOffscreenPageLimit(iArr.length);
        this.viewPager.getAdapter().notifyDataSetChanged();
        this.viewPager.setCurrentItem(0, false);
    }

    public void show(View view, int i) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.showAtLocation(view, i, 0, 0);
        }
    }
}

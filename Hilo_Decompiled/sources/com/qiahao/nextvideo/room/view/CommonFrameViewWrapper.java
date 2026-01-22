package com.qiahao.nextvideo.room.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.databinding.CommonFrameViewWrapperBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\nB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\rJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020!J\b\u0010$\u001a\u00020!H\u0002J\u0006\u0010%\u001a\u00020!J\u0006\u0010,\u001a\u00020!J\u0006\u0010-\u001a\u00020!J\u0012\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0018\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020\f2\u0006\u0010/\u001a\u000200H\u0016R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00063"}, d2 = {"Lcom/qiahao/nextvideo/room/view/CommonFrameViewWrapper;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "outParent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroid/view/ViewGroup;)V", "i", "", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/view/ViewGroup;)V", "mContext", "mParent", "getMParent", "()Landroid/view/ViewGroup;", "setMParent", "(Landroid/view/ViewGroup;)V", "mCommonFrameViewWrapperBinding", "Lcom/qiahao/nextvideo/databinding/CommonFrameViewWrapperBinding;", "getMCommonFrameViewWrapperBinding", "()Lcom/qiahao/nextvideo/databinding/CommonFrameViewWrapperBinding;", "setMCommonFrameViewWrapperBinding", "(Lcom/qiahao/nextvideo/databinding/CommonFrameViewWrapperBinding;)V", "mCommonFrameViewWrapperListener", "Lcom/qiahao/nextvideo/room/view/CommonFrameViewWrapperListener;", "getMCommonFrameViewWrapperListener", "()Lcom/qiahao/nextvideo/room/view/CommonFrameViewWrapperListener;", "setMCommonFrameViewWrapperListener", "(Lcom/qiahao/nextvideo/room/view/CommonFrameViewWrapperListener;)V", "setCommonFrameViewWrapperListener", "", "commonFrameViewWrapperListener", "initView", "initStyle", "showView", "hasHide", "", "getHasHide", "()Z", "setHasHide", "(Z)V", "hideView", "addContractFragment", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "onKeyUp", "keyCode", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonFrameViewWrapper extends FrameLayout {
    private boolean hasHide;
    public CommonFrameViewWrapperBinding mCommonFrameViewWrapperBinding;

    @Nullable
    private CommonFrameViewWrapperListener mCommonFrameViewWrapperListener;

    @NotNull
    private Context mContext;
    public ViewGroup mParent;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonFrameViewWrapper(@NotNull Context context, @NotNull ViewGroup viewGroup) {
        this(context, null, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "outParent");
    }

    private final void initStyle() {
        ConstraintLayout.b layoutParams = getMCommonFrameViewWrapperBinding().rootView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        ((ViewGroup.MarginLayoutParams) bVar).width = dimens.getScreenWidth();
        ((ViewGroup.MarginLayoutParams) bVar).height = (dimens.getScreenHeight() / 5) * 4;
        getMCommonFrameViewWrapperBinding().rootView.setLayoutParams(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(View view) {
    }

    public final void addContractFragment() {
        if (getContext() != null) {
            BaseActivity context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.qiahao.nextvideo.app.base.HiloBaseActivity");
            BaseActivity baseActivity = (HiloBaseActivity) context;
            if (!baseActivity.isFinishing()) {
                baseActivity.isDestroyed();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@Nullable KeyEvent event) {
        if (event != null && event.getKeyCode() == 4) {
            hideView();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    public final boolean getHasHide() {
        return this.hasHide;
    }

    @NotNull
    public final CommonFrameViewWrapperBinding getMCommonFrameViewWrapperBinding() {
        CommonFrameViewWrapperBinding commonFrameViewWrapperBinding = this.mCommonFrameViewWrapperBinding;
        if (commonFrameViewWrapperBinding != null) {
            return commonFrameViewWrapperBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCommonFrameViewWrapperBinding");
        return null;
    }

    @Nullable
    public final CommonFrameViewWrapperListener getMCommonFrameViewWrapperListener() {
        return this.mCommonFrameViewWrapperListener;
    }

    @NotNull
    public final ViewGroup getMParent() {
        ViewGroup viewGroup = this.mParent;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mParent");
        return null;
    }

    public final void hideView() {
        if (this.hasHide) {
            return;
        }
        this.hasHide = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_bottom_out);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.qiahao.nextvideo.room.view.CommonFrameViewWrapper$hideView$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (CommonFrameViewWrapper.this.getContext() != null) {
                    BaseActivity context = CommonFrameViewWrapper.this.getContext();
                    Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.qiahao.nextvideo.app.base.HiloBaseActivity");
                    BaseActivity baseActivity = (HiloBaseActivity) context;
                    if (baseActivity.isFinishing() || baseActivity.isDestroyed()) {
                        return;
                    }
                }
                CommonFrameViewWrapper.this.getMParent().removeView(CommonFrameViewWrapper.this);
                CommonFrameViewWrapperListener mCommonFrameViewWrapperListener = CommonFrameViewWrapper.this.getMCommonFrameViewWrapperListener();
                if (mCommonFrameViewWrapperListener != null) {
                    mCommonFrameViewWrapperListener.hide();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        startAnimation(loadAnimation);
    }

    public final void initView() {
        setMCommonFrameViewWrapperBinding(CommonFrameViewWrapperBinding.inflate(LayoutInflater.from(this.mContext), this, true));
        initStyle();
        getMCommonFrameViewWrapperBinding().rootBack.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonFrameViewWrapper.this.hideView();
            }
        });
        getMCommonFrameViewWrapperBinding().rootView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonFrameViewWrapper.initView$lambda$1(view);
            }
        });
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, @NotNull KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if ((keyCode == 4 || keyCode == 111) && event.isTracking() && !event.isCanceled()) {
            hideView();
            return true;
        }
        return false;
    }

    public final void setCommonFrameViewWrapperListener(@NotNull CommonFrameViewWrapperListener commonFrameViewWrapperListener) {
        Intrinsics.checkNotNullParameter(commonFrameViewWrapperListener, "commonFrameViewWrapperListener");
        this.mCommonFrameViewWrapperListener = commonFrameViewWrapperListener;
    }

    public final void setHasHide(boolean z) {
        this.hasHide = z;
    }

    public final void setMCommonFrameViewWrapperBinding(@NotNull CommonFrameViewWrapperBinding commonFrameViewWrapperBinding) {
        Intrinsics.checkNotNullParameter(commonFrameViewWrapperBinding, "<set-?>");
        this.mCommonFrameViewWrapperBinding = commonFrameViewWrapperBinding;
    }

    public final void setMCommonFrameViewWrapperListener(@Nullable CommonFrameViewWrapperListener commonFrameViewWrapperListener) {
        this.mCommonFrameViewWrapperListener = commonFrameViewWrapperListener;
    }

    public final void setMParent(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.mParent = viewGroup;
    }

    public final void showView() {
        getMParent().addView(this);
        setAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_bottom_in));
        getAnimation().startNow();
        requestFocus();
        addContractFragment();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonFrameViewWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet, @NotNull ViewGroup viewGroup) {
        this(context, attributeSet, 0, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "outParent");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonFrameViewWrapper(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, @NotNull ViewGroup viewGroup) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "outParent");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.mContext = context2;
        setMParent(viewGroup);
        initView();
    }
}

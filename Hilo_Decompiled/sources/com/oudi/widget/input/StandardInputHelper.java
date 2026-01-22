package com.oudi.widget.input;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.RequiresApi;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.utils.KeyboardHelper;
import com.oudi.utils.log.ILog;
import com.oudi.widget.input.InputContext;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(message = "等有空优化后在使用，目前不够灵活，且没测试过。")
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001:\u00019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u001dJ\u001c\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\u001d2\b\u0010%\u001a\u0004\u0018\u00010\u001dH\u0003J\u000e\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u001aJ\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0013H\u0017J\b\u0010*\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0013H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010\u001d2\u0006\u0010-\u001a\u00020\u0013H\u0002J\u0006\u0010.\u001a\u00020\u0013J\u0010\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u001aH\u0003J\b\u00101\u001a\u00020 H\u0003J\u0006\u00102\u001a\u00020\u0017J\u0016\u00103\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\u0017H\u0007J\b\u00106\u001a\u00020 H\u0003J\b\u00107\u001a\u00020\u0017H\u0007J\b\u00108\u001a\u00020 H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001d0\u001cj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001d`\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/oudi/widget/input/StandardInputHelper;", "Lcom/oudi/widget/input/InputContext;", "context", "Landroid/content/Context;", "inputBar", "Lcom/oudi/widget/input/InputBar;", "<init>", "(Landroid/content/Context;Lcom/oudi/widget/input/InputBar;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/oudi/widget/input/StandardInputHelper$Listener;", "placeholderPanel", "Landroid/view/View;", "keyboardPanel", "Lcom/oudi/widget/input/KeyboardPanel;", "getKeyboardPanel", "()Lcom/oudi/widget/input/KeyboardPanel;", "keyboardPanel$delegate", "Lkotlin/Lazy;", "currentPanelType", "", "keyboardHelper", "Lcom/oudi/utils/KeyboardHelper;", "inputEnabled", "", "hasNavigationBar", "navigationBarHeight", "", "panels", "Ljava/util/HashMap;", "Lcom/oudi/widget/input/InputPanel;", "Lkotlin/collections/HashMap;", "setListener", "", "registerPanel", "inputPanel", "handlerPanelAnimator", "newPanel", "oldPanel", "setPanelHeight", "value", "switchPanel", "type", "getInputBar", "updateCurrentPanel", "getInputPanel", "panelType", "getCurrentPanelType", "onKeyboardOpened", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onKeyboardClose", "isInputEnabled", "updateNavigationBarState", "setInputEnabled", "isEnabled", "initKeyboardHelper", "onBackPressedIntercept", "onCleared", "Listener", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStandardInputHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StandardInputHelper.kt\ncom/oudi/widget/input/StandardInputHelper\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,412:1\n216#2,2:413\n*S KotlinDebug\n*F\n+ 1 StandardInputHelper.kt\ncom/oudi/widget/input/StandardInputHelper\n*L\n401#1:413,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class StandardInputHelper implements InputContext {

    @Nullable
    private Context context;

    @NotNull
    private String currentPanelType;
    private boolean hasNavigationBar;

    @Nullable
    private InputBar inputBar;
    private boolean inputEnabled;

    @Nullable
    private KeyboardHelper keyboardHelper;

    /* renamed from: keyboardPanel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy keyboardPanel;

    @Nullable
    private Listener listener;
    private int navigationBarHeight;

    @NotNull
    private HashMap<String, InputPanel> panels;

    @Nullable
    private View placeholderPanel;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/oudi/widget/input/StandardInputHelper$Listener;", "", "onPanelChanged", "", "panelType", "", "onContentChanged", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface Listener {
        void onContentChanged(int height);

        void onPanelChanged(@NotNull String panelType);
    }

    public StandardInputHelper(@NotNull final Context context, @NotNull InputBar inputBar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputBar, "inputBar");
        this.keyboardPanel = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.input.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KeyboardPanel keyboardPanel_delegate$lambda$0;
                keyboardPanel_delegate$lambda$0 = StandardInputHelper.keyboardPanel_delegate$lambda$0(context);
                return keyboardPanel_delegate$lambda$0;
            }
        });
        this.currentPanelType = "none";
        this.inputEnabled = true;
        this.panels = new HashMap<>();
        this.context = context;
        this.inputBar = inputBar;
    }

    private final InputPanel getInputPanel(String panelType) {
        return this.panels.get(panelType);
    }

    private final KeyboardPanel getKeyboardPanel() {
        return (KeyboardPanel) this.keyboardPanel.getValue();
    }

    @RequiresApi(11)
    private final void handlerPanelAnimator(final InputPanel newPanel, final InputPanel oldPanel) {
        int i10;
        int i11;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        ObjectAnimator objectAnimator3;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.oudi.widget.input.StandardInputHelper$handlerPanelAnimator$animator$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                View contentView;
                Intrinsics.checkNotNullParameter(animation, "animation");
                InputPanel inputPanel = oldPanel;
                if (inputPanel != null && (contentView = inputPanel.getContentView()) != null) {
                    contentView.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                View contentView;
                Intrinsics.checkNotNullParameter(animation, "animation");
                InputPanel inputPanel = InputPanel.this;
                if (inputPanel != null && (contentView = inputPanel.getContentView()) != null) {
                    contentView.setVisibility(0);
                }
            }
        });
        if (oldPanel != null) {
            i10 = oldPanel.getPanelHeight();
        } else {
            i10 = 0;
        }
        float f10 = i10 * (-1.0f);
        if (newPanel != null) {
            i11 = newPanel.getPanelHeight();
        } else {
            i11 = 0;
        }
        float f11 = i11 * (-1.0f);
        if (newPanel instanceof KeyboardPanel) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "panelHeight", ((int) f10) * (-1), ((int) f11) * (-1));
        Intrinsics.checkNotNullExpressionValue(ofInt, "ofInt(...)");
        ObjectAnimator objectAnimator4 = null;
        if (newPanel != null) {
            objectAnimator = ObjectAnimator.ofFloat(newPanel.getContentView(), "translationY", f10, f11);
        } else {
            objectAnimator = null;
        }
        if (newPanel != null) {
            objectAnimator2 = ObjectAnimator.ofFloat(newPanel.getContentView(), "alpha", DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        } else {
            objectAnimator2 = null;
        }
        if (oldPanel != null) {
            objectAnimator3 = ObjectAnimator.ofFloat(oldPanel.getContentView(), "translationY", f10, f11);
        } else {
            objectAnimator3 = null;
        }
        if (oldPanel != null) {
            objectAnimator4 = ObjectAnimator.ofFloat(oldPanel.getContentView(), "alpha", 1.0f, DownloadProgress.UNKNOWN_PROGRESS);
        }
        AnimatorSet.Builder play = animatorSet.play(ofInt);
        if (objectAnimator != null) {
            play.with(objectAnimator);
        }
        if (objectAnimator3 != null) {
            play.with(objectAnimator3);
        }
        if (objectAnimator4 != null) {
            play.with(objectAnimator4);
        }
        if (objectAnimator2 != null) {
            play.with(objectAnimator2);
        }
        animatorSet.start();
    }

    @RequiresApi(11)
    private final void initKeyboardHelper() {
        if (this.keyboardHelper != null || !getInputEnabled()) {
            return;
        }
        KeyboardHelper keyboardHelper = new KeyboardHelper(getInputBar().getContentView(), this.hasNavigationBar, this.navigationBarHeight);
        keyboardHelper.registerKeyboardChangedListener(new KeyboardHelper.OnKeyboardChangedListener() { // from class: com.oudi.widget.input.StandardInputHelper$initKeyboardHelper$1$1
            @Override // com.oudi.utils.KeyboardHelper.OnKeyboardChangedListener
            public void onChanged(boolean isPopup, int keyboardHeight) {
                if (isPopup) {
                    StandardInputHelper.this.onKeyboardOpened(keyboardHeight);
                } else {
                    StandardInputHelper.this.onKeyboardClose();
                }
            }
        });
        this.keyboardHelper = keyboardHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeyboardPanel keyboardPanel_delegate$lambda$0(Context context) {
        return new KeyboardPanel(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(11)
    public final void onKeyboardClose() {
        ILog.DefaultImpls.logD$default(this, "onKeyboardClose()", null, false, 6, null);
        if (Intrinsics.areEqual(this.currentPanelType, "key_board")) {
            handlerPanelAnimator(null, getInputPanel(this.currentPanelType));
            updateCurrentPanel("none");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(11)
    public final void onKeyboardOpened(int height) {
        ILog.DefaultImpls.logD$default(this, "onKeyboardOpened() height:" + height, null, false, 6, null);
        if (!getInputEnabled()) {
            return;
        }
        getKeyboardPanel().setHeight(0);
        handlerPanelAnimator(getKeyboardPanel(), getInputPanel(this.currentPanelType));
        updateCurrentPanel("key_board");
        Listener listener = this.listener;
        if (listener != null) {
            listener.onContentChanged(height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void switchPanel$lambda$7(StandardInputHelper standardInputHelper, InputPanel inputPanel, InputPanel inputPanel2, String str) {
        standardInputHelper.handlerPanelAnimator(inputPanel, inputPanel2);
        standardInputHelper.updateCurrentPanel(str);
    }

    private final void updateCurrentPanel(String type) {
        ILog.DefaultImpls.logD$default(this, "updateCurrentPanel() type:" + type, null, false, 6, null);
        InputPanel inputPanel = getInputPanel(this.currentPanelType);
        if (inputPanel != null) {
            inputPanel.onVisibleChanged(false);
        }
        InputPanel inputPanel2 = getInputPanel(type);
        if (inputPanel2 != null) {
            inputPanel2.onVisibleChanged(true);
        }
        this.currentPanelType = type;
        getInputBar().onPanelChanged(this.currentPanelType);
        Listener listener = this.listener;
        if (listener != null) {
            listener.onPanelChanged(this.currentPanelType);
        }
    }

    @NotNull
    public final String getCurrentPanelType() {
        return this.currentPanelType;
    }

    @Override // com.oudi.widget.input.InputContext
    @NotNull
    public InputBar getInputBar() {
        InputBar inputBar = this.inputBar;
        Intrinsics.checkNotNull(inputBar);
        return inputBar;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return InputContext.DefaultImpls.getLogTag(this);
    }

    /* renamed from: isInputEnabled, reason: from getter */
    public final boolean getInputEnabled() {
        return this.inputEnabled;
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        InputContext.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        InputContext.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        InputContext.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        InputContext.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        InputContext.DefaultImpls.logW(this, str, str2, z10);
    }

    @RequiresApi(11)
    public final boolean onBackPressedIntercept() {
        if (!Intrinsics.areEqual(getCurrentPanelType(), "none")) {
            switchPanel("none");
            return true;
        }
        return false;
    }

    @Override // com.oudi.utils.ICleared
    public void onCleared() {
        InputContext.DefaultImpls.onCleared(this);
        this.listener = null;
        KeyboardHelper keyboardHelper = this.keyboardHelper;
        if (keyboardHelper != null) {
            keyboardHelper.onCleared();
        }
        this.keyboardHelper = null;
        InputBar inputBar = this.inputBar;
        if (inputBar != null) {
            inputBar.onCleared();
        }
        this.inputBar = null;
        Iterator<Map.Entry<String, InputPanel>> it = this.panels.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onCleared();
        }
        this.panels.clear();
        this.context = null;
    }

    @Override // com.oudi.widget.input.InputContext
    public void onReset() {
        InputContext.DefaultImpls.onReset(this);
    }

    public final void registerPanel(@NotNull InputPanel inputPanel) {
        Intrinsics.checkNotNullParameter(inputPanel, "inputPanel");
        this.panels.put(inputPanel.getPanelType(), inputPanel);
        inputPanel.onAttachInputLayout(this);
    }

    @RequiresApi(11)
    public final void setInputEnabled(boolean isEnabled) {
        int i10;
        if (!Intrinsics.areEqual(this.currentPanelType, "none")) {
            switchPanel("none");
        }
        View contentView = getInputBar().getContentView();
        if (isEnabled) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        contentView.setVisibility(i10);
        this.inputEnabled = isEnabled;
    }

    public final void setListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void setPanelHeight(int value) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.placeholderPanel;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.height = value;
        }
        View view2 = this.placeholderPanel;
        if (view2 != null) {
            view2.requestLayout();
        }
        Listener listener = this.listener;
        if (listener != null) {
            listener.onContentChanged(value);
        }
    }

    @Override // com.oudi.widget.input.InputContext
    @RequiresApi(11)
    public void switchPanel(@NotNull final String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        ILog.DefaultImpls.logD$default(this, "switchPanel() type:" + type, null, false, 6, null);
        if (!getInputEnabled() || Intrinsics.areEqual(this.currentPanelType, type)) {
            return;
        }
        if (Intrinsics.areEqual(type, "key_board")) {
            getInputBar().showSoftInput();
            return;
        }
        final InputPanel inputPanel = getInputPanel(this.currentPanelType);
        final InputPanel inputPanel2 = getInputPanel(type);
        if (inputPanel instanceof KeyboardPanel) {
            this.currentPanelType = type;
            getInputBar().closeSoftInput();
            ((KeyboardPanel) inputPanel).getContentView().postDelayed(new Runnable() { // from class: com.oudi.widget.input.d
                @Override // java.lang.Runnable
                public final void run() {
                    StandardInputHelper.switchPanel$lambda$7(StandardInputHelper.this, inputPanel2, inputPanel, type);
                }
            }, 50L);
        } else {
            handlerPanelAnimator(inputPanel2, inputPanel);
            updateCurrentPanel(type);
        }
    }

    public final void updateNavigationBarState(boolean hasNavigationBar, int navigationBarHeight) {
        this.hasNavigationBar = hasNavigationBar;
        this.navigationBarHeight = navigationBarHeight;
        KeyboardHelper keyboardHelper = this.keyboardHelper;
        if (keyboardHelper != null) {
            keyboardHelper.updateNavigationBarState(hasNavigationBar, navigationBarHeight);
        }
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        InputContext.DefaultImpls.logE(this, str, th, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        InputContext.DefaultImpls.logE(this, th, str, z10);
    }
}

package com.oudi.widget.input;

import android.content.Context;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.widget.input.InputPanel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/oudi/widget/input/KeyboardPanel;", "Lcom/oudi/widget/input/InputPanel;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "getHeight", "()I", "setHeight", "(I)V", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view$delegate", "Lkotlin/Lazy;", "getContentView", "getPanelType", "", "onAttachInputLayout", "", "inputLayout", "Lcom/oudi/widget/input/InputContext;", "onVisibleChanged", "isVisibleToUser", "", "getPanelHeight", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class KeyboardPanel implements InputPanel {
    private int height;

    /* renamed from: view$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy view;

    public KeyboardPanel(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.view = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.input.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                View view_delegate$lambda$0;
                view_delegate$lambda$0 = KeyboardPanel.view_delegate$lambda$0(context);
                return view_delegate$lambda$0;
            }
        });
    }

    private final View getView() {
        return (View) this.view.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View view_delegate$lambda$0(Context context) {
        return new View(context);
    }

    @Override // com.oudi.widget.input.InputPanel
    @NotNull
    public View getContentView() {
        return getView();
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return InputPanel.DefaultImpls.getLogTag(this);
    }

    @Override // com.oudi.widget.input.InputPanel
    public int getPanelHeight() {
        return this.height;
    }

    @Override // com.oudi.widget.input.InputPanel
    @NotNull
    public String getPanelType() {
        return "key_board";
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        InputPanel.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        InputPanel.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        InputPanel.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        InputPanel.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        InputPanel.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.oudi.widget.input.InputPanel
    public void onAttachInputLayout(@NotNull InputContext inputLayout) {
        Intrinsics.checkNotNullParameter(inputLayout, "inputLayout");
    }

    @Override // com.oudi.utils.ICleared
    public void onCleared() {
        InputPanel.DefaultImpls.onCleared(this);
    }

    @Override // com.oudi.widget.input.InputPanel
    public void onVisibleChanged(boolean isVisibleToUser) {
    }

    public final void setHeight(int i10) {
        this.height = i10;
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        InputPanel.DefaultImpls.logE(this, str, th, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        InputPanel.DefaultImpls.logE(this, th, str, z10);
    }
}

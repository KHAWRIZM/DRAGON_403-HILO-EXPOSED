package com.oudi.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.oudi.utils.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0002R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/oudi/widget/TailTextLayout;", "Landroid/widget/FrameLayout;", "Lcom/oudi/utils/log/ILog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentView", "Landroid/widget/TextView;", "getContentView", "()Landroid/widget/TextView;", "tailView", "Landroid/view/View;", "getTailView", "()Landroid/view/View;", "textWatcher", "Landroid/text/TextWatcher;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "handler", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TailTextLayout extends FrameLayout implements ILog {

    @Nullable
    private TextWatcher textWatcher;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailTextLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00bf, code lost:
    
        r3.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c2, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handler() {
        try {
            TextView contentView = getContentView();
            if (contentView == null) {
                ILog.DefaultImpls.logE$default((ILog) this, "没有有效的内容视图", (String) null, false, 6, (Object) null);
                View tailView = getTailView();
                if (tailView != null) {
                    tailView.setVisibility(8);
                    return;
                }
                return;
            }
            CharSequence text = contentView.getText();
            if (Intrinsics.areEqual(contentView.getTag(), text.toString())) {
                ILog.DefaultImpls.logD$default(this, "文本内容无变化", null, false, 6, null);
                return;
            }
            View tailView2 = getTailView();
            int maxLines = contentView.getMaxLines();
            int lineCount = contentView.getLineCount();
            if (tailView2 != null) {
                Intrinsics.checkNotNull(text);
                if (text.length() != 0 && maxLines != 0 && lineCount > maxLines) {
                    int i10 = maxLines - 1;
                    int lineStart = contentView.getLayout().getLineStart(i10);
                    int lineEnd = contentView.getLayout().getLineEnd(i10);
                    CharSequence subSequence = contentView.getText().subSequence(0, lineStart);
                    CharSequence ellipsize = TextUtils.ellipsize(contentView.getText().subSequence(lineStart, lineEnd), contentView.getPaint(), ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - tailView2.getMeasuredWidth(), TextUtils.TruncateAt.END);
                    Intrinsics.checkNotNullExpressionValue(ellipsize, "ellipsize(...)");
                    SpannableStringBuilder append = new SpannableStringBuilder(subSequence).append(ellipsize);
                    contentView.setTag(append.toString());
                    contentView.setText(append);
                    contentView.requestLayout();
                    tailView2.setVisibility(0);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            ILog.DefaultImpls.logE$default((ILog) this, "handler() e:" + e10, (String) null, false, 6, (Object) null);
        }
    }

    @Nullable
    public final TextView getContentView() {
        View childAt = getChildAt(0);
        if (childAt instanceof TextView) {
            return (TextView) childAt;
        }
        return null;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Nullable
    public final View getTailView() {
        return getChildAt(1);
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        if (getContentView() != null && this.textWatcher == null) {
            handler();
            this.textWatcher = new TextWatcher() { // from class: com.oudi.widget.TailTextLayout$onSizeChanged$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s10) {
                    TailTextLayout.this.handler();
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s10, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s10, int start, int before, int count) {
                }
            };
            TextView contentView = getContentView();
            if (contentView != null) {
                contentView.addTextChangedListener(this.textWatcher);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TailTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailTextLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }
}

package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f١٥٤٩a;

    /* renamed from: b, reason: collision with root package name */
    private final x2.f f١٥٥٠b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(TextView textView) {
        this.f١٥٤٩a = textView;
        this.f١٥٥٠b = new x2.f(textView, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f١٥٥٠b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f١٥٥٠b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f١٥٤٩a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i10, 0);
        try {
            int i11 = R.styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z10 = true;
            if (obtainStyledAttributes.hasValue(i11)) {
                z10 = obtainStyledAttributes.getBoolean(i11, true);
            }
            obtainStyledAttributes.recycle();
            e(z10);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(boolean z10) {
        this.f١٥٥٠b.c(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(boolean z10) {
        this.f١٥٥٠b.d(z10);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f١٥٥٠b.e(transformationMethod);
    }
}

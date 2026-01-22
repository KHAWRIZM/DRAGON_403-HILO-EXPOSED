package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class q {

    /* renamed from: a, reason: collision with root package name */
    private TextView f١٦٢٧a;

    /* renamed from: b, reason: collision with root package name */
    private TextClassifier f١٦٢٨b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class a {
        static TextClassifier a(TextView textView) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            return TextClassifier.NO_OP;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TextView textView) {
        this.f١٦٢٧a = (TextView) androidx.core.util.h.g(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f١٦٢٨b;
        if (textClassifier == null) {
            return a.a(this.f١٦٢٧a);
        }
        return textClassifier;
    }

    public void b(TextClassifier textClassifier) {
        this.f١٦٢٨b = textClassifier;
    }
}

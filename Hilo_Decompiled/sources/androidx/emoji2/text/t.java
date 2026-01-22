package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class t implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٣٦٨٥a = false;

    /* renamed from: b, reason: collision with root package name */
    private Spannable f٣٦٨٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a {
        static IntStream a(CharSequence charSequence) {
            IntStream chars;
            chars = charSequence.chars();
            return chars;
        }

        static IntStream b(CharSequence charSequence) {
            IntStream codePoints;
            codePoints = charSequence.codePoints();
            return codePoints;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {
        b() {
        }

        boolean a(CharSequence charSequence) {
            return charSequence instanceof l2.n;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends b {
        c() {
        }

        @Override // androidx.emoji2.text.t.b
        boolean a(CharSequence charSequence) {
            if (!u.a(charSequence) && !(charSequence instanceof l2.n)) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Spannable spannable) {
        this.f٣٦٨٦b = spannable;
    }

    private void a() {
        Spannable spannable = this.f٣٦٨٦b;
        if (!this.f٣٦٨٥a && c().a(spannable)) {
            this.f٣٦٨٦b = new SpannableString(spannable);
        }
        this.f٣٦٨٥a = true;
    }

    static b c() {
        if (Build.VERSION.SDK_INT < 28) {
            return new b();
        }
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Spannable b() {
        return this.f٣٦٨٦b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i10) {
        return this.f٣٦٨٦b.charAt(i10);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return a.a(this.f٣٦٨٦b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return a.b(this.f٣٦٨٦b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f٣٦٨٦b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f٣٦٨٦b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f٣٦٨٦b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i10, int i11, Class cls) {
        return this.f٣٦٨٦b.getSpans(i10, i11, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f٣٦٨٦b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f٣٦٨٦b.nextSpanTransition(i10, i11, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f٣٦٨٦b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f٣٦٨٦b.setSpan(obj, i10, i11, i12);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i10, int i11) {
        return this.f٣٦٨٦b.subSequence(i10, i11);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f٣٦٨٦b.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(CharSequence charSequence) {
        this.f٣٦٨٦b = new SpannableString(charSequence);
    }
}

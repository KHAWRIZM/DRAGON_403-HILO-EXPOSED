package l2;

import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class n implements Spannable {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final TextPaint f١٥٧٠٩a;

        /* renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f١٥٧١٠b;

        /* renamed from: c, reason: collision with root package name */
        private final int f١٥٧١١c;

        /* renamed from: d, reason: collision with root package name */
        private final int f١٥٧١٢d;

        /* renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f١٥٧١٣e;

        /* renamed from: l2.n$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public static class C٠١٨٥a {

            /* renamed from: a, reason: collision with root package name */
            private final TextPaint f١٥٧١٤a;

            /* renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f١٥٧١٥b;

            /* renamed from: c, reason: collision with root package name */
            private int f١٥٧١٦c;

            /* renamed from: d, reason: collision with root package name */
            private int f١٥٧١٧d;

            public C٠١٨٥a(TextPaint textPaint) {
                this.f١٥٧١٤a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f١٥٧١٦c = 1;
                    this.f١٥٧١٧d = 1;
                } else {
                    this.f١٥٧١٧d = 0;
                    this.f١٥٧١٦c = 0;
                }
                this.f١٥٧١٥b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public a a() {
                return new a(this.f١٥٧١٤a, this.f١٥٧١٥b, this.f١٥٧١٦c, this.f١٥٧١٧d);
            }

            public C٠١٨٥a b(int i10) {
                this.f١٥٧١٦c = i10;
                return this;
            }

            public C٠١٨٥a c(int i10) {
                this.f١٥٧١٧d = i10;
                return this;
            }

            public C٠١٨٥a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f١٥٧١٥b = textDirectionHeuristic;
                return this;
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
            PrecomputedText.Params.Builder breakStrategy;
            PrecomputedText.Params.Builder hyphenationFrequency;
            PrecomputedText.Params.Builder textDirection;
            PrecomputedText.Params build;
            if (Build.VERSION.SDK_INT >= 29) {
                breakStrategy = d.a(textPaint).setBreakStrategy(i10);
                hyphenationFrequency = breakStrategy.setHyphenationFrequency(i11);
                textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
                build = textDirection.build();
                this.f١٥٧١٣e = build;
            } else {
                this.f١٥٧١٣e = null;
            }
            this.f١٥٧٠٩a = textPaint;
            this.f١٥٧١٠b = textDirectionHeuristic;
            this.f١٥٧١١c = i10;
            this.f١٥٧١٢d = i11;
        }

        public boolean a(a aVar) {
            LocaleList textLocales;
            LocaleList textLocales2;
            boolean equals;
            int i10 = Build.VERSION.SDK_INT;
            if ((i10 >= 23 && (this.f١٥٧١١c != aVar.b() || this.f١٥٧١٢d != aVar.c())) || this.f١٥٧٠٩a.getTextSize() != aVar.e().getTextSize() || this.f١٥٧٠٩a.getTextScaleX() != aVar.e().getTextScaleX() || this.f١٥٧٠٩a.getTextSkewX() != aVar.e().getTextSkewX() || this.f١٥٧٠٩a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f١٥٧٠٩a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) || this.f١٥٧٠٩a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i10 >= 24) {
                textLocales = this.f١٥٧٠٩a.getTextLocales();
                textLocales2 = aVar.e().getTextLocales();
                equals = textLocales.equals(textLocales2);
                if (!equals) {
                    return false;
                }
            } else if (!this.f١٥٧٠٩a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            if (this.f١٥٧٠٩a.getTypeface() == null) {
                if (aVar.e().getTypeface() != null) {
                    return false;
                }
                return true;
            }
            if (!this.f١٥٧٠٩a.getTypeface().equals(aVar.e().getTypeface())) {
                return false;
            }
            return true;
        }

        public int b() {
            return this.f١٥٧١١c;
        }

        public int c() {
            return this.f١٥٧١٢d;
        }

        public TextDirectionHeuristic d() {
            return this.f١٥٧١٠b;
        }

        public TextPaint e() {
            return this.f١٥٧٠٩a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (a(aVar) && this.f١٥٧١٠b == aVar.d()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            LocaleList textLocales;
            if (Build.VERSION.SDK_INT >= 24) {
                Float valueOf = Float.valueOf(this.f١٥٧٠٩a.getTextSize());
                Float valueOf2 = Float.valueOf(this.f١٥٧٠٩a.getTextScaleX());
                Float valueOf3 = Float.valueOf(this.f١٥٧٠٩a.getTextSkewX());
                Float valueOf4 = Float.valueOf(this.f١٥٧٠٩a.getLetterSpacing());
                Integer valueOf5 = Integer.valueOf(this.f١٥٧٠٩a.getFlags());
                textLocales = this.f١٥٧٠٩a.getTextLocales();
                return androidx.core.util.f.b(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, textLocales, this.f١٥٧٠٩a.getTypeface(), Boolean.valueOf(this.f١٥٧٠٩a.isElegantTextHeight()), this.f١٥٧١٠b, Integer.valueOf(this.f١٥٧١١c), Integer.valueOf(this.f١٥٧١٢d));
            }
            return androidx.core.util.f.b(Float.valueOf(this.f١٥٧٠٩a.getTextSize()), Float.valueOf(this.f١٥٧٠٩a.getTextScaleX()), Float.valueOf(this.f١٥٧٠٩a.getTextSkewX()), Float.valueOf(this.f١٥٧٠٩a.getLetterSpacing()), Integer.valueOf(this.f١٥٧٠٩a.getFlags()), this.f١٥٧٠٩a.getTextLocale(), this.f١٥٧٠٩a.getTypeface(), Boolean.valueOf(this.f١٥٧٠٩a.isElegantTextHeight()), this.f١٥٧١٠b, Integer.valueOf(this.f١٥٧١١c), Integer.valueOf(this.f١٥٧١٢d));
        }

        public String toString() {
            String fontVariationSettings;
            LocaleList textLocales;
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f١٥٧٠٩a.getTextSize());
            sb.append(", textScaleX=" + this.f١٥٧٠٩a.getTextScaleX());
            sb.append(", textSkewX=" + this.f١٥٧٠٩a.getTextSkewX());
            int i10 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.f١٥٧٠٩a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f١٥٧٠٩a.isElegantTextHeight());
            if (i10 >= 24) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(", textLocale=");
                textLocales = this.f١٥٧٠٩a.getTextLocales();
                sb2.append(textLocales);
                sb.append(sb2.toString());
            } else {
                sb.append(", textLocale=" + this.f١٥٧٠٩a.getTextLocale());
            }
            sb.append(", typeface=" + this.f١٥٧٠٩a.getTypeface());
            if (i10 >= 26) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(", variationSettings=");
                fontVariationSettings = this.f١٥٧٠٩a.getFontVariationSettings();
                sb3.append(fontVariationSettings);
                sb.append(sb3.toString());
            }
            sb.append(", textDir=" + this.f١٥٧١٠b);
            sb.append(", breakStrategy=" + this.f١٥٧١١c);
            sb.append(", hyphenationFrequency=" + this.f١٥٧١٢d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            TextPaint textPaint;
            TextDirectionHeuristic textDirection;
            int breakStrategy;
            int hyphenationFrequency;
            textPaint = params.getTextPaint();
            this.f١٥٧٠٩a = textPaint;
            textDirection = params.getTextDirection();
            this.f١٥٧١٠b = textDirection;
            breakStrategy = params.getBreakStrategy();
            this.f١٥٧١١c = breakStrategy;
            hyphenationFrequency = params.getHyphenationFrequency();
            this.f١٥٧١٢d = hyphenationFrequency;
            this.f١٥٧١٣e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}

package x2;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.f;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class g implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    private final EditText f١٨٨٨٨a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f١٨٨٨٩b;

    /* renamed from: c, reason: collision with root package name */
    private f.AbstractC٠٠٣٩f f١٨٨٩٠c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٨٨٩١d = Integer.MAX_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f١٨٨٩٢e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f١٨٨٩٣f = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a extends f.AbstractC٠٠٣٩f {

        /* renamed from: a, reason: collision with root package name */
        private final Reference f١٨٨٩٤a;

        a(EditText editText) {
            this.f١٨٨٩٤a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.f.AbstractC٠٠٣٩f
        public void b() {
            super.b();
            g.c((EditText) this.f١٨٨٩٤a.get(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditText editText, boolean z10) {
        this.f١٨٨٨٨a = editText;
        this.f١٨٨٨٩b = z10;
    }

    private f.AbstractC٠٠٣٩f a() {
        if (this.f١٨٨٩٠c == null) {
            this.f١٨٨٩٠c = new a(this.f١٨٨٨٨a);
        }
        return this.f١٨٨٩٠c;
    }

    static void c(EditText editText, int i10) {
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.f.c().p(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean e() {
        if (this.f١٨٨٩٣f && (this.f١٨٨٨٩b || androidx.emoji2.text.f.i())) {
            return false;
        }
        return true;
    }

    public boolean b() {
        return this.f١٨٨٩٣f;
    }

    public void d(boolean z10) {
        if (this.f١٨٨٩٣f != z10) {
            if (this.f١٨٨٩٠c != null) {
                androidx.emoji2.text.f.c().u(this.f١٨٨٩٠c);
            }
            this.f١٨٨٩٣f = z10;
            if (z10) {
                c(this.f١٨٨٨٨a, androidx.emoji2.text.f.c().e());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        if (!this.f١٨٨٨٨a.isInEditMode() && !e() && i11 <= i12 && (charSequence instanceof Spannable)) {
            int e10 = androidx.emoji2.text.f.c().e();
            if (e10 != 0) {
                if (e10 != 1) {
                    if (e10 != 3) {
                        return;
                    }
                } else {
                    androidx.emoji2.text.f.c().s((Spannable) charSequence, i10, i10 + i12, this.f١٨٨٩١d, this.f١٨٨٩٢e);
                    return;
                }
            }
            androidx.emoji2.text.f.c().t(a());
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}

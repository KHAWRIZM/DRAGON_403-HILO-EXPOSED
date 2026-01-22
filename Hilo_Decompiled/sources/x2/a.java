package x2;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f١٨٨٦٧a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٨٨٦٨b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private int f١٨٨٦٩c = 0;

    /* renamed from: x2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class C٠٢٤٣a extends b {

        /* renamed from: a, reason: collision with root package name */
        private final EditText f١٨٨٧٠a;

        /* renamed from: b, reason: collision with root package name */
        private final g f١٨٨٧١b;

        C٠٢٤٣a(EditText editText, boolean z10) {
            this.f١٨٨٧٠a = editText;
            g gVar = new g(editText, z10);
            this.f١٨٨٧١b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(x2.b.getInstance());
        }

        @Override // x2.a.b
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new e(keyListener);
        }

        @Override // x2.a.b
        boolean b() {
            return this.f١٨٨٧١b.b();
        }

        @Override // x2.a.b
        InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            if (inputConnection instanceof c) {
                return inputConnection;
            }
            return new c(this.f١٨٨٧٠a, inputConnection, editorInfo);
        }

        @Override // x2.a.b
        void d(boolean z10) {
            this.f١٨٨٧١b.d(z10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b {
        b() {
        }

        abstract KeyListener a(KeyListener keyListener);

        abstract boolean b();

        abstract InputConnection c(InputConnection inputConnection, EditorInfo editorInfo);

        abstract void d(boolean z10);
    }

    public a(EditText editText, boolean z10) {
        androidx.core.util.h.h(editText, "editText cannot be null");
        this.f١٨٨٦٧a = new C٠٢٤٣a(editText, z10);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f١٨٨٦٧a.a(keyListener);
    }

    public boolean b() {
        return this.f١٨٨٦٧a.b();
    }

    public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f١٨٨٦٧a.c(inputConnection, editorInfo);
    }

    public void d(boolean z10) {
        this.f١٨٨٦٧a.d(z10);
    }
}

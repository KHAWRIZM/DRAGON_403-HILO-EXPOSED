package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.d1;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.actions.SearchIntents;
import io.agora.rtc.Constants;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SearchView extends LinearLayoutCompat implements androidx.appcompat.view.c {
    static final o V;
    private boolean A;

    /* renamed from: B, reason: collision with root package name */
    private CharSequence f١٣٦٨B;
    private boolean C;
    private boolean D;
    private int E;
    private boolean F;
    private CharSequence G;
    private CharSequence H;
    private boolean I;
    private int J;
    SearchableInfo K;
    private Bundle L;
    private final Runnable M;
    private Runnable N;
    private final WeakHashMap O;
    private final View.OnClickListener P;
    View.OnKeyListener Q;
    private final TextView.OnEditorActionListener R;
    private final AdapterView.OnItemClickListener S;
    private final AdapterView.OnItemSelectedListener T;
    private TextWatcher U;

    /* renamed from: a, reason: collision with root package name */
    final SearchAutoComplete f١٣٦٩a;

    /* renamed from: b, reason: collision with root package name */
    private final View f١٣٧٠b;

    /* renamed from: c, reason: collision with root package name */
    private final View f١٣٧١c;

    /* renamed from: d, reason: collision with root package name */
    private final View f١٣٧٢d;

    /* renamed from: e, reason: collision with root package name */
    final ImageView f١٣٧٣e;

    /* renamed from: f, reason: collision with root package name */
    final ImageView f١٣٧٤f;

    /* renamed from: g, reason: collision with root package name */
    final ImageView f١٣٧٥g;

    /* renamed from: h, reason: collision with root package name */
    final ImageView f١٣٧٦h;

    /* renamed from: i, reason: collision with root package name */
    private final View f١٣٧٧i;

    /* renamed from: j, reason: collision with root package name */
    private p f١٣٧٨j;

    /* renamed from: k, reason: collision with root package name */
    private Rect f١٣٧٩k;

    /* renamed from: l, reason: collision with root package name */
    private Rect f١٣٨٠l;

    /* renamed from: m, reason: collision with root package name */
    private int[] f١٣٨١m;

    /* renamed from: n, reason: collision with root package name */
    private int[] f١٣٨٢n;

    /* renamed from: o, reason: collision with root package name */
    private final ImageView f١٣٨٣o;

    /* renamed from: p, reason: collision with root package name */
    private final Drawable f١٣٨٤p;

    /* renamed from: q, reason: collision with root package name */
    private final int f١٣٨٥q;

    /* renamed from: r, reason: collision with root package name */
    private final int f١٣٨٦r;

    /* renamed from: s, reason: collision with root package name */
    private final Intent f١٣٨٧s;

    /* renamed from: t, reason: collision with root package name */
    private final Intent f١٣٨٨t;

    /* renamed from: u, reason: collision with root package name */
    private final CharSequence f١٣٨٩u;

    /* renamed from: v, reason: collision with root package name */
    View.OnFocusChangeListener f١٣٩٠v;

    /* renamed from: w, reason: collision with root package name */
    private View.OnClickListener f١٣٩١w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f١٣٩٢x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f١٣٩٣y;

    /* renamed from: z, reason: collision with root package name */
    r2.a f١٣٩٤z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        boolean f١٣٩٥a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f١٣٩٥a + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Boolean.valueOf(this.f١٣٩٥a));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f١٣٩٥a = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: e, reason: collision with root package name */
        private int f١٣٩٦e;

        /* renamed from: f, reason: collision with root package name */
        private SearchView f١٣٩٧f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f١٣٩٨g;

        /* renamed from: h, reason: collision with root package name */
        final Runnable f١٣٩٩h;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i10 = configuration.screenWidthDp;
            int i11 = configuration.screenHeightDp;
            if (i10 >= 960 && i11 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i10 < 600) {
                if (i10 < 640 || i11 < 480) {
                    return Constants.ERR_ALREADY_IN_RECORDING;
                }
                return 192;
            }
            return 192;
        }

        void b() {
            if (Build.VERSION.SDK_INT >= 29) {
                k.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            SearchView.V.c(this);
        }

        boolean c() {
            if (TextUtils.getTrimmedLength(getText()) == 0) {
                return true;
            }
            return false;
        }

        void d() {
            if (this.f١٣٩٨g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f١٣٩٨g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            if (this.f١٣٩٦e > 0 && !super.enoughToFilter()) {
                return false;
            }
            return true;
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f١٣٩٨g) {
                removeCallbacks(this.f١٣٩٩h);
                post(this.f١٣٩٩h);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z10, int i10, Rect rect) {
            super.onFocusChanged(z10, i10, rect);
            this.f١٣٩٧f.H();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i10, KeyEvent keyEvent) {
            if (i10 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f١٣٩٧f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i10, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z10) {
            super.onWindowFocusChanged(z10);
            if (z10 && this.f١٣٩٧f.hasFocus() && getVisibility() == 0) {
                this.f١٣٩٨g = true;
                if (SearchView.u(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z10) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z10) {
                this.f١٣٩٨g = false;
                removeCallbacks(this.f١٣٩٩h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.f١٣٩٨g = false;
                    removeCallbacks(this.f١٣٩٩h);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.f١٣٩٨g = true;
            }
        }

        void setSearchView(SearchView searchView) {
            this.f١٣٩٧f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i10) {
            super.setThreshold(i10);
            this.f١٣٩٦e = i10;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.f١٣٩٩h = new a();
            this.f١٣٩٦e = getThreshold();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            SearchView.this.G(charSequence);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.N();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r2.a aVar = SearchView.this.f١٣٩٤z;
            if (aVar instanceof k0) {
                aVar.a(null);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f١٣٩٠v;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z10);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            SearchView.this.j();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f١٣٧٣e) {
                searchView.D();
                return;
            }
            if (view == searchView.f١٣٧٥g) {
                searchView.z();
                return;
            }
            if (view == searchView.f١٣٧٤f) {
                searchView.E();
            } else if (view == searchView.f١٣٧٦h) {
                searchView.I();
            } else if (view == searchView.f١٣٦٩a) {
                searchView.p();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.K == null) {
                return false;
            }
            if (searchView.f١٣٦٩a.isPopupShowing() && SearchView.this.f١٣٦٩a.getListSelection() != -1) {
                return SearchView.this.F(view, i10, keyEvent);
            }
            if (SearchView.this.f١٣٦٩a.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.x(0, null, searchView2.f١٣٦٩a.getText().toString());
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            SearchView.this.E();
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            SearchView.this.A(i10, 0, null);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i10, long j10) {
            SearchView.this.B(i10);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class k {
        static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        static void b(SearchAutoComplete searchAutoComplete, int i10) {
            searchAutoComplete.setInputMethodMode(i10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface l {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface m {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface n {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class o {

        /* renamed from: a, reason: collision with root package name */
        private Method f١٤١١a;

        /* renamed from: b, reason: collision with root package name */
        private Method f١٤١٢b;

        /* renamed from: c, reason: collision with root package name */
        private Method f١٤١٣c;

        o() {
            this.f١٤١١a = null;
            this.f١٤١٢b = null;
            this.f١٤١٣c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                this.f١٤١١a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                this.f١٤١٢b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f١٤١٣c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        private static void d() {
            if (Build.VERSION.SDK_INT < 29) {
            } else {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f١٤١٢b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f١٤١١a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f١٤١٣c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class p extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final View f١٤١٤a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f١٤١٥b;

        /* renamed from: c, reason: collision with root package name */
        private final Rect f١٤١٦c;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f١٤١٧d;

        /* renamed from: e, reason: collision with root package name */
        private final int f١٤١٨e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f١٤١٩f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f١٤١٨e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f١٤١٥b = new Rect();
            this.f١٤١٧d = new Rect();
            this.f١٤١٦c = new Rect();
            a(rect, rect2);
            this.f١٤١٤a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f١٤١٥b.set(rect);
            this.f١٤١٧d.set(rect);
            Rect rect3 = this.f١٤١٧d;
            int i10 = this.f١٤١٨e;
            rect3.inset(-i10, -i10);
            this.f١٤١٦c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z10;
            boolean z11;
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z12 = true;
            if (action != 0) {
                if (action != 1 && action != 2) {
                    if (action == 3) {
                        z11 = this.f١٤١٩f;
                        this.f١٤١٩f = false;
                    }
                    z10 = true;
                    z12 = false;
                } else {
                    z11 = this.f١٤١٩f;
                    if (z11 && !this.f١٤١٧d.contains(x10, y10)) {
                        z12 = z11;
                        z10 = false;
                    }
                }
                z12 = z11;
                z10 = true;
            } else {
                if (this.f١٤١٥b.contains(x10, y10)) {
                    this.f١٤١٩f = true;
                    z10 = true;
                }
                z10 = true;
                z12 = false;
            }
            if (!z12) {
                return false;
            }
            if (z10 && !this.f١٤١٦c.contains(x10, y10)) {
                motionEvent.setLocation(this.f١٤١٤a.getWidth() / 2, this.f١٤١٤a.getHeight() / 2);
            } else {
                Rect rect = this.f١٤١٦c;
                motionEvent.setLocation(x10 - rect.left, y10 - rect.top);
            }
            return this.f١٤١٤a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        o oVar;
        if (Build.VERSION.SDK_INT < 29) {
            oVar = new o();
        } else {
            oVar = null;
        }
        V = oVar;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private void J() {
        post(this.M);
    }

    private void K(int i10) {
        Editable text = this.f١٣٦٩a.getText();
        Cursor d10 = this.f١٣٩٤z.d();
        if (d10 == null) {
            return;
        }
        if (d10.moveToPosition(i10)) {
            CharSequence b10 = this.f١٣٩٤z.b(d10);
            if (b10 != null) {
                setQuery(b10);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    private void M() {
        boolean z10;
        int[] iArr;
        boolean isEmpty = TextUtils.isEmpty(this.f١٣٦٩a.getText());
        int i10 = 0;
        if (isEmpty && (!this.f١٣٩٢x || this.I)) {
            z10 = false;
        } else {
            z10 = true;
        }
        ImageView imageView = this.f١٣٧٥g;
        if (!z10) {
            i10 = 8;
        }
        imageView.setVisibility(i10);
        Drawable drawable = this.f١٣٧٥g.getDrawable();
        if (drawable != null) {
            if (!isEmpty) {
                iArr = ViewGroup.ENABLED_STATE_SET;
            } else {
                iArr = ViewGroup.EMPTY_STATE_SET;
            }
            drawable.setState(iArr);
        }
    }

    private void O() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f١٣٦٩a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(r(queryHint));
    }

    private void P() {
        this.f١٣٦٩a.setThreshold(this.K.getSuggestThreshold());
        this.f١٣٦٩a.setImeOptions(this.K.getImeOptions());
        int inputType = this.K.getInputType();
        int i10 = 1;
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.K.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f١٣٦٩a.setInputType(inputType);
        r2.a aVar = this.f١٣٩٤z;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.K.getSuggestAuthority() != null) {
            k0 k0Var = new k0(getContext(), this, this.K, this.O);
            this.f١٣٩٤z = k0Var;
            this.f١٣٦٩a.setAdapter(k0Var);
            k0 k0Var2 = (k0) this.f١٣٩٤z;
            if (this.C) {
                i10 = 2;
            }
            k0Var2.x(i10);
        }
    }

    private void Q() {
        int i10;
        if (v() && (this.f١٣٧٤f.getVisibility() == 0 || this.f١٣٧٦h.getVisibility() == 0)) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        this.f١٣٧٢d.setVisibility(i10);
    }

    private void R(boolean z10) {
        int i10;
        if (this.A && v() && hasFocus() && (z10 || !this.F)) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        this.f١٣٧٤f.setVisibility(i10);
    }

    private void S(boolean z10) {
        int i10;
        int i11;
        this.f١٣٩٣y = z10;
        int i12 = 8;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        boolean isEmpty = TextUtils.isEmpty(this.f١٣٦٩a.getText());
        this.f١٣٧٣e.setVisibility(i10);
        R(!isEmpty);
        View view = this.f١٣٧٠b;
        if (z10) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        view.setVisibility(i11);
        if (this.f١٣٨٣o.getDrawable() != null && !this.f١٣٩٢x) {
            i12 = 0;
        }
        this.f١٣٨٣o.setVisibility(i12);
        M();
        T(isEmpty);
        Q();
    }

    private void T(boolean z10) {
        int i10 = 8;
        if (this.F && !t() && z10) {
            this.f١٣٧٤f.setVisibility(8);
            i10 = 0;
        }
        this.f١٣٧٦h.setVisibility(i10);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private Intent k(String str, Uri uri, String str2, String str3, int i10, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.H);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.L;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i10 != 0) {
            intent.putExtra("action_key", i10);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.K.getSearchActivity());
        return intent;
    }

    private Intent l(Cursor cursor, int i10, String str) {
        int i11;
        Uri parse;
        String o10;
        try {
            String o11 = k0.o(cursor, "suggest_intent_action");
            if (o11 == null) {
                o11 = this.K.getSuggestIntentAction();
            }
            if (o11 == null) {
                o11 = "android.intent.action.SEARCH";
            }
            String str2 = o11;
            String o12 = k0.o(cursor, "suggest_intent_data");
            if (o12 == null) {
                o12 = this.K.getSuggestIntentData();
            }
            if (o12 != null && (o10 = k0.o(cursor, "suggest_intent_data_id")) != null) {
                o12 = o12 + "/" + Uri.encode(o10);
            }
            if (o12 == null) {
                parse = null;
            } else {
                parse = Uri.parse(o12);
            }
            return k(str2, parse, k0.o(cursor, "suggest_intent_extra_data"), k0.o(cursor, "suggest_intent_query"), i10, str);
        } catch (RuntimeException e10) {
            try {
                i11 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i11 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i11 + " returned exception.", e10);
            return null;
        }
    }

    private Intent m(Intent intent, SearchableInfo searchableInfo) {
        String str;
        String str2;
        String str3;
        int i10;
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.L;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        if (searchableInfo.getVoiceLanguageModeId() != 0) {
            str = resources.getString(searchableInfo.getVoiceLanguageModeId());
        } else {
            str = "free_form";
        }
        String str4 = null;
        if (searchableInfo.getVoicePromptTextId() != 0) {
            str2 = resources.getString(searchableInfo.getVoicePromptTextId());
        } else {
            str2 = null;
        }
        if (searchableInfo.getVoiceLanguageId() != 0) {
            str3 = resources.getString(searchableInfo.getVoiceLanguageId());
        } else {
            str3 = null;
        }
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i10 = searchableInfo.getVoiceMaxResults();
        } else {
            i10 = 1;
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", str);
        intent3.putExtra("android.speech.extra.PROMPT", str2);
        intent3.putExtra("android.speech.extra.LANGUAGE", str3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i10);
        if (searchActivity != null) {
            str4 = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str4);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent n(Intent intent, SearchableInfo searchableInfo) {
        String flattenToShortString;
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        if (searchActivity == null) {
            flattenToShortString = null;
        } else {
            flattenToShortString = searchActivity.flattenToShortString();
        }
        intent2.putExtra("calling_package", flattenToShortString);
        return intent2;
    }

    private void o() {
        this.f١٣٦٩a.dismissDropDown();
    }

    private void q(View view, Rect rect) {
        view.getLocationInWindow(this.f١٣٨١m);
        getLocationInWindow(this.f١٣٨٢n);
        int[] iArr = this.f١٣٨١m;
        int i10 = iArr[1];
        int[] iArr2 = this.f١٣٨٢n;
        int i11 = i10 - iArr2[1];
        int i12 = iArr[0] - iArr2[0];
        rect.set(i12, i11, view.getWidth() + i12, view.getHeight() + i11);
    }

    private CharSequence r(CharSequence charSequence) {
        if (this.f١٣٩٢x && this.f١٣٨٤p != null) {
            int textSize = (int) (this.f١٣٦٩a.getTextSize() * 1.25d);
            this.f١٣٨٤p.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.f١٣٨٤p), 1, 2, 33);
            spannableStringBuilder.append(charSequence);
            return spannableStringBuilder;
        }
        return charSequence;
    }

    private boolean s() {
        Intent intent;
        SearchableInfo searchableInfo = this.K;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        if (this.K.getVoiceSearchLaunchWebSearch()) {
            intent = this.f١٣٨٧s;
        } else if (this.K.getVoiceSearchLaunchRecognizer()) {
            intent = this.f١٣٨٨t;
        } else {
            intent = null;
        }
        if (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) {
            return false;
        }
        return true;
    }

    private void setQuery(CharSequence charSequence) {
        int length;
        this.f١٣٦٩a.setText(charSequence);
        SearchAutoComplete searchAutoComplete = this.f١٣٦٩a;
        if (TextUtils.isEmpty(charSequence)) {
            length = 0;
        } else {
            length = charSequence.length();
        }
        searchAutoComplete.setSelection(length);
    }

    static boolean u(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private boolean v() {
        if ((this.A || this.F) && !t()) {
            return true;
        }
        return false;
    }

    private void w(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e10) {
            Log.e("SearchView", "Failed launch activity: " + intent, e10);
        }
    }

    private boolean y(int i10, int i11, String str) {
        Cursor d10 = this.f١٣٩٤z.d();
        if (d10 != null && d10.moveToPosition(i10)) {
            w(l(d10, i11, str));
            return true;
        }
        return false;
    }

    boolean A(int i10, int i11, String str) {
        y(i10, 0, null);
        this.f١٣٦٩a.setImeVisibility(false);
        o();
        return true;
    }

    boolean B(int i10) {
        K(i10);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void D() {
        S(false);
        this.f١٣٦٩a.requestFocus();
        this.f١٣٦٩a.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f١٣٩١w;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void E() {
        Editable text = this.f١٣٦٩a.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.K != null) {
                x(0, null, text.toString());
            }
            this.f١٣٦٩a.setImeVisibility(false);
            o();
        }
    }

    boolean F(View view, int i10, KeyEvent keyEvent) {
        int length;
        if (this.K != null && this.f١٣٩٤z != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i10 != 66 && i10 != 84 && i10 != 61) {
                if (i10 != 21 && i10 != 22) {
                    if (i10 == 19) {
                        this.f١٣٦٩a.getListSelection();
                        return false;
                    }
                } else {
                    if (i10 == 21) {
                        length = 0;
                    } else {
                        length = this.f١٣٦٩a.length();
                    }
                    this.f١٣٦٩a.setSelection(length);
                    this.f١٣٦٩a.setListSelection(0);
                    this.f١٣٦٩a.clearListSelection();
                    this.f١٣٦٩a.b();
                    return true;
                }
            } else {
                return A(this.f١٣٦٩a.getListSelection(), 0, null);
            }
        }
        return false;
    }

    void G(CharSequence charSequence) {
        Editable text = this.f١٣٦٩a.getText();
        this.H = text;
        boolean isEmpty = TextUtils.isEmpty(text);
        R(!isEmpty);
        T(isEmpty);
        M();
        Q();
        this.G = charSequence.toString();
    }

    void H() {
        S(t());
        J();
        if (this.f١٣٦٩a.hasFocus()) {
            p();
        }
    }

    void I() {
        SearchableInfo searchableInfo = this.K;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(n(this.f١٣٨٧s, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(m(this.f١٣٨٨t, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public void L(CharSequence charSequence, boolean z10) {
        this.f١٣٦٩a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f١٣٦٩a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.H = charSequence;
        }
        if (z10 && !TextUtils.isEmpty(charSequence)) {
            E();
        }
    }

    void N() {
        int[] iArr;
        if (this.f١٣٦٩a.hasFocus()) {
            iArr = ViewGroup.FOCUSED_STATE_SET;
        } else {
            iArr = ViewGroup.EMPTY_STATE_SET;
        }
        Drawable background = this.f١٣٧١c.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f١٣٧٢d.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // androidx.appcompat.view.c
    public void a() {
        if (this.I) {
            return;
        }
        this.I = true;
        int imeOptions = this.f١٣٦٩a.getImeOptions();
        this.J = imeOptions;
        this.f١٣٦٩a.setImeOptions(imeOptions | 33554432);
        this.f١٣٦٩a.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.D = true;
        super.clearFocus();
        this.f١٣٦٩a.clearFocus();
        this.f١٣٦٩a.setImeVisibility(false);
        this.D = false;
    }

    @Override // androidx.appcompat.view.c
    public void d() {
        L("", false);
        clearFocus();
        S(true);
        this.f١٣٦٩a.setImeOptions(this.J);
        this.I = false;
    }

    public int getImeOptions() {
        return this.f١٣٦٩a.getImeOptions();
    }

    public int getInputType() {
        return this.f١٣٦٩a.getInputType();
    }

    public int getMaxWidth() {
        return this.E;
    }

    public CharSequence getQuery() {
        return this.f١٣٦٩a.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f١٣٦٨B;
        if (charSequence == null) {
            SearchableInfo searchableInfo = this.K;
            if (searchableInfo != null && searchableInfo.getHintId() != 0) {
                return getContext().getText(this.K.getHintId());
            }
            return this.f١٣٨٩u;
        }
        return charSequence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.f١٣٨٦r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.f١٣٨٥q;
    }

    public r2.a getSuggestionsAdapter() {
        return this.f١٣٩٤z;
    }

    void j() {
        int i10;
        int i11;
        if (this.f١٣٧٧i.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f١٣٧١c.getPaddingLeft();
            Rect rect = new Rect();
            boolean b10 = a1.b(this);
            if (this.f١٣٩٢x) {
                i10 = resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left);
            } else {
                i10 = 0;
            }
            this.f١٣٦٩a.getDropDownBackground().getPadding(rect);
            if (b10) {
                i11 = -rect.left;
            } else {
                i11 = paddingLeft - (rect.left + i10);
            }
            this.f١٣٦٩a.setDropDownHorizontalOffset(i11);
            this.f١٣٦٩a.setDropDownWidth((((this.f١٣٧٧i.getWidth() + rect.left) + rect.right) + i10) - paddingLeft);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.M);
        post(this.N);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            q(this.f١٣٦٩a, this.f١٣٧٩k);
            Rect rect = this.f١٣٨٠l;
            Rect rect2 = this.f١٣٧٩k;
            rect.set(rect2.left, 0, rect2.right, i13 - i11);
            p pVar = this.f١٣٧٨j;
            if (pVar == null) {
                p pVar2 = new p(this.f١٣٨٠l, this.f١٣٧٩k, this.f١٣٦٩a);
                this.f١٣٧٨j = pVar2;
                setTouchDelegate(pVar2);
                return;
            }
            pVar.a(this.f١٣٨٠l, this.f١٣٧٩k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        if (t()) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824 && (i12 = this.E) > 0) {
                    size = Math.min(i12, size);
                }
            } else {
                size = this.E;
                if (size <= 0) {
                    size = getPreferredWidth();
                }
            }
        } else {
            int i13 = this.E;
            size = i13 > 0 ? Math.min(i13, size) : Math.min(getPreferredWidth(), size);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                size2 = getPreferredHeight();
            }
        } else {
            size2 = Math.min(getPreferredHeight(), size2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        S(savedState.f١٣٩٥a);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f١٣٩٥a = t();
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        J();
    }

    void p() {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.f١٣٦٩a);
            return;
        }
        o oVar = V;
        oVar.b(this.f١٣٦٩a);
        oVar.a(this.f١٣٦٩a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i10, Rect rect) {
        if (this.D || !isFocusable()) {
            return false;
        }
        if (!t()) {
            boolean requestFocus = this.f١٣٦٩a.requestFocus(i10, rect);
            if (requestFocus) {
                S(false);
            }
            return requestFocus;
        }
        return super.requestFocus(i10, rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setAppSearchData(Bundle bundle) {
        this.L = bundle;
    }

    public void setIconified(boolean z10) {
        if (z10) {
            z();
        } else {
            D();
        }
    }

    public void setIconifiedByDefault(boolean z10) {
        if (this.f١٣٩٢x == z10) {
            return;
        }
        this.f١٣٩٢x = z10;
        S(z10);
        O();
    }

    public void setImeOptions(int i10) {
        this.f١٣٦٩a.setImeOptions(i10);
    }

    public void setInputType(int i10) {
        this.f١٣٦٩a.setInputType(i10);
    }

    public void setMaxWidth(int i10) {
        this.E = i10;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f١٣٩٠v = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f١٣٩١w = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f١٣٦٨B = charSequence;
        O();
    }

    public void setQueryRefinementEnabled(boolean z10) {
        int i10;
        this.C = z10;
        r2.a aVar = this.f١٣٩٤z;
        if (aVar instanceof k0) {
            k0 k0Var = (k0) aVar;
            if (z10) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            k0Var.x(i10);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.K = searchableInfo;
        if (searchableInfo != null) {
            P();
            O();
        }
        boolean s10 = s();
        this.F = s10;
        if (s10) {
            this.f١٣٦٩a.setPrivateImeOptions("nm");
        }
        S(t());
    }

    public void setSubmitButtonEnabled(boolean z10) {
        this.A = z10;
        S(t());
    }

    public void setSuggestionsAdapter(r2.a aVar) {
        this.f١٣٩٤z = aVar;
        this.f١٣٦٩a.setAdapter(aVar);
    }

    public boolean t() {
        return this.f١٣٩٣y;
    }

    void x(int i10, String str, String str2) {
        getContext().startActivity(k("android.intent.action.SEARCH", null, null, str2, i10, str));
    }

    void z() {
        if (TextUtils.isEmpty(this.f١٣٦٩a.getText())) {
            if (this.f١٣٩٢x) {
                clearFocus();
                S(true);
                return;
            }
            return;
        }
        this.f١٣٦٩a.setText("");
        this.f١٣٦٩a.requestFocus();
        this.f١٣٦٩a.setImeVisibility(true);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٧٩k = new Rect();
        this.f١٣٨٠l = new Rect();
        this.f١٣٨١m = new int[2];
        this.f١٣٨٢n = new int[2];
        this.M = new b();
        this.N = new c();
        this.O = new WeakHashMap();
        f fVar = new f();
        this.P = fVar;
        this.Q = new g();
        h hVar = new h();
        this.R = hVar;
        i iVar = new i();
        this.S = iVar;
        j jVar = new j();
        this.T = jVar;
        this.U = new a();
        int[] iArr = R.styleable.SearchView;
        p0 v10 = p0.v(context, attributeSet, iArr, i10, 0);
        d1.o0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        LayoutInflater.from(context).inflate(v10.n(R.styleable.SearchView_layout, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f١٣٦٩a = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f١٣٧٠b = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.f١٣٧١c = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.f١٣٧٢d = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f١٣٧٣e = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f١٣٧٤f = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f١٣٧٥g = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f١٣٧٦h = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.f١٣٨٣o = imageView5;
        d1.t0(findViewById, v10.g(R.styleable.SearchView_queryBackground));
        d1.t0(findViewById2, v10.g(R.styleable.SearchView_submitBackground));
        int i11 = R.styleable.SearchView_searchIcon;
        imageView.setImageDrawable(v10.g(i11));
        imageView2.setImageDrawable(v10.g(R.styleable.SearchView_goIcon));
        imageView3.setImageDrawable(v10.g(R.styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(v10.g(R.styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(v10.g(i11));
        this.f١٣٨٤p = v10.g(R.styleable.SearchView_searchHintIcon);
        u0.a(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.f١٣٨٥q = v10.n(R.styleable.SearchView_suggestionRowLayout, R.layout.abc_search_dropdown_item_icons_2line);
        this.f١٣٨٦r = v10.n(R.styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.U);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.Q);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(v10.a(R.styleable.SearchView_iconifiedByDefault, true));
        int f10 = v10.f(R.styleable.SearchView_android_maxWidth, -1);
        if (f10 != -1) {
            setMaxWidth(f10);
        }
        this.f١٣٨٩u = v10.p(R.styleable.SearchView_defaultQueryHint);
        this.f١٣٦٨B = v10.p(R.styleable.SearchView_queryHint);
        int k10 = v10.k(R.styleable.SearchView_android_imeOptions, -1);
        if (k10 != -1) {
            setImeOptions(k10);
        }
        int k11 = v10.k(R.styleable.SearchView_android_inputType, -1);
        if (k11 != -1) {
            setInputType(k11);
        }
        setFocusable(v10.a(R.styleable.SearchView_android_focusable, true));
        v10.x();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f١٣٨٧s = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f١٣٨٨t = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f١٣٧٧i = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        S(this.f١٣٩٢x);
        O();
    }
}

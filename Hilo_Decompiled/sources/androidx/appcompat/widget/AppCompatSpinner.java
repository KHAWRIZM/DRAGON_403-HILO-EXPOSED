package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AppCompatSpinner extends Spinner implements androidx.core.view.y0 {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f١٢٨٠i = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    private final androidx.appcompat.widget.c f١٢٨١a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f١٢٨٢b;

    /* renamed from: c, reason: collision with root package name */
    private e0 f١٢٨٣c;

    /* renamed from: d, reason: collision with root package name */
    private SpinnerAdapter f١٢٨٤d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f١٢٨٥e;

    /* renamed from: f, reason: collision with root package name */
    private g f١٢٨٦f;

    /* renamed from: g, reason: collision with root package name */
    int f١٢٨٧g;

    /* renamed from: h, reason: collision with root package name */
    final Rect f١٢٨٨h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        boolean f١٢٨٩a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f١٢٨٩a ? (byte) 1 : (byte) 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f١٢٨٩a = parcel.readByte() != 0;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends e0 {

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f١٢٩٠j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, f fVar) {
            super(view);
            this.f١٢٩٠j = fVar;
        }

        @Override // androidx.appcompat.widget.e0
        public androidx.appcompat.view.menu.o b() {
            return this.f١٢٩٠j;
        }

        @Override // androidx.appcompat.widget.e0
        public boolean c() {
            if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                AppCompatSpinner.this.b();
                return true;
            }
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class c {
        static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (!androidx.core.util.f.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class d implements g, DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        AlertDialog f١٢٩٣a;

        /* renamed from: b, reason: collision with root package name */
        private ListAdapter f١٢٩٤b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f١٢٩٥c;

        d() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void b(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public int c() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void d(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void dismiss() {
            AlertDialog alertDialog = this.f١٢٩٣a;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f١٢٩٣a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public CharSequence e() {
            return this.f١٢٩٥c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public Drawable f() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void g(CharSequence charSequence) {
            this.f١٢٩٥c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void h(int i10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void i(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public boolean isShowing() {
            AlertDialog alertDialog = this.f١٢٩٣a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void j(int i10, int i11) {
            if (this.f١٢٩٤b == null) {
                return;
            }
            AlertDialog.a aVar = new AlertDialog.a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f١٢٩٥c;
            if (charSequence != null) {
                aVar.h(charSequence);
            }
            AlertDialog a10 = aVar.g(this.f١٢٩٤b, AppCompatSpinner.this.getSelectedItemPosition(), this).a();
            this.f١٢٩٣a = a10;
            ListView listView = a10.getListView();
            listView.setTextDirection(i10);
            listView.setTextAlignment(i11);
            this.f١٢٩٣a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public int k() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void l(ListAdapter listAdapter) {
            this.f١٢٩٤b = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            AppCompatSpinner.this.setSelection(i10);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i10, this.f١٢٩٤b.getItemId(i10));
            }
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f١٢٩٧a;

        /* renamed from: b, reason: collision with root package name */
        private ListAdapter f١٢٩٨b;

        public e(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f١٢٩٧a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f١٢٩٨b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && Build.VERSION.SDK_INT >= 23 && o.a(spinnerAdapter)) {
                c.a(p.a(spinnerAdapter), theme);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f١٢٩٨b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f١٢٩٧a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f١٢٩٧a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f١٢٩٧a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f١٢٩٧a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f١٢٩٧a;
            if (spinnerAdapter != null && spinnerAdapter.hasStableIds()) {
                return true;
            }
            return false;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            if (getCount() == 0) {
                return true;
            }
            return false;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f١٢٩٨b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f١٢٩٧a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f١٢٩٧a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class f extends f0 implements g {
        private CharSequence J;
        ListAdapter K;
        private final Rect L;
        private int M;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppCompatSpinner f١٢٩٩a;

            a(AppCompatSpinner appCompatSpinner) {
                this.f١٢٩٩a = appCompatSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                AppCompatSpinner.this.setSelection(i10);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    f fVar = f.this;
                    AppCompatSpinner.this.performItemClick(view, i10, fVar.K.getItemId(i10));
                }
                f.this.dismiss();
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                f fVar = f.this;
                if (!fVar.Q(AppCompatSpinner.this)) {
                    f.this.dismiss();
                } else {
                    f.this.O();
                    f.super.show();
                }
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class c implements PopupWindow.OnDismissListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f١٣٠٢a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f١٣٠٢a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f١٣٠٢a);
                }
            }
        }

        public f(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.L = new Rect();
            B(AppCompatSpinner.this);
            H(true);
            K(0);
            setOnItemClickListener(new a(AppCompatSpinner.this));
        }

        void O() {
            int i10;
            int P;
            Drawable f10 = f();
            if (f10 != null) {
                f10.getPadding(AppCompatSpinner.this.f١٢٨٨h);
                if (a1.b(AppCompatSpinner.this)) {
                    i10 = AppCompatSpinner.this.f١٢٨٨h.right;
                } else {
                    i10 = -AppCompatSpinner.this.f١٢٨٨h.left;
                }
            } else {
                Rect rect = AppCompatSpinner.this.f١٢٨٨h;
                rect.right = 0;
                rect.left = 0;
                i10 = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i11 = appCompatSpinner.f١٢٨٧g;
            if (i11 == -2) {
                int a10 = appCompatSpinner.a((SpinnerAdapter) this.K, f());
                int i12 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f١٢٨٨h;
                int i13 = (i12 - rect2.left) - rect2.right;
                if (a10 > i13) {
                    a10 = i13;
                }
                D(Math.max(a10, (width - paddingLeft) - paddingRight));
            } else if (i11 == -1) {
                D((width - paddingLeft) - paddingRight);
            } else {
                D(i11);
            }
            if (a1.b(AppCompatSpinner.this)) {
                P = i10 + (((width - paddingRight) - x()) - P());
            } else {
                P = i10 + paddingLeft + P();
            }
            d(P);
        }

        public int P() {
            return this.M;
        }

        boolean Q(View view) {
            if (view.isAttachedToWindow() && view.getGlobalVisibleRect(this.L)) {
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public CharSequence e() {
            return this.J;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void g(CharSequence charSequence) {
            this.J = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void i(int i10) {
            this.M = i10;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.g
        public void j(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            O();
            G(2);
            super.show();
            ListView n10 = n();
            n10.setChoiceMode(1);
            n10.setTextDirection(i10);
            n10.setTextAlignment(i11);
            L(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                setOnDismissListener(new c(bVar));
            }
        }

        @Override // androidx.appcompat.widget.f0, androidx.appcompat.widget.AppCompatSpinner.g
        public void l(ListAdapter listAdapter) {
            super.l(listAdapter);
            this.K = listAdapter;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface g {
        void b(Drawable drawable);

        int c();

        void d(int i10);

        void dismiss();

        CharSequence e();

        Drawable f();

        void g(CharSequence charSequence);

        void h(int i10);

        void i(int i10);

        boolean isShowing();

        void j(int i10, int i11);

        int k();

        void l(ListAdapter listAdapter);
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f١٢٨٨h);
            Rect rect = this.f١٢٨٨h;
            return i11 + rect.left + rect.right;
        }
        return i11;
    }

    void b() {
        this.f١٢٨٦f.j(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.c cVar = this.f١٢٨١a;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.f١٢٨٦f;
        if (gVar != null) {
            return gVar.c();
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.f١٢٨٦f;
        if (gVar != null) {
            return gVar.k();
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f١٢٨٦f != null) {
            return this.f١٢٨٧g;
        }
        return super.getDropDownWidth();
    }

    @VisibleForTesting
    final g getInternalPopup() {
        return this.f١٢٨٦f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.f١٢٨٦f;
        if (gVar != null) {
            return gVar.f();
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f١٢٨٢b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.f١٢٨٦f;
        if (gVar != null) {
            return gVar.e();
        }
        return super.getPrompt();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.c cVar = this.f١٢٨١a;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.c cVar = this.f١٢٨١a;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f١٢٨٦f;
        if (gVar != null && gVar.isShowing()) {
            this.f١٢٨٦f.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f١٢٨٦f != null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f١٢٨٩a && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        boolean z10;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        g gVar = this.f١٢٨٦f;
        if (gVar != null && gVar.isShowing()) {
            z10 = true;
        } else {
            z10 = false;
        }
        savedState.f١٢٨٩a = z10;
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e0 e0Var = this.f١٢٨٣c;
        if (e0Var != null && e0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.f١٢٨٦f;
        if (gVar != null) {
            if (!gVar.isShowing()) {
                b();
                return true;
            }
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.c cVar = this.f١٢٨١a;
        if (cVar != null) {
            cVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        androidx.appcompat.widget.c cVar = this.f١٢٨١a;
        if (cVar != null) {
            cVar.g(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        g gVar = this.f١٢٨٦f;
        if (gVar != null) {
            gVar.i(i10);
            this.f١٢٨٦f.d(i10);
        } else {
            super.setDropDownHorizontalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        g gVar = this.f١٢٨٦f;
        if (gVar != null) {
            gVar.h(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f١٢٨٦f != null) {
            this.f١٢٨٧g = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f١٢٨٦f;
        if (gVar != null) {
            gVar.b(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(r1.a.b(getPopupContext(), i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f١٢٨٦f;
        if (gVar != null) {
            gVar.g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.view.y0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.c cVar = this.f١٢٨١a;
        if (cVar != null) {
            cVar.i(colorStateList);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.c cVar = this.f١٢٨١a;
        if (cVar != null) {
            cVar.j(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.spinnerStyle);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f١٢٨٥e) {
            this.f١٢٨٤d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f١٢٨٦f != null) {
            Context context = this.f١٢٨٢b;
            if (context == null) {
                context = getContext();
            }
            this.f١٢٨٦f.l(new e(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        if (r11 == null) goto L٣١;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.appcompat.widget.AppCompatSpinner, android.view.View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i10, int i11, Resources.Theme theme) {
        super(context, attributeSet, i10);
        TypedArray typedArray;
        this.f١٢٨٨h = new Rect();
        l0.a(this, getContext());
        p0 v10 = p0.v(context, attributeSet, androidx.appcompat.R.styleable.Spinner, i10, 0);
        this.f١٢٨١a = new androidx.appcompat.widget.c(this);
        if (theme != null) {
            this.f١٢٨٢b = new androidx.appcompat.view.d(context, theme);
        } else {
            int n10 = v10.n(androidx.appcompat.R.styleable.Spinner_popupTheme, 0);
            if (n10 != 0) {
                this.f١٢٨٢b = new androidx.appcompat.view.d(context, n10);
            } else {
                this.f١٢٨٢b = context;
            }
        }
        ?? r11 = -1;
        TypedArray typedArray2 = null;
        try {
            if (i11 == -1) {
                try {
                    typedArray = context.obtainStyledAttributes(attributeSet, f١٢٨٠i, i10, 0);
                    try {
                        boolean hasValue = typedArray.hasValue(0);
                        r11 = typedArray;
                        if (hasValue) {
                            i11 = typedArray.getInt(0, 0);
                            r11 = typedArray;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        r11 = typedArray;
                    }
                } catch (Exception e11) {
                    e = e11;
                    typedArray = null;
                } catch (Throwable th) {
                    th = th;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                    throw th;
                }
                r11.recycle();
            }
            if (i11 == 0) {
                d dVar = new d();
                this.f١٢٨٦f = dVar;
                dVar.g(v10.o(androidx.appcompat.R.styleable.Spinner_android_prompt));
            } else if (i11 == 1) {
                f fVar = new f(this.f١٢٨٢b, attributeSet, i10);
                p0 v11 = p0.v(this.f١٢٨٢b, attributeSet, androidx.appcompat.R.styleable.Spinner, i10, 0);
                this.f١٢٨٧g = v11.m(androidx.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
                fVar.b(v11.g(androidx.appcompat.R.styleable.Spinner_android_popupBackground));
                fVar.g(v10.o(androidx.appcompat.R.styleable.Spinner_android_prompt));
                v11.x();
                this.f١٢٨٦f = fVar;
                this.f١٢٨٣c = new a(this, fVar);
            }
            CharSequence[] q10 = v10.q(androidx.appcompat.R.styleable.Spinner_android_entries);
            if (q10 != null) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, q10);
                arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                setAdapter(arrayAdapter);
            }
            v10.x();
            this.f١٢٨٥e = true;
            SpinnerAdapter spinnerAdapter = this.f١٢٨٤d;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.f١٢٨٤d = null;
            }
            this.f١٢٨١a.e(attributeSet, i10);
        } catch (Throwable th2) {
            th = th2;
            typedArray2 = r11;
        }
    }
}

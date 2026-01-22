package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.d1;
import androidx.core.widget.NestedScrollView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a, reason: collision with root package name */
    private final Context f٥٥٦a;

    /* renamed from: b, reason: collision with root package name */
    final AppCompatDialog f٥٥٧b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f٥٥٨c;

    /* renamed from: d, reason: collision with root package name */
    private final int f٥٥٩d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f٥٦٠e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f٥٦١f;

    /* renamed from: g, reason: collision with root package name */
    ListView f٥٦٢g;

    /* renamed from: h, reason: collision with root package name */
    private View f٥٦٣h;

    /* renamed from: i, reason: collision with root package name */
    private int f٥٦٤i;

    /* renamed from: j, reason: collision with root package name */
    private int f٥٦٥j;

    /* renamed from: k, reason: collision with root package name */
    private int f٥٦٦k;

    /* renamed from: l, reason: collision with root package name */
    private int f٥٦٧l;

    /* renamed from: m, reason: collision with root package name */
    private int f٥٦٨m;

    /* renamed from: o, reason: collision with root package name */
    Button f٥٧٠o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f٥٧١p;

    /* renamed from: q, reason: collision with root package name */
    Message f٥٧٢q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f٥٧٣r;

    /* renamed from: s, reason: collision with root package name */
    Button f٥٧٤s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f٥٧٥t;

    /* renamed from: u, reason: collision with root package name */
    Message f٥٧٦u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f٥٧٧v;

    /* renamed from: w, reason: collision with root package name */
    Button f٥٧٨w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f٥٧٩x;

    /* renamed from: y, reason: collision with root package name */
    Message f٥٨٠y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f٥٨١z;

    /* renamed from: n, reason: collision with root package name */
    private boolean f٥٦٩n = false;

    /* renamed from: B, reason: collision with root package name */
    private int f٥٥٥B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        private final int f٥٨٢a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٥٨٣b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void a(boolean z10, boolean z11) {
            int i10;
            int i11;
            if (!z11 || !z10) {
                int paddingLeft = getPaddingLeft();
                if (z10) {
                    i10 = getPaddingTop();
                } else {
                    i10 = this.f٥٨٢a;
                }
                int paddingRight = getPaddingRight();
                if (z11) {
                    i11 = getPaddingBottom();
                } else {
                    i11 = this.f٥٨٣b;
                }
                setPadding(paddingLeft, i10, paddingRight, i11);
            }
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.f٥٨٣b = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f٥٨٢a = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f٥٧٠o && (message4 = alertController.f٥٧٢q) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.f٥٧٤s && (message3 = alertController.f٥٧٦u) != null) {
                message = Message.obtain(message3);
            } else if (view == alertController.f٥٧٨w && (message2 = alertController.f٥٨٠y) != null) {
                message = Message.obtain(message2);
            } else {
                message = null;
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f٥٥٧b).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements NestedScrollView.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f٥٨٥a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f٥٨٦b;

        b(View view, View view2) {
            this.f٥٨٥a = view;
            this.f٥٨٦b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.e
        public void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
            AlertController.g(nestedScrollView, this.f٥٨٥a, this.f٥٨٦b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f٥٨٨a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f٥٨٩b;

        c(View view, View view2) {
            this.f٥٨٨a = view;
            this.f٥٨٩b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.A, this.f٥٨٨a, this.f٥٨٩b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d implements AbsListView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f٥٩١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f٥٩٢b;

        d(View view, View view2) {
            this.f٥٩١a = view;
            this.f٥٩٢b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            AlertController.g(absListView, this.f٥٩١a, this.f٥٩٢b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f٥٩٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f٥٩٥b;

        e(View view, View view2) {
            this.f٥٩٤a = view;
            this.f٥٩٥b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.f٥٦٢g, this.f٥٩٤a, this.f٥٩٥b);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f {
        public int A;

        /* renamed from: B, reason: collision with root package name */
        public int f٥٩٧B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;

        /* renamed from: a, reason: collision with root package name */
        public final Context f٥٩٨a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f٥٩٩b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f٦٠١d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f٦٠٣f;

        /* renamed from: g, reason: collision with root package name */
        public View f٦٠٤g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f٦٠٥h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f٦٠٦i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f٦٠٧j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f٦٠٨k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f٦٠٩l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f٦١٠m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f٦١١n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f٦١٢o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f٦١٣p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f٦١٤q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f٦١٦s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f٦١٧t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f٦١٨u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f٦١٩v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f٦٢٠w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f٦٢١x;

        /* renamed from: y, reason: collision with root package name */
        public int f٦٢٢y;

        /* renamed from: z, reason: collision with root package name */
        public View f٦٢٣z;

        /* renamed from: c, reason: collision with root package name */
        public int f٦٠٠c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f٦٠٢e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean O = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f٦١٥r = true;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class a extends ArrayAdapter {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f٦٢٤a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f٦٢٤a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i10]) {
                    this.f٦٢٤a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class b extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            private final int f٦٢٦a;

            /* renamed from: b, reason: collision with root package name */
            private final int f٦٢٧b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ RecycleListView f٦٢٨c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AlertController f٦٢٩d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f٦٢٨c = recycleListView;
                this.f٦٢٩d = alertController;
                Cursor cursor2 = getCursor();
                this.f٦٢٦a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f٦٢٧b = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(android.R.id.text1)).setText(cursor.getString(this.f٦٢٦a));
                RecycleListView recycleListView = this.f٦٢٨c;
                int position = cursor.getPosition();
                boolean z10 = true;
                if (cursor.getInt(this.f٦٢٧b) != 1) {
                    z10 = false;
                }
                recycleListView.setItemChecked(position, z10);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f٥٩٩b.inflate(this.f٦٢٩d.M, viewGroup, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ AlertController f٦٣١a;

            c(AlertController alertController) {
                this.f٦٣١a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                f.this.f٦٢١x.onClick(this.f٦٣١a.f٥٥٧b, i10);
                if (!f.this.H) {
                    this.f٦٣١a.f٥٥٧b.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ RecycleListView f٦٣٣a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AlertController f٦٣٤b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f٦٣٣a = recycleListView;
                this.f٦٣٤b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i10] = this.f٦٣٣a.isItemChecked(i10);
                }
                f.this.J.onClick(this.f٦٣٤b.f٥٥٧b, i10, this.f٦٣٣a.isItemChecked(i10));
            }
        }

        public f(Context context) {
            this.f٥٩٨a = context;
            this.f٥٩٩b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            int i10;
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f٥٩٩b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                if (this.K == null) {
                    listAdapter = new a(this.f٥٩٨a, alertController.M, android.R.id.text1, this.f٦١٩v, recycleListView);
                } else {
                    listAdapter = new b(this.f٥٩٨a, this.K, false, recycleListView, alertController);
                }
            } else {
                if (this.H) {
                    i10 = alertController.N;
                } else {
                    i10 = alertController.O;
                }
                int i11 = i10;
                if (this.K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f٥٩٨a, i11, this.K, new String[]{this.L}, new int[]{android.R.id.text1});
                } else {
                    listAdapter = this.f٦٢٠w;
                    if (listAdapter == null) {
                        listAdapter = new h(this.f٥٩٨a, i11, android.R.id.text1, this.f٦١٩v);
                    }
                }
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.f٦٢١x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f٥٦٢g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f٦٠٤g;
            if (view != null) {
                alertController.n(view);
            } else {
                CharSequence charSequence = this.f٦٠٣f;
                if (charSequence != null) {
                    alertController.s(charSequence);
                }
                Drawable drawable = this.f٦٠١d;
                if (drawable != null) {
                    alertController.p(drawable);
                }
                int i10 = this.f٦٠٠c;
                if (i10 != 0) {
                    alertController.o(i10);
                }
                int i11 = this.f٦٠٢e;
                if (i11 != 0) {
                    alertController.o(alertController.d(i11));
                }
            }
            CharSequence charSequence2 = this.f٦٠٥h;
            if (charSequence2 != null) {
                alertController.q(charSequence2);
            }
            CharSequence charSequence3 = this.f٦٠٦i;
            if (charSequence3 != null || this.f٦٠٧j != null) {
                alertController.l(-1, charSequence3, this.f٦٠٨k, null, this.f٦٠٧j);
            }
            CharSequence charSequence4 = this.f٦٠٩l;
            if (charSequence4 != null || this.f٦١٠m != null) {
                alertController.l(-2, charSequence4, this.f٦١١n, null, this.f٦١٠m);
            }
            CharSequence charSequence5 = this.f٦١٢o;
            if (charSequence5 != null || this.f٦١٣p != null) {
                alertController.l(-3, charSequence5, this.f٦١٤q, null, this.f٦١٣p);
            }
            if (this.f٦١٩v != null || this.K != null || this.f٦٢٠w != null) {
                b(alertController);
            }
            View view2 = this.f٦٢٣z;
            if (view2 != null) {
                if (this.E) {
                    alertController.v(view2, this.A, this.f٥٩٧B, this.C, this.D);
                    return;
                } else {
                    alertController.u(view2);
                    return;
                }
            }
            int i12 = this.f٦٢٢y;
            if (i12 != 0) {
                alertController.t(i12);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference f٦٣٦a;

        public g(DialogInterface dialogInterface) {
            this.f٦٣٦a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != -3 && i10 != -2 && i10 != -1) {
                if (i10 == 1) {
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
                return;
            }
            ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f٦٣٦a.get(), message.what);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class h extends ArrayAdapter {
        public h(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.f٥٥٦a = context;
        this.f٥٥٧b = appCompatDialog;
        this.f٥٥٨c = window;
        this.R = new g(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f٥٥٩d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A() {
        boolean z10;
        boolean z11;
        boolean z12;
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3;
        View findViewById4 = this.f٥٥٨c.findViewById(R.id.parentPanel);
        int i10 = R.id.topPanel;
        View findViewById5 = findViewById4.findViewById(i10);
        int i11 = R.id.contentPanel;
        View findViewById6 = findViewById4.findViewById(i11);
        int i12 = R.id.buttonPanel;
        View findViewById7 = findViewById4.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) findViewById4.findViewById(R.id.customPanel);
        y(viewGroup);
        View findViewById8 = viewGroup.findViewById(i10);
        View findViewById9 = viewGroup.findViewById(i11);
        View findViewById10 = viewGroup.findViewById(i12);
        ViewGroup j10 = j(findViewById8, findViewById5);
        ViewGroup j11 = j(findViewById9, findViewById6);
        ViewGroup j12 = j(findViewById10, findViewById7);
        x(j11);
        w(j12);
        z(j10);
        int i13 = 0;
        if (viewGroup.getVisibility() != 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (j10 != null && j10.getVisibility() != 8) {
            z11 = 1;
        } else {
            z11 = 0;
        }
        if (j12 != null && j12.getVisibility() != 8) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12 && j11 != null && (findViewById3 = j11.findViewById(R.id.textSpacerNoButtons)) != null) {
            findViewById3.setVisibility(0);
        }
        if (z11 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            if (this.f٥٦١f == null && this.f٥٦٢g == null) {
                findViewById2 = null;
            } else {
                findViewById2 = j10.findViewById(R.id.titleDividerNoCustom);
            }
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        } else if (j11 != null && (findViewById = j11.findViewById(R.id.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f٥٦٢g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z11, z12);
        }
        if (!z10) {
            View view = this.f٥٦٢g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                if (z12) {
                    i13 = 2;
                }
                r(j11, view, z11 | i13, 3);
            }
        }
        ListView listView2 = this.f٥٦٢g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i14 = this.I;
            if (i14 > -1) {
                listView2.setItemChecked(i14, true);
                listView2.setSelection(i14);
            }
        }
    }

    private static boolean B(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void g(View view, View view2, View view3) {
        int i10;
        int i11 = 4;
        if (view2 != null) {
            if (view.canScrollVertically(-1)) {
                i10 = 0;
            } else {
                i10 = 4;
            }
            view2.setVisibility(i10);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1)) {
                i11 = 0;
            }
            view3.setVisibility(i11);
        }
    }

    private ViewGroup j(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int k() {
        int i10 = this.K;
        if (i10 == 0) {
            return this.J;
        }
        if (this.Q == 1) {
            return i10;
        }
        return this.J;
    }

    private void r(ViewGroup viewGroup, View view, int i10, int i11) {
        View findViewById = this.f٥٥٨c.findViewById(R.id.scrollIndicatorUp);
        View findViewById2 = this.f٥٥٨c.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            d1.H0(view, i10, i11);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i10 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i10 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f٥٦١f != null) {
                this.A.setOnScrollChangeListener(new b(findViewById, findViewById2));
                this.A.post(new c(findViewById, findViewById2));
                return;
            }
            ListView listView = this.f٥٦٢g;
            if (listView != null) {
                listView.setOnScrollListener(new d(findViewById, findViewById2));
                this.f٥٦٢g.post(new e(findViewById, findViewById2));
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    private void w(ViewGroup viewGroup) {
        int i10;
        Button button = (Button) viewGroup.findViewById(android.R.id.button1);
        this.f٥٧٠o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f٥٧١p) && this.f٥٧٣r == null) {
            this.f٥٧٠o.setVisibility(8);
            i10 = 0;
        } else {
            this.f٥٧٠o.setText(this.f٥٧١p);
            Drawable drawable = this.f٥٧٣r;
            if (drawable != null) {
                int i11 = this.f٥٥٩d;
                drawable.setBounds(0, 0, i11, i11);
                this.f٥٧٠o.setCompoundDrawables(this.f٥٧٣r, null, null, null);
            }
            this.f٥٧٠o.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(android.R.id.button2);
        this.f٥٧٤s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f٥٧٥t) && this.f٥٧٧v == null) {
            this.f٥٧٤s.setVisibility(8);
        } else {
            this.f٥٧٤s.setText(this.f٥٧٥t);
            Drawable drawable2 = this.f٥٧٧v;
            if (drawable2 != null) {
                int i12 = this.f٥٥٩d;
                drawable2.setBounds(0, 0, i12, i12);
                this.f٥٧٤s.setCompoundDrawables(this.f٥٧٧v, null, null, null);
            }
            this.f٥٧٤s.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(android.R.id.button3);
        this.f٥٧٨w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f٥٧٩x) && this.f٥٨١z == null) {
            this.f٥٧٨w.setVisibility(8);
        } else {
            this.f٥٧٨w.setText(this.f٥٧٩x);
            Drawable drawable3 = this.f٥٨١z;
            if (drawable3 != null) {
                int i13 = this.f٥٥٩d;
                drawable3.setBounds(0, 0, i13, i13);
                this.f٥٧٨w.setCompoundDrawables(this.f٥٨١z, null, null, null);
            }
            this.f٥٧٨w.setVisibility(0);
            i10 |= 4;
        }
        if (B(this.f٥٥٦a)) {
            if (i10 == 1) {
                b(this.f٥٧٠o);
            } else if (i10 == 2) {
                b(this.f٥٧٤s);
            } else if (i10 == 4) {
                b(this.f٥٧٨w);
            }
        }
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private void x(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f٥٥٨c.findViewById(R.id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(android.R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f٥٦١f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f٥٦٢g != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.A);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.f٥٦٢g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void y(ViewGroup viewGroup) {
        View view = this.f٥٦٣h;
        boolean z10 = false;
        if (view == null) {
            if (this.f٥٦٤i != 0) {
                view = LayoutInflater.from(this.f٥٥٦a).inflate(this.f٥٦٤i, viewGroup, false);
            } else {
                view = null;
            }
        }
        if (view != null) {
            z10 = true;
        }
        if (!z10 || !a(view)) {
            this.f٥٥٨c.setFlags(anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH, anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH);
        }
        if (z10) {
            FrameLayout frameLayout = (FrameLayout) this.f٥٥٨c.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f٥٦٩n) {
                frameLayout.setPadding(this.f٥٦٥j, this.f٥٦٦k, this.f٥٦٧l, this.f٥٦٨m);
            }
            if (this.f٥٦٢g != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = DownloadProgress.UNKNOWN_PROGRESS;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void z(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f٥٥٨c.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f٥٥٨c.findViewById(android.R.id.icon);
        if (!TextUtils.isEmpty(this.f٥٦٠e) && this.P) {
            TextView textView = (TextView) this.f٥٥٨c.findViewById(R.id.alertTitle);
            this.E = textView;
            textView.setText(this.f٥٦٠e);
            int i10 = this.f٥٥٥B;
            if (i10 != 0) {
                this.D.setImageResource(i10);
                return;
            }
            Drawable drawable = this.C;
            if (drawable != null) {
                this.D.setImageDrawable(drawable);
                return;
            } else {
                this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                this.D.setVisibility(8);
                return;
            }
        }
        this.f٥٥٨c.findViewById(R.id.title_template).setVisibility(8);
        this.D.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    public Button c(int i10) {
        if (i10 != -3) {
            if (i10 != -2) {
                if (i10 != -1) {
                    return null;
                }
                return this.f٥٧٠o;
            }
            return this.f٥٧٤s;
        }
        return this.f٥٧٨w;
    }

    public int d(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f٥٥٦a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f٥٦٢g;
    }

    public void f() {
        this.f٥٥٧b.setContentView(k());
        A();
    }

    public boolean h(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean i(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public void l(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i10, onClickListener);
        }
        if (i10 != -3) {
            if (i10 != -2) {
                if (i10 == -1) {
                    this.f٥٧١p = charSequence;
                    this.f٥٧٢q = message;
                    this.f٥٧٣r = drawable;
                    return;
                }
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f٥٧٥t = charSequence;
            this.f٥٧٦u = message;
            this.f٥٧٧v = drawable;
            return;
        }
        this.f٥٧٩x = charSequence;
        this.f٥٨٠y = message;
        this.f٥٨١z = drawable;
    }

    public void m(int i10) {
        this.Q = i10;
    }

    public void n(View view) {
        this.G = view;
    }

    public void o(int i10) {
        this.C = null;
        this.f٥٥٥B = i10;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i10 != 0) {
                imageView.setVisibility(0);
                this.D.setImageResource(this.f٥٥٥B);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void p(Drawable drawable) {
        this.C = drawable;
        this.f٥٥٥B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void q(CharSequence charSequence) {
        this.f٥٦١f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void s(CharSequence charSequence) {
        this.f٥٦٠e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void t(int i10) {
        this.f٥٦٣h = null;
        this.f٥٦٤i = i10;
        this.f٥٦٩n = false;
    }

    public void u(View view) {
        this.f٥٦٣h = view;
        this.f٥٦٤i = 0;
        this.f٥٦٩n = false;
    }

    public void v(View view, int i10, int i11, int i12, int i13) {
        this.f٥٦٣h = view;
        this.f٥٦٤i = 0;
        this.f٥٦٩n = true;
        this.f٥٦٥j = i10;
        this.f٥٦٦k = i11;
        this.f٥٦٧l = i12;
        this.f٥٦٨m = i13;
    }
}

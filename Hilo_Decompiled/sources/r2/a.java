package r2;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import r2.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f١٧٣٠٨a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f١٧٣٠٩b;

    /* renamed from: c, reason: collision with root package name */
    protected Cursor f١٧٣١٠c;

    /* renamed from: d, reason: collision with root package name */
    protected Context f١٧٣١١d;

    /* renamed from: e, reason: collision with root package name */
    protected int f١٧٣١٢e;

    /* renamed from: f, reason: collision with root package name */
    protected C٠٢١٤a f١٧٣١٣f;

    /* renamed from: g, reason: collision with root package name */
    protected DataSetObserver f١٧٣١٤g;

    /* renamed from: h, reason: collision with root package name */
    protected r2.b f١٧٣١٥h;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class C٠٢١٤a extends ContentObserver {
        C٠٢١٤a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            a.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f١٧٣٠٨a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f١٧٣٠٨a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z10) {
        int i10;
        if (z10) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        f(context, cursor, i10);
    }

    public void a(Cursor cursor) {
        Cursor j10 = j(cursor);
        if (j10 != null) {
            j10.close();
        }
    }

    public abstract CharSequence b(Cursor cursor);

    @Override // r2.b.a
    public Cursor d() {
        return this.f١٧٣١٠c;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i10) {
        int i11;
        boolean z10 = false;
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f١٧٣٠٩b = true;
        } else {
            this.f١٧٣٠٩b = false;
        }
        if (cursor != null) {
            z10 = true;
        }
        this.f١٧٣١٠c = cursor;
        this.f١٧٣٠٨a = z10;
        this.f١٧٣١١d = context;
        if (z10) {
            i11 = cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID);
        } else {
            i11 = -1;
        }
        this.f١٧٣١٢e = i11;
        if ((i10 & 2) == 2) {
            this.f١٧٣١٣f = new C٠٢١٤a();
            this.f١٧٣١٤g = new b();
        } else {
            this.f١٧٣١٣f = null;
            this.f١٧٣١٤g = null;
        }
        if (z10) {
            C٠٢١٤a r42 = this.f١٧٣١٣f;
            if (r42 != null) {
                cursor.registerContentObserver(r42);
            }
            DataSetObserver dataSetObserver = this.f١٧٣١٤g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (this.f١٧٣٠٨a && (cursor = this.f١٧٣١٠c) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (this.f١٧٣٠٨a) {
            this.f١٧٣١٠c.moveToPosition(i10);
            if (view == null) {
                view = g(this.f١٧٣١١d, this.f١٧٣١٠c, viewGroup);
            }
            e(view, this.f١٧٣١١d, this.f١٧٣١٠c);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f١٧٣١٥h == null) {
            this.f١٧٣١٥h = new r2.b(this);
        }
        return this.f١٧٣١٥h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        Cursor cursor;
        if (this.f١٧٣٠٨a && (cursor = this.f١٧٣١٠c) != null) {
            cursor.moveToPosition(i10);
            return this.f١٧٣١٠c;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        Cursor cursor;
        if (!this.f١٧٣٠٨a || (cursor = this.f١٧٣١٠c) == null || !cursor.moveToPosition(i10)) {
            return 0L;
        }
        return this.f١٧٣١٠c.getLong(this.f١٧٣١٢e);
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (this.f١٧٣٠٨a) {
            if (this.f١٧٣١٠c.moveToPosition(i10)) {
                if (view == null) {
                    view = h(this.f١٧٣١١d, this.f١٧٣١٠c, viewGroup);
                }
                e(view, this.f١٧٣١١d, this.f١٧٣١٠c);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i10);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (this.f١٧٣٠٩b && (cursor = this.f١٧٣١٠c) != null && !cursor.isClosed()) {
            this.f١٧٣٠٨a = this.f١٧٣١٠c.requery();
        }
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f١٧٣١٠c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C٠٢١٤a r12 = this.f١٧٣١٣f;
            if (r12 != null) {
                cursor2.unregisterContentObserver(r12);
            }
            DataSetObserver dataSetObserver = this.f١٧٣١٤g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f١٧٣١٠c = cursor;
        if (cursor != null) {
            C٠٢١٤a r13 = this.f١٧٣١٣f;
            if (r13 != null) {
                cursor.registerContentObserver(r13);
            }
            DataSetObserver dataSetObserver2 = this.f١٧٣١٤g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f١٧٣١٢e = cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID);
            this.f١٧٣٠٨a = true;
            notifyDataSetChanged();
        } else {
            this.f١٧٣١٢e = -1;
            this.f١٧٣٠٨a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}

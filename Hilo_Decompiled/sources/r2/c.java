package r2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c extends a {

    /* renamed from: i, reason: collision with root package name */
    private int f١٧٣١٩i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٧٣٢٠j;

    /* renamed from: k, reason: collision with root package name */
    private LayoutInflater f١٧٣٢١k;

    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f١٧٣٢٠j = i10;
        this.f١٧٣١٩i = i10;
        this.f١٧٣٢١k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // r2.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f١٧٣٢١k.inflate(this.f١٧٣٢٠j, viewGroup, false);
    }

    @Override // r2.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f١٧٣٢١k.inflate(this.f١٧٣١٩i, viewGroup, false);
    }
}

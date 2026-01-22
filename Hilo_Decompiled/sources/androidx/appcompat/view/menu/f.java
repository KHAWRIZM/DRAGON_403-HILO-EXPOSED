package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.m;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    g f١٠١٠a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٠١١b = -1;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٠١٢c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f١٠١٣d;

    /* renamed from: e, reason: collision with root package name */
    private final LayoutInflater f١٠١٤e;

    /* renamed from: f, reason: collision with root package name */
    private final int f١٠١٥f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f١٠١٣d = z10;
        this.f١٠١٤e = layoutInflater;
        this.f١٠١٠a = gVar;
        this.f١٠١٥f = i10;
        a();
    }

    void a() {
        i x10 = this.f١٠١٠a.x();
        if (x10 != null) {
            ArrayList B2 = this.f١٠١٠a.B();
            int size = B2.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((i) B2.get(i10)) == x10) {
                    this.f١٠١١b = i10;
                    return;
                }
            }
        }
        this.f١٠١١b = -1;
    }

    public g b() {
        return this.f١٠١٠a;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i getItem(int i10) {
        ArrayList G;
        if (this.f١٠١٣d) {
            G = this.f١٠١٠a.B();
        } else {
            G = this.f١٠١٠a.G();
        }
        int i11 = this.f١٠١١b;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return (i) G.get(i10);
    }

    public void d(boolean z10) {
        this.f١٠١٢c = z10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList G;
        if (this.f١٠١٣d) {
            G = this.f١٠١٠a.B();
        } else {
            G = this.f١٠١٠a.G();
        }
        if (this.f١٠١١b < 0) {
            return G.size();
        }
        return G.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        int i11;
        boolean z10;
        if (view == null) {
            view = this.f١٠١٤e.inflate(this.f١٠١٥f, viewGroup, false);
        }
        int groupId = getItem(i10).getGroupId();
        int i12 = i10 - 1;
        if (i12 >= 0) {
            i11 = getItem(i12).getGroupId();
        } else {
            i11 = groupId;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f١٠١٠a.I() && groupId != i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        listMenuItemView.setGroupDividerEnabled(z10);
        m.a aVar = (m.a) view;
        if (this.f١٠١٢c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.g(getItem(i10), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}

package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.q;
import com.google.android.material.internal.ParcelableSparseArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NavigationBarPresenter implements l {

    /* renamed from: a, reason: collision with root package name */
    private NavigationBarMenuView f٩٤٩٠a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٩٤٩١b = false;

    /* renamed from: c, reason: collision with root package name */
    private int f٩٤٩٢c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f٩٤٩٣a;

        /* renamed from: b, reason: collision with root package name */
        ParcelableSparseArray f٩٤٩٤b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
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

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f٩٤٩٣a);
            parcel.writeParcelable(this.f٩٤٩٤b, 0);
        }

        SavedState(Parcel parcel) {
            this.f٩٤٩٣a = parcel.readInt();
            this.f٩٤٩٤b = (ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public void a(androidx.appcompat.view.menu.g gVar, boolean z10) {
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean b(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f٩٤٩٠a.p(savedState.f٩٤٩٣a);
            this.f٩٤٩٠a.n(com.google.android.material.badge.b.c(this.f٩٤٩٠a.getContext(), savedState.f٩٤٩٤b));
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean e(q qVar) {
        return false;
    }

    public void f(int i10) {
        this.f٩٤٩٢c = i10;
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.f٩٤٩٣a = this.f٩٤٩٠a.getSelectedItemId();
        savedState.f٩٤٩٤b = com.google.android.material.badge.b.d(this.f٩٤٩٠a.getBadgeDrawables());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f٩٤٩٢c;
    }

    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        if (this.f٩٤٩١b) {
            return;
        }
        if (z10) {
            this.f٩٤٩٠a.d();
        } else {
            this.f٩٤٩٠a.r();
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(Context context, androidx.appcompat.view.menu.g gVar) {
        this.f٩٤٩٠a.b(gVar);
    }

    public void l(NavigationBarMenuView navigationBarMenuView) {
        this.f٩٤٩٠a = navigationBarMenuView;
    }

    public void m(boolean z10) {
        this.f٩٤٩١b = z10;
    }
}

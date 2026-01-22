package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f٤٤٨٢d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f٤٤٨٣e;

    /* renamed from: f, reason: collision with root package name */
    private final int f٤٤٨٤f;

    /* renamed from: g, reason: collision with root package name */
    private final int f٤٤٨٥g;

    /* renamed from: h, reason: collision with root package name */
    private final String f٤٤٨٦h;

    /* renamed from: i, reason: collision with root package name */
    private int f٤٤٨٧i;

    /* renamed from: j, reason: collision with root package name */
    private int f٤٤٨٨j;

    /* renamed from: k, reason: collision with root package name */
    private int f٤٤٨٩k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f٤٤٨٣e.writeInt(bArr.length);
            this.f٤٤٨٣e.writeByteArray(bArr);
        } else {
            this.f٤٤٨٣e.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f٤٤٨٣e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i10) {
        this.f٤٤٨٣e.writeInt(i10);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f٤٤٨٣e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f٤٤٨٣e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i10 = this.f٤٤٨٧i;
        if (i10 >= 0) {
            int i11 = this.f٤٤٨٢d.get(i10);
            int dataPosition = this.f٤٤٨٣e.dataPosition();
            this.f٤٤٨٣e.setDataPosition(i11);
            this.f٤٤٨٣e.writeInt(dataPosition - i11);
            this.f٤٤٨٣e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f٤٤٨٣e;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f٤٤٨٨j;
        if (i10 == this.f٤٤٨٤f) {
            i10 = this.f٤٤٨٥g;
        }
        return new b(parcel, dataPosition, i10, this.f٤٤٨٦h + "  ", this.f٤٤٧٩a, this.f٤٤٨٠b, this.f٤٤٨١c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        if (this.f٤٤٨٣e.readInt() != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f٤٤٨٣e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f٤٤٨٣e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f٤٤٨٣e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i10) {
        while (this.f٤٤٨٨j < this.f٤٤٨٥g) {
            int i11 = this.f٤٤٨٩k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f٤٤٨٣e.setDataPosition(this.f٤٤٨٨j);
            int readInt = this.f٤٤٨٣e.readInt();
            this.f٤٤٨٩k = this.f٤٤٨٣e.readInt();
            this.f٤٤٨٨j += readInt;
        }
        if (this.f٤٤٨٩k != i10) {
            return false;
        }
        return true;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f٤٤٨٣e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public Parcelable q() {
        return this.f٤٤٨٣e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f٤٤٨٣e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i10) {
        a();
        this.f٤٤٨٧i = i10;
        this.f٤٤٨٢d.put(i10, this.f٤٤٨٣e.dataPosition());
        E(0);
        E(i10);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z10) {
        this.f٤٤٨٣e.writeInt(z10 ? 1 : 0);
    }

    private b(Parcel parcel, int i10, int i11, String str, androidx.collection.a aVar, androidx.collection.a aVar2, androidx.collection.a aVar3) {
        super(aVar, aVar2, aVar3);
        this.f٤٤٨٢d = new SparseIntArray();
        this.f٤٤٨٧i = -1;
        this.f٤٤٨٩k = -1;
        this.f٤٤٨٣e = parcel;
        this.f٤٤٨٤f = i10;
        this.f٤٤٨٥g = i11;
        this.f٤٤٨٨j = i10;
        this.f٤٤٨٦h = str;
    }
}

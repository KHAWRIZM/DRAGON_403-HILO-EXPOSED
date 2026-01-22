package v4;

import android.graphics.Bitmap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class j0 implements m4.k {
    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public o4.v decode(Bitmap bitmap, int i10, int i11, m4.i iVar) {
        return new a(bitmap);
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(Bitmap bitmap, m4.i iVar) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a implements o4.v {

        /* renamed from: a, reason: collision with root package name */
        private final Bitmap f١٨٥١٥a;

        a(Bitmap bitmap) {
            this.f١٨٥١٥a = bitmap;
        }

        @Override // o4.v
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f١٨٥١٥a;
        }

        @Override // o4.v
        public Class getResourceClass() {
            return Bitmap.class;
        }

        @Override // o4.v
        public int getSize() {
            return f5.l.i(this.f١٨٥١٥a);
        }

        @Override // o4.v
        public void recycle() {
        }
    }
}

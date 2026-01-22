package i8;

import android.graphics.RectF;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static final d f١٤٦٩٣a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final d f١٤٦٩٤b = new b();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements d {
        a() {
        }

        @Override // i8.d
        public void a(RectF rectF, float f10, f fVar) {
            rectF.bottom -= Math.abs(fVar.f١٤٧٠٠f - fVar.f١٤٦٩٨d) * f10;
        }

        @Override // i8.d
        public boolean b(f fVar) {
            if (fVar.f١٤٦٩٨d > fVar.f١٤٧٠٠f) {
                return true;
            }
            return false;
        }

        @Override // i8.d
        public f c(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            float o10 = n.o(f13, f15, f11, f12, f10, true);
            float f17 = o10 / f13;
            float f18 = o10 / f15;
            return new f(f17, f18, o10, f14 * f17, o10, f16 * f18);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements d {
        b() {
        }

        @Override // i8.d
        public void a(RectF rectF, float f10, f fVar) {
            float abs = (Math.abs(fVar.f١٤٦٩٩e - fVar.f١٤٦٩٧c) / 2.0f) * f10;
            rectF.left += abs;
            rectF.right -= abs;
        }

        @Override // i8.d
        public boolean b(f fVar) {
            if (fVar.f١٤٦٩٧c > fVar.f١٤٦٩٩e) {
                return true;
            }
            return false;
        }

        @Override // i8.d
        public f c(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            float o10 = n.o(f14, f16, f11, f12, f10, true);
            float f17 = o10 / f14;
            float f18 = o10 / f16;
            return new f(f17, f18, f13 * f17, o10, f15 * f18, o10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(int i10, boolean z10, RectF rectF, RectF rectF2) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    return f١٤٦٩٤b;
                }
                throw new IllegalArgumentException("Invalid fit mode: " + i10);
            }
            return f١٤٦٩٣a;
        }
        if (b(z10, rectF, rectF2)) {
            return f١٤٦٩٣a;
        }
        return f١٤٦٩٤b;
    }

    private static boolean b(boolean z10, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f10 = (height2 * width) / width2;
        float f11 = (width2 * height) / width;
        if (z10) {
            if (f10 < height) {
                return false;
            }
        } else if (f11 < height2) {
            return false;
        }
        return true;
    }
}

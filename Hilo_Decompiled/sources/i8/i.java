package i8;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class i extends PathMotion {
    private static PointF a(float f10, float f11, float f12, float f13) {
        if (f11 > f13) {
            return new PointF(f12, f11);
        }
        return new PointF(f10, f13);
    }

    @Override // android.transition.PathMotion
    public Path getPath(float f10, float f11, float f12, float f13) {
        Path path = new Path();
        path.moveTo(f10, f11);
        PointF a10 = a(f10, f11, f12, f13);
        path.quadTo(a10.x, a10.y, f12, f13);
        return path;
    }
}

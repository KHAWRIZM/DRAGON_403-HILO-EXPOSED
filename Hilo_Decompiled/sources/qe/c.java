package qe;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.renderscript.BaseObj, android.renderscript.ScriptIntrinsicBlur] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Context context, Bitmap bitmap, int i10) {
        Allocation allocation;
        Allocation allocation2;
        Allocation allocation3;
        RenderScript create;
        RenderScript renderScript = null;
        ?? r12 = 0;
        try {
            create = RenderScript.create(context);
            try {
                create.setMessageHandler(new RenderScript.RSMessageHandler());
                allocation2 = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            } catch (Throwable th) {
                th = th;
                allocation2 = null;
                allocation3 = null;
            }
        } catch (Throwable th2) {
            th = th2;
            allocation = null;
            allocation2 = null;
            allocation3 = null;
        }
        try {
            allocation3 = Allocation.createTyped(create, allocation2.getType());
            try {
                r12 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                r12.setInput(allocation2);
                r12.setRadius(i10);
                r12.forEach(allocation3);
                allocation3.copyTo(bitmap);
                if (Build.VERSION.SDK_INT >= 23) {
                    RenderScript.releaseAllContexts();
                } else {
                    create.destroy();
                }
                allocation2.destroy();
                allocation3.destroy();
                r12.destroy();
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                Allocation allocation4 = r12;
                renderScript = create;
                allocation = allocation4;
                if (renderScript != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        RenderScript.releaseAllContexts();
                    } else {
                        renderScript.destroy();
                    }
                }
                if (allocation2 != null) {
                    allocation2.destroy();
                }
                if (allocation3 != null) {
                    allocation3.destroy();
                }
                if (allocation != null) {
                    allocation.destroy();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            allocation3 = null;
            renderScript = create;
            allocation = allocation3;
            if (renderScript != null) {
            }
            if (allocation2 != null) {
            }
            if (allocation3 != null) {
            }
            if (allocation != null) {
            }
            throw th;
        }
    }
}

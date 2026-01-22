package tech.sud.runtime.component.g;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class a {
    private final AssetManager a;
    private Canvas b;
    private Bitmap c;
    private int d = 4;
    private int e = 4;
    private int f = LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY;
    private HashMap<String, Typeface> g = new HashMap<>();

    public a(AssetManager assetManager) {
        this.a = assetManager;
    }

    public Typeface a(String str) {
        if (this.g.containsKey(str)) {
            return this.g.get(str);
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str.startsWith("/") && new File(str).exists()) {
            Typeface createFromFile = Typeface.createFromFile(str);
            tech.sud.runtime.component.h.f.c("TextBitmap", "font: ".concat(str));
            this.g.put(str, createFromFile);
            return createFromFile;
        }
        if (str.contains("/") && a(this.a, str)) {
            Typeface createFromAsset = Typeface.createFromAsset(this.a, str);
            this.g.put(str, createFromAsset);
            return createFromAsset;
        }
        return Typeface.create(str, 0);
    }

    public int b() {
        return this.f;
    }

    public Bitmap c() {
        return this.c;
    }

    public String b(String str) {
        try {
            if (str.startsWith("/")) {
                File file = new File(str);
                if (file.exists()) {
                    return b.a(new FileInputStream(file)).a();
                }
                return null;
            }
            if (a(this.a, str)) {
                return b.a(this.a.open(str)).a();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a() {
        this.g.clear();
    }

    public void a(int i) {
        this.f = i;
    }

    public Canvas a(int i, int i2) {
        boolean z;
        int i3 = this.d;
        if (i > i3 || i2 > this.e || this.c == null) {
            if (i > i3) {
                this.d = i;
            }
            if (i2 > this.e) {
                this.e = i2;
            }
            Bitmap bitmap = this.c;
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.c = Bitmap.createBitmap(this.d, this.e, Bitmap.Config.ARGB_8888);
            z = true;
        } else {
            z = false;
        }
        Canvas canvas = this.b;
        if (canvas == null) {
            this.b = new Canvas(this.c);
        } else if (z) {
            canvas.setBitmap(this.c);
        }
        return this.b;
    }

    private static boolean a(AssetManager assetManager, String str) {
        try {
            int lastIndexOf = str.lastIndexOf("/");
            String substring = str.substring(0, lastIndexOf);
            String substring2 = str.substring(lastIndexOf + 1);
            String[] list = assetManager.list(substring);
            for (String str2 : list) {
                if (str2.equals(substring2)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

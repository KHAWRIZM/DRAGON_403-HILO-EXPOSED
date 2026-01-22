package f6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private String f١٤٠٨٣a;

    /* renamed from: b, reason: collision with root package name */
    private File f١٤٠٨٤b;

    /* renamed from: c, reason: collision with root package name */
    private BufferedWriter f١٤٠٨٥c;

    @Override // f6.b
    public void a(String str) {
        try {
            this.f١٤٠٨٥c.write(str);
            this.f١٤٠٨٥c.newLine();
            this.f١٤٠٨٥c.flush();
        } catch (Exception e10) {
            x5.b.d().f("append log failed: " + e10.getMessage());
        }
    }

    @Override // f6.b
    public boolean b() {
        BufferedWriter bufferedWriter = this.f١٤٠٨٥c;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        this.f١٤٠٨٥c = null;
        this.f١٤٠٨٣a = null;
        this.f١٤٠٨٤b = null;
        return true;
    }

    @Override // f6.b
    public File c() {
        return this.f١٤٠٨٤b;
    }

    @Override // f6.b
    public String d() {
        return this.f١٤٠٨٣a;
    }

    @Override // f6.b
    public boolean e() {
        if (this.f١٤٠٨٥c != null && this.f١٤٠٨٤b.exists()) {
            return true;
        }
        return false;
    }

    @Override // f6.b
    public boolean f(File file) {
        boolean z10;
        this.f١٤٠٨٣a = file.getName();
        this.f١٤٠٨٤b = file;
        if (!file.exists()) {
            try {
                File parentFile = this.f١٤٠٨٤b.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f١٤٠٨٤b.createNewFile();
                z10 = true;
            } catch (Exception e10) {
                e10.printStackTrace();
                b();
                return false;
            }
        } else {
            z10 = false;
        }
        try {
            this.f١٤٠٨٥c = new BufferedWriter(new FileWriter(this.f١٤٠٨٤b, true));
            if (z10) {
                g(this.f١٤٠٨٤b);
            }
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            b();
            return false;
        }
    }

    public void g(File file) {
    }
}

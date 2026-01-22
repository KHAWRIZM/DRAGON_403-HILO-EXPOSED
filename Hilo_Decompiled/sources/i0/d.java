package i0;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public final File f١٤٥٩١a;

    /* renamed from: b, reason: collision with root package name */
    public final OutputStream f١٤٥٩٢b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f١٤٥٩٣c;

    public d(File file) {
        Path path;
        OutputStream newOutputStream;
        this.f١٤٥٩١a = file;
        try {
            path = file.toPath();
            newOutputStream = Files.newOutputStream(path, new OpenOption[0]);
            this.f١٤٥٩٢b = newOutputStream;
        } catch (FileNotFoundException e10) {
            throw e10;
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final InputStream a() {
        Path path;
        InputStream newInputStream;
        path = this.f١٤٥٩١a.toPath();
        newInputStream = Files.newInputStream(path, new OpenOption[0]);
        return newInputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            if (!this.f١٤٥٩٣c) {
                this.f١٤٥٩٢b.close();
                this.f١٤٥٩٣c = true;
            }
        } finally {
            if (this.f١٤٥٩١a.exists() && !this.f١٤٥٩١a.delete()) {
                this.f١٤٥٩١a.deleteOnExit();
            }
        }
    }
}

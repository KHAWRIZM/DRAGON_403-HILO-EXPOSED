package sf;

import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public abstract class d implements e {
    public abstract InputStream a();

    @Override // sf.e
    public void close() {
        tf.b.d().a();
    }

    @Override // sf.e
    public InputStream open() {
        return a();
    }
}

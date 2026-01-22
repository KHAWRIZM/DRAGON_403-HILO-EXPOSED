package com.amazonaws.internal;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ReleasableInputStream extends SdkFilterInputStream implements Releasable {
    private static final Log log = LogFactory.getLog(ReleasableInputStream.class);
    private boolean closeDisabled;

    /* JADX INFO: Access modifiers changed from: protected */
    public ReleasableInputStream(InputStream inputStream) {
        super(inputStream);
    }

    private void doRelease() {
        try {
            ((FilterInputStream) this).in.close();
        } catch (Exception e10) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("FYI", e10);
            }
        }
        if (((FilterInputStream) this).in instanceof Releasable) {
            ((Releasable) ((FilterInputStream) this).in).release();
        }
        abortIfNeeded();
    }

    public static ReleasableInputStream wrap(InputStream inputStream) {
        if (inputStream instanceof ReleasableInputStream) {
            return (ReleasableInputStream) inputStream;
        }
        if (inputStream instanceof FileInputStream) {
            return ResettableInputStream.newResettableInputStream((FileInputStream) inputStream);
        }
        return new ReleasableInputStream(inputStream);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.closeDisabled) {
            doRelease();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends ReleasableInputStream> T disableClose() {
        this.closeDisabled = true;
        return this;
    }

    public final boolean isCloseDisabled() {
        return this.closeDisabled;
    }

    @Override // com.amazonaws.internal.Releasable
    public final void release() {
        doRelease();
    }
}

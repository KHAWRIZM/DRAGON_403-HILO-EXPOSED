package tech.sud.a.a;

import b1.e;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class Suddo implements Runnable {
    public final /* synthetic */ Sudif Suddo;

    public Suddo(Sudif sudif) {
        this.Suddo = sudif;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar;
        OutputStream outputStream;
        OutputStream outputStream2;
        e eVar2;
        OutputStream outputStream3;
        OutputStream outputStream4;
        Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
        while (true) {
            try {
                try {
                    if (Thread.interrupted()) {
                        break;
                    }
                    eVar2 = this.Suddo.c;
                    ByteBuffer byteBuffer = (ByteBuffer) eVar2.a.take();
                    outputStream3 = this.Suddo.e;
                    outputStream3.write(byteBuffer.array(), 0, byteBuffer.limit());
                    outputStream4 = this.Suddo.e;
                    outputStream4.flush();
                } catch (InterruptedException unused) {
                    eVar = this.Suddo.c;
                    Iterator it = eVar.a.iterator();
                    while (it.hasNext()) {
                        ByteBuffer byteBuffer2 = (ByteBuffer) it.next();
                        outputStream = this.Suddo.e;
                        outputStream.write(byteBuffer2.array(), 0, byteBuffer2.limit());
                        outputStream2 = this.Suddo.e;
                        outputStream2.flush();
                    }
                }
            } catch (IOException e) {
                Sudif.a(this.Suddo, e);
                return;
            } finally {
                Sudif.c(this.Suddo);
                this.Suddo.g = null;
            }
        }
    }
}

package org.android.spdy;

import com.tencent.qcloud.tuicore.TUIConstants;
import org.android.spdy.ProtectedPointer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class ProtectedPointerTest {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
    static class Data {
        private int i = 0;

        Data() {
        }

        public void destroy() {
            System.out.println(TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC);
            this.i = 1;
        }

        public void work() {
            System.out.println("work");
            if (this.i == 1) {
                System.exit(-1);
            }
        }
    }

    public static void main(String[] strArr) {
        ProtectedPointer protectedPointer = new ProtectedPointer(new Data());
        protectedPointer.setHow2close(new ProtectedPointer.ProtectedPointerOnClose() { // from class: org.android.spdy.ProtectedPointerTest.3
            @Override // org.android.spdy.ProtectedPointer.ProtectedPointerOnClose
            public void close(Object obj) {
                ((Data) obj).destroy();
            }
        });
        test_close_with_work(protectedPointer);
    }

    public static void test_close_anywhere1(ProtectedPointer protectedPointer) {
        if (protectedPointer.enter()) {
            Data data = (Data) protectedPointer.getData();
            protectedPointer.release();
            data.work();
            protectedPointer.exit();
        }
    }

    public static void test_close_with_work(final ProtectedPointer protectedPointer) {
        Thread thread = new Thread(new Runnable() { // from class: org.android.spdy.ProtectedPointerTest.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (ProtectedPointer.this.enter()) {
                        ((Data) ProtectedPointer.this.getData()).work();
                        ProtectedPointer.this.exit();
                    } else {
                        System.out.println("the data has been destroy");
                    }
                }
            }
        });
        new Thread(new Runnable() { // from class: org.android.spdy.ProtectedPointerTest.2
            @Override // java.lang.Runnable
            public void run() {
                ProtectedPointer.this.release();
            }
        }).run();
        thread.run();
    }

    public static void test_sequece(ProtectedPointer protectedPointer) {
        protectedPointer.release();
    }
}

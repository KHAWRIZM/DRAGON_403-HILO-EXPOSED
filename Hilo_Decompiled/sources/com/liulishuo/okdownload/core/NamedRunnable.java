package com.liulishuo.okdownload.core;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String name;

    public NamedRunnable(String str) {
        this.name = str;
    }

    public abstract void execute();

    public abstract void finished();

    public abstract void interrupted(InterruptedException interruptedException);

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            try {
                execute();
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                interrupted(e10);
            }
        } finally {
            Thread.currentThread().setName(name);
            finished();
        }
    }
}

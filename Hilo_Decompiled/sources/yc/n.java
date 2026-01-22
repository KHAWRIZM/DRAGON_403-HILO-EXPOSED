package yc;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final class n {
    private final c a;
    private final String b;
    private final int c;
    private boolean d;
    private final StringBuilder e = new StringBuilder();
    private int f = 0;
    private int g = -1;
    private b h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.WRAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.SPACE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum b {
        WRAP,
        SPACE,
        EMPTY
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Appendable appendable, String str, int i) {
        u.c(appendable, "out == null", new Object[0]);
        this.a = new c(appendable);
        this.b = str;
        this.c = i;
    }

    private void b(b bVar) {
        int i;
        int i2 = a.a[bVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unknown FlushType: " + bVar);
                }
            } else {
                this.a.append(' ');
            }
        } else {
            this.a.append('\n');
            int i3 = 0;
            while (true) {
                i = this.g;
                if (i3 >= i) {
                    break;
                }
                this.a.append(this.b);
                i3++;
            }
            int length = i * this.b.length();
            this.f = length;
            this.f = length + this.e.length();
        }
        this.a.append(this.e);
        StringBuilder sb2 = this.e;
        sb2.delete(0, sb2.length());
        this.g = -1;
        this.h = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        int length;
        b bVar;
        if (!this.d) {
            if (this.h != null) {
                int indexOf = str.indexOf(10);
                if (indexOf == -1 && this.f + str.length() <= this.c) {
                    this.e.append(str);
                    this.f += str.length();
                    return;
                } else {
                    if (indexOf != -1 && this.f + indexOf <= this.c) {
                        bVar = this.h;
                    } else {
                        bVar = b.WRAP;
                    }
                    b(bVar);
                }
            }
            this.a.append(str);
            int lastIndexOf = str.lastIndexOf(10);
            if (lastIndexOf != -1) {
                length = (str.length() - lastIndexOf) - 1;
            } else {
                length = str.length() + this.f;
            }
            this.f = length;
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char c() {
        return this.a.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        if (!this.d) {
            b bVar = this.h;
            if (bVar != null) {
                b(bVar);
            }
            this.f++;
            this.h = b.SPACE;
            this.g = i;
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i) {
        if (!this.d) {
            if (this.f == 0) {
                return;
            }
            b bVar = this.h;
            if (bVar != null) {
                b(bVar);
            }
            this.h = b.EMPTY;
            this.g = i;
            return;
        }
        throw new IllegalStateException("closed");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class c implements Appendable {
        private final Appendable a;
        char b = 0;

        c(Appendable appendable) {
            this.a = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            int length = charSequence.length();
            if (length != 0) {
                this.b = charSequence.charAt(length - 1);
            }
            return this.a.append(charSequence);
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) {
            return append(charSequence.subSequence(i, i2));
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) {
            this.b = c;
            return this.a.append(c);
        }
    }
}

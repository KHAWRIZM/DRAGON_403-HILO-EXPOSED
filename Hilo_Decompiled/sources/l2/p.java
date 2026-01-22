package l2;

import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final o f١٥٧١٨a = new e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final o f١٥٧١٩b = new e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final o f١٥٧٢٠c;

    /* renamed from: d, reason: collision with root package name */
    public static final o f١٥٧٢١d;

    /* renamed from: e, reason: collision with root package name */
    public static final o f١٥٧٢٢e;

    /* renamed from: f, reason: collision with root package name */
    public static final o f١٥٧٢٣f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        static final a f١٥٧٢٤b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        private final boolean f١٥٧٢٥a;

        private a(boolean z10) {
            this.f١٥٧٢٥a = z10;
        }

        @Override // l2.p.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int a10 = p.a(Character.getDirectionality(charSequence.charAt(i10)));
                if (a10 != 0) {
                    if (a10 == 1) {
                        if (!this.f١٥٧٢٥a) {
                            return 1;
                        }
                    } else {
                        continue;
                        i10++;
                    }
                } else if (this.f١٥٧٢٥a) {
                    return 0;
                }
                z10 = true;
                i10++;
            }
            if (z10) {
                return this.f١٥٧٢٥a ? 1 : 0;
            }
            return 2;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        static final b f١٥٧٢٦a = new b();

        private b() {
        }

        @Override // l2.p.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int i13 = 2;
            while (i10 < i12 && i13 == 2) {
                i13 = p.b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return i13;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static abstract class d implements o {

        /* renamed from: a, reason: collision with root package name */
        private final c f١٥٧٢٧a;

        d(c cVar) {
            this.f١٥٧٢٧a = cVar;
        }

        private boolean c(CharSequence charSequence, int i10, int i11) {
            int a10 = this.f١٥٧٢٧a.a(charSequence, i10, i11);
            if (a10 == 0) {
                return true;
            }
            if (a10 != 1) {
                return b();
            }
            return false;
        }

        @Override // l2.o
        public boolean a(CharSequence charSequence, int i10, int i11) {
            if (charSequence != null && i10 >= 0 && i11 >= 0 && charSequence.length() - i11 >= i10) {
                if (this.f١٥٧٢٧a == null) {
                    return b();
                }
                return c(charSequence, i10, i11);
            }
            throw new IllegalArgumentException();
        }

        protected abstract boolean b();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class e extends d {

        /* renamed from: b, reason: collision with root package name */
        private final boolean f١٥٧٢٨b;

        e(c cVar, boolean z10) {
            super(cVar);
            this.f١٥٧٢٨b = z10;
        }

        @Override // l2.p.d
        protected boolean b() {
            return this.f١٥٧٢٨b;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class f extends d {

        /* renamed from: b, reason: collision with root package name */
        static final f f١٥٧٢٩b = new f();

        f() {
            super(null);
        }

        @Override // l2.p.d
        protected boolean b() {
            if (q.a(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    static {
        b bVar = b.f١٥٧٢٦a;
        f١٥٧٢٠c = new e(bVar, false);
        f١٥٧٢١d = new e(bVar, true);
        f١٥٧٢٢e = new e(a.f١٥٧٢٤b, false);
        f١٥٧٢٣f = f.f١٥٧٢٩b;
    }

    static int a(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 != 1 && i10 != 2) {
            return 2;
        }
        return 0;
    }

    static int b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}

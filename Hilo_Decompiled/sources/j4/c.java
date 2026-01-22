package j4;

import android.view.View;
import com.bigkoo.pickerview.R;
import com.contrarywind.view.WheelView;
import com.facebook.internal.security.CertificateUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {

    /* renamed from: t, reason: collision with root package name */
    public static DateFormat f١٥٢٢٩t = new SimpleDateFormat(com.oudi.utils.date.DateFormat.YMD_HMS);

    /* renamed from: a, reason: collision with root package name */
    private View f١٥٢٣٠a;

    /* renamed from: b, reason: collision with root package name */
    private WheelView f١٥٢٣١b;

    /* renamed from: c, reason: collision with root package name */
    private WheelView f١٥٢٣٢c;

    /* renamed from: d, reason: collision with root package name */
    private WheelView f١٥٢٣٣d;

    /* renamed from: e, reason: collision with root package name */
    private WheelView f١٥٢٣٤e;

    /* renamed from: f, reason: collision with root package name */
    private WheelView f١٥٢٣٥f;

    /* renamed from: g, reason: collision with root package name */
    private WheelView f١٥٢٣٦g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٥٢٣٧h;

    /* renamed from: i, reason: collision with root package name */
    private boolean[] f١٥٢٣٨i;

    /* renamed from: p, reason: collision with root package name */
    private int f١٥٢٤٥p;

    /* renamed from: q, reason: collision with root package name */
    private int f١٥٢٤٦q;

    /* renamed from: s, reason: collision with root package name */
    private h4.b f١٥٢٤٨s;

    /* renamed from: j, reason: collision with root package name */
    private int f١٥٢٣٩j = 1900;

    /* renamed from: k, reason: collision with root package name */
    private int f١٥٢٤٠k = 2100;

    /* renamed from: l, reason: collision with root package name */
    private int f١٥٢٤١l = 1;

    /* renamed from: m, reason: collision with root package name */
    private int f١٥٢٤٢m = 12;

    /* renamed from: n, reason: collision with root package name */
    private int f١٥٢٤٣n = 1;

    /* renamed from: o, reason: collision with root package name */
    private int f١٥٢٤٤o = 31;

    /* renamed from: r, reason: collision with root package name */
    private boolean f١٥٢٤٧r = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements l5.b {
        a() {
        }

        @Override // l5.b
        public void a(int i10) {
            int h10;
            int i11 = i10 + c.this.f١٥٢٣٩j;
            c.this.f١٥٢٣٢c.setAdapter(new e4.a(i4.a.d(i11)));
            if (i4.a.g(i11) != 0 && c.this.f١٥٢٣٢c.getCurrentItem() > i4.a.g(i11) - 1) {
                c.this.f١٥٢٣٢c.setCurrentItem(c.this.f١٥٢٣٢c.getCurrentItem() + 1);
            } else {
                c.this.f١٥٢٣٢c.setCurrentItem(c.this.f١٥٢٣٢c.getCurrentItem());
            }
            int currentItem = c.this.f١٥٢٣٣d.getCurrentItem();
            if (i4.a.g(i11) != 0 && c.this.f١٥٢٣٢c.getCurrentItem() > i4.a.g(i11) - 1) {
                if (c.this.f١٥٢٣٢c.getCurrentItem() == i4.a.g(i11) + 1) {
                    c.this.f١٥٢٣٣d.setAdapter(new e4.a(i4.a.b(i4.a.f(i11))));
                    h10 = i4.a.f(i11);
                } else {
                    c.this.f١٥٢٣٣d.setAdapter(new e4.a(i4.a.b(i4.a.h(i11, c.this.f١٥٢٣٢c.getCurrentItem()))));
                    h10 = i4.a.h(i11, c.this.f١٥٢٣٢c.getCurrentItem());
                }
            } else {
                c.this.f١٥٢٣٣d.setAdapter(new e4.a(i4.a.b(i4.a.h(i11, c.this.f١٥٢٣٢c.getCurrentItem() + 1))));
                h10 = i4.a.h(i11, c.this.f١٥٢٣٢c.getCurrentItem() + 1);
            }
            int i12 = h10 - 1;
            if (currentItem > i12) {
                c.this.f١٥٢٣٣d.setCurrentItem(i12);
            }
            if (c.this.f١٥٢٤٨s != null) {
                c.this.f١٥٢٤٨s.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements l5.b {
        b() {
        }

        @Override // l5.b
        public void a(int i10) {
            int h10;
            int currentItem = c.this.f١٥٢٣١b.getCurrentItem() + c.this.f١٥٢٣٩j;
            int currentItem2 = c.this.f١٥٢٣٣d.getCurrentItem();
            if (i4.a.g(currentItem) != 0 && i10 > i4.a.g(currentItem) - 1) {
                if (c.this.f١٥٢٣٢c.getCurrentItem() == i4.a.g(currentItem) + 1) {
                    c.this.f١٥٢٣٣d.setAdapter(new e4.a(i4.a.b(i4.a.f(currentItem))));
                    h10 = i4.a.f(currentItem);
                } else {
                    c.this.f١٥٢٣٣d.setAdapter(new e4.a(i4.a.b(i4.a.h(currentItem, i10))));
                    h10 = i4.a.h(currentItem, i10);
                }
            } else {
                int i11 = i10 + 1;
                c.this.f١٥٢٣٣d.setAdapter(new e4.a(i4.a.b(i4.a.h(currentItem, i11))));
                h10 = i4.a.h(currentItem, i11);
            }
            int i12 = h10 - 1;
            if (currentItem2 > i12) {
                c.this.f١٥٢٣٣d.setCurrentItem(i12);
            }
            if (c.this.f١٥٢٤٨s != null) {
                c.this.f١٥٢٤٨s.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j4.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class C٠١٧٢c implements l5.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f١٥٢٥١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f١٥٢٥٢b;

        C٠١٧٢c(List list, List list2) {
            this.f١٥٢٥١a = list;
            this.f١٥٢٥٢b = list2;
        }

        @Override // l5.b
        public void a(int i10) {
            int i11 = i10 + c.this.f١٥٢٣٩j;
            c.this.f١٥٢٤٥p = i11;
            int currentItem = c.this.f١٥٢٣٢c.getCurrentItem();
            if (c.this.f١٥٢٣٩j == c.this.f١٥٢٤٠k) {
                c.this.f١٥٢٣٢c.setAdapter(new e4.b(c.this.f١٥٢٤١l, c.this.f١٥٢٤٢m));
                if (currentItem > c.this.f١٥٢٣٢c.getAdapter().a() - 1) {
                    currentItem = c.this.f١٥٢٣٢c.getAdapter().a() - 1;
                    c.this.f١٥٢٣٢c.setCurrentItem(currentItem);
                }
                int i12 = currentItem + c.this.f١٥٢٤١l;
                if (c.this.f١٥٢٤١l == c.this.f١٥٢٤٢m) {
                    c cVar = c.this;
                    cVar.E(i11, i12, cVar.f١٥٢٤٣n, c.this.f١٥٢٤٤o, this.f١٥٢٥١a, this.f١٥٢٥٢b);
                } else if (i12 == c.this.f١٥٢٤١l) {
                    c cVar2 = c.this;
                    cVar2.E(i11, i12, cVar2.f١٥٢٤٣n, 31, this.f١٥٢٥١a, this.f١٥٢٥٢b);
                } else if (i12 != c.this.f١٥٢٤٢m) {
                    c.this.E(i11, i12, 1, 31, this.f١٥٢٥١a, this.f١٥٢٥٢b);
                } else {
                    c cVar3 = c.this;
                    cVar3.E(i11, i12, 1, cVar3.f١٥٢٤٤o, this.f١٥٢٥١a, this.f١٥٢٥٢b);
                }
            } else if (i11 == c.this.f١٥٢٣٩j) {
                c.this.f١٥٢٣٢c.setAdapter(new e4.b(c.this.f١٥٢٤١l, 12));
                if (currentItem > c.this.f١٥٢٣٢c.getAdapter().a() - 1) {
                    currentItem = c.this.f١٥٢٣٢c.getAdapter().a() - 1;
                    c.this.f١٥٢٣٢c.setCurrentItem(currentItem);
                }
                int i13 = currentItem + c.this.f١٥٢٤١l;
                if (i13 != c.this.f١٥٢٤١l) {
                    c.this.E(i11, i13, 1, 31, this.f١٥٢٥١a, this.f١٥٢٥٢b);
                } else {
                    c cVar4 = c.this;
                    cVar4.E(i11, i13, cVar4.f١٥٢٤٣n, 31, this.f١٥٢٥١a, this.f١٥٢٥٢b);
                }
            } else if (i11 == c.this.f١٥٢٤٠k) {
                c.this.f١٥٢٣٢c.setAdapter(new e4.b(1, c.this.f١٥٢٤٢m));
                if (currentItem > c.this.f١٥٢٣٢c.getAdapter().a() - 1) {
                    currentItem = c.this.f١٥٢٣٢c.getAdapter().a() - 1;
                    c.this.f١٥٢٣٢c.setCurrentItem(currentItem);
                }
                int i14 = 1 + currentItem;
                if (i14 != c.this.f١٥٢٤٢m) {
                    c.this.E(i11, i14, 1, 31, this.f١٥٢٥١a, this.f١٥٢٥٢b);
                } else {
                    c cVar5 = c.this;
                    cVar5.E(i11, i14, 1, cVar5.f١٥٢٤٤o, this.f١٥٢٥١a, this.f١٥٢٥٢b);
                }
            } else {
                c.this.f١٥٢٣٢c.setAdapter(new e4.b(1, 12));
                c cVar6 = c.this;
                cVar6.E(i11, 1 + cVar6.f١٥٢٣٢c.getCurrentItem(), 1, 31, this.f١٥٢٥١a, this.f١٥٢٥٢b);
            }
            if (c.this.f١٥٢٤٨s != null) {
                c.this.f١٥٢٤٨s.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d implements l5.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f١٥٢٥٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f١٥٢٥٥b;

        d(List list, List list2) {
            this.f١٥٢٥٤a = list;
            this.f١٥٢٥٥b = list2;
        }

        @Override // l5.b
        public void a(int i10) {
            int i11 = i10 + 1;
            if (c.this.f١٥٢٣٩j == c.this.f١٥٢٤٠k) {
                int i12 = (i11 + c.this.f١٥٢٤١l) - 1;
                if (c.this.f١٥٢٤١l == c.this.f١٥٢٤٢m) {
                    c cVar = c.this;
                    cVar.E(cVar.f١٥٢٤٥p, i12, c.this.f١٥٢٤٣n, c.this.f١٥٢٤٤o, this.f١٥٢٥٤a, this.f١٥٢٥٥b);
                } else if (c.this.f١٥٢٤١l == i12) {
                    c cVar2 = c.this;
                    cVar2.E(cVar2.f١٥٢٤٥p, i12, c.this.f١٥٢٤٣n, 31, this.f١٥٢٥٤a, this.f١٥٢٥٥b);
                } else if (c.this.f١٥٢٤٢m == i12) {
                    c cVar3 = c.this;
                    cVar3.E(cVar3.f١٥٢٤٥p, i12, 1, c.this.f١٥٢٤٤o, this.f١٥٢٥٤a, this.f١٥٢٥٥b);
                } else {
                    c cVar4 = c.this;
                    cVar4.E(cVar4.f١٥٢٤٥p, i12, 1, 31, this.f١٥٢٥٤a, this.f١٥٢٥٥b);
                }
            } else if (c.this.f١٥٢٤٥p == c.this.f١٥٢٣٩j) {
                int i13 = (i11 + c.this.f١٥٢٤١l) - 1;
                if (i13 == c.this.f١٥٢٤١l) {
                    c cVar5 = c.this;
                    cVar5.E(cVar5.f١٥٢٤٥p, i13, c.this.f١٥٢٤٣n, 31, this.f١٥٢٥٤a, this.f١٥٢٥٥b);
                } else {
                    c cVar6 = c.this;
                    cVar6.E(cVar6.f١٥٢٤٥p, i13, 1, 31, this.f١٥٢٥٤a, this.f١٥٢٥٥b);
                }
            } else if (c.this.f١٥٢٤٥p == c.this.f١٥٢٤٠k) {
                if (i11 == c.this.f١٥٢٤٢m) {
                    c cVar7 = c.this;
                    cVar7.E(cVar7.f١٥٢٤٥p, c.this.f١٥٢٣٢c.getCurrentItem() + 1, 1, c.this.f١٥٢٤٤o, this.f١٥٢٥٤a, this.f١٥٢٥٥b);
                } else {
                    c cVar8 = c.this;
                    cVar8.E(cVar8.f١٥٢٤٥p, c.this.f١٥٢٣٢c.getCurrentItem() + 1, 1, 31, this.f١٥٢٥٤a, this.f١٥٢٥٥b);
                }
            } else {
                c cVar9 = c.this;
                cVar9.E(cVar9.f١٥٢٤٥p, i11, 1, 31, this.f١٥٢٥٤a, this.f١٥٢٥٥b);
            }
            if (c.this.f١٥٢٤٨s != null) {
                c.this.f١٥٢٤٨s.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class e implements l5.b {
        e() {
        }

        @Override // l5.b
        public void a(int i10) {
            c.this.f١٥٢٤٨s.a();
        }
    }

    public c(View view, boolean[] zArr, int i10, int i11) {
        this.f١٥٢٣٠a = view;
        this.f١٥٢٣٨i = zArr;
        this.f١٥٢٣٧h = i10;
        this.f١٥٢٤٦q = i11;
    }

    private void A(int i10, int i11, int i12, boolean z10, int i13, int i14, int i15) {
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        WheelView wheelView = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.year);
        this.f١٥٢٣١b = wheelView;
        wheelView.setAdapter(new e4.a(i4.a.e(this.f١٥٢٣٩j, this.f١٥٢٤٠k)));
        this.f١٥٢٣١b.setLabel("");
        this.f١٥٢٣١b.setCurrentItem(i10 - this.f١٥٢٣٩j);
        this.f١٥٢٣١b.setGravity(this.f١٥٢٣٧h);
        WheelView wheelView2 = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.month);
        this.f١٥٢٣٢c = wheelView2;
        wheelView2.setAdapter(new e4.a(i4.a.d(i10)));
        this.f١٥٢٣٢c.setLabel("");
        int g10 = i4.a.g(i10);
        if (g10 != 0 && (i11 > g10 - 1 || z10)) {
            this.f١٥٢٣٢c.setCurrentItem(i11 + 1);
        } else {
            this.f١٥٢٣٢c.setCurrentItem(i11);
        }
        this.f١٥٢٣٢c.setGravity(this.f١٥٢٣٧h);
        this.f١٥٢٣٣d = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.day);
        if (i4.a.g(i10) == 0) {
            this.f١٥٢٣٣d.setAdapter(new e4.a(i4.a.b(i4.a.h(i10, i11))));
        } else {
            this.f١٥٢٣٣d.setAdapter(new e4.a(i4.a.b(i4.a.f(i10))));
        }
        this.f١٥٢٣٣d.setLabel("");
        this.f١٥٢٣٣d.setCurrentItem(i12 - 1);
        this.f١٥٢٣٣d.setGravity(this.f١٥٢٣٧h);
        WheelView wheelView3 = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.hour);
        this.f١٥٢٣٤e = wheelView3;
        int i21 = 0;
        wheelView3.setAdapter(new e4.b(0, 23));
        this.f١٥٢٣٤e.setCurrentItem(i13);
        this.f١٥٢٣٤e.setGravity(this.f١٥٢٣٧h);
        WheelView wheelView4 = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.min);
        this.f١٥٢٣٥f = wheelView4;
        wheelView4.setAdapter(new e4.b(0, 59));
        this.f١٥٢٣٥f.setCurrentItem(i14);
        this.f١٥٢٣٥f.setGravity(this.f١٥٢٣٧h);
        WheelView wheelView5 = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.second);
        this.f١٥٢٣٦g = wheelView5;
        wheelView5.setAdapter(new e4.b(0, 59));
        this.f١٥٢٣٦g.setCurrentItem(i14);
        this.f١٥٢٣٦g.setGravity(this.f١٥٢٣٧h);
        this.f١٥٢٣١b.setOnItemSelectedListener(new a());
        this.f١٥٢٣٢c.setOnItemSelectedListener(new b());
        r(this.f١٥٢٣٣d);
        r(this.f١٥٢٣٤e);
        r(this.f١٥٢٣٥f);
        r(this.f١٥٢٣٦g);
        boolean[] zArr = this.f١٥٢٣٨i;
        if (zArr.length == 6) {
            WheelView wheelView6 = this.f١٥٢٣١b;
            if (zArr[0]) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            wheelView6.setVisibility(i16);
            WheelView wheelView7 = this.f١٥٢٣٢c;
            if (this.f١٥٢٣٨i[1]) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            wheelView7.setVisibility(i17);
            WheelView wheelView8 = this.f١٥٢٣٣d;
            if (this.f١٥٢٣٨i[2]) {
                i18 = 0;
            } else {
                i18 = 8;
            }
            wheelView8.setVisibility(i18);
            WheelView wheelView9 = this.f١٥٢٣٤e;
            if (this.f١٥٢٣٨i[3]) {
                i19 = 0;
            } else {
                i19 = 8;
            }
            wheelView9.setVisibility(i19);
            WheelView wheelView10 = this.f١٥٢٣٥f;
            if (this.f١٥٢٣٨i[4]) {
                i20 = 0;
            } else {
                i20 = 8;
            }
            wheelView10.setVisibility(i20);
            WheelView wheelView11 = this.f١٥٢٣٦g;
            if (!this.f١٥٢٣٨i[5]) {
                i21 = 8;
            }
            wheelView11.setVisibility(i21);
            s();
            return;
        }
        throw new RuntimeException("type[] length is not 6");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(int i10, int i11, int i12, int i13, List list, List list2) {
        int currentItem = this.f١٥٢٣٣d.getCurrentItem();
        if (list.contains(String.valueOf(i11))) {
            if (i13 > 31) {
                i13 = 31;
            }
            this.f١٥٢٣٣d.setAdapter(new e4.b(i12, i13));
        } else if (list2.contains(String.valueOf(i11))) {
            if (i13 > 30) {
                i13 = 30;
            }
            this.f١٥٢٣٣d.setAdapter(new e4.b(i12, i13));
        } else if ((i10 % 4 == 0 && i10 % 100 != 0) || i10 % 400 == 0) {
            if (i13 > 29) {
                i13 = 29;
            }
            this.f١٥٢٣٣d.setAdapter(new e4.b(i12, i13));
        } else {
            if (i13 > 28) {
                i13 = 28;
            }
            this.f١٥٢٣٣d.setAdapter(new e4.b(i12, i13));
        }
        if (currentItem > this.f١٥٢٣٣d.getAdapter().a() - 1) {
            this.f١٥٢٣٣d.setCurrentItem(this.f١٥٢٣٣d.getAdapter().a() - 1);
        }
    }

    private void G(int i10, int i11, int i12, int i13, int i14, int i15) {
        boolean z10;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        List asList = Arrays.asList("1", "3", "5", "7", "8", "10", "12");
        List asList2 = Arrays.asList("4", "6", "9", "11");
        this.f١٥٢٤٥p = i10;
        WheelView wheelView = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.year);
        this.f١٥٢٣١b = wheelView;
        wheelView.setAdapter(new e4.b(this.f١٥٢٣٩j, this.f١٥٢٤٠k));
        this.f١٥٢٣١b.setCurrentItem(i10 - this.f١٥٢٣٩j);
        this.f١٥٢٣١b.setGravity(this.f١٥٢٣٧h);
        WheelView wheelView2 = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.month);
        this.f١٥٢٣٢c = wheelView2;
        int i23 = this.f١٥٢٣٩j;
        int i24 = this.f١٥٢٤٠k;
        if (i23 == i24) {
            wheelView2.setAdapter(new e4.b(this.f١٥٢٤١l, this.f١٥٢٤٢m));
            this.f١٥٢٣٢c.setCurrentItem((i11 + 1) - this.f١٥٢٤١l);
        } else if (i10 == i23) {
            wheelView2.setAdapter(new e4.b(this.f١٥٢٤١l, 12));
            this.f١٥٢٣٢c.setCurrentItem((i11 + 1) - this.f١٥٢٤١l);
        } else if (i10 == i24) {
            wheelView2.setAdapter(new e4.b(1, this.f١٥٢٤٢m));
            this.f١٥٢٣٢c.setCurrentItem(i11);
        } else {
            wheelView2.setAdapter(new e4.b(1, 12));
            this.f١٥٢٣٢c.setCurrentItem(i11);
        }
        this.f١٥٢٣٢c.setGravity(this.f١٥٢٣٧h);
        this.f١٥٢٣٣d = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.day);
        int i25 = 0;
        if ((i10 % 4 == 0 && i10 % 100 != 0) || i10 % 400 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i26 = this.f١٥٢٣٩j;
        int i27 = this.f١٥٢٤٠k;
        int i28 = 28;
        if (i26 == i27 && this.f١٥٢٤١l == this.f١٥٢٤٢m) {
            int i29 = i11 + 1;
            if (asList.contains(String.valueOf(i29))) {
                if (this.f١٥٢٤٤o > 31) {
                    this.f١٥٢٤٤o = 31;
                }
                this.f١٥٢٣٣d.setAdapter(new e4.b(this.f١٥٢٤٣n, this.f١٥٢٤٤o));
            } else if (asList2.contains(String.valueOf(i29))) {
                if (this.f١٥٢٤٤o > 30) {
                    this.f١٥٢٤٤o = 30;
                }
                this.f١٥٢٣٣d.setAdapter(new e4.b(this.f١٥٢٤٣n, this.f١٥٢٤٤o));
            } else if (z10) {
                if (this.f١٥٢٤٤o > 29) {
                    this.f١٥٢٤٤o = 29;
                }
                this.f١٥٢٣٣d.setAdapter(new e4.b(this.f١٥٢٤٣n, this.f١٥٢٤٤o));
            } else {
                if (this.f١٥٢٤٤o > 28) {
                    this.f١٥٢٤٤o = 28;
                }
                this.f١٥٢٣٣d.setAdapter(new e4.b(this.f١٥٢٤٣n, this.f١٥٢٤٤o));
            }
            this.f١٥٢٣٣d.setCurrentItem(i12 - this.f١٥٢٤٣n);
        } else if (i10 == i26 && (i17 = i11 + 1) == this.f١٥٢٤١l) {
            if (asList.contains(String.valueOf(i17))) {
                this.f١٥٢٣٣d.setAdapter(new e4.b(this.f١٥٢٤٣n, 31));
            } else if (asList2.contains(String.valueOf(i17))) {
                this.f١٥٢٣٣d.setAdapter(new e4.b(this.f١٥٢٤٣n, 30));
            } else {
                WheelView wheelView3 = this.f١٥٢٣٣d;
                int i30 = this.f١٥٢٤٣n;
                if (z10) {
                    i28 = 29;
                }
                wheelView3.setAdapter(new e4.b(i30, i28));
            }
            this.f١٥٢٣٣d.setCurrentItem(i12 - this.f١٥٢٤٣n);
        } else if (i10 == i27 && (i16 = i11 + 1) == this.f١٥٢٤٢m) {
            if (asList.contains(String.valueOf(i16))) {
                if (this.f١٥٢٤٤o > 31) {
                    this.f١٥٢٤٤o = 31;
                }
                this.f١٥٢٣٣d.setAdapter(new e4.b(1, this.f١٥٢٤٤o));
            } else if (asList2.contains(String.valueOf(i16))) {
                if (this.f١٥٢٤٤o > 30) {
                    this.f١٥٢٤٤o = 30;
                }
                this.f١٥٢٣٣d.setAdapter(new e4.b(1, this.f١٥٢٤٤o));
            } else if (z10) {
                if (this.f١٥٢٤٤o > 29) {
                    this.f١٥٢٤٤o = 29;
                }
                this.f١٥٢٣٣d.setAdapter(new e4.b(1, this.f١٥٢٤٤o));
            } else {
                if (this.f١٥٢٤٤o > 28) {
                    this.f١٥٢٤٤o = 28;
                }
                this.f١٥٢٣٣d.setAdapter(new e4.b(1, this.f١٥٢٤٤o));
            }
            this.f١٥٢٣٣d.setCurrentItem(i12 - 1);
        } else {
            int i31 = i11 + 1;
            if (asList.contains(String.valueOf(i31))) {
                this.f١٥٢٣٣d.setAdapter(new e4.b(1, 31));
            } else if (asList2.contains(String.valueOf(i31))) {
                this.f١٥٢٣٣d.setAdapter(new e4.b(1, 30));
            } else {
                WheelView wheelView4 = this.f١٥٢٣٣d;
                int i32 = this.f١٥٢٤٣n;
                if (z10) {
                    i28 = 29;
                }
                wheelView4.setAdapter(new e4.b(i32, i28));
            }
            this.f١٥٢٣٣d.setCurrentItem(i12 - 1);
        }
        this.f١٥٢٣٣d.setGravity(this.f١٥٢٣٧h);
        WheelView wheelView5 = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.hour);
        this.f١٥٢٣٤e = wheelView5;
        wheelView5.setAdapter(new e4.b(0, 23));
        this.f١٥٢٣٤e.setCurrentItem(i13);
        this.f١٥٢٣٤e.setGravity(this.f١٥٢٣٧h);
        WheelView wheelView6 = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.min);
        this.f١٥٢٣٥f = wheelView6;
        wheelView6.setAdapter(new e4.b(0, 59));
        this.f١٥٢٣٥f.setCurrentItem(i14);
        this.f١٥٢٣٥f.setGravity(this.f١٥٢٣٧h);
        WheelView wheelView7 = (WheelView) this.f١٥٢٣٠a.findViewById(R.id.second);
        this.f١٥٢٣٦g = wheelView7;
        wheelView7.setAdapter(new e4.b(0, 59));
        this.f١٥٢٣٦g.setCurrentItem(i15);
        this.f١٥٢٣٦g.setGravity(this.f١٥٢٣٧h);
        this.f١٥٢٣١b.setOnItemSelectedListener(new C٠١٧٢c(asList, asList2));
        this.f١٥٢٣٢c.setOnItemSelectedListener(new d(asList, asList2));
        r(this.f١٥٢٣٣d);
        r(this.f١٥٢٣٤e);
        r(this.f١٥٢٣٥f);
        r(this.f١٥٢٣٦g);
        boolean[] zArr = this.f١٥٢٣٨i;
        if (zArr.length == 6) {
            WheelView wheelView8 = this.f١٥٢٣١b;
            if (zArr[0]) {
                i18 = 0;
            } else {
                i18 = 8;
            }
            wheelView8.setVisibility(i18);
            WheelView wheelView9 = this.f١٥٢٣٢c;
            if (this.f١٥٢٣٨i[1]) {
                i19 = 0;
            } else {
                i19 = 8;
            }
            wheelView9.setVisibility(i19);
            WheelView wheelView10 = this.f١٥٢٣٣d;
            if (this.f١٥٢٣٨i[2]) {
                i20 = 0;
            } else {
                i20 = 8;
            }
            wheelView10.setVisibility(i20);
            WheelView wheelView11 = this.f١٥٢٣٤e;
            if (this.f١٥٢٣٨i[3]) {
                i21 = 0;
            } else {
                i21 = 8;
            }
            wheelView11.setVisibility(i21);
            WheelView wheelView12 = this.f١٥٢٣٥f;
            if (this.f١٥٢٣٨i[4]) {
                i22 = 0;
            } else {
                i22 = 8;
            }
            wheelView12.setVisibility(i22);
            WheelView wheelView13 = this.f١٥٢٣٦g;
            if (!this.f١٥٢٣٨i[5]) {
                i25 = 8;
            }
            wheelView13.setVisibility(i25);
            s();
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    private String n() {
        int currentItem;
        boolean z10;
        int currentItem2;
        StringBuilder sb = new StringBuilder();
        int currentItem3 = this.f١٥٢٣١b.getCurrentItem() + this.f١٥٢٣٩j;
        if (i4.a.g(currentItem3) == 0) {
            currentItem2 = this.f١٥٢٣٢c.getCurrentItem();
        } else if ((this.f١٥٢٣٢c.getCurrentItem() + 1) - i4.a.g(currentItem3) <= 0) {
            currentItem2 = this.f١٥٢٣٢c.getCurrentItem();
        } else {
            if ((this.f١٥٢٣٢c.getCurrentItem() + 1) - i4.a.g(currentItem3) == 1) {
                currentItem = this.f١٥٢٣٢c.getCurrentItem();
                z10 = true;
                int[] b10 = i4.b.b(currentItem3, currentItem, this.f١٥٢٣٣d.getCurrentItem() + 1, z10);
                sb.append(b10[0]);
                sb.append("-");
                sb.append(b10[1]);
                sb.append("-");
                sb.append(b10[2]);
                sb.append(" ");
                sb.append(this.f١٥٢٣٤e.getCurrentItem());
                sb.append(CertificateUtil.DELIMITER);
                sb.append(this.f١٥٢٣٥f.getCurrentItem());
                sb.append(CertificateUtil.DELIMITER);
                sb.append(this.f١٥٢٣٦g.getCurrentItem());
                return sb.toString();
            }
            currentItem = this.f١٥٢٣٢c.getCurrentItem();
            z10 = false;
            int[] b102 = i4.b.b(currentItem3, currentItem, this.f١٥٢٣٣d.getCurrentItem() + 1, z10);
            sb.append(b102[0]);
            sb.append("-");
            sb.append(b102[1]);
            sb.append("-");
            sb.append(b102[2]);
            sb.append(" ");
            sb.append(this.f١٥٢٣٤e.getCurrentItem());
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.f١٥٢٣٥f.getCurrentItem());
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.f١٥٢٣٦g.getCurrentItem());
            return sb.toString();
        }
        currentItem = currentItem2 + 1;
        z10 = false;
        int[] b1022 = i4.b.b(currentItem3, currentItem, this.f١٥٢٣٣d.getCurrentItem() + 1, z10);
        sb.append(b1022[0]);
        sb.append("-");
        sb.append(b1022[1]);
        sb.append("-");
        sb.append(b1022[2]);
        sb.append(" ");
        sb.append(this.f١٥٢٣٤e.getCurrentItem());
        sb.append(CertificateUtil.DELIMITER);
        sb.append(this.f١٥٢٣٥f.getCurrentItem());
        sb.append(CertificateUtil.DELIMITER);
        sb.append(this.f١٥٢٣٦g.getCurrentItem());
        return sb.toString();
    }

    private void r(WheelView wheelView) {
        if (this.f١٥٢٤٨s != null) {
            wheelView.setOnItemSelectedListener(new e());
        }
    }

    private void s() {
        this.f١٥٢٣٣d.setTextSize(this.f١٥٢٤٦q);
        this.f١٥٢٣٢c.setTextSize(this.f١٥٢٤٦q);
        this.f١٥٢٣١b.setTextSize(this.f١٥٢٤٦q);
        this.f١٥٢٣٤e.setTextSize(this.f١٥٢٤٦q);
        this.f١٥٢٣٥f.setTextSize(this.f١٥٢٤٦q);
        this.f١٥٢٣٦g.setTextSize(this.f١٥٢٤٦q);
    }

    public void B(boolean z10) {
        this.f١٥٢٤٧r = z10;
    }

    public void C(int i10, int i11, int i12, int i13, int i14, int i15) {
        boolean z10;
        if (this.f١٥٢٤٧r) {
            int[] d10 = i4.b.d(i10, i11 + 1, i12);
            int i16 = d10[0];
            int i17 = d10[1] - 1;
            int i18 = d10[2];
            if (d10[3] == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            A(i16, i17, i18, z10, i13, i14, i15);
            return;
        }
        G(i10, i11, i12, i13, i14, i15);
    }

    public void D(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i10 = calendar2.get(1);
            int i11 = calendar2.get(2) + 1;
            int i12 = calendar2.get(5);
            int i13 = this.f١٥٢٣٩j;
            if (i10 > i13) {
                this.f١٥٢٤٠k = i10;
                this.f١٥٢٤٢m = i11;
                this.f١٥٢٤٤o = i12;
                return;
            } else {
                if (i10 == i13) {
                    int i14 = this.f١٥٢٤١l;
                    if (i11 > i14) {
                        this.f١٥٢٤٠k = i10;
                        this.f١٥٢٤٢m = i11;
                        this.f١٥٢٤٤o = i12;
                        return;
                    } else {
                        if (i11 == i14 && i12 > this.f١٥٢٤٣n) {
                            this.f١٥٢٤٠k = i10;
                            this.f١٥٢٤٢m = i11;
                            this.f١٥٢٤٤o = i12;
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (calendar != null && calendar2 == null) {
            int i15 = calendar.get(1);
            int i16 = calendar.get(2) + 1;
            int i17 = calendar.get(5);
            int i18 = this.f١٥٢٤٠k;
            if (i15 < i18) {
                this.f١٥٢٤١l = i16;
                this.f١٥٢٤٣n = i17;
                this.f١٥٢٣٩j = i15;
                return;
            } else {
                if (i15 == i18) {
                    int i19 = this.f١٥٢٤٢m;
                    if (i16 < i19) {
                        this.f١٥٢٤١l = i16;
                        this.f١٥٢٤٣n = i17;
                        this.f١٥٢٣٩j = i15;
                        return;
                    } else {
                        if (i16 == i19 && i17 < this.f١٥٢٤٤o) {
                            this.f١٥٢٤١l = i16;
                            this.f١٥٢٤٣n = i17;
                            this.f١٥٢٣٩j = i15;
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (calendar != null && calendar2 != null) {
            this.f١٥٢٣٩j = calendar.get(1);
            this.f١٥٢٤٠k = calendar2.get(1);
            this.f١٥٢٤١l = calendar.get(2) + 1;
            this.f١٥٢٤٢m = calendar2.get(2) + 1;
            this.f١٥٢٤٣n = calendar.get(5);
            this.f١٥٢٤٤o = calendar2.get(5);
        }
    }

    public void F(h4.b bVar) {
        this.f١٥٢٤٨s = bVar;
    }

    public void H(int i10) {
        this.f١٥٢٣٩j = i10;
    }

    public void I(int i10) {
        this.f١٥٢٣٣d.setTextColorCenter(i10);
        this.f١٥٢٣٢c.setTextColorCenter(i10);
        this.f١٥٢٣١b.setTextColorCenter(i10);
        this.f١٥٢٣٤e.setTextColorCenter(i10);
        this.f١٥٢٣٥f.setTextColorCenter(i10);
        this.f١٥٢٣٦g.setTextColorCenter(i10);
    }

    public void J(int i10) {
        this.f١٥٢٣٣d.setTextColorOut(i10);
        this.f١٥٢٣٢c.setTextColorOut(i10);
        this.f١٥٢٣١b.setTextColorOut(i10);
        this.f١٥٢٣٤e.setTextColorOut(i10);
        this.f١٥٢٣٥f.setTextColorOut(i10);
        this.f١٥٢٣٦g.setTextColorOut(i10);
    }

    public void K(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f١٥٢٣١b.setTextXOffset(i10);
        this.f١٥٢٣٢c.setTextXOffset(i11);
        this.f١٥٢٣٣d.setTextXOffset(i12);
        this.f١٥٢٣٤e.setTextXOffset(i13);
        this.f١٥٢٣٥f.setTextXOffset(i14);
        this.f١٥٢٣٦g.setTextXOffset(i15);
    }

    public String o() {
        if (this.f١٥٢٤٧r) {
            return n();
        }
        StringBuilder sb = new StringBuilder();
        if (this.f١٥٢٤٥p == this.f١٥٢٣٩j) {
            int currentItem = this.f١٥٢٣٢c.getCurrentItem();
            int i10 = this.f١٥٢٤١l;
            if (currentItem + i10 == i10) {
                sb.append(this.f١٥٢٣١b.getCurrentItem() + this.f١٥٢٣٩j);
                sb.append("-");
                sb.append(this.f١٥٢٣٢c.getCurrentItem() + this.f١٥٢٤١l);
                sb.append("-");
                sb.append(this.f١٥٢٣٣d.getCurrentItem() + this.f١٥٢٤٣n);
                sb.append(" ");
                sb.append(this.f١٥٢٣٤e.getCurrentItem());
                sb.append(CertificateUtil.DELIMITER);
                sb.append(this.f١٥٢٣٥f.getCurrentItem());
                sb.append(CertificateUtil.DELIMITER);
                sb.append(this.f١٥٢٣٦g.getCurrentItem());
            } else {
                sb.append(this.f١٥٢٣١b.getCurrentItem() + this.f١٥٢٣٩j);
                sb.append("-");
                sb.append(this.f١٥٢٣٢c.getCurrentItem() + this.f١٥٢٤١l);
                sb.append("-");
                sb.append(this.f١٥٢٣٣d.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f١٥٢٣٤e.getCurrentItem());
                sb.append(CertificateUtil.DELIMITER);
                sb.append(this.f١٥٢٣٥f.getCurrentItem());
                sb.append(CertificateUtil.DELIMITER);
                sb.append(this.f١٥٢٣٦g.getCurrentItem());
            }
        } else {
            sb.append(this.f١٥٢٣١b.getCurrentItem() + this.f١٥٢٣٩j);
            sb.append("-");
            sb.append(this.f١٥٢٣٢c.getCurrentItem() + 1);
            sb.append("-");
            sb.append(this.f١٥٢٣٣d.getCurrentItem() + 1);
            sb.append(" ");
            sb.append(this.f١٥٢٣٤e.getCurrentItem());
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.f١٥٢٣٥f.getCurrentItem());
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.f١٥٢٣٦g.getCurrentItem());
        }
        return sb.toString();
    }

    public void p(boolean z10) {
        this.f١٥٢٣٣d.i(z10);
        this.f١٥٢٣٢c.i(z10);
        this.f١٥٢٣١b.i(z10);
        this.f١٥٢٣٤e.i(z10);
        this.f١٥٢٣٥f.i(z10);
        this.f١٥٢٣٦g.i(z10);
    }

    public void q(boolean z10) {
        this.f١٥٢٣٣d.setAlphaGradient(z10);
        this.f١٥٢٣٢c.setAlphaGradient(z10);
        this.f١٥٢٣١b.setAlphaGradient(z10);
        this.f١٥٢٣٤e.setAlphaGradient(z10);
        this.f١٥٢٣٥f.setAlphaGradient(z10);
        this.f١٥٢٣٦g.setAlphaGradient(z10);
    }

    public void t(boolean z10) {
        this.f١٥٢٣١b.setCyclic(z10);
        this.f١٥٢٣٢c.setCyclic(z10);
        this.f١٥٢٣٣d.setCyclic(z10);
        this.f١٥٢٣٤e.setCyclic(z10);
        this.f١٥٢٣٥f.setCyclic(z10);
        this.f١٥٢٣٦g.setCyclic(z10);
    }

    public void u(int i10) {
        this.f١٥٢٣٣d.setDividerColor(i10);
        this.f١٥٢٣٢c.setDividerColor(i10);
        this.f١٥٢٣١b.setDividerColor(i10);
        this.f١٥٢٣٤e.setDividerColor(i10);
        this.f١٥٢٣٥f.setDividerColor(i10);
        this.f١٥٢٣٦g.setDividerColor(i10);
    }

    public void v(WheelView.c cVar) {
        this.f١٥٢٣٣d.setDividerType(cVar);
        this.f١٥٢٣٢c.setDividerType(cVar);
        this.f١٥٢٣١b.setDividerType(cVar);
        this.f١٥٢٣٤e.setDividerType(cVar);
        this.f١٥٢٣٥f.setDividerType(cVar);
        this.f١٥٢٣٦g.setDividerType(cVar);
    }

    public void w(int i10) {
        this.f١٥٢٤٠k = i10;
    }

    public void x(int i10) {
        this.f١٥٢٣٣d.setItemsVisibleCount(i10);
        this.f١٥٢٣٢c.setItemsVisibleCount(i10);
        this.f١٥٢٣١b.setItemsVisibleCount(i10);
        this.f١٥٢٣٤e.setItemsVisibleCount(i10);
        this.f١٥٢٣٥f.setItemsVisibleCount(i10);
        this.f١٥٢٣٦g.setItemsVisibleCount(i10);
    }

    public void y(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.f١٥٢٤٧r) {
            return;
        }
        if (str != null) {
            this.f١٥٢٣١b.setLabel(str);
        } else {
            this.f١٥٢٣١b.setLabel(this.f١٥٢٣٠a.getContext().getString(R.string.pickerview_year));
        }
        if (str2 != null) {
            this.f١٥٢٣٢c.setLabel(str2);
        } else {
            this.f١٥٢٣٢c.setLabel(this.f١٥٢٣٠a.getContext().getString(R.string.pickerview_month));
        }
        if (str3 != null) {
            this.f١٥٢٣٣d.setLabel(str3);
        } else {
            this.f١٥٢٣٣d.setLabel(this.f١٥٢٣٠a.getContext().getString(R.string.pickerview_day));
        }
        if (str4 != null) {
            this.f١٥٢٣٤e.setLabel(str4);
        } else {
            this.f١٥٢٣٤e.setLabel(this.f١٥٢٣٠a.getContext().getString(R.string.pickerview_hours));
        }
        if (str5 != null) {
            this.f١٥٢٣٥f.setLabel(str5);
        } else {
            this.f١٥٢٣٥f.setLabel(this.f١٥٢٣٠a.getContext().getString(R.string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f١٥٢٣٦g.setLabel(str6);
        } else {
            this.f١٥٢٣٦g.setLabel(this.f١٥٢٣٠a.getContext().getString(R.string.pickerview_seconds));
        }
    }

    public void z(float f10) {
        this.f١٥٢٣٣d.setLineSpacingMultiplier(f10);
        this.f١٥٢٣٢c.setLineSpacingMultiplier(f10);
        this.f١٥٢٣١b.setLineSpacingMultiplier(f10);
        this.f١٥٢٣٤e.setLineSpacingMultiplier(f10);
        this.f١٥٢٣٥f.setLineSpacingMultiplier(f10);
        this.f١٥٢٣٦g.setLineSpacingMultiplier(f10);
    }
}

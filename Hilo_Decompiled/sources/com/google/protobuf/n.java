package com.google.protobuf;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.protobuf.b0;
import com.google.protobuf.b1;
import com.google.protobuf.e1;
import com.google.protobuf.e2;
import com.google.protobuf.j0;
import com.google.protobuf.m;
import com.google.protobuf.r2;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import kotlin.text.Typography;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f١١٧١٩a = Logger.getLogger(n.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f١١٧٢٠b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    private static final b[] f١١٧٢١c = new b[0];

    /* renamed from: d, reason: collision with root package name */
    private static final g[] f١١٧٢٢d = new g[0];

    /* renamed from: e, reason: collision with root package name */
    private static final e[] f١١٧٢٣e = new e[0];

    /* renamed from: f, reason: collision with root package name */
    private static final m[] f١١٧٢٤f = new m[0];

    /* renamed from: g, reason: collision with root package name */
    private static final l[] f١١٧٢٥g = new l[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١١٧٢٦a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f١١٧٢٧b;

        static {
            int[] iArr = new int[g.b.values().length];
            f١١٧٢٧b = iArr;
            try {
                iArr[g.b.ENUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١١٧٢٧b[g.b.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[g.c.values().length];
            f١١٧٢٦a = iArr2;
            try {
                iArr2[g.c.f١١٨٠١f.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨١٣r.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨١١p.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨٠٩n.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨٠٣h.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٧٩٩d.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨١٤s.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨١٢q.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨٠٠e.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨٠٢g.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٧٩٨c.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٧٩٧b.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨٠٤i.ordinal()] = 13;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨٠٥j.ordinal()] = 14;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨٠٨m.ordinal()] = 15;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨١٠o.ordinal()] = 16;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨٠٧l.ordinal()] = 17;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f١١٧٢٦a[g.c.f١١٨٠٦k.ordinal()] = 18;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b extends i {

        /* renamed from: a, reason: collision with root package name */
        private final int f١١٧٢٨a;

        /* renamed from: b, reason: collision with root package name */
        private m.b f١١٧٢٩b;

        /* renamed from: c, reason: collision with root package name */
        private final String f١١٧٣٠c;

        /* renamed from: d, reason: collision with root package name */
        private final h f١١٧٣١d;

        /* renamed from: e, reason: collision with root package name */
        private final b f١١٧٣٢e;

        /* renamed from: f, reason: collision with root package name */
        private final b[] f١١٧٣٣f;

        /* renamed from: g, reason: collision with root package name */
        private final e[] f١١٧٣٤g;

        /* renamed from: h, reason: collision with root package name */
        private final g[] f١١٧٣٥h;

        /* renamed from: i, reason: collision with root package name */
        private final g[] f١١٧٣٦i;

        /* renamed from: j, reason: collision with root package name */
        private final g[] f١١٧٣٧j;

        /* renamed from: k, reason: collision with root package name */
        private final l[] f١١٧٣٨k;

        /* renamed from: l, reason: collision with root package name */
        private final int f١١٧٣٩l;

        /* renamed from: m, reason: collision with root package name */
        private final int[] f١١٧٤٠m;

        /* renamed from: n, reason: collision with root package name */
        private final int[] f١١٧٤١n;

        /* synthetic */ b(m.b bVar, h hVar, b bVar2, int i10, a aVar) {
            this(bVar, hVar, bVar2, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            for (b bVar : this.f١١٧٣٣f) {
                bVar.g();
            }
            for (g gVar : this.f١١٧٣٥h) {
                gVar.j();
            }
            Arrays.sort(this.f١١٧٣٦i);
            q();
            for (g gVar2 : this.f١١٧٣٧j) {
                gVar2.j();
            }
        }

        private void q() {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                g[] gVarArr = this.f١١٧٣٦i;
                if (i11 < gVarArr.length) {
                    g gVar = gVarArr[i10];
                    g gVar2 = gVarArr[i11];
                    if (gVar.getNumber() != gVar2.getNumber()) {
                        i10 = i11;
                    } else {
                        throw new d(gVar2, "Field number " + gVar2.getNumber() + " has already been used in \"" + gVar2.l().c() + "\" by field \"" + gVar.d() + "\".", (a) null);
                    }
                } else {
                    return;
                }
            }
        }

        @Override // com.google.protobuf.n.i
        public h a() {
            return this.f١١٧٣١d;
        }

        @Override // com.google.protobuf.n.i
        public String c() {
            return this.f١١٧٣٠c;
        }

        @Override // com.google.protobuf.n.i
        public String d() {
            return this.f١١٧٢٩b.getName();
        }

        public g h(String str) {
            i c10 = this.f١١٧٣١d.f١١٨٢٥h.c(this.f١١٧٣٠c + '.' + str);
            if (c10 instanceof g) {
                return (g) c10;
            }
            return null;
        }

        public g i(int i10) {
            g[] gVarArr = this.f١١٧٣٦i;
            return (g) n.j(gVarArr, gVarArr.length, g.f١١٧٧٢m, i10);
        }

        public List j() {
            return Collections.unmodifiableList(Arrays.asList(this.f١١٧٣٥h));
        }

        public List k() {
            return Collections.unmodifiableList(Arrays.asList(this.f١١٧٣٣f));
        }

        public List l() {
            return Collections.unmodifiableList(Arrays.asList(this.f١١٧٣٨k));
        }

        public m.l m() {
            return this.f١١٧٢٩b.a0();
        }

        public boolean n() {
            return !this.f١١٧٢٩b.Q().isEmpty();
        }

        public boolean o(int i10) {
            int binarySearch = Arrays.binarySearch(this.f١١٧٤٠m, i10);
            if (binarySearch < 0) {
                binarySearch = (~binarySearch) - 1;
            }
            if (binarySearch >= 0 && i10 < this.f١١٧٤١n[binarySearch]) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.n.i
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public m.b e() {
            return this.f١١٧٢٩b;
        }

        b(String str) {
            super(null);
            String str2;
            String str3;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str3 = str.substring(lastIndexOf + 1);
                str2 = str.substring(0, lastIndexOf);
            } else {
                str2 = "";
                str3 = str;
            }
            this.f١١٧٢٨a = 0;
            this.f١١٧٢٩b = m.b.h0().X(str3).e(m.b.c.y().v(1).t(536870912).build()).build();
            this.f١١٧٣٠c = str;
            this.f١١٧٣٢e = null;
            this.f١١٧٣٣f = n.f١١٧٢١c;
            this.f١١٧٣٤g = n.f١١٧٢٣e;
            this.f١١٧٣٥h = n.f١١٧٢٢d;
            this.f١١٧٣٦i = n.f١١٧٢٢d;
            this.f١١٧٣٧j = n.f١١٧٢٢d;
            this.f١١٧٣٨k = n.f١١٧٢٥g;
            this.f١١٧٣٩l = 0;
            this.f١١٧٣١d = new h(str2, this);
            this.f١١٧٤٠m = new int[]{1};
            this.f١١٧٤١n = new int[]{536870912};
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private b(m.b bVar, h hVar, b bVar2, int i10) {
            super(r0);
            l[] lVarArr;
            b[] bVarArr;
            e[] eVarArr;
            g[] gVarArr;
            g[] gVarArr2;
            a aVar = null;
            this.f١١٧٢٨a = i10;
            this.f١١٧٢٩b = bVar;
            this.f١١٧٣٠c = n.k(hVar, bVar2, bVar.getName());
            this.f١١٧٣١d = hVar;
            this.f١١٧٣٢e = bVar2;
            if (bVar.Y() <= 0) {
                lVarArr = n.f١١٧٢٥g;
            } else {
                lVarArr = new l[bVar.Y()];
            }
            this.f١١٧٣٨k = lVarArr;
            int i11 = 0;
            for (int i12 = 0; i12 < bVar.Y(); i12++) {
                this.f١١٧٣٨k[i12] = new l(bVar.X(i12), hVar, this, i12, null);
            }
            if (bVar.V() <= 0) {
                bVarArr = n.f١١٧٢١c;
            } else {
                bVarArr = new b[bVar.V()];
            }
            this.f١١٧٣٣f = bVarArr;
            for (int i13 = 0; i13 < bVar.V(); i13++) {
                this.f١١٧٣٣f[i13] = new b(bVar.U(i13), hVar, this, i13);
            }
            if (bVar.J() <= 0) {
                eVarArr = n.f١١٧٢٣e;
            } else {
                eVarArr = new e[bVar.J()];
            }
            this.f١١٧٣٤g = eVarArr;
            for (int i14 = 0; i14 < bVar.J(); i14++) {
                this.f١١٧٣٤g[i14] = new e(bVar.I(i14), hVar, this, i14, null);
            }
            if (bVar.S() <= 0) {
                gVarArr = n.f١١٧٢٢d;
            } else {
                gVarArr = new g[bVar.S()];
            }
            this.f١١٧٣٥h = gVarArr;
            for (int i15 = 0; i15 < bVar.S(); i15++) {
                this.f١١٧٣٥h[i15] = new g(bVar.R(i15), hVar, this, i15, false, null);
            }
            this.f١١٧٣٦i = bVar.S() > 0 ? (g[]) this.f١١٧٣٥h.clone() : n.f١١٧٢٢d;
            if (bVar.M() <= 0) {
                gVarArr2 = n.f١١٧٢٢d;
            } else {
                gVarArr2 = new g[bVar.M()];
            }
            this.f١١٧٣٧j = gVarArr2;
            for (int i16 = 0; i16 < bVar.M(); i16++) {
                this.f١١٧٣٧j[i16] = new g(bVar.L(i16), hVar, this, i16, true, null);
            }
            for (int i17 = 0; i17 < bVar.Y(); i17++) {
                l lVar = this.f١١٧٣٨k[i17];
                lVar.f١١٨٤٤g = new g[lVar.k()];
                this.f١١٧٣٨k[i17].f١١٨٤٣f = 0;
            }
            for (int i18 = 0; i18 < bVar.S(); i18++) {
                l k10 = this.f١١٧٣٥h[i18].k();
                if (k10 != null) {
                    k10.f١١٨٤٤g[l.i(k10)] = this.f١١٧٣٥h[i18];
                }
            }
            int i19 = 0;
            for (l lVar2 : this.f١١٧٣٨k) {
                if (lVar2.n()) {
                    i19++;
                } else if (i19 > 0) {
                    throw new d(this, "Synthetic oneofs must come last.", aVar);
                }
            }
            this.f١١٧٣٩l = this.f١١٧٣٨k.length - i19;
            hVar.f١١٨٢٥h.b(this);
            if (bVar.P() <= 0) {
                this.f١١٧٤٠m = n.f١١٧٢٠b;
                this.f١١٧٤١n = n.f١١٧٢٠b;
                return;
            }
            this.f١١٧٤٠m = new int[bVar.P()];
            this.f١١٧٤١n = new int[bVar.P()];
            for (m.b.c cVar : bVar.Q()) {
                this.f١١٧٤٠m[i11] = cVar.u();
                this.f١١٧٤١n[i11] = cVar.s();
                i11++;
            }
            Arrays.sort(this.f١١٧٤٠m);
            Arrays.sort(this.f١١٧٤١n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final Set f١١٧٤٢a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f١١٧٤٣b;

        /* renamed from: c, reason: collision with root package name */
        private final Map f١١٧٤٤c = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class a extends i {

            /* renamed from: a, reason: collision with root package name */
            private final String f١١٧٤٥a;

            /* renamed from: b, reason: collision with root package name */
            private final String f١١٧٤٦b;

            /* renamed from: c, reason: collision with root package name */
            private final h f١١٧٤٧c;

            a(String str, String str2, h hVar) {
                super(null);
                this.f١١٧٤٧c = hVar;
                this.f١١٧٤٦b = str2;
                this.f١١٧٤٥a = str;
            }

            @Override // com.google.protobuf.n.i
            public h a() {
                return this.f١١٧٤٧c;
            }

            @Override // com.google.protobuf.n.i
            public String c() {
                return this.f١١٧٤٦b;
            }

            @Override // com.google.protobuf.n.i
            public String d() {
                return this.f١١٧٤٥a;
            }

            @Override // com.google.protobuf.n.i
            public b1 e() {
                return this.f١١٧٤٧c.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum b {
            TYPES_ONLY,
            AGGREGATES_ONLY,
            ALL_SYMBOLS
        }

        c(h[] hVarArr, boolean z10) {
            this.f١١٧٤٢a = Collections.newSetFromMap(new IdentityHashMap(hVarArr.length));
            this.f١١٧٤٣b = z10;
            for (h hVar : hVarArr) {
                this.f١١٧٤٢a.add(hVar);
                e(hVar);
            }
            for (h hVar2 : this.f١١٧٤٢a) {
                try {
                    a(hVar2.l(), hVar2);
                } catch (d e10) {
                    throw new AssertionError(e10);
                }
            }
        }

        private void e(h hVar) {
            for (h hVar2 : hVar.m()) {
                if (this.f١١٧٤٢a.add(hVar2)) {
                    e(hVar2);
                }
            }
        }

        static void i(i iVar) {
            String d10 = iVar.d();
            a aVar = null;
            if (d10.length() != 0) {
                for (int i10 = 0; i10 < d10.length(); i10++) {
                    char charAt = d10.charAt(i10);
                    if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && charAt != '_' && ('0' > charAt || charAt > '9' || i10 <= 0))) {
                        throw new d(iVar, Typography.quote + d10 + "\" is not a valid identifier.", aVar);
                    }
                }
                return;
            }
            throw new d(iVar, "Missing name.", aVar);
        }

        void a(String str, h hVar) {
            String substring;
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                substring = str;
            } else {
                a(str.substring(0, lastIndexOf), hVar);
                substring = str.substring(lastIndexOf + 1);
            }
            i iVar = (i) this.f١١٧٤٤c.put(str, new a(substring, str, hVar));
            if (iVar != null) {
                this.f١١٧٤٤c.put(str, iVar);
                if (!(iVar instanceof a)) {
                    throw new d(hVar, Typography.quote + substring + "\" is already defined (as something other than a package) in file \"" + iVar.a().d() + "\".", (a) null);
                }
            }
        }

        void b(i iVar) {
            i(iVar);
            String c10 = iVar.c();
            i iVar2 = (i) this.f١١٧٤٤c.put(c10, iVar);
            if (iVar2 != null) {
                this.f١١٧٤٤c.put(c10, iVar2);
                a aVar = null;
                if (iVar.a() == iVar2.a()) {
                    int lastIndexOf = c10.lastIndexOf(46);
                    if (lastIndexOf == -1) {
                        throw new d(iVar, Typography.quote + c10 + "\" is already defined.", aVar);
                    }
                    throw new d(iVar, Typography.quote + c10.substring(lastIndexOf + 1) + "\" is already defined in \"" + c10.substring(0, lastIndexOf) + "\".", aVar);
                }
                throw new d(iVar, Typography.quote + c10 + "\" is already defined in file \"" + iVar2.a().d() + "\".", aVar);
            }
        }

        i c(String str) {
            return d(str, b.ALL_SYMBOLS);
        }

        i d(String str, b bVar) {
            i iVar = (i) this.f١١٧٤٤c.get(str);
            if (iVar != null && (bVar == b.ALL_SYMBOLS || ((bVar == b.TYPES_ONLY && g(iVar)) || (bVar == b.AGGREGATES_ONLY && f(iVar))))) {
                return iVar;
            }
            Iterator it = this.f١١٧٤٢a.iterator();
            while (it.hasNext()) {
                i iVar2 = (i) ((h) it.next()).f١١٨٢٥h.f١١٧٤٤c.get(str);
                if (iVar2 != null && (bVar == b.ALL_SYMBOLS || ((bVar == b.TYPES_ONLY && g(iVar2)) || (bVar == b.AGGREGATES_ONLY && f(iVar2))))) {
                    return iVar2;
                }
            }
            return null;
        }

        boolean f(i iVar) {
            if (!(iVar instanceof b) && !(iVar instanceof e) && !(iVar instanceof a) && !(iVar instanceof m)) {
                return false;
            }
            return true;
        }

        boolean g(i iVar) {
            if (!(iVar instanceof b) && !(iVar instanceof e)) {
                return false;
            }
            return true;
        }

        i h(String str, i iVar, b bVar) {
            String substring;
            i d10;
            String str2;
            if (str.startsWith(InstructionFileId.DOT)) {
                str2 = str.substring(1);
                d10 = d(str2, bVar);
            } else {
                int indexOf = str.indexOf(46);
                if (indexOf == -1) {
                    substring = str;
                } else {
                    substring = str.substring(0, indexOf);
                }
                StringBuilder sb = new StringBuilder(iVar.c());
                while (true) {
                    int lastIndexOf = sb.lastIndexOf(InstructionFileId.DOT);
                    if (lastIndexOf == -1) {
                        d10 = d(str, bVar);
                        str2 = str;
                        break;
                    }
                    int i10 = lastIndexOf + 1;
                    sb.setLength(i10);
                    sb.append(substring);
                    i d11 = d(sb.toString(), b.AGGREGATES_ONLY);
                    if (d11 != null) {
                        if (indexOf != -1) {
                            sb.setLength(i10);
                            sb.append(str);
                            d10 = d(sb.toString(), bVar);
                        } else {
                            d10 = d11;
                        }
                        str2 = sb.toString();
                    } else {
                        sb.setLength(lastIndexOf);
                    }
                }
            }
            if (d10 == null) {
                if (this.f١١٧٤٣b && bVar == b.TYPES_ONLY) {
                    n.f١١٧١٩a.warning("The descriptor for message type \"" + str + "\" cannot be found and a placeholder is created for it");
                    b bVar2 = new b(str2);
                    this.f١١٧٤٢a.add(bVar2.a());
                    return bVar2;
                }
                throw new d(iVar, Typography.quote + str + "\" is not defined.", (a) null);
            }
            return d10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;

        /* renamed from: a, reason: collision with root package name */
        private final String f١١٧٥٢a;

        /* renamed from: b, reason: collision with root package name */
        private final b1 f١١٧٥٣b;

        /* renamed from: c, reason: collision with root package name */
        private final String f١١٧٥٤c;

        /* synthetic */ d(h hVar, String str, a aVar) {
            this(hVar, str);
        }

        /* synthetic */ d(i iVar, String str, a aVar) {
            this(iVar, str);
        }

        /* synthetic */ d(i iVar, String str, Throwable th, a aVar) {
            this(iVar, str, th);
        }

        private d(i iVar, String str) {
            super(iVar.c() + ": " + str);
            this.f١١٧٥٢a = iVar.c();
            this.f١١٧٥٣b = iVar.e();
            this.f١١٧٥٤c = str;
        }

        private d(i iVar, String str, Throwable th) {
            this(iVar, str);
            initCause(th);
        }

        private d(h hVar, String str) {
            super(hVar.d() + ": " + str);
            this.f١١٧٥٢a = hVar.d();
            this.f١١٧٥٣b = hVar.e();
            this.f١١٧٥٤c = str;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class e extends i implements j0.d {

        /* renamed from: a, reason: collision with root package name */
        private final int f١١٧٥٥a;

        /* renamed from: b, reason: collision with root package name */
        private m.c f١١٧٥٦b;

        /* renamed from: c, reason: collision with root package name */
        private final String f١١٧٥٧c;

        /* renamed from: d, reason: collision with root package name */
        private final h f١١٧٥٨d;

        /* renamed from: e, reason: collision with root package name */
        private final b f١١٧٥٩e;

        /* renamed from: f, reason: collision with root package name */
        private final f[] f١١٧٦٠f;

        /* renamed from: g, reason: collision with root package name */
        private final f[] f١١٧٦١g;

        /* renamed from: h, reason: collision with root package name */
        private final int f١١٧٦٢h;

        /* renamed from: i, reason: collision with root package name */
        private Map f١١٧٦٣i;

        /* renamed from: j, reason: collision with root package name */
        private ReferenceQueue f١١٧٦٤j;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class a extends WeakReference {

            /* renamed from: a, reason: collision with root package name */
            private final int f١١٧٦٥a;

            /* synthetic */ a(int i10, f fVar, a aVar) {
                this(i10, fVar);
            }

            private a(int i10, f fVar) {
                super(fVar);
                this.f١١٧٦٥a = i10;
            }
        }

        /* synthetic */ e(m.c cVar, h hVar, b bVar, int i10, a aVar) {
            this(cVar, hVar, bVar, i10);
        }

        @Override // com.google.protobuf.n.i
        public h a() {
            return this.f١١٧٥٨d;
        }

        @Override // com.google.protobuf.n.i
        public String c() {
            return this.f١١٧٥٧c;
        }

        @Override // com.google.protobuf.n.i
        public String d() {
            return this.f١١٧٥٦b.getName();
        }

        public f g(String str) {
            i c10 = this.f١١٧٥٨d.f١١٨٢٥h.c(this.f١١٧٥٧c + '.' + str);
            if (c10 instanceof f) {
                return (f) c10;
            }
            return null;
        }

        public f h(int i10) {
            return (f) n.j(this.f١١٧٦١g, this.f١١٧٦٢h, f.f١١٧٦٧f, i10);
        }

        public f i(int i10) {
            f fVar;
            f h10 = h(i10);
            if (h10 != null) {
                return h10;
            }
            synchronized (this) {
                try {
                    if (this.f١١٧٦٤j == null) {
                        this.f١١٧٦٤j = new ReferenceQueue();
                        this.f١١٧٦٣i = new HashMap();
                    } else {
                        while (true) {
                            a aVar = (a) this.f١١٧٦٤j.poll();
                            if (aVar == null) {
                                break;
                            }
                            this.f١١٧٦٣i.remove(Integer.valueOf(aVar.f١١٧٦٥a));
                        }
                    }
                    WeakReference weakReference = (WeakReference) this.f١١٧٦٣i.get(Integer.valueOf(i10));
                    a aVar2 = null;
                    if (weakReference == null) {
                        fVar = null;
                    } else {
                        fVar = (f) weakReference.get();
                    }
                    if (fVar == null) {
                        fVar = new f(this, Integer.valueOf(i10), aVar2);
                        this.f١١٧٦٣i.put(Integer.valueOf(i10), new a(i10, fVar, aVar2));
                    }
                } finally {
                }
            }
            return fVar;
        }

        public List j() {
            return Collections.unmodifiableList(Arrays.asList(this.f١١٧٦٠f));
        }

        @Override // com.google.protobuf.n.i
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public m.c e() {
            return this.f١١٧٥٦b;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private e(m.c cVar, h hVar, b bVar, int i10) {
            super(r0);
            a aVar = null;
            this.f١١٧٦٣i = null;
            this.f١١٧٦٤j = null;
            this.f١١٧٥٥a = i10;
            this.f١١٧٥٦b = cVar;
            this.f١١٧٥٧c = n.k(hVar, bVar, cVar.getName());
            this.f١١٧٥٨d = hVar;
            this.f١١٧٥٩e = bVar;
            if (cVar.E() != 0) {
                this.f١١٧٦٠f = new f[cVar.E()];
                int i11 = 0;
                for (int i12 = 0; i12 < cVar.E(); i12++) {
                    this.f١١٧٦٠f[i12] = new f(cVar.D(i12), hVar, this, i12, null);
                }
                f[] fVarArr = (f[]) this.f١١٧٦٠f.clone();
                this.f١١٧٦١g = fVarArr;
                Arrays.sort(fVarArr, f.f١١٧٦٦e);
                for (int i13 = 1; i13 < cVar.E(); i13++) {
                    f[] fVarArr2 = this.f١١٧٦١g;
                    f fVar = fVarArr2[i11];
                    f fVar2 = fVarArr2[i13];
                    if (fVar.getNumber() != fVar2.getNumber()) {
                        i11++;
                        this.f١١٧٦١g[i11] = fVar2;
                    }
                }
                int i14 = i11 + 1;
                this.f١١٧٦٢h = i14;
                Arrays.fill(this.f١١٧٦١g, i14, cVar.E(), (Object) null);
                hVar.f١١٨٢٥h.b(this);
                return;
            }
            throw new d(this, "Enums must contain at least one value.", aVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class f extends i implements j0.c {

        /* renamed from: e, reason: collision with root package name */
        static final Comparator f١١٧٦٦e = new a();

        /* renamed from: f, reason: collision with root package name */
        static final k f١١٧٦٧f = new b();

        /* renamed from: a, reason: collision with root package name */
        private final int f١١٧٦٨a;

        /* renamed from: b, reason: collision with root package name */
        private m.e f١١٧٦٩b;

        /* renamed from: c, reason: collision with root package name */
        private final String f١١٧٧٠c;

        /* renamed from: d, reason: collision with root package name */
        private final e f١١٧٧١d;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Comparator {
            a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(f fVar, f fVar2) {
                return Integer.valueOf(fVar.getNumber()).compareTo(Integer.valueOf(fVar2.getNumber()));
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class b implements k {
            b() {
            }

            @Override // com.google.protobuf.n.k
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public int a(f fVar) {
                return fVar.getNumber();
            }
        }

        /* synthetic */ f(m.e eVar, h hVar, e eVar2, int i10, a aVar) {
            this(eVar, hVar, eVar2, i10);
        }

        @Override // com.google.protobuf.n.i
        public h a() {
            return this.f١١٧٧١d.f١١٧٥٨d;
        }

        @Override // com.google.protobuf.n.i
        public String c() {
            return this.f١١٧٧٠c;
        }

        @Override // com.google.protobuf.n.i
        public String d() {
            return this.f١١٧٦٩b.getName();
        }

        public int f() {
            return this.f١١٧٦٨a;
        }

        public e g() {
            return this.f١١٧٧١d;
        }

        @Override // com.google.protobuf.j0.c
        public int getNumber() {
            return this.f١١٧٦٩b.t();
        }

        @Override // com.google.protobuf.n.i
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public m.e e() {
            return this.f١١٧٦٩b;
        }

        public String toString() {
            return this.f١١٧٦٩b.getName();
        }

        /* synthetic */ f(e eVar, Integer num, a aVar) {
            this(eVar, num);
        }

        private f(m.e eVar, h hVar, e eVar2, int i10) {
            super(null);
            this.f١١٧٦٨a = i10;
            this.f١١٧٦٩b = eVar;
            this.f١١٧٧١d = eVar2;
            this.f١١٧٧٠c = eVar2.c() + '.' + eVar.getName();
            hVar.f١١٨٢٥h.b(this);
        }

        private f(e eVar, Integer num) {
            super(null);
            m.e build = m.e.y().u("UNKNOWN_ENUM_VALUE_" + eVar.d() + "_" + num).v(num.intValue()).build();
            this.f١١٧٦٨a = -1;
            this.f١١٧٦٩b = build;
            this.f١١٧٧١d = eVar;
            this.f١١٧٧٠c = eVar.c() + '.' + build.getName();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class g extends i implements Comparable, b0.c {

        /* renamed from: m, reason: collision with root package name */
        private static final k f١١٧٧٢m = new a();

        /* renamed from: n, reason: collision with root package name */
        private static final r2.b[] f١١٧٧٣n = r2.b.values();

        /* renamed from: a, reason: collision with root package name */
        private final int f١١٧٧٤a;

        /* renamed from: b, reason: collision with root package name */
        private m.h f١١٧٧٥b;

        /* renamed from: c, reason: collision with root package name */
        private final String f١١٧٧٦c;

        /* renamed from: d, reason: collision with root package name */
        private final h f١١٧٧٧d;

        /* renamed from: e, reason: collision with root package name */
        private final b f١١٧٧٨e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f١١٧٧٩f;

        /* renamed from: g, reason: collision with root package name */
        private c f١١٧٨٠g;

        /* renamed from: h, reason: collision with root package name */
        private b f١١٧٨١h;

        /* renamed from: i, reason: collision with root package name */
        private b f١١٧٨٢i;

        /* renamed from: j, reason: collision with root package name */
        private l f١١٧٨٣j;

        /* renamed from: k, reason: collision with root package name */
        private e f١١٧٨٤k;

        /* renamed from: l, reason: collision with root package name */
        private Object f١١٧٨٥l;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements k {
            a() {
            }

            @Override // com.google.protobuf.n.k
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public int a(g gVar) {
                return gVar.getNumber();
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum b {
            INT(0),
            LONG(0L),
            FLOAT(Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS)),
            DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
            BOOLEAN(Boolean.FALSE),
            STRING(""),
            BYTE_STRING(com.google.protobuf.h.f١١٠١١b),
            ENUM(null),
            MESSAGE(null);


            /* renamed from: a, reason: collision with root package name */
            private final Object f١١٧٩٦a;

            b(Object obj) {
                this.f١١٧٩٦a = obj;
            }
        }

        /* JADX WARN: Enum visitor error
        jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'd' uses external variables
        	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
        	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
        	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
         */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class c {

            /* renamed from: b, reason: collision with root package name */
            public static final c f١١٧٩٧b = new c("DOUBLE", 0, b.DOUBLE);

            /* renamed from: c, reason: collision with root package name */
            public static final c f١١٧٩٨c = new c("FLOAT", 1, b.FLOAT);

            /* renamed from: d, reason: collision with root package name */
            public static final c f١١٧٩٩d;

            /* renamed from: e, reason: collision with root package name */
            public static final c f١١٨٠٠e;

            /* renamed from: f, reason: collision with root package name */
            public static final c f١١٨٠١f;

            /* renamed from: g, reason: collision with root package name */
            public static final c f١١٨٠٢g;

            /* renamed from: h, reason: collision with root package name */
            public static final c f١١٨٠٣h;

            /* renamed from: i, reason: collision with root package name */
            public static final c f١١٨٠٤i;

            /* renamed from: j, reason: collision with root package name */
            public static final c f١١٨٠٥j;

            /* renamed from: k, reason: collision with root package name */
            public static final c f١١٨٠٦k;

            /* renamed from: l, reason: collision with root package name */
            public static final c f١١٨٠٧l;

            /* renamed from: m, reason: collision with root package name */
            public static final c f١١٨٠٨m;

            /* renamed from: n, reason: collision with root package name */
            public static final c f١١٨٠٩n;

            /* renamed from: o, reason: collision with root package name */
            public static final c f١١٨١٠o;

            /* renamed from: p, reason: collision with root package name */
            public static final c f١١٨١١p;

            /* renamed from: q, reason: collision with root package name */
            public static final c f١١٨١٢q;

            /* renamed from: r, reason: collision with root package name */
            public static final c f١١٨١٣r;

            /* renamed from: s, reason: collision with root package name */
            public static final c f١١٨١٤s;

            /* renamed from: t, reason: collision with root package name */
            private static final c[] f١١٨١٥t;

            /* renamed from: u, reason: collision with root package name */
            private static final /* synthetic */ c[] f١١٨١٦u;

            /* renamed from: a, reason: collision with root package name */
            private final b f١١٨١٧a;

            static {
                b bVar = b.LONG;
                f١١٧٩٩d = new c("INT64", 2, bVar);
                f١١٨٠٠e = new c("UINT64", 3, bVar);
                b bVar2 = b.INT;
                f١١٨٠١f = new c("INT32", 4, bVar2);
                f١١٨٠٢g = new c("FIXED64", 5, bVar);
                f١١٨٠٣h = new c("FIXED32", 6, bVar2);
                f١١٨٠٤i = new c("BOOL", 7, b.BOOLEAN);
                f١١٨٠٥j = new c("STRING", 8, b.STRING);
                b bVar3 = b.MESSAGE;
                f١١٨٠٦k = new c("GROUP", 9, bVar3);
                f١١٨٠٧l = new c("MESSAGE", 10, bVar3);
                f١١٨٠٨m = new c("BYTES", 11, b.BYTE_STRING);
                f١١٨٠٩n = new c("UINT32", 12, bVar2);
                f١١٨١٠o = new c("ENUM", 13, b.ENUM);
                f١١٨١١p = new c("SFIXED32", 14, bVar2);
                f١١٨١٢q = new c("SFIXED64", 15, bVar);
                f١١٨١٣r = new c("SINT32", 16, bVar2);
                f١١٨١٤s = new c("SINT64", 17, bVar);
                f١١٨١٦u = a();
                f١١٨١٥t = values();
            }

            private c(String str, int i10, b bVar) {
                this.f١١٨١٧a = bVar;
            }

            private static /* synthetic */ c[] a() {
                return new c[]{f١١٧٩٧b, f١١٧٩٨c, f١١٧٩٩d, f١١٨٠٠e, f١١٨٠١f, f١١٨٠٢g, f١١٨٠٣h, f١١٨٠٤i, f١١٨٠٥j, f١١٨٠٦k, f١١٨٠٧l, f١١٨٠٨m, f١١٨٠٩n, f١١٨١٠o, f١١٨١١p, f١١٨١٢q, f١١٨١٣r, f١١٨١٤s};
            }

            public static c e(m.h.d dVar) {
                return f١١٨١٥t[dVar.getNumber() - 1];
            }

            public static c valueOf(String str) {
                return (c) Enum.valueOf(c.class, str);
            }

            public static c[] values() {
                return (c[]) f١١٨١٦u.clone();
            }

            public b d() {
                return this.f١١٨١٧a;
            }
        }

        static {
            if (c.f١١٨١٥t.length == m.h.d.values().length) {
            } else {
                throw new RuntimeException("descriptor.proto has a new declared type but Descriptors.java wasn't updated.");
            }
        }

        /* synthetic */ g(m.h hVar, h hVar2, b bVar, int i10, boolean z10, a aVar) {
            this(hVar, hVar2, bVar, i10, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:47:0x0199. Please report as an issue. */
        public void j() {
            a aVar = null;
            if (this.f١١٧٧٥b.Q()) {
                i h10 = this.f١١٧٧٧d.f١١٨٢٥h.h(this.f١١٧٧٥b.G(), this, c.b.TYPES_ONLY);
                if (h10 instanceof b) {
                    this.f١١٧٨١h = (b) h10;
                    if (!l().o(getNumber())) {
                        throw new d(this, Typography.quote + l().c() + "\" does not declare " + getNumber() + " as an extension number.", aVar);
                    }
                } else {
                    throw new d(this, Typography.quote + this.f١١٧٧٥b.G() + "\" is not a message type.", aVar);
                }
            }
            if (this.f١١٧٧٥b.Z()) {
                i h11 = this.f١١٧٧٧d.f١١٨٢٥h.h(this.f١١٧٧٥b.O(), this, c.b.TYPES_ONLY);
                if (!this.f١١٧٧٥b.Y()) {
                    if (h11 instanceof b) {
                        this.f١١٧٨٠g = c.f١١٨٠٧l;
                    } else if (h11 instanceof e) {
                        this.f١١٧٨٠g = c.f١١٨١٠o;
                    } else {
                        throw new d(this, Typography.quote + this.f١١٧٧٥b.O() + "\" is not a type.", aVar);
                    }
                }
                if (q() == b.MESSAGE) {
                    if (h11 instanceof b) {
                        this.f١١٧٨٢i = (b) h11;
                        if (this.f١١٧٧٥b.P()) {
                            throw new d(this, "Messages can't have default values.", aVar);
                        }
                    } else {
                        throw new d(this, Typography.quote + this.f١١٧٧٥b.O() + "\" is not a message type.", aVar);
                    }
                } else if (q() == b.ENUM) {
                    if (h11 instanceof e) {
                        this.f١١٧٨٤k = (e) h11;
                    } else {
                        throw new d(this, Typography.quote + this.f١١٧٧٥b.O() + "\" is not an enum type.", aVar);
                    }
                } else {
                    throw new d(this, "Field with primitive type has type_name.", aVar);
                }
            } else if (q() == b.MESSAGE || q() == b.ENUM) {
                throw new d(this, "Field with message or enum type missing type_name.", aVar);
            }
            if (this.f١١٧٧٥b.L().I() && !y()) {
                throw new d(this, "[packed = true] can only be specified for repeated primitive fields.", aVar);
            }
            if (this.f١١٧٧٥b.P()) {
                if (!isRepeated()) {
                    try {
                        switch (a.f١١٧٢٦a[t().ordinal()]) {
                            case 1:
                            case 2:
                            case 3:
                                this.f١١٧٨٥l = Integer.valueOf(e2.j(this.f١١٧٧٥b.F()));
                                break;
                            case 4:
                            case 5:
                                this.f١١٧٨٥l = Integer.valueOf(e2.m(this.f١١٧٧٥b.F()));
                                break;
                            case 6:
                            case 7:
                            case 8:
                                this.f١١٧٨٥l = Long.valueOf(e2.k(this.f١١٧٧٥b.F()));
                                break;
                            case 9:
                            case 10:
                                this.f١١٧٨٥l = Long.valueOf(e2.n(this.f١١٧٧٥b.F()));
                                break;
                            case 11:
                                if (this.f١١٧٧٥b.F().equals("inf")) {
                                    this.f١١٧٨٥l = Float.valueOf(Float.POSITIVE_INFINITY);
                                    break;
                                } else if (this.f١١٧٧٥b.F().equals("-inf")) {
                                    this.f١١٧٨٥l = Float.valueOf(Float.NEGATIVE_INFINITY);
                                    break;
                                } else if (this.f١١٧٧٥b.F().equals("nan")) {
                                    this.f١١٧٨٥l = Float.valueOf(Float.NaN);
                                    break;
                                } else {
                                    this.f١١٧٨٥l = Float.valueOf(this.f١١٧٧٥b.F());
                                    break;
                                }
                            case 12:
                                if (this.f١١٧٧٥b.F().equals("inf")) {
                                    this.f١١٧٨٥l = Double.valueOf(Double.POSITIVE_INFINITY);
                                    break;
                                } else if (this.f١١٧٧٥b.F().equals("-inf")) {
                                    this.f١١٧٨٥l = Double.valueOf(Double.NEGATIVE_INFINITY);
                                    break;
                                } else if (this.f١١٧٧٥b.F().equals("nan")) {
                                    this.f١١٧٨٥l = Double.valueOf(Double.NaN);
                                    break;
                                } else {
                                    this.f١١٧٨٥l = Double.valueOf(this.f١١٧٧٥b.F());
                                    break;
                                }
                            case 13:
                                this.f١١٧٨٥l = Boolean.valueOf(this.f١١٧٧٥b.F());
                                break;
                            case 14:
                                this.f١١٧٨٥l = this.f١١٧٧٥b.F();
                                break;
                            case 15:
                                try {
                                    this.f١١٧٨٥l = e2.p(this.f١١٧٧٥b.F());
                                    break;
                                } catch (e2.b e10) {
                                    throw new d(this, "Couldn't parse default value: " + e10.getMessage(), e10, aVar);
                                }
                            case 16:
                                f g10 = this.f١١٧٨٤k.g(this.f١١٧٧٥b.F());
                                this.f١١٧٨٥l = g10;
                                if (g10 == null) {
                                    throw new d(this, "Unknown enum default value: \"" + this.f١١٧٧٥b.F() + Typography.quote, aVar);
                                }
                                break;
                            case 17:
                            case 18:
                                throw new d(this, "Message type had default value.", aVar);
                        }
                    } catch (NumberFormatException e11) {
                        throw new d(this, "Could not parse default value: \"" + this.f١١٧٧٥b.F() + Typography.quote, e11, aVar);
                    }
                } else {
                    throw new d(this, "Repeated fields cannot have default values.", aVar);
                }
            } else if (isRepeated()) {
                this.f١١٧٨٥l = Collections.emptyList();
            } else {
                int i10 = a.f١١٧٢٧b[q().ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        this.f١١٧٨٥l = q().f١١٧٩٦a;
                    } else {
                        this.f١١٧٨٥l = null;
                    }
                } else {
                    this.f١١٧٨٥l = this.f١١٧٨٤k.j().get(0);
                }
            }
            b bVar = this.f١١٧٨١h;
            if (bVar != null && bVar.m().D()) {
                if (v()) {
                    if (!x() || t() != c.f١١٨٠٧l) {
                        throw new d(this, "Extensions of MessageSets must be optional messages.", aVar);
                    }
                    return;
                }
                throw new d(this, "MessageSets cannot have fields, only extensions.", aVar);
            }
        }

        public boolean A() {
            if (this.f١١٧٨٠g != c.f١١٨٠٥j) {
                return false;
            }
            if (l().m().C() || a().n() == h.a.PROTO3) {
                return true;
            }
            return a().k().l0();
        }

        @Override // com.google.protobuf.n.i
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public m.h e() {
            return this.f١١٧٧٥b;
        }

        @Override // com.google.protobuf.n.i
        public h a() {
            return this.f١١٧٧٧d;
        }

        @Override // com.google.protobuf.b0.c
        public e1.a b(e1.a aVar, e1 e1Var) {
            return ((b1.a) aVar).mergeFrom((b1) e1Var);
        }

        @Override // com.google.protobuf.n.i
        public String c() {
            return this.f١١٧٧٦c;
        }

        @Override // com.google.protobuf.n.i
        public String d() {
            return this.f١١٧٧٥b.getName();
        }

        @Override // com.google.protobuf.b0.c
        public r2.c getLiteJavaType() {
            return getLiteType().c();
        }

        @Override // com.google.protobuf.b0.c
        public r2.b getLiteType() {
            return f١١٧٧٣n[this.f١١٧٨٠g.ordinal()];
        }

        @Override // com.google.protobuf.b0.c
        public int getNumber() {
            return this.f١١٧٧٥b.J();
        }

        @Override // java.lang.Comparable
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public int compareTo(g gVar) {
            if (gVar.f١١٧٨١h == this.f١١٧٨١h) {
                return getNumber() - gVar.getNumber();
            }
            throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
        }

        @Override // com.google.protobuf.b0.c
        public boolean isPacked() {
            if (!y()) {
                return false;
            }
            if (a().n() == h.a.PROTO2) {
                return s().I();
            }
            if (s().S() && !s().I()) {
                return false;
            }
            return true;
        }

        @Override // com.google.protobuf.b0.c
        public boolean isRepeated() {
            if (this.f١١٧٧٥b.I() == m.h.c.LABEL_REPEATED) {
                return true;
            }
            return false;
        }

        public l k() {
            return this.f١١٧٨٣j;
        }

        public b l() {
            return this.f١١٧٨١h;
        }

        public Object m() {
            if (q() != b.MESSAGE) {
                return this.f١١٧٨٥l;
            }
            throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
        }

        public e n() {
            if (q() == b.ENUM) {
                return this.f١١٧٨٤k;
            }
            throw new UnsupportedOperationException(String.format("This field is not of enum type. (%s)", this.f١١٧٧٦c));
        }

        public b o() {
            if (v()) {
                return this.f١١٧٧٨e;
            }
            throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", this.f١١٧٧٦c));
        }

        public int p() {
            return this.f١١٧٧٤a;
        }

        public b q() {
            return this.f١١٧٨٠g.d();
        }

        public b r() {
            if (q() == b.MESSAGE) {
                return this.f١١٧٨٢i;
            }
            throw new UnsupportedOperationException(String.format("This field is not of message type. (%s)", this.f١١٧٧٦c));
        }

        public m.i s() {
            return this.f١١٧٧٥b.L();
        }

        public c t() {
            return this.f١١٧٨٠g;
        }

        public String toString() {
            return c();
        }

        public boolean u() {
            if (!this.f١١٧٧٩f && (this.f١١٧٧٧d.n() != h.a.PROTO2 || !x() || k() != null)) {
                return false;
            }
            return true;
        }

        public boolean v() {
            return this.f١١٧٧٥b.Q();
        }

        public boolean w() {
            if (t() == c.f١١٨٠٧l && isRepeated() && r().m().C()) {
                return true;
            }
            return false;
        }

        public boolean x() {
            if (this.f١١٧٧٥b.I() == m.h.c.LABEL_OPTIONAL) {
                return true;
            }
            return false;
        }

        public boolean y() {
            if (isRepeated() && getLiteType().e()) {
                return true;
            }
            return false;
        }

        public boolean z() {
            if (this.f١١٧٧٥b.I() == m.h.c.LABEL_REQUIRED) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private g(m.h hVar, h hVar2, b bVar, int i10, boolean z10) {
            super(r0);
            a aVar = null;
            this.f١١٧٧٤a = i10;
            this.f١١٧٧٥b = hVar;
            this.f١١٧٧٦c = n.k(hVar2, bVar, hVar.getName());
            this.f١١٧٧٧d = hVar2;
            if (hVar.Y()) {
                this.f١١٧٨٠g = c.e(hVar.N());
            }
            this.f١١٧٧٩f = hVar.M();
            if (getNumber() > 0) {
                if (z10) {
                    if (hVar.Q()) {
                        this.f١١٧٨١h = null;
                        if (bVar != null) {
                            this.f١١٧٧٨e = bVar;
                        } else {
                            this.f١١٧٧٨e = null;
                        }
                        if (!hVar.V()) {
                            this.f١١٧٨٣j = null;
                        } else {
                            throw new d(this, "FieldDescriptorProto.oneof_index set for extension field.", aVar);
                        }
                    } else {
                        throw new d(this, "FieldDescriptorProto.extendee not set for extension field.", aVar);
                    }
                } else if (!hVar.Q()) {
                    this.f١١٧٨١h = bVar;
                    if (hVar.V()) {
                        if (hVar.K() >= 0 && hVar.K() < bVar.e().Y()) {
                            l lVar = (l) bVar.l().get(hVar.K());
                            this.f١١٧٨٣j = lVar;
                            l.i(lVar);
                        } else {
                            throw new d(this, "FieldDescriptorProto.oneof_index is out of range for type " + bVar.d(), aVar);
                        }
                    } else {
                        this.f١١٧٨٣j = null;
                    }
                    this.f١١٧٧٨e = null;
                } else {
                    throw new d(this, "FieldDescriptorProto.extendee set for non-extension field.", aVar);
                }
                hVar2.f١١٨٢٥h.b(this);
                return;
            }
            throw new d(this, "Field numbers must be positive integers.", aVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class i {
        /* synthetic */ i(a aVar) {
            this();
        }

        public abstract h a();

        public abstract String c();

        public abstract String d();

        public abstract b1 e();

        private i() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class j extends i {

        /* renamed from: a, reason: collision with root package name */
        private final int f١١٨٣١a;

        /* renamed from: b, reason: collision with root package name */
        private m.C٠١٤١m f١١٨٣٢b;

        /* renamed from: c, reason: collision with root package name */
        private final String f١١٨٣٣c;

        /* renamed from: d, reason: collision with root package name */
        private final h f١١٨٣٤d;

        /* renamed from: e, reason: collision with root package name */
        private final m f١١٨٣٥e;

        /* renamed from: f, reason: collision with root package name */
        private b f١١٨٣٦f;

        /* renamed from: g, reason: collision with root package name */
        private b f١١٨٣٧g;

        /* synthetic */ j(m.C٠١٤١m r12, h hVar, m mVar, int i10, a aVar) {
            this(r12, hVar, mVar, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            c cVar = a().f١١٨٢٥h;
            String z10 = this.f١١٨٣٢b.z();
            c.b bVar = c.b.TYPES_ONLY;
            i h10 = cVar.h(z10, this, bVar);
            a aVar = null;
            if (h10 instanceof b) {
                this.f١١٨٣٦f = (b) h10;
                i h11 = a().f١١٨٢٥h.h(this.f١١٨٣٢b.B(), this, bVar);
                if (h11 instanceof b) {
                    this.f١١٨٣٧g = (b) h11;
                    return;
                }
                throw new d(this, Typography.quote + this.f١١٨٣٢b.B() + "\" is not a message type.", aVar);
            }
            throw new d(this, Typography.quote + this.f١١٨٣٢b.z() + "\" is not a message type.", aVar);
        }

        @Override // com.google.protobuf.n.i
        public h a() {
            return this.f١١٨٣٤d;
        }

        @Override // com.google.protobuf.n.i
        public String c() {
            return this.f١١٨٣٣c;
        }

        @Override // com.google.protobuf.n.i
        public String d() {
            return this.f١١٨٣٢b.getName();
        }

        @Override // com.google.protobuf.n.i
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public m.C٠١٤١m e() {
            return this.f١١٨٣٢b;
        }

        private j(m.C٠١٤١m r22, h hVar, m mVar, int i10) {
            super(null);
            this.f١١٨٣١a = i10;
            this.f١١٨٣٢b = r22;
            this.f١١٨٣٤d = hVar;
            this.f١١٨٣٥e = mVar;
            this.f١١٨٣٣c = mVar.c() + '.' + r22.getName();
            hVar.f١١٨٢٥h.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface k {
        int a(Object obj);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class l extends i {

        /* renamed from: a, reason: collision with root package name */
        private final int f١١٨٣٨a;

        /* renamed from: b, reason: collision with root package name */
        private m.o f١١٨٣٩b;

        /* renamed from: c, reason: collision with root package name */
        private final String f١١٨٤٠c;

        /* renamed from: d, reason: collision with root package name */
        private final h f١١٨٤١d;

        /* renamed from: e, reason: collision with root package name */
        private b f١١٨٤٢e;

        /* renamed from: f, reason: collision with root package name */
        private int f١١٨٤٣f;

        /* renamed from: g, reason: collision with root package name */
        private g[] f١١٨٤٤g;

        /* synthetic */ l(m.o oVar, h hVar, b bVar, int i10, a aVar) {
            this(oVar, hVar, bVar, i10);
        }

        static /* synthetic */ int i(l lVar) {
            int i10 = lVar.f١١٨٤٣f;
            lVar.f١١٨٤٣f = i10 + 1;
            return i10;
        }

        @Override // com.google.protobuf.n.i
        public h a() {
            return this.f١١٨٤١d;
        }

        @Override // com.google.protobuf.n.i
        public String c() {
            return this.f١١٨٤٠c;
        }

        @Override // com.google.protobuf.n.i
        public String d() {
            return this.f١١٨٣٩b.getName();
        }

        public b j() {
            return this.f١١٨٤٢e;
        }

        public int k() {
            return this.f١١٨٤٣f;
        }

        public List l() {
            return Collections.unmodifiableList(Arrays.asList(this.f١١٨٤٤g));
        }

        public int m() {
            return this.f١١٨٣٨a;
        }

        public boolean n() {
            g[] gVarArr = this.f١١٨٤٤g;
            if (gVarArr.length != 1 || !gVarArr[0].f١١٧٧٩f) {
                return false;
            }
            return true;
        }

        @Override // com.google.protobuf.n.i
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public m.o e() {
            return this.f١١٨٣٩b;
        }

        private l(m.o oVar, h hVar, b bVar, int i10) {
            super(null);
            this.f١١٨٣٩b = oVar;
            this.f١١٨٤٠c = n.k(hVar, bVar, oVar.getName());
            this.f١١٨٤١d = hVar;
            this.f١١٨٣٨a = i10;
            this.f١١٨٤٢e = bVar;
            this.f١١٨٤٣f = 0;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class m extends i {

        /* renamed from: a, reason: collision with root package name */
        private final int f١١٨٤٥a;

        /* renamed from: b, reason: collision with root package name */
        private m.q f١١٨٤٦b;

        /* renamed from: c, reason: collision with root package name */
        private final String f١١٨٤٧c;

        /* renamed from: d, reason: collision with root package name */
        private final h f١١٨٤٨d;

        /* renamed from: e, reason: collision with root package name */
        private j[] f١١٨٤٩e;

        /* synthetic */ m(m.q qVar, h hVar, int i10, a aVar) {
            this(qVar, hVar, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            for (j jVar : this.f١١٨٤٩e) {
                jVar.g();
            }
        }

        @Override // com.google.protobuf.n.i
        public h a() {
            return this.f١١٨٤٨d;
        }

        @Override // com.google.protobuf.n.i
        public String c() {
            return this.f١١٨٤٧c;
        }

        @Override // com.google.protobuf.n.i
        public String d() {
            return this.f١١٨٤٦b.getName();
        }

        @Override // com.google.protobuf.n.i
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public m.q e() {
            return this.f١١٨٤٦b;
        }

        private m(m.q qVar, h hVar, int i10) {
            super(null);
            this.f١١٨٤٥a = i10;
            this.f١١٨٤٦b = qVar;
            this.f١١٨٤٧c = n.k(hVar, null, qVar.getName());
            this.f١١٨٤٨d = hVar;
            this.f١١٨٤٩e = new j[qVar.v()];
            for (int i11 = 0; i11 < qVar.v(); i11++) {
                this.f١١٨٤٩e[i11] = new j(qVar.u(i11), hVar, this, i11, null);
            }
            hVar.f١١٨٢٥h.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object j(Object[] objArr, int i10, k kVar, int i11) {
        int i12 = i10 - 1;
        int i13 = 0;
        while (i13 <= i12) {
            int i14 = (i13 + i12) / 2;
            Object obj = objArr[i14];
            int a10 = kVar.a(obj);
            if (i11 < a10) {
                i12 = i14 - 1;
            } else if (i11 > a10) {
                i13 = i14 + 1;
            } else {
                return obj;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k(h hVar, b bVar, String str) {
        if (bVar != null) {
            return bVar.c() + '.' + str;
        }
        String l10 = hVar.l();
        if (!l10.isEmpty()) {
            return l10 + '.' + str;
        }
        return str;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class h extends i {

        /* renamed from: a, reason: collision with root package name */
        private m.j f١١٨١٨a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f١١٨١٩b;

        /* renamed from: c, reason: collision with root package name */
        private final e[] f١١٨٢٠c;

        /* renamed from: d, reason: collision with root package name */
        private final m[] f١١٨٢١d;

        /* renamed from: e, reason: collision with root package name */
        private final g[] f١١٨٢٢e;

        /* renamed from: f, reason: collision with root package name */
        private final h[] f١١٨٢٣f;

        /* renamed from: g, reason: collision with root package name */
        private final h[] f١١٨٢٤g;

        /* renamed from: h, reason: collision with root package name */
        private final c f١١٨٢٥h;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum a {
            UNKNOWN("unknown"),
            PROTO2("proto2"),
            PROTO3("proto3");


            /* renamed from: a, reason: collision with root package name */
            private final String f١١٨٣٠a;

            a(String str) {
                this.f١١٨٣٠a = str;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private h(m.j jVar, h[] hVarArr, c cVar, boolean z10) {
            super(r0);
            b[] bVarArr;
            e[] eVarArr;
            m[] mVarArr;
            g[] gVarArr;
            a aVar = null;
            this.f١١٨٢٥h = cVar;
            this.f١١٨١٨a = jVar;
            this.f١١٨٢٣f = (h[]) hVarArr.clone();
            HashMap hashMap = new HashMap();
            for (h hVar : hVarArr) {
                hashMap.put(hVar.d(), hVar);
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < jVar.a0(); i10++) {
                int Z = jVar.Z(i10);
                if (Z >= 0 && Z < jVar.M()) {
                    String L = jVar.L(Z);
                    h hVar2 = (h) hashMap.get(L);
                    if (hVar2 != null) {
                        arrayList.add(hVar2);
                    } else if (!z10) {
                        throw new d(this, "Invalid public dependency: " + L, aVar);
                    }
                } else {
                    throw new d(this, "Invalid public dependency index.", aVar);
                }
            }
            h[] hVarArr2 = new h[arrayList.size()];
            this.f١١٨٢٤g = hVarArr2;
            arrayList.toArray(hVarArr2);
            cVar.a(l(), this);
            if (jVar.V() <= 0) {
                bVarArr = n.f١١٧٢١c;
            } else {
                bVarArr = new b[jVar.V()];
            }
            this.f١١٨١٩b = bVarArr;
            for (int i11 = 0; i11 < jVar.V(); i11++) {
                this.f١١٨١٩b[i11] = new b(jVar.U(i11), this, null, i11, null);
            }
            if (jVar.P() <= 0) {
                eVarArr = n.f١١٧٢٣e;
            } else {
                eVarArr = new e[jVar.P()];
            }
            this.f١١٨٢٠c = eVarArr;
            for (int i12 = 0; i12 < jVar.P(); i12++) {
                this.f١١٨٢٠c[i12] = new e(jVar.O(i12), this, null, i12, null);
            }
            if (jVar.d0() <= 0) {
                mVarArr = n.f١١٧٢٤f;
            } else {
                mVarArr = new m[jVar.d0()];
            }
            this.f١١٨٢١d = mVarArr;
            for (int i13 = 0; i13 < jVar.d0(); i13++) {
                this.f١١٨٢١d[i13] = new m(jVar.c0(i13), this, i13, aVar);
            }
            if (jVar.S() <= 0) {
                gVarArr = n.f١١٧٢٢d;
            } else {
                gVarArr = new g[jVar.S()];
            }
            this.f١١٨٢٢e = gVarArr;
            for (int i14 = 0; i14 < jVar.S(); i14++) {
                this.f١١٨٢٢e[i14] = new g(jVar.R(i14), this, null, i14, true, null);
            }
        }

        public static h g(m.j jVar, h[] hVarArr, boolean z10) {
            h hVar = new h(jVar, hVarArr, new c(hVarArr, z10), z10);
            hVar.h();
            return hVar;
        }

        private void h() {
            for (b bVar : this.f١١٨١٩b) {
                bVar.g();
            }
            for (m mVar : this.f١١٨٢١d) {
                mVar.g();
            }
            for (g gVar : this.f١١٨٢٢e) {
                gVar.j();
            }
        }

        public static h o(String[] strArr, h[] hVarArr) {
            try {
                m.j r02 = m.j.r0(p(strArr));
                try {
                    return g(r02, hVarArr, true);
                } catch (d e10) {
                    throw new IllegalArgumentException("Invalid embedded descriptor for \"" + r02.getName() + "\".", e10);
                }
            } catch (k0 e11) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e11);
            }
        }

        private static byte[] p(String[] strArr) {
            if (strArr.length == 1) {
                return strArr[0].getBytes(j0.f١١١٦٣c);
            }
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
            }
            return sb.toString().getBytes(j0.f١١١٦٣c);
        }

        @Override // com.google.protobuf.n.i
        public h a() {
            return this;
        }

        @Override // com.google.protobuf.n.i
        public String c() {
            return this.f١١٨١٨a.getName();
        }

        @Override // com.google.protobuf.n.i
        public String d() {
            return this.f١١٨١٨a.getName();
        }

        public List i() {
            return Collections.unmodifiableList(Arrays.asList(this.f١١٨٢٠c));
        }

        public List j() {
            return Collections.unmodifiableList(Arrays.asList(this.f١١٨١٩b));
        }

        public m.k k() {
            return this.f١١٨١٨a.X();
        }

        public String l() {
            return this.f١١٨١٨a.Y();
        }

        public List m() {
            return Collections.unmodifiableList(Arrays.asList(this.f١١٨٢٤g));
        }

        public a n() {
            a aVar = a.PROTO3;
            if (aVar.f١١٨٣٠a.equals(this.f١١٨١٨a.g0())) {
                return aVar;
            }
            return a.PROTO2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean q() {
            if (n() == a.PROTO3) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.n.i
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public m.j e() {
            return this.f١١٨١٨a;
        }

        h(String str, b bVar) {
            super(null);
            c cVar = new c(new h[0], true);
            this.f١١٨٢٥h = cVar;
            this.f١١٨١٨a = m.j.o0().T(bVar.c() + ".placeholder.proto").U(str).e(bVar.e()).build();
            this.f١١٨٢٣f = new h[0];
            this.f١١٨٢٤g = new h[0];
            this.f١١٨١٩b = new b[]{bVar};
            this.f١١٨٢٠c = n.f١١٧٢٣e;
            this.f١١٨٢١d = n.f١١٧٢٤f;
            this.f١١٨٢٢e = n.f١١٧٢٢d;
            cVar.a(str, this);
            cVar.b(bVar);
        }
    }
}

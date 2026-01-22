package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.b0;
import com.google.protobuf.b1;
import com.google.protobuf.g0;
import com.google.protobuf.h1;
import com.google.protobuf.j0;
import com.google.protobuf.k2;
import com.google.protobuf.m0;
import com.google.protobuf.n;
import com.google.protobuf.q;
import com.google.protobuf.r2;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class h0 extends com.google.protobuf.a implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    protected k2 unknownFields;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.b f١١٠٢٣a;

        a(h0 h0Var, a.b bVar) {
            this.f١١٠٢٣a = bVar;
        }

        @Override // com.google.protobuf.a.b
        public void a() {
            this.f١١٠٢٣a.a();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class b extends a.AbstractC٠١٣٢a {
        private c builderParent;
        private boolean isClean;
        private com.google.protobuf.h0$b.a meAsParent;
        private Object unknownFieldsOrBuilder;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private class a implements c {
            private a() {
            }

            @Override // com.google.protobuf.a.b
            public void a() {
                b.this.onChanged();
            }

            /* synthetic */ a(b bVar, a aVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b() {
            this(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map c() {
            TreeMap treeMap = new TreeMap();
            List j10 = internalGetFieldAccessorTable().f١١٠٣١a.j();
            int i10 = 0;
            while (i10 < j10.size()) {
                n.g gVar = (n.g) j10.get(i10);
                n.l k10 = gVar.k();
                if (k10 != null) {
                    i10 += k10.k() - 1;
                    if (hasOneof(k10)) {
                        gVar = getOneofFieldDescriptor(k10);
                        treeMap.put(gVar, getField(gVar));
                        i10++;
                    } else {
                        i10++;
                    }
                } else {
                    if (gVar.isRepeated()) {
                        List list = (List) getField(gVar);
                        if (!list.isEmpty()) {
                            treeMap.put(gVar, list);
                        }
                    } else {
                        if (!hasField(gVar)) {
                        }
                        treeMap.put(gVar, getField(gVar));
                    }
                    i10++;
                }
            }
            return treeMap;
        }

        private b d(k2 k2Var) {
            this.unknownFieldsOrBuilder = k2Var;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.b1.a
        public b addRepeatedField(n.g gVar, Object obj) {
            internalGetFieldAccessorTable().e(gVar).g(this, obj);
            return this;
        }

        public b clear() {
            this.unknownFieldsOrBuilder = k2.c();
            onChanged();
            return this;
        }

        public b clearField(n.g gVar) {
            internalGetFieldAccessorTable().e(gVar).a(this);
            return this;
        }

        public b clearOneof(n.l lVar) {
            internalGetFieldAccessorTable().f(lVar).a(this);
            return this;
        }

        public b clone() {
            b bVar = (b) getDefaultInstanceForType().newBuilderForType();
            bVar.mergeFrom(buildPartial());
            return bVar;
        }

        @Override // com.google.protobuf.a.AbstractC٠١٣٢a
        void dispose() {
            this.builderParent = null;
        }

        @Override // com.google.protobuf.g1
        public Map<n.g, Object> getAllFields() {
            return Collections.unmodifiableMap(c());
        }

        @Override // com.google.protobuf.b1.a, com.google.protobuf.g1
        public abstract n.b getDescriptorForType();

        @Override // com.google.protobuf.g1
        public Object getField(n.g gVar) {
            Object c10 = internalGetFieldAccessorTable().e(gVar).c(this);
            if (gVar.isRepeated()) {
                return Collections.unmodifiableList((List) c10);
            }
            return c10;
        }

        @Override // com.google.protobuf.b1.a
        public b1.a getFieldBuilder(n.g gVar) {
            return internalGetFieldAccessorTable().e(gVar).o(this);
        }

        public n.g getOneofFieldDescriptor(n.l lVar) {
            return internalGetFieldAccessorTable().f(lVar).b(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public c getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new a(this, null);
            }
            return this.meAsParent;
        }

        public Object getRepeatedField(n.g gVar, int i10) {
            return internalGetFieldAccessorTable().e(gVar).j(this, i10);
        }

        public b1.a getRepeatedFieldBuilder(n.g gVar, int i10) {
            return internalGetFieldAccessorTable().e(gVar).m(this, i10);
        }

        public int getRepeatedFieldCount(n.g gVar) {
            return internalGetFieldAccessorTable().e(gVar).d(this);
        }

        @Override // com.google.protobuf.a.AbstractC٠١٣٢a
        protected k2.b getUnknownFieldSetBuilder() {
            Object obj = this.unknownFieldsOrBuilder;
            if (obj instanceof k2) {
                this.unknownFieldsOrBuilder = ((k2) obj).toBuilder();
            }
            onChanged();
            return (k2.b) this.unknownFieldsOrBuilder;
        }

        @Override // com.google.protobuf.g1
        public final k2 getUnknownFields() {
            Object obj = this.unknownFieldsOrBuilder;
            if (obj instanceof k2) {
                return (k2) obj;
            }
            return ((k2.b) obj).buildPartial();
        }

        @Override // com.google.protobuf.g1
        public boolean hasField(n.g gVar) {
            return internalGetFieldAccessorTable().e(gVar).l(this);
        }

        public boolean hasOneof(n.l lVar) {
            return internalGetFieldAccessorTable().f(lVar).d(this);
        }

        protected abstract f internalGetFieldAccessorTable();

        protected v0 internalGetMapField(int i10) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        protected v0 internalGetMutableMapField(int i10) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.a.AbstractC٠١٣٢a
        protected void markClean() {
            this.isClean = true;
        }

        @Override // com.google.protobuf.a.AbstractC٠١٣٢a
        public b mergeUnknownFields(k2 k2Var) {
            if (k2.c().equals(k2Var)) {
                return this;
            }
            if (k2.c().equals(this.unknownFieldsOrBuilder)) {
                this.unknownFieldsOrBuilder = k2Var;
                onChanged();
                return this;
            }
            getUnknownFieldSetBuilder().n(k2Var);
            onChanged();
            return this;
        }

        protected final void mergeUnknownLengthDelimitedField(int i10, h hVar) {
            getUnknownFieldSetBuilder().p(i10, hVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void mergeUnknownVarintField(int i10, int i11) {
            getUnknownFieldSetBuilder().q(i10, i11);
        }

        @Override // com.google.protobuf.b1.a
        public b1.a newBuilderForField(n.g gVar) {
            return internalGetFieldAccessorTable().e(gVar).newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void onBuilt() {
            if (this.builderParent != null) {
                markClean();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void onChanged() {
            c cVar;
            if (this.isClean && (cVar = this.builderParent) != null) {
                cVar.a();
                this.isClean = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean parseUnknownField(i iVar, v vVar, int i10) throws IOException {
            if (iVar.N()) {
                return iVar.O(i10);
            }
            return getUnknownFieldSetBuilder().j(i10, iVar);
        }

        @Override // com.google.protobuf.b1.a
        public b setField(n.g gVar, Object obj) {
            internalGetFieldAccessorTable().e(gVar).f(this, obj);
            return this;
        }

        public b setRepeatedField(n.g gVar, int i10, Object obj) {
            internalGetFieldAccessorTable().e(gVar).i(this, i10, obj);
            return this;
        }

        @Override // com.google.protobuf.a.AbstractC٠١٣٢a
        protected void setUnknownFieldSetBuilder(k2.b bVar) {
            this.unknownFieldsOrBuilder = bVar;
            onChanged();
        }

        @Override // com.google.protobuf.b1.a
        public b setUnknownFields(k2 k2Var) {
            return d(k2Var);
        }

        protected b setUnknownFieldsProto3(k2 k2Var) {
            return d(k2Var);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public b(c cVar) {
            this.unknownFieldsOrBuilder = k2.c();
            this.builderParent = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface c extends a.b {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class d extends b implements g1 {

        /* renamed from: a, reason: collision with root package name */
        private b0.b f١١٠٢٥a;

        /* JADX INFO: Access modifiers changed from: protected */
        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b0 g() {
            b0.b bVar = this.f١١٠٢٥a;
            if (bVar == null) {
                return b0.o();
            }
            return bVar.d();
        }

        private void h() {
            if (this.f١١٠٢٥a == null) {
                this.f١١٠٢٥a = b0.I();
            }
        }

        private void l(n.g gVar) {
            if (gVar.l() == getDescriptorForType()) {
            } else {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        public d f(n.g gVar, Object obj) {
            if (gVar.v()) {
                l(gVar);
                h();
                this.f١١٠٢٥a.a(gVar, obj);
                onChanged();
                return this;
            }
            return (d) super.addRepeatedField(gVar, obj);
        }

        @Override // com.google.protobuf.h0.b, com.google.protobuf.g1
        public Map getAllFields() {
            Map c10 = c();
            b0.b bVar = this.f١١٠٢٥a;
            if (bVar != null) {
                c10.putAll(bVar.g());
            }
            return Collections.unmodifiableMap(c10);
        }

        @Override // com.google.protobuf.h0.b, com.google.protobuf.g1
        public Object getField(n.g gVar) {
            Object h10;
            if (gVar.v()) {
                l(gVar);
                b0.b bVar = this.f١١٠٢٥a;
                if (bVar == null) {
                    h10 = null;
                } else {
                    h10 = bVar.h(gVar);
                }
                if (h10 == null) {
                    if (gVar.q() == n.g.b.MESSAGE) {
                        return q.k(gVar.r());
                    }
                    return gVar.m();
                }
                return h10;
            }
            return super.getField(gVar);
        }

        @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a
        public b1.a getFieldBuilder(n.g gVar) {
            if (gVar.v()) {
                l(gVar);
                if (gVar.q() == n.g.b.MESSAGE) {
                    h();
                    Object i10 = this.f١١٠٢٥a.i(gVar);
                    if (i10 == null) {
                        q.b n10 = q.n(gVar.r());
                        this.f١١٠٢٥a.u(gVar, n10);
                        onChanged();
                        return n10;
                    }
                    if (i10 instanceof b1.a) {
                        return (b1.a) i10;
                    }
                    if (i10 instanceof b1) {
                        b1.a builder = ((b1) i10).toBuilder();
                        this.f١١٠٢٥a.u(gVar, builder);
                        onChanged();
                        return builder;
                    }
                    throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
                }
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }
            return super.getFieldBuilder(gVar);
        }

        @Override // com.google.protobuf.h0.b
        public Object getRepeatedField(n.g gVar, int i10) {
            if (gVar.v()) {
                l(gVar);
                b0.b bVar = this.f١١٠٢٥a;
                if (bVar != null) {
                    return bVar.j(gVar, i10);
                }
                throw new IndexOutOfBoundsException();
            }
            return super.getRepeatedField(gVar, i10);
        }

        @Override // com.google.protobuf.h0.b
        public b1.a getRepeatedFieldBuilder(n.g gVar, int i10) {
            if (gVar.v()) {
                l(gVar);
                h();
                if (gVar.q() == n.g.b.MESSAGE) {
                    Object k10 = this.f١١٠٢٥a.k(gVar, i10);
                    if (k10 instanceof b1.a) {
                        return (b1.a) k10;
                    }
                    if (k10 instanceof b1) {
                        b1.a builder = ((b1) k10).toBuilder();
                        this.f١١٠٢٥a.v(gVar, i10, builder);
                        onChanged();
                        return builder;
                    }
                    throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
                }
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
            return super.getRepeatedFieldBuilder(gVar, i10);
        }

        @Override // com.google.protobuf.h0.b
        public int getRepeatedFieldCount(n.g gVar) {
            if (gVar.v()) {
                l(gVar);
                b0.b bVar = this.f١١٠٢٥a;
                if (bVar == null) {
                    return 0;
                }
                return bVar.l(gVar);
            }
            return super.getRepeatedFieldCount(gVar);
        }

        @Override // com.google.protobuf.h0.b, com.google.protobuf.g1
        public boolean hasField(n.g gVar) {
            if (gVar.v()) {
                l(gVar);
                b0.b bVar = this.f١١٠٢٥a;
                if (bVar == null) {
                    return false;
                }
                return bVar.m(gVar);
            }
            return super.hasField(gVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean i() {
            b0.b bVar = this.f١١٠٢٥a;
            if (bVar == null) {
                return true;
            }
            return bVar.n();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void j(e eVar) {
            if (eVar.f١١٠٢٦a != null) {
                h();
                this.f١١٠٢٥a.o(eVar.f١١٠٢٦a);
                onChanged();
            }
        }

        public d k(n.g gVar, Object obj) {
            if (gVar.v()) {
                l(gVar);
                h();
                this.f١١٠٢٥a.u(gVar, obj);
                onChanged();
                return this;
            }
            return (d) super.setField(gVar, obj);
        }

        @Override // com.google.protobuf.h0.b, com.google.protobuf.b1.a
        public b1.a newBuilderForField(n.g gVar) {
            if (gVar.v()) {
                return q.n(gVar.r());
            }
            return super.newBuilderForField(gVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.h0.b
        public boolean parseUnknownField(i iVar, v vVar, int i10) {
            k2.b unknownFieldSetBuilder;
            h();
            if (iVar.N()) {
                unknownFieldSetBuilder = null;
            } else {
                unknownFieldSetBuilder = getUnknownFieldSetBuilder();
            }
            return h1.d(iVar, unknownFieldSetBuilder, vVar, getDescriptorForType(), new h1.d(this.f١١٠٢٥a), i10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public d(c cVar) {
            super(cVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        private final n.b f١١٠٣١a;

        /* renamed from: b, reason: collision with root package name */
        private final a[] f١١٠٣٢b;

        /* renamed from: c, reason: collision with root package name */
        private String[] f١١٠٣٣c;

        /* renamed from: d, reason: collision with root package name */
        private final c[] f١١٠٣٤d;

        /* renamed from: e, reason: collision with root package name */
        private volatile boolean f١١٠٣٥e = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public interface a {
            void a(b bVar);

            Object b(h0 h0Var);

            Object c(b bVar);

            int d(b bVar);

            int e(h0 h0Var);

            void f(b bVar, Object obj);

            void g(b bVar, Object obj);

            boolean h(h0 h0Var);

            void i(b bVar, int i10, Object obj);

            Object j(b bVar, int i10);

            Object k(h0 h0Var, int i10);

            boolean l(b bVar);

            b1.a m(b bVar, int i10);

            Object n(h0 h0Var);

            b1.a newBuilder();

            b1.a o(b bVar);
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static class b implements a {

            /* renamed from: a, reason: collision with root package name */
            private final n.g f١١٠٣٦a;

            /* renamed from: b, reason: collision with root package name */
            private final b1 f١١٠٣٧b;

            b(n.g gVar, String str, Class cls, Class cls2) {
                this.f١١٠٣٦a = gVar;
                this.f١١٠٣٧b = r((h0) h0.j(h0.i(cls, "getDefaultInstance", new Class[0]), null, new Object[0])).i();
            }

            private b1 p(b1 b1Var) {
                if (b1Var == null) {
                    return null;
                }
                if (this.f١١٠٣٧b.getClass().isInstance(b1Var)) {
                    return b1Var;
                }
                return this.f١١٠٣٧b.toBuilder().mergeFrom(b1Var).build();
            }

            private v0 q(b bVar) {
                return bVar.internalGetMapField(this.f١١٠٣٦a.getNumber());
            }

            private v0 r(h0 h0Var) {
                return h0Var.internalGetMapField(this.f١١٠٣٦a.getNumber());
            }

            private v0 s(b bVar) {
                return bVar.internalGetMutableMapField(this.f١١٠٣٦a.getNumber());
            }

            @Override // com.google.protobuf.h0.f.a
            public void a(b bVar) {
                s(bVar).j().clear();
            }

            @Override // com.google.protobuf.h0.f.a
            public Object b(h0 h0Var) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < e(h0Var); i10++) {
                    arrayList.add(k(h0Var, i10));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.h0.f.a
            public Object c(b bVar) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < d(bVar); i10++) {
                    arrayList.add(j(bVar, i10));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.h0.f.a
            public int d(b bVar) {
                return q(bVar).g().size();
            }

            @Override // com.google.protobuf.h0.f.a
            public int e(h0 h0Var) {
                return r(h0Var).g().size();
            }

            @Override // com.google.protobuf.h0.f.a
            public void f(b bVar, Object obj) {
                a(bVar);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    g(bVar, it.next());
                }
            }

            @Override // com.google.protobuf.h0.f.a
            public void g(b bVar, Object obj) {
                s(bVar).j().add(p((b1) obj));
            }

            @Override // com.google.protobuf.h0.f.a
            public boolean h(h0 h0Var) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.h0.f.a
            public void i(b bVar, int i10, Object obj) {
                s(bVar).j().set(i10, p((b1) obj));
            }

            @Override // com.google.protobuf.h0.f.a
            public Object j(b bVar, int i10) {
                return q(bVar).g().get(i10);
            }

            @Override // com.google.protobuf.h0.f.a
            public Object k(h0 h0Var, int i10) {
                return r(h0Var).g().get(i10);
            }

            @Override // com.google.protobuf.h0.f.a
            public boolean l(b bVar) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.h0.f.a
            public b1.a m(b bVar, int i10) {
                throw new UnsupportedOperationException("Map fields cannot be repeated");
            }

            @Override // com.google.protobuf.h0.f.a
            public Object n(h0 h0Var) {
                return b(h0Var);
            }

            @Override // com.google.protobuf.h0.f.a
            public b1.a newBuilder() {
                return this.f١١٠٣٧b.newBuilderForType();
            }

            @Override // com.google.protobuf.h0.f.a
            public b1.a o(b bVar) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            private final n.b f١١٠٣٨a;

            /* renamed from: b, reason: collision with root package name */
            private final Method f١١٠٣٩b;

            /* renamed from: c, reason: collision with root package name */
            private final Method f١١٠٤٠c;

            /* renamed from: d, reason: collision with root package name */
            private final Method f١١٠٤١d;

            /* renamed from: e, reason: collision with root package name */
            private final n.g f١١٠٤٢e;

            c(n.b bVar, int i10, String str, Class cls, Class cls2) {
                this.f١١٠٣٨a = bVar;
                n.l lVar = (n.l) bVar.l().get(i10);
                if (lVar.n()) {
                    this.f١١٠٣٩b = null;
                    this.f١١٠٤٠c = null;
                    this.f١١٠٤٢e = (n.g) lVar.l().get(0);
                } else {
                    this.f١١٠٣٩b = h0.i(cls, "get" + str + "Case", new Class[0]);
                    this.f١١٠٤٠c = h0.i(cls2, "get" + str + "Case", new Class[0]);
                    this.f١١٠٤٢e = null;
                }
                this.f١١٠٤١d = h0.i(cls2, "clear" + str, new Class[0]);
            }

            public void a(b bVar) {
                h0.j(this.f١١٠٤١d, bVar, new Object[0]);
            }

            public n.g b(b bVar) {
                n.g gVar = this.f١١٠٤٢e;
                if (gVar != null) {
                    if (!bVar.hasField(gVar)) {
                        return null;
                    }
                    return this.f١١٠٤٢e;
                }
                int number = ((j0.c) h0.j(this.f١١٠٤٠c, bVar, new Object[0])).getNumber();
                if (number <= 0) {
                    return null;
                }
                return this.f١١٠٣٨a.i(number);
            }

            public n.g c(h0 h0Var) {
                n.g gVar = this.f١١٠٤٢e;
                if (gVar != null) {
                    if (!h0Var.hasField(gVar)) {
                        return null;
                    }
                    return this.f١١٠٤٢e;
                }
                int number = ((j0.c) h0.j(this.f١١٠٣٩b, h0Var, new Object[0])).getNumber();
                if (number <= 0) {
                    return null;
                }
                return this.f١١٠٣٨a.i(number);
            }

            public boolean d(b bVar) {
                n.g gVar = this.f١١٠٤٢e;
                if (gVar != null) {
                    return bVar.hasField(gVar);
                }
                if (((j0.c) h0.j(this.f١١٠٤٠c, bVar, new Object[0])).getNumber() == 0) {
                    return false;
                }
                return true;
            }

            public boolean e(h0 h0Var) {
                n.g gVar = this.f١١٠٤٢e;
                if (gVar != null) {
                    return h0Var.hasField(gVar);
                }
                if (((j0.c) h0.j(this.f١١٠٣٩b, h0Var, new Object[0])).getNumber() == 0) {
                    return false;
                }
                return true;
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static final class d extends e {

            /* renamed from: c, reason: collision with root package name */
            private n.e f١١٠٤٣c;

            /* renamed from: d, reason: collision with root package name */
            private final Method f١١٠٤٤d;

            /* renamed from: e, reason: collision with root package name */
            private final Method f١١٠٤٥e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f١١٠٤٦f;

            /* renamed from: g, reason: collision with root package name */
            private Method f١١٠٤٧g;

            /* renamed from: h, reason: collision with root package name */
            private Method f١١٠٤٨h;

            /* renamed from: i, reason: collision with root package name */
            private Method f١١٠٤٩i;

            /* renamed from: j, reason: collision with root package name */
            private Method f١١٠٥٠j;

            d(n.g gVar, String str, Class cls, Class cls2) {
                super(gVar, str, cls, cls2);
                this.f١١٠٤٣c = gVar.n();
                this.f١١٠٤٤d = h0.i(this.f١١٠٥١a, "valueOf", n.f.class);
                this.f١١٠٤٥e = h0.i(this.f١١٠٥١a, "getValueDescriptor", new Class[0]);
                boolean q10 = gVar.a().q();
                this.f١١٠٤٦f = q10;
                if (q10) {
                    Class cls3 = Integer.TYPE;
                    this.f١١٠٤٧g = h0.i(cls, "get" + str + "Value", cls3);
                    this.f١١٠٤٨h = h0.i(cls2, "get" + str + "Value", cls3);
                    this.f١١٠٤٩i = h0.i(cls2, "set" + str + "Value", cls3, cls3);
                    this.f١١٠٥٠j = h0.i(cls2, "add" + str + "Value", cls3);
                }
            }

            @Override // com.google.protobuf.h0.f.e, com.google.protobuf.h0.f.a
            public Object b(h0 h0Var) {
                ArrayList arrayList = new ArrayList();
                int e10 = e(h0Var);
                for (int i10 = 0; i10 < e10; i10++) {
                    arrayList.add(k(h0Var, i10));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.h0.f.e, com.google.protobuf.h0.f.a
            public Object c(b bVar) {
                ArrayList arrayList = new ArrayList();
                int d10 = d(bVar);
                for (int i10 = 0; i10 < d10; i10++) {
                    arrayList.add(j(bVar, i10));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.google.protobuf.h0.f.e, com.google.protobuf.h0.f.a
            public void g(b bVar, Object obj) {
                if (this.f١١٠٤٦f) {
                    h0.j(this.f١١٠٥٠j, bVar, Integer.valueOf(((n.f) obj).getNumber()));
                } else {
                    super.g(bVar, h0.j(this.f١١٠٤٤d, null, obj));
                }
            }

            @Override // com.google.protobuf.h0.f.e, com.google.protobuf.h0.f.a
            public void i(b bVar, int i10, Object obj) {
                if (this.f١١٠٤٦f) {
                    h0.j(this.f١١٠٤٩i, bVar, Integer.valueOf(i10), Integer.valueOf(((n.f) obj).getNumber()));
                } else {
                    super.i(bVar, i10, h0.j(this.f١١٠٤٤d, null, obj));
                }
            }

            @Override // com.google.protobuf.h0.f.e, com.google.protobuf.h0.f.a
            public Object j(b bVar, int i10) {
                if (!this.f١١٠٤٦f) {
                    return h0.j(this.f١١٠٤٥e, super.j(bVar, i10), new Object[0]);
                }
                return this.f١١٠٤٣c.i(((Integer) h0.j(this.f١١٠٤٨h, bVar, Integer.valueOf(i10))).intValue());
            }

            @Override // com.google.protobuf.h0.f.e, com.google.protobuf.h0.f.a
            public Object k(h0 h0Var, int i10) {
                if (!this.f١١٠٤٦f) {
                    return h0.j(this.f١١٠٤٥e, super.k(h0Var, i10), new Object[0]);
                }
                return this.f١١٠٤٣c.i(((Integer) h0.j(this.f١١٠٤٧g, h0Var, Integer.valueOf(i10))).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class e implements a {

            /* renamed from: a, reason: collision with root package name */
            protected final Class f١١٠٥١a;

            /* renamed from: b, reason: collision with root package name */
            protected final a f١١٠٥٢b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            public interface a {
                void a(b bVar);

                Object b(h0 h0Var);

                Object c(b bVar);

                int d(b bVar);

                int e(h0 h0Var);

                void g(b bVar, Object obj);

                void i(b bVar, int i10, Object obj);

                Object j(b bVar, int i10);

                Object k(h0 h0Var, int i10);
            }

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            private static final class b implements a {

                /* renamed from: a, reason: collision with root package name */
                protected final Method f١١٠٥٣a;

                /* renamed from: b, reason: collision with root package name */
                protected final Method f١١٠٥٤b;

                /* renamed from: c, reason: collision with root package name */
                protected final Method f١١٠٥٥c;

                /* renamed from: d, reason: collision with root package name */
                protected final Method f١١٠٥٦d;

                /* renamed from: e, reason: collision with root package name */
                protected final Method f١١٠٥٧e;

                /* renamed from: f, reason: collision with root package name */
                protected final Method f١١٠٥٨f;

                /* renamed from: g, reason: collision with root package name */
                protected final Method f١١٠٥٩g;

                /* renamed from: h, reason: collision with root package name */
                protected final Method f١١٠٦٠h;

                /* renamed from: i, reason: collision with root package name */
                protected final Method f١١٠٦١i;

                b(n.g gVar, String str, Class cls, Class cls2) {
                    this.f١١٠٥٣a = h0.i(cls, "get" + str + "List", new Class[0]);
                    this.f١١٠٥٤b = h0.i(cls2, "get" + str + "List", new Class[0]);
                    StringBuilder sb = new StringBuilder();
                    sb.append("get");
                    sb.append(str);
                    String sb2 = sb.toString();
                    Class cls3 = Integer.TYPE;
                    Method i10 = h0.i(cls, sb2, cls3);
                    this.f١١٠٥٥c = i10;
                    this.f١١٠٥٦d = h0.i(cls2, "get" + str, cls3);
                    Class<?> returnType = i10.getReturnType();
                    this.f١١٠٥٧e = h0.i(cls2, "set" + str, cls3, returnType);
                    this.f١١٠٥٨f = h0.i(cls2, "add" + str, returnType);
                    this.f١١٠٥٩g = h0.i(cls, "get" + str + "Count", new Class[0]);
                    this.f١١٠٦٠h = h0.i(cls2, "get" + str + "Count", new Class[0]);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("clear");
                    sb3.append(str);
                    this.f١١٠٦١i = h0.i(cls2, sb3.toString(), new Class[0]);
                }

                @Override // com.google.protobuf.h0.f.e.a
                public void a(b bVar) {
                    h0.j(this.f١١٠٦١i, bVar, new Object[0]);
                }

                @Override // com.google.protobuf.h0.f.e.a
                public Object b(h0 h0Var) {
                    return h0.j(this.f١١٠٥٣a, h0Var, new Object[0]);
                }

                @Override // com.google.protobuf.h0.f.e.a
                public Object c(b bVar) {
                    return h0.j(this.f١١٠٥٤b, bVar, new Object[0]);
                }

                @Override // com.google.protobuf.h0.f.e.a
                public int d(b bVar) {
                    return ((Integer) h0.j(this.f١١٠٦٠h, bVar, new Object[0])).intValue();
                }

                @Override // com.google.protobuf.h0.f.e.a
                public int e(h0 h0Var) {
                    return ((Integer) h0.j(this.f١١٠٥٩g, h0Var, new Object[0])).intValue();
                }

                @Override // com.google.protobuf.h0.f.e.a
                public void g(b bVar, Object obj) {
                    h0.j(this.f١١٠٥٨f, bVar, obj);
                }

                @Override // com.google.protobuf.h0.f.e.a
                public void i(b bVar, int i10, Object obj) {
                    h0.j(this.f١١٠٥٧e, bVar, Integer.valueOf(i10), obj);
                }

                @Override // com.google.protobuf.h0.f.e.a
                public Object j(b bVar, int i10) {
                    return h0.j(this.f١١٠٥٦d, bVar, Integer.valueOf(i10));
                }

                @Override // com.google.protobuf.h0.f.e.a
                public Object k(h0 h0Var, int i10) {
                    return h0.j(this.f١١٠٥٥c, h0Var, Integer.valueOf(i10));
                }
            }

            e(n.g gVar, String str, Class cls, Class cls2) {
                b bVar = new b(gVar, str, cls, cls2);
                this.f١١٠٥١a = bVar.f١١٠٥٥c.getReturnType();
                this.f١١٠٥٢b = p(bVar);
            }

            static a p(b bVar) {
                return bVar;
            }

            @Override // com.google.protobuf.h0.f.a
            public void a(b bVar) {
                this.f١١٠٥٢b.a(bVar);
            }

            @Override // com.google.protobuf.h0.f.a
            public Object b(h0 h0Var) {
                return this.f١١٠٥٢b.b(h0Var);
            }

            @Override // com.google.protobuf.h0.f.a
            public Object c(b bVar) {
                return this.f١١٠٥٢b.c(bVar);
            }

            @Override // com.google.protobuf.h0.f.a
            public int d(b bVar) {
                return this.f١١٠٥٢b.d(bVar);
            }

            @Override // com.google.protobuf.h0.f.a
            public int e(h0 h0Var) {
                return this.f١١٠٥٢b.e(h0Var);
            }

            @Override // com.google.protobuf.h0.f.a
            public void f(b bVar, Object obj) {
                a(bVar);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    g(bVar, it.next());
                }
            }

            @Override // com.google.protobuf.h0.f.a
            public void g(b bVar, Object obj) {
                this.f١١٠٥٢b.g(bVar, obj);
            }

            @Override // com.google.protobuf.h0.f.a
            public boolean h(h0 h0Var) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.h0.f.a
            public void i(b bVar, int i10, Object obj) {
                this.f١١٠٥٢b.i(bVar, i10, obj);
            }

            @Override // com.google.protobuf.h0.f.a
            public Object j(b bVar, int i10) {
                return this.f١١٠٥٢b.j(bVar, i10);
            }

            @Override // com.google.protobuf.h0.f.a
            public Object k(h0 h0Var, int i10) {
                return this.f١١٠٥٢b.k(h0Var, i10);
            }

            @Override // com.google.protobuf.h0.f.a
            public boolean l(b bVar) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.h0.f.a
            public b1.a m(b bVar, int i10) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.h0.f.a
            public Object n(h0 h0Var) {
                return b(h0Var);
            }

            @Override // com.google.protobuf.h0.f.a
            public b1.a newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.h0.f.a
            public b1.a o(b bVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }
        }

        /* renamed from: com.google.protobuf.h0$f$f, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static final class C٠١٣٦f extends e {

            /* renamed from: c, reason: collision with root package name */
            private final Method f١١٠٦٢c;

            /* renamed from: d, reason: collision with root package name */
            private final Method f١١٠٦٣d;

            C٠١٣٦f(n.g gVar, String str, Class cls, Class cls2) {
                super(gVar, str, cls, cls2);
                this.f١١٠٦٢c = h0.i(this.f١١٠٥١a, "newBuilder", new Class[0]);
                this.f١١٠٦٣d = h0.i(cls2, "get" + str + "Builder", Integer.TYPE);
            }

            private Object q(Object obj) {
                if (this.f١١٠٥١a.isInstance(obj)) {
                    return obj;
                }
                return ((b1.a) h0.j(this.f١١٠٦٢c, null, new Object[0])).mergeFrom((b1) obj).build();
            }

            @Override // com.google.protobuf.h0.f.e, com.google.protobuf.h0.f.a
            public void g(b bVar, Object obj) {
                super.g(bVar, q(obj));
            }

            @Override // com.google.protobuf.h0.f.e, com.google.protobuf.h0.f.a
            public void i(b bVar, int i10, Object obj) {
                super.i(bVar, i10, q(obj));
            }

            @Override // com.google.protobuf.h0.f.e, com.google.protobuf.h0.f.a
            public b1.a m(b bVar, int i10) {
                return (b1.a) h0.j(this.f١١٠٦٣d, bVar, Integer.valueOf(i10));
            }

            @Override // com.google.protobuf.h0.f.e, com.google.protobuf.h0.f.a
            public b1.a newBuilder() {
                return (b1.a) h0.j(this.f١١٠٦٢c, null, new Object[0]);
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static final class g extends h {

            /* renamed from: f, reason: collision with root package name */
            private n.e f١١٠٦٤f;

            /* renamed from: g, reason: collision with root package name */
            private Method f١١٠٦٥g;

            /* renamed from: h, reason: collision with root package name */
            private Method f١١٠٦٦h;

            /* renamed from: i, reason: collision with root package name */
            private boolean f١١٠٦٧i;

            /* renamed from: j, reason: collision with root package name */
            private Method f١١٠٦٨j;

            /* renamed from: k, reason: collision with root package name */
            private Method f١١٠٦٩k;

            /* renamed from: l, reason: collision with root package name */
            private Method f١١٠٧٠l;

            g(n.g gVar, String str, Class cls, Class cls2, String str2) {
                super(gVar, str, cls, cls2, str2);
                this.f١١٠٦٤f = gVar.n();
                this.f١١٠٦٥g = h0.i(this.f١١٠٧١a, "valueOf", n.f.class);
                this.f١١٠٦٦h = h0.i(this.f١١٠٧١a, "getValueDescriptor", new Class[0]);
                boolean q10 = gVar.a().q();
                this.f١١٠٦٧i = q10;
                if (q10) {
                    this.f١١٠٦٨j = h0.i(cls, "get" + str + "Value", new Class[0]);
                    this.f١١٠٦٩k = h0.i(cls2, "get" + str + "Value", new Class[0]);
                    this.f١١٠٧٠l = h0.i(cls2, "set" + str + "Value", Integer.TYPE);
                }
            }

            @Override // com.google.protobuf.h0.f.h, com.google.protobuf.h0.f.a
            public Object b(h0 h0Var) {
                if (!this.f١١٠٦٧i) {
                    return h0.j(this.f١١٠٦٦h, super.b(h0Var), new Object[0]);
                }
                return this.f١١٠٦٤f.i(((Integer) h0.j(this.f١١٠٦٨j, h0Var, new Object[0])).intValue());
            }

            @Override // com.google.protobuf.h0.f.h, com.google.protobuf.h0.f.a
            public Object c(b bVar) {
                if (!this.f١١٠٦٧i) {
                    return h0.j(this.f١١٠٦٦h, super.c(bVar), new Object[0]);
                }
                return this.f١١٠٦٤f.i(((Integer) h0.j(this.f١١٠٦٩k, bVar, new Object[0])).intValue());
            }

            @Override // com.google.protobuf.h0.f.h, com.google.protobuf.h0.f.a
            public void f(b bVar, Object obj) {
                if (this.f١١٠٦٧i) {
                    h0.j(this.f١١٠٧٠l, bVar, Integer.valueOf(((n.f) obj).getNumber()));
                } else {
                    super.f(bVar, h0.j(this.f١١٠٦٥g, null, obj));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class h implements a {

            /* renamed from: a, reason: collision with root package name */
            protected final Class f١١٠٧١a;

            /* renamed from: b, reason: collision with root package name */
            protected final n.g f١١٠٧٢b;

            /* renamed from: c, reason: collision with root package name */
            protected final boolean f١١٠٧٣c;

            /* renamed from: d, reason: collision with root package name */
            protected final boolean f١١٠٧٤d;

            /* renamed from: e, reason: collision with root package name */
            protected final a f١١٠٧٥e;

            /* JADX INFO: Access modifiers changed from: private */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            public interface a {
                void a(b bVar);

                Object b(h0 h0Var);

                Object c(b bVar);

                int d(h0 h0Var);

                int e(b bVar);

                void f(b bVar, Object obj);

                boolean h(h0 h0Var);

                boolean l(b bVar);
            }

            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
            private static final class b implements a {

                /* renamed from: a, reason: collision with root package name */
                protected final Method f١١٠٧٦a;

                /* renamed from: b, reason: collision with root package name */
                protected final Method f١١٠٧٧b;

                /* renamed from: c, reason: collision with root package name */
                protected final Method f١١٠٧٨c;

                /* renamed from: d, reason: collision with root package name */
                protected final Method f١١٠٧٩d;

                /* renamed from: e, reason: collision with root package name */
                protected final Method f١١٠٨٠e;

                /* renamed from: f, reason: collision with root package name */
                protected final Method f١١٠٨١f;

                /* renamed from: g, reason: collision with root package name */
                protected final Method f١١٠٨٢g;

                /* renamed from: h, reason: collision with root package name */
                protected final Method f١١٠٨٣h;

                b(n.g gVar, String str, Class cls, Class cls2, String str2, boolean z10, boolean z11) {
                    Method method;
                    Method method2;
                    Method method3;
                    Method i10 = h0.i(cls, "get" + str, new Class[0]);
                    this.f١١٠٧٦a = i10;
                    this.f١١٠٧٧b = h0.i(cls2, "get" + str, new Class[0]);
                    this.f١١٠٧٨c = h0.i(cls2, "set" + str, i10.getReturnType());
                    Method method4 = null;
                    if (z11) {
                        method = h0.i(cls, "has" + str, new Class[0]);
                    } else {
                        method = null;
                    }
                    this.f١١٠٧٩d = method;
                    if (z11) {
                        method2 = h0.i(cls2, "has" + str, new Class[0]);
                    } else {
                        method2 = null;
                    }
                    this.f١١٠٨٠e = method2;
                    this.f١١٠٨١f = h0.i(cls2, "clear" + str, new Class[0]);
                    if (z10) {
                        method3 = h0.i(cls, "get" + str2 + "Case", new Class[0]);
                    } else {
                        method3 = null;
                    }
                    this.f١١٠٨٢g = method3;
                    if (z10) {
                        method4 = h0.i(cls2, "get" + str2 + "Case", new Class[0]);
                    }
                    this.f١١٠٨٣h = method4;
                }

                @Override // com.google.protobuf.h0.f.h.a
                public void a(b bVar) {
                    h0.j(this.f١١٠٨١f, bVar, new Object[0]);
                }

                @Override // com.google.protobuf.h0.f.h.a
                public Object b(h0 h0Var) {
                    return h0.j(this.f١١٠٧٦a, h0Var, new Object[0]);
                }

                @Override // com.google.protobuf.h0.f.h.a
                public Object c(b bVar) {
                    return h0.j(this.f١١٠٧٧b, bVar, new Object[0]);
                }

                @Override // com.google.protobuf.h0.f.h.a
                public int d(h0 h0Var) {
                    return ((j0.c) h0.j(this.f١١٠٨٢g, h0Var, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.h0.f.h.a
                public int e(b bVar) {
                    return ((j0.c) h0.j(this.f١١٠٨٣h, bVar, new Object[0])).getNumber();
                }

                @Override // com.google.protobuf.h0.f.h.a
                public void f(b bVar, Object obj) {
                    h0.j(this.f١١٠٧٨c, bVar, obj);
                }

                @Override // com.google.protobuf.h0.f.h.a
                public boolean h(h0 h0Var) {
                    return ((Boolean) h0.j(this.f١١٠٧٩d, h0Var, new Object[0])).booleanValue();
                }

                @Override // com.google.protobuf.h0.f.h.a
                public boolean l(b bVar) {
                    return ((Boolean) h0.j(this.f١١٠٨٠e, bVar, new Object[0])).booleanValue();
                }
            }

            h(n.g gVar, String str, Class cls, Class cls2, String str2) {
                boolean z10;
                boolean z11;
                if (gVar.k() != null && !gVar.k().n()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f١١٠٧٣c = z10;
                if (gVar.a().n() != n.h.a.PROTO2 && !gVar.u() && (z10 || gVar.q() != n.g.b.MESSAGE)) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                this.f١١٠٧٤d = z11;
                b bVar = new b(gVar, str, cls, cls2, str2, z10, z11);
                this.f١١٠٧٢b = gVar;
                this.f١١٠٧١a = bVar.f١١٠٧٦a.getReturnType();
                this.f١١٠٧٥e = p(bVar);
            }

            static a p(b bVar) {
                return bVar;
            }

            @Override // com.google.protobuf.h0.f.a
            public void a(b bVar) {
                this.f١١٠٧٥e.a(bVar);
            }

            @Override // com.google.protobuf.h0.f.a
            public Object b(h0 h0Var) {
                return this.f١١٠٧٥e.b(h0Var);
            }

            @Override // com.google.protobuf.h0.f.a
            public Object c(b bVar) {
                return this.f١١٠٧٥e.c(bVar);
            }

            @Override // com.google.protobuf.h0.f.a
            public int d(b bVar) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.h0.f.a
            public int e(h0 h0Var) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.h0.f.a
            public void f(b bVar, Object obj) {
                this.f١١٠٧٥e.f(bVar, obj);
            }

            @Override // com.google.protobuf.h0.f.a
            public void g(b bVar, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.h0.f.a
            public boolean h(h0 h0Var) {
                if (!this.f١١٠٧٤d) {
                    if (this.f١١٠٧٣c) {
                        if (this.f١١٠٧٥e.d(h0Var) == this.f١١٠٧٢b.getNumber()) {
                            return true;
                        }
                        return false;
                    }
                    return !b(h0Var).equals(this.f١١٠٧٢b.m());
                }
                return this.f١١٠٧٥e.h(h0Var);
            }

            @Override // com.google.protobuf.h0.f.a
            public void i(b bVar, int i10, Object obj) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.h0.f.a
            public Object j(b bVar, int i10) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.h0.f.a
            public Object k(h0 h0Var, int i10) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.h0.f.a
            public boolean l(b bVar) {
                if (!this.f١١٠٧٤d) {
                    if (this.f١١٠٧٣c) {
                        if (this.f١١٠٧٥e.e(bVar) == this.f١١٠٧٢b.getNumber()) {
                            return true;
                        }
                        return false;
                    }
                    return !c(bVar).equals(this.f١١٠٧٢b.m());
                }
                return this.f١١٠٧٥e.l(bVar);
            }

            @Override // com.google.protobuf.h0.f.a
            public b1.a m(b bVar, int i10) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.h0.f.a
            public Object n(h0 h0Var) {
                return b(h0Var);
            }

            @Override // com.google.protobuf.h0.f.a
            public b1.a newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.h0.f.a
            public b1.a o(b bVar) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static final class i extends h {

            /* renamed from: f, reason: collision with root package name */
            private final Method f١١٠٨٤f;

            /* renamed from: g, reason: collision with root package name */
            private final Method f١١٠٨٥g;

            i(n.g gVar, String str, Class cls, Class cls2, String str2) {
                super(gVar, str, cls, cls2, str2);
                this.f١١٠٨٤f = h0.i(this.f١١٠٧١a, "newBuilder", new Class[0]);
                this.f١١٠٨٥g = h0.i(cls2, "get" + str + "Builder", new Class[0]);
            }

            private Object q(Object obj) {
                if (this.f١١٠٧١a.isInstance(obj)) {
                    return obj;
                }
                return ((b1.a) h0.j(this.f١١٠٨٤f, null, new Object[0])).mergeFrom((b1) obj).buildPartial();
            }

            @Override // com.google.protobuf.h0.f.h, com.google.protobuf.h0.f.a
            public void f(b bVar, Object obj) {
                super.f(bVar, q(obj));
            }

            @Override // com.google.protobuf.h0.f.h, com.google.protobuf.h0.f.a
            public b1.a newBuilder() {
                return (b1.a) h0.j(this.f١١٠٨٤f, null, new Object[0]);
            }

            @Override // com.google.protobuf.h0.f.h, com.google.protobuf.h0.f.a
            public b1.a o(b bVar) {
                return (b1.a) h0.j(this.f١١٠٨٥g, bVar, new Object[0]);
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static final class j extends h {

            /* renamed from: f, reason: collision with root package name */
            private final Method f١١٠٨٦f;

            /* renamed from: g, reason: collision with root package name */
            private final Method f١١٠٨٧g;

            /* renamed from: h, reason: collision with root package name */
            private final Method f١١٠٨٨h;

            j(n.g gVar, String str, Class cls, Class cls2, String str2) {
                super(gVar, str, cls, cls2, str2);
                this.f١١٠٨٦f = h0.i(cls, "get" + str + "Bytes", new Class[0]);
                this.f١١٠٨٧g = h0.i(cls2, "get" + str + "Bytes", new Class[0]);
                this.f١١٠٨٨h = h0.i(cls2, "set" + str + "Bytes", com.google.protobuf.h.class);
            }

            @Override // com.google.protobuf.h0.f.h, com.google.protobuf.h0.f.a
            public void f(b bVar, Object obj) {
                if (obj instanceof com.google.protobuf.h) {
                    h0.j(this.f١١٠٨٨h, bVar, obj);
                } else {
                    super.f(bVar, obj);
                }
            }

            @Override // com.google.protobuf.h0.f.h, com.google.protobuf.h0.f.a
            public Object n(h0 h0Var) {
                return h0.j(this.f١١٠٨٦f, h0Var, new Object[0]);
            }
        }

        public f(n.b bVar, String[] strArr) {
            this.f١١٠٣١a = bVar;
            this.f١١٠٣٣c = strArr;
            this.f١١٠٣٢b = new a[bVar.j().size()];
            this.f١١٠٣٤d = new c[bVar.l().size()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a e(n.g gVar) {
            if (gVar.l() == this.f١١٠٣١a) {
                if (!gVar.v()) {
                    return this.f١١٠٣٢b[gVar.p()];
                }
                throw new IllegalArgumentException("This type does not have extensions.");
            }
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public c f(n.l lVar) {
            if (lVar.j() == this.f١١٠٣١a) {
                return this.f١١٠٣٤d[lVar.m()];
            }
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        public f d(Class cls, Class cls2) {
            if (this.f١١٠٣٥e) {
                return this;
            }
            synchronized (this) {
                try {
                    if (this.f١١٠٣٥e) {
                        return this;
                    }
                    int length = this.f١١٠٣٢b.length;
                    int i10 = 0;
                    while (true) {
                        String str = null;
                        if (i10 >= length) {
                            break;
                        }
                        n.g gVar = (n.g) this.f١١٠٣١a.j().get(i10);
                        if (gVar.k() != null) {
                            str = this.f١١٠٣٣c[gVar.k().m() + length];
                        }
                        String str2 = str;
                        if (gVar.isRepeated()) {
                            if (gVar.q() == n.g.b.MESSAGE) {
                                if (gVar.w()) {
                                    this.f١١٠٣٢b[i10] = new b(gVar, this.f١١٠٣٣c[i10], cls, cls2);
                                } else {
                                    this.f١١٠٣٢b[i10] = new C٠١٣٦f(gVar, this.f١١٠٣٣c[i10], cls, cls2);
                                }
                            } else if (gVar.q() == n.g.b.ENUM) {
                                this.f١١٠٣٢b[i10] = new d(gVar, this.f١١٠٣٣c[i10], cls, cls2);
                            } else {
                                this.f١١٠٣٢b[i10] = new e(gVar, this.f١١٠٣٣c[i10], cls, cls2);
                            }
                        } else if (gVar.q() == n.g.b.MESSAGE) {
                            this.f١١٠٣٢b[i10] = new i(gVar, this.f١١٠٣٣c[i10], cls, cls2, str2);
                        } else if (gVar.q() == n.g.b.ENUM) {
                            this.f١١٠٣٢b[i10] = new g(gVar, this.f١١٠٣٣c[i10], cls, cls2, str2);
                        } else if (gVar.q() == n.g.b.STRING) {
                            this.f١١٠٣٢b[i10] = new j(gVar, this.f١١٠٣٣c[i10], cls, cls2, str2);
                        } else {
                            this.f١١٠٣٢b[i10] = new h(gVar, this.f١١٠٣٣c[i10], cls, cls2, str2);
                        }
                        i10++;
                    }
                    int length2 = this.f١١٠٣٤d.length;
                    for (int i11 = 0; i11 < length2; i11++) {
                        this.f١١٠٣٤d[i11] = new c(this.f١١٠٣١a, i11, this.f١١٠٣٣c[i11 + length], cls, cls2);
                    }
                    this.f١١٠٣٥e = true;
                    this.f١١٠٣٣c = null;
                    return this;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    protected static final class g {

        /* renamed from: a, reason: collision with root package name */
        static final g f١١٠٨٩a = new g();

        private g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h0() {
        this.unknownFields = k2.c();
    }

    static /* synthetic */ r access$500(s sVar) {
        g(sVar);
        return null;
    }

    protected static boolean canUseUnsafe() {
        if (p2.J() && p2.K()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int computeStringSize(int i10, Object obj) {
        if (obj instanceof String) {
            return k.U(i10, (String) obj);
        }
        return k.h(i10, (h) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int computeStringSizeNoTag(Object obj) {
        if (obj instanceof String) {
            return k.V((String) obj);
        }
        return k.i((h) obj);
    }

    protected static j0.a emptyBooleanList() {
        return com.google.protobuf.f.k();
    }

    protected static j0.b emptyDoubleList() {
        return o.k();
    }

    protected static j0.f emptyFloatList() {
        return d0.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static j0.g emptyIntList() {
        return i0.i();
    }

    protected static j0.h emptyLongList() {
        return r0.i();
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        setAlwaysUseFieldBuildersForTesting(true);
    }

    private static r g(s sVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map h(boolean z10) {
        TreeMap treeMap = new TreeMap();
        List j10 = internalGetFieldAccessorTable().f١١٠٣١a.j();
        int i10 = 0;
        while (i10 < j10.size()) {
            n.g gVar = (n.g) j10.get(i10);
            n.l k10 = gVar.k();
            if (k10 != null) {
                i10 += k10.k() - 1;
                if (hasOneof(k10)) {
                    gVar = getOneofFieldDescriptor(k10);
                    if (!z10 && gVar.q() == n.g.b.STRING) {
                        treeMap.put(gVar, getFieldRaw(gVar));
                    } else {
                        treeMap.put(gVar, getField(gVar));
                    }
                    i10++;
                } else {
                    i10++;
                }
            } else {
                if (gVar.isRepeated()) {
                    List list = (List) getField(gVar);
                    if (!list.isEmpty()) {
                        treeMap.put(gVar, list);
                    }
                } else {
                    if (!hasField(gVar)) {
                    }
                    if (!z10) {
                    }
                    treeMap.put(gVar, getField(gVar));
                }
                i10++;
            }
        }
        return treeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method i(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e10);
        }
    }

    protected static boolean isStringEmpty(Object obj) {
        if (obj instanceof String) {
            return ((String) obj).isEmpty();
        }
        return ((h) obj).isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object j(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    private static void k(k kVar, Map map, t0 t0Var, int i10, boolean z10) {
        if (!map.containsKey(Boolean.valueOf(z10))) {
        } else {
            throw null;
        }
    }

    private static void l(k kVar, Map map, t0 t0Var, int i10) {
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static j0.g mutableCopy(j0.g gVar) {
        int size = gVar.size();
        return gVar.a(size == 0 ? 10 : size * 2);
    }

    protected static j0.a newBooleanList() {
        return new com.google.protobuf.f();
    }

    protected static j0.b newDoubleList() {
        return new o();
    }

    protected static j0.f newFloatList() {
        return new d0();
    }

    protected static j0.g newIntList() {
        return new i0();
    }

    protected static j0.h newLongList() {
        return new r0();
    }

    protected static <M extends b1> M parseDelimitedWithIOException(r1 r1Var, InputStream inputStream) throws IOException {
        try {
            return (M) r1Var.parseDelimitedFrom(inputStream);
        } catch (k0 e10) {
            throw e10.m();
        }
    }

    protected static <M extends b1> M parseWithIOException(r1 r1Var, InputStream inputStream) throws IOException {
        try {
            return (M) r1Var.parseFrom(inputStream);
        } catch (k0 e10) {
            throw e10.m();
        }
    }

    protected static <V> void serializeBooleanMapTo(k kVar, v0 v0Var, t0 t0Var, int i10) throws IOException {
        Map h10 = v0Var.h();
        if (!kVar.f0()) {
            l(kVar, h10, t0Var, i10);
        } else {
            k(kVar, h10, t0Var, i10, false);
            k(kVar, h10, t0Var, i10, true);
        }
    }

    protected static <V> void serializeIntegerMapTo(k kVar, v0 v0Var, t0 t0Var, int i10) throws IOException {
        Map h10 = v0Var.h();
        if (!kVar.f0()) {
            l(kVar, h10, t0Var, i10);
            return;
        }
        int size = h10.size();
        int[] iArr = new int[size];
        Iterator it = h10.keySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            iArr[i11] = ((Integer) it.next()).intValue();
            i11++;
        }
        Arrays.sort(iArr);
        if (size <= 0) {
            return;
        }
        int i12 = iArr[0];
        throw null;
    }

    protected static <V> void serializeLongMapTo(k kVar, v0 v0Var, t0 t0Var, int i10) throws IOException {
        Map h10 = v0Var.h();
        if (!kVar.f0()) {
            l(kVar, h10, t0Var, i10);
            return;
        }
        int size = h10.size();
        long[] jArr = new long[size];
        Iterator it = h10.keySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            jArr[i11] = ((Long) it.next()).longValue();
            i11++;
        }
        Arrays.sort(jArr);
        if (size <= 0) {
            return;
        }
        long j10 = jArr[0];
        throw null;
    }

    protected static <V> void serializeStringMapTo(k kVar, v0 v0Var, t0 t0Var, int i10) throws IOException {
        Map h10 = v0Var.h();
        if (!kVar.f0()) {
            l(kVar, h10, t0Var, i10);
            return;
        }
        String[] strArr = (String[]) h10.keySet().toArray(new String[h10.size()]);
        Arrays.sort(strArr);
        if (strArr.length <= 0) {
            return;
        }
        String str = strArr[0];
        throw null;
    }

    static void setAlwaysUseFieldBuildersForTesting(boolean z10) {
        alwaysUseFieldBuilders = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void writeString(k kVar, int i10, Object obj) throws IOException {
        if (obj instanceof String) {
            kVar.P0(i10, (String) obj);
        } else {
            kVar.p0(i10, (h) obj);
        }
    }

    protected static void writeStringNoTag(k kVar, Object obj) throws IOException {
        if (obj instanceof String) {
            kVar.Q0((String) obj);
        } else {
            kVar.q0((h) obj);
        }
    }

    @Override // com.google.protobuf.g1
    public Map<n.g, Object> getAllFields() {
        return Collections.unmodifiableMap(h(false));
    }

    Map<n.g, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(h(true));
    }

    @Override // com.google.protobuf.g1
    public n.b getDescriptorForType() {
        return internalGetFieldAccessorTable().f١١٠٣١a;
    }

    @Override // com.google.protobuf.g1
    public Object getField(n.g gVar) {
        return internalGetFieldAccessorTable().e(gVar).b(this);
    }

    Object getFieldRaw(n.g gVar) {
        return internalGetFieldAccessorTable().e(gVar).n(this);
    }

    public n.g getOneofFieldDescriptor(n.l lVar) {
        return internalGetFieldAccessorTable().f(lVar).c(this);
    }

    public Object getRepeatedField(n.g gVar, int i10) {
        return internalGetFieldAccessorTable().e(gVar).k(this, i10);
    }

    public int getRepeatedFieldCount(n.g gVar) {
        return internalGetFieldAccessorTable().e(gVar).e(this);
    }

    @Override // com.google.protobuf.g1
    public boolean hasField(n.g gVar) {
        return internalGetFieldAccessorTable().e(gVar).h(this);
    }

    public boolean hasOneof(n.l lVar) {
        return internalGetFieldAccessorTable().f(lVar).e(this);
    }

    protected abstract f internalGetFieldAccessorTable();

    protected v0 internalGetMapField(int i10) {
        throw new RuntimeException("No map fields found in " + getClass().getName());
    }

    protected void makeExtensionsImmutable() {
    }

    @Deprecated
    protected void mergeFromAndMakeImmutableInternal(i iVar, v vVar) throws k0 {
        y1 d10 = u1.a().d(this);
        try {
            d10.e(this, j.N(iVar), vVar);
            d10.b(this);
        } catch (k0 e10) {
            throw e10.j(this);
        } catch (IOException e11) {
            throw new k0(e11).j(this);
        }
    }

    @Override // com.google.protobuf.a
    protected b1.a newBuilderForType(a.b bVar) {
        return newBuilderForType((c) new a(this, bVar));
    }

    protected abstract b1.a newBuilderForType(c cVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object newInstance(g gVar);

    protected boolean parseUnknownField(i iVar, k2.b bVar, v vVar, int i10) throws IOException {
        if (iVar.N()) {
            return iVar.O(i10);
        }
        return bVar.j(i10, iVar);
    }

    protected boolean parseUnknownFieldProto3(i iVar, k2.b bVar, v vVar, int i10) throws IOException {
        return parseUnknownField(iVar, bVar, vVar, i10);
    }

    protected Object writeReplace() throws ObjectStreamException {
        return new g0.b(this);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class e extends h0 implements g1 {
        private static final long serialVersionUID = 1;

        /* renamed from: a, reason: collision with root package name */
        private final b0 f١١٠٢٦a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        protected class a {

            /* renamed from: a, reason: collision with root package name */
            private final Iterator f١١٠٢٧a;

            /* renamed from: b, reason: collision with root package name */
            private Map.Entry f١١٠٢٨b;

            /* renamed from: c, reason: collision with root package name */
            private final boolean f١١٠٢٩c;

            /* synthetic */ a(e eVar, boolean z10, a aVar) {
                this(z10);
            }

            public void a(int i10, k kVar) {
                while (true) {
                    Map.Entry entry = this.f١١٠٢٨b;
                    if (entry != null && ((n.g) entry.getKey()).getNumber() < i10) {
                        n.g gVar = (n.g) this.f١١٠٢٨b.getKey();
                        if (this.f١١٠٢٩c && gVar.getLiteJavaType() == r2.c.MESSAGE && !gVar.isRepeated()) {
                            if (this.f١١٠٢٨b instanceof m0.b) {
                                kVar.K0(gVar.getNumber(), ((m0.b) this.f١١٠٢٨b).a().c());
                            } else {
                                kVar.J0(gVar.getNumber(), (b1) this.f١١٠٢٨b.getValue());
                            }
                        } else {
                            b0.O(gVar, this.f١١٠٢٨b.getValue(), kVar);
                        }
                        if (this.f١١٠٢٧a.hasNext()) {
                            this.f١١٠٢٨b = (Map.Entry) this.f١١٠٢٧a.next();
                        } else {
                            this.f١١٠٢٨b = null;
                        }
                    } else {
                        return;
                    }
                }
            }

            private a(boolean z10) {
                Iterator E = e.this.f١١٠٢٦a.E();
                this.f١١٠٢٧a = E;
                if (E.hasNext()) {
                    this.f١١٠٢٨b = (Map.Entry) E.next();
                }
                this.f١١٠٢٩c = z10;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public e() {
            this.f١١٠٢٦a = b0.J();
        }

        private void r(n.g gVar) {
            if (gVar.l() == getDescriptorForType()) {
            } else {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        @Override // com.google.protobuf.h0, com.google.protobuf.g1
        public Map getAllFields() {
            Map h10 = h(false);
            h10.putAll(p());
            return Collections.unmodifiableMap(h10);
        }

        @Override // com.google.protobuf.h0
        public Map getAllFieldsRaw() {
            Map h10 = h(false);
            h10.putAll(p());
            return Collections.unmodifiableMap(h10);
        }

        @Override // com.google.protobuf.h0, com.google.protobuf.g1
        public Object getField(n.g gVar) {
            if (gVar.v()) {
                r(gVar);
                Object q10 = this.f١١٠٢٦a.q(gVar);
                if (q10 == null) {
                    if (gVar.isRepeated()) {
                        return Collections.emptyList();
                    }
                    if (gVar.q() == n.g.b.MESSAGE) {
                        return q.k(gVar.r());
                    }
                    return gVar.m();
                }
                return q10;
            }
            return super.getField(gVar);
        }

        @Override // com.google.protobuf.h0
        public Object getRepeatedField(n.g gVar, int i10) {
            if (gVar.v()) {
                r(gVar);
                return this.f١١٠٢٦a.t(gVar, i10);
            }
            return super.getRepeatedField(gVar, i10);
        }

        @Override // com.google.protobuf.h0
        public int getRepeatedFieldCount(n.g gVar) {
            if (gVar.v()) {
                r(gVar);
                return this.f١١٠٢٦a.u(gVar);
            }
            return super.getRepeatedFieldCount(gVar);
        }

        @Override // com.google.protobuf.h0, com.google.protobuf.g1
        public boolean hasField(n.g gVar) {
            if (gVar.v()) {
                r(gVar);
                return this.f١١٠٢٦a.x(gVar);
            }
            return super.hasField(gVar);
        }

        @Override // com.google.protobuf.h0
        protected void makeExtensionsImmutable() {
            this.f١١٠٢٦a.F();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean n() {
            return this.f١١٠٢٦a.A();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int o() {
            return this.f١١٠٢٦a.v();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Map p() {
            return this.f١١٠٢٦a.p();
        }

        @Override // com.google.protobuf.h0
        protected boolean parseUnknownField(i iVar, k2.b bVar, v vVar, int i10) {
            if (iVar.N()) {
                bVar = null;
            }
            return h1.d(iVar, bVar, vVar, getDescriptorForType(), new h1.c(this.f١١٠٢٦a), i10);
        }

        @Override // com.google.protobuf.h0
        protected boolean parseUnknownFieldProto3(i iVar, k2.b bVar, v vVar, int i10) {
            return parseUnknownField(iVar, bVar, vVar, i10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public a q() {
            return new a(this, false, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public e(d dVar) {
            super(dVar);
            this.f١١٠٢٦a = dVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h0(b bVar) {
        this.unknownFields = bVar.getUnknownFields();
    }

    protected static j0.h mutableCopy(j0.h hVar) {
        int size = hVar.size();
        return hVar.a(size == 0 ? 10 : size * 2);
    }

    protected static <M extends b1> M parseDelimitedWithIOException(r1 r1Var, InputStream inputStream, v vVar) throws IOException {
        try {
            return (M) r1Var.parseDelimitedFrom(inputStream, vVar);
        } catch (k0 e10) {
            throw e10.m();
        }
    }

    protected static <M extends b1> M parseWithIOException(r1 r1Var, InputStream inputStream, v vVar) throws IOException {
        try {
            return (M) r1Var.parseFrom(inputStream, vVar);
        } catch (k0 e10) {
            throw e10.m();
        }
    }

    protected static j0.f mutableCopy(j0.f fVar) {
        int size = fVar.size();
        return fVar.a(size == 0 ? 10 : size * 2);
    }

    protected static <M extends b1> M parseWithIOException(r1 r1Var, i iVar) throws IOException {
        try {
            return (M) r1Var.parseFrom(iVar);
        } catch (k0 e10) {
            throw e10.m();
        }
    }

    protected static j0.b mutableCopy(j0.b bVar) {
        int size = bVar.size();
        return bVar.a(size == 0 ? 10 : size * 2);
    }

    protected static <M extends b1> M parseWithIOException(r1 r1Var, i iVar, v vVar) throws IOException {
        try {
            return (M) r1Var.parseFrom(iVar, vVar);
        } catch (k0 e10) {
            throw e10.m();
        }
    }

    protected static j0.a mutableCopy(j0.a aVar) {
        int size = aVar.size();
        return aVar.a(size == 0 ? 10 : size * 2);
    }
}

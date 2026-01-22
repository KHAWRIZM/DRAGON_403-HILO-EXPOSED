package com.google.protobuf;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.protobuf.b;
import com.google.protobuf.b1;
import com.google.protobuf.j0;
import com.google.protobuf.k2;
import com.google.protobuf.n;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a extends com.google.protobuf.b implements b1 {
    protected int memoizedSize = -1;

    /* renamed from: com.google.protobuf.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class AbstractC٠١٣٢a extends b.a implements b1.a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static i2 newUninitializedMessageException(b1 b1Var) {
            return new i2(h1.b(b1Var));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void dispose() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        public List<String> findInitializationErrors() {
            return h1.b(this);
        }

        public String getInitializationErrorString() {
            return h1.a(findInitializationErrors());
        }

        protected k2.b getUnknownFieldSetBuilder() {
            return k2.f(getUnknownFields());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void markClean() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        public abstract AbstractC٠١٣٢a mergeUnknownFields(k2 k2Var);

        protected void setUnknownFieldSetBuilder(k2.b bVar) {
            setUnknownFields(bVar.build());
        }

        public String toString() {
            return e2.o().j(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.b.a
        public AbstractC٠١٣٢a internalMergeFrom(com.google.protobuf.b bVar) {
            return mergeFrom((b1) bVar);
        }

        @Override // com.google.protobuf.b1.a
        public AbstractC٠١٣٢a mergeFrom(b1 b1Var) {
            return mergeFrom(b1Var, (Map<n.g, Object>) b1Var.getAllFields());
        }

        AbstractC٠١٣٢a mergeFrom(b1 b1Var, Map<n.g, Object> map) {
            if (b1Var.getDescriptorForType() == getDescriptorForType()) {
                for (Map.Entry<n.g, Object> entry : map.entrySet()) {
                    n.g key = entry.getKey();
                    if (key.isRepeated()) {
                        Iterator it = ((List) entry.getValue()).iterator();
                        while (it.hasNext()) {
                            addRepeatedField(key, it.next());
                        }
                    } else if (key.q() == n.g.b.MESSAGE) {
                        b1 b1Var2 = (b1) getField(key);
                        if (b1Var2 == b1Var2.getDefaultInstanceForType()) {
                            setField(key, entry.getValue());
                        } else {
                            setField(key, b1Var2.newBuilderForType().mergeFrom(b1Var2).mergeFrom((b1) entry.getValue()).build());
                        }
                    } else {
                        setField(key, entry.getValue());
                    }
                }
                mergeUnknownFields(b1Var.getUnknownFields());
                return this;
            }
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public AbstractC٠١٣٢a m٤٥٢mergeFrom(i iVar) throws IOException {
            return mergeFrom(iVar, (v) t.e());
        }

        @Override // com.google.protobuf.e1.a
        public AbstractC٠١٣٢a mergeFrom(i iVar, v vVar) {
            k2.b unknownFieldSetBuilder = iVar.N() ? null : getUnknownFieldSetBuilder();
            h1.e(this, unknownFieldSetBuilder, iVar, vVar);
            if (unknownFieldSetBuilder != null) {
                setUnknownFieldSetBuilder(unknownFieldSetBuilder);
            }
            return this;
        }

        @Override // com.google.protobuf.b1.a
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public AbstractC٠١٣٢a m٤٥٠mergeFrom(h hVar) throws k0 {
            return (AbstractC٠١٣٢a) super.m٤٥٠mergeFrom(hVar);
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public AbstractC٠١٣٢a m٤٥١mergeFrom(h hVar, v vVar) throws k0 {
            return (AbstractC٠١٣٢a) super.m٤٥١mergeFrom(hVar, vVar);
        }

        @Override // com.google.protobuf.e1.a
        public AbstractC٠١٣٢a mergeFrom(byte[] bArr) throws k0 {
            return (AbstractC٠١٣٢a) super.mergeFrom(bArr);
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public AbstractC٠١٣٢a m٤٥٥mergeFrom(byte[] bArr, int i10, int i11) throws k0 {
            return (AbstractC٠١٣٢a) super.m٤٥٥mergeFrom(bArr, i10, i11);
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public AbstractC٠١٣٢a m٤٥٧mergeFrom(byte[] bArr, v vVar) throws k0 {
            return (AbstractC٠١٣٢a) super.m٤٥٧mergeFrom(bArr, vVar);
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public AbstractC٠١٣٢a m٤٥٦mergeFrom(byte[] bArr, int i10, int i11, v vVar) throws k0 {
            return (AbstractC٠١٣٢a) super.m٤٥٦mergeFrom(bArr, i10, i11, vVar);
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public AbstractC٠١٣٢a m٤٥٣mergeFrom(InputStream inputStream) throws IOException {
            return (AbstractC٠١٣٢a) super.m٤٥٣mergeFrom(inputStream);
        }

        @Override // com.google.protobuf.b.a
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public AbstractC٠١٣٢a m٤٥٤mergeFrom(InputStream inputStream, v vVar) throws IOException {
            return (AbstractC٠١٣٢a) super.m٤٥٤mergeFrom(inputStream, vVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void a();
    }

    private static boolean b(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        return f(obj).equals(f(obj2));
    }

    private static boolean c(Object obj, Object obj2) {
        return w0.k(d((List) obj), d((List) obj2));
    }

    static boolean compareFields(Map<n.g, Object> map, Map<n.g, Object> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (n.g gVar : map.keySet()) {
            if (!map2.containsKey(gVar)) {
                return false;
            }
            Object obj = map.get(gVar);
            Object obj2 = map2.get(gVar);
            if (gVar.t() == n.g.c.f١١٨٠٨m) {
                if (gVar.isRepeated()) {
                    List list = (List) obj;
                    List list2 = (List) obj2;
                    if (list.size() != list2.size()) {
                        return false;
                    }
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        if (!b(list.get(i10), list2.get(i10))) {
                            return false;
                        }
                    }
                } else if (!b(obj, obj2)) {
                    return false;
                }
            } else if (gVar.w()) {
                if (!c(obj, obj2)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static Map d(List list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        b1 b1Var = (b1) it.next();
        n.b descriptorForType = b1Var.getDescriptorForType();
        n.g h10 = descriptorForType.h(TransferTable.COLUMN_KEY);
        n.g h11 = descriptorForType.h("value");
        Object field = b1Var.getField(h11);
        if (field instanceof n.f) {
            field = Integer.valueOf(((n.f) field).getNumber());
        }
        hashMap.put(b1Var.getField(h10), field);
        while (it.hasNext()) {
            b1 b1Var2 = (b1) it.next();
            Object field2 = b1Var2.getField(h11);
            if (field2 instanceof n.f) {
                field2 = Integer.valueOf(((n.f) field2).getNumber());
            }
            hashMap.put(b1Var2.getField(h10), field2);
        }
        return hashMap;
    }

    private static int e(Object obj) {
        return w0.c(d((List) obj));
    }

    private static h f(Object obj) {
        if (obj instanceof byte[]) {
            return h.m((byte[]) obj);
        }
        return (h) obj;
    }

    @Deprecated
    protected static int hashBoolean(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    @Deprecated
    protected static int hashEnum(j0.c cVar) {
        return cVar.getNumber();
    }

    @Deprecated
    protected static int hashEnumList(List<? extends j0.c> list) {
        Iterator<? extends j0.c> it = list.iterator();
        int i10 = 1;
        while (it.hasNext()) {
            i10 = (i10 * 31) + hashEnum(it.next());
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int hashFields(int i10, Map<n.g, Object> map) {
        int i11;
        int f10;
        for (Map.Entry<n.g, Object> entry : map.entrySet()) {
            n.g key = entry.getKey();
            Object value = entry.getValue();
            int number = (i10 * 37) + key.getNumber();
            if (key.w()) {
                i11 = number * 53;
                f10 = e(value);
            } else if (key.t() != n.g.c.f١١٨١٠o) {
                i11 = number * 53;
                f10 = value.hashCode();
            } else if (key.isRepeated()) {
                i11 = number * 53;
                f10 = j0.g((List) value);
            } else {
                i11 = number * 53;
                f10 = j0.f((j0.c) value);
            }
            i10 = i11 + f10;
        }
        return i10;
    }

    @Deprecated
    protected static int hashLong(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        if (getDescriptorForType() == b1Var.getDescriptorForType() && compareFields(getAllFields(), b1Var.getAllFields()) && getUnknownFields().equals(b1Var.getUnknownFields())) {
            return true;
        }
        return false;
    }

    public List<String> findInitializationErrors() {
        return h1.b(this);
    }

    public String getInitializationErrorString() {
        return h1.a(findInitializationErrors());
    }

    @Override // com.google.protobuf.b
    int getMemoizedSerializedSize() {
        return this.memoizedSize;
    }

    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 == 0) {
            int hashFields = (hashFields(779 + getDescriptorForType().hashCode(), getAllFields()) * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = hashFields;
            return hashFields;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b1.a newBuilderForType(b bVar) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.b
    public i2 newUninitializedMessageException() {
        return AbstractC٠١٣٢a.newUninitializedMessageException((b1) this);
    }

    @Override // com.google.protobuf.b
    void setMemoizedSerializedSize(int i10) {
        this.memoizedSize = i10;
    }

    public final String toString() {
        return e2.o().j(this);
    }
}

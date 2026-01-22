package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class m0 extends n0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        private Map.Entry f١١٧١٧a;

        public m0 a() {
            return (m0) this.f١١٧١٧a.getValue();
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f١١٧١٧a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return null;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof e1) {
                return ((m0) this.f١١٧١٧a.getValue()).b((e1) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private b(Map.Entry entry) {
            this.f١١٧١٧a = entry;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class c implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private Iterator f١١٧١٨a;

        public c(Iterator it) {
            this.f١١٧١٨a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Map.Entry entry = (Map.Entry) this.f١١٧١٨a.next();
            if (entry.getValue() instanceof m0) {
                return new b(entry);
            }
            return entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f١١٧١٨a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f١١٧١٨a.remove();
        }
    }

    public abstract e1 d();
}

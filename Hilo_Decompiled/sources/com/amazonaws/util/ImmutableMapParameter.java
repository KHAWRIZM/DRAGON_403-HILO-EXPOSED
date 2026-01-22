package com.amazonaws.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class ImmutableMapParameter<K, V> implements Map<K, V> {
    private static final String DUPLICATED_KEY_MESSAGE = "Duplicate keys are provided.";
    private static final String UNMODIFIABLE_MESSAGE = "This is an immutable map.";
    private final Map<K, V> map;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class Builder<K, V> {
        private final Map<K, V> entries = new HashMap();

        public ImmutableMapParameter<K, V> build() {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.entries);
            return new ImmutableMapParameter<>(hashMap);
        }

        public Builder<K, V> put(K k10, V v10) {
            ImmutableMapParameter.putAndWarnDuplicateKeys(this.entries, k10, v10);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k10, V v10) {
        return new ImmutableMapParameter<>(Collections.singletonMap(k10, v10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> void putAndWarnDuplicateKeys(Map<K, V> map, K k10, V v10) {
        if (!map.containsKey(k10)) {
            map.put(k10, v10);
            return;
        }
        throw new IllegalArgumentException(DUPLICATED_KEY_MESSAGE);
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return this.map.entrySet();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return this.map.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.map.keySet();
    }

    @Override // java.util.Map
    public V put(K k10, V v10) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException(UNMODIFIABLE_MESSAGE);
    }

    @Override // java.util.Map
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return this.map.values();
    }

    private ImmutableMapParameter(Map<K, V> map) {
        this.map = map;
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k10, V v10, K k11, V v11) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, k10, v10);
        putAndWarnDuplicateKeys(hashMap, k11, v11);
        return new ImmutableMapParameter<>(hashMap);
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, k10, v10);
        putAndWarnDuplicateKeys(hashMap, k11, v11);
        putAndWarnDuplicateKeys(hashMap, k12, v12);
        return new ImmutableMapParameter<>(hashMap);
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, k10, v10);
        putAndWarnDuplicateKeys(hashMap, k11, v11);
        putAndWarnDuplicateKeys(hashMap, k12, v12);
        putAndWarnDuplicateKeys(hashMap, k13, v13);
        return new ImmutableMapParameter<>(hashMap);
    }

    public static <K, V> ImmutableMapParameter<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        HashMap hashMap = new HashMap();
        putAndWarnDuplicateKeys(hashMap, k10, v10);
        putAndWarnDuplicateKeys(hashMap, k11, v11);
        putAndWarnDuplicateKeys(hashMap, k12, v12);
        putAndWarnDuplicateKeys(hashMap, k13, v13);
        putAndWarnDuplicateKeys(hashMap, k14, v14);
        return new ImmutableMapParameter<>(hashMap);
    }
}

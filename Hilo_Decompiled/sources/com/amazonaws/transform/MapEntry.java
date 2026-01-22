package com.amazonaws.transform;

import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    public K setKey(K k10) {
        this.key = k10;
        return k10;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v10) {
        this.value = v10;
        return v10;
    }
}

package com.qiahao.nextvideo.data.model;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/qiahao/nextvideo/data/model/ActivityIngResponseBean;", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/ActivityIngResponseBeanItem;", "Lkotlin/collections/ArrayList;", "<init>", "()V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivityIngResponseBean extends ArrayList<ActivityIngResponseBeanItem> {
    public /* bridge */ boolean contains(ActivityIngResponseBeanItem activityIngResponseBeanItem) {
        return super.contains((Object) activityIngResponseBeanItem);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(ActivityIngResponseBeanItem activityIngResponseBeanItem) {
        return super.indexOf((Object) activityIngResponseBeanItem);
    }

    public /* bridge */ int lastIndexOf(ActivityIngResponseBeanItem activityIngResponseBeanItem) {
        return super.lastIndexOf((Object) activityIngResponseBeanItem);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ ActivityIngResponseBeanItem remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ ActivityIngResponseBeanItem removeAt(int i) {
        return (ActivityIngResponseBeanItem) super.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ActivityIngResponseBeanItem) {
            return contains((ActivityIngResponseBeanItem) obj);
        }
        return false;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ActivityIngResponseBeanItem) {
            return indexOf((ActivityIngResponseBeanItem) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ActivityIngResponseBeanItem) {
            return lastIndexOf((ActivityIngResponseBeanItem) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(ActivityIngResponseBeanItem activityIngResponseBeanItem) {
        return super.remove((Object) activityIngResponseBeanItem);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof ActivityIngResponseBeanItem) {
            return remove((ActivityIngResponseBeanItem) obj);
        }
        return false;
    }
}

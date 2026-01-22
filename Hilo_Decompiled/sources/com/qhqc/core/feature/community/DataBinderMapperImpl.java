package com.qhqc.core.feature.community;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.qhqc.core.feature.community.databinding.FeatureCommunityAdapterItemPostNewestUserListBindingImpl;
import com.qhqc.core.feature.community.databinding.FeatureCommunityItemPostsListBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class DataBinderMapperImpl extends androidx.databinding.e {

    /* renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f١٢٢٦٩a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final HashMap f١٢٢٧٠a;

        static {
            HashMap hashMap = new HashMap(2);
            f١٢٢٧٠a = hashMap;
            hashMap.put("layout/feature_community_adapter_item_post_newest_user_list_0", Integer.valueOf(R.layout.feature_community_adapter_item_post_newest_user_list));
            hashMap.put("layout/feature_community_item_posts_list_0", Integer.valueOf(R.layout.feature_community_item_posts_list));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f١٢٢٦٩a = sparseIntArray;
        sparseIntArray.put(R.layout.feature_community_adapter_item_post_newest_user_list, 1);
        sparseIntArray.put(R.layout.feature_community_item_posts_list, 2);
    }

    @Override // androidx.databinding.e
    public List collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.qhqc.core.basic.DataBinderMapperImpl());
        arrayList.add(new com.qhqc.core.basic.widget.DataBinderMapperImpl());
        arrayList.add(new com.ruffian.library.widget.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(androidx.databinding.f fVar, View view, int i10) {
        int i11 = f١٢٢٦٩a.get(i10);
        if (i11 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i11 == 1) {
            if ("layout/feature_community_adapter_item_post_newest_user_list_0".equals(tag)) {
                return new FeatureCommunityAdapterItemPostNewestUserListBindingImpl(fVar, view);
            }
            throw new IllegalArgumentException("The tag for feature_community_adapter_item_post_newest_user_list is invalid. Received: " + tag);
        }
        if (i11 != 2) {
            return null;
        }
        if ("layout/feature_community_item_posts_list_0".equals(tag)) {
            return new FeatureCommunityItemPostsListBindingImpl(fVar, view);
        }
        throw new IllegalArgumentException("The tag for feature_community_item_posts_list is invalid. Received: " + tag);
    }

    @Override // androidx.databinding.e
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = (Integer) a.f١٢٢٧٠a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.e
    public ViewDataBinding getDataBinder(androidx.databinding.f fVar, View[] viewArr, int i10) {
        if (viewArr == null || viewArr.length == 0 || f١٢٢٦٩a.get(i10) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

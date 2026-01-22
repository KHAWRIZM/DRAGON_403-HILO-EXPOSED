package com.luck.picture.lib.magical;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BuildRecycleItemViewParams {
    private static final List<ViewParams> viewParams = new ArrayList();

    public static void clear() {
        List<ViewParams> list = viewParams;
        if (list.size() > 0) {
            list.clear();
        }
    }

    private static void fillPlaceHolder(List<View> list, int i10, int i11, int i12) {
        if (i11 > 0) {
            while (i11 >= 1) {
                list.add(0, null);
                i11--;
            }
        }
        if (i12 < i10) {
            for (int i13 = (i10 - 1) - i12; i13 >= 1; i13--) {
                list.add(null);
            }
        }
    }

    public static void generateViewParams(ViewGroup viewGroup, int i10) {
        int childCount;
        int count;
        int firstVisiblePosition;
        int lastVisiblePosition;
        ArrayList arrayList = new ArrayList();
        boolean z10 = viewGroup instanceof RecyclerView;
        if (z10) {
            childCount = ((RecyclerView) viewGroup).getChildCount();
        } else if (viewGroup instanceof ListView) {
            childCount = ((ListView) viewGroup).getChildCount();
        } else {
            throw new IllegalArgumentException(viewGroup.getClass().getCanonicalName() + " Must be " + RecyclerView.class + " or " + ListView.class);
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt != null) {
                arrayList.add(childAt);
            }
        }
        if (z10) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) ((RecyclerView) viewGroup).getLayoutManager();
            if (gridLayoutManager == null) {
                return;
            }
            count = gridLayoutManager.getItemCount();
            firstVisiblePosition = gridLayoutManager.findFirstVisibleItemPosition();
            lastVisiblePosition = gridLayoutManager.findLastVisibleItemPosition();
        } else {
            ListView listView = (ListView) viewGroup;
            ListAdapter adapter = listView.getAdapter();
            if (adapter == null) {
                return;
            }
            count = adapter.getCount();
            firstVisiblePosition = listView.getFirstVisiblePosition();
            lastVisiblePosition = listView.getLastVisiblePosition();
        }
        if (lastVisiblePosition > count) {
            lastVisiblePosition = count - 1;
        }
        fillPlaceHolder(arrayList, count, firstVisiblePosition, lastVisiblePosition);
        viewParams.clear();
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            View view = (View) arrayList.get(i12);
            ViewParams viewParams2 = new ViewParams();
            if (view == null) {
                viewParams2.setLeft(0);
                viewParams2.setTop(0);
                viewParams2.setWidth(0);
                viewParams2.setHeight(0);
            } else {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                viewParams2.setLeft(iArr[0]);
                viewParams2.setTop(iArr[1] - i10);
                viewParams2.setWidth(view.getWidth());
                viewParams2.setHeight(view.getHeight());
            }
            viewParams.add(viewParams2);
        }
    }

    public static ViewParams getItemViewParams(int i10) {
        List<ViewParams> list = viewParams;
        if (list.size() > i10) {
            return list.get(i10);
        }
        return null;
    }
}

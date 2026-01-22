package com.tencent.qcloud.tuicore.component.action;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.a;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class PopMenuAdapter extends BaseAdapter {
    private List<PopMenuAction> dataSource = new ArrayList();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class ViewHolder {
        ImageView menu_icon;
        TextView menu_lable;

        ViewHolder() {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dataSource.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.dataSource.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(TUIConfig.getAppContext()).inflate(R.layout.pop_menu_adapter, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.menu_icon = (ImageView) view.findViewById(R.id.pop_menu_icon);
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.core_pop_menu_icon_size);
            ViewGroup.LayoutParams layoutParams = viewHolder.menu_icon.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            viewHolder.menu_icon.setLayoutParams(layoutParams);
            viewHolder.menu_lable = (TextView) view.findViewById(R.id.pop_menu_label);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        PopMenuAction popMenuAction = (PopMenuAction) getItem(i);
        viewHolder.menu_icon.setVisibility(0);
        if (popMenuAction.getIcon() != null) {
            viewHolder.menu_icon.setImageBitmap(popMenuAction.getIcon());
        } else if (popMenuAction.getIconResId() > 0) {
            ImageView imageView = viewHolder.menu_icon;
            imageView.setImageDrawable(a.getDrawable(imageView.getContext(), popMenuAction.getIconResId()));
        } else {
            viewHolder.menu_icon.setVisibility(8);
        }
        viewHolder.menu_lable.setText(popMenuAction.getActionName());
        return view;
    }

    public void setDataSource(List list) {
        this.dataSource = list;
        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuicore.component.action.PopMenuAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                PopMenuAdapter.this.notifyDataSetChanged();
            }
        });
    }
}

package com.tencent.qcloud.tuicore.component.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.tencent.qcloud.tuicore.component.TitleBarLayout;
import com.tencent.qcloud.tuicore.component.interfaces.ITitleBarLayout;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SelectionActivity extends BaseLightActivity {
    private static OnResultReturnListener sOnResultReturnListener;
    private EditText input;
    private int mSelectionType;
    private OnItemClickListener onItemClickListener;
    private SelectAdapter selectListAdapter;
    private RecyclerView selectListView;
    private ArrayList<String> selectList = new ArrayList<>();
    private int selectedItem = -1;
    private boolean needConfirm = true;
    private boolean returnNow = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnItemClickListener {
        void onClick(int i);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnResultReturnListener {
        void onReturn(Object obj);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    class SelectAdapter extends RecyclerView.Adapter<SelectViewHolder> {
        int selectedItem = -1;
        ArrayList<String> data = new ArrayList<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class SelectViewHolder extends RecyclerView.ViewHolder {
            TextView name;
            ImageView selectedIcon;

            public SelectViewHolder(View view) {
                super(view);
                this.name = (TextView) view.findViewById(R.id.name);
                this.selectedIcon = (ImageView) view.findViewById(R.id.selected_icon);
            }
        }

        SelectAdapter() {
        }

        public int getItemCount() {
            return this.data.size();
        }

        public void setData(ArrayList<String> arrayList) {
            this.data.clear();
            this.data.addAll(arrayList);
        }

        public void setSelectedItem(int i) {
            this.selectedItem = i;
        }

        public void onBindViewHolder(SelectViewHolder selectViewHolder, final int i) {
            selectViewHolder.name.setText(this.data.get(i));
            if (this.selectedItem == i) {
                selectViewHolder.selectedIcon.setVisibility(0);
            } else {
                selectViewHolder.selectedIcon.setVisibility(8);
            }
            ((RecyclerView.ViewHolder) selectViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.SelectionActivity.SelectAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SelectionActivity.this.onItemClickListener.onClick(i);
                }
            });
        }

        public SelectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new SelectViewHolder(LayoutInflater.from(SelectionActivity.this).inflate(R.layout.core_select_item_layout, viewGroup, false));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class Selection {
        public static final String CONTENT = "content";
        public static final String DEFAULT_SELECT_ITEM_INDEX = "default_select_item_index";
        public static final String INIT_CONTENT = "init_content";
        public static final String LIMIT = "limit";
        public static final String LIST = "list";
        public static final String NEED_CONFIRM = "needConfirm";
        public static final String RETURN_NOW = "returnNow";
        public static final String SELECT_ALL = "select_all";
        public static final String TITLE = "title";
        public static final String TYPE = "type";
        public static final int TYPE_LIST = 2;
        public static final int TYPE_TEXT = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void echoClick() {
        OnResultReturnListener onResultReturnListener;
        int i = this.mSelectionType;
        if (i != 1) {
            if (i == 2 && (onResultReturnListener = sOnResultReturnListener) != null) {
                onResultReturnListener.onReturn(Integer.valueOf(this.selectedItem));
            }
        } else {
            OnResultReturnListener onResultReturnListener2 = sOnResultReturnListener;
            if (onResultReturnListener2 != null) {
                onResultReturnListener2.onReturn(this.input.getText().toString());
            }
        }
        if (this.returnNow) {
            finish();
        }
    }

    public static void startListSelection(Context context, Bundle bundle, OnResultReturnListener onResultReturnListener) {
        bundle.putInt("type", 2);
        startSelection(context, bundle, onResultReturnListener);
    }

    private static void startSelection(Context context, Bundle bundle, OnResultReturnListener onResultReturnListener) {
        Intent intent = new Intent(context, (Class<?>) SelectionActivity.class);
        intent.putExtra("content", bundle);
        intent.addFlags(268435456);
        context.startActivity(intent);
        sOnResultReturnListener = onResultReturnListener;
    }

    public static void startTextSelection(Context context, Bundle bundle, OnResultReturnListener onResultReturnListener) {
        bundle.putInt("type", 1);
        startSelection(context, bundle, onResultReturnListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qcloud.tuicore.component.activities.BaseLightActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tuicore_selection_activity);
        TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.edit_title_bar);
        this.selectListView = findViewById(R.id.select_list);
        SelectAdapter selectAdapter = new SelectAdapter();
        this.selectListAdapter = selectAdapter;
        this.selectListView.setAdapter(selectAdapter);
        this.selectListView.setLayoutManager(new CustomLinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, 1);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.core_list_divider));
        this.selectListView.addItemDecoration(dividerItemDecoration);
        this.onItemClickListener = new OnItemClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.SelectionActivity.1
            @Override // com.tencent.qcloud.tuicore.component.activities.SelectionActivity.OnItemClickListener
            public void onClick(int i) {
                SelectionActivity.this.selectedItem = i;
                SelectionActivity.this.selectListAdapter.setSelectedItem(i);
                SelectionActivity.this.selectListAdapter.notifyDataSetChanged();
                if (!SelectionActivity.this.needConfirm) {
                    SelectionActivity.this.echoClick();
                }
            }
        };
        this.input = (EditText) findViewById(R.id.edit_content_et);
        Bundle bundleExtra = getIntent().getBundleExtra("content");
        int i = bundleExtra.getInt("type");
        if (i != 1) {
            if (i != 2) {
                finish();
                return;
            }
            this.input.setVisibility(8);
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("list");
            this.selectedItem = bundleExtra.getInt(Selection.DEFAULT_SELECT_ITEM_INDEX);
            if (stringArrayList != null && stringArrayList.size() != 0) {
                this.selectList.clear();
                this.selectList.addAll(stringArrayList);
                this.selectListAdapter.setSelectedItem(this.selectedItem);
                this.selectListAdapter.setData(this.selectList);
                this.selectListAdapter.notifyDataSetChanged();
            } else {
                return;
            }
        } else {
            this.selectListView.setVisibility(8);
            String string = bundleExtra.getString(Selection.INIT_CONTENT);
            int i2 = bundleExtra.getInt("limit");
            if (!TextUtils.isEmpty(string)) {
                this.input.setText(string);
                this.input.setSelection(string.length());
            }
            if (i2 > 0) {
                this.input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
            }
        }
        this.mSelectionType = bundleExtra.getInt("type");
        String string2 = bundleExtra.getString("title");
        this.needConfirm = bundleExtra.getBoolean(Selection.NEED_CONFIRM, true);
        this.returnNow = bundleExtra.getBoolean(Selection.RETURN_NOW, true);
        titleBarLayout.setTitle(string2, ITitleBarLayout.Position.MIDDLE);
        titleBarLayout.setOnLeftClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.SelectionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectionActivity.this.finish();
            }
        });
        titleBarLayout.getRightIcon().setVisibility(8);
        if (this.needConfirm) {
            titleBarLayout.getRightTitle().setText(getResources().getString(R.string.sure));
            titleBarLayout.setOnRightClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuicore.component.activities.SelectionActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    SelectionActivity.this.echoClick();
                }
            });
        } else {
            titleBarLayout.getRightGroup().setVisibility(8);
        }
    }

    protected void onStop() {
        super.onStop();
        sOnResultReturnListener = null;
    }
}

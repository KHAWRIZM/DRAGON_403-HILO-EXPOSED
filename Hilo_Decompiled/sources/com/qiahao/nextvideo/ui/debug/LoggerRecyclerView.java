package com.qiahao.nextvideo.ui.debug;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0005%&'()B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\u000e\u0010\u001f\u001a\b\u0018\u00010\u0012R\u00020\u0000H\u0016J\u0010\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010#\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00060\u0012R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00060\u0014R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxItems", "getMaxItems", "()I", "setMaxItems", "(I)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogRecyclerViewAdapter;", "mDecoration", "Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$MarginDecoration;", "mInflater", "Landroid/view/LayoutInflater;", "mLogList", "", "Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogItem;", "mVerticalSpacing", "init", "", "setLayout", "getOffset", "getAdapter", "logI", "text", "", "logW", "logE", "LogLevel", "LogItem", "LogRecyclerViewAdapter", "ViewHolder", "MarginDecoration", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LoggerRecyclerView extends RecyclerView {

    @NotNull
    private final LogRecyclerViewAdapter mAdapter;

    @NotNull
    private final MarginDecoration mDecoration;

    @Nullable
    private LayoutInflater mInflater;

    @NotNull
    private final List<LogItem> mLogList;
    private int mVerticalSpacing;
    private int maxItems;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogItem;", "", "level", "Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogLevel;", "text", "", "<init>", "(Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogLevel;Ljava/lang/String;)V", "getLevel", "()Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogLevel;", "setLevel", "(Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogLevel;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textColor", "", "getTextColor", "()I", "setTextColor", "(I)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class LogItem {

        @NotNull
        private LogLevel level;

        @Nullable
        private String text;
        private int textColor;

        public LogItem(@NotNull LogLevel logLevel, @Nullable String str) {
            Intrinsics.checkNotNullParameter(logLevel, "level");
            this.level = logLevel;
            this.text = str;
        }

        @NotNull
        public final LogLevel getLevel() {
            return this.level;
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final void setLevel(@NotNull LogLevel logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "<set-?>");
            this.level = logLevel;
        }

        public final void setText(@Nullable String str) {
            this.text = str;
        }

        public final void setTextColor(int i) {
            this.textColor = i;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "ERROR", "WARN", "INFO", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class LogLevel {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LogLevel[] $VALUES;
        public static final LogLevel ERROR = new LogLevel("ERROR", 0);
        public static final LogLevel WARN = new LogLevel("WARN", 1);
        public static final LogLevel INFO = new LogLevel("INFO", 2);

        private static final /* synthetic */ LogLevel[] $values() {
            return new LogLevel[]{ERROR, WARN, INFO};
        }

        static {
            LogLevel[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private LogLevel(String str, int i) {
        }

        @NotNull
        public static EnumEntries<LogLevel> getEntries() {
            return $ENTRIES;
        }

        public static LogLevel valueOf(String str) {
            return (LogLevel) Enum.valueOf(LogLevel.class, str);
        }

        public static LogLevel[] values() {
            return (LogLevel[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0013\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$ViewHolder;", "Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView;", "<init>", "(Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView;)V", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "position", "", "onBindViewHolder", "", "viewHolder", "getItemCount", "logI", "text", "", "logW", "logE", "addLogItem", "level", "Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogLevel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public final class LogRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
        public LogRecyclerViewAdapter() {
        }

        private final void addLogItem(LogLevel level, String text) {
            LogItem logItem = new LogItem(level, text);
            if (LoggerRecyclerView.this.mLogList.size() == LoggerRecyclerView.this.getMaxItems()) {
                LoggerRecyclerView.this.mLogList.remove(0);
            }
            LoggerRecyclerView.this.mLogList.add(logItem);
            LoggerRecyclerView.this.scrollToPosition(r2.mLogList.size() - 1);
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return LoggerRecyclerView.this.mLogList.size();
        }

        public final void logE(@Nullable String text) {
            addLogItem(LogLevel.ERROR, text);
        }

        public final void logI(@Nullable String text) {
            addLogItem(LogLevel.INFO, text);
        }

        public final void logW(@Nullable String text) {
            addLogItem(LogLevel.WARN, text);
        }

        public void onBindViewHolder(@NotNull ViewHolder viewHolder, int position) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            viewHolder.update((LogItem) LoggerRecyclerView.this.mLogList.get(position));
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int position) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            LayoutInflater layoutInflater = LoggerRecyclerView.this.mInflater;
            Intrinsics.checkNotNull(layoutInflater);
            View inflate = layoutInflater.inflate(R.layout.log_item_layout, viewGroup, false);
            LoggerRecyclerView loggerRecyclerView = LoggerRecyclerView.this;
            Intrinsics.checkNotNull(inflate);
            return new ViewHolder(loggerRecyclerView, inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$MarginDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "(Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView;)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public final class MarginDecoration extends RecyclerView.ItemDecoration {
        public MarginDecoration() {
        }

        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.top = LoggerRecyclerView.this.mVerticalSpacing;
            outRect.bottom = LoggerRecyclerView.this.mVerticalSpacing;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView;Landroid/view/View;)V", "layout", "Landroid/widget/LinearLayout;", "getLayout", "()Landroid/widget/LinearLayout;", "setLayout", "(Landroid/widget/LinearLayout;)V", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "setText", "(Landroid/widget/TextView;)V", "update", "", "item", "Lcom/qiahao/nextvideo/ui/debug/LoggerRecyclerView$LogItem;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private LinearLayout layout;

        @NotNull
        private TextView text;
        final /* synthetic */ LoggerRecyclerView this$0;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LogLevel.values().length];
                try {
                    iArr[LogLevel.INFO.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LogLevel.WARN.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LogLevel.ERROR.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull LoggerRecyclerView loggerRecyclerView, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.this$0 = loggerRecyclerView;
            View findViewById = view.findViewById(R.id.log_back);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.layout = (LinearLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.log_text);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.text = (TextView) findViewById2;
        }

        @NotNull
        public final LinearLayout getLayout() {
            return this.layout;
        }

        @NotNull
        public final TextView getText() {
            return this.text;
        }

        public final void setLayout(@NotNull LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.layout = linearLayout;
        }

        public final void setText(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.text = textView;
        }

        public final void update(@NotNull LogItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            int i = WhenMappings.$EnumSwitchMapping$0[item.getLevel().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        item.setTextColor(-65536);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    item.setTextColor(-256);
                }
            } else {
                item.setTextColor(-16711936);
            }
            this.text.setText(item.getText());
            this.text.setTextColor(item.getTextColor());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoggerRecyclerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxItems = 10;
        this.mAdapter = new LogRecyclerViewAdapter();
        this.mDecoration = new MarginDecoration();
        this.mLogList = new ArrayList();
        init(context);
    }

    private final int getOffset() {
        return Dimens.INSTANCE.getMarginSmall();
    }

    private final void init(Context context) {
        this.mInflater = LayoutInflater.from(context);
        setAdapter(this.mAdapter);
        setLayout(context);
    }

    private final void setLayout(Context context) {
        CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(context);
        customLinearLayoutManager.setOrientation(1);
        setLayoutManager(customLinearLayoutManager);
        addItemDecoration(this.mDecoration);
        this.mVerticalSpacing = getOffset();
    }

    public final int getMaxItems() {
        return this.maxItems;
    }

    public final void logE(@Nullable String text) {
        this.mAdapter.logE(text);
    }

    public final void logI(@Nullable String text) {
        this.mAdapter.logI(text);
    }

    public final void logW(@Nullable String text) {
        this.mAdapter.logW(text);
    }

    public final void setMaxItems(int i) {
        this.maxItems = i;
    }

    @Nullable
    public LogRecyclerViewAdapter getAdapter() {
        return this.mAdapter;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoggerRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxItems = 10;
        this.mAdapter = new LogRecyclerViewAdapter();
        this.mDecoration = new MarginDecoration();
        this.mLogList = new ArrayList();
        init(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoggerRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxItems = 10;
        this.mAdapter = new LogRecyclerViewAdapter();
        this.mDecoration = new MarginDecoration();
        this.mLogList = new ArrayList();
        init(context);
    }
}

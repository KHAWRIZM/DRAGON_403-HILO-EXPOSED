package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.face;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import c5.h;
import com.bumptech.glide.Glide;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.component.face.ChatFace;
import com.tencent.qcloud.tuikit.tuichat.component.face.CustomFace;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceGroup;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.component.face.RecentEmojiManager;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.component.EmojiIndicatorView;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.BaseInputFragment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FaceFragment extends BaseInputFragment {
    FaceTabListAdapter faceTabListAdapter;
    RecyclerView faceTabListView;
    ViewPager2 faceViewPager;
    private OnEmojiClickListener listener;
    private RecentEmojiManager recentManager;
    ArrayList<Emoji> recentlyEmojiList;
    private TextView sendButton;
    private boolean showCustomFace = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class FaceGVAdapter extends BaseAdapter {
        private List<ChatFace> faceList;
        private final Context mContext;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        class ViewHolder {
            ImageView iv;

            ViewHolder() {
            }
        }

        public FaceGVAdapter(Context context) {
            this.mContext = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<ChatFace> list = this.faceList;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.faceList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            ChatFace chatFace = this.faceList.get(i);
            if (view == null) {
                viewHolder = new ViewHolder();
                view2 = LayoutInflater.from(this.mContext).inflate(R.layout.item_face, (ViewGroup) null);
                ImageView imageView = (ImageView) view2.findViewById(R.id.face_image);
                viewHolder.iv = imageView;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                if (chatFace != null && chatFace.getHeight() != 0 && chatFace.getWidth() != 0) {
                    layoutParams.width = chatFace.getWidth();
                    layoutParams.height = chatFace.getHeight();
                }
                viewHolder.iv.setLayoutParams(layoutParams);
                view2.setTag(viewHolder);
            } else {
                view2 = view;
                viewHolder = (ViewHolder) view.getTag();
            }
            if (chatFace != null) {
                FaceManager.loadFace(chatFace, viewHolder.iv);
            }
            return view2;
        }

        public void setFaceList(List<ChatFace> list) {
            this.faceList = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class FaceTabListAdapter extends RecyclerView.Adapter<FaceTabListViewHolder> {
        private List<FaceGroup> faceGroups;
        private int selected = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class FaceTabListViewHolder extends RecyclerView.ViewHolder {
            private ImageView faceGroupIcon;
            private View selectBorder;

            public FaceTabListViewHolder(View view) {
                super(view);
                this.selectBorder = view.findViewById(R.id.select_border);
                this.faceGroupIcon = (ImageView) view.findViewById(R.id.face_group_tab_icon);
            }
        }

        FaceTabListAdapter() {
        }

        public int getItemCount() {
            List<FaceGroup> list = this.faceGroups;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void setFaceGroups(List<FaceGroup> list) {
            this.faceGroups = list;
        }

        public void setSelected(int i) {
            this.selected = i;
            notifyDataSetChanged();
        }

        public void onBindViewHolder(FaceTabListViewHolder faceTabListViewHolder, int i) {
            final FaceGroup faceGroup = this.faceGroups.get(i);
            Glide.with(((RecyclerView.ViewHolder) faceTabListViewHolder).itemView).q(faceGroup.getFaceGroupIconUrl()).q0(new h().j(android.R.drawable.ic_menu_report_image)).D0(faceTabListViewHolder.faceGroupIcon);
            if (this.selected == i) {
                faceTabListViewHolder.selectBorder.setVisibility(0);
            } else {
                faceTabListViewHolder.selectBorder.setVisibility(8);
            }
            ((RecyclerView.ViewHolder) faceTabListViewHolder).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.face.FaceFragment.FaceTabListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int indexOf = FaceTabListAdapter.this.faceGroups.indexOf(faceGroup);
                    if (indexOf == -1) {
                        return;
                    }
                    FaceFragment.this.faceViewPager.setCurrentItem(indexOf);
                }
            });
        }

        public FaceTabListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new FaceTabListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.minimalist_face_group_icon, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class FaceVPAdapter extends RecyclerView.Adapter<FaceVPHolder> {
        private List<FaceGroup> faceGroups;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class FaceGridAdapter extends RecyclerView.Adapter<FaceGridHolder> {
            private FaceGroup faceGroup;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
            public class FaceGridHolder extends RecyclerView.ViewHolder {
                private GridView faceGrid;

                public FaceGridHolder(View view) {
                    super(view);
                    GridView gridView = (GridView) view;
                    this.faceGrid = gridView;
                    gridView.setAdapter((ListAdapter) new FaceGVAdapter(view.getContext()));
                }
            }

            FaceGridAdapter() {
            }

            public int getItemCount() {
                FaceGroup faceGroup = this.faceGroup;
                boolean z = false;
                if (faceGroup == null) {
                    return 0;
                }
                FaceFragment faceFragment = FaceFragment.this;
                ArrayList<ChatFace> faces = faceGroup.getFaces();
                int pageColumnCount = this.faceGroup.getPageColumnCount();
                int pageRowCount = this.faceGroup.getPageRowCount();
                if (this.faceGroup.getGroupID() == 0) {
                    z = true;
                }
                return faceFragment.getPagerCount(faces, pageColumnCount, pageRowCount, z);
            }

            public void setFaceGroup(FaceGroup faceGroup) {
                this.faceGroup = faceGroup;
            }

            public void onBindViewHolder(FaceGridHolder faceGridHolder, int i) {
                int i2 = this.faceGroup.getGroupID() == 0 ? 1 : 0;
                final int pageColumnCount = this.faceGroup.getPageColumnCount();
                final int pageRowCount = this.faceGroup.getPageRowCount();
                ArrayList<ChatFace> faces = this.faceGroup.getFaces();
                int i3 = (pageColumnCount * pageRowCount) - i2;
                final List<ChatFace> subList = faces.subList(i * i3, Math.min((i + 1) * i3, faces.size()));
                if (i2 != 0 && subList.size() < i3) {
                    for (int size = subList.size(); size < i3; size++) {
                        subList.add(null);
                    }
                }
                if (i2 != 0) {
                    Emoji emoji = new Emoji();
                    emoji.setIcon(BitmapFactory.decodeResource(FaceFragment.this.getResources(), R.drawable.face_delete));
                    subList.add(emoji);
                }
                FaceGVAdapter faceGVAdapter = (FaceGVAdapter) faceGridHolder.faceGrid.getAdapter();
                faceGVAdapter.setFaceList(subList);
                faceGridHolder.faceGrid.setNumColumns(this.faceGroup.getPageColumnCount());
                faceGridHolder.faceGrid.setAdapter((ListAdapter) faceGVAdapter);
                faceGridHolder.faceGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.face.FaceFragment.FaceVPAdapter.FaceGridAdapter.1
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j) {
                        if (subList.get(i4) instanceof CustomFace) {
                            FaceFragment.this.listener.onCustomFaceClick(FaceGridAdapter.this.faceGroup.getGroupID(), (CustomFace) subList.get(i4));
                            return;
                        }
                        if (subList.get(i4) instanceof Emoji) {
                            if (i4 == (pageColumnCount * pageRowCount) - 1) {
                                if (FaceFragment.this.listener != null) {
                                    FaceFragment.this.listener.onEmojiDelete();
                                }
                            } else if (FaceFragment.this.listener != null) {
                                FaceFragment.this.listener.onEmojiClick((Emoji) subList.get(i4));
                            }
                        }
                    }
                });
            }

            public FaceGridHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                GridView gridView = (GridView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_face_grid, viewGroup, false);
                gridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return new FaceGridHolder(gridView);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public class FaceVPHolder extends RecyclerView.ViewHolder {
            private FaceGridAdapter faceGridAdapter;
            private EmojiIndicatorView indicatorView;
            private int oldPosition;
            private ViewPager2 viewPager2;

            public FaceVPHolder(View view) {
                super(view);
                this.oldPosition = 0;
                this.viewPager2 = view.findViewById(R.id.face_group_view_pager2);
                this.indicatorView = (EmojiIndicatorView) view.findViewById(R.id.face_indicator);
                FaceGridAdapter faceGridAdapter = new FaceGridAdapter();
                this.faceGridAdapter = faceGridAdapter;
                this.viewPager2.setAdapter(faceGridAdapter);
                this.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.face.FaceFragment.FaceVPAdapter.FaceVPHolder.1
                    public void onPageSelected(int i) {
                        FaceVPHolder.this.indicatorView.playBy(FaceVPHolder.this.oldPosition, i);
                        FaceVPHolder.this.oldPosition = i;
                    }
                });
            }

            void setData(FaceGroup faceGroup) {
                boolean z;
                this.faceGridAdapter.setFaceGroup(faceGroup);
                EmojiIndicatorView emojiIndicatorView = this.indicatorView;
                FaceFragment faceFragment = FaceFragment.this;
                ArrayList<ChatFace> faces = faceGroup.getFaces();
                int pageColumnCount = faceGroup.getPageColumnCount();
                int pageRowCount = faceGroup.getPageRowCount();
                if (faceGroup.getGroupID() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                emojiIndicatorView.init(faceFragment.getPagerCount(faces, pageColumnCount, pageRowCount, z));
                this.oldPosition = 0;
                this.faceGridAdapter.notifyDataSetChanged();
            }
        }

        FaceVPAdapter() {
        }

        public int getItemCount() {
            List<FaceGroup> list = this.faceGroups;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void setFaceGroups(List<FaceGroup> list) {
            this.faceGroups = list;
        }

        public void onBindViewHolder(FaceVPHolder faceVPHolder, int i) {
            FaceGridAdapter faceGridAdapter = faceVPHolder.faceGridAdapter;
            faceVPHolder.setData(this.faceGroups.get(i));
            faceGridAdapter.notifyDataSetChanged();
        }

        public FaceVPHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_minimalist_face_view_pager_item, viewGroup, false);
            FaceVPHolder faceVPHolder = new FaceVPHolder(inflate);
            faceVPHolder.faceGridAdapter = new FaceGridAdapter();
            faceVPHolder.viewPager2.setAdapter(faceVPHolder.faceGridAdapter);
            return new FaceVPHolder(inflate);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnEmojiClickListener {
        void onCustomFaceClick(int i, CustomFace customFace);

        void onEmojiClick(Emoji emoji);

        void onEmojiDelete();

        void sendEmoji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPagerCount(List<? extends ChatFace> list, int i, int i2, boolean z) {
        int size = list.size();
        int i3 = (i * i2) - (z ? 1 : 0);
        if (size % i3 == 0) {
            return size / i3;
        }
        return (size / i3) + 1;
    }

    private void initViews() {
        this.faceTabListAdapter = new FaceTabListAdapter();
        ArrayList arrayList = new ArrayList();
        if (!this.showCustomFace) {
            arrayList.add(FaceManager.getFaceGroupList().get(0));
        } else {
            arrayList.addAll(FaceManager.getFaceGroupList());
        }
        this.faceTabListAdapter.setFaceGroups(arrayList);
        this.faceTabListView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.faceTabListView.setAdapter(this.faceTabListAdapter);
        FaceVPAdapter faceVPAdapter = new FaceVPAdapter();
        faceVPAdapter.setFaceGroups(arrayList);
        this.faceViewPager.setAdapter(faceVPAdapter);
        this.faceViewPager.setUserInputEnabled(false);
        this.faceViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.face.FaceFragment.2
            int oldPosition = 0;

            public void onPageSelected(int i) {
                this.oldPosition = i;
                FaceFragment.this.faceTabListAdapter.setSelected(i);
            }
        });
        this.faceViewPager.setCurrentItem(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttach(Activity activity) {
        if (activity instanceof OnEmojiClickListener) {
            this.listener = (OnEmojiClickListener) activity;
        }
        this.recentManager = RecentEmojiManager.getInstance();
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        try {
            if (this.recentManager.getCollection(RecentEmojiManager.PREFERENCE_NAME) != null) {
                this.recentlyEmojiList = (ArrayList) this.recentManager.getCollection(RecentEmojiManager.PREFERENCE_NAME);
            } else {
                this.recentlyEmojiList = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.minimalist_fragment_face, viewGroup, false);
        this.faceViewPager = inflate.findViewById(R.id.face_viewPager);
        this.faceTabListView = inflate.findViewById(R.id.face_view_group);
        TextView textView = (TextView) inflate.findViewById(R.id.send_btn);
        this.sendButton = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.face.FaceFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FaceFragment.this.listener != null) {
                    FaceFragment.this.listener.sendEmoji();
                }
            }
        });
        initViews();
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        try {
            this.recentManager.putCollection(RecentEmojiManager.PREFERENCE_NAME, this.recentlyEmojiList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setListener(OnEmojiClickListener onEmojiClickListener) {
        this.listener = onEmojiClickListener;
    }

    public void setShowCustomFace(boolean z) {
        this.showCustomFace = z;
    }
}

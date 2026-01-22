package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face;

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
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.classicui.component.EmojiIndicatorView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.BaseInputFragment;
import com.tencent.qcloud.tuikit.tuichat.component.face.ChatFace;
import com.tencent.qcloud.tuikit.tuichat.component.face.CustomFace;
import com.tencent.qcloud.tuikit.tuichat.component.face.Emoji;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceGroup;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.component.face.RecentEmojiManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FaceFragment extends BaseInputFragment {
    LinearLayout faceGroup;
    List<FaceGroup> faceGroups;
    EmojiIndicatorView faceIndicator;
    ViewPager faceViewPager;
    private OnEmojiClickListener listener;
    FaceGroupIcon mCurrentSelected;
    private RecentEmojiManager recentManager;
    ArrayList<Emoji> recentlyEmojiList;
    ArrayList<View> ViewPagerItems = new ArrayList<>();
    private int mCurrentGroupIndex = 0;
    private boolean showCustomFace = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class FaceGVAdapter extends BaseAdapter {
        private final List<ChatFace> list;
        private final Context mContext;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        class ViewHolder {
            ImageView iv;

            ViewHolder() {
            }
        }

        public FaceGVAdapter(List<ChatFace> list, Context context) {
            this.list = list;
            this.mContext = context;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.list.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            ViewHolder viewHolder;
            ChatFace chatFace = this.list.get(i);
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class FaceVPAdapter extends a {
        private List<View> views;

        public FaceVPAdapter(List<View> list) {
            this.views = list;
        }

        public void destroyItem(View view, int i, Object obj) {
            ((ViewPager) view).removeView((View) obj);
        }

        public int getCount() {
            return this.views.size();
        }

        public Object instantiateItem(View view, int i) {
            ((ViewPager) view).addView(this.views.get(i));
            return this.views.get(i);
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface OnEmojiClickListener {
        void onCustomFaceClick(int i, CustomFace customFace);

        void onEmojiClick(Emoji emoji);

        void onEmojiDelete();
    }

    private int getPagerCount(ArrayList<? extends ChatFace> arrayList, int i, int i2) {
        int i3;
        int size = arrayList.size();
        if (this.mCurrentGroupIndex > 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        int i4 = (i * i2) - i3;
        if (size % i4 == 0) {
            return size / i4;
        }
        return (size / i4) + 1;
    }

    private View getViewPagerItem(int i, ArrayList<? extends ChatFace> arrayList, final int i2, final int i3) {
        int i4;
        GridView gridView = (GridView) ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.layout_face_grid, (ViewGroup) null).findViewById(R.id.chart_face_gv);
        gridView.setNumColumns(i2);
        final ArrayList arrayList2 = new ArrayList();
        if (this.mCurrentGroupIndex > 0) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        int i5 = (i2 * i3) - i4;
        int i6 = i * i5;
        int i7 = (i + 1) * i5;
        if (i7 > arrayList.size()) {
            i7 = arrayList.size();
        }
        arrayList2.addAll(arrayList.subList(i6, i7));
        if (this.mCurrentGroupIndex == 0 && arrayList2.size() < i5) {
            for (int size = arrayList2.size(); size < i5; size++) {
                arrayList2.add(null);
            }
        }
        if (this.mCurrentGroupIndex == 0) {
            Emoji emoji = new Emoji();
            emoji.setIcon(BitmapFactory.decodeResource(getResources(), R.drawable.face_delete));
            arrayList2.add(emoji);
        }
        gridView.setAdapter((ListAdapter) new FaceGVAdapter(arrayList2, getActivity()));
        gridView.setNumColumns(i2);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i8, long j) {
                if (FaceFragment.this.mCurrentGroupIndex > 0) {
                    FaceFragment.this.listener.onCustomFaceClick(FaceFragment.this.mCurrentGroupIndex, (CustomFace) arrayList2.get(i8));
                    return;
                }
                if (i8 == (i2 * i3) - 1) {
                    if (FaceFragment.this.listener != null) {
                        FaceFragment.this.listener.onEmojiDelete();
                    }
                } else if (FaceFragment.this.listener != null) {
                    FaceFragment.this.listener.onEmojiClick((Emoji) arrayList2.get(i8));
                }
            }
        });
        return gridView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager(ArrayList<? extends ChatFace> arrayList, int i, int i2) {
        intiIndicator(arrayList, i, i2);
        this.ViewPagerItems.clear();
        int pagerCount = getPagerCount(arrayList, i, i2);
        for (int i3 = 0; i3 < pagerCount; i3++) {
            this.ViewPagerItems.add(getViewPagerItem(i3, arrayList, i, i2));
        }
        this.faceViewPager.setAdapter(new FaceVPAdapter(this.ViewPagerItems));
        this.faceViewPager.setOnPageChangeListener(new ViewPager.j() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.2
            int oldPosition = 0;

            public void onPageScrollStateChanged(int i4) {
            }

            public void onPageScrolled(int i4, float f, int i5) {
            }

            public void onPageSelected(int i4) {
                FaceFragment.this.faceIndicator.playBy(this.oldPosition, i4);
                this.oldPosition = i4;
            }
        });
    }

    private void initViews() {
        this.faceGroups = FaceManager.getFaceGroupList();
        for (int i = 0; i < this.faceGroups.size(); i++) {
            final FaceGroup faceGroup = this.faceGroups.get(i);
            if (faceGroup.getGroupID() == 0 || this.showCustomFace) {
                FaceGroupIcon faceGroupIcon = new FaceGroupIcon(getActivity());
                faceGroupIcon.setFaceTabIcon(faceGroup.getFaceGroupIconUrl());
                if (i == 0) {
                    this.mCurrentSelected = faceGroupIcon;
                    this.mCurrentGroupIndex = faceGroup.getGroupID();
                    initViewPager(faceGroup.getFaces(), faceGroup.getPageColumnCount(), faceGroup.getPageRowCount());
                    this.mCurrentSelected.setSelected(true);
                }
                faceGroupIcon.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.face.FaceFragment.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FaceFragment faceFragment = FaceFragment.this;
                        if (faceFragment.mCurrentSelected != view) {
                            faceFragment.mCurrentGroupIndex = faceGroup.getGroupID();
                            ArrayList<ChatFace> faces = faceGroup.getFaces();
                            FaceFragment.this.mCurrentSelected.setSelected(false);
                            FaceFragment.this.initViewPager(faces, faceGroup.getPageColumnCount(), faceGroup.getPageRowCount());
                            FaceGroupIcon faceGroupIcon2 = (FaceGroupIcon) view;
                            FaceFragment.this.mCurrentSelected = faceGroupIcon2;
                            faceGroupIcon2.setSelected(true);
                        }
                    }
                });
                this.faceGroup.addView(faceGroupIcon);
            }
        }
    }

    private void intiIndicator(ArrayList<? extends ChatFace> arrayList, int i, int i2) {
        this.faceIndicator.init(getPagerCount(arrayList, i, i2));
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
        View inflate = layoutInflater.inflate(R.layout.fragment_face, viewGroup, false);
        this.faceViewPager = inflate.findViewById(R.id.face_viewPager);
        this.faceIndicator = (EmojiIndicatorView) inflate.findViewById(R.id.face_indicator);
        this.faceGroup = (LinearLayout) inflate.findViewById(R.id.face_view_group);
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

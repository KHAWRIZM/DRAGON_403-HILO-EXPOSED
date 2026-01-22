package com.qiahao.nextvideo.utilities;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/qiahao/nextvideo/utilities/Debug;", "", "<init>", "()V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Debug {

    @NotNull
    private static ArrayList<Integer> colors;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<String> images = CollectionsKt.listOf(new String[]{"https://cdn.pixabay.com/photo/2019/11/30/04/03/bharatanatyam-4662487_1280.jpg", "https://cdn.pixabay.com/photo/2013/05/01/21/46/tango-108483_1280.jpg", "https://cdn.pixabay.com/photo/2016/05/12/23/03/lamb-1388937_1280.png", "https://cdn.pixabay.com/photo/2015/04/03/16/36/bee-705412_1280.png", "https://cdn.pixabay.com/photo/2016/09/14/20/50/teeth-1670434_1280.png", "https://cdn.pixabay.com/photo/2015/12/05/08/25/fairy-tale-1077863_1280.jpg", "https://cdn.pixabay.com/photo/2012/12/27/19/41/halloween-72939_1280.jpg", "https://cdn.pixabay.com/photo/2016/09/07/11/37/tropical-1651423_1280.jpg", "https://cdn.pixabay.com/photo/2013/06/07/06/51/tree-117582_1280.jpg", "https://cdn.pixabay.com/photo/2014/12/22/00/07/tree-576847_1280.png", "https://cdn.pixabay.com/photo/2015/07/27/20/16/book-863418_1280.jpg", "https://cdn.pixabay.com/photo/2013/07/18/10/56/house-163526_1280.jpg", "https://cdn.pixabay.com/photo/2014/12/08/11/49/love-560783_1280.jpg", "https://cdn.pixabay.com/photo/2016/06/14/14/09/skeleton-1456627_1280.png", "https://cdn.pixabay.com/photo/2016/10/19/02/21/moon-1751987_1280.png", "https://cdn.pixabay.com/photo/2016/07/02/12/21/eclipse-1492818_1280.jpg", "http://photocdn.sohu.com/20111115/Img325612940.jpg", "http://img3.cache.netease.com/photo/0031/2016-05-06/BMBHD1O56LRJ0031.jpg", "http://i.gongxiao8.com/uploads/i_1_1027848948x2494305301_26.jpg", "http://img.wxcha.com/file/201901/10/56f2ece12e.jpg", "http://img.wxcha.com/file/201812/21/89d683ab85.jpg", "http://img.wxcha.com/file/201807/18/e605ec3f55.jpg", "http://img.wxcha.com/file/201809/30/b8293c6a8a.jpg", "http://img.wxcha.com/file/201812/11/93bcbfd5f3.jpg", "http://img4.imgtn.bdimg.com/it/u=3175508956,2902264390&fm=26&gp=0.jpg", "http://img0.imgtn.bdimg.com/it/u=1560417182,3068121638&fm=26&gp=0.jpg", "http://img5.imgtn.bdimg.com/it/u=1647889927,4015832972&fm=26&gp=0.jpg", "http://img0.imgtn.bdimg.com/it/u=1330428072,249467376&fm=26&gp=0.jpg", "http://img3.imgtn.bdimg.com/it/u=1483331499,286472910&fm=26&gp=0.jpg", "http://img.wxcha.com/file/201812/11/93bcbfd5f3.jpg", "http://img3.imgtn.bdimg.com/it/u=3722249721,1705042876&fm=26&gp=0.jpg", "http://pic.962.net/up/2017-10/20171026113429875970.jpg", "http://wx3.sinaimg.cn/large/994b6f2egy1fr2kio27mij20j80iuwfe.jpg"});

    @NotNull
    private static final List<String> medias = CollectionsKt.listOf("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-10.mp3");

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/utilities/Debug$Companion;", "", "<init>", "()V", "images", "", "", "getImages", "()Ljava/util/List;", "medias", "getMedias", "colors", "Ljava/util/ArrayList;", "", "getColors", "()Ljava/util/ArrayList;", "setColors", "(Ljava/util/ArrayList;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ArrayList<Integer> getColors() {
            return Debug.colors;
        }

        @NotNull
        public final List<String> getImages() {
            return Debug.images;
        }

        @NotNull
        public final List<String> getMedias() {
            return Debug.medias;
        }

        public final void setColors(@NotNull ArrayList<Integer> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            Debug.colors = arrayList;
        }

        private Companion() {
        }
    }

    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(Color.parseColor("#FFA54F")));
        arrayList.add(Integer.valueOf(Color.parseColor("#FFFF00")));
        arrayList.add(Integer.valueOf(Color.parseColor("#FF83FA")));
        arrayList.add(Integer.valueOf(Color.parseColor("#63B8FF")));
        arrayList.add(Integer.valueOf(Color.parseColor("#EE2C2C")));
        arrayList.add(Integer.valueOf(Color.parseColor("#9B30FF")));
        arrayList.add(Integer.valueOf(Color.parseColor("#6B8E23")));
        arrayList.add(Integer.valueOf(Color.parseColor("#404040")));
        colors = arrayList;
    }
}

package com.qiahao.nextvideo.room.music;

import com.google.gson.reflect.TypeToken;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/qiahao/nextvideo/room/music/MusicCache;", "", "<init>", "()V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MusicCache {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\f¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/room/music/MusicCache$Companion;", "", "<init>", "()V", "saveMusicIdToLocal", "", "musicList", "", "", "getMusicIdForLocal", "saveLocalRotateType", "rotateType", "", "getLocalRotateType", "saveLocalVolume", "volumeType", "getLocalVolume", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getLocalRotateType() {
            return ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "music_rotate_local", 0, (String) null, 4, (Object) null)).intValue();
        }

        public final int getLocalVolume() {
            return ((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "music_volume_local", 20, (String) null, 4, (Object) null)).intValue();
        }

        @NotNull
        public final List<Long> getMusicIdForLocal() {
            String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "music_id_local", "", (String) null, 4, (Object) null);
            if (str != null && str.length() != 0) {
                try {
                    Object k = BaseApplication.Companion.getGSON().k(str, new TypeToken<ArrayList<Long>>() { // from class: com.qiahao.nextvideo.room.music.MusicCache$Companion$getMusicIdForLocal$1
                    }.getType());
                    Intrinsics.checkNotNull(k);
                    return (ArrayList) k;
                } catch (Exception unused) {
                    return new ArrayList();
                }
            }
            return new ArrayList();
        }

        public final void saveLocalRotateType(int rotateType) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "music_rotate_local", Integer.valueOf(rotateType), (String) null, 4, (Object) null);
        }

        public final void saveLocalVolume(int volumeType) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "music_volume_local", Integer.valueOf(volumeType), (String) null, 4, (Object) null);
        }

        public final void saveMusicIdToLocal(@NotNull List<Long> musicList) {
            Intrinsics.checkNotNullParameter(musicList, "musicList");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "music_id_local", BaseApplication.Companion.getGSON().s((ArrayList) musicList), (String) null, 4, (Object) null);
        }

        private Companion() {
        }
    }
}

package com.luck.picture.lib.loader;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.SortUtils;
import com.qiahao.hilo_message.activity.MediaDetailActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class LocalMediaLoader extends IBridgeMediaLoader {
    public LocalMediaLoader(Context context, SelectorConfig selectorConfig) {
        super(context, selectorConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocalMediaFolder getImageFolder(String str, String str2, String str3, List<LocalMediaFolder> list) {
        for (LocalMediaFolder localMediaFolder : list) {
            String folderName = localMediaFolder.getFolderName();
            if (!TextUtils.isEmpty(folderName) && TextUtils.equals(folderName, str3)) {
                return localMediaFolder;
            }
        }
        LocalMediaFolder localMediaFolder2 = new LocalMediaFolder();
        localMediaFolder2.setFolderName(str3);
        localMediaFolder2.setFirstImagePath(str);
        localMediaFolder2.setFirstMimeType(str2);
        list.add(localMediaFolder2);
        return localMediaFolder2;
    }

    private static String getSelectionArgsForAllMediaCondition(String str, String str2, String str3, String str4) {
        return "(media_type=?" + str3 + " OR " + MediaDetailActivity.EXTRA_MEDIA_TYPE + "=?" + str4 + " AND " + str + ") AND " + str2;
    }

    private static String getSelectionArgsForAudioMediaCondition(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private static String getSelectionArgsForImageMediaCondition(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private static String getSelectionArgsForVideoMediaCondition(String str, String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    public String getAlbumFirstCover(long j10) {
        return null;
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    protected String getSelection() {
        String durationCondition = getDurationCondition();
        String fileSizeCondition = getFileSizeCondition();
        int i10 = getConfig().chooseMode;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    return getSelectionArgsForAudioMediaCondition(durationCondition, getAudioMimeTypeCondition());
                }
                return getSelectionArgsForVideoMediaCondition(durationCondition, getVideoMimeTypeCondition());
            }
            return getSelectionArgsForImageMediaCondition(fileSizeCondition, getImageMimeTypeCondition());
        }
        return getSelectionArgsForAllMediaCondition(durationCondition, fileSizeCondition, getImageMimeTypeCondition(), getVideoMimeTypeCondition());
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    protected String[] getSelectionArgs() {
        int i10 = getConfig().chooseMode;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    return new String[]{String.valueOf(2)};
                }
                return new String[]{String.valueOf(3)};
            }
            return new String[]{String.valueOf(1)};
        }
        return new String[]{String.valueOf(1), String.valueOf(3)};
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    protected String getSortOrder() {
        if (TextUtils.isEmpty(getConfig().sortOrder)) {
            return "date_modified DESC";
        }
        return getConfig().sortOrder;
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    public void loadAllAlbum(final OnQueryAllAlbumListener<LocalMediaFolder> onQueryAllAlbumListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() { // from class: com.luck.picture.lib.loader.LocalMediaLoader.1
            /* JADX WARN: Code restructure failed: missing block: B:46:0x014c, code lost:
            
                if (r1.isClosed() != false) goto L٤٩;
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x0162, code lost:
            
                if (r1.isClosed() == false) goto L٤٠;
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x014e, code lost:
            
                r1.close();
             */
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public List<LocalMediaFolder> doInBackground() {
                String str;
                Context context;
                int i10;
                ArrayList arrayList = new ArrayList();
                Cursor query = LocalMediaLoader.this.getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, IBridgeMediaLoader.PROJECTION, LocalMediaLoader.this.getSelection(), LocalMediaLoader.this.getSelectionArgs(), LocalMediaLoader.this.getSortOrder());
                try {
                    if (query != null) {
                        try {
                            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
                            ArrayList<LocalMedia> arrayList2 = new ArrayList<>();
                            if (query.getCount() > 0) {
                                query.moveToFirst();
                                do {
                                    LocalMedia parseLocalMedia = LocalMediaLoader.this.parseLocalMedia(query, false);
                                    if (parseLocalMedia != null) {
                                        LocalMediaFolder imageFolder = LocalMediaLoader.this.getImageFolder(parseLocalMedia.getPath(), parseLocalMedia.getMimeType(), parseLocalMedia.getParentFolderName(), arrayList);
                                        imageFolder.setBucketId(parseLocalMedia.getBucketId());
                                        imageFolder.getData().add(parseLocalMedia);
                                        imageFolder.setFolderTotalNum(imageFolder.getFolderTotalNum() + 1);
                                        imageFolder.setBucketId(parseLocalMedia.getBucketId());
                                        arrayList2.add(parseLocalMedia);
                                        localMediaFolder.setFolderTotalNum(localMediaFolder.getFolderTotalNum() + 1);
                                    }
                                } while (query.moveToNext());
                                LocalMediaFolder loadInAppSandboxFolderFile = SandboxFileLoader.loadInAppSandboxFolderFile(LocalMediaLoader.this.getContext(), LocalMediaLoader.this.getConfig().sandboxDir);
                                if (loadInAppSandboxFolderFile != null) {
                                    arrayList.add(loadInAppSandboxFolderFile);
                                    localMediaFolder.setFolderTotalNum(localMediaFolder.getFolderTotalNum() + loadInAppSandboxFolderFile.getFolderTotalNum());
                                    localMediaFolder.setData(loadInAppSandboxFolderFile.getData());
                                    arrayList2.addAll(0, loadInAppSandboxFolderFile.getData());
                                    if (60 > loadInAppSandboxFolderFile.getFolderTotalNum()) {
                                        if (arrayList2.size() > 60) {
                                            SortUtils.sortLocalMediaAddedTime(arrayList2.subList(0, 60));
                                        } else {
                                            SortUtils.sortLocalMediaAddedTime(arrayList2);
                                        }
                                    }
                                }
                                if (arrayList2.size() > 0) {
                                    SortUtils.sortFolder(arrayList);
                                    arrayList.add(0, localMediaFolder);
                                    localMediaFolder.setFirstImagePath(arrayList2.get(0).getPath());
                                    localMediaFolder.setFirstMimeType(arrayList2.get(0).getMimeType());
                                    if (TextUtils.isEmpty(LocalMediaLoader.this.getConfig().defaultAlbumName)) {
                                        if (LocalMediaLoader.this.getConfig().chooseMode == SelectMimeType.ofAudio()) {
                                            context = LocalMediaLoader.this.getContext();
                                            i10 = R.string.ps_all_audio;
                                        } else {
                                            context = LocalMediaLoader.this.getContext();
                                            i10 = R.string.ps_camera_roll;
                                        }
                                        str = context.getString(i10);
                                    } else {
                                        str = LocalMediaLoader.this.getConfig().defaultAlbumName;
                                    }
                                    localMediaFolder.setFolderName(str);
                                    localMediaFolder.setBucketId(-1L);
                                    localMediaFolder.setData(arrayList2);
                                }
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (query != null) {
                    }
                    return arrayList;
                } catch (Throwable th) {
                    if (!query.isClosed()) {
                        query.close();
                    }
                    throw th;
                }
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(List<LocalMediaFolder> list) {
                PictureThreadUtils.cancel(this);
                OnQueryAllAlbumListener onQueryAllAlbumListener2 = onQueryAllAlbumListener;
                if (onQueryAllAlbumListener2 != null) {
                    onQueryAllAlbumListener2.onComplete(list);
                }
            }
        });
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    public void loadOnlyInAppDirAllMedia(final OnQueryAlbumListener<LocalMediaFolder> onQueryAlbumListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<LocalMediaFolder>() { // from class: com.luck.picture.lib.loader.LocalMediaLoader.2
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public LocalMediaFolder doInBackground() {
                return SandboxFileLoader.loadInAppSandboxFolderFile(LocalMediaLoader.this.getContext(), LocalMediaLoader.this.getConfig().sandboxDir);
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(LocalMediaFolder localMediaFolder) {
                PictureThreadUtils.cancel(this);
                OnQueryAlbumListener onQueryAlbumListener2 = onQueryAlbumListener;
                if (onQueryAlbumListener2 != null) {
                    onQueryAlbumListener2.onComplete(localMediaFolder);
                }
            }
        });
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    public void loadPageMediaData(long j10, int i10, int i11, OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    protected LocalMedia parseLocalMedia(Cursor cursor, boolean z10) {
        String str;
        long j10;
        long j11;
        String[] strArr = IBridgeMediaLoader.PROJECTION;
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(strArr[0]);
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow(strArr[1]);
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow(strArr[2]);
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow(strArr[3]);
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow(strArr[4]);
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow(strArr[5]);
        int columnIndexOrThrow7 = cursor.getColumnIndexOrThrow(strArr[6]);
        int columnIndexOrThrow8 = cursor.getColumnIndexOrThrow(strArr[7]);
        int columnIndexOrThrow9 = cursor.getColumnIndexOrThrow(strArr[8]);
        int columnIndexOrThrow10 = cursor.getColumnIndexOrThrow(strArr[9]);
        int columnIndexOrThrow11 = cursor.getColumnIndexOrThrow(strArr[10]);
        int columnIndexOrThrow12 = cursor.getColumnIndexOrThrow(strArr[11]);
        long j12 = cursor.getLong(columnIndexOrThrow);
        long j13 = cursor.getLong(columnIndexOrThrow11);
        String string = cursor.getString(columnIndexOrThrow3);
        String string2 = cursor.getString(columnIndexOrThrow2);
        if (SdkVersionUtils.isQ()) {
            str = MediaUtils.getRealPathUri(j12, string);
        } else {
            str = string2;
        }
        if (TextUtils.isEmpty(string)) {
            string = PictureMimeType.ofJPEG();
        }
        if (string.endsWith(SelectMimeType.SYSTEM_IMAGE)) {
            string = MediaUtils.getMimeTypeFromMediaUrl(string2);
            j10 = j13;
            if (!getConfig().isGif && PictureMimeType.isHasGif(string)) {
                return null;
            }
        } else {
            j10 = j13;
        }
        if (string.endsWith(SelectMimeType.SYSTEM_IMAGE)) {
            return null;
        }
        if (!getConfig().isWebp && string.startsWith(PictureMimeType.ofWEBP())) {
            return null;
        }
        if (!getConfig().isBmp && PictureMimeType.isHasBmp(string)) {
            return null;
        }
        if (!getConfig().isHeic && PictureMimeType.isHasHeic(string)) {
            return null;
        }
        int i10 = cursor.getInt(columnIndexOrThrow4);
        int i11 = cursor.getInt(columnIndexOrThrow5);
        int i12 = cursor.getInt(columnIndexOrThrow12);
        if (i12 == 90 || i12 == 270) {
            i10 = cursor.getInt(columnIndexOrThrow5);
            i11 = cursor.getInt(columnIndexOrThrow4);
        }
        long j14 = cursor.getLong(columnIndexOrThrow6);
        long j15 = cursor.getLong(columnIndexOrThrow7);
        String string3 = cursor.getString(columnIndexOrThrow8);
        String string4 = cursor.getString(columnIndexOrThrow9);
        int i13 = i10;
        long j16 = cursor.getLong(columnIndexOrThrow10);
        if (TextUtils.isEmpty(string4)) {
            string4 = PictureMimeType.getUrlToFileName(string2);
        }
        if (getConfig().isFilterSizeDuration && j15 > 0 && j15 < 1024) {
            return null;
        }
        if (!PictureMimeType.isHasVideo(string) && !PictureMimeType.isHasAudio(string)) {
            j11 = j15;
        } else {
            if (getConfig().filterVideoMinSecond > 0) {
                j11 = j15;
                if (j14 < getConfig().filterVideoMinSecond) {
                    return null;
                }
            } else {
                j11 = j15;
            }
            if (getConfig().filterVideoMaxSecond > 0 && j14 > getConfig().filterVideoMaxSecond) {
                return null;
            }
            if (getConfig().isFilterSizeDuration && j14 <= 0) {
                return null;
            }
        }
        LocalMedia create = LocalMedia.create();
        create.setId(j12);
        create.setBucketId(j16);
        create.setPath(str);
        create.setRealPath(string2);
        create.setFileName(string4);
        create.setParentFolderName(string3);
        create.setDuration(j14);
        create.setChooseModel(getConfig().chooseMode);
        create.setMimeType(string);
        create.setWidth(i13);
        create.setHeight(i11);
        create.setSize(j11);
        create.setDateAddedTime(j10);
        OnQueryFilterListener onQueryFilterListener = this.mConfig.onQueryFilterListener;
        if (onQueryFilterListener != null && onQueryFilterListener.onFilter(create)) {
            return null;
        }
        return create;
    }
}

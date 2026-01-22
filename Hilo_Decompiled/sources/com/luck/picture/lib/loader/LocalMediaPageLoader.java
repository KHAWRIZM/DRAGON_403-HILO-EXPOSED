package com.luck.picture.lib.loader;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.entity.MediaData;
import com.luck.picture.lib.interfaces.OnQueryAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import com.luck.picture.lib.utils.MediaUtils;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.SdkVersionUtils;
import com.luck.picture.lib.utils.SortUtils;
import com.luck.picture.lib.utils.ValueOf;
import com.qiahao.hilo_message.activity.MediaDetailActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class LocalMediaPageLoader extends IBridgeMediaLoader {
    public LocalMediaPageLoader(Context context, SelectorConfig selectorConfig) {
        super(context, selectorConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFirstCoverMimeType(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFirstUri(Cursor cursor) {
        return MediaUtils.getRealPathUri(cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID)), cursor.getString(cursor.getColumnIndexOrThrow("mime_type")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFirstUrl(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndexOrThrow("_data"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPageSelection(long j10) {
        String durationCondition = getDurationCondition();
        String fileSizeCondition = getFileSizeCondition();
        int i10 = getConfig().chooseMode;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    return getPageSelectionArgsForAudioMediaCondition(j10, getAudioMimeTypeCondition(), durationCondition, fileSizeCondition);
                }
                return getPageSelectionArgsForVideoMediaCondition(j10, getVideoMimeTypeCondition(), durationCondition, fileSizeCondition);
            }
            return getPageSelectionArgsForImageMediaCondition(j10, getImageMimeTypeCondition(), fileSizeCondition);
        }
        return getPageSelectionArgsForAllMediaCondition(j10, getImageMimeTypeCondition(), getVideoMimeTypeCondition(), durationCondition, fileSizeCondition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] getPageSelectionArgs(long j10) {
        int i10 = getConfig().chooseMode;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    return getSelectionArgsForPageSingleMediaType(2, j10);
                }
                return getSelectionArgsForPageSingleMediaType(3, j10);
            }
            return getSelectionArgsForPageSingleMediaType(1, j10);
        }
        if (j10 == -1) {
            return new String[]{String.valueOf(1), String.valueOf(3)};
        }
        return new String[]{String.valueOf(1), String.valueOf(3), ValueOf.toString(Long.valueOf(j10))};
    }

    private static String getPageSelectionArgsForAllMediaCondition(long j10, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
        sb.append("=?");
        sb.append(str);
        sb.append(" OR ");
        sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
        sb.append("=?");
        sb.append(str2);
        sb.append(" AND ");
        sb.append(str3);
        sb.append(")");
        sb.append(" AND ");
        if (j10 == -1) {
            sb.append(str4);
            return sb.toString();
        }
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str4);
        return sb.toString();
    }

    private static String getPageSelectionArgsForAudioMediaCondition(long j10, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
        sb.append("=?");
        sb.append(str);
        sb.append(" AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j10 == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    private static String getPageSelectionArgsForImageMediaCondition(long j10, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
        sb.append("=?");
        if (j10 == -1) {
            sb.append(str);
            sb.append(") AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append(str);
        sb.append(") AND ");
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str2);
        return sb.toString();
    }

    private static String getPageSelectionArgsForVideoMediaCondition(long j10, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
        sb.append("=?");
        sb.append(str);
        sb.append(" AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j10 == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id");
        sb.append("=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    private String getSelectionArgsForAllMediaCondition(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
        sb.append("=?");
        sb.append(str3);
        sb.append(" OR ");
        sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
        sb.append("=?");
        sb.append(str4);
        sb.append(" AND ");
        sb.append(str);
        sb.append(")");
        sb.append(" AND ");
        sb.append(str2);
        if (isWithAllQuery()) {
            return sb.toString();
        }
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    private String getSelectionArgsForAudioMediaCondition(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (isWithAllQuery()) {
            sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
            sb.append("=?");
            sb.append(str2);
            sb.append(" AND ");
            sb.append(str);
            return sb.toString();
        }
        sb.append("(");
        sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
        sb.append("=?");
        sb.append(str2);
        sb.append(") AND ");
        sb.append(str);
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    private String getSelectionArgsForImageMediaCondition(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (isWithAllQuery()) {
            sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
            sb.append("=?");
            sb.append(str2);
            sb.append(" AND ");
            sb.append(str);
            return sb.toString();
        }
        sb.append("(");
        sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
        sb.append("=?");
        sb.append(str2);
        sb.append(") AND ");
        sb.append(str);
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    private static String[] getSelectionArgsForPageSingleMediaType(int i10, long j10) {
        if (j10 == -1) {
            return new String[]{String.valueOf(i10)};
        }
        return new String[]{String.valueOf(i10), ValueOf.toString(Long.valueOf(j10))};
    }

    private String getSelectionArgsForVideoMediaCondition(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (isWithAllQuery()) {
            sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
            sb.append("=?");
            sb.append(str2);
            sb.append(" AND ");
            sb.append(str);
            return sb.toString();
        }
        sb.append("(");
        sb.append(MediaDetailActivity.EXTRA_MEDIA_TYPE);
        sb.append("=?");
        sb.append(str2);
        sb.append(") AND ");
        sb.append(str);
        sb.append(")");
        sb.append(" GROUP BY (bucket_id");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWithAllQuery() {
        if (SdkVersionUtils.isQ()) {
            return true;
        }
        return getConfig().isPageSyncAsCount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void synchronousFirstCover(List<LocalMediaFolder> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            LocalMediaFolder localMediaFolder = list.get(i10);
            if (localMediaFolder != null) {
                String albumFirstCover = getAlbumFirstCover(localMediaFolder.getBucketId());
                if (!TextUtils.isEmpty(albumFirstCover)) {
                    localMediaFolder.setFirstImagePath(albumFirstCover);
                }
            }
        }
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    public String getAlbumFirstCover(long j10) {
        Cursor cursor;
        Cursor query;
        String string;
        Cursor cursor2 = null;
        try {
            if (SdkVersionUtils.isR()) {
                query = getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, new String[]{TransferTable.COLUMN_ID, "mime_type", "_data"}, MediaUtils.createQueryArgsBundle(getPageSelection(j10), getPageSelectionArgs(j10), 1, 0, getSortOrder()), null);
            } else {
                query = getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, new String[]{TransferTable.COLUMN_ID, "mime_type", "_data"}, getPageSelection(j10), getPageSelectionArgs(j10), getSortOrder() + " limit 1 offset 0");
            }
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        if (query.moveToFirst()) {
                            long j11 = query.getLong(query.getColumnIndexOrThrow(TransferTable.COLUMN_ID));
                            String string2 = query.getString(query.getColumnIndexOrThrow("mime_type"));
                            if (SdkVersionUtils.isQ()) {
                                string = MediaUtils.getRealPathUri(j11, string2);
                            } else {
                                string = query.getString(query.getColumnIndexOrThrow("_data"));
                            }
                            if (!query.isClosed()) {
                                query.close();
                            }
                            return string;
                        }
                        if (!query.isClosed()) {
                            query.close();
                        }
                        return null;
                    }
                } catch (Exception e10) {
                    cursor = query;
                    e = e10;
                    try {
                        e.printStackTrace();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    cursor2 = query;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
        } catch (Exception e11) {
            e = e11;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
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
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<List<LocalMediaFolder>>() { // from class: com.luck.picture.lib.loader.LocalMediaPageLoader.3
            /* JADX WARN: Code restructure failed: missing block: B:10:0x02f5, code lost:
            
                if (r2.isClosed() == false) goto L٩٣;
             */
            /* JADX WARN: Code restructure failed: missing block: B:114:0x02df, code lost:
            
                if (r2.isClosed() != false) goto L١٠٢;
             */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x02e1, code lost:
            
                r2.close();
             */
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public List<LocalMediaFolder> doInBackground() {
                int i10;
                String str;
                Context context;
                int i11;
                long lastModified;
                long valueOf;
                Cursor query = LocalMediaPageLoader.this.getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, LocalMediaPageLoader.this.isWithAllQuery() ? IBridgeMediaLoader.PROJECTION : IBridgeMediaLoader.ALL_PROJECTION, LocalMediaPageLoader.this.getSelection(), LocalMediaPageLoader.this.getSelectionArgs(), LocalMediaPageLoader.this.getSortOrder());
                try {
                    if (query != null) {
                        try {
                            int count = query.getCount();
                            ArrayList<LocalMediaFolder> arrayList = new ArrayList();
                            if (count > 0) {
                                if (LocalMediaPageLoader.this.isWithAllQuery()) {
                                    HashMap hashMap = new HashMap();
                                    HashSet hashSet = new HashSet();
                                    while (query.moveToNext()) {
                                        if (LocalMediaPageLoader.this.getConfig().isPageSyncAsCount) {
                                            LocalMedia parseLocalMedia = LocalMediaPageLoader.this.parseLocalMedia(query, true);
                                            if (parseLocalMedia != null) {
                                                parseLocalMedia.recycle();
                                            }
                                        }
                                        long j10 = query.getLong(query.getColumnIndexOrThrow("bucket_id"));
                                        Long l10 = (Long) hashMap.get(Long.valueOf(j10));
                                        if (l10 == null) {
                                            valueOf = 1L;
                                        } else {
                                            valueOf = Long.valueOf(l10.longValue() + 1);
                                        }
                                        hashMap.put(Long.valueOf(j10), valueOf);
                                        if (!hashSet.contains(Long.valueOf(j10))) {
                                            LocalMediaFolder localMediaFolder = new LocalMediaFolder();
                                            localMediaFolder.setBucketId(j10);
                                            String string = query.getString(query.getColumnIndexOrThrow("bucket_display_name"));
                                            String string2 = query.getString(query.getColumnIndexOrThrow("mime_type"));
                                            if (hashMap.containsKey(Long.valueOf(j10))) {
                                                Long l11 = (Long) hashMap.get(Long.valueOf(j10));
                                                l11.longValue();
                                                long j11 = query.getLong(query.getColumnIndexOrThrow(TransferTable.COLUMN_ID));
                                                localMediaFolder.setFolderName(string);
                                                localMediaFolder.setFolderTotalNum(ValueOf.toInt(l11));
                                                localMediaFolder.setFirstImagePath(MediaUtils.getRealPathUri(j11, string2));
                                                localMediaFolder.setFirstMimeType(string2);
                                                arrayList.add(localMediaFolder);
                                                hashSet = hashSet;
                                                hashSet.add(Long.valueOf(j10));
                                            }
                                        }
                                    }
                                    i10 = 0;
                                    for (LocalMediaFolder localMediaFolder2 : arrayList) {
                                        int i12 = ValueOf.toInt(hashMap.get(Long.valueOf(localMediaFolder2.getBucketId())));
                                        localMediaFolder2.setFolderTotalNum(i12);
                                        i10 += i12;
                                    }
                                } else {
                                    query.moveToFirst();
                                    int i13 = 0;
                                    do {
                                        String string3 = query.getString(query.getColumnIndexOrThrow("_data"));
                                        String string4 = query.getString(query.getColumnIndexOrThrow("bucket_display_name"));
                                        String string5 = query.getString(query.getColumnIndexOrThrow("mime_type"));
                                        long j12 = query.getLong(query.getColumnIndexOrThrow("bucket_id"));
                                        int i14 = query.getInt(query.getColumnIndexOrThrow("count"));
                                        LocalMediaFolder localMediaFolder3 = new LocalMediaFolder();
                                        localMediaFolder3.setBucketId(j12);
                                        localMediaFolder3.setFirstImagePath(string3);
                                        localMediaFolder3.setFolderName(string4);
                                        localMediaFolder3.setFirstMimeType(string5);
                                        localMediaFolder3.setFolderTotalNum(i14);
                                        arrayList.add(localMediaFolder3);
                                        i13 += i14;
                                    } while (query.moveToNext());
                                    i10 = i13;
                                }
                                LocalMediaFolder localMediaFolder4 = new LocalMediaFolder();
                                LocalMediaFolder loadInAppSandboxFolderFile = SandboxFileLoader.loadInAppSandboxFolderFile(LocalMediaPageLoader.this.getContext(), LocalMediaPageLoader.this.getConfig().sandboxDir);
                                if (loadInAppSandboxFolderFile != null) {
                                    arrayList.add(loadInAppSandboxFolderFile);
                                    long lastModified2 = new File(loadInAppSandboxFolderFile.getFirstImagePath()).lastModified();
                                    i10 += loadInAppSandboxFolderFile.getFolderTotalNum();
                                    localMediaFolder4.setData(new ArrayList<>());
                                    if (query.moveToFirst()) {
                                        localMediaFolder4.setFirstImagePath(SdkVersionUtils.isQ() ? LocalMediaPageLoader.getFirstUri(query) : LocalMediaPageLoader.getFirstUrl(query));
                                        localMediaFolder4.setFirstMimeType(LocalMediaPageLoader.getFirstCoverMimeType(query));
                                        if (PictureMimeType.isContent(localMediaFolder4.getFirstImagePath())) {
                                            lastModified = new File(PictureFileUtils.getPath(LocalMediaPageLoader.this.getContext(), Uri.parse(localMediaFolder4.getFirstImagePath()))).lastModified();
                                        } else {
                                            lastModified = new File(localMediaFolder4.getFirstImagePath()).lastModified();
                                        }
                                        if (lastModified2 > lastModified) {
                                            localMediaFolder4.setFirstImagePath(loadInAppSandboxFolderFile.getFirstImagePath());
                                            localMediaFolder4.setFirstMimeType(loadInAppSandboxFolderFile.getFirstMimeType());
                                        }
                                    }
                                } else if (query.moveToFirst()) {
                                    localMediaFolder4.setFirstImagePath(SdkVersionUtils.isQ() ? LocalMediaPageLoader.getFirstUri(query) : LocalMediaPageLoader.getFirstUrl(query));
                                    localMediaFolder4.setFirstMimeType(LocalMediaPageLoader.getFirstCoverMimeType(query));
                                }
                                if (i10 == 0) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                    return arrayList;
                                }
                                SortUtils.sortFolder(arrayList);
                                localMediaFolder4.setFolderTotalNum(i10);
                                localMediaFolder4.setBucketId(-1L);
                                if (TextUtils.isEmpty(LocalMediaPageLoader.this.getConfig().defaultAlbumName)) {
                                    if (LocalMediaPageLoader.this.getConfig().chooseMode == SelectMimeType.ofAudio()) {
                                        context = LocalMediaPageLoader.this.getContext();
                                        i11 = R.string.ps_all_audio;
                                    } else {
                                        context = LocalMediaPageLoader.this.getContext();
                                        i11 = R.string.ps_camera_roll;
                                    }
                                    str = context.getString(i11);
                                } else {
                                    str = LocalMediaPageLoader.this.getConfig().defaultAlbumName;
                                }
                                localMediaFolder4.setFolderName(str);
                                arrayList.add(0, localMediaFolder4);
                                if (LocalMediaPageLoader.this.getConfig().isSyncCover && LocalMediaPageLoader.this.getConfig().chooseMode == SelectMimeType.ofAll()) {
                                    LocalMediaPageLoader.this.synchronousFirstCover(arrayList);
                                }
                                if (!query.isClosed()) {
                                    query.close();
                                }
                                return arrayList;
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            Log.i(IBridgeMediaLoader.TAG, "loadAllMedia Data Error: " + e10.getMessage());
                        }
                    }
                    if (query != null) {
                    }
                    return new ArrayList();
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
                LocalMedia.destroyPool();
                OnQueryAllAlbumListener onQueryAllAlbumListener2 = onQueryAllAlbumListener;
                if (onQueryAllAlbumListener2 != null) {
                    onQueryAllAlbumListener2.onComplete(list);
                }
            }
        });
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    public void loadOnlyInAppDirAllMedia(final OnQueryAlbumListener<LocalMediaFolder> onQueryAlbumListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<LocalMediaFolder>() { // from class: com.luck.picture.lib.loader.LocalMediaPageLoader.2
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public LocalMediaFolder doInBackground() {
                return SandboxFileLoader.loadInAppSandboxFolderFile(LocalMediaPageLoader.this.getContext(), LocalMediaPageLoader.this.getConfig().sandboxDir);
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
    public void loadPageMediaData(final long j10, final int i10, final int i11, final OnQueryDataResultListener<LocalMedia> onQueryDataResultListener) {
        PictureThreadUtils.executeByIo(new PictureThreadUtils.SimpleTask<MediaData>() { // from class: com.luck.picture.lib.loader.LocalMediaPageLoader.1
            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public MediaData doInBackground() {
                String str;
                ArrayList<LocalMedia> loadInAppSandboxFile;
                Cursor cursor = null;
                try {
                    try {
                        boolean z10 = true;
                        if (SdkVersionUtils.isR()) {
                            String pageSelection = LocalMediaPageLoader.this.getPageSelection(j10);
                            String[] pageSelectionArgs = LocalMediaPageLoader.this.getPageSelectionArgs(j10);
                            int i12 = i11;
                            cursor = LocalMediaPageLoader.this.getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, IBridgeMediaLoader.PROJECTION, MediaUtils.createQueryArgsBundle(pageSelection, pageSelectionArgs, i12, (i10 - 1) * i12, LocalMediaPageLoader.this.getSortOrder()), null);
                        } else {
                            if (i10 == -1) {
                                str = LocalMediaPageLoader.this.getSortOrder();
                            } else {
                                str = LocalMediaPageLoader.this.getSortOrder() + " limit " + i11 + " offset " + ((i10 - 1) * i11);
                            }
                            cursor = LocalMediaPageLoader.this.getContext().getContentResolver().query(IBridgeMediaLoader.QUERY_URI, IBridgeMediaLoader.PROJECTION, LocalMediaPageLoader.this.getPageSelection(j10), LocalMediaPageLoader.this.getPageSelectionArgs(j10), str);
                        }
                        if (cursor != null) {
                            ArrayList arrayList = new ArrayList();
                            if (cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                do {
                                    LocalMedia parseLocalMedia = LocalMediaPageLoader.this.parseLocalMedia(cursor, false);
                                    if (parseLocalMedia != null) {
                                        arrayList.add(parseLocalMedia);
                                    }
                                } while (cursor.moveToNext());
                            }
                            if (j10 == -1 && i10 == 1 && (loadInAppSandboxFile = SandboxFileLoader.loadInAppSandboxFile(LocalMediaPageLoader.this.getContext(), LocalMediaPageLoader.this.getConfig().sandboxDir)) != null) {
                                arrayList.addAll(loadInAppSandboxFile);
                                SortUtils.sortLocalMediaAddedTime(arrayList);
                            }
                            if (cursor.getCount() <= 0) {
                                z10 = false;
                            }
                            MediaData mediaData = new MediaData(z10, arrayList);
                            if (!cursor.isClosed()) {
                                cursor.close();
                            }
                            return mediaData;
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return new MediaData();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        Log.i(IBridgeMediaLoader.TAG, "loadMedia Page Data Error: " + e10.getMessage());
                        MediaData mediaData2 = new MediaData();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return mediaData2;
                    }
                } catch (Throwable th) {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    throw th;
                }
            }

            @Override // com.luck.picture.lib.thread.PictureThreadUtils.Task
            public void onSuccess(MediaData mediaData) {
                PictureThreadUtils.cancel(this);
                OnQueryDataResultListener onQueryDataResultListener2 = onQueryDataResultListener;
                if (onQueryDataResultListener2 != null) {
                    ArrayList<LocalMedia> arrayList = mediaData.data;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    onQueryDataResultListener2.onComplete(arrayList, mediaData.isHasNextMore);
                }
            }
        });
    }

    @Override // com.luck.picture.lib.loader.IBridgeMediaLoader
    protected LocalMedia parseLocalMedia(Cursor cursor, boolean z10) {
        String str;
        String str2;
        int i10;
        long j10;
        LocalMedia create;
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
        long j11 = cursor.getLong(columnIndexOrThrow);
        String string = cursor.getString(columnIndexOrThrow3);
        String string2 = cursor.getString(columnIndexOrThrow2);
        if (SdkVersionUtils.isQ()) {
            str = MediaUtils.getRealPathUri(j11, string);
        } else {
            str = string2;
        }
        if (TextUtils.isEmpty(string)) {
            string = PictureMimeType.ofJPEG();
        }
        if (getConfig().isFilterInvalidFile) {
            if (PictureMimeType.isHasImage(string)) {
                if (!TextUtils.isEmpty(string2) && !PictureFileUtils.isImageFileExists(string2)) {
                    return null;
                }
            } else if (!PictureFileUtils.isFileExists(string2)) {
                return null;
            }
        }
        if (string.endsWith(SelectMimeType.SYSTEM_IMAGE)) {
            string = MediaUtils.getMimeTypeFromMediaUrl(string2);
            str2 = str;
            if (!getConfig().isGif && PictureMimeType.isHasGif(string)) {
                return null;
            }
        } else {
            str2 = str;
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
        int i11 = cursor.getInt(columnIndexOrThrow4);
        int i12 = cursor.getInt(columnIndexOrThrow5);
        int i13 = cursor.getInt(columnIndexOrThrow12);
        if (i13 != 90 && i13 != 270) {
            i10 = i11;
        } else {
            i10 = cursor.getInt(columnIndexOrThrow5);
            i12 = cursor.getInt(columnIndexOrThrow4);
        }
        long j12 = cursor.getLong(columnIndexOrThrow6);
        long j13 = cursor.getLong(columnIndexOrThrow7);
        String string3 = cursor.getString(columnIndexOrThrow8);
        String string4 = cursor.getString(columnIndexOrThrow9);
        long j14 = cursor.getLong(columnIndexOrThrow10);
        long j15 = cursor.getLong(columnIndexOrThrow11);
        if (TextUtils.isEmpty(string4)) {
            string4 = PictureMimeType.getUrlToFileName(string2);
        }
        if (getConfig().isFilterSizeDuration && j13 > 0 && j13 < 1024) {
            return null;
        }
        if (!PictureMimeType.isHasVideo(string) && !PictureMimeType.isHasAudio(string)) {
            j10 = j15;
        } else {
            if (getConfig().filterVideoMinSecond > 0) {
                j10 = j15;
                if (j12 < getConfig().filterVideoMinSecond) {
                    return null;
                }
            } else {
                j10 = j15;
            }
            if (getConfig().filterVideoMaxSecond > 0 && j12 > getConfig().filterVideoMaxSecond) {
                return null;
            }
            if (getConfig().isFilterSizeDuration && j12 <= 0) {
                return null;
            }
        }
        if (z10) {
            create = LocalMedia.obtain();
        } else {
            create = LocalMedia.create();
        }
        create.setId(j11);
        create.setBucketId(j14);
        create.setPath(str2);
        create.setRealPath(string2);
        create.setFileName(string4);
        create.setParentFolderName(string3);
        create.setDuration(j12);
        create.setChooseModel(getConfig().chooseMode);
        create.setMimeType(string);
        create.setWidth(i10);
        create.setHeight(i12);
        create.setSize(j13);
        create.setDateAddedTime(j10);
        OnQueryFilterListener onQueryFilterListener = this.mConfig.onQueryFilterListener;
        if (onQueryFilterListener != null && onQueryFilterListener.onFilter(create)) {
            return null;
        }
        return create;
    }
}

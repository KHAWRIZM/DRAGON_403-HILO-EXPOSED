package com.liulishuo.okdownload.core.breakpoint;

import android.database.Cursor;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BreakpointInfoRow {
    private final boolean chunked;
    private final String etag;
    private final String filename;
    private final int id;
    private final String parentPath;
    private final boolean taskOnlyProvidedParentPath;
    private final String url;

    public BreakpointInfoRow(Cursor cursor) {
        boolean z10;
        this.id = cursor.getInt(cursor.getColumnIndex("id"));
        this.url = cursor.getString(cursor.getColumnIndex("url"));
        this.etag = cursor.getString(cursor.getColumnIndex("etag"));
        this.parentPath = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.PARENT_PATH));
        this.filename = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.FILENAME));
        if (cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.TASK_ONLY_PARENT_PATH)) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.taskOnlyProvidedParentPath = z10;
        this.chunked = cursor.getInt(cursor.getColumnIndex("chunked")) == 1;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getFilename() {
        return this.filename;
    }

    public int getId() {
        return this.id;
    }

    public String getParentPath() {
        return this.parentPath;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public boolean isTaskOnlyProvidedParentPath() {
        return this.taskOnlyProvidedParentPath;
    }

    public BreakpointInfo toInfo() {
        BreakpointInfo breakpointInfo = new BreakpointInfo(this.id, this.url, new File(this.parentPath), this.filename, this.taskOnlyProvidedParentPath);
        breakpointInfo.setEtag(this.etag);
        breakpointInfo.setChunked(this.chunked);
        return breakpointInfo;
    }
}

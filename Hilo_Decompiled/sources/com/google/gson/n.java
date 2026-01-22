package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class n {
    public static i a(JsonReader jsonReader) {
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                return q8.m.a(jsonReader);
            } catch (OutOfMemoryError e10) {
                throw new m("Failed parsing JSON source: " + jsonReader + " to Json", e10);
            } catch (StackOverflowError e11) {
                throw new m("Failed parsing JSON source: " + jsonReader + " to Json", e11);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }

    public static i b(Reader reader) {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            i a10 = a(jsonReader);
            if (!a10.k() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new r("Did not consume the entire document.");
            }
            return a10;
        } catch (MalformedJsonException e10) {
            throw new r(e10);
        } catch (IOException e11) {
            throw new j(e11);
        } catch (NumberFormatException e12) {
            throw new r(e12);
        }
    }

    public static i c(String str) {
        return b(new StringReader(str));
    }
}

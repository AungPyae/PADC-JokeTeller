package xyz.aungpyaephyo.joketeller.utils;

import android.content.Context;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

import xyz.aungpyaephyo.joketeller.JokeTellerApp;

/**
 * Created by aung on 12/12/15.
 */
public class JsonUtils {

    private static final String PATH_DUMMY_DATA = "dummy_data";

    private static JsonUtils objInstace;

    public static JsonUtils getInstance() {
        if (objInstace == null) {
            objInstace = new JsonUtils();
        }

        return objInstace;
    }

    private JsonUtils() {

    }

    /**
     * Read text from assets folder.
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    private byte[] readJsonFile(Context context, String fileName) throws IOException {
        InputStream inStream = context.getAssets().open(fileName);
        int size = inStream.available();
        byte[] buffer = new byte[size];
        inStream.read(buffer);
        inStream.close();
        return buffer;
    }

    /**
     * @param fileName - name of Json File.
     * @return JSONObject from loaded file.
     * @throws IOException
     * @throws JSONException
     */
    public String loadDummyData(Context context, String fileName) throws IOException, JSONException {
        byte[] buffer = readJsonFile(context, PATH_DUMMY_DATA + "/" + fileName);
        return new String(buffer, "UTF-8").toString();
    }
}

package campaigncode.tool.fsecure.com.campaigncode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

//adb shell am broadcast -a com.android.vending.INSTALL_REFERRER --es "referrer" "utm_term%3Dgwf2doj341sd"

public class InstallReferrerReceiver extends BroadcastReceiver {
    public static final String KEY_UTM_SOURCE = "utm_source";
    public static final String KEY_UTM_CONTENT = "utm_content";
    public static final String KEY_UTM_CAMPAIGN = "utm_campaign";
    final String D_TAG = "BR";




    public void onReceive(Context context, Intent intent) {
        try {
            Log.i(D_TAG, "onReceive: " + intent);
            String referrer = intent.getStringExtra("referrer");
            String[] referrerParts = referrer.split("&");
            String utmSource = getData(KEY_UTM_SOURCE, referrerParts);
            String utmContent = getData(KEY_UTM_CONTENT, referrerParts);
            String utmCampaign = getData(KEY_UTM_CAMPAIGN, referrerParts);
            Log.d(D_TAG, "CustomReceiver onReceive (context, intent)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getData(String key, String[] allData) {
        for (String selected : allData)
            if (selected.contains(key)) {
                return selected.split("=")[1];
            }
        return "";
    }
}

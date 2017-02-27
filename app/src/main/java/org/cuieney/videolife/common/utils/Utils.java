package org.cuieney.videolife.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by cuieney on 16/8/25.
 */
public class Utils {

    public static String getApplicationVersionName(Context context) {
        try {
            PackageInfo pinfo = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            String versionName = pinfo.versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    public static String getApplicationPackageName(Context context) {
        try {
            PackageInfo pinfo = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return pinfo.packageName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    /**
     * Check whether the network is available.
     *
     * @param context
     * @return true if the network is available.
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].isConnected()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean isWifiActive(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info;
        if (connectivity != null) {
            info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if ((info[i].getTypeName().equalsIgnoreCase("WIFI") || info[i]
                            .getTypeName().equalsIgnoreCase("WI FI"))
                            && info[i].isConnected()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Check the network is available and not wifi,maybe 2G or 3G data
     * connection.
     *
     * @param context
     * @return true if is not wifi.
     */
    public static boolean isNetworkAvailableAndNotWifi(Context context) {
        return isNetworkAvailable(context) && !isWifiActive(context);
    }

    private void  rediter(String url){
        try {
            HttpURLConnection con = (HttpURLConnection)(new URL( url ).openConnection());
            con.setInstanceFollowRedirects( false );
            con.connect();
            int responseCode = con.getResponseCode();
            Log.e("oye", responseCode +"");
            String location = con.getHeaderField( "Location" );
            Log.e("oye", location);

            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setReadTimeout(5000);
            conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
            conn.addRequestProperty("User-Agent", "Mozilla");
            conn.addRequestProperty("Referer", "google.com");

            Log.e("oye","Request URL ... " + url);

            boolean redirect = false;

            // normally, 3xx is redirect
            int status = conn.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) {
                if (status == HttpURLConnection.HTTP_MOVED_TEMP
                        || status == HttpURLConnection.HTTP_MOVED_PERM
                        || status == HttpURLConnection.HTTP_SEE_OTHER)
                    redirect = true;
            }

            Log.e("oye","Response Code ... " + status);

            if (redirect) {

                // get redirect url from "location" header field
                String newUrl = conn.getHeaderField("Location");

                // get the cookie if need, for login
                String cookies = conn.getHeaderField("Set-Cookie");

                // open the new connnection again
                conn = (HttpURLConnection) new URL(newUrl).openConnection();
                conn.setRequestProperty("Cookie", cookies);
                conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
                conn.addRequestProperty("User-Agent", "Mozilla");
                conn.addRequestProperty("Referer", "google.com");

                Log.e("oye","Redirect to URL : " + newUrl);

            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer html = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                html.append(inputLine);
            }
            in.close();

            Log.e("oye","URL Content... \n" + html.toString());
            Log.e("oye","Done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

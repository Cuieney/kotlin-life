package org.cuieney.videolife.common.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * GPRS : 2G(2.5) General Packet Radia Service 114kbps
 * EDGE : 2G(2.75G) Enhanced Data Rate for GSM Evolution 384kbps
 * UMTS : 3G WCDMA 联通3G Universal Mobile Telecommunication System 完整的3G移动通信技术标准
 * CDMA : 2G 电信 Code Division Multiple Access 码分多址
 * EVDO_0 : 3G (EVDO 全程 CDMA2000 1xEV-DO) Evolution - Data Only (Data Optimized) 153.6kps - 2.4mbps 属于3G
 * EVDO_A : 3G 1.8mbps - 3.1mbps 属于3G过渡，3.5G
 * 1xRTT : 2G CDMA2000 1xRTT (RTT - 无线电传输技术) 144kbps 2G的过渡,
 * HSDPA : 3.5G 高速下行分组接入 3.5G WCDMA High Speed Downlink Packet Access 14.4mbps
 * HSUPA : 3.5G High Speed Uplink Packet Access 高速上行链路分组接入 1.4 - 5.8 mbps
 * HSPA : 3G (分HSDPA,HSUPA) High Speed Packet Access
 * IDEN : 2G Integrated Dispatch Enhanced Networks 集成数字增强型网络 （属于2G，来自维基百科）
 * EVDO_B : 3G EV-DO Rev.B 14.7Mbps 下行 3.5G
 * LTE : 4G Long Term Evolution FDD-LTE 和 TDD-LTE , 3G过渡，升级版 LTE Advanced 才是4G
 * EHRPD : 3G CDMA2000向LTE 4G的中间产物 Evolved High Rate Packet Data HRPD的升级
 * HSPAP : 3G HSPAP 比 HSDPA 快些
 */

/**
 * 专网
 */
public class NetWorkUtil {
    public enum NetType {
        NETWORK_UNKNOWN, NETWORK_WIFI, NETWORK_3_G, NETWORK_4_G, NETWORK_2_G
    }

    /**
     * 网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        if (context != null) {
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
        }
        return false;
    }

    /**
     * 判断是否有网络连接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager
                    .getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 判断WIFI网络是否可用
     *
     * @param icontext
     * @return
     */
    public static boolean isWifiConnected(Context icontext) {
        Context context = icontext.getApplicationContext();
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info;
        if (connectivity != null) {
            info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if ((info[i].getTypeName().equalsIgnoreCase("WIFI") || info[i].getTypeName()
                            .equalsIgnoreCase("WI FI")) && info[i].isConnected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 判断MOBILE 网络是否可用
     *
     * @param context
     * @return
     */
    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 获取当前网络连接的类型信息
     *
     * @param context
     * @return
     */
    public static int getConnectedType(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager
                    .getActiveNetworkInfo();
            if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
                return mNetworkInfo.getType();
            }
        }
        return -1;
    }

    /**
     * @return netType 返回类型
     * @throws
     * @方法名: getAPNType
     * @说 明: 获取当前的网络状态 -1：没有网络 1：WIFI网络2：wap 网络3：net网络
     * @参 数: @param context
     * @参 数: @return
     */
    public static NetType getNetworkType(Context context) {
        NetType netType = null;
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                netType = NetType.NETWORK_WIFI;
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {

                // TD-SCDMA   networkType is 17
                int networkType = networkInfo.getSubtype();
                switch (networkType) {
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                    case TelephonyManager.NETWORK_TYPE_IDEN: //api<8 : replace by 11
                        netType = NetType.NETWORK_2_G;
                        break;
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_B: //api<9 : replace by 14
                    case TelephonyManager.NETWORK_TYPE_EHRPD:  //api<11 : replace by 12
                    case TelephonyManager.NETWORK_TYPE_HSPAP:  //api<13 : replace by 15
                        netType = NetType.NETWORK_3_G;
                        break;
                    case TelephonyManager.NETWORK_TYPE_LTE:    //api<11 : replace by 13
                        netType = NetType.NETWORK_4_G;
                        break;
                    default:
                        String typeName = networkInfo.getSubtypeName();
                        // http://baike.baidu.com/item/TD-SCDMA 中国移动 联通 电信 三种3G制式
                        if (typeName.equalsIgnoreCase("TD-SCDMA") || typeName.equalsIgnoreCase("WCDMA") || typeName.equalsIgnoreCase("CDMA2000")) {
                            netType = NetType.NETWORK_3_G;
                        } else {
                            netType = NetType.NETWORK_UNKNOWN;
                        }
                        break;
                }
            }
        }

        return netType;
    }

    public static class APNNet {
        /**
         * Network type is unknown
         */
        public static final int NETWORK_TYPE_UNKNOWN = 0;
        /**
         * Current network is GPRS
         */
        public static final int NETWORK_TYPE_GPRS = 1;
        /**
         * Current network is EDGE
         */
        public static final int NETWORK_TYPE_EDGE = 2;
        /**
         * Current network is UMTS
         */
        public static final int NETWORK_TYPE_UMTS = 3;
        /**
         * Current network is CDMA: Either IS95A or IS95B
         */
        public static final int NETWORK_TYPE_CDMA = 4;
        /**
         * Current network is EVDO revision 0
         */
        public static final int NETWORK_TYPE_EVDO_0 = 5;
        /**
         * Current network is EVDO revision A
         */
        public static final int NETWORK_TYPE_EVDO_A = 6;
        /**
         * Current network is 1xRTT
         */
        public static final int NETWORK_TYPE_1xRTT = 7;
        /**
         * Current network is HSDPA
         */
        public static final int NETWORK_TYPE_HSDPA = 8;
        /**
         * Current network is HSUPA
         */
        public static final int NETWORK_TYPE_HSUPA = 9;
        /**
         * Current network is HSPA
         */
        public static final int NETWORK_TYPE_HSPA = 10;
        /**
         * Current network is iDen
         */
        public static final int NETWORK_TYPE_IDEN = 11;
        /**
         * Current network is EVDO revision B
         */
        public static final int NETWORK_TYPE_EVDO_B = 12;
        /**
         * Current network is LTE
         */
        public static final int NETWORK_TYPE_LTE = 13;
        /**
         * Current network is eHRPD
         */
        public static final int NETWORK_TYPE_EHRPD = 14;
        /**
         * Current network is HSPA+
         */
        public static final int NETWORK_TYPE_HSPAP = 15;
        /**
         * Current network is GSM
         */
        public static final int NETWORK_TYPE_GSM = 16;
        /**
         * Current network is TD_SCDMA
         */
        public static final int NETWORK_TYPE_TD_SCDMA = 17;
        /**
         * Current network is IWLAN
         */
        public static final int NETWORK_TYPE_IWLAN = 18;
    }
}

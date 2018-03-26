package com.sansi.stellarWiFi.util;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;

/**
 * @author lql E-mail: 595308107@qq.com
 * @version 0 创建时间：2017/4/14 10:25
 *          类说明
 */
public class GpsUtils {
    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     *
     * @param context
     * @return true 表示开启
     */
    public static final boolean isGpsOpen(final Context context) {
        LocationManager locationManager
                = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        L.e(String.format("gps:%s,network:%s",String.valueOf(gps),String.valueOf(network)));
        if (gps || network) {
            return true;
        }
        return false;
    }

    public static void openGpsActivity(Context context){
        Intent myIntent = new Intent( Settings.ACTION_SECURITY_SETTINGS );
        context.startActivity(myIntent);
    }
}

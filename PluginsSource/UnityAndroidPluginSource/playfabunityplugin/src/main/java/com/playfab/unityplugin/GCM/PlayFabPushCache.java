package com.playfab.unityplugin.GCM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 9/16/2015.
 */

/*
  * a container class that holds the data from the last push notification received by the device
*/
public class PlayFabPushCache {
    private static List<PlayFabNotificationPackage> mPushCache = new ArrayList<PlayFabNotificationPackage>();

    public static void setPushCache(PlayFabNotificationPackage notification){
        mPushCache.add(notification);
    }

    // returns the entire push cache
    public static List<PlayFabNotificationPackage> getPushCache(){
        return mPushCache == null ? new ArrayList<PlayFabNotificationPackage>() : mPushCache;
    }

    public static void clearPushCache(){
        List<PlayFabNotificationPackage> mLoopList = mPushCache;
        for( PlayFabNotificationPackage mPushCacheItem  : mLoopList){
            if(mPushCacheItem.Delivered){
                mPushCache.remove(mPushCacheItem);
            }
        }
    }

    // returns only the custom data portion of the cache
    public static String getPushCacheData(String id){
        String CustomData = "";
        for( PlayFabNotificationPackage mPushCacheItem  : mPushCache){
            if(mPushCacheItem.Id == id){
                CustomData = mPushCacheItem.CustomData;
            }
        }
        return CustomData;
    }

}


package com.zb.user9999.util;

import java.util.HashMap;

/**
 * @author zb
 * @date 2019/7/9 9:40
 **/
public class MaHashMapUtil {
    public static HashMap<String, String> hashMap = new HashMap<String, String>();

    public static void storageMa(String mail, String N) throws InterruptedException {
        hashMap.put(mail, N);
        Thread.sleep(60000);
        hashMap.remove(mail);
    }

}

package com.wemall.core.tools;

/**
 * 鎺掑簭宸ュ叿绫?
 */
public class SortUtil {
    /**
     * 鍐掓场鎺掑簭
     *
     * @paramsrc寰呮帓搴忔暟缁?
     */
    public static void doBubbleSort(int[] src){
        int len = src.length;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                int temp;
                if (src[i] > src[j]){
                    temp = src[j];
                    src[j] = src[i];
                    src[i] = temp;
                }
            }
        }
    }

    /**
     * 阃夋嫨鎺掑簭
     *
     * @paramsrc寰呮帓搴忕殑鏁扮粍
     */
    public static void doChooseSort(int[] src){
        int len = src.length;
        int temp;
        for (int i = 0; i < len; i++){
            temp = src[i];
            int j;
            int samllestLocation = i;// 链€灏忔暟镄勪笅镙?
            for (j = i + 1; j < len; j++){
                if (src[j] < temp){
                    temp = src[j];// 鍙栧嚭链€灏忓€?
                    samllestLocation = j;// 鍙栧嚭链€灏忓€兼墍鍦ㄤ笅镙?
                }
            }
            src[samllestLocation] = src[i];
            src[i] = temp;
        }
    }

    /**
     * 鎻掑叆鎺掑簭
     *
     * @paramsrc寰呮帓搴忔暟缁?
     */
    public static void doInsertSort1(int[] src){
        int len = src.length;
        for (int i = 1; i < len; i++){
            int temp = src[i];
            int j = i;

            while (src[j - 1] > temp){
                src[j] = src[j - 1];
                j--;
                if (j <= 0)
                    break;
            }
            src[j] = temp;
        }
    }
}

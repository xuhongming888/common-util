package com.xzh.www.utils;

/**
 * @Description: jsonUtil
 * @Author: xuzh1
 * @Date: 2018-09-28 15:43
 **/
public class JsonUtils {

    public static void main(String[] args) {

        int[] a = {1, 2, 3 ,4};

        int[] b = subStringArr(a, 1);




        for(int i : b){
            System.out.println(i);
        }
    }

    private static int[] subStringArr(int[] strArr, int index){
        int[] resultArr = new int[(strArr.length - 1)];
        if(index == 0){
            for(int i = 1; i< strArr.length; i++){
                resultArr[i - 1] = strArr[i];
            }
        }else if(index == (strArr.length - 1)){
            for(int i = 0; i< strArr.length - 1; i++){
                resultArr[i] = strArr[i];
            }
        }else{

            for(int i = 0; i < index; i++){
                resultArr[i] = strArr[i];
            }

            for(int i = index + 1; i < strArr.length; i++){
                resultArr[i - 1] = strArr[i];
            }
        }
        return resultArr;
    }
}

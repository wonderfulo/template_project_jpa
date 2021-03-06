package com.cxy.utils.array;//package com.cxy.utils.array;
//
//import java.util.Arrays;
//
///**
// * @author 陈翔宇
// * @version 1.0.0
// * @ClassName ArrayUitl.java
// * @Description 数组工具类
// * @createTime 2020年12月11日 13:53:00
// */
//public class MyArrayUtil {
//
//    /**
//     * 求两个数组的交集
//     */
//    public static String[] sameOfTwoArrays(String[] arr1, String[] arr2) {
//        // 新建一个空数组，用于存储交集，空数组长度应该为两个数组中最小的。
//        Object temp[] = new Object[Math.min(arr1.length, arr2.length)];
//        // 定义一个int的变量，初始值为0；用于交集数组的自增添加元素
//        int k = 0;
//        // 第一层for循环的作用是：遍历获取两个数组中的某一个元素。如果从效率上来处理，应该遍历较短的那个数组
//        for (int i = 0; i < arr1.length; i++) {
//            // 第二层for循环，遍历获取另一个数组的元素
//            for (int j = 0; j < arr2.length; j++) {
//                // 把两个数组中遍历出来的元素进行比较
//                if (arr1[i].equals(arr2[j])) {
//                    // 如果两个元素相等，就存入交集数组中，交集数组的index需要自增长，以便存放下一个相等元素
//                    temp[k++] = arr1[i];
//                    // 把第二层循环中的当前找到的与第一层循环相等的元素位置存放如数组最后一个元素
//                    arr2[j] = arr2[arr2.length - 1];
//                    // 删除最后一个元素
//                    arr2 = Arrays.copyOf(arr2, arr2.length - 1);
//                    // 结束本次内循环
//                    break;
//                }
//            }
//        }
//        return Arrays.copyOf(temp, k, String[].class);
//    }
//
//    /**
//     * long数组转String数组
//     * @param longArray
//     * @return
//     */
//    public static String[] longToString(Long longArray[]) {
//        if (longArray == null || longArray.length < 1) {
//            return null;
//        }
//        String  stringArray[] = new String[longArray.length];
//        for (int i = 0; i < stringArray.length; i++ ) {
//            try {
//                stringArray[i] = String.valueOf(longArray[i]);
//            } catch (NumberFormatException e) {
//                stringArray[i] = null;
//                continue;
//            }
//        }
//        return stringArray;
//    }
//}

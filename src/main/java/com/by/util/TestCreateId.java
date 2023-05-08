package com.by.util;

import java.math.BigInteger;
import java.util.Random;

import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.apache.commons.lang.StringUtils.leftPad;

public class TestCreateId {
    public static class IdCreateUtil {
        private static final long EPOCH = 1479533469598L; //开始时间,固定一个小于当前时间的毫秒数
        private static final int max12bit = 4095;
        private static final long max41bit= 1099511627775L;
        private static String machineId = "" ; // 机器id

        public  static long createOnlyId(){
            long time = System.currentTimeMillis() - EPOCH  + max41bit;
            // 二进制的 毫秒级时间戳
            String base = Long.toBinaryString(time);
            // 序列数
            String randomStr = leftPad(Integer.toBinaryString(new Random().nextInt(max12bit)),12,'0');
            if(isNotEmpty(machineId)){
                machineId = leftPad(machineId, 10, '0');
            }
            //拼接
            String appendStr = base + machineId + randomStr;
            // 转化为十进制 返回
            BigInteger bi = new BigInteger(appendStr, 2);
            return  Long.valueOf(bi.toString());
        }
    }

    public static void main(String[] args) {
//        System.out.println(IdCreateUtil.createOnlyId());
        int uniqueId = (int) (System.currentTimeMillis() & 0xfffffff);
        System.out.println(uniqueId);
    }
}

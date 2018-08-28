package com.ichaoge.pet.common;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SwiftNumber {

    private static final String SERIAL_NUMBER = "0001"; // 流水号格式
    private static SwiftNumber primaryGenerater = null;

    private SwiftNumber() {
    }

    /**
     * 取得PrimaryGenerater的单例实现
     *
     * @return
     */
    public static SwiftNumber getInstance() {
        if (primaryGenerater == null) {
            synchronized (SwiftNumber.class) {
                if (primaryGenerater == null) {
                    primaryGenerater = new SwiftNumber();
                }
            }
        }
        return primaryGenerater;
    }

    /**
     * 生成下一个编号
     */
    public synchronized String generaterNextNumber(String sno) {
        String id;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        if (sno == null) {
            id = formatter.format(date) + SERIAL_NUMBER;
        } else {
            int count = SERIAL_NUMBER.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append("0");
            }
            DecimalFormat df = new DecimalFormat(sb.toString());
            String substring = sno.substring(0, 6);//取单号日期
            String formatDate = formatter.format(date);//当前日期
            Integer num = Integer.parseInt(sno.substring(6, 10));//取单号尾号
            if(substring.equals(formatDate)){
                //日期相同 这单号尾号+1
                id = formatDate + df.format(1 + num);
            }else{
                //日期不同 则从新0001开始生成单号尾号
                id = formatter.format(date) + SERIAL_NUMBER;
            }
        }
        return id;
    }
}
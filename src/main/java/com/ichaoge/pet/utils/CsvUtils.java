package com.ichaoge.pet.utils;

import com.google.common.collect.Lists;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/5/15 0015.
 */
public class CsvUtils {

    // Space mark , ; : etc.
    private static final String spaceMark = ",";

    /**
     * Get parsed array from CSV file
     *
     * @return
     */
    public static List<List<String>> getParsedArray(InputStream is) throws Exception {
        List<List<String>> retval = Lists.newArrayList();
        if (null == is) {
            return retval;
        }
        String regExp = getRegExp();
        byte[] head = new byte[3];
        is.read(head);
        String code = "";
        code = "gbk";
        if(head[0]==-17 && head[1]==-69 && head[2] ==-65)
            code = "UTF-8";

        if(head[0]==-26 && head[1]==-100 && head[2] ==-120)
            code = "UTF-8";
        BufferedReader in = null;
        if (code.equals("gbk")) {
            in   = new BufferedReader(new InputStreamReader(is, "GBK"));
        } else {
            in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        }
        String strLine;
        String str;

        while ((strLine = in.readLine()) != null) {
            Pattern pattern = Pattern.compile(regExp);
            Matcher matcher = pattern.matcher(strLine);
            List<String> listTemp = Lists.newArrayList();
            while (matcher.find()) {
                str = matcher.group().trim();
                if (str.endsWith(spaceMark)) {
                    str = str.substring(0, str.length() - 1).trim();
                }

                if (str.startsWith("\"") && str.endsWith("\"")) {
                    str = str.substring(1, str.length() - 1);
                    if (CsvUtils.isExisted("\"\"", str)) {
                        str = str.replaceAll("\"\"", "\"");
                    }
                }

                listTemp.add(str);
            }

            // Add to retval
            retval.add(listTemp);
        }
        in.close();

        return retval;
    }

    /**
     * Regular Expression for CSV parse
     *
     * @return
     */
    private static String getRegExp() {
        final String SPECIAL_CHAR_A = "[^\",\\n 　]";
        final String SPECIAL_CHAR_B = "[^\"" + spaceMark + "\\n]";

        StringBuffer strRegExps = new StringBuffer();
        strRegExps.append("\"((");
        strRegExps.append(SPECIAL_CHAR_A);
        strRegExps.append("*[" + spaceMark + "\\n 　])*(");
        strRegExps.append(SPECIAL_CHAR_A);
        strRegExps.append("*\"{2})*)*");
        strRegExps.append(SPECIAL_CHAR_A);
        strRegExps.append("*\"[ 　]*" + spaceMark + "[ 　]*");
        strRegExps.append("|");
        strRegExps.append(SPECIAL_CHAR_B);
        strRegExps.append("*[ 　]*" + spaceMark + "[ 　]*");
        strRegExps.append("|\"((");
        strRegExps.append(SPECIAL_CHAR_A);
        strRegExps.append("*[" + spaceMark + "\\n 　])*(");
        strRegExps.append(SPECIAL_CHAR_A);
        strRegExps.append("*\"{2})*)*");
        strRegExps.append(SPECIAL_CHAR_A);
        strRegExps.append("*\"[ 　]*");
        strRegExps.append("|");
        strRegExps.append(SPECIAL_CHAR_B);
        strRegExps.append("*[ 　]*");
        return strRegExps.toString();
    }

    /**
     * If argChar is exist in argStr
     *
     * @param argChar
     * @param argStr
     * @return
     */
    private static boolean isExisted(String argChar, String argStr) {

        boolean blnReturnValue = false;
        if ((argStr.indexOf(argChar) >= 0)
                && (argStr.indexOf(argChar) <= argStr.length())) {
            blnReturnValue = true;
        }
        return blnReturnValue;
    }

//    public static void main(String[] args)  throws Exception{
//        CsvUtils parser=new CsvUtils("D:\\1.csv");
//        //CsvParser parser=new CsvParser("C:\\Users\\IBM_ADMIN\\Desktop\\Test CSV Files\\dummydata_not quoted_2.csv");
//        //CsvParser parser=new CsvParser("C:\\Users\\IBM_ADMIN\\Desktop\\Test CSV Files\\dummydata_quoted.csv");
//        //CsvParser parser=new CsvParser("C:\\Users\\IBM_ADMIN\\Desktophagsi~jksdjksdfsadfksdfksd893e\\Test CSV Files\\dummydata_quoted_2.csv");
//
//        //CsvParser parser=new CsvParser("C:\\Users\\IBM_ADMIN\\Desktop\\Test CSV Files\\dummydata_1.csv",";");
//        //CsvParser parser=new CsvParser("C:\\Users\\IBM_ADMIN\\Desktop\\Test CSV Files\\dummydata_2.csv",":");
//
//        Object[] arr=parser.getParsedArray();
//        //System.out.println(arr);
//
//        for(Object obj:arr){
//            System.out.print("[");
//
//            List<String> ls=(List<String>)obj;
//
//            for(String item:ls){
//                System.out.print(item+",");
//            }
//
//            System.out.println("]");
//        }
//    }
     public static void main(String[] args)  throws Exception {
       String orderNo  = "dmzk000374247905";
         System.out.println(orderNo.substring(4));
   }


}

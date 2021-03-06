package com.work.ocr.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SearchOCRState {
    public static void main(String[] args) throws IOException {
      //  BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\aaaa.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\项目\\springboot\\src\\main\\resources\\static\\batqOCR.txt"));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\aaaa2.txt"));
        int bdOCRGoodCount = 0;
        int alOCRGoodCount = 0;
        int txOCRGoodCount = 0;
        int qnOCRGoodCount = 0;

        int bdOCRErrorCount = 0;
        int alOCRErrorCount = 0;
        int txOCRErrorCount = 0;
        int qnOCRErrorCount = 0;
        StringBuilder bdstringBuilder =new StringBuilder(240);
        StringBuilder alstringBuilder =new StringBuilder(240);
        StringBuilder txstringBuilder =new StringBuilder(240);
        StringBuilder qnstringBuilder =new StringBuilder(240);
        String str1;
        while ((str1=bufferedReader.readLine())!=null) {
            //System.out.println(str1);
            //String str2 = bufferedReader.readLine();
            //System.out.println(str2);
            str1 =str1.trim();
            //str2 =str2.trim();
            /**
             * 百度
              */
            if (str1.startsWith("yybdocr")) {
                bdOCRGoodCount++;
                bdstringBuilder.append(1);
                bdstringBuilder.append(" ");
            }
            if (str1.startsWith("0yybdocr")) {
                bdOCRErrorCount++;
                bdstringBuilder.append(0);
                bdstringBuilder.append(" ");
            }

            /**
             * 阿里
             */
            if (str1.startsWith("yyalOcr")) {
                alOCRGoodCount++;
                alstringBuilder.append(1);
                alstringBuilder.append(" ");
            }
            if (str1.startsWith("0yyalOcr")) {
                alOCRErrorCount++;
                alstringBuilder.append(0);
                alstringBuilder.append(" ");
            }


            /**
             * 腾讯
             */
            if (str1.startsWith("yytxOcr")) {
                txOCRGoodCount++;
                txstringBuilder.append(1);
                txstringBuilder.append(" ");
            }
            if (str1.startsWith("0yytxOcr")) {
                txOCRErrorCount++;
                txstringBuilder.append(0);
                txstringBuilder.append(" ");
            }

            /**
             * qn
             */
            if (str1.startsWith("yyqnOcr")) {
                qnOCRGoodCount++;
                qnstringBuilder.append(1);
                qnstringBuilder.append(" ");
            }
            if (str1.startsWith("0yyqnOcr")) {
                qnOCRErrorCount++;
                qnstringBuilder.append(0);
                qnstringBuilder.append(" ");
            }


          // List<String> list = AligningStr(str1, str2);
          // List<String> list1 = AligningStr(list.get(1), list.get(0));
//            bufferedWriter.write(str1);
//            bufferedWriter.newLine();
//            bufferedWriter.write(str2);
//            bufferedWriter.newLine();
//            bufferedWriter.newLine();
//            bufferedWriter.flush();
        }


        System.out.println("百度OCR优秀数量： " + bdOCRGoodCount);
        System.out.println("阿里OCR优秀数量： " + alOCRGoodCount);
        System.out.println("腾讯OCR优秀数量： " + txOCRGoodCount);
        System.out.println("全能OCR优秀数量： " + qnOCRGoodCount);

        System.out.println("百度OCR不优秀数量： " + bdOCRErrorCount);
        System.out.println("阿里OCR不优秀数量： " + alOCRErrorCount);
        System.out.println("腾讯OCR不优秀数量： " + txOCRErrorCount);
        System.out.println("全能OCR不优秀数量： " + qnOCRErrorCount);

        System.out.println("百度识别状态集：  " + bdstringBuilder.toString());
        System.out.println("阿里识别状态集：  " + alstringBuilder.toString());
        System.out.println("腾讯识别状态集：  " + txstringBuilder.toString());
        System.out.println("全能识别状态集：  " + qnstringBuilder.toString());


            bufferedReader.close();
            //bufferedWriter.close();
    }
    public static List<String>  AligningStr(String str1, String str2){
        int i = 0;
        a : for (int j = 0; j < str1.length(); j++) {
            int startIndex = j;
            for (int k = 0; k < 10; k++) {
                if (str2.charAt(j) == str1.charAt(j)){
                    continue a;
                }
                if (str1.charAt(j) == ' '){
                    break;
                }
                if ((j + k) > str2.length()){
                    break;
                }
                if (str1.charAt(j) == str2.charAt(j + k)){
                    for (int l = 0; l < k+1; l++) {
                        if (k == 0){
                            break ;
                        }
                        StringBuilder sb = new StringBuilder(str1);
                        sb.insert(j," ");
                        str1 = sb.toString();
                    }
                    continue a;
                }
            }
            StringBuilder stringBuilder = new StringBuilder(str2);
            stringBuilder.insert(startIndex," ");
            str2 = stringBuilder.toString();
            j++;

        }
        List<String> list = new ArrayList<>();
        list.add(str1);
        list.add(str2);
        return  list;
    }
}

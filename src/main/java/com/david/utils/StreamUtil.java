package com.david.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author David Zheng
 * @date 2022/05/07
 */
public class StreamUtil {

    public static String getStringByInputStream1(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            byte[] b = new byte[10240];
            int n;
            while ((n = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, n);
            }
        } catch (Exception e) {
            try {
                inputStream.close();
                outputStream.close();
            } catch (Exception e1) {
            }
        }
        return outputStream.toString();
    }

    public static String getStringByInputStream2(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception e) {
            try {
                inputStream.close();
                bufferedReader.close();
            } catch (Exception e1) {
            }
        }
        return null;
    }

}

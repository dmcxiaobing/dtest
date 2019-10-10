package com.david.test;

import com.david.utils.FileUtil;

import java.io.File;

/**
 * @author David
 * @date 2019/9/19
 * @time 19:47
 */
public class FileTest {

    public static void main(String[] args) {
        File dir = new File("d:\\test_dir");
        FileUtil.judeDirExists(dir);
        System.out.println();
        // 写一行
        FileUtil.fileLinesWrite("/usr/local/abc/2019/"+"233","hello",true);

    }
}

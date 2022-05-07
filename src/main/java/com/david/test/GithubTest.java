package com.david.test;

import com.david.entity.GithubJsonBean;
import com.david.utils.FastJsonUtil;
import com.david.utils.FileUtil;
import com.david.utils.StreamUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David Zheng
 * @date 2022/05/07
 * https://api.github.com/users/QQ986945193/repos?per_page=100
 * https://api.github.com/users/QQ986945193/repos?per_page=100&page=2
 * https://api.github.com/users/QQ986945193/repos?per_page=100&page=3
 *
 *
 * 下载github代码，根据生成的bat脚本，使用管理员运行dos，然后执行：cloneGithub.bat
 */
public class GithubTest {


    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "src/main/resources/GithubProject.json";
        String filePath2 = "src/main/resources/GithubProject2.json";
        String filePath3 = "src/main/resources/GithubProject3.json";

        List<GithubJsonBean> list = new ArrayList<>();
        list.addAll(getList(filePath));
        list.addAll(getList(filePath2));
        list.addAll(getList(filePath3));

        int count = 0;
        for (GithubJsonBean bean : list) {
            count++;
            System.out.println(bean.getClone_url());
        }
        System.out.println(count);


        for (GithubJsonBean bean : list) {
            String bat = "git clone --depth=1 " + bean.getClone_url();
            FileUtil.fileLinesWrite("src/main/resources/cloneGithub.bat", bat, true);
        }

    }

    private static List<GithubJsonBean> getList(String filePath) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(new File(filePath));
        return FastJsonUtil.jsonToList(StreamUtil.getStringByInputStream1(inputStream), GithubJsonBean.class);
    }
}

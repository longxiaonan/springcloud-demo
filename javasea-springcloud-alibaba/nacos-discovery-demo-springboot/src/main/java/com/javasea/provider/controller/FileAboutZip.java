package com.javasea.provider.controller;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @Author hhl
 * @Date 2020/7/24 0024 18:29
 * @Version 1.0
 */
public class FileAboutZip {
    public static void main(String[] args) {
        try {
            FileAboutZip.unCompress("F:\\project\\镇雄以勒项目2#清单.zip", "F:\\project\\zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 解压zip压缩文件
     * @param needFilePath 需要解压的文件地址
     * @param savePath 解压后文件保存地址
     * @throws Exception
     */
    public static void unCompress(String needFilePath,String savePath) throws Exception {
        //  获取当前需要解压的文件
        File srcFile = new File(needFilePath);
        if (!srcFile.exists()) {
            throw new Exception(srcFile.getPath() + "所指文件不存在");
        }
        // 插件保存的目录
        File pathFile = new File(savePath);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        // 开始解压
        //构建解压输入流
        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(srcFile));
        ZipEntry entry = null;
        File file = null;
        while ((entry = zipInput.getNextEntry()) != null) {
            if (!entry.isDirectory()) {
                file = new File(savePath, entry.getName());
                OutputStream out =new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(out);
                int len = -1;
                byte[] buf = new byte[1024];
                while ((len = zipInput.read(buf)) != -1) {
                    bos.write(buf, 0, len);
                }
                // 关流顺序，先打开的后关闭
                bos.close();
                out.close();
            }
        }
    }
}


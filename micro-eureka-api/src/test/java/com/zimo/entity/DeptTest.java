package com.zimo.entity;

import org.junit.Test;
import java.io.*;

/**
 * Created by Zimo on 2022/3/5.
 */
public class DeptTest {

    @Test
    public void testDept() throws IOException {
        File file = new File("out.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = null;
            try {
                objectOutputStream= new ObjectOutputStream(fileOutputStream);
                Dept dept = new Dept(0, "董事会", "000");
                System.out.println(dept);
                objectOutputStream.writeObject(dept);
                objectOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    System.out.println("objectOutputStream关闭失败："+ e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件："+ e.getMessage());
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println("fileOutputStream关闭失败" + e.getMessage());
            }
        }


        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
                try {
                    Dept dept = ((Dept) objectInputStream.readObject());
                    System.out.println(dept);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    System.out.println("objectInputStream关闭失败" + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件" + e.getMessage());
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                System.out.println("fileInputStream关闭失败" + e.getMessage());
            }
        }
    }

}
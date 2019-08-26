package huffmancode;

import java.io.*;
import java.util.Map;

public class HuffmanZipFile {
    public static void main(String[] args) {
        // 1. 测试压缩文件
        String srcFile = "F:\\MyProject\\DataStructure\\data\\src.bmp";
        String dstFile = "F:\\MyProject\\DataStructure\\data\\src.zip";

        zipFile(srcFile, dstFile);
        System.out.println("压缩文件ok~~");


        // 2. 测试解压文件
        String zipFile = "F:\\MyProject\\DataStructure\\data\\src.zip";
        dstFile = "F:\\MyProject\\DataStructure\\data\\src2.bmp";
        unZipFile(zipFile, dstFile);
        System.out.println("解压成功!");
    }

    private static void zipFile(String srcFile, String dstFile) {
        //创建文件的输入流
        FileInputStream is = null;
        //创建输出流
        OutputStream os = null;
        ObjectOutputStream oos = null;
        HuffmanCode hc = new HuffmanCode();

        try {
            //创建文件的输入流
            is = new FileInputStream(srcFile);
            //创建一个和源文件大小一样的byte[]
            byte[] fileBytes = new byte[is.available()];
            //读取文件
            is.read(fileBytes);
            //直接对源文件压缩
            byte[] huffmanBytes = hc.huffmanZip(fileBytes);
            //创建文件的输出流, 存放压缩文件
            os = new FileOutputStream(dstFile);
            //创建一个和文件输出流关联的ObjectOutputStream
            oos = new ObjectOutputStream(os);
            //把 赫夫曼编码后的字节数组写入压缩文件
            oos.writeObject(huffmanBytes);
            //这里以对象流的方式写入 赫夫曼编码，是为了以后恢复源文件时使用
            //注意一定要把赫夫曼编码 写入压缩文件
            Map<Byte, String> huffmanCodes = hc.genHuffmanCodes(fileBytes);
            oos.writeObject(huffmanCodes);

            is.close();
            oos.close();
            os.close();

        } catch (Exception e) {
            //
            System.out.println(e.getMessage());
        }

    }

    private static void unZipFile(String zipFile, String dstFile) {
//定义文件输入流
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;
        HuffmanCode hc = new HuffmanCode();

        try {
            //创建文件输入流
            is = new FileInputStream(zipFile);
            //创建一个和  is关联的对象输入流
            ois = new ObjectInputStream(is);
            //读取byte数组  huffmanBytes
            byte[] huffmanBytes = (byte[]) ois.readObject();
            //读取赫夫曼编码表
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            //解码
            byte[] bytes = hc.decode(huffmanBytes, huffmanCodes);
            //将bytes 数组写入到目标文件
            os = new FileOutputStream(dstFile);
            //写数据到 dstFile 文件
            os.write(bytes);

            os.close();
            ois.close();
            is.close();
        } catch (Exception e) {
            //
            System.out.println(e.getMessage());
        }
    }
}

package huffmancode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HuffmanCodeTest {
    public static void main(String[] args) {
        //
        String content = "i like like like java do you like a java";

        // 分步测试 huffman 编码
        stepHuffmanCode(content);

        // 测试编码
        byte[] huffmanCodesBytes = huffmanZip(content);
        System.out.println("压缩后的结果是:" + Arrays.toString(huffmanCodesBytes) + " \n 长度 = " + huffmanCodesBytes.length);


        // 测试解码
        Map<Byte, String> huffmanCodes = genHuffmanCodes(content);
        byte[] destBytes = decode(huffmanCodesBytes, huffmanCodes);
        System.out.println("解码后>>>>>>>>> " + new String(destBytes));
    }

    /*
      分步测试huffman编码
     */
    private static void stepHuffmanCode(String content) {
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length); //40


        HuffmanCode hc = new HuffmanCode();
        //
        List<Node> nodes = hc.getNodes(contentBytes);
        System.out.println("nodes = " + nodes);

        //测试，创建的赫夫曼树
        System.out.println("赫夫曼树");
        Node huffmanTreeRoot = hc.createHuffmanTree(nodes);
        System.out.println("前序遍历");
        huffmanTreeRoot.preOrder();

        //测试，是否生成了对应的赫夫曼编码
        Map<Byte, String> huffmanCodes = hc.getCodes(huffmanTreeRoot);
        System.out.println(">>>>>>>>>>>>>>> 生成的赫夫曼编码表= " + huffmanCodes);


        //测试编码
        byte[] huffmanCodeBytes = hc.zip(contentBytes, huffmanCodes);
        System.out.println("编码 huffmanCodeBytes=" + Arrays.toString(huffmanCodeBytes));//17


    }

    // 集成在一个方法中
    private static byte[] huffmanZip(String content) {
        HuffmanCode hc = new HuffmanCode();
        return hc.huffmanZip(content);
    }

    private static Map<Byte, String> genHuffmanCodes(String content){
        HuffmanCode hc = new HuffmanCode();
        return hc.genHuffmanCodes(content);
    }
    private static byte[] decode(byte[] huffmanBytes, Map<Byte, String> huffmanCodes) {
        HuffmanCode hc = new HuffmanCode();
        return hc.decode(huffmanBytes, huffmanCodes);
    }
}

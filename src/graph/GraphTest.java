package graph;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

public class GraphTest {
    public static void main(String[] args) {
        // 测试图1
        String vertexs[] = {"A", "B", "C", "D", "E"};//
        int [][]edges = {{0,1},{0,2},{1,2},{1,3},{1,4}};

        test(vertexs,edges,5);
        // 深度优先：A->B->C->D->E
        // 广度优先：A->B->C->D->E


        // 测试图2
        String vertexs2[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        int [][]edges2 = {{0,1},{0,2},{1,3},{1,4},{3,7},{4,7},{2,5},{2,6},{5,6}};
        test(vertexs2,edges2,8);
        // 深度优先：[1->2->4->8->5->3->6->7]
        // 广度优先：[1->2->3->4->5->6->7->8]
    }

    private static void test(String [] vertexs,int [][]edges,int n ){
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for(String vertex: vertexs) {
            graph.insertVertex(vertex);
        }
        //添加边
        for(int[] edge:edges)
        {
            graph.insertEdge(edge[0],edge[1],1);
        }

        graph.showGraph();

        //测试dfs遍历
        System.out.println(">>>>>> 深度优先");
        graph.dfs();


        // 广度优先遍历
        System.out.println("\n>>>>>>> 广度优先");
        graph.bfs();
    }
}

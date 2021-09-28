package W02.S201250136;

/**
 * @author ljh
 * @create 2021-09-25 10:20
 */
public class SnakeMonster
{
    private Sorter sorter;
    private static SnakeMonster snakeMonster;
    //一🐍不容二精
    private SnakeMonster(){}

    public static SnakeMonster getSnakeMonster()
    {
        if(snakeMonster == null)
        {
            snakeMonster = new SnakeMonster();
        }
        return snakeMonster;
    }

    public void setSorter(Sorter sorter)
    {
        this.sorter = sorter;
    }


    /*
    我们现在的问题是如何每次排序后都保留排序动作并调用toString
    现在我们先考虑希尔排序
    可以说这个排序相当于插入排序，每一次都要移动很多位，那么我们可以将这很多次移动视为一次
    或者每个单个的移动视为一次，个人倾向第二种，但是代码实现要求第一种
    那么我们现在就是可以这样在每次插入一个数输出
    输出在这一次插入中交换的所有值
    */
    public String goLine(MyQueue myQueue)
    {
        return dealString(goNecessary(myQueue), myQueue);
    }

    public String goMatrix(MyQueue queue, int row, int column)
    {
        return dealString(goNecessary(queue), queue, row, column);
    }

    public String goNecessary(MyQueue myQueue)
    {
        MyQueue.Groove[] grooves = myQueue.getGrooves();
        int[] sortedData = new int[grooves.length];
        for (int i = 0; i < grooves.length; i++)
        {
            sortedData[i] = grooves[i].getSpirit().getId();
        }
        return this.sorter.sort(sortedData);
    }
    public String dealString(String tar, MyQueue queue)
    {
        StringBuilder result = new StringBuilder();
        String[] routes = tar.split("\n");
        String[] inter;
        for(String s:routes)
        {
            inter = s.split("->");
            queue.getSpiritById(Integer.parseInt(inter[0])).swapGroove(queue.getSpiritById(Integer.parseInt(inter[1])));
            result.append(queue.toLineString());
        }
        return result.toString();
    }
    public String dealString(String tar, MyQueue queue, int row, int column)
    {
        StringBuilder result = new StringBuilder();
        String[] routes = tar.split("\n");
        String[] inter;
        for(String s:routes)
        {
            inter = s.split("->");
            queue.getSpiritById(Integer.parseInt(inter[0])).swapGroove(queue.getSpiritById(Integer.parseInt(inter[1])));
            result.append(queue.toMatrixString(row, column));
        }
        return result.toString();
    }
}

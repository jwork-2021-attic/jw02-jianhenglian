package W02.S201250136;

/**
 * 这个算法即将数据按照不同的增量分组，每组排序，然乎缩小增量，直至增量为0
 * @author ljh
 * @create 2021-09-24 14:17
 */
public class ShellSorter implements Sorter
{
    @Override
    public String sort(int[] targetArray)
    {
        StringBuilder sb = new StringBuilder();
        int increment = targetArray.length / 2;
        while(increment > 0)
        {
            for (int i = 0; i <increment; i++)
            {
                sb.append(sort(targetArray, i, increment));
            }
            increment /= 2;
        }
        return sb.toString();
    }
    public String sort(int[] targetArray, int start, int increment)
    {
        StringBuilder result = new StringBuilder();
        int interNum;
        int preIndex;
        for (int i = start + increment; i < targetArray.length; i += increment)
        {
            interNum = targetArray[i];
            preIndex = i - increment;
            while(preIndex >= start && targetArray[preIndex] > interNum )
            {
                result.append(targetArray[preIndex] + "->" + interNum).append("\n");
                targetArray[preIndex + increment] = targetArray[preIndex];
                preIndex -= increment;
            }
            targetArray[preIndex + increment] = interNum;
        }
        return result.toString();
    }
}

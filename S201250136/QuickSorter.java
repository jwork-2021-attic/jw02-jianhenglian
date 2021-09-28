package W02.S201250136;

/**
 * @author ljh
 * @create 2021-09-24 11:47
 */
public class QuickSorter implements Sorter
{
    @Override
    public String sort(int[] targetArray)
    {
        return sort(targetArray, 0, targetArray.length - 1);
    }
    public String sort(int[] targetArray, int start, int end)
    {
        StringBuilder result = new StringBuilder();
        if(start < end)
        {
            int base = targetArray[start];
            int leftFind = start;
            int rightFind = end;
            while(leftFind < rightFind)
            {
                while(targetArray[rightFind] >= base && rightFind > leftFind)
                {
                    rightFind--;
                }
                if(rightFind > leftFind)
                {
                    result.append(targetArray[rightFind] + "->" + base).append("\n");
                    targetArray[leftFind] = targetArray[rightFind];//感觉这里有改进的可能
                }
                while(targetArray[leftFind] <= base && leftFind < rightFind )
                {
                    leftFind++;
                }
                if(rightFind > leftFind)
                {
                    result.append(targetArray[leftFind] + "->" + base).append("\n");
                    targetArray[rightFind] = targetArray[leftFind];
                }
            }
            targetArray[rightFind] = base;
            result.append(sort(targetArray, start, rightFind));
            result.append(sort(targetArray, rightFind + 1, end));
            return result.toString();
        }
        return "";
    }
}

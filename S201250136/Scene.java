package W02.S201250136;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author ljh
 * @create 2021-09-25 10:33
 */
public class Scene
{
    public static void main(String[] args) throws IOException
    {
        int numOfSpirit = 100;
        SpiritHotel spiritHotel = SpiritHotel.getSpiritHotel();
        int[] sequential = getRandomSequential(numOfSpirit);
        MyQueue myQueue = new MyQueue(numOfSpirit);
        for (int i = 0; i < numOfSpirit; i++)
        {
            myQueue.putSpirit(spiritHotel.next(), sequential[i]);
        }
        SnakeMonster snake = SnakeMonster.getSnakeMonster();
        snake.setSorter(new QuickSorter());
        String shellString = snake.goLine(myQueue);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("S201250136/result.txt"));
        writer.write(shellString);
        writer.flush();
        writer.close();
    }
    public static int[] getRandomSequential(int n)
    {
        Random rand = new Random((int)(Math.random() * 100));
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
        {
            result[i] = i ;
        }
        for (int i = 1; i < n; i++)
        {
            swap(result, i, rand.nextInt(i));
        }
        return result;
    }
    public static void swap(int[] tar, int i, int j)
    {
        tar[i] += tar[j];
        tar[j] = tar[i] - tar[j];
        tar[i] = tar[i] - tar[j];
    }

}

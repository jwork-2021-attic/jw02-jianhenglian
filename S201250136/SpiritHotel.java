package W02.S201250136;

import java.util.Random;

/**
 * 稍加思考后我们决定给每个小妖怪一个独特的颜色，并通过颜色来识别这些独特的妖怪
 * 由于只凭相加判断还是会有很多出错的可能，因此我们决定给三种颜色不同的权重来减小出错可能
 * @author ljh
 * @create 2021-09-25 10:07
 */
public class SpiritHotel implements Factory<Spirit>
{
    private static Random rand = new Random(47);
    private static int id = -1;
    private static SpiritHotel spiritHotel;
    private static int[] redColors;
    static
    {
        redColors = Scene.getRandomSequential(256);
    }

    private SpiritHotel(){};

    public static SpiritHotel getSpiritHotel()
    {
        if(spiritHotel == null)
        {
            spiritHotel = new SpiritHotel();
        }
        return spiritHotel;
    }

    @Override
    public Spirit next()
    {
        id++;
        return new Spirit(redColors[id]);
    }
}

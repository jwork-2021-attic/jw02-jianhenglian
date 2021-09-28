package W02.S201250136;

/**
 * @author ljh
 * @create 2021-09-25 9:53
 */
public class Spirit
{
    private int red;
    private int green;
    private int blue;
    private int id;

    private MyQueue.Groove myGroove;

    public Spirit(int red)
    {
        this.green = red;
        if(red < 80)
        {
            this.red = 255 - red;
            this.blue = 0;
        }
        else if(red < 180)
        {
            this.red = 0;
            this.blue = red;
        }
        else
        {
            this.red = red;
            this.blue = 255 - red;
        }
        id = this.green;
    }

    public int getId()
    {
        return id;
    }

    public void swapGroove(Spirit another)
    {
        MyQueue.Groove inter = this.myGroove;
        another.getMyGroove().setSpirit(this);
        inter.setSpirit(another);
    }

    public MyQueue.Groove getMyGroove()
    {
        return myGroove;
    }

    public void setMyGroove(MyQueue.Groove myGroove)
    {
        this.myGroove = myGroove;
    }

    @Override
    public String toString()
    {
        return "\033[48;2;" + this.red + ";" + this.green + ";" + this.blue + ";38;2;0;0;0m    " + "  \033[0m";
    }
}

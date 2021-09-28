package W02.S201250136;

/**
 * 每个队列有一定数量的凹槽
 * 每个凹槽可以放进去一个小精灵
 * @author ljh
 * @create 2021-09-25 9:53
 */
public class MyQueue
{
    private Groove[] grooves;

    public Groove[] getGrooves()
    {
        return grooves;
    }

    public Spirit getSpiritById(int id)
    {
        for(Groove groove:grooves)
        {
            if(groove.getSpirit().getId() == id) return groove.getSpirit();
        }
        return null;
    }
    public MyQueue(int numOfGroove)
    {
        grooves = new Groove[numOfGroove];
    }

    public void putSpirit(Spirit prettySpirit, int position)
    {
        if(grooves[position] == null) grooves[position] = new Groove();
        grooves[position].setSpirit(prettySpirit);
    }
    class Groove
    {
        private Spirit spirit;

        public Spirit getSpirit()
        {
            return spirit;
        }

        public void setSpirit(Spirit spirit)
        {
            this.spirit = spirit;
            spirit.setMyGroove(this);
        }

        @Override
        public String toString()
        {
            return spirit.toString();
        }
    }

    public String toMatrixString(int row, int column)
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                result.append(grooves[i * row + j].getSpirit().toString());
            }
            result.append("\n");
        }
        result.append("\n[frame]\n");
        return result.toString();
    }
    public String toLineString()
    {
        StringBuilder result = new StringBuilder();
        for(Groove groove:grooves)
        {
            result.append(groove.getSpirit().toString());
        }
        result.append("\n[frame]\n");
        return result.toString();
    }
}

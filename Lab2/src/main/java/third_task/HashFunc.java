package third_task;

public class HashFunc {

    public int hashCodeForHashFuncWithKnutConst(int element){
        final double constOfKnut = 0.6180339887;
        final int hashConst = 25;
        return hashConst*((int)(constOfKnut*element)%1);
    }
}

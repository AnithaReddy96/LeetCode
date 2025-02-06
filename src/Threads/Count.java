package Threads;

public class Count {
    int num=0;
    public synchronized int increment(){
        System.out.println(num);
        num++;
        return num;
    }
    public void setNum(int num){
        this.num = num;
    }
    public int getNum(){
        return num;
    }

}

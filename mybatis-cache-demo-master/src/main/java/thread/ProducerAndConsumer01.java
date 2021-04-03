package thread;

/**
 * @createTime:2021/04/02 12:07
 * @author:luofeng30850
 * @description:生产者、消费者模型
 */
public class ProducerAndConsumer01 {
    public static void main(String[] args) {

    }
}

//店员
class Clerk {
    private int product = 0;

    //进货
    public void get(){
        if(product>=1){
            System.out.println("产品已满！");
        }
    }
}
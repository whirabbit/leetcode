package daily;

/**
 * @Author wrobby
 * @Date 2021/10/1 13:23
 * @Version 1.0
 */
public class A  extends B{
    @Override
    void eat() {
        super.eat();
    }
}


abstract class B{
  void eat(){

  }
}

interface  C{
    void say();
}

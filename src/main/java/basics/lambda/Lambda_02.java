package basics.lambda;

/**
 * 函数接口: 只有一个抽象方法的接口,用作Lambda表达式的类型。
 * @author : Su Long
 * @date : 2019/10/24
 */
@FunctionalInterface
public interface Lambda_02 extends LambdaFather_02{
    void actionPerformed(Lambda_01 lambda_01);
}

public class ProductOfTwoNum {
    public static int productOfTwo(int x, int y) {
        if(x < y) return productOfTwo(y, x);
        if (y == 0) return 0;
        return (x + productOfTwo(x, y - 1));
    }

    public static void main(String[] args) {
        System.out.println(productOfTwo(5, 2));
        System.out.println(productOfTwo(100, 5));
    }
}

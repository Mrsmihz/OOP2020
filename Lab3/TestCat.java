public class TestCat {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.defineCat("Mew", "White");
        c.Speak();

        c.upWeight(5);
        c.upHeight(10);
        c.Speak();

        c.upWeight(-5);
        c.upHeight(-10);
        c.Speak();
    }
}

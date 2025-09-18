package practice.java;

class BlankFinalWithConstructor
{
    // It is a blank final variable
    final int a;
    BlankFinalWithConstructor()
    {
        // If we remove this line, we get compiler error.
        a = 2;
    }

    BlankFinalWithConstructor(int x)
    {
        // If we remove this line, we get compiler error.
        this.a = x;
    }

}

class MainClass
{
    public static void main(String args[])
    {
        BlankFinalWithConstructor object = new BlankFinalWithConstructor();
        System.out.println("Value of final variable a = "+ object.a);

        BlankFinalWithConstructor object1 = new BlankFinalWithConstructor(5);
        System.out.println("Value of final variable a = "+ object1.a);

        BlankFinalWithConstructor object2 = new BlankFinalWithConstructor(10);
        System.out.println("Value of final variable a = "+ object2.a);

    }
}
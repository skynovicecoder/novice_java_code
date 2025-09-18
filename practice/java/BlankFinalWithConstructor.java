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

    static final int b;

    static
    {
        // assigning value to final variable
        b = 8;
    }

    int c = 10;

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

        System.out.println("Static Final Value variable b = "+ BlankFinalWithConstructor.b);

        // It is a local final variable
        final int a = 5;
        System.out.println("Value of a = "+ a);

        final BlankFinalWithConstructor obj = new BlankFinalWithConstructor();
        obj.c = 10;
        System.out.println("Value of c = "+ obj.c);
        // You can't re-assign it. it will throw compilation error
        //obj = new BlankFinalWithConstructor();

        final int arr[] = {1, 2, 3, 4};
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        for(int i = 0; i < 4 ; i++ )
        {
            System.out.println(arr[i]);
        }
        // You can't re-assign it. it will throw compilation error
        // arr = new int[5];

    }
}
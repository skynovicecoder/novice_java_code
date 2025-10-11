package practice.java.atomic;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

class UserObj {
    String name;
    int age;

    UserObj(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    /*@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserObj otherUser = (UserObj) obj;
        return age == otherUser.age && Objects.equals(name, otherUser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }*/
}

public class AtomicReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        UserObj user = new UserObj("Rocky", 34);
        AtomicReference<UserObj> atomicUser = new AtomicReference<>(user);

        /*Runnable task = ()->{
            atomicUser.set(new UserObj("Sky", 35));
        };
        Thread t1 = new Thread(task);

        Thread t2 = new Thread(() -> {
            atomicUser.compareAndSet(new UserObj("Rocky", 34),
                    new UserObj("Chirkuit", 36)
            );
        });
         */
        Thread t2 = new Thread(() -> {
            atomicUser.compareAndSet(user,  //Note: expect of compareAndSet works on == not on .equals
                    new UserObj("Chirkuit", 36)
            );
        });

        //t1.start();
        t2.start();

        //t1.join();
        t2.join();

        System.out.println("Value of Object : " + atomicUser);

    }
}

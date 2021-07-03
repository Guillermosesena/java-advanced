package lambda;

public class Lambda {
    public static void main(String[] args) {
        OnOneListener oneListener = new OnOneListener() {
            @Override
            public void onOne(String message) {
                System.out.println("One" + message);
            }
        };

        OnOneListener oneListener2 = (String message) -> {
            System.out.println("One" + message);
        };

        oneListener.onOne("Sin lambda :(");
        oneListener2.onOne("Con lambda :)");

        //Exercise 36/40
        Clickable clickable = ()->{};

    }
}

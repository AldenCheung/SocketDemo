package main;

import java.io.IOException;

/**
 * Created by alden on 2017/12/3.
 */
public class Test {
    public static void main(String[] args){

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SocketService.main(new String[]{});
            }
        };


        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    SocketClient.main(new String[]{});
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable1);

        thread.start();
        thread1.start();
    }
}

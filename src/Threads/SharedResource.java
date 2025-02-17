package Threads;

public class SharedResource {
    String message ;
    boolean isEmpty = true;

    public synchronized void writeMessage(String message){
        // write only when the string is empty
        if(!isEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.message = message;
        System.out.println("Write "+this.message);
        isEmpty = false;
        notify();

    }

    public     String readMessage(){
        if(isEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        isEmpty = true;
        notify();
        System.out.println("Read "+message);
        return message;
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        String[] msgs = {"Hi","hello","Bye"};
        Thread write = new Thread( () -> {
            for(String msg : msgs)
            resource.writeMessage(msg);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread read = new Thread(() ->{
            for(String msg : msgs){
                resource.readMessage();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        write.start();
        read.start();
    }
}

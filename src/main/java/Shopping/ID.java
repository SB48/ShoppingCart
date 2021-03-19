package Shopping;

import java.util.concurrent.atomic.AtomicLong;

abstract class ID {
    private int counter = 0;
    static AtomicLong idCounter = new AtomicLong();
    String uniqueID;
    String simpleID;

    public ID(){
        simpleID = createSimpleId();
        uniqueID = createId();
    }

    private String createSimpleId(){
        this.counter += 1;
        return String.valueOf(this.counter);
    }

    private static String createId(){
        return String.valueOf(idCounter.getAndIncrement());
    }



}

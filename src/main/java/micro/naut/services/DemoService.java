package micro.naut.services;

import micro.naut.dtos.Test;

import javax.inject.Singleton;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Karanbir Singh on 1/26/2019.
 **/
@Singleton
public class DemoService {

    public String test(){
        return "test";
    }

    public Test testObject(){
        Test test = new Test();
        test.setId(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE));
        test.setTest("RANDOM SOMETHING millis -> "+ Instant.now().toEpochMilli()+" nanos -> "+LocalDateTime.now().getNano());
        return test;
    }

}

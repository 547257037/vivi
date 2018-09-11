package com.tiantian.psqlTest;

import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author 付天
 * @Title: starv-iptv-4
 * @Package com.starv.psqlTest
 * @Description: ${TODO}
 * @date 2018/4/23 0023下午 3:07
 */
public class Streams {
    private enum Status {
        OPEN, CLOSED
    }

    ;

    @Data
    private static final class Task {
        private final Status status;
        private final Integer points;
    }

     Collection<Task> tasks = Arrays.asList(
            new Task(Status.OPEN, 5),
            new Task(Status.OPEN, 13),
            new Task(Status.CLOSED, 8)
    );
  //  Collection<Task> e = (Collection<Task>) tasks
    //        .stream()
        //    .filter(eee -> {return eee.getStatus() });
//            .mapToInt(Task::getPoints)
//            .sum();

    @Test
    public void findList1() {

  //      System.out.println("Total points: " + e);
    }
}
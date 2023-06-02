package bsu.evg.m.compiler;

import bsu.evg.m.Reader;
import bsu.evg.m.State;
import bsu.evg.m.TuringMachine;

import java.util.ArrayList;

//2.17. Г={a,b}. Перенести последний символ непустого слова P в начало слова.
public class CompilerTask2 {
    public static void running() {
        String[] str = {"task2-1.txt", "task2-2.txt", "task2-3.txt"};
        ArrayList<String> list = Reader.reader(str[2]);
        TuringMachine tm = new TuringMachine(list, list.size()-2);
        System.out.println(tm);
        while (tm.getState() != State.Q0) {
            switch (tm.getState()) {
                case Q1: {
                    switch (tm.getTape().get(tm.getCurrentPosition())) {
                        case "a" -> {
                            tm.getTape().set(tm.getCurrentPosition(), "L");
                            tm.moveLeft();
                            tm.setState(State.Q2);
                        }
                        case "b" -> {
                            tm.getTape().set(tm.getCurrentPosition(), "L");
                            tm.moveLeft();
                            tm.setState(State.Q3);
                        }
                        default -> tm.setState(State.Q0);
                    }
                    break;
                }
                case Q2: {
                    if ("L".equals(tm.getTape().get(tm.getCurrentPosition()))) {
                        tm.getTape().set(tm.getCurrentPosition(), "a");
                        tm.setState(State.Q0);
                    } else {
                        tm.moveLeft();
                        tm.setState(State.Q2);
                    }
                    break;
                }
                case Q3: {
                    if ("L".equals(tm.getTape().get(tm.getCurrentPosition()))) {
                        tm.getTape().set(tm.getCurrentPosition(), "b");
                        tm.setState(State.Q0);
                    } else {
                        tm.moveLeft();
                        tm.setState(State.Q3);
                    }
                    break;
                }
            }
            System.out.println(tm);
        }
        System.out.println("\n" + tm);
    }
}

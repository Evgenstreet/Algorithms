package org.evg_min;

import java.util.*;
import java.util.stream.Collectors;

//                  Генетический алгоритм
//                      Вариант 3
//          условие: случайная популяция в +-300
//          селекция: турнирная
//          скрещивание: однородное вероятностное
//          мутация: "Каждый бит наиболее пригодных
//              потомков мутирует с
//              вероятностью p1, а каждый бит
//              наименее пригодных потомков
//              мутирует с вероятностью p2"
//          замещение: "Наименее пригодных
//              особей старой популяции заменить на
//              наиболее пригодных особей из потомков"
//
//
//          первое уравнение отказывается быть решённым!!!


public class Main {
    public static void main(String[] args) {
        //int[][] equation = {{0, 0, 1, 1, 1}, {0, 0, 1, 1, 2}, {0, 0, 0, 1, 0}, {1, 0, 1, 2, 2}, {0, 2, 1, 2, 1}};
        int[][] equation = {{0, 0, 0, 0, 1}, {0, 1, 2, 0, 1}, {1, 0, 1, 2, 1}, {1, 2, 2, 0, 2}, {0, 1, 2, 2, 0}};
        //int[][] thirdEquation = {{2, 2, 2, 0, 1}, {2, 0, 1, 2, 0}, {0, 1, 1, 1, 0}, {0, 0, 0, 1, 0}, {2, 0, 2, 2, 0}};
        new MathGenius(equation, -50).solve();
        //new MathGenius(thirdEquation, 40).solve();
    }

//      Second Array
//      Best solution: {x1=-1, x2=-2, x3=-1, x4=-3, x5=-2}
//      Iteration: 9834
//      Infelicity: 0.0

//      Second Array
//      Best solution: {x1=-2, x2=-1, x3=-1, x4=-4, x5=-1}
//      Iteration: 134392
//      Infelicity: 0.0
//      Second Array
//      Best solution: {x1=-2, x2=-1, x3=-1, x4=-4, x5=-1}
//      Iteration: 61353
//      Infelicity: 0.0

//      Second Array
//      Best solution: {x1=-2, x2=-1, x3=-1, x4=-4, x5=-1}
//      Iteration: 76497
//      Infelicity: 0.0


//      Third Array
//      Best solution: {x1=-1, x2=-1, x3=-2, x4=-12, x5=-53}
//      Iteration: 70540
//      Infelicity: 0.0

//      Third Array
//      Best solution: {x1=-1, x2=-1, x3=-2, x4=-12, x5=-53}
//      Iteration: 96877
//      Infelicity: 0.0

//      Third Array
//      Best solution: {x1=-1, x2=-1, x3=-2, x4=-8, x5=-16}
//      Iteration: 14421
//      Infelicity: 0.0
}
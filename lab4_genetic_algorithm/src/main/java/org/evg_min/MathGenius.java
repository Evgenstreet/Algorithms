package org.evg_min;

import java.util.*;
import java.util.stream.Collectors;

public class MathGenius  {
    private final int minValue = -100;
    private final int maxValue = 100;
    private final int populationCount = 10;
    private final double chanceForGoodGeneration = 0.64;
    private final double chanceForBadGeneration = 0.72;
    private int[][] powers;
    private int result;

    public MathGenius(int[][] powers, int result) {
        this.powers = powers;
        this.result = result;
    }

    public double propability(Random random){
        return random.nextDouble(1)+0;
    }

    private double Infelicity(Equation equation) {
        return Math.abs(
                Math.pow(equation.x1, powers[0][0])*Math.pow(equation.x2, powers[0][1])*Math.pow(equation.x3, powers[0][2])*Math.pow(equation.x4, powers[0][3])*Math.pow(equation.x5, powers[0][4]) + Math.pow(equation.x1, powers[1][0])*Math.pow(equation.x2, powers[1][1])*Math.pow(equation.x3, powers[1][2])*Math.pow(equation.x4, powers[1][3])*Math.pow(equation.x5, powers[1][4]) + Math.pow(equation.x1, powers[2][0])*Math.pow(equation.x2, powers[2][1])*Math.pow(equation.x3, powers[2][2])*Math.pow(equation.x4, powers[2][3])*Math.pow(equation.x5, powers[2][4]) + Math.pow(equation.x1, powers[3][0])*Math.pow(equation.x2, powers[3][1])*Math.pow(equation.x3, powers[3][2])*Math.pow(equation.x4, powers[3][3])*Math.pow(equation.x5, powers[3][4]) + Math.pow(equation.x1, powers[4][0])*Math.pow(equation.x2, powers[4][1])*Math.pow(equation.x3, powers[4][2])*Math.pow(equation.x4, powers[4][3])*Math.pow(equation.x5, powers[4][4]) - result
        );
    }

    private double fitness(Equation equation) {
        return 1/Math.abs(0.00000001 + (Infelicity(equation)));
    }

    public void solve() {
        List<Equation> population = new Equation().generatePopulation(populationCount, minValue, maxValue);
        double infelicity = fitness(population.get(0));
        Equation solution = population.get(0);
        int iteration = 0;
        while(infelicity < 1) {
            List<Equation> newPopulation = selection(new ArrayList<>(population));
            List<Equation> nextPopulation = substitution(population, newPopulation);
            double newBestSolutionError = fitness(nextPopulation.get(0));
            Equation newBestSolution = nextPopulation.get(0);
            if (newBestSolutionError > infelicity) {
                solution = newBestSolution;
                infelicity = newBestSolutionError;
            }
            population = nextPopulation;
            iteration++;
        }
        System.out.println("Best solution: " + solution.toString() + "\nIteration: " + iteration + "\nInfelicity: " + Infelicity(solution));
    }


    public ArrayList<Equation> substitution(List<Equation> oldPopulation, List<Equation> newPopulation) {
        List<Equation> substitutedPopulation = new ArrayList<>();
        List<Double> errorsOfEquations = new ArrayList<>();
        oldPopulation.addAll(newPopulation);
        for (Equation i : oldPopulation) {
            errorsOfEquations.add(fitness(i));
        }
        Collections.sort(errorsOfEquations);
        Collections.reverse(errorsOfEquations);
        for(int i = 0; i < populationCount; i++) {
            for(Equation j : oldPopulation) {
                if(fitness(j) == errorsOfEquations.get(i)) substitutedPopulation.add(j);
                if(substitutedPopulation.size() >= populationCount) break;
            }
            if(substitutedPopulation.size() >= populationCount) break;
        }
        return new ArrayList<>(substitutedPopulation);
    }
    public List<Equation> selection(ArrayList<Equation> old) {
        List<Equation> children = new ArrayList<>();
        List<Double> errorsOfEquations = new ArrayList<>();
        for (Equation i : old) {
            errorsOfEquations.add(fitness(i));
        }

        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < populationCount; i++) {
            List<Equation> tournament = new ArrayList<>();
            int tournamentSize = 3;
            for (int j = 0; j < tournamentSize; j++) {
                int randomIndex = rand.nextInt(old.size());
                tournament.add(old.get(randomIndex));
            }
            Equation winner = tournament.stream()
                    .max(Comparator.comparingDouble(this::fitness))
                    .orElseThrow(NoSuchElementException::new);
            children.add(winner);
        }
        children = crossoverBreeding((ArrayList<Equation>) children);
        children = mutation((ArrayList<Equation>) children);
        return children;
    }

    public List<Equation> crossoverBreeding(ArrayList<Equation> old) {
        List<Equation> newChildren = new ArrayList<>();
        Random rand  = new Random(System.currentTimeMillis());
        for(int i = 0; i < old.size() - 1; i+=2){
            Equation parent1 = old.get(i);
            Equation parent2 = old.get(i+1);
            for(int j = 0; j < old.size() - 1; j++)
            {
                if(propability(rand) > chanceForGoodGeneration) {
                    newChildren.add(new Equation(parent1.x1, parent1.x2, parent1.x3, parent1.x4, parent1.x5));
                    newChildren.add(new Equation(parent2.x1, parent2.x2, parent2.x3, parent2.x4, parent2.x5));
                }
                else {
                    newChildren.add(new Equation(parent2.x1, parent2.x2, parent2.x3, parent2.x4, parent2.x5));
                    newChildren.add(new Equation(parent1.x1, parent1.x2, parent1.x3, parent1.x4, parent1.x5));
                }
            }
        }
        return newChildren;
    }

    private List<Equation> mutation(ArrayList<Equation> old) {
        return old.stream().map(i -> fitness(i) > chanceForGoodGeneration ? new Equation(
                isTrue(chanceForGoodGeneration) ? i.generateGenome(minValue, maxValue): i.x1,
                isTrue(chanceForGoodGeneration) ? i.generateGenome(minValue, maxValue): i.x2,
                isTrue(chanceForGoodGeneration) ? i.generateGenome(minValue, maxValue): i.x3,
                isTrue(chanceForGoodGeneration) ? i.generateGenome(minValue, maxValue): i.x4,
                isTrue(chanceForGoodGeneration) ? i.generateGenome(minValue, maxValue): i.x5
        ):new Equation(
                isTrue(chanceForBadGeneration) ? i.generateGenome(minValue, maxValue): i.x1,
                isTrue(chanceForBadGeneration) ? i.generateGenome(minValue, maxValue): i.x2,
                isTrue(chanceForBadGeneration) ? i.generateGenome(minValue, maxValue): i.x3,
                isTrue(chanceForBadGeneration) ? i.generateGenome(minValue, maxValue): i.x4,
                isTrue(chanceForBadGeneration) ? i.generateGenome(minValue, maxValue): i.x5
        )).collect(Collectors.toList());
    }

    private boolean isTrue(double mutationValue) {
        Random rand = new Random();
        return propability(rand) < mutationValue;
    }
}

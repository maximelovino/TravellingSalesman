# Travelling Salesman

## Introduction
The travelling salesman problem asks the following question: *"Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city exactly once and returns to the origin city?"*

## How to solve the problem?
One possible way to find a solution to the Travelling Salesman Problem would be to try all permutations of the N cities and keep the smallest overall distance. While this is possible for a small number of cities, this would be highly inefficient and downright impossible for a big number of cities, as the algorithm is of order O(n!).

For this program, we are going to use an heuristic method to find a solution to the problem. The algorithm is called *Simulated Annealing*, and it consists of sweeping the range of possible solutions (all the possible permutations of cities) at first by making big jumps between the different states and then by making only small refinements in order to reach the "optimal" solution. While we have no indication that it is in fact the optimal solution, by tweaking the parameters such as the initial temperature correctly, we can be pretty sure that the solution is a good one.

The function that we're trying to minimize here is the fitness function of our problem and is defined by the total distance travelled during our trip.

## How to use the program?
At launch, choose the number of cities you want, and then click on *Launch computation* to generate a solution.

# AdventOfCode2020
My take at the Advent Of Code challenge 2020

The puzzles can be found on the official [Advent Of Code website](https://adventofcode.com/2020).

##Day 1

###Part 1

Given a list of numbers we have to find a pair whose sum equals to 2020. Once the pair found we have to return the product of the two numbers.
We're going to have to iterate over the list to find a pair meeting the conditions. I decided to start by getting rid of all values in the list above the target value to reduce the size of the array to iterate over.
I then pic the highest value in the array and proceed to find a matching value iterating the array starting from the lowest value. Until a pair is found I pick the second-highest value in the array.

###Part 2

The puzzle is the same instead this time we have to find three items adding up to 2020 and return the product of the three values. I followed the same path as for part 1, adding an extra iteration.

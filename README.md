# AdventOfCode2020
My take at the Advent Of Code challenge 2020

The puzzles can be found on the official [Advent Of Code website](https://adventofcode.com/2020).

## Day 1

### Part 1

Given a list of numbers we have to find a pair whose sum equals to 2020. Once the pair found we have to return the product of the two numbers.
We're going to have to iterate over the list to find a pair meeting the conditions. I decided to start by getting rid of all values in the list above the target value to reduce the size of the array to iterate over.
I then iterate over the array twice, forming pairs until I find a matching one.

### Part 2

The puzzle is the same instead this time we have to find three items adding up to 2020 and return the product of the three values. I followed the same path as for part 1, adding an extra iteration. This part takes less time to solve since it has less interations to do to find matching items.

## Day 2

### Part 1

We are given a list of String containing a password, a character and two decimal values. Following the pattern we can use a regular expression to extract the useful data from each line.
In part 1 we have to count the number of passwords in which a given character count is between the given boundaries.
For each element in the list we then filter the characters in the password matching the given one. If the number of occurrences is between the given boundaries, we increment the result.

### Part 2

In part 2 we are given the same data set except this time we are told that the two numbers are in fact indexes in the password at which we must find the given character. Only one of the indexes must contain the character.
Using an XOR operation we can check if each password meets the requirement or not. If so, we increment the result.  

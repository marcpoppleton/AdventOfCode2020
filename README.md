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

## Day 3

### Part 1

We are given a list of String containing a fixed set of characters, . or #.
We need to find the number of occurrences of # in a string array, given a specific line and index jump.
Each line contains a fixed number of characters. We have two parameters, right and down. 
Right give the value to increment the index, down the number of lines to jump.
If the incremented index is above the biggest index of the line, we shift the index from the start by the difference
In part one we test every line, shifting the index by 3.
    
### Part 2

In part 2 we are given the same data set. We are given a 5 combinations of right and down values. We have to return the product of the number of # found in each combination.

## Day 4

### Part 1

The data set contains potential passport looking data, written on one or more line per potential passport.
We need to find the number of moreless passport looking scan results. A given set of required keys is provided. A scan is considered valid if it contains all of the required keys.
The first step consists of collecting all data regarding one potential passport on a single line. I then break the string into tokens, first separating the pairs key:values, then extracting the keys and putting them in a collection. If the collection contains all the required keys, the dataset is considered as valid.
    
### Part 2

In part 2 we are given the same data set. This time not only must we check if the datasets contains all the required keys, but we must also check that the values follow a given set of rules.

## Day 5

### Part 1

We are given a list of 10 chars String representing seat numbers encoded in a combination of F,B,L and R. The first 7 chars encode the row, the last 3 encode the column.
We start by splitting the string in two bits, on encoding the row, the other the column. Then by walking down the BSP tree following the chars in each substring we can get in row and the column.
The plane is composed of 8 columns, so row * 8 + column will give us the seat number.
We proceed to decode each boarding pass and then return the highest value found. 
    
### Part 2

We have all the boarding passes, therefore all the occupied seats. In order to find our seat, we need to find the missing value in the suite of seat numbers. Luckily we are told that our seat is not at the very beginning or at the very end, so we know that our missing value is somewhere in the suite.
We can calculate the expected sum of the values of this arithmetic suite.
The difference between the expected sum and the actual sum is our seat id.

## Day 6

### Part 1

The input contains groups of lines corresponding to the positives answers to a set of questions.
We have to return the number of questions having at least one positive answer for each group
Knowing that an empty line means a new group, we start by concatenating the lines to build a line per group.
Then we collect the unique letters of the string and count them.
    
### Part 2

This time we have to count number of items found in ALL lines of a group.
To do so we get the unique positive responses for each person and, by intersecting the sets, form the response for a given group.


## Day 7

### Part 1

We are given a set of hare brained rules regarding bags containing other bags, recursively.
We have to parse the file to build a structure holding all the rules.
We are going to store in a hashmap objects containing themselves a hashmap of their parents and siblings.
In part 1 we are asked to count the number or root parent capable of containing our bag.
To do so we use two sets, one of bags to visit, and one of visited bags. Everytime we take a bag we add it from the visited set we add its parents to the visiting set.
We iterate on the visiting set until it's empty.    

### Part 2

Based on the same structure as part 1 we recursively count the siblings of each bag.


## Day 8

### Part 1

The input contains instructions for a program to run. It has three instructions, NOP, ACC and JMP followed by a numeric value.
We are told that the program can fall in an infinite loop and never terminate. So we must implement a security mechanism to stop the program from looping.
In part 1 we are asked to stop the program as soon as it is about to enter an infinite loop and return the value of the accumulator.

### Part 2

In part 2 we are told that the infinite loop is maybe due to an instruction error. Either a NOP switched to a JMP or the opposite.
To debug the program we have to change one, and only one, JMP to NOP or NOP to JMP and the program will execute properly.
To do, so we change one by one all the JMP instructions to NOP and run the code each time. If the program still fails to terminate properly
we proceed to change one by one all the NOP to JMP and run the code each time.
As soon as a change gets the program to terminate gracefully we return the value of the accumulator.


## Day 9

### Part 1

We are given a set of number. We want to know how many numbers are at 1 degree of seperation and how many are at 3.
We start by sorting the numbers then for each number we check if the previous one is 1 or 3 steps bellow.
Once all numbers explored, we return the product of the two sums.

### Part 2

In part 2, after having found the number not being the sum of exactly two numbers in the 25 preceding ones we have to find a set of
consecutive numbers adding up to this number. Once the set found, we have to return the sum of the lowest and higest numbers of the set


## Day 10

### Part 1

We are given a set of number. We want to know how many numbers are at 1 degree of separation and how many are at 3.
We start by sorting the numbers then for each number we check if the previous one is 1 or 3 steps bellow.
Once all numbers explored, we return the product of the two sums.

### Part 2

We have to find the number of successful paths from 0 to max value of our list of inputs.
We cannot compute all possibilities and check them one by one, but we can build a tree with the provided data.
Walking down the tree we can check if some paths are successful or not.
To avoid loosing time checking child nodes we store for each explored node the number of successful child node.
Before exploring a child node we check if we already have a value for it or not. If we don't, we explore the child and store the value.
# Homework1

Output:
4.776 seconds 5761455 279209790387276
99999787 99999821 99999827 99999839 99999847 99999931 99999941 99999959 99999971 99999989 

Summary
I used a parallizied prime sieve algorithm to solve the problem. I began by experimenting with an prime function that ran with all eight threads. I was also planning on using a counter class that I made, but was having issues synchronizing the method. Then I switched and used the inbuilt Java Atomic Integer. This helped in synchronizing the count, so that each thread would take a number and two threads would not be assigned the same number. I used that function with the prime method, this method would check if the number was prime, but it was slow. Then I tried to use a different algorithm based on the sieve of estheros. The sieve of Eratosthenes begins at two, and then squares the ith value, it then crosses all values that are a multiple of i in the list, this occurs for all values in the list. I parallized this method using an atomic counter so each thread would work dynamically and do the algorithm for each number. I did this on a boolean list which extended to the number (1e8) + 1. Then I summed up the values of all the primes in the list. In comparison to my first evaluation, the second one was much faster with a runtime of between 5 - 6 seconds.


Run
To run use the command 
javac Homework1, then on the next line java


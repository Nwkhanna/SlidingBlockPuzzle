This is the project 2 submission for Nikhil Khanna(nkhanna3@u.rochester.edu and David Tang(dtang5@u.rochester.edu).

David Tang worked on the Puzzle class, as well as effectively half of
the Validate class. Nikhil worked on the other half of the Validate
class, as well as the Interact class. Both worked on debugging the 
code. 

The way puzzle was intended to work was that it would contain all the 
methods and data needed by Validate and Interact, so that Validate
and Interact would never have to "directly" modify puzzle. The sole
exception to this thought process was the edit method. 

All that you need to do to run Interact is to run the Interact class.
Interact's main method will do the rest.

The structure of both Validate and Interact is that they introduce the program and take an input. They then both accept moves to solve the puzzle. Interact takes a difficulty, and each difficulty has a different number of solvable moves. Easy is 10, Medium is 20, hard is 30. Difficulties were specified via estimations of what each difficulty should be.

The Puzzle class has methods that are used by both classes, and was organized to ensure that both could work as simply as possible. 
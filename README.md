# ZombieHead
First project
This project was inspired by Boxhead game.
  WSAD:   Move
  F:      Fire/Use (only when moving)
  Space:  Melle attack  sdsd
  
Everything should work with the mvn command.

mvn compile
mvn package
mvn exec:java-D exec.mainClass=com.game.Bridge.Main

In InteliJ:
Click Maven(right side)
Lifecycle->compile - next - package
Then Build->Build artifacts->build

Sometimes this may happen!!!
If Exception in thread "Thread-0" java.lang.IllegalArgumentException: input == null!
It is kind of tricky.
Try:
Maven-> Plugins-> clean-> clean 
Then Build->Build artifacts->build

Now it should work. I am still looking for solution. 

# ZombieHead
First project
This project was inspired by Boxhead game.<br />
  WSAD:   Move<br />
  F:      Fire/Use only when moving <br />
  Space:  Melle attack  sdsd<br />
  
Everything should work with the mvn command.<br />

mvn compile<br />
mvn package<br />
mvn exec:java-D exec.mainClass=com.game.Bridge.Main<br />

In InteliJ:<br />
Click Maven right side<br />
Lifecycle->compile - next - package<br />
Then Build->Build artifacts->build<br />

Sometimes this may happen!!!<br />
If Exception in thread "Thread-0" java.lang.IllegalArgumentException: input == null!<br />
It is kind of tricky.<br />
Try:<br />
Maven-> Plugins-> clean-> clean <br />
Then Build->Build artifacts->build<br />

Now it should work. I am still looking for solution. <br />
 

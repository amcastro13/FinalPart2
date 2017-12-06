/**
 * 
 */
package finalExam.part2;

/**
 *
 *@author Alexis Castro
 *
 * A class that will identify a person, peron's friends, and messages.
 */


public class Person {

	private int numOfFriends;  // variable that will hold the number of friends each person has
	private int numOfMessages; // variable that will hold the number of messages each person has
	//private String personName;
	private String personName; // String that will hold the name of the person;
	private StackInterface<Person> friendList; // a stack that holds the person's friend list
	private StackInterface<String> messages; // a stack that holds the person's messages
	
	 // Create a new Person with this name.
    public Person(String name) {
        personName = name;
        friendList = new Stack<>(10);
        messages = new Stack<>(10);
        numOfFriends = 0;
        numOfMessages = 0;
        
    }

    // Make these two people become friends with each other.
    // Throw an exception if you try to meet yourself.
    // We are allowed to assume we didn't meet this person yet.
    public void meet(Person otherPerson) throws Exception{
    	if(otherPerson.personName == personName) {
    		throw new Exception("You've already met yourself, you twat");
    	}
        friendList.push(otherPerson);
        numOfFriends++;
    	
    }

    // Are these two people friends?
    // Throw an exception if you ask about knowing yourself.
    public boolean knows(Person otherPerson) throws Exception {
    	StackInterface<Person> temp = friendList;
    	
    	if(otherPerson.personName == personName) {
    		throw new Exception("This is yourself");
    	}
    	
    	for(int i = 0; i <= numOfFriends - 1; i++) {
    		if(temp.peek() != otherPerson) {
    			temp.pop();
    		if(temp.isEmpty()) {
    			return false;
    		}
    		}
    	}
		return true;
       
    }

    // Post a message to my list and the lists of all my friends
    public void post(String message) {
    	//System.out.println(message);
    	StackInterface<Person> temp = friendList;
    	Person tempPerson;
    	messages.push(message);
    	numOfMessages++;
    	for(int i = 0; i <= numOfFriends - 1; i++) {
    		tempPerson = temp.peek();
    		tempPerson.messages.push(message);
    		temp.pop();
    	}
        	
        
    	
    }

    // Print a header, then all messages this Person can read, newest first
    public void listMessages() {
      System.out.println("== The wall of " + personName + " ==");
       StackInterface<String> temp = messages;
       for(int i = 0; i <= numOfMessages - 1; i++) {
    	   System.out.println(temp.peek());
    	   System.out.print("\n");
    	   temp.pop();
       }
}
}

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
	private List<String> studentAnswer = new ArrayList<String>();
	
	//Constructor
	public Student(String studentID) {
		super.setID(studentID);
	}
	
	//Accessor and Mutator
	public List<String> getAnswer() {
		return studentAnswer;
	}
	public void setAnswer(String answer) {
		studentAnswer.add(answer);
	}
	
	//Remove Answers
	public void removeAnswer(int index) {
		studentAnswer.remove(index);
	}
	public void removeAnswer() {
		studentAnswer.clear();
	}
}

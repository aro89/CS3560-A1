import java.util.List;
import java.util.ArrayList;

public abstract class Question {
	protected String question;
	protected String questionType;
	protected List<String> candidateAnswers = new ArrayList<String>();
	protected List<String> answerKey = new ArrayList<String>();
	
	//Accessors and Mutators
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionType() {
		return questionType;
	}
	public List<String> getAnswerKey() {
		return answerKey;
	} 
	public List<String> getCandidateAnswers() {
		return candidateAnswers;
	}
	
	//Abstract Methods
	abstract void setCandidateAnswer(String choice, boolean isAnswer);
	abstract void setCandidateAnswers(List<String> choices, List<String> answers);
	abstract void displayAnswer();
	
	//Display Methods
	public void displayQuestion() {
		System.out.println(question);
	}
	public void displayCandidateAnswers() {
		for (String choice : candidateAnswers) {
			System.out.println(choice);
		}
	}
}

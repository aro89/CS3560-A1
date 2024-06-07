import java.util.List;

public class MultipleChoiceQuestion extends Question {
	//Constructor
	MultipleChoiceQuestion() {
		super();
		questionType = "multiple";
	}
		
	@Override
	void setCandidateAnswer(String choice, boolean isAnswer) {
		candidateAnswers.add(choice);
		if (isAnswer && !answerKey.contains(choice)) {
			answerKey.add(choice);
		}
	}

	@Override
	void setCandidateAnswers(List<String> choices, List<String> answers) {
		for (String val : choices) {
			candidateAnswers.add(val);
		}
		for (String val : answers) {
			answerKey.add(val);
		}
	}
	
	@Override
	public void displayAnswer() {
		for (String ans : answerKey) {
			System.out.println(ans);
		}
	}
}

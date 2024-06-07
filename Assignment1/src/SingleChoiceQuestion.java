import java.util.List;

public class SingleChoiceQuestion extends Question {
	//Constructor
	SingleChoiceQuestion() {
		super();
		questionType = "single";
	}
	
	@Override
	void setCandidateAnswer(String choice, boolean isAnswer) {
		candidateAnswers.add(choice);
		if (isAnswer && answerKey.isEmpty()) {
			answerKey.add(choice);
		}
		else if (isAnswer && !answerKey.isEmpty()) {
			throw new RuntimeException("Single choice questions may have only one correct answer.");
		}
	}

	@Override
	void setCandidateAnswers(List<String> choices, List<String> answers) {
		for (String val : choices) {
			candidateAnswers.add(val);
		}
		if (answers.size() == 1) {
			answerKey.add(answers.get(0));
		}
		else {
			throw new RuntimeException("Single choice questions may have only one correct answer.");
		}
	}
	
	@Override
	public void displayAnswer() {
		System.out.println(answerKey.get(0));
	}
}


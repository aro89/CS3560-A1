import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class IVoteService {
	private Map<String, List<String>> submissions = new Hashtable<String, List<String>>();
	private Question query;
	
	IVoteService(Question q) {
		query = q;
	}
	
	//Each ID can only map to one value
	//In case of multiple submissions, only the last submission is counted
	public void addSubmission(String userID ,List<String> answers){
		submissions.put(userID, answers);
	}
	
	public void displayPollQuestion() {
		System.out.println("This is a " + query.getQuestionType()+ " choice question.");
		query.displayQuestion();
		query.displayCandidateAnswers();
	}
	
	public void displayStatistics() {
		List<String> answer = query.answerKey;
		int correct = 0;
		int incorrect = 0;
		
		//Display the number of selections for each candidate answer
		System.out.println("SUBMISSION RESULTS:");
		for (String choice : query.candidateAnswers) {
			int count = 0;
			System.out.print(choice + " : ");
			for (List<String> temp : submissions.values()) {
				if(temp.contains(choice)) {
					count++;
				}
			}
			System.out.println(count);
		}
		
		//Count the number of students that submitted correct answers
		for (List<String> temp : submissions.values()) {
			if(temp.equals(answer)) {
				correct++;
			}
			else {
				incorrect++;
			}
		}
		
		//Display results
		System.out.println("ANSWER:");
		query.displayAnswer();
		
		//for (Map.Entry entry : submissions.entrySet()) {
		//	System.out.println("ID: " + entry.getKey() + "; Answer: " + entry.getValue());
		//}
				
		System.out.println("Number of people polled: " + submissions.size());
		System.out.println("Number of correct answers: " + correct);
		System.out.println("Number of incorrect answers: " + incorrect);
	}
}

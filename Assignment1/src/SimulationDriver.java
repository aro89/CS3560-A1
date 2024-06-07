import java.util.ArrayList;
import java.util.Random;

public class SimulationDriver {
	private static Random rand = new Random();
	
	public static void main(String[] args) {
		Question q1 = new SingleChoiceQuestion();
		Question q2 = new MultipleChoiceQuestion();
		
		q1.setQuestion("Sample Question 1?");
		q1.setCandidateAnswer("True", true);
		q1.setCandidateAnswer("False", false);
		
		q2.setQuestion("Sample Question 2?");
		q2.setCandidateAnswer("A: ", true);
		q2.setCandidateAnswer("B: ", false);
		q2.setCandidateAnswer("C: ", true);
		q2.setCandidateAnswer("D: ", false);
		
		//Number of Students between 30-70
		int numStudents = rand.nextInt(41) + 30;
		Student[] students = generateStudents(numStudents);
		
		students = generateAnswers(students, q1);
		runSimulation(students, q1);
		
		for (Student s : students) {
			s.removeAnswer();
		}
		
		students = generateAnswers(students, q2);
		runSimulation(students, q2);
		
	}
	
	public static Student[] generateStudents(int numStudents) {
		Student students[] = new Student[numStudents];
		ArrayList<Integer> studentIDs = new ArrayList<Integer>();
		
		//Generate unique Student IDs
		while (studentIDs.size() < numStudents) {
			//Student IDs in the range of 10000 to 11000
			int temp = rand.nextInt(1000) + 10001;
			if (!studentIDs.contains(temp)) {
				studentIDs.add(temp);
			}
		}
		
		for (int i = 0; i < numStudents; i++) {
			students[i] = new Student(String.valueOf(studentIDs.get(i)));
		}
		return students;
	}
	
	public static Student[] generateAnswers(Student[] students, Question q) {
		int numChoices = q.getCandidateAnswers().size();
		String tempAnswer = null;
		
		if (q.getQuestionType().equals("single")) {
			for (int i = 0; i < students.length; i++) {
				//Pick one answer among the candidate answers
				tempAnswer = q.getCandidateAnswers().get(rand.nextInt(numChoices));
				students[i].setAnswer(tempAnswer);
			}
		}
		else if (q.getQuestionType().equals("multiple")) {
			for (int i = 0; i < students.length; i++) {
				for (String choice : q.getCandidateAnswers()) {
					//50% probability of selecting each candidate answer
					if (rand.nextInt(2) == 0) {
						students[i].setAnswer(choice);
					}
				}
			}
		}
		return students;
	}
	
	public static void runSimulation(Student[] students, Question q) {
		IVoteService poll = new IVoteService(q);
		//Submit student answers
		for (int i = 0; i < students.length; i++) {
			poll.addSubmission(students[i].getID(), students[i].getAnswer());
		}
		//Display results
		poll.displayPollQuestion();
		poll.displayStatistics();
		System.out.println();
	}
}




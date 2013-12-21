import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class ReviewerAssignment 
{
    static final Map<Integer, String> STUDENTS = new HashMap<Integer, String>() {{
	    put(1, "Boanos");
	    put(2, "DeNelle");
	    put(3, "Hanko");
	    put(4, "Hanley");
	    put(5, "Hawk");
	    put(6, "Hesch, Nicholas");
	    put(7, "Hesch, Phillip");
	    put(8, "Hollis");
	    put(9, "McCurdy");
	    put(10, "McIntyre");
	    put(11, "Person");
	    put(12, "Spencer");
	    put(13, "Torrance");
	    put(14, "Wagoner");
	    put(15, "Witenske");
	}};

    public static void main(String[] args) {

	ArrayList<Integer> students = new ArrayList<Integer>();

	// populate the arraylist with the integers
	for(int i = 1; i <= 15; i++) {
	    Integer I = new Integer(i);
	    students.add(I);
	}

	// pick the ordering for the talks today
	ArrayList<Integer> studentsTodaysOrdering = (ArrayList<Integer>)students.clone();
	Collections.shuffle(studentsTodaysOrdering);
	System.out.println("Today's presentation ordering: "); // + studentsTodaysOrdering);
	System.out.println();

	for(Integer studentToday : studentsTodaysOrdering) {

	    System.out.println(STUDENTS.get(studentToday));

	}

	System.out.println();

	HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>(){{
		put(1, 0);
		put(2, 0);
		put(3, 0);
		put(4, 0);
		put(5, 0);
		put(6, 0);
		put(7, 0);
		put(8, 0);
		put(9, 0);
		put(10, 0);
		put(11, 0);
		put(12, 0);
		put(13, 0);
		put(14, 0);
		put(15, 0);
	    }};

	System.out.println("Today's review assignments: \n");

	// generate a random assignment for each of the students
	for(int i = 1; i <= 15; i++) {
	    // remove the current student from the listing
	    ArrayList<Integer> studentsClone = (ArrayList<Integer>)students.clone();
	    studentsClone.remove(new Integer(i));
	    
	    // shuffle the student clone and get the first five from the list
	    Collections.shuffle(studentsClone);
	    List<Integer> selectedReviews = studentsClone.subList(0, 5);
	    
	    System.out.print(STUDENTS.get(i) + " ");
	    //System.out.println("must review these presentations:" + selectedReviews);
	    System.out.print("must review these presentations: \n\t["); // + selectedReviews);
	    
	    for(Integer selectedReview : selectedReviews) {
		System.out.print(STUDENTS.get(selectedReview));
		int lastIndexOf = selectedReviews.lastIndexOf(selectedReview);
		if( lastIndexOf != selectedReviews.size()-1 ) {
		    System.out.print(", ");
		}
	    }	    
	    
	    System.out.println("]");

	    // iterate through all of the chosen reviews and update histogram
	    for(Integer selectedReview : selectedReviews) {
		// extract the count for this student
		//System.out.println("selected Review: " + selectedReview);
		Integer selectedStudentIndexCount = histogram.get(selectedReview);
		//System.out.println("count: " + selectedStudentIndexCount);
		int onebigger = selectedStudentIndexCount.intValue();
		onebigger++;
		histogram.put(selectedReview, new Integer(onebigger));
		//System.out.println(histogram.get(selectedReview));
	    }

	}

	// System.out.println(histogram);

	System.out.println();
	System.out.println("Today's assignment tracking: \n");

	// print out the histogram
	Set<Integer> keys = histogram.keySet();

	for(Integer key : keys) {
	    System.out.println(STUDENTS.get(key) + " will receive " + histogram.get(key) + " reviews");
	}

    }

}

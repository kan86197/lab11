package student;
import static java.lang.System.out;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Consumer<Student> action ) {
		for(Student s : students ) {
			if (filter.test(s))	action.accept( s );
		}
	}

	public static void main(String[] args) {
		
		List<Student> students = Registrar.getInstance().getStudents();
		LocalDate localDate = LocalDate.now();
		StudentApp app = new StudentApp();
		Comparator<Student> compare = (a, b) -> a.getFirstname().substring(0, 1).
				compareToIgnoreCase(b.getFirstname().substring(0, 1));
		students.sort(compare);
		Predicate<Student> filter = s -> s.getBirthdate().getMonthValue() == localDate.getMonthValue();
		Consumer<Student> consumer = s -> out.printf("%s %s will have birth day on %d %s\n", s.getFirstname(), 
				s.getLastname(), s.getBirthdate().getDayOfMonth(), s.getBirthdate().getMonth() );
		app.filterAndPrint(students, filter, consumer /* may */);
		
		
		
		
	}
}

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 
 */

/**
 * @author sankhe
 *
 */
public class StudentModel {

	List<Student> studentResultList;   // stores the model data in a List collection of type Student
	private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	private static EntityManagerFactory factory;  // JPA  
	private EntityManager manager;		      // JPA 

	private Student student;// represents the entity courselist

	// This field contains additional information about the results   
	private StudentService studentService;


	private int numcols, numrows; // number of rows and columns

	StudentModel() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		student = new Student();
		studentService = new StudentService(manager);

		// read all the records from Student SQL table
		studentResultList = studentService.readAll();

		// update the number of rows and columns in the model
		numrows = studentResultList.size();
		numcols = student.getNumberOfColumns();
	}


	// returns a count of the number of rows
	public int getRowCount() {
		return numrows;
	}

	// returns a count of the number of columns
	public int getColumnCount() {
		return numcols;
	}

	// returns the data at the given row and column number
	public Object getValueAt(int row, int col) {
		try {
			return studentResultList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// returns the name of the column

	public String getColumnName(int col) {
		try {
			return student.getColumnName(col);
		} catch (Exception err) {
			return err.toString();
		}             
	}


	// In this method, a newly inserted row in the GUI is added to the database table
	// The argument to this method is an array containing the data in the textfields of the new row.
	public void addRow(String[] array) {
		EntityTransaction userTransaction = manager.getTransaction();  
		userTransaction.begin();
		Student newRecord = studentService.addStudentEntry(Integer.parseInt((String) array[0]),(String) array[1], 
				(String) array[2], (String) array[3], (String) array[4], 
				Integer.parseInt((String) array[5]), Integer.parseInt((String) array[6]), Integer.parseInt((String) array[7]),
				Float.parseFloat(array[8]));
		userTransaction.commit();
		// set the current row to rowIndex
		studentResultList.add(newRecord);
		int row = studentResultList.size();  
		int col = 0;

		numrows++;

	}	

	public int deleteRow(String firstName, String lastName) {
		EntityTransaction userTransaction = manager.getTransaction();  
		userTransaction.begin();
		int del = studentService.deleteStudentEntry(firstName, lastName);
		userTransaction.commit();
		return del;
	}

	public Student loginPlayer(String firstName, String lastName) {
		EntityTransaction userTransaction = manager.getTransaction();  
		userTransaction.begin();
		List<Student> list = studentService.updateScoreForStudent_1(firstName, lastName);
		userTransaction.commit();
		if(list.size() != 0)
				return (list.get(0));
		return null;
	}		
	
	public int updateScore(Student s1) { 
		EntityTransaction userTransaction = manager.getTransaction();  
		//System.out.println(s1.getTotalScore()+"  "+Controller.getStudentScore());
		int var1 = s1.getStudent_id();
		int var2 = s1.getTotalScore() + Controller.getStudentScore();
		int var3 = s1.getNumber_of_times_game_played() + 1;
		float var4 = var2/var3;
        //System.out.println(var1+"  "+var2+ "  " + var3+ "  " +var4);
		userTransaction.begin();
		int updateResult = studentService.updateScoreForStudent_2(var1, var2, var3, var4);
		userTransaction.commit();
		
		return updateResult;
	}
	
	public List getMaxScore() {
		EntityTransaction userTransaction = manager.getTransaction(); 
		userTransaction.begin();
		//Student s1 = studentService.getMaxQuery();
		List<Student> s1 = studentService.getMaxQuery();
		userTransaction.commit();
		return s1;
	}
	
	public List getMinScore() {
		EntityTransaction userTransaction = manager.getTransaction(); 
		userTransaction.begin();
		//Student s1  = studentService.getMinQuery();
		List<Student> s1 = studentService.getMinQuery();
		userTransaction.commit();
		return s1;
	}

	public Student getMaxIDFromDatabase() {
		EntityTransaction userTransaction = manager.getTransaction(); 
		userTransaction.begin();
		Student s1  = studentService.getMaxIdQuery();
		userTransaction.commit();
		return s1;
	}
	
	public Double getAvgScore() {
		EntityTransaction userTransaction = manager.getTransaction(); 
		userTransaction.begin();
		Double s1  = studentService.getAvgQuery();
		userTransaction.commit();
		return s1;
	}
	
	public int studentAboveAvg(){
		EntityTransaction userTransaction = manager.getTransaction(); 
		userTransaction.begin();
		Long s1  = studentService.studentAboveAvg();
		userTransaction.commit();
		return s1.intValue();
	}
	
	public int studentBelowAvg(){
		EntityTransaction userTransaction = manager.getTransaction(); 
		userTransaction.begin();
		Long s1  = studentService.studentBelowAvg();
		userTransaction.commit();
		return s1.intValue();
	}
	
}

import javax.persistence.*;

import java.util.*;


/**
 *
 * @author sankhe
 */

public class StudentService {
	private EntityManager manager;

	public  StudentService(EntityManager manager) {
		this.manager = manager;
	}

	// method to create a new record
	public Student addStudentEntry(int student_id, String first_name, String last_name, String gender, String birthdate, int age
			, int total_score, int  number_of_times_game_played, float avg_score) {
		Student student = new Student();
		student.setStudent_id(student_id);
		student.setFirst_name(first_name);
		student.setLast_name(last_name);
		student.setGender(gender);
		student.setBirthdate(birthdate);
		student.setAge(age);
		student.setTotalScore(total_score);
		student.setNumber_of_times_game_played(number_of_times_game_played);
		student.setAvg_score(avg_score);
		manager.persist(student);
		return student;
	}

	// method to read a record
	public Student readStudentEntry(int student_id) {
		Student student = manager.find(Student.class, student_id);
		return student;   	 
	}

	// method to read all records
	public List<Student> readAll() {
		TypedQuery<Student> query = manager.createQuery("SELECT e FROM Student e", Student.class);
		List<Student> result =  query.getResultList();

		return result;   	 
	}


	// method to delete a record
	public int deleteStudentEntry(String first_name, String last_name) {
		TypedQuery<Student> query = manager.createQuery("delete from Student where first_name=:fname AND last_name=:lname", 
				Student.class);
    	query.setParameter("fname", first_name); // used named parameter fname
    	query.setParameter("lname", last_name);
    	int deleted = query.executeUpdate();
    	//System.out.println(deleted);
		return deleted;
		/*Student student = manager.find(Student.class, student_id);
		if (student != null)
			manager.remove(student); */
	}
	
	public List updateScoreForStudent_1(String first_name, String last_name) {
		TypedQuery<Student> query = manager.createQuery("select e from Student e where e.first_name=:fname AND e.last_name=:lname", 
				Student.class);
    	query.setParameter("fname", first_name); // used named parameter fname
    	query.setParameter("lname", last_name);
    	List<Student> result =  query.getResultList();
    	return result;
	}
	
	public int updateScoreForStudent_2(int student_id, int total_score, int number_of_times_game_played, float avg_score) {
		TypedQuery<Student> query = manager.createQuery("update Student e set e.total_score=:tot_score, "
				+ "e.number_of_times_game_played=:numGamesPlayed, e.avg_score=:AvgScore where e.student_id=:id", 
				Student.class);
    	query.setParameter("id", student_id); // used named parameter id
    	query.setParameter("tot_score", total_score);
    	query.setParameter("numGamesPlayed", number_of_times_game_played);
    	query.setParameter("AvgScore", avg_score);
    	int updateResult = query.executeUpdate();
    	return updateResult;
	}
	
	public List getMaxQuery() {
		TypedQuery<Student> query =  manager.createQuery("select e from Student e where "
				+ "e.avg_score=(select  max(e.avg_score) from Student e)", Student.class);
		//Student s1 = query.getSingleResult();
		List<Student> s1 =  query.getResultList();
		return s1;
	}
	
	public List getMinQuery() {
		TypedQuery<Student> query = manager.createQuery("select e from Student e where "
				+ "e.avg_score=(select  min(e.avg_score) from Student e)", Student.class);
		//Student s1 = query.getSingleResult();
		List<Student> s1 =  query.getResultList();
		return s1;
	}
	
	public Double getAvgQuery() {
		Query query = manager.createQuery("select avg(e.avg_score) from Student e ");
		Double s1 = (Double)query.getSingleResult();
		return s1;
	}
	
	public Student getMaxIdQuery() {
		TypedQuery<Student> query =  manager.createQuery("select e from Student e where "
				+ "e.student_id=(select  max(e.student_id) from Student e)", Student.class);
		Student s1 = query.getSingleResult();
		return s1;
	}
	
	public Long studentAboveAvg() {
		Double avg = getAvgQuery();
		Query query =  manager.createQuery("select count(e) from Student e where e.avg_score > :avg");
		query.setParameter("avg", avg.doubleValue());
		Long s1 = (Long)query.getSingleResult();
		return s1;
	}
	
	public Long studentBelowAvg() {
		Double avg = getAvgQuery();
		Query query =  manager.createQuery("select count(e) from Student e where e.avg_score < :avg");
		query.setParameter("avg", avg.doubleValue());
		Long s1 = (Long)query.getSingleResult();
		return s1;
	}
	
}




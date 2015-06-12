import javax.persistence.*;

import java.io.*;


/**
 *
 * @author sankhe
 */

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity(name = "Student")
public class Student implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "student_id")
	private int student_id;
	
	@Column(name = "first_name")
	private String first_name;

	@Column
	private String last_name;
	
	@Column
	private String gender;
	
	@Column
	private String birthdate;
	
	@Column
	private int age;
	
	@Column
	private int total_score;

	@Column
	private int number_of_times_game_played;
	
	@Column
	private float avg_score;

	

	/**
	 * @return the avg_score
	 */
	public float getAvg_score() {
		return avg_score;
	}

	/**
	 * @param avg_score the avg_score to set
	 */
	public void setAvg_score(float avg_score) {
		this.avg_score = avg_score;
	}

	// return number of columns in the table
	public int getNumberOfColumns() {
		return 8;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the student_id
	 */
	public int getStudent_id() {
		return student_id;
	}

	/**
	 * @param student_id the student_id to set
	 */
	/*public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}*/
	public void setStudent_id(int id) {
		this.student_id = id;
	}
	
	/**
	 * @return the score
	 */
	public int getTotalScore() {
		return total_score;
	}

	/**
	 * @param score the score to set
	 */
	public void setTotalScore(int score) {
		this.total_score = score;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the number_of_times_game_played
	 */
	public int getNumber_of_times_game_played() {
		return number_of_times_game_played;
	}

	/**
	 * @param number_of_times_game_played the number_of_times_game_played to set
	 */
	public void setNumber_of_times_game_played(int number_of_times_game_played) {
		this.number_of_times_game_played = number_of_times_game_played;
	}

	// return the data in column i
	public String getColumnData(int i) throws Exception {
		if (i == 0)
			return  Integer.toString(getStudent_id());
		else if (i == 1)
			return getFirst_name();
		else if (i == 2) 
			return getLast_name();
		else if (i == 3)
			return null;
		else if (i == 4)
			return getBirthdate();
		else if (i == 5)
			return Integer.toString(getAge());
		else if (i == 6)
			return Integer.toString(getTotalScore());
		else if (i == 7)
			return Integer.toString(getNumber_of_times_game_played());
		else if(i == 8)
			return Float.toString(getAvg_score());
		else
			throw new Exception("Error: invalid column index in student table");    
	}

	// return the name of column i
	public String getColumnName(int i) throws Exception {
		String colName = null;
		if (i == 0) 
			colName = "student_id";
		else if (i == 1)
			colName = "first_name";
		else if (i == 2)
			colName = "last_name";
		else if (i == 3)
			colName = "gender";
		else if (i == 4)
			colName = "birthdate";
		else if (i == 5)
			colName = "age";
		else if (i == 6)
			colName = "total_score";
		else if (i == 7)
			colName = "number_of_times_game_played";
		else if(i == 8)
			colName = "avg_score";
		else 
			throw new Exception("Access to invalid column number in courselist table");

		return colName;
	}

	// set data column i to value
	public void setColumnData(int i, Object value) throws Exception {
		if (i == 0) 
			student_id = Integer.parseInt((String) value);
		else if (i == 1) 
			first_name = (String) value;
		else if (i == 2) 
			last_name =  (String) value;
		else if (i == 3)
			gender = (String) value;
		else if (i == 4)
			birthdate =   (String) value;
		else if (i == 5)
			age = Integer.parseInt((String) value);
		else if( i == 6)
			total_score = Integer.parseInt((String) value);
		else if( i == 7)
			number_of_times_game_played = Integer.parseInt((String) value);
		else if (i == 8) {
			avg_score = Float.parseFloat((String) value);
		}
		else
			throw new Exception("Error: invalid column index in courselist table");    
	}

	
	

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", first_name="
				+ first_name + ", last_name=" + last_name + ", gender="
				+ gender + ", birthdate=" + birthdate + ", age=" + age
				+ ", total_score=" + total_score
				+ ", number_of_times_game_played="
				+ number_of_times_game_played + ", avg_score=" + avg_score
				+ "]";
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}



}

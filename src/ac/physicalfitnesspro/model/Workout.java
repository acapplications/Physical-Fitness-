package ac.physicalfitnesspro.model;

public class Workout {

	private int id;
    private String workout_name;
    private String number_of_days;
    private String created_at;
	
    
    public Workout() {
    	
    }
    
    public Workout(int id, String workout_name,String number_of_days, String created_at) {
    	this.id = id;
    	this.workout_name = workout_name;
    	this.number_of_days = number_of_days;
    	this.created_at = created_at;
    }

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the workout_name
	 */
	public String getWorkout_name() {
		return workout_name;
	}

	/**
	 * @param workout_name the workout_name to set
	 */
	public void setWorkout_name(String workout_name) {
		this.workout_name = workout_name;
	}

	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the number_of_days
	 */
	public String getNumber_of_days() {
		return number_of_days;
	}

	/**
	 * @param number_of_days the number_of_days to set
	 */
	public void setNumber_of_days(String number_of_days) {
		this.number_of_days = number_of_days;
	}
    
}

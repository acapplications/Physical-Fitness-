package ac.physicalfitnesspro.model;

public class WorkoutDescDayWise {

	private int id;
	private int workout_id;
	private String day;
	private String exercise_name;
	private String description;
	private int image;
	private String created_at;
	
    
    public WorkoutDescDayWise() {
    	
    }
    
    public WorkoutDescDayWise(int id, int workout_id,String day, String exercise_name, String description,int image, String created_at) {
    	this.id = id;
    	this.workout_id = workout_id;
    	this.day = day;
    	this.exercise_name=exercise_name;
    	this.description = description;
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
	 * @return the exercise_name
	 */
	public String getExercise_Name() {
		return exercise_name;
	}

	/**
	 * @param exercise_name the exercise_name to set
	 */
	public void setExercise_Name(String exercise_name) {
		this.exercise_name = exercise_name;
	}
	
	/**
	 * @return the workout_id
	 */
	public int getWorkout_id() {
		return workout_id;
	}

	/**
	 * @param workout_id the workout_id to set
	 */
	public void setWorkout_id(int workout_id) {
		this.workout_id = workout_id;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the image
	 */
	public int getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(int image) {
		this.image = image;
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
}

package model;

import java.util.Date;

public interface IVisualizable {

	/**
	 * This method captures the exact time when visualization started
	 * @param dateI It's a {@code Date} object that contains the time when the visualization started.
	 * @return Returns the captured date and time.
	 * **/
	Date startToSee(Date dateI);

	/**
	 * This method captures the exact date and time when the visualization started.
	 * @param dateI It's a {@code Date} object that contains the time when the visualization started.
	 * @param dateF It's a {@code Date} object that contains the time when the visualization finished.
	 * */
	void stopToSee(Date dateI, Date dateF);
	
}

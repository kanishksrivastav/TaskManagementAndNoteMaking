package com.epam.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
public class Notes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long notesID;

	private String notesDescription;
	
	@ManyToOne(targetEntity = Task.class)
	@JoinColumn(name="task")
	Task task;
	
	public long getNotesID() {
		return notesID;
	}
	public void setNotesID(long notesID) {
		this.notesID = notesID;
	}
	public String getNotesDescription() {
		return notesDescription;
	}
	public void setNotesDescription(String notesDescription) {
		this.notesDescription = notesDescription;
	}
	@Override
	public String toString() {
		return this.notesDescription;
	}
	public String[] toStringArray() {
		String[] arr = new String[2];
		arr[0] = this.notesID+"";
		arr[1] = this.notesDescription;
		return arr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notesDescription == null) ? 0 : notesDescription.hashCode());
		result = prime * result + (int) (notesID ^ (notesID >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notes other = (Notes) obj;
		if (notesDescription == null) {
			if (other.notesDescription != null)
				return false;
		} else if (!notesDescription.equals(other.notesDescription))
			return false;
		if (notesID != other.notesID)
			return false;
		return true;
	}
	
	
}
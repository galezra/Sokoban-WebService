package com.gal.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "SokobanSolutions")
public class SokobanSolution {
	@Id
	@Column(name="solutionId")
	private int solutionId;
	@Column(name = "solution")
	private String solution;

	public SokobanSolution(int solutionId, String solution) {
		super();
		this.solutionId = solutionId;
		this.solution = solution;
	}

	public int getSolutionId() {
		return solutionId;
	}

	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public SokobanSolution() {
	}
	
	@Override
	public String toString() {
		return "SokobanSolution [solutionId=" + solutionId + ", solution=" + solution + "]";
	}

}

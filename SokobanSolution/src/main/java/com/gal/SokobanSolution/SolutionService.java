package com.gal.SokobanSolution;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gal.db.SokobanSolution;
import com.gal.db.SolutionManager;

@Path("solutions")
public class SolutionService {
	private SolutionManager solutionManger;
	
	public SolutionService() {
		solutionManger = new SolutionManager();
	}

	@GET
	@Path("get/{solution}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSolution(@PathParam("solution")String solutionId)
	{
		return solutionManger.getSolution(solutionId);
	}
	
	/**
	 * Check if solution exist
	 * @param solution
	 * @return true if exist
	 */
	@GET
	@Path("search/{isExist}")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean findSolution(@PathParam("isExist")String solution)
	{
		return solutionManger.isSolutionExist(solution);
	}

	
	/*
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addSolution(@FormParam("solutionId") int solutionId, @FormParam("solution") String solution) {
		SokobanSolution sol = new SokobanSolution(solutionId,solution);
		solutionManger.addSolution(sol);
	}
	*/
	
	/**
	 * update the data base with the solution
	 * @param solutionId
	 * @param solution
	 * @return
	 */
	
	
	@GET
	@Path("/add/{solutionId}/{solution}")
    public Response addSolution(@PathParam("solutionId")int solutionId,@PathParam("solution") String solution) {
		System.out.println(solutionId);
		System.out.println(solution);
		SokobanSolution sol = new SokobanSolution(solutionId, solution);
		solutionManger.addSolution(sol);
      return Response.status(200).build();
    }

}

package com.gct.homecare.service;

import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.gct.homecare.dao.GoalDAO;
import com.gct.homecare.pojo.Goal;


@Path("/jsonServices")
public class GoalManagementService {

	@GET
	@Path("/getGoals/{patientID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Goal> produceJSON(@PathParam("patientID") int patientID) throws java.net.UnknownHostException {
		GoalDAO objGoalDAO = new GoalDAO();
		/*
		List<Goal> lstGoal = new ArrayList<Goal>();
		Goal objGoal = new Goal(patientID, 123,
				"Assist with getting in/out of bed");
		lstGoal.add(objGoal);
		objGoal = new Goal(patientID, 124, "Help with bathing");
		lstGoal.add(objGoal);
		objGoal = new Goal(patientID, 125, "Help with dressing");
		*/
		return objGoalDAO.findData(null, null);

	}

	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consumeJSON(Goal objGoal) {

		String output = objGoal.toString();

		return Response.status(200).entity(output).build();
	}

}

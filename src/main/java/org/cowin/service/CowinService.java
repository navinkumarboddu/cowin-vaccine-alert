package org.cowin.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.cowin.data.CalendarByPin;
import org.cowin.data.Root;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/appointment/sessions/public")
public interface CowinService {

	@GET
	@Path("/findByPin")
	@Produces(MediaType.APPLICATION_JSON)
	public Root getSessionSlotFindByPin(@QueryParam("pincode") String pincode, @QueryParam("date") String date);

	@GET
	@Path("/calendarByPin")
	@Produces(MediaType.APPLICATION_JSON)
	public CalendarByPin getSessionSlotCalendarByPin(@QueryParam("pincode") String pincode, @QueryParam("date") String date);
}

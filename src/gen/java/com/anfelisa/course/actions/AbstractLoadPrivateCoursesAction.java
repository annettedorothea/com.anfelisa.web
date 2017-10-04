package com.anfelisa.course.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.course.data.MyCourseListData;


public abstract class AbstractLoadPrivateCoursesAction extends Action<MyCourseListData> {

	public AbstractLoadPrivateCoursesAction(DBI jdbi, DBI jdbiTimeline) {
		super("com.anfelisa.course.actions.LoadPrivateCoursesAction", HttpMethod.GET, jdbi, jdbiTimeline);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	public void initActionData(String json) {
		try {
			this.actionData = mapper.readValue(json, MyCourseListData.class);
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

}

/*       S.D.G.       */

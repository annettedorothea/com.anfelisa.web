package com.anfelisa.box.actions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AuthUser;
import com.anfelisa.box.data.BoxOfCourseListData;
import com.anfelisa.box.models.BoxDao;
import com.anfelisa.box.models.CourseToBoxAdditionModel;
import com.anfelisa.box.models.CustomBoxDao;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IBoxOfCourseModel;
import com.anfelisa.box.models.ICourseToBoxAdditionModel;
import com.anfelisa.course.models.CustomCourseDao;
import com.anfelisa.course.models.IMyCourseModel;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.dropwizard.auth.Auth;

@Path("/boxes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoadBoxOfCourseListAction extends AbstractLoadBoxOfCourseListAction {

	static final Logger LOG = LoggerFactory.getLogger(LoadBoxOfCourseListAction.class);

	public LoadBoxOfCourseListAction(DBI jdbi) {
		super(jdbi);
	}

	@GET
	@Timed
	@Path("/courses")
	@PermitAll
	public Response get(@Auth AuthUser user, @NotNull @QueryParam("uuid") String uuid,
			@NotNull @QueryParam("schema") String schema, @NotNull @QueryParam("boxId") Integer boxId)
			throws JsonProcessingException {
		this.actionData = new BoxOfCourseListData(uuid, schema).withCredentialsRole(user.getRole())
				.withCredentialsUsername(user.getUsername()).withBoxId(boxId);
		return this.apply();
	}

	@Override
	protected void loadDataForGetRequest() {
		IBoxModel box = BoxDao.selectByBoxId(this.getHandle(), actionData.getBoxId(), actionData.getSchema());
		if (!box.getUsername().equals(actionData.getCredentialsUsername())) {
			throwUnauthorized();
		}
		this.actionData.setBoxName(box.getName());
		List<ICourseToBoxAdditionModel> list = new ArrayList<ICourseToBoxAdditionModel>();
		List<IMyCourseModel> myCourses = CustomCourseDao.selectMyCourses(this.databaseHandle.getHandle(),
				this.actionData.getSchema(), this.actionData.getCredentialsUsername());
		for (IMyCourseModel myCourse : myCourses) {
			IBoxOfCourseModel boxOfCourse = CustomBoxDao.selectBoxOfCourse(this.databaseHandle.getHandle(),
					this.actionData.getSchema(), myCourse.getCourseId(), this.actionData.getCredentialsUsername(),
					this.actionData.getBoxId());
			if (boxOfCourse == null) {
				ICourseToBoxAdditionModel model = new CourseToBoxAdditionModel(null, myCourse.getCourseId(), null,
						myCourse.getName());
				list.add(model);
			} else {
				ICourseToBoxAdditionModel model = new CourseToBoxAdditionModel(boxOfCourse.getBoxId(),
						myCourse.getCourseId(), boxOfCourse.getAutoAdd(), myCourse.getName());
				list.add(model);
			}
		}
		this.actionData.setCourseToBoxAdditionList(list);
	}

}

/* S.D.G. */

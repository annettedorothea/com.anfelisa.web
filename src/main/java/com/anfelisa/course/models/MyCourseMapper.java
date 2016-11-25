package com.anfelisa.course.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class MyCourseMapper implements ResultSetMapper<IMyCourseModel> {
	
	public IMyCourseModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new MyCourseModel(
			r.getInt("id"),
			r.getString("name"),
			r.getString("description"),
			r.getInt("sequence"),
			r.getBoolean("isPublic"),
			r.getString("author"), 
			r.getInt("openTests"),
			r.getInt("openTests") > 0
		);
	}
}

/*       S.D.G.       */
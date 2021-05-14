/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ReverseBoxCreationMapper implements RowMapper<IReverseBoxCreationModel> {
	
	public IReverseBoxCreationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ReverseBoxCreationModel(
			r.getString("boxId"),
			r.getString("username")
		);
	}
}



/******* S.D.G. *******/




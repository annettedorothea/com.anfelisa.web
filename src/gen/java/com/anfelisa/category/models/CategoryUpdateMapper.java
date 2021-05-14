/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CategoryUpdateMapper implements RowMapper<ICategoryUpdateModel> {
	
	public ICategoryUpdateModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryUpdateModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getString("userId")
		);
	}
}



/******* S.D.G. *******/




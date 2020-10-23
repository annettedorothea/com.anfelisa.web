/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CategoryDeleteMapper implements RowMapper<ICategoryDeleteModel> {
	
	public ICategoryDeleteModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryDeleteModel(
			r.getString("categoryId"),
			r.getObject("categoryIndex") != null ? r.getInt("categoryIndex") : null,
			r.getString("parentCategoryId"),
			r.getString("userId")
		);
	}
}



/******* S.D.G. *******/




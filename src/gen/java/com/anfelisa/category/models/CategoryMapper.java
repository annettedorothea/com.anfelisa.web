package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CategoryMapper implements RowMapper<ICategoryModel> {
	
	public ICategoryModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getString("categoryAuthor"),
			r.getObject("categoryIndex") != null ? r.getInt("categoryIndex") : null,
			r.getString("parentCategoryId"),
			r.getString("rootCategoryId"),
			r.getBoolean("dictionaryLookup"),
			r.getString("givenLanguage"),
			r.getString("wantedLanguage"),
			r.getBoolean("publicRootCategory")
		);
	}
}

/*       S.D.G.       */

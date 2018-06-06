package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CategoryItemMapper implements ResultSetMapper<ICategoryItemModel> {
	
	public ICategoryItemModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryItemModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getString("categoryAuthor"),
			r.getObject("categoryIndex") != null ? r.getInt("categoryIndex") : null,
			r.getString("parentCategoryId"),
			r.getString("rootCategoryId"),
			r.getBoolean("dictionaryLookup"),
			r.getString("givenLanguage"),
			r.getString("wantedLanguage"),
			r.getString("path"),
			r.getBoolean("empty")
		);
	}
}

/*       S.D.G.       */
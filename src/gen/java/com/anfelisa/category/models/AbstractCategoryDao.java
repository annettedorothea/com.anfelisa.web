/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.category.models;

import de.acegen.PersistenceHandle;
import org.jdbi.v3.core.statement.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("all")
public class AbstractCategoryDao {
	
	public void insert(PersistenceHandle handle, ICategoryModel categoryModel) {
		Update statement = handle.getHandle().createUpdate("INSERT INTO \"category\" (categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage) VALUES (:categoryid, :categoryname, :categoryauthor, :categoryindex, :parentcategoryid, :rootcategoryid, :dictionarylookup, :givenlanguage, :wantedlanguage)");
		statement.bind("categoryid",  categoryModel.getCategoryId() );
		statement.bind("categoryname",  categoryModel.getCategoryName() );
		statement.bind("categoryauthor",  categoryModel.getCategoryAuthor() );
		statement.bind("categoryindex",  categoryModel.getCategoryIndex() );
		statement.bind("parentcategoryid",  categoryModel.getParentCategoryId() );
		statement.bind("rootcategoryid",  categoryModel.getRootCategoryId() );
		statement.bind("dictionarylookup",  categoryModel.getDictionaryLookup() );
		statement.bind("givenlanguage",  categoryModel.getGivenLanguage() );
		statement.bind("wantedlanguage",  categoryModel.getWantedLanguage() );
		statement.execute();
	}
	
	
	public void updateByCategoryId(PersistenceHandle handle, ICategoryModel categoryModel) {
		Update statement = handle.getHandle().createUpdate("UPDATE \"category\" SET categoryid = :categoryid, categoryname = :categoryname, categoryauthor = :categoryauthor, categoryindex = :categoryindex, parentcategoryid = :parentcategoryid, rootcategoryid = :rootcategoryid, dictionarylookup = :dictionarylookup, givenlanguage = :givenlanguage, wantedlanguage = :wantedlanguage WHERE categoryid = :categoryid");
		statement.bind("categoryid",  categoryModel.getCategoryId() );
		statement.bind("categoryname",  categoryModel.getCategoryName() );
		statement.bind("categoryauthor",  categoryModel.getCategoryAuthor() );
		statement.bind("categoryindex",  categoryModel.getCategoryIndex() );
		statement.bind("parentcategoryid",  categoryModel.getParentCategoryId() );
		statement.bind("rootcategoryid",  categoryModel.getRootCategoryId() );
		statement.bind("dictionarylookup",  categoryModel.getDictionaryLookup() );
		statement.bind("givenlanguage",  categoryModel.getGivenLanguage() );
		statement.bind("wantedlanguage",  categoryModel.getWantedLanguage() );
		statement.bind("categoryid",  categoryModel.getCategoryId()  );
		statement.execute();
	}

	public void deleteByCategoryId(PersistenceHandle handle, String categoryId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM \"category\" WHERE categoryid = :categoryid");
		statement.bind("categoryid", categoryId);
		statement.execute();
	}

	public ICategoryModel selectByCategoryId(PersistenceHandle handle, String categoryId) {
		Optional<ICategoryModel> optional = handle.getHandle().createQuery("SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage FROM \"category\" WHERE categoryid = :categoryid")
			.bind("categoryid", categoryId)
			.map(new CategoryMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public ICategoryModel selectByPrimaryKey(PersistenceHandle handle, String categoryId) {
		Optional<ICategoryModel> optional = handle.getHandle().createQuery("SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage FROM \"category\" WHERE categoryid = :categoryid")
			.bind("categoryid", categoryId)
			.map(new CategoryMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	
	public int filterAndCountBy(PersistenceHandle handle, Map<String, String> filterMap) {
		String sql = "SELECT count(*) FROM \"category\"";
		if (filterMap != null) {
			int i = 0;
			for(String key : filterMap.keySet()) {
				if (i == 0) {
					sql += " WHERE " + key + " = '" + filterMap.get(key) + "'";
				} else {
					sql += " AND " + key + " = '" + filterMap.get(key) + "'";
				}
				i++;
			}
		}
		return handle.getHandle().createQuery(sql).mapTo(Integer.class).first();
	}

	public List<ICategoryModel> selectAll(PersistenceHandle handle) {
		return handle.getHandle().createQuery("SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage FROM \"category\"")
			.map(new CategoryMapper())
			.list();
	}

	public void truncate(PersistenceHandle handle) {
		Update statement = handle.getHandle().createUpdate("TRUNCATE TABLE \"category\" CASCADE");
		statement.execute();
	}

}



/******* S.D.G. *******/




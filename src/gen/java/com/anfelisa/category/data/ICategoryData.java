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




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.ICategoryModel;

@JsonDeserialize(as=CategoryData.class)
public interface ICategoryData extends ICategoryModel, IDataContainer {
	
	ICategoryData withCategoryId(String categoryId);
	
	ICategoryData withCategoryName(String categoryName);
	
	ICategoryData withCategoryAuthor(String categoryAuthor);
	
	ICategoryData withCategoryIndex(Integer categoryIndex);
	
	ICategoryData withParentCategoryId(String parentCategoryId);
	
	ICategoryData withRootCategoryId(String rootCategoryId);
	
	ICategoryData withDictionaryLookup(Boolean dictionaryLookup);
	
	ICategoryData withGivenLanguage(String givenLanguage);
	
	ICategoryData withWantedLanguage(String wantedLanguage);
	
	
}



/******* S.D.G. *******/




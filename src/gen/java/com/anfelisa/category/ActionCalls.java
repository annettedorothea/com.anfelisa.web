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




package com.anfelisa.category;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.JerseyClientBuilder;

@SuppressWarnings("unused")
public class ActionCalls {

	public static Response callCreateCategory(String uuid, String categoryName, String parentCategoryId, Boolean dictionaryLookup, String givenLanguage, String wantedLanguage, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/create", port)).request(); 
		com.anfelisa.category.data.ICategoryCreationData data = new com.anfelisa.category.data.CategoryCreationData(uuid);
		data.setCategoryName(categoryName);
		data.setParentCategoryId(parentCategoryId);
		data.setDictionaryLookup(dictionaryLookup);
		data.setGivenLanguage(givenLanguage);
		data.setWantedLanguage(wantedLanguage);
		builder.header("Authorization", authorization);
		return builder.post(Entity.json(data));
	}
	
	public static Response callUpdateCategory(String uuid, String categoryId, String categoryName, Boolean dictionaryLookup, String givenLanguage, String wantedLanguage, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/update?uuid=" + uuid, port)).request();
		com.anfelisa.category.data.ICategoryUpdateData data = new com.anfelisa.category.data.CategoryUpdateData(uuid);
		data.setCategoryId(categoryId);
		data.setCategoryName(categoryName);
		data.setDictionaryLookup(dictionaryLookup);
		data.setGivenLanguage(givenLanguage);
		data.setWantedLanguage(wantedLanguage);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callDeleteCategory(String uuid, String categoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/delete?uuid=" + uuid + "&categoryId=" + categoryId, port)).request();
		builder.header("Authorization", authorization);
		return builder.delete();
	}
	
	public static Response callGetCategoryTree(String uuid, String rootCategoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/tree?uuid=" + uuid + "&rootCategoryId=" + rootCategoryId, port)).request(); 
		builder.header("Authorization", authorization);
		return builder.get();
	}
	
	public static Response callMoveCategory(String uuid, String movedCategoryId, String targetCategoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/move?uuid=" + uuid, port)).request();
		com.anfelisa.category.data.ICategoryMoveData data = new com.anfelisa.category.data.CategoryMoveData(uuid);
		data.setMovedCategoryId(movedCategoryId);
		data.setTargetCategoryId(targetCategoryId);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	public static Response callChangeOrderCategory(String uuid, String movedCategoryId, String targetCategoryId, int port, String authorization) {
		Client client = new JerseyClientBuilder().build();
		Builder builder = client.target(String.format("http://localhost:%d/api/category/changeorder?uuid=" + uuid, port)).request();
		com.anfelisa.category.data.ICategoryChangeOrderData data = new com.anfelisa.category.data.CategoryChangeOrderData(uuid);
		data.setMovedCategoryId(movedCategoryId);
		data.setTargetCategoryId(targetCategoryId);
		builder.header("Authorization", authorization);
		return builder.put(Entity.json(data));
	}
	
	
}




/******* S.D.G. *******/




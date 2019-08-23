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




package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SimpleCardModel implements ISimpleCardModel {

	@NotNull
	private String given;
	
	@NotNull
	private String wanted;
	
	@NotNull
	private String id;
	

	public SimpleCardModel() {
	}

	public SimpleCardModel(
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("id") String id
	) {
		this.given = given;
		this.wanted = wanted;
		this.id = id;
	}

	@JsonProperty
		public String getGiven() {
			return this.given;
		}
	public void setGiven(String given) {
		this.given = given;
	}
	
	@JsonProperty
		public String getWanted() {
			return this.wanted;
		}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	
	@JsonProperty
		public String getId() {
			return this.id;
		}
	public void setId(String id) {
		this.id = id;
	}
	
	
}




/******* S.D.G. *******/



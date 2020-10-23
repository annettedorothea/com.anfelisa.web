/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class GetBoxStatisticsResponse implements IGetBoxStatisticsResponse {
	
	private java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> boxStatisticsList;
	
	public GetBoxStatisticsResponse() {
	}
	
	public GetBoxStatisticsResponse(com.anfelisa.box.models.IBoxStatisticsListModel data) {
		boxStatisticsList = data.getBoxStatisticsList();
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> getBoxStatisticsList() {
		return this.boxStatisticsList;
	}
	
}



/******* S.D.G. *******/




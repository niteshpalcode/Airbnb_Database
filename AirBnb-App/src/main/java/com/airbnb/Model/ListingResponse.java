package com.airbnb.Model;

import java.util.List;

import com.airbnb.DTO.ListingDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingResponse {
	
	private List<ListingDTO> content;
	
	private Integer pageNo;
	
	private Integer pagesize;
	
	private Integer totalPage;
	
	private boolean lastpage;
	
	private Integer totalElement;
	
	
	

}

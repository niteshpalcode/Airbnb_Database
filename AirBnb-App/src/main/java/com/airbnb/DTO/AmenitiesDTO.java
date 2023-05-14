package com.airbnb.DTO;

import java.util.List;

import javax.persistence.Column;

import com.airbnb.Model.Amenities;
import com.airbnb.Model.ListingAmenities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AmenitiesDTO {

	private Integer amenityId;
	private String amenityName;
}

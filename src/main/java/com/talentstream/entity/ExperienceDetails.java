package com.talentstream.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Embeddable
//@Entity
@Getter
@Setter
public class ExperienceDetails {
	 private String company;
	    private String position;
	    private String startDate;
	    private String endDate;
}

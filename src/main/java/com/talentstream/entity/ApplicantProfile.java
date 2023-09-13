package com.talentstream.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class ApplicantProfile {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicantid;

    @Embedded
    private BasicDetails basicDetails;

    @Embedded
    private XClassDetails xClassDetails;

    @Embedded
    private IntermediateDetails intermediateDetails;

    @Embedded
    private GraduationDetails graduationDetails;

    @ElementCollection
    private List<String> skills;

    @ElementCollection
    private List<ExperienceDetails> experienceDetails;
}

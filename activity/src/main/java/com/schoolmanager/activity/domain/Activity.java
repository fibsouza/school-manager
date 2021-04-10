package com.schoolmanager.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "activities")
public class Activity {

    @Id
    @GeneratedValue
    private String id;

    private String title;

    private String subject;

    private String classId;

    private String createdFor;

    @CreatedDate
    private Date createdAt;

    @CreatedDate
    private Date lastModified;

    private String lastModifiedFor;

    private Boolean visibility;

    private String status;

    @CreatedDate
    private Date deadline;

    private List<Question> questions;
}

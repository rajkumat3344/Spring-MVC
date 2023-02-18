package com.web.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "club")
public class Club {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long Id;
private String title;
private String photoUrl;
private String content;

@CreationTimestamp
private LocalDateTime createdOn;
@UpdateTimestamp
private LocalDateTime updatedOn;
}

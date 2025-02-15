package com.example.team5_project.entity;


import java.security.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import com.example.team5_project.baseEntity.BaseEntity;
import com.example.team5_project.dto.PostResponseDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="board_id", nullable=false)
    private Board board;

    @Column(name="post_title")
    private String postTitle;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @ColumnDefault("0")
    private Integer viewCount =0;
    
    @ColumnDefault("0")
    private Integer likeCount =0;
    
    private String imgName;
    private String imgPath;
    
//    private String createdAt;
//    private String updatedAt;
    
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
    
    public PostResponseDto toDto() {
    	return PostResponseDto.builder()
    			.postId(postId)
    			.user(user)
    			.board(board)
    			.postTitle(postTitle)
    			.description(description.replace("<br>", "\r\n"))
    			.imgName(imgName)
    			.imgPath(imgPath)
    			.build();
    }
    
    public void updateCount(boolean liked) {
    	if(liked) {
    		likeCount +=1;
    		
    	} else {
    		likeCount -=1;
    	}
    }

}
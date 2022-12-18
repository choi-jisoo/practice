package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Entity // DB가 해당 객체를 인식 가능
public class Article {

    @Id // 유일무이한 대표값을 지정
    @GeneratedValue // 자동생성하기위한 어노테이션 1, 2, 3, ...
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

}

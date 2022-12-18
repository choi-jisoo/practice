package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스팅된다
class ArticleServiceTest {

    @Autowired ArticleService articleService;

    @Test
    void index() {
        // 예상
        Article a = new Article(1L, "a", "1");
        Article b = new Article(2L, "b", "2");
//        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b));
        List<Article> expected = new ArrayList<>();
        // 실제
        List<Article> articles = articleService.index();

        // 비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Transactional
    @Test
    void create_success_타이틀과컨텐트만있는dto입력() {
        //예상
        String title = "xxxx";
        String content = "99999";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(1L, title, content);
        //실제
        Article article = articleService.create(dto);
        //비교
        assertEquals(expected.toString(), article.toString());
    }

    @Transactional
    @Test
    void create_fail__id가포함된dto입력() {
        //예상
        String title = "xxxx";
        String content = "99999";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;
        //실제
        Article article = articleService.create(dto);
        //비교
        assertEquals(expected, article);
    }
}
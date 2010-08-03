package springtdd;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class BlogDaoTest {
	@Autowired
	private BlogDao blogDao;

	@Test
	public void shouldAddAnArticleAndListArticles() {
		Article article = new Article();
		article.setTitle("titre");
		article.setContent("contenu");
		blogDao.insertArticle(article);
		Assert.assertNotNull(article.getId());
		List<Article> articles = blogDao.listArticles();
		Assert.assertNotNull(articles);
		Assert.assertEquals(1, articles.size());
		Assert.assertEquals("titre", articles.get(0).getTitle());
		Assert.assertEquals("contenu", articles.get(0).getContent());
	}

}

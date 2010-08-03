package springtdd;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.unitils.UnitilsJUnit4;
import org.unitils.mock.Mock;

public class BlogControllerTest extends UnitilsJUnit4 {
	private BlogController controller;
	
	private Mock<BlogDao> blogDao;
	
	@Before
	public void init() {
		controller = new BlogController();
		controller.setBlogDao(blogDao.getMock());
	}

	@Test
	public void shouldListArticles() {
		//lorsque la methode listArticles() du mock est appelé, 
		//elle renvoie articles
		List<Article> articles = new ArrayList<Article>();
		blogDao.returns(articles).listArticles();
		
		//appel du controller
		ModelMap mm = new ModelMap();
		String view = controller.listArticles(mm);
		
		Assert.assertNotNull(mm.get("articles"));
		Assert.assertSame(articles, mm.get("articles"));
		Assert.assertEquals("articles", view);
		//on verifie que le mock a bien été appelé par le controller
		blogDao.assertInvoked().listArticles();
	}
	
	@Test
	public void shouldSetUpArticle() {
		Article article = controller.setUpArticle();
		Assert.assertNotNull(article);
		Assert.assertNull(article.getTitle());
		Assert.assertNull(article.getContent());
	}
	
	@Test
	public void shouldPostArticle() {
		Article article = new Article();
		article.setTitle("titre");
		article.setContent("contenu");

		String view = controller.postArticle(article );
		blogDao.assertInvoked().insertArticle(article);
		Assert.assertEquals("redirect:listArticles.htm", view);
		
	}
}

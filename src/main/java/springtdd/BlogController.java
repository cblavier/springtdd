package springtdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogController {
	
	@Autowired
	private BlogDao blogDao;

	@RequestMapping(method=RequestMethod.GET,value="/listArticles.htm")	
	public String listArticles(ModelMap mm) {
		mm.put("articles", blogDao.listArticles());
		return "articles";
	}

	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	@RequestMapping(method=RequestMethod.GET,value="/addArticle.htm")
	public Article setUpArticle() {
		return new Article();
	}

	@RequestMapping(method=RequestMethod.POST,value="/addArticle.htm")
	public String postArticle(Article article) {
		blogDao.insertArticle(article);
		return "redirect:listArticles.htm";
	}

}

package springtdd;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDao extends HibernateDaoSupport {
	@Autowired
	public BlogDao(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void insertArticle(Article article) {
		getHibernateTemplate().save(article);
	}

	public List<Article> listArticles() {
		return getHibernateTemplate().find("from Article");
	}

}

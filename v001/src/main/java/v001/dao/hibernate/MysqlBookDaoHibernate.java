package v001.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import v002.dao.BookDao;
import v002.dao.DaoDefault;
import v002.model.Book;

public class MysqlBookDaoHibernate implements BookDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Book> readAll() {

		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Book where deleted <> 1").list();
	}

	@Override
	@Transactional
	public Book read(Integer k) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Book.class, k);
	}

	@Override
	@Transactional
	public void update(Book o) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(o);
	}
	

	@Override
	@Transactional
	public int markDeleted(Integer k) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Book set deleted = 1 where id = :id").setParameter("id", k);
		
		return query.executeUpdate();
	}

}

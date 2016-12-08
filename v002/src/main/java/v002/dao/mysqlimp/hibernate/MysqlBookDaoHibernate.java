package v002.dao.mysqlimp.hibernate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import v002.DAO.BookDAO;
import v002.model.Book;

public class MysqlBookDaoHibernate implements BookDAO {

    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public List<Book> readAll()  {

		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Book").list();
	}

}

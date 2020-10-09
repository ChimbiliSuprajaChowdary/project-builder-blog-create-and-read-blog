package dao;

import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements  BlogDaoInterface
{

	public void insertBlog(Blog blog) 
	{
	try {
		Connection con = ConnectionManager.getConnection();

		String sql = "INSERT INTO blog(blogId,blogName,blogDiscription,postedOn)VALUES(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);;


			st.setLong(1,blog.getBlogId());

			st.setString(2,blog.getBlogTitle());

			st.setString(3,blog.getBlogDescription());

			st.setDate(4,java.sql.Date.valueOf(blog.getPostedOn()));

			st.executeUpdate();

			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
}

	public List<Blog> selectAllBlogs()  
	{
		try {
		List<Blog> list=new ArrayList<Blog>();

		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM blog");
		while(rs.next())
		{
			

			String title = rs.getString(2);

			String description = rs.getString(3);

			Date d = rs.getDate(4);

			System.out.println(d);


			Blog blog = new Blog();
			blog.setBlogTitle(title);
			blog.setBlogTitle(description);
		    blog.setBlogDescription(description);

			LocalDate postedOn = rs.getDate("postedOn").toLocalDate();

			blog.setPostedOn(postedOn);
			list.add(blog);
		}

		return list;
	} catch (Exception e) {
		System.out.println(e);
	}
		return null;
	}	
} 
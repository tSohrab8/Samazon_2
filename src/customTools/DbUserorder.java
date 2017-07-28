package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Userorder;


public class DbUserorder {
	
	public static Userorder getUserOrder(int orderID)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		Userorder userorder = em.find(Userorder.class, orderID);
		return userorder;		
	}
	
	public static void insert(Userorder u) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(u);
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public static int getCount(){
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		return (Integer)em.createQuery("select max(u.orderid) from Userorder u").getSingleResult();
	}
//
//	public static void update(Cart cart) {
//		EntityManager em = DbUtil.getEmFactory().createEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		try {
//			trans.begin();
//			em.merge(cart);
//			trans.commit();
//		} catch (Exception e) {
//			trans.rollback();
//		} finally {
//			em.close();
//		}
//	}
//
//	public static List<Cart> listOfCarts (){
//		EntityManager em = DbUtil.getEmFactory().createEntityManager();
//		String qString = "select b from Cart b";
//		
//		List<Cart> posts = null;
//		try{
//			TypedQuery<Cart> query = em.createQuery(qString,Cart.class);
//			posts = query.getResultList();
//
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		finally{
//				em.close();
//			}
//		return posts;
//	}
//	
//	public static void delete(Cart cart) {
//		EntityManager em = DbUtil.getEmFactory().createEntityManager();
//		EntityTransaction trans = em.getTransaction();
//		try {
//			trans.begin();
//			em.remove(em.merge(cart));
//			trans.commit();
//		} catch (Exception e) {
//			System.out.println(e);
//			trans.rollback();
//		} finally {
//			em.close();
//		}
//	}
//	
//	public static List<Cart> listOfCarts(long userid)
//	{
//		EntityManager em = DbUtil.getEmFactory().createEntityManager();
//		List<Cart> usercarts = null;
//		String qString = "select b from Cart b where b.userid = :userid";
//		
//		try{
//			TypedQuery<Cart> query = em.createQuery(qString,Cart.class);
//			query.setParameter("userid", userid);
//			usercarts = query.getResultList();
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		finally{
//				em.close();
//			}
//		return usercarts;	
//	}
	
//	public static List<Product> listOfProducts(String useremail)
//	{
//		EntityManager em = DbUtil.getEmFactory().createEntityManager();
//		List<Product> userposts = null;
//		String qString = "select b from products b "
//				+ "where b.bhuser.useremail = :useremail";
//		
//		try{
//			TypedQuery<Product> query = em.createQuery(qString,Product.class);
//			query.setParameter("useremail", useremail);
//			userposts = query.getResultList();
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//		finally{
//				em.close();
//			}
//		return userposts;	
//	}
	
//	public static List<Product> searchProducts (String search)
//	{
//		EntityManager em = DbUtil.getEmFactory().createEntityManager();
//		List<Product> searchposts = null;
//		String qString = "select b from products b "
//				+ "where b.posttext like :search";
//		
//		try{
//			TypedQuery<Product> query = em.createQuery(qString,Product.class);
//			query.setParameter("search", "%" + search + "%");
//			searchposts = query.getResultList();
//		}catch (Exception e){
//			e.printStackTrace();
//		}finally{
//			em.close();
//		}return searchposts;
//	}
	
}
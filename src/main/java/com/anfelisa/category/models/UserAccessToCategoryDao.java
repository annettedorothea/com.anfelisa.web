package com.anfelisa.category.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.statement.Update;

import de.acegen.PersistenceHandle;

public class UserAccessToCategoryDao extends AbstractUserAccessToCategoryDao {
	
	public IUserAccessToCategoryModel selectByCategoryIdAndUserId(PersistenceHandle handle, String categoryId, String userId) {
		Optional<IUserAccessToCategoryModel> optional = handle.getHandle().createQuery(
				"SELECT categoryid, userid, editable FROM public.useraccesstocategory where categoryid = :categoryid and userid = :userid")
				.bind("categoryid", categoryId).bind("userid", userId).map(new UserAccessToCategoryMapper())
				.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<IUserWithAccessModel> selectByCategoryId(PersistenceHandle handle, String categoryId) {
		return handle.getHandle().createQuery(
				"SELECT a.userid, u.username, a.editable FROM public.useraccesstocategory a inner join public.user u on a.userid = u.userid where categoryid = :categoryid order by u.username")
				.bind("categoryid", categoryId).map(new UserWithAccessMapper()).list();
	}

	public List<IUserWithAccessModel> selectByCategoryIdWhereEditable(PersistenceHandle handle, String categoryId) {
		return handle.getHandle().createQuery(
				"SELECT a.userid, u.username, a.editable FROM public.useraccesstocategory a inner join public.user u on a.userid = u.userid where categoryid = :categoryid and editable = true order by u.username")
				.bind("categoryid", categoryId).map(new UserWithAccessMapper()).list();
	}
	
	public void deleteByCategoryIdAndUserId(PersistenceHandle handle, String categoryId, String userId) {
		Update statement = handle.getHandle().createUpdate(
				"DELETE FROM public.useraccesstocategory WHERE categoryid = :categoryid and userid = :userid");
		statement.bind("categoryid", categoryId);
		statement.bind("userid", userId);
		statement.execute();
	}

	public void deleteByCategoryId(PersistenceHandle handle, String categoryId) {
		Update statement = handle.getHandle().createUpdate(
				"DELETE FROM public.useraccesstocategory WHERE categoryid = :categoryid");
		statement.bind("categoryid", categoryId);
		statement.execute();
	}
	
	public IUserAccessToCategoryModel hasUserAccessTo(PersistenceHandle handle, String categoryId, String userId) {
		Optional<IUserAccessToCategoryModel> optional = handle.getHandle().createQuery("SELECT uc.categoryid, uc.userid, uc.editable "
				+ "from public.useraccesstocategory uc "
				+ "where uc.categoryid = (select c.rootcategoryid from public.category c where c.categoryid = :categoryid ) "
				+ "and uc.userid = :userid").bind("categoryid", categoryId).bind("userid", userId)
				.map(new UserAccessToCategoryMapper()).findFirst();
		return optional.isPresent() ? optional.get() : null;

	}

}

/* S.D.G. */

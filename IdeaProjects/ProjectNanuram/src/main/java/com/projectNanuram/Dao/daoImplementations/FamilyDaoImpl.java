package com.projectNanuram.Dao.daoImplementations;

import com.projectNanuram.Dao.daoInterfaces.FamilyDao;
import com.projectNanuram.entity.Address;
import com.projectNanuram.entity.Family;
import com.projectNanuram.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FamilyDaoImpl implements FamilyDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Family> getAllFamilyDetails() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Family> cq = cb.createQuery(Family.class);
        Root<Family> root = cq.from(Family.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Family getFamilyById(String familyId) {

        Session session = sessionFactory.getCurrentSession();
        Family family = session.byId(Family.class).load(familyId);
        return family;
    }

    @Override
    public int getTotalMemberCount(String familyId) {
        Session session = sessionFactory.getCurrentSession();
        var queryString = "select f.totalMembers from Family as f where f.id  = :familyId";
        Query query = session.createQuery(queryString);
        int result = (int)query.getFirstResult();
        return result;
    }

    @Override
    public List<Person> getMembersDetails(String familyId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "select p from Person p where Family.familyId= :familyId";
        Query query = session.createQuery(hql);
        List<Person> members = query.getResultList();
        return members;
    }

    @Override
    public List<Address> getFamilyAddress(String familyId) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Address ad where Family.familyId = :familyId";
        Query query = session.createQuery(hql);
        List<Address> addresses = query.getResultList();
        return addresses;
    }

    @Override
    public Family getFamilyByAddress(Address address) {

        Session session = sessionFactory.getCurrentSession();
        String hql = "select Family as f from Address where Address = :address";
        Query query = session.createQuery(hql);

        return null;
    }

    @Override
    public Family getFamilyDetails(String personId) {
        return null;
    }

    @Override
    public Person getHeadOfTheFamily(String familyId) {
        return null;
    }

    @Override
    public void saveFamily(Family family) {

    }

    @Override
    public Family updateFamilyDetails(String familyId) {
        return null;
    }

    @Override
    public void deleteFamily(String familyId) {

    }
}

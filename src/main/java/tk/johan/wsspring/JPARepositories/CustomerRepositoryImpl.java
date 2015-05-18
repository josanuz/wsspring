package tk.johan.wsspring.JPARepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.johan.wsspring.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Casa on 17/05/2015.
 */
@Repository
public class CustomerRepositoryImpl {
@PersistenceContext EntityManager em;
    @Transactional
    public Customer findByCustomerId(Long id){
        return em.find(Customer.class,id);
    }

}

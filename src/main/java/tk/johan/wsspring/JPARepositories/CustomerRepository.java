package tk.johan.wsspring.JPARepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tk.johan.wsspring.entities.Customer;

import javax.transaction.Transactional;

/**
 * Created by Casa on 17/05/2015.
 */
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //Customer findByCustomerId(Long id);
    //Customer findByCustomerId(Long Id);
}

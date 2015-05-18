package tk.johan.wsspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tk.johan.wsspring.JPARepositories.CustomerRepository;
import tk.johan.wsspring.JPARepositories.CustomerRepositoryImpl;
import tk.johan.wsspring.entities.Customer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Casa on 17/05/2015.
 */
@RestController
@RequestMapping( value = "/services/customers")
public class HelloController {
    @Autowired private CustomerRepository repo;

    @RequestMapping(path = "/{id}" , method = RequestMethod.GET)
    public Customer hi(@PathVariable("id")Integer id){
        Customer c = repo.findOne(id);;
        return c;
    }
    @RequestMapping(path = "/{id}" , method = RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public Long create(@PathVariable("id") int id, @RequestBody Customer resource ){
        Logger.getGlobal().log(Level.ALL,resource.toString());

        return 1L;
    }

}

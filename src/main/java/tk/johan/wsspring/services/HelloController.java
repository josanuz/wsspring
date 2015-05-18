package tk.johan.wsspring.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tk.johan.wsspring.entities.Customer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Casa on 17/05/2015.
 */
@RestController
@RequestMapping( value = "/services/customers")
public class HelloController {

    @RequestMapping(path = "/{id}" , method = RequestMethod.GET)
    public Customer hi(@PathVariable("id")String id){
        return new Customer(Integer.valueOf(id),id,"Johan");
    }
    @RequestMapping(path = "/{id}" , method = RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public Long create(@PathVariable("id") int id, @RequestBody Customer resource ){
        Logger.getGlobal().log(Level.ALL,resource.toString());

        return 1L;
    }

}

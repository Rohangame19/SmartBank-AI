package in.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.Repository.AccountRepo;
import in.model.Account;


@RestController
@RequestMapping("/account")
public class AccountController {
	
	  private final AccountRepo repo;

	    public AccountController(AccountRepo repo) {
	        this.repo = repo;
	    }

	    @PostMapping
	    public Account create(@RequestBody Account account) {
	    	long generated =50097+repo.count();
	    	account.setAccount_no(String.valueOf(generated));
	        return repo.save(account);
	    }

	    @GetMapping("/{id}")
	    public Account get(@PathVariable int id) {
	        return repo.findById(id).orElse(null);
	    }
	    
	    @PostMapping("/{id}/deposit")
	    public Account deposit(@PathVariable int id, @RequestParam double amount) {
	        Account account = repo.findById(id).orElse(null);

	        if (account != null) {
	            account.setBalance(account.getBalance() + amount);
	            return repo.save(account);
	        }

	        return null;
	    }

	    @PostMapping("/{id}/withdraw")
	    public Account withdraw(@PathVariable int id, @RequestParam double amount) {
	        Account account = repo.findById(id).orElse(null);

	        if (account != null && account.getBalance() >= amount) {
	            account.setBalance(account.getBalance() - amount);
	            return repo.save(account);
	        }

	        return null;
	    }
	

}

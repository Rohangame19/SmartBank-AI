package in.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.model.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

}

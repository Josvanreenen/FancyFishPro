package nl.hu.bep.example.fancyfishpro.repositories;

import nl.hu.bep.example.fancyfishpro.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<MyUser, Long> {
    public MyUser findByUsername(String username);
}

package nl.hu.bep.example.fancyfishpro;

import nl.hu.bep.example.fancyfishpro.model.Inzet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InzetRepository extends JpaRepository<Inzet, Long> {
}
